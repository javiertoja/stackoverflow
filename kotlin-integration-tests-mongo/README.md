# Sample Quarkus2.0+kotlin+integration tests

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

Now with the dev services the application will detect that the mongodb dependency is present on the classpath and will download and start a instance for us if we have docker installed on our system.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Integration tests

In order to run the integration tests you are required to include the maven-fail-safe plugin

```
    <plugin>
      <artifactId>maven-failsafe-plugin</artifactId>
      <version>${failsafe-plugin.version}</version>
      <executions>
        <execution>
          <goals>
            <goal>integration-test</goal>
            <goal>verify</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
```
By this means you are able to use the @QuarkusIntegrationTests annotation which will take care of executing yout integration tests. The devServices do not run in the integration tests pahse but they do run on the unit testing phase, so in order to have a mongo instance available for the integration tests we are required to implement a class that implements the ```QuarkusTestResourceLifecycleManager``` interface. This class will be started on the first tests which contains the annotation ```@QuarkusTestResource(MockMongoDatabase::class)``` in order to indicate the dependence on the mongo resource.
This example contains some println lines to show when the mongo instance is started and when is stopped.


