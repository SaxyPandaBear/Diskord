package com.github.saxypandabear.diskord.util

/**
 * Every project has some form of StringUtils. No need to pull in a large
 * project like Apache Commons just for some simple string operations
 */
object StringUtil {

    fun mkString(delimiter: String, vararg strings: String): String {
        val builder = StringBuilder()
        for (string in strings) {
            builder.append(string)
            builder.append(delimiter)
        }
        return builder.toString()
    }
}