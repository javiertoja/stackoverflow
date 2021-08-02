package org.acme

import javax.annotation.security.RolesAllowed
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@RolesAllowed(value = ["user"])
class ReactiveGreetingResource {

    @POST
    fun hello(@Valid request: GreetingRequest) = "Hello RESTEasy Reactive ${request.name}"
}