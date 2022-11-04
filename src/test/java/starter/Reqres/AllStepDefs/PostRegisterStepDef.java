package starter.Reqres.AllStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario 1
    @Given("Post register with all valid body request")
    public void postRegisterWithAllValidBodyRequest(){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostRegister.json");
        reqresAPI.postRegister(json);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body should contain id is {int} and token is {string}")
    public void responseBodyShouldContainIdIsAndTokenIs(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID_POST_REGISTER,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate post register with valid value json schema")
    public void validatePostRegisterWithValidValueJsonSchema() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostRegisterValidValueSchema.json");
        reqresAPI.postRegister(json);
    }

    // Scenario 2
    @Given("Post register input email with empty password")
    public void postRegisterInputEmailWithEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterEmptyPassword.json");
        reqresAPI.postRegister(json);
    }
    @And("Validate post register error message with json schema")
    public void validatePostRegisterErrorMessageWithJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA +"/PostRegisterErrorMessageSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 3
    @Given("Post register input password with empty email")
    public void postRegisterInputPasswordWithEmptyEmail() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostRegisterEmptyEmail.json");
        reqresAPI.postRegister(json);
    }

    // Scenario 4
    @Given("Post register empty email and empty password")
    public void postRegisterEmptyEmailAndEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostRegisterEmptyAllValue.json");
        reqresAPI.postRegister(json);
    }
}

