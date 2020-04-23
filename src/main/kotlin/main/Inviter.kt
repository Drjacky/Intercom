package main

import java.io.File
import java.io.FileNotFoundException
import java.util.*
import exception.ContentFormatException
import dto.Customer
import org.json.JSONException
import org.json.JSONObject
import util.Utils.Companion.getGreatCircleDistanceByHaversine
import java.lang.Double.parseDouble
import java.lang.NumberFormatException

private const val JSON_KEY_LATITUDE = "latitude"
private const val JSON_KEY_LONGITUDE = "longitude"
private const val JSON_KEY_USER_ID = "user_id"
private const val JSON_KEY_NAME = "name"

class Inviter constructor(
    private val inputFileName: File,
    private val desirableDistance: Double,
    private val destinationLatitude: Double,
    private val destinationLongitude: Double
) {

    val inRangeCustomers: List<Customer>
        get() {
            readFile().let {
                return calculateInRangeCustomers(it)
            }
        }

    private fun readFile(): List<Customer> {
        val allCustomers = mutableListOf<Customer>()
        var scanner: Scanner? = null

        try {
            scanner = Scanner(inputFileName)

            while (scanner.hasNextLine()) {
                val line = scanner.nextLine()
                val lineJsonObject = JSONObject(line)
                val latitude = parseDouble(lineJsonObject.getString(JSON_KEY_LATITUDE))
                val longitude = parseDouble(lineJsonObject.getString(JSON_KEY_LONGITUDE))
                val userId = lineJsonObject.getInt(JSON_KEY_USER_ID)
                val name = lineJsonObject.getString(JSON_KEY_NAME)

                allCustomers.add(Customer(userId, name, latitude, longitude))
            }
        } catch (exception: Exception) {
            when (exception) {
                is JSONException, is NumberFormatException -> {
                    throw ContentFormatException(exception.message + "")
                }
                is FileNotFoundException -> throw FileNotFoundException(exception.message)
                else -> throw exception
            }
        } finally {
            scanner?.close()
        }

        return allCustomers
    }

    private fun calculateInRangeCustomers(allCustomers: List<Customer>): List<Customer> {
        val invitedCustomers = mutableListOf<Customer>()
        allCustomers.forEach { customer ->
            getGreatCircleDistanceByHaversine(
                customer.latitude,
                customer.longitude,
                destinationLatitude,
                destinationLongitude
            ).let {
                if(it <= desirableDistance)
                    invitedCustomers.add(customer) }
        }
        invitedCustomers.sort()

        return invitedCustomers
    }
}