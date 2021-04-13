package com.cornellappdev.apollo_android_tutorial.networking

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.coroutines.toDeferred
import com.cornellappdev.LaunchRocketQuery
import com.cornellappdev.apollo_android_tutorial.Launch
import com.cornellappdev.apollo_android_tutorial.Mission
import com.cornellappdev.apollo_android_tutorial.Rocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "NetworkingUtils"

object NetworkingUtils {

    //declaring the client
    val apolloClient = ApolloClient.builder()
        .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com")
        .build()

    //example of wrapper function that calls the networking function
    suspend fun retrieveData(id: String): LaunchRocketQuery.Launch? {
        //null object to assign later
        var launchObj: LaunchRocketQuery.Launch? = null
        //this will let us run the network request in the background
        withContext(Dispatchers.IO) {

            //the await allows us to use the value of defferedResponse once it returns
            val deferredResponse = apolloClient.query(LaunchRocketQuery(id)).await()
            val response = deferredResponse.data?.launch
            launchObj = response
        }

        return launchObj
    }

}