package by.htp.seleniumFinalTask.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FareCalendarPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();

	@FindBy(xpath = "//div[@class='content']/label[@for]")
	private List<WebElement> pricesOnPage;
	
	@FindBy(xpath = "//div[@class='content']/input[@name='date']")
	private List<WebElement> datesOnPage;
	
	@FindBy(xpath = "//a[@data-val='next']")
	private WebElement linkNext7Day;

	public FareCalendarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		logger.info("Fare Calendar opened");
	}
	
	public List<String> getPricesOnWeek(){
		List<String> prices = new ArrayList<String>();
		for(WebElement element: pricesOnPage) {
			prices.add(element.getText());
		}
		return prices;
	}
	
	public List<String> getDateOnWeek(){
		List<String> dates = new ArrayList<String>();
		for(WebElement element: datesOnPage) {
			dates.add(element.getAttribute("value"));
		}
		return dates;
	}
	
	public void gotoNextWeek() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		linkNext7Day.click();
	}

}