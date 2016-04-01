package be.odisee.oxyplast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import oxyplast2016.Oxyplast2016Wa;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Oxyplast2016Wa.class)
@WebAppConfiguration
public class OxyplastDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
