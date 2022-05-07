package cl.equifax.prueba.Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cl.equifax.prueba.Page.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "cl.equifax.prueba.Step" }, 
				features = "src/test/resources/cucumber", 
				plugin = {"pretty" }, 
				monochrome = true, 
				tags = "@flujos_EquiFax")

public class MainRunner {
	@AfterClass
	public static void cleanDriver() {
		Base.closeBrowser();
		
	}
}
