package util

fun Double.formatDouble(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()