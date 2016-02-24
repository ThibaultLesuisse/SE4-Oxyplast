package BE.Odisee.Oxyplast;


import org.junit.runner.RunWith;

import cucumber.api.junit.*;


@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)

@Cucumber.Options(format={"pretty", "html:target/cucumber"}) 
public class RunTests {
}