package org.acme

import javax.validation.constraints.NotEmpty

data class GreetingRequest(
    @field:NotEmpty(message = "{error.message}")
    var name:String?=null
)