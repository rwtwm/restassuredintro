package com.sparta.waj;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultiplePostcodeTest
{
    private static Response response;

    @BeforeClass
    public static void Setup()
    {
        baseURI = "https://api.postcodes.io/";
        basePath = "postcodes/";
    }

    @BeforeClass
    public static void cacheResponse()
    {
        response = given().contentType(ContentType.JSON).body("{\"postcodes\":[\"OX49 5NU\",\"M32 0JG\",\"NE30 1DP\"]}")
                .when()
                .post()
                .then().extract().response();
    }

    @Test
    public void testMultiple()
    {
        response
                .then()
                .body("result[0].result.country", equalTo("England"));
    }
}
