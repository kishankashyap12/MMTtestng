package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class MMTbaseclass {

	public WebDriver driver;
	public Properties prop;

	public void driverIni() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		}
	}

	@BeforeMethod
	public void openurl() throws IOException {
		driverIni();
		String urlname = prop.getProperty("url");
		driver.get(urlname);
		driver.manage().window().maximize();

	}
/*
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
*/
}
