package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        ArrayList<Integer> ids = response.extract().path("ikd");
        int size = ids.size();
        System.out.println("ID" + size);
    }

    //2. Extract the all Names
    @Test
    public void test002() {
        ArrayList<String> names = response.extract().path("name");
        System.out.println("Names are " + names);
        for (String a : names) {
            if (a.equals(10)) {
                Assert.assertTrue(true);
            }

        }

    }

    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String object = response.extract().path("[4].name");
        System.out.println("Name of 5th object is " + object);
        Assert.assertTrue(true);


    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        ArrayList<String> status = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("Names of inactive users" + status);
        Assert.assertTrue(true);
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        ArrayList<String> gender = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("Genders which are active" + gender);
        Assert.assertTrue(true);
    }

    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        ArrayList<String> genderf = response.extract().path("findAll{it.gender=='female'}.name");
        System.out.println("names of Female genders" + genderf);
        Assert.assertTrue(true);
    }

    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007() {
        ArrayList<String> emails = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("emails of inactive status" + emails);
        Assert.assertTrue(true);
    }

    //8. Get the ids of the object where gender = male
    @Test
    public void test008() {
        ArrayList<String> ids = response.extract().path("findAll{it.gender=='male'}.id");
        System.out.println("id of males" + ids);
        Assert.assertTrue(true);

    }

    //9. Get all the status
    @Test
    public void test009() {
        ArrayList<String> status = response.extract().path("status");
        System.out.println("all the status"+status);
        Assert.assertTrue(true);
    }

    //10. Get email of the object where name = Bhadrak Panicker Ret.
    @Test
    public void test010(){
        String email = response.extract().path("[3].email");
        System.out.println("the email is "+email);
        Assert.assertTrue(true);
    }

    //11. Get gender of id = 5471
    @Test
    public void test011(){
        String gender = response.extract().path("[1].gender");
        System.out.println("The gender is " +gender);
        Assert.assertTrue(true);
    }


}
