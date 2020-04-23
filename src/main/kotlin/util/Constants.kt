package util

class Constants {

    companion object {
        const val EXCEPTION_WRONG_CONTENT_FORMAT = "Error reading file content:\n\t"
        const val EXCEPTION_WRONG_INPUT_FORMAT_DEFAULT_USED = "Wrong input format. Default value has been used\n"
        const val EXCEPTION_FILE_NOT_FOUND = "Please provide an existing JSON file containing the customers!"
        const val INFO_NO_CUSTOMER_INVITED = "No customer is in the given range."
        const val INFO_ENTER_DISTANCE = "Enter distance in KM. Default is "
        const val INFO_ENTER_LATITUDE = "Enter latitude. Default is "
        const val INFO_ENTER_LONGITUDE = "Enter longitude. Default is "
    }
}