package com.example.footballleague.data

data class DataStatus<out T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        fun <T> loading(): DataStatus<T> {
            return DataStatus(Status.LOADING)
        }

        fun <T> success(data: T?): DataStatus<T> {
            return DataStatus(Status.SUCCESS, data)
        }

        fun <T> error(message: String?): DataStatus<T> {
            return DataStatus(Status.FAILURE, message = message)
        }

    }

}

enum class Status {
    LOADING, SUCCESS, FAILURE
}
