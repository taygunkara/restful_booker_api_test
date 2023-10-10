package com.restful.api;
import io.restassured.internal.support.PathSupport;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.restful.api.Routes.PATH;
import static com.restful.tests.BookingTests.bookingID;


public class BookingHelper {

    public static Response createBooking(String requestBooking){
        return RestResource.post(PATH, requestBooking);
    }
    public static Response readBookingWithId(){
        return RestResource.get(PATH, bookingID);
    }
    public static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String getJsonBody() throws IOException {
        return generateStringFromResource("src/test/resources/data.json");
    }
    public static void checkTotalPrice(int totalprice){
        String message = null;
        if (totalprice > 1){
            message = "Pahalı tatil";
        }
        System.out.println(message);
    }

}