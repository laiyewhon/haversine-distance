# heaversine-distance

There are 3 apis in total

- Gets coordinates given a UK postcode
- Updates an existing UK postcode's coordinates i.e. latitude and longitude
- Calculates the distance given 2 UK postcodes

Requirements:

| software        | version                                                                                                                                                                                     |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| java            | openjdk version "17.0.6" 2023-01-17<br>OpenJDK Runtime Environment Temurin-17.0.6+10 (build 17.0.6+10)<br>OpenJDK 64-Bit Server VM Temurin-17.0.6+10 (build 17.0.6+10, mixed mode, sharing) |
| maven (wrapper) | Apache Maven 3.8.7 (b89d5959fcde851dcb1c8946a785a163f14e1e29)                                                                                                                               |
| docker          | Docker version 20.10.23, build 7155243                                                                                                                                                      |
| docker compose  | Docker Compose version v2.15.1                                                                                                                                                              |

## Database

The `postcode` user and database are created automatically by the script in `./docker/seed.sql`

```shell
docker compose up -d
```

## Spring Application

Building the app

```shell
./mvnw clean install
```

Starting the app

Initially the startup will take up to *7-8 minutes* and seems like stuck at the console output `Migrating schema ``postcode`` to version "1.1 - Seed postcode data"` because of the inital database data seeding.

```shell
./mvnw clean install spring-boot:run
```

Swagger UI can be accessed at <http://localhost:8080/swagger-ui/index.html>

The default basic credential is `user/abc123`

All api endpoints are protected by default, therefore the header `Authorization: Basic dXNlcjphYmMxMjM=` will need to be set


```text
2023-03-16 10:28:31.425  INFO 60073 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.674s)
2023-03-16 10:28:31.449  INFO 60073 --- [           main] o.f.c.i.s.JdbcTableSchemaHistory         : Creating Schema History table `postcode`.`flyway_schema_history` ...
2023-03-16 10:28:31.509  INFO 60073 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `postcode`: << Empty Schema >>
2023-03-16 10:28:31.515  INFO 60073 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema `postcode` to version "1 - Add postcodelatlng"
2023-03-16 10:28:31.526  WARN 60073 --- [           main] o.f.c.i.s.DefaultSqlScriptExecutor       : DB: Integer display width is deprecated and will be removed in a future release. (SQL State: HY000 - Error Code: 1681)
2023-03-16 10:28:55.846  INFO 60073 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema `postcode` to version "1.1 - Seed postcode data"
2023-03-16 10:36:00.549  INFO 60073 --- [           main] o.f.core.internal.command.DbMigrate      : Successfully applied 2 migrations to schema `postcode`, now at version v1.1 (execution time 07:29.025s)
```

## Development

Development uses a *contract first approach*

No visible `Controller` annotations will be apprently visible

The openapi 3 definition file can be found at `./src/main/resources/distance-openapi.yml`
