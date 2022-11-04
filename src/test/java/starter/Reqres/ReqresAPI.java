package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_LIST_USERS = URL + "/api/users?page={page}";
    public static String ID = "data.id";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String GET_LIST_RESOURCE= URL+"/api/{path}";
    public static String GET_LIST_RESOURCE_PARAM=URL+"/api/unknown?page={page}";
    public static String GET_SINGLE_RESOURCE = URL+"/api/unknown/{id}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER_INVALID_PATH=URL+"/api/{path}";
    public static String POST_LOGIN = URL+"/api/login";
    public static String POST_REGISTER = URL+"/api/register";
    public static String PUT_UPDATE_USER_INVALID_PATH=URL+"/api/{path}";
    public static String GET_DELAYED_RESPONSE=URL+"/api/users?delay={delay}";

    @Step("Get list users")
    public void setGetListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get list users invalid page with char")
    public void getListUsersInvalidPage(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user invalid id with string")
    public void getSingleUserInvalidStringValue(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list resource with valid path")
    public void GetListResource(String path){
        SerenityRest.given().pathParam("path", path);
    }

    @Step("Get list resource with valid page parameter")
    public void getListResourcePageParam(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single resource with valid id")
    public void getSingleResourceValidId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single resource with invalid id by char")
    public void getSingleResources(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Post Register")
    public void postRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user")
    public void setPostCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete user id string")
    public void deleteUserIdString(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user id invalid path")
    public void deleteUserInvalidPath(String path){
        SerenityRest.given().pathParam("path", path);
    }

    @Step("Put Update User")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user invalid path")
    public void putUpdateUserInvalidPath(String path, File json){
        SerenityRest.given()
                .pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Custom Login
    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Get Delayed Response")
    public void getDelayedResponse(int delay){
        SerenityRest.given().pathParam("delay", delay);
    }
}
