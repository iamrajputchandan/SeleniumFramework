package MvnPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver; 

public class DemoClass {

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
		driver.get("http://www.facebook.com");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("9631692459");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ja*N2025");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
		driver.findElement(By.tagName("body")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@aria-label='Messenger' and @class='x1i10hfl x1ejq31n xd10rxx x1sy0etr x17r0tee x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 xzolkzo x12go9s9 x1rnf11y xprq8jg x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x1vqgdyp x100vrsf x1qhmfi1']")).click();
		//driver.close();
}
}