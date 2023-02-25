package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIT(){
        RestAssured.baseURI = "https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 10
    @Test
    public void test001(){
        response.body("size",equalTo(10));
    }
    //2. Verify the if the name of id = 5487 is equal to ”Devvrat Verma”
    @Test
    public void test002(){
        response.body("[1].name",equalTo("Devvrat Verma"));

    }
    //3. Check the single ‘Name’ in the Array list (Pushti Khan II)
    @Test
    public void test003(){
        Arrays.asList("[7].name",equalTo("Pushti Khan II"));
    }

    //4.Check the multiple ‘Names’ in the ArrayList (Chatur Mehrotra, Lakshminath Deshpande MD, Goswami Ganaka)
    @Test
    public void test004(){
        response.body("[4].name",equalTo("Chatur Mehrotra"));
        response.body("[5].name",equalTo("Lakshminath Deshpande MD"));
        response.body("[8].name",equalTo("Goswami Ganaka"));
    }

    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005(){

        response.body("[6].email",equalTo("shukla_kumar_gov@little.biz"));

    }

    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){
        response.body("[4].status",equalTo("active"));

    }
    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){
        response.body("[9].gender",equalTo("male"));

    }

}
