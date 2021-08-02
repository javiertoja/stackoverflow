package a.testing.resources

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AccessTokenRepresentation(
    @field:JsonProperty("access_token") var token:String?= null
) {
}