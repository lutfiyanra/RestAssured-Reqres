package starter.Reqres.AllStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;


public class GetDelayResponseStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get delayed response with valid parameter delay {int}")
    public void getDelayedResponseWithValidParameterDelay(int delay){
        reqresAPI.getDelayedResponse(delay);
    }

    @When("Send request to get delayed response")
    public void sendRequestToGetDelayedResponse() throws InterruptedException {
        Thread.sleep(3000);
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

    @And("Validate get delayed response json schema")
    public void validateGetDelayedResponseJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/GetDelayedResponseSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
