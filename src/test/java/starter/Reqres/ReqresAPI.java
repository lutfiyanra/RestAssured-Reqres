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

    public static String GET_LIST_USERS = URL + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER = URL + "/api/users/{id}";

    @Step("Get list users")
    public void setGetListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
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
}
