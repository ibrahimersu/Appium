package step_definitions;

import io.cucumber.java.After;
import utils.Driver;

public class Hooks {

    @After
    public void teardown(){
        Driver.closeDriver();
    }
}
