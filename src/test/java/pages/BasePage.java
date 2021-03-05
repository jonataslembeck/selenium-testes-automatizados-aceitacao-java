package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		if (driver == null) {
			this.driver = new ChromeDriver();
		} else {
			this.driver = driver;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Espera componente carregar
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // Espera pagina carregar
	}
	
	public void fechar() {
		driver.quit();
	}

}
