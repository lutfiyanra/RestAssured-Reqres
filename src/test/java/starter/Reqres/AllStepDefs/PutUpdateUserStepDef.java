package starter.Reqres.AllStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.framework.qual.RequiresQualifier;
import starter.Reqres.ReqresAPI;

import java.io.File;

public class PutUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;


    // Scenario 1 -> latihan
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.setPutUpdateUser(id,json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Put update user with id {int} only input name")
    public void putUpdateUserWithIdIdOnlyInputName(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PutUpdateUserEmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    // Scenario 3
    @Given("Put update user with id {int} only input job")
    public void putUpdateUserWithIdIdOnlyInputJob(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PutUpdateUserEmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    // Scenario 4
    @Given("Put update user with id {int} empty name and empty job")
    public void putUpdateUserWithIdIdEmptyNameAndEmptyJob(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PutUpdateUserEmptyAllValue.json");
        reqresAPI.putUpdateUser(id, json);
    }

    // Scenario 5
    @Given("Put update user with invalid path {string} by character and valid json")
    public void putUpdateUserWithInvalidPathAndValidJson(String path) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }
    @When("Send put update user request invalid path")
    public void sendPutUpdateUserRequestInvalidPath() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER_INVALID_PATH);
    }

    // Scenario 6
    @Given("Put update user with invalid path {string} by special character and valid json")
    public void putUpdateUserWithInvalidPathBySpecialCharacterAndValidJson(String path) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }
}
