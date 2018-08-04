package by.htp.seleniumFinalTask.steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.seleniumFinalTask.driver.DriverSingleton;
import by.htp.seleniumFinalTask.pages.BelaviaMainPage;
import by.htp.seleniumFinalTask.pages.FareCalendarPage;

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
		logger.info("--- Step: fillFormBookFlightsOneWay ---");
		BelaviaMainPage belaviaMainPage = new BelaviaMainPage(driver);
		belaviaMainPage.openPage();
		belaviaMainPage.fillFieldFrom(sityFrom);
		belaviaMainPage.fillFieldTo(sityTo);
		belaviaMainPage.choseDepartoreDate();
		belaviaMainPage.choseRadioButtonOneWay();
		belaviaMainPage.search();
	}
	
	public void fillFormBookFlightsReturn(String sityFrom, String sityTo) {
		logger.info("--- Step: fillFormBookFlightsOneWay ---");
		BelaviaMainPage belaviaMainPage = new BelaviaMainPage(driver);
		belaviaMainPage.openPage();
		belaviaMainPage.fillFieldFrom(sityFrom);
		belaviaMainPage.fillFieldTo(sityTo);
		belaviaMainPage.choseDepartoreDate();
		belaviaMainPage.choseReturnDate();
		belaviaMainPage.choseRadioButtonReturn();
		belaviaMainPage.search();
	}

	public void showTickets() {
		logger.info("--- Step: showTickets ---");
		FareCalendarPage fareCalendarPage = new FareCalendarPage(driver);
		
		List<String> prices = new ArrayList<String>();
		List<String> dates = new ArrayList<String>();
		int numberWeeksSearch = 14;

		for (int k = 1; k < numberWeeksSearch; k++) {
			List<String> pricesOnPage = new ArrayList<String>();
			pricesOnPage = fareCalendarPage.getPricesOnWeek();
			prices.addAll(pricesOnPage);
			
			List<String> datesOnPage = new ArrayList<String>();
			datesOnPage = fareCalendarPage.getDateOnWeek();
			dates.addAll(datesOnPage);

			fareCalendarPage.gotoNextWeek();
		}
		
		for(int i = 0; i < prices.size(); i++) {
			String price = prices.get(i);
			String date = dates.get(i);
			System.out.println("Date: " + date + " , cost: " + price);
		}
	}
}