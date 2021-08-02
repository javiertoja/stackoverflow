package org.acme

import a.testing.Utils
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(GreetingResource::class)
class GreetingResourceTest {

    @Test
    fun testHelloEndpointWithoutUser() {
        given()
            .`when`()
            .contentType(ContentType.JSON)
            .post()
            .then()
            .statusCode(401)
    }

    @Test
    fun testHelloEndpointBadRequestLanguageGL() {
        given()
            .`when`()
            .auth()
            .oauth2(Utils.getAccessToken("alice"))
            .contentType(ContentType.JSON)
            .header("Accept-Language","gl-ES")
            .body(GreetingRequest(""))
            .post()
            .then()
            .statusCode(400)
            .body(containsString("galego"))
    }

    @Test
    fun testHelloEndpointBadRequestLanguageEN() {
        given()
            .`when`()
            .auth()
            .oauth2(Utils.getAccessToken("alice"))
            .contentType(ContentType.JSON)
            .header("Accept-Language","en")
            .body(GreetingRequest(""))
            .post()
            .then()
            .statusCode(400)
            .body(containsString("english"))
    }
}