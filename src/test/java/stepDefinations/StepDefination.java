package stepDefinations;


import io.cucumber.java.en.*;

public class StepDefination {

    @Given("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() {
        System.out.println("A");
    }

    @When("User login into application with username and password")
    public void user_login_into_application_with_username_and_password() {

        System.out.println("B");
    }
    @When("User login into application with {string} and {string}")
    public void userLoginIntoApplicationWithAnd(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {

        System.out.println("C");
    }
    @Then("Cards are displayed")
    public void cards_are_displayed() {

        System.out.println("D");
    }


    @And("Cards are displayed {string}")
    public void cardsAreDisplayed(String arg0) {
        System.out.println("arg0 = " + arg0);
        
    }



}
