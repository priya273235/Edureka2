import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\New folder\\SelIntroduction\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();;
		driver.get("https:\\google.com");
		driver.navigate().to("https:\\rahulshettyacademy.com");
		driver.navigate().back();
		System.out.println("Hi!google");
		driver.navigate().forward();
		System.out.println("Hi!RahulShettyacademy");

	}

}
