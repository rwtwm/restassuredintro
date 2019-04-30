package com.sparta.waj;

import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SinglePostcodeTests
{
    @BeforeClass
    public static void Setup()
    {
        baseURI = "https://api.postcodes.io/";
        basePath = "postcodes/";
    }

    @Test
    public void PostcodeRequestIsSuccessful()
    {
        get("e114du").then()
                .statusCode(200)
                .body("result.postcode",equalTo("E11 4DU"));
    }

    @Test
    public void IllegalPostcode()
    {
        get("ZE19 8JQ").then().statusCode(404);
    }
}
