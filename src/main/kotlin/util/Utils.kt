package util

import main.Inviter
import util.Constants.Companion.EXCEPTION_WRONG_INPUT_FORMAT_DEFAULT_USED
import util.Constants.Companion.INFO_ENTER_DISTANCE
import util.Constants.Companion.INFO_ENTER_LATITUDE
import util.Constants.Companion.INFO_ENTER_LONGITUDE
import java.io.File
import java.lang.Math.toRadians
import kotlin.math.*

private const val DISTANCE_KM_DEFAULT = 100.0
private const val OFFICE_LATITUDE_DEFAULT = 53.339428
private const val OFFICE_LONGITUDE_DEFAULT = -6.257664
private const val FILENAME_OUTPUT = "customers_within_100_km.txt"
private const val EARTH_RADIUS_M = 6378137

class Utils {

    companion object {
        fun readInputs(): List<Double> {
            print("$INFO_ENTER_DISTANCE[$DISTANCE_KM_DEFAULT] -> ")
            val distanceInput = readDouble(DISTANCE_KM_DEFAULT)

            print("$INFO_ENTER_LATITUDE[$OFFICE_LATITUDE_DEFAULT] -> ")
            val latInput = readDouble(OFFICE_LATITUDE_DEFAULT)

            print("$INFO_ENTER_LONGITUDE[$OFFICE_LONGITUDE_DEFAULT] -> ")
            val longInput = readDouble(OFFICE_LONGITUDE_DEFAULT)

            return listOf(distanceInput, latInput, longInput)
        }

        fun <T> createOutput(input: T) {
            val myFile = File(FILENAME_OUTPUT)

            myFile.bufferedWriter().use { out ->
                var result = Constants.INFO_NO_CUSTOMER_INVITED
                when (input) {
                    is Inviter ->
                        if (!input.inRangeCustomers.isNullOrEmpty()) {
                            for (customer in input.inRangeCustomers) {
                                result = "Customer ID: ${customer.userId} - Customer Name: ${customer.name}"
                                println(result)
                                out.write("${result}\n")
                            }
                        } else {
                            println(result)
                            out.write(result)
                        }
                    else -> return
                }
            }
        }

        fun getGreatCircleDistanceByHaversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
            val latRad1 = toRadians(lat1)
            val latRad2 = toRadians(lat2)
            val dLat = toRadians(lat2 - lat1)
            val dLong = toRadians(lon2 - lon1)
            val a = sin(dLat / 2) * sin(dLat / 2) +
                    cos(latRad1) * cos(latRad2) *
                    sin(dLong / 2) * sin(dLong / 2)
            val c = 2 * atan2(sqrt(a), sqrt(1 - a))
            return (EARTH_RADIUS_M * c / 1000).formatDouble()
        }

        private fun readDouble(defaultValue: Double): Double {
            var result = defaultValue
            try {
                val line = readLine()
                result = if (!line.isNullOrBlank()) line.toDouble() else defaultValue
            } catch (numberFormatException: NumberFormatException) {
                System.err.println(EXCEPTION_WRONG_INPUT_FORMAT_DEFAULT_USED)
            }

            return result
        }
    }
}