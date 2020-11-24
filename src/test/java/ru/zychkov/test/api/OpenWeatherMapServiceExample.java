package ru.zychkov.test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class OpenWeatherMapServiceExample {

    private static final String URL = "http://api.openweathermap.org/data/2.5/";
    private static final String ENDPOINT = "weather";

    public static Response doGetRequest(String appId, String cityName) {
        RestAssured.defaultParser = Parser.JSON;

        return given()
                .param("appid", appId)
                .param("q", cityName)
                .header("Content-Type", ContentType.JSON)
                .when().get(URL + ENDPOINT)
                .then().contentType(ContentType.JSON).extract().response();
    }

    public static float getTemperature(Response response) {
        Map<String, Float> main = response.jsonPath().getMap("main");

        return main.get("temp");
    }

    public static int kelvinToCelsius(float tempInKelvin) {
        return (int) (tempInKelvin - 273.15f);
    }
}