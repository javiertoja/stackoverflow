## Introduction

This repo contains two reproducers for what it seems to be two bugs reagarding a different behaviour between the quarkus resteasy extension and the reactive version.
Both projects are identical in functionality and use the following extensions resteasy, hibernate-validator, oidc and kotlin. The difference is that one uses the reactive
version of the resteasy dependency and the other don't.

## The bugs

1. The reactive version validates the body of a request annotated with the @Valid annotation before checking the security constraints specified by the RolesAllowed
annotation, in the non-reactive version the validation occurs in different order.

2. The reactive version is not using the Accept-Language header to while generating the error messages for a 400 response, it seems to use the default locale.

## The reproducers

Both reproducers have a test suite with three identical test which validate the expected responses for a request without authorization header, and with language
preferences. It is possible to see how the non-reactive are ok and the reactive version finished in error.

## Running

In order to run the projects just run ```mvn clean test```
