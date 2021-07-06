package org.acme

import com.mongodb.client.MongoClient
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    lateinit var mongo:MongoClient

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello():String{
        println(mongo.clusterDescription)
        return "Hello RESTEasy"
    }
}