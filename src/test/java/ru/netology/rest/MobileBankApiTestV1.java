package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
//        Given - When - Then
//        Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
//        Выполняемые действия
                .when()
                .get("/demo/accounts")
//        Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }

    @Test
    void shouldMatchUSD() {
//        Given - When - Then
//        Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
//        Выполняемые действия
                .when()
                .get("/demo/accounts")
//        Проверки
                .then()
                .statusCode(200)
                .body("[1].currency", equalTo("USD"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }

    @Test
    void shouldMatchHeader() {
//        Given - When - Then
//        Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
//        Выполняемые действия
                .when()
                .get("/demo/accounts")
//        Проверки
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }

    @Test
    void shouldMatchHasSize() {
//        Given - When - Then
//        Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
//        Выполняемые действия
                .when()
                .get("/demo/accounts")
//        Проверки
                .then()
                .body("", hasSize(3));
    }
}
