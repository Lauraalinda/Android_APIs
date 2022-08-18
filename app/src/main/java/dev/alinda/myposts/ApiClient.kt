package dev.alinda.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit =Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T{ //creating an api client and padsing an api interface
        return retrofit.create(apiInterface)
    }
}
//code that creates a client in our android app in this case the client is
//a program not a device so this code allows us to make requests
//t makes this function be a generic function

//about the interfACE .. do not type
//interface is a point of contact btn two systems
//rules ..
//for exxample a tv
//fun main(){
//
//}
//interface Television{
//    fun switchon()
//
//    fun switchoff()
//
//    fun adjustvolume(level: Int)
//
//    fun switchchannel()
//}
////create television
//class Sony:Television{ ctr i
//    override fun switchon() {

//    }
//
//    override fun switchoff() {
//        TODO("Not yet implemented")
//    }
//
//    override fun adjustvolume(level: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun switchchannel() {
//        TODO("Not yet implemented")
//    }
//    TODO STAFF
//}
//class Samsung:Television{
//    TODO STAFF
//}


