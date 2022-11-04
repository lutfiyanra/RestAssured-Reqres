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

public class PostCreateNewUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/CreateUser.json");
        reqresAPI.setPostCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {

        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAnd(String name, String job) {
        SerenityRest.then().
                body(ReqresResponses.NAME,equalTo(name)).
                body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate create user json schema")
    public void validateCreateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/CreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Post create new user input name empty job")
    public void postCreateNewUserInputNameEmptyJob() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostCreateNewUserEmptyJob.json");
        reqresAPI.setPostCreateNewUser(json);
    }

    // Scenario 3
    @Given("Post create new user input job empty name")
    public void postCreateNewUserInputJobEmptyName() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostCreateNewUserEmptyName.json");
        reqresAPI.setPostCreateNewUser(json);
    }

    // Scenario 4
    @Given("Post create new user with empty name and empty job")
    public void postCreateNewUserWithEmptyNameAndEmptyJob() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostCreateNewUserEmptyAllValue.json");
        reqresAPI.setPostCreateNewUser(json);
    }

}
