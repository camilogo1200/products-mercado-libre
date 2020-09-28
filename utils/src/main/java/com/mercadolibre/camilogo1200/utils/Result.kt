package com.mercadolibre.camilogo1200.utils

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {


    data class Success<out T>(val data: T) : Result<T>()
    data class Failure<out T>(val throwable: Throwable) : Result<T>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Error[exception=${throwable.message}]"
            Loading -> "Loading"
        }
    }
}

val Result<out R>.isSuccessful
    get() = this is Result.Success && data != null
