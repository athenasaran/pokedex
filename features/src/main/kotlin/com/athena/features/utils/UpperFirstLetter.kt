package com.athena.features.utils

fun upperFirstLetter(value: String): String {
    return value.replaceFirstChar { it.uppercase() }
}