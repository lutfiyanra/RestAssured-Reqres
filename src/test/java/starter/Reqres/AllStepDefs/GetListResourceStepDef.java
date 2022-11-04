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

import static org.hamcrest.Matchers.equalTo;

public class GetListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get list resource with valid  path {string}")
    public void getListResourceWithValidPath(String path){
        reqresAPI.GetListResource(path);
    }
    @When("Send request to get list resource")
    public void sendRequestToGetListResource(){
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }
    @And("Response body page should be page {int} and total pages are {int}")
    public void responseBodyPageShouldBePageAndTotalPageAre(int page, int totalPage){
        SerenityRest.then()
                .body(ReqresResponses.PAGE,equalTo(page))
                .body(ReqresResponses.TOTAL_PAGE, equalTo(totalPage));
    }
    @And("Validate get list resource json schema")
    public void validateGetListResourceJsonSchema(){
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListResourceJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Get list resource with invalid path {string}")
    public void getListResourceWithInvalidPath(String path) {
        reqresAPI.GetListResource(path);
    }

    // Scenario 3
    @Given("Get list resource with valid page parameter {int}")
    public void getListResourceWithValidPageParameter(int page) {
        reqresAPI.getListResourcePageParam(page);
    }

    @When("Send request to get list resource with valid page parameter")
    public void sendRequestToGetListResourceWithValidPageParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE_PARAM);
    }

    @And("Response body page should contain page {int}")
    public void responseBodyPageShouldContainPage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
}

