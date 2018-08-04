package by.htp.seleniumFinalTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BelaviaMainPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://belavia.by";

	@FindBy(xpath = "//*[@id='OriginLocation_Combobox']")
	private WebElement inputFrom;
	
	@FindBy(xpath = "//*[@id='DestinationLocation_Combobox']")
	private WebElement inputTo;
	
	@FindBy(xpath = "//*[@id='calendar']/div/div[1]/table/tbody/tr[1]/td[7]/a")
	private WebElement departureDate;
	
//	@FindBy(xpath = "//*[@id='step-2']/div[1]/div/label[1]")
//	private WebElement returnDate;
	
	@FindBy(xpath = "//*[@id='step-2']/div[1]/div/label[1]")
	private WebElement radioButtonOneWay;
	
	@FindBy(xpath = "//*[@id='step-2']/div[4]/div/button")
	private WebElement buttonSearch;	

	public BelaviaMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Main page opened");
	}

	public void fillFieldFrom(String sity) {
		inputFrom.sendKeys(sity);
		inputFrom.sendKeys(Keys.RETURN);
		logger.info("Field 'From' was filled.");
	}
	
	public void fillFieldTo(String sity) {
		inputTo.sendKeys(sity);
		inputTo.sendKeys(Keys.RETURN);
		logger.info("Field 'To' was filled.");
	}
	
	public void choseDepartoreDate() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		departureDate.click();
		logger.info("Departure date was choosen.");
	}
	
	public void choseRadioButtonOneWay() {
		radioButtonOneWay.click();
		logger.info("Radio button One-Way was choosen.");
	}
	
	public void search() {
		buttonSearch.click();
	}
}
