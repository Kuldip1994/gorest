package com.gorest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Testbase {

    @BeforeClass
    public static void inIt(){

    RestAssured.baseURI = "https://gorest.co.in/public/";
               RestAssured.basePath ="/users";
}
}
