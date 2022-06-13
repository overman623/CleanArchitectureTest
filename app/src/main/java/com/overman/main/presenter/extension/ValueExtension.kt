package com.overman.main.presenter.extension

internal fun Any?.valueDouble() : Double {
    return when (this) {
        is String? -> return try {
            val value = this as String
            if (value.isEmpty()) {
                return 0.0
            }

            value.toDouble()
        } catch (e: Exception) {
            0.0
        }
        is Int? -> return try {
            val value = this as Double
            value
        } catch (e: Exception) {
            0.0
        }
        else -> 0.0
    }
}

internal fun Any?.valueInt() : Int {
    this ?: return 0
    return when (this) {
        is String -> {
            try {
                this.toInt()
            } catch (e : Exception) {
                0
            }
        }
        is Double -> {
            this.toInt()
        }
        is Float -> {
            this.toInt()
        }
        is Int -> {
            this
        }
        else -> 0
    }
}

internal fun Any?.valueString() : String {
    this ?: return ""
    return when (this) {
        is String -> this
        is Double, is Float, is Int ->
            this.toString()
        else -> ""
    }
}

internal fun Any?.valueBoolean() : Boolean {
    this ?: return false
    return when (this) {
        is String -> this == "true" || this == "TRUE"
        is Double -> 1 <= this
        is Float -> 1f <= this
        is Int -> 1 <= this
        else -> false
    }
}