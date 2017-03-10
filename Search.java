package search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class Search {
	
WebDriver driver = null;
@Before
public void beforeTheTest()
{
	driver = new ChromeDriver();
}

 @Given("^I am on Amazon home page$") 
 public void goToAmazon() {
     
     driver.navigate().to("https://www.amazon.com/");
 }
 

 
 @When("^I enter search text as \"([^\"]*)\"$")
 public void I_enter_search_text_as(String arg1) {
     // Express the Regexp above with the code you wish you had
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(arg1);
    
 }
 
 @And("^I click search button$")
 public void I_click_search_button() {
     driver.findElement(By.className("nav-input")).click();
 }
 
 @Then("^I should see \"([^\"]*)\" in the search results$")
 public void I_should_see_in_the_search_results(String arg1) {
	// .//*div[@id='customSelect_3']/div/span[@class='selectLabel clear'].getText()))
     String str = driver.findElement(By.xpath("//div[@id='softlines-mini-resultinfobar']/span[@class='a-size-large a-color-secondary a-text-normal']")).getText();
     if (str.equals(arg1))
    	 System.out.println("Test pass");
     else
    	 System.out.println("Test fail");
 }
  @After
  public void afterTheTest()
  {
	  driver.close();
  }

}
