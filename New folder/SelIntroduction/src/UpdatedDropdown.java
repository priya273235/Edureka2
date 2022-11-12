import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\New folder\\SelIntroduction\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println("click on add passengers field is successful");
		Thread.sleep(1000);
		int i=1;
		while(i<5) {
		driver.findElement(By.id("hrefIncAdt")).click();//4times
		i++;
		}
		System.out.println(driver.findElement(By.id("spanAudlt")).getText());
		System.out.println("Added 5 passegers successfully");
		driver.findElement(By.id("btnclosepaxoption"));
		System.out.println("Closed the field");
		driver.close();

	}

}
