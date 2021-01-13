package stepDefinations;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
     //execute this code only when place id is null
        //write code that will give you place id

        StepDefination2 m = new StepDefination2();
        if(StepDefination2.place_id==null) {

            m.addPlacePayload("Shetty", "French", "Asia");
            m.userCallsWithHttpRequest("addPlaceAPI", "POST");
            m.verifyPlace_IdCreatedMapsToUsing("Shety", "POST");
            
        }
    }
}
