import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import util.formatDouble

@RunWith(JUnit4::class)
class ExtensionUnitTest {

    @Test
    fun `check round method works correctly in case of not passing param`() {
        val expectedResult = 12.34
        val actual: Double = 12.34567.formatDouble()

        Assert.assertEquals(expectedResult, actual, 0.01)
    }

    @Test
    fun `check round method works correctly in case of passing param`() {
        val expectedResult = 12.345
        val actual: Double = 12.34567.formatDouble(3)

        Assert.assertEquals(expectedResult, actual, 0.01)
    }
}