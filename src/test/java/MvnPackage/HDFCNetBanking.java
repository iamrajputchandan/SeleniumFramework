package MvnPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver; 

public class HDFCNetBanking {

	public static String browser= "Chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chrome-win64\\chrome_proxy.exe");
		if(browser.equals("Chrome")) {
		driver=new ChromeDriver();
		}
		else if(browser.equals("Edge")) {
		driver=new EdgeDriver();
		}
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		//driver.switchTo().frame(0); even this code will work
		WebElement frame1=driver.findElement(By.xpath("//frame[@name='login_page']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@class='form-control text-muted']")).sendKeys("48482463");
		driver.findElement(By.xpath("//a[@class='btn btn-primary login-btn']")).click();
		
		//The website will not allow to do the right click, so we can do Ctrl+Shift+I and iterate through the webElements manually
		driver.findElement(By.xpath("//input[@name='fldPassword']")).sendKeys("santosh@4366");
		driver.findElement(By.xpath("//input[@name='chkrsastu']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='fldMobile']")).click();
		driver.findElement(By.xpath("//img[@alt='Submit']")).click();
		
		Thread.sleep(2000);
		//driver.close();
}
}