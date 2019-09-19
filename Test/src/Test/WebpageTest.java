package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class WebpageTest {
	
	    public static void main(String[] args) {
	    	
	        // declaration and instantiation of objects/variables
	    	
	    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	        WebDriver w = new FirefoxDriver();
	        String baseUrl = "https://www.fevicoldesignideas.com/fcc-listing";
	        w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        String expectedTitle = "Fevicol Design Ideas | Certified Contractors";
	        String actualTitle = "";

	        // launch Fire fox and direct it to the Base URL
	        w.get(baseUrl);
	        
	        // get the actual value of the title
	        actualTitle = w.getTitle();

	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Title Test Passed!");
	        } else {
	            System.out.println("Title Test Failed");
	        }
	        
	        /*
	         * searching the contractor by pin
	         */
	        
	        w.findElement(By.id("loc_pincode")).click();
	        w.findElement(By.id("loc_pincode")).sendKeys("400011");
	        w.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	        w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        
	        String imageUrl=w.findElement(By.xpath("//img[contains(@src,'https://www.fevicoldesignideas.com/images/404-img.png')]")).getAttribute("src");
	        System.out.println("Image source path : \n"+ imageUrl);
	        
	        WebElement textErrorPage= w.findElement(By.xpath("//p[1]"));
	        String innerText= textErrorPage.getText();
	        System.out.println("Inner text is :"+innerText);
	                
	        //close Firefox
	        w.close();
	       
	    }

	}

