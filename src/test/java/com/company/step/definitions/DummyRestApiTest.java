package com.company.step.definitions;

import com.company.config.TestConfig;
import com.company.controllers.SampleController;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;

import java.net.URISyntaxException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class DummyRestApiTest {
	private SampleController sampleController;
	private Scenario scenario;
	private ValidatableResponse response;

	@Before
	public void before(Scenario scenarioVal) {
		this.scenario = scenarioVal;
		this.sampleController = new SampleController();
	}

	@Given("^Get Call to \"(.*)\"$")
	public void get_call_to_url(String url) throws URISyntaxException {
		response = sampleController.makeCallTo(url);
	}

	@Given("Anonymous Client is ready for the request")
	public void anonymousClientIsReadyForTheRequest() {
		sampleController = new SampleController();
	}

	@When("Call to the all employees URL {string}")
	public void callToTheURL(String url) throws URISyntaxException {
		response = sampleController.makeCallTo(url);
	}

	@Then("^Response \"(.*)\" is validated$")
	public void response_is_validated(String responseMessage) {
		response.statusCode(HttpStatus.SC_OK);

		scenario.log("Response Recieved == " + response.extract().asPrettyString());

		response.body("message", equalTo(responseMessage));
	}


	@Then("List of employees is returned")
	public void listOfEmployeesIsReturned() {
		response.statusCode(HttpStatus.SC_OK);
		response.body("message", equalTo("Successfully! All records has been fetched."));
		response.body("data.size()", greaterThanOrEqualTo(1));
	}
}
