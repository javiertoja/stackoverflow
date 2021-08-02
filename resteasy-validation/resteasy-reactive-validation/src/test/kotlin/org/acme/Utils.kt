package a.testing

import io.restassured.RestAssured
import org.eclipse.microprofile.config.ConfigProvider
import a.testing.resources.AccessTokenRepresentation

object Utils {

    fun getAccessToken(userName: String?): String? {
        return RestAssured.given()
            .param("grant_type", "password")
            .param("username", userName)
            .param("password", userName)
            .param("client_id", "quarkus-app")
            .param("client_secret","secret")
            .`when`()
            .post(ConfigProvider.getConfig().getValue("quarkus.oidc.auth-server-url",String::class.java) + "/protocol/openid-connect/token")
            .`as`(AccessTokenRepresentation::class.java).token
    }
}