import main.Inviter
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import util.Utils
import java.io.File

private const val TEST_CASES_PATH = "src/test/kotlin/jsons/"
private const val DESIRABLE_DISTANCE = 100.0
private const val DESTINATION_LATITUDE = 53.339428
private const val DESTINATION_LONGITUDE = -6.257664
private const val FILENAME_OUTPUT = "customers_within_100_km.txt"

@RunWith(JUnit4::class)
class UtilUnitTest {

    @Test
    fun `check getGreatCircleDistanceByHaversine method works correctly`() {
        val startLatitude = 41.4016252
        val startLongitude = 2.2003234
        val endLatitude = DESTINATION_LATITUDE
        val endLongitude = DESTINATION_LONGITUDE
        val expectedDistance = 1471.0
        val result = Utils.getGreatCircleDistanceByHaversine(startLatitude, startLongitude, endLatitude, endLongitude)

        Assert.assertEquals(expectedDistance, result, 22.0)
    }

    @Test
    fun `check createOutput works perfectly`() {
        Inviter(
            File(TEST_CASES_PATH + "customers.json"),
            DESIRABLE_DISTANCE,
            DESTINATION_LATITUDE,
            DESTINATION_LONGITUDE
        )

        val outputFile = File(FILENAME_OUTPUT)
        Assert.assertTrue(outputFile.exists())
    }
}