package com.taher.views

import com.taher.views.executor.AppExecutors
import com.taher.views.executor.ExecutorType
import java.lang.Exception

object CodeTemplate {

    private val appExecutor = AppExecutors()

    private fun getExecutor(executorType: ExecutorType) = when(executorType) {
        ExecutorType.DISK_IO -> appExecutor.diskIO
        ExecutorType.NETWORK_IO -> appExecutor.networkIO
        ExecutorType.MAIN_THREAD -> appExecutor.mainThread
    }

    //safe call action in specific thread
    fun safeCall(executorType: ExecutorType = ExecutorType.MAIN_THREAD, action: () -> Unit, onFailed: (e: Exception) -> Unit) {

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        //EspressoIdlingResource.increment() // App is busy until further notice

        getExecutor(executorType).execute {
            try {
                action()

            } catch (e: Exception) {
                //e.printStackTrace()
                //logger.exception(e = e)
                onFailed(e)
            }

            //EspressoIdlingResource.safeDecrement() // Set app as idle.
        }
    }

    //safe call api
    fun <T> safeApiCall(apiCall: () -> T, handleApiResponse: (response: T) -> Unit, onFailed: (e: Exception) -> Unit) {

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        //EspressoIdlingResource.increment() // App is busy until further notice

        appExecutor.networkIO.execute {
            try {
                val response = apiCall()
                appExecutor.mainThread.execute {
                    handleApiResponse(response)
                }

            } catch (e: Exception) {
                //e.printStackTrace()
                //logger.exception(e = e)
                appExecutor.mainThread.execute {
                    onFailed(e)
                }
            }

            //EspressoIdlingResource.safeDecrement() // Set app as idle.
        }

    }

    //safe call action in the current thread
    fun safeCall(action: () -> Unit, onFailed: (e: Exception) -> Unit = {}) {
        try {
            action()
        } catch (e: Exception) {
            onFailed(e)
            //logger.exception(e = e)
        }
    }

}