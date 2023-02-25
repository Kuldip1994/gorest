package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class PostsAssertionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI ="https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/posts?page=1&per_page=25")
                .then().statusCode(200);
    }

    //1. Verify  if the total record is 25
    @Test
    public void test001(){
        response.body("size", equalTo(25));
    }

    //2.Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test002(){
        response.body("[11].title",equalTo("Utor omnis vinitor clamo soluta expedita basium nemo canis aveho molestiae capillus."));
    }

    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003(){
        Arrays.asList("[6].user_id",equalTo("602803"));
    }

    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004(){
        Arrays.asList("[6].id",equalTo(20958));
        Arrays.asList("[7].id",equalTo(20957));
        Arrays.asList("[8].id",equalTo(20955));

    }
    //5.Verify the body of userid = 2678 is equal
    @Test
    public void test005(){

        response.body("[5].body",equalTo("Blanditiis aer verto. Basium utor conforto. Debeo acsi terga. Cariosus error eligendi. Ter sulum cariosus. Aegrus benigne amoveo. Tibi canto ait. Strues umerus vitium. Tonsor despecto cupiditate. Caecus cibo acerbitas. Tantum conicio viriliter. Catena verto atrox. Enim ambulo auditor. Theatrum avoco autem. Celebrer conqueror accusamus. Cum caste quos. Cariosus desidero infit. Depopulo vero molestiae. Deprimo demum coma."));

    }


}
