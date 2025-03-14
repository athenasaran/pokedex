package com.athena.utils

fun upperFirstLetter(value: String): String {
    return value.replaceFirstChar { it.uppercase() }
}