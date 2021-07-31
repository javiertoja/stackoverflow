Quarkus guide: https://quarkus.io/guides/validation

## Information

This repo contains an example with two test to check the behaviour of the hibernate validator in conjunction with resteasy in quarkus.

What I've seen so far is that either with the rest-reactive or non reactive extensions and the hibernate-validator the validation messages internationalization is not working.

By following the guide and setting the properties quarkus.locales and quarkus.default-locale I had expected that the validation messages will be generated in a locale acording to the Accept-Language header, but it seams that its only checking the quarkus.default-locale.

There are two test testBookWithoutAuthorES and testBookWithoutAuthorEN, which send the Accept-Language header and can be used to reproduce the issue. Also I've included two properties files to have some a custom message in spanish and english. I've checked that quarkus is loading correctly this properties files before checking the issue with the locale resolution in the validator.
