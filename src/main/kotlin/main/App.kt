package main

import util.Constants.Companion.EXCEPTION_FILE_NOT_FOUND
import util.Constants.Companion.EXCEPTION_WRONG_CONTENT_FORMAT
import util.Utils.Companion.createOutput
import util.Utils.Companion.readInputs
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess
import exception.*

private const val FILENAME_INPUT = "customers.json"

fun main() {
    try {
        readInputs().let {
            Inviter(
                inputFileName = File(FILENAME_INPUT),
                desirableDistance = it[0],
                destinationLatitude = it[1],
                destinationLongitude = it[2]
            ).let { inviter ->
                createOutput(input = inviter)
            }
        }
    } catch (inputFormatException: ContentFormatException) {
        System.err.println(EXCEPTION_WRONG_CONTENT_FORMAT + inputFormatException.message)
    } catch (fileNotFoundException: FileNotFoundException) {
        System.err.println(EXCEPTION_FILE_NOT_FOUND)
    } finally {
        exitProcess(1)
    }
}