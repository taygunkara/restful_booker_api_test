package com.restful.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.restful.api.SpecBuilder.getRequestSpec;
import static com.restful.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response get(String path, int bookingid){
        return given(getRequestSpec())
                .when().get(path + "/" + bookingid)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response post(String path, String requestBooking){
        return given(getRequestSpec())
                .body(requestBooking)
                .contentType(ContentType.JSON)
                .when().post(path)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

}
