package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class User {
    protected static String url = "https://reqres.in/api/";

    @Step("I set Api endpoints")
    public String setApiEndpoint() {
        return url + "users/2";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }


    @Step("I receive valid data for detail user")
    public void validateDataDetailUser() {
        restAssuredThat(response -> response.body("'data'.'id'", equalTo(2)));
        restAssuredThat(response -> response.body("'data'.'first_name'", equalTo("Janet")));
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setApiEndpoint());
    }


    @Step("I receive valid HTTP response code {int}")
    public void iReceiveValidHTTPResponseCode(int statusCode) {
        if(statusCode==200){
            SerenityRest.then().statusCode(200);
        }else if(statusCode==201){
            SerenityRest.then().statusCode(201);
        }else{
            SerenityRest.then().statusCode(204);
        };
    }

    @Step("I receive valid data for new user")
    public void validateDatanewUser() {
        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("leader")));
    }

    @Step("I send PUT HTTP request")
    public void iSendPUTHTTPRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).put(setApiEndpoint());
    }

    @Step("I receive valid data for updated user")
    public void iReceiveValidDataForUpdatedUser() {
        restAssuredThat(response -> response.body("'name'", CoreMatchers.equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", CoreMatchers.equalTo("zion resident")));
    }

    @Step("I send DELETE HTTP request")
    public void iSendDELETEHTTPRequest() {
        SerenityRest.given().delete(setApiEndpoint());
    }
}
