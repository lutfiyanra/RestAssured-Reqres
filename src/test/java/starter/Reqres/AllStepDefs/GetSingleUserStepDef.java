package starter.Reqres.AllStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario 1
    @Given("Get single user with id {int}")
    public void getSingleUserWithValidParam(int id){
        reqresAPI.getSingleUser(id);
    }
    @When("Send request to get single user")
    public void sendRequestToGetSingleUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @And("Response body page should contain id {int} first name {string} and last name {string}")
    public void responseBodyPageShouldContainIdFirstNameAndLastName(int id, String firstName, String lastName) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.FIRST_NAME,equalTo(firstName))
                .body(ReqresResponses.LAST_NAME,equalTo(lastName));
    }
    @And("Response body should contain id {int} with first name {string} and last name {string}")
    public void responseBodyShouldContainIdFirstNameAndLastName(int id, String firstName, String lastName){
        SerenityRest.then().body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.FIRST_NAME, equalTo(firstName))
                .body(ReqresResponses.LAST_NAME, equalTo(lastName));
    }
    @And("Validate get single user with json schema validator")
    public void validateGetSingleUserWithJsonSchemaValidator(){
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Get single user with invalid id {string}")
    public void getSingleUserInvalidId(String id){
        reqresAPI.getSingleUserInvalidStringValue(id);
    }

    // Scenario 3 dan 4 sama dengan Scenario 2

    // Scenario 5
    @Given("Get single user invalid id higher than expected value {int}")
    public void getSingleUserIdHigherThanExpected(int id){
        reqresAPI.getSingleUser(id);
    }

}
