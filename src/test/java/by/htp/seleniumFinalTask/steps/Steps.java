package by.htp.seleniumFinalTask.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.seleniumFinalTask.driver.DriverSingleton;
import by.htp.seleniumFinalTask.pages.BelaviaMainPage;

public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void fillFormBookFlightsOneWay(String sityFrom, String sityTo) {
		BelaviaMainPage belaviaMainPage = new BelaviaMainPage(driver);
		belaviaMainPage.openPage();
		belaviaMainPage.fillFieldFrom(sityFrom);
		belaviaMainPage.fillFieldTo(sityTo);
		belaviaMainPage.choseDepartoreDate();
		belaviaMainPage.choseRadioButtonOneWay();
		belaviaMainPage.search();
	}
}