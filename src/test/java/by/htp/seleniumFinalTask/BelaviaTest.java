package by.htp.seleniumFinalTask;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.seleniumFinalTask.steps.Steps;

public class BelaviaTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "One side")
	public void getListTickersOneSide() {
		steps.fillFormBookFlightsOneWay("Минск", "Рига");
		steps.showTickets();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
