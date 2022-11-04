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

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

        // Scenario 1
        @Given("Post login with all valid value")
        public void postLoginWithAllValidValue(){
             File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLogin.json");
             reqresAPI.postLogin(json);
            }
        @When("Send request post login")
        public void sendRequestPostLogin(){
            SerenityRest.when().post(ReqresAPI.POST_LOGIN);
            }
        @Then("Should return {int} OK")
        public void shouldReturnOK(int OK) {
            SerenityRest.then().statusCode(OK);
            }
        @And("Response body should contain token {string}")
        public void responseBodyShouldContainToken(String token){
            SerenityRest.then().body(ReqresResponses.TOKEN, equalTo(token));
        }

        @And("Validate post login valid value json schema")
        public void postLoginValidValueJsonSchemaValidator(){
            File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginJsonSchema.json");
            SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
        }

    // Scenario 2
    @Given("Post login input email empty password")
    public void postLoginInputEmailEmptyPassword() {
            File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginEmptyPassword.json");
            reqresAPI.postLogin(json);
    }


    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response body should contain error message {string}")
    public void responseBodyShouldContainErrorMessage(String error) {
        ///
    }

    @And("Validate post login error message json schema")
    public void postLoginErrorMessageJsonSchema() {
            File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginErrorJsonSchema.json");
            SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 3
    @Given("Post login input password empty email")
    public void postLoginInputPasswordEmptyEmail() {
            File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginEmptyEmail.json");
            reqresAPI.postLogin(json);
    }

    // Scenario 4
    @Given("Post login empty email empty password")
    public void postLoginEmptyEmailEmptyPassword() {
            File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginEmptyAllValue.json");
            reqresAPI.postLogin(json);
    }

    @Given("Post login input with unregistered email")
    public void postLoginInputWithUnregisteredEmail() {
            File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostLoginUnregisteredEmail.json");
            reqresAPI.postLogin(json);
    }

    // Scenario 5

}

