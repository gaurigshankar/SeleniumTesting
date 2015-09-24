package org.openqa.selenium.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GoogleLogin {
	private static WebDriver driver = null;
	private static String welcomeMessage = "Welcome Message";
	private static String loginPassword = "username";
	private static String loginEmail = "password";
	
	public static void main(String[] args) {
		
		String fileName = "files/2.txt";
		if(args.length>0){
			fileName = "files/"+args[0]+".txt";
		}
		
		ArrayList<String> list = readFileIntoList(fileName);
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()){
			String inviteEmailIds = iter.next();
			loginAndNavigate(inviteEmailIds);
			System.out.println();
		}
		
		
	}
	
	private static void loginAndNavigate(String inviteEmailIds){
		driver = new FirefoxDriver();
		
		
		WebElement memberEmailAddress = null;
		WebElement memberWelcomeMessageElement  = null;
		
        driver.get("https://groups.google.com/forum/#!managemembers/sanatanmandirsanbruno/add");

        
        WebElement element = driver.findElement(By.id("Email"));
        element.sendKeys(loginEmail);
        element.submit();
        
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        WebElement passWordElement = driver.findElement(By.name("Passwd"));
        passWordElement.sendKeys(loginPassword);
        WebElement signInElement = driver.findElement(By.name("signIn")); 
        signInElement.submit();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        memberEmailAddress = driver.findElement(By.id("gwt-uid-172"));
        if(null!=memberEmailAddress){
        	memberEmailAddress.sendKeys(inviteEmailIds);
            memberWelcomeMessageElement = driver.findElement(By.id("gwt-uid-173"));
            memberWelcomeMessageElement.sendKeys(welcomeMessage);
            
        }
        else{
        	memberEmailAddress = driver.findElement(By.id("gwt-uid-164"));
        	memberEmailAddress.sendKeys(inviteEmailIds);
            memberWelcomeMessageElement = driver.findElement(By.id("gwt-uid-165"));
            memberWelcomeMessageElement.sendKeys(welcomeMessage);
        }
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
        //driver.quit();
	}
	
	public static ArrayList<String> readFileIntoList(String fileName){
		Scanner s;
		ArrayList<String> list = null;
		try {
			
			s = new Scanner(new File(fileName));
			 list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}


