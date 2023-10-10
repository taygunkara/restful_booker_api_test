package com.restful.tests;

import com.restful.api.Routes;
import com.restful.models.Booking;
import com.restful.models.BookingResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.restful.api.BookingHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotEquals;

public class BookingTests {

    public static int bookingID;
    public static int bookingTotalPrice;

    @Test
    public void ShouldBeAbleToCreteABooking() throws IOException {

        Response response = createBooking(getJsonBody());
        BookingResponse responseBooking = response.as(BookingResponse.class);
        response.then().statusCode(200).log().all();

        bookingID = responseBooking.getBookingid();
        assertThat(Routes.EXPECTED_NAME, equalTo(responseBooking.getBooking().getFirstname()));
        assertNotEquals(bookingID, null);

    }

    @Test
    public void ShouldBeAbleToGetBookingWithID(){

        Response response = readBookingWithId();
        response.then().statusCode(200);
        Booking responseBooking = response.as(Booking.class);
        assertThat(Routes.ACTUAL_NAME, equalTo(responseBooking.getFirstname()));

        bookingTotalPrice = responseBooking.getTotalprice();
        checkTotalPrice(bookingTotalPrice);
    }


}
