package starter.Reqres.AllStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Latihan -> Scenario 1
    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    // Scenario 2
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id){
        reqresAPI.deleteUser(id);
    }

    // Scenario 3
    @Given("Delete user with invalid id by character {string}")
    public void deleteUserWithInvalidIdByCharacter(String id) {
        reqresAPI.deleteUserIdString(id);
    }

    // Scenario 4
    @Given("Delete user with invalid id by special character {string}")
    public void deleteUserWithInvalidIdBySpecialCharacter(String id) {
        reqresAPI.deleteUserIdString(id);
    }

    // Scenario 5
    @Given("Delete user with invalid path by character {string}")
    public void deleteUserWithInvalidPathByCharacter(String path) {
        reqresAPI.deleteUserInvalidPath(path);
    }
    @When("Send delete user with invalid path")
    public void sendDeleteUserWithInvalidPath() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_INVALID_PATH);
    }

    @Given("Delete user with invalid path by special character {string}")
    public void deleteUserWithInvalidPathBySpecialCharacter(String path) {
        reqresAPI.deleteUserInvalidPath(path);
    }

    // Scenario 6
}
