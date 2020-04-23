import exception.ContentFormatException
import main.Inviter
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.*

private const val TEST_CASES_PATH = "src/test/kotlin/jsons/"
private const val DESIRABLE_DISTANCE = 100.0
private const val DESTINATION_LATITUDE = 53.339428
private const val DESTINATION_LONGITUDE = -6.257664
private const val FILENAME_OUTPUT = "customers_within_100_km.txt"

@RunWith(JUnit4::class)
class InviterUnitTest {

    @Test
    fun `check the number of in range customers by given static file must be 16`() {
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        Assert.assertEquals(16, customers.size)
    }

    @Test
    fun `check output file has been created in case of at least one in range customer`() {
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        val outputFile = File(FILENAME_OUTPUT)
        Assert.assertTrue(outputFile.exists())
    }

    @Test(expected = FileNotFoundException::class)
    @Throws(Exception::class)
    fun `wrong filename must return FileNotFoundException`() {
        Inviter(
            File("wrong_file_name.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers
    }

    @Test(expected = ContentFormatException::class)
    @Throws(Exception::class)
    fun `wrong file content must return ContentFormatException`() {
        Inviter(
            File(TEST_CASES_PATH + "customers_corrupted_file.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers
    }

    @Test
    fun `empty file with no exception and empty customer`() {
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers_empty.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        Assert.assertEquals(0, customers.size)
    }

    @Test
    fun `check when location of customer is same as destination location`() {
        val inviter = Inviter(
            File(TEST_CASES_PATH + "customers_exact_on_destination.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        )
        val customers = inviter.inRangeCustomers

        Assert.assertEquals(1, customers[0].userId)
    }

    @Test
    fun `check one of in range customer has been considered`() {
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers_in_range.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        Assert.assertEquals(4, customers[0].userId)
    }

    @Test
    fun `check out range customers must not consider for invitation`() {
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers_out_of_range.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        Assert.assertEquals(0, customers.size)
    }

    @Test
    fun `check list of in range customers are sorted by ascending order`() {
        val userIds = intArrayOf(4, 39)
        val customers = Inviter(
            File(TEST_CASES_PATH + "customers_descending_order.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        ).inRangeCustomers

        customers.forEachIndexed { i, customer ->
            Assert.assertEquals(userIds[i], customer.userId)
        }
    }
}