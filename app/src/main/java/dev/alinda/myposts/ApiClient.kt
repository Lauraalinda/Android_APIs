package dev.alinda.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit =Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T{
        return retrofit.create(apiInterface)
    }
}
//code that creates a client in our android app in this case the client is
//a program not a device so this code allows us to make requests
//t makes this function be a generic function