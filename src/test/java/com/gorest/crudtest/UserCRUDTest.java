package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.Testbase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends Testbase {


    static ValidatableResponse response;
    int idNumber;
    @Test
    public void test001() {

        UserPojo pojo = new UserPojo();
        pojo.setName("anhubg");
        pojo.setGender("male");
        pojo.setEmail("patelt12@gmail.com");
        pojo.setStatus("active");

        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer 629fd11e416237ddfc7ff93a7321791d4b81f7ec28c9a84a46790eb29fe3b4c3")
                .header("Content-Type", "application/json")
                .body(pojo)
                .when()
                .post();
        response.then().statusCode(200);
        int idNumber = response.then().extract().path("id");
        System.out.println(idNumber);

    }
    @Test //update
    public void test002(){
        UserPojo pojo= new UserPojo();
        pojo.setGender("Female");
        pojo.setName("Josh");

        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer 629fd11e416237ddfc7ff93a7321791d4b81f7ec28c9a84a46790eb29fe3b4c3")
                .header("Content-Type", "application/json")
                .pathParam("id","628132")
                .body(pojo)
                .patch("/{id}");

        response.then().statusCode(201);

    }
    @Test //delete
    public void test003(){
        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer 629fd11e416237ddfc7ff93a7321791d4b81f7ec28c9a84a46790eb29fe3b4c3")
                .header("Content-Type", "application/json")
                .pathParam("id","628132")
                .when()
                .delete("/{id}");

        response.then().statusCode(204);

    }
    @Test //retrive
    public void test004(){
        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer 629fd11e416237ddfc7ff93a7321791d4b81f7ec28c9a84a46790eb29fe3b4c3")
                .header("Content-Type", "application/json")
                .pathParam("id","628132")
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }



}


