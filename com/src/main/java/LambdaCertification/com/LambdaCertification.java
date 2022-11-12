package LambdaCertification.com;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LambdaCertification {

	private RemoteWebDriver driver;
	public String Status = "Failed";

	@BeforeMethod
	public void setup(Method m, ITestContext ctx) throws MalformedURLException {
		String username = System.getenv("LT_USERNAME") == null ? "priyagarikapati98" : System.getenv("LT_USERNAME");
		String authkey = System.getenv("LT_ACCESS_KEY") == null ? "ZSzD1932rF7ZxyBPuUboqBPX6YdXl9KLtv9iHqF1t7sG3VrKV0"
				: System.getenv("LT_ACCESS_KEY");
		String hub = "@hub.lambdatest.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();
		// Configure your capabilities here
		caps.setCapability("platform", "Windows 11");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("version", "107.0");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("build", "LambdaCertification");
		caps.setCapability("name", m.getName() + this.getClass().getName());
		caps.setCapability("plugin", "git-testng");

		String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
		caps.setCapability("tags", Tags);

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
	}

	@Test(priority = 1)
	public void Scenario1() {
		String Message = "Welcome to Lambda test";
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();
		System.out.println("clicked");
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(Message);
		System.out.println("Message entered successfully");
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		System.out.println("Clicked on checked button");
		String a = driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertEquals(Message, a);
		System.out.println("Both are same:)");
		Status = "Passed";

		driver.close();

	}

	@Test(priority = 2)
	public void Scenario2() {
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[normalize-space()='Drag & Drop Sliders']")).click();
		driver.findElement(By.xpath("//input[@value='15']")).clear();
		WebElement From = driver.findElement(By.xpath("//input[@value='15']"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 15, 95).doubleClick(From).perform();
		System.out.println("Moved successfully to 95 from 15");
		Status = "Passed";
		driver.close();

	}

	@Test(priority = 3)
	public void Scenario3() throws InterruptedException {
		String Final = "Thanks for contacting us, we will get back to you shortly.";
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[normalize-space()='Input Form Submit']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Priya");
		driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Chinni@273");
		driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("priyagarikapati98@gmail.com");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Mindtree");
		driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("https://www.mindtree.com/");
		Select Country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		Country.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Tirupati");
		driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("Padmavathi Nagar");
		driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("2nd line");
		driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("AndhraPradesh");
		driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("516127");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String output = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		Assert.assertEquals(Final, output);

		Status = "Passed";

	}
}
