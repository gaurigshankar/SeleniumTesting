package org.openqa.selenium.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Example {

	public static void main(String[] args) {
		// Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        
        System.out.println(element.getText());
        CharSequence[] obje = {"hello"};

        // Enter something to search for
       element.sendKeys(new String[] { "hello" });

        // Now submit the form. WebDriver will find the form for us from the element
       // element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
	}

	/*compile 'org.openqa.selenium.core:selenium-core:1.0-20080914.225453'
	compile 'org.openqa.selenium.server:selenium-server:1.0-20081010.060147'
	compile 'org.openqa.selenium.server:selenium-server-coreless:1.0-20081010.060147'*/
}
