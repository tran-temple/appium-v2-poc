package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NgBase;

import java.time.Duration;

public class HomePageIT extends NgBase {

    // Go HomePage first
    public void goHomePage(){
        driver.findElement(HomePage.homePageIcon).click();
        //explicit wait - to wait for video shows
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.videoContainer));
    }

    // Test case is to test About us menu and description
    @Test(enabled = true)
    public void testAboutUs() throws InterruptedException {
        // Show hamburger menu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.hamburgerMenu));
        driver.findElement(HomePage.hamburgerMenu).click();
        Thread.sleep(2000);

        // Verify About us header and description
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.aboutUsMenu));
        WebElement eleAboutUs = driver.findElement(HomePage.aboutUsMenu);
        System.out.println(eleAboutUs.getText());
        eleAboutUs.click();
        Thread.sleep(2000);

        WebElement eleSubMenu = driver.findElement(HomePage.aboutUsSubMenu);
        System.out.println(eleSubMenu.getText());
        eleSubMenu.click();
        Thread.sleep(2000);

        WebElement eleAboutUsTitle = driver.findElement(HomePage.aboutUsTitle);
        System.out.println(eleAboutUsTitle.getText());
        Thread.sleep(2000);
        String originalDesc = "About the Federal Reserve Bank of St. Louis";
        Assert.assertEquals(eleAboutUsTitle.getText(), originalDesc);

        WebElement eleDescription1 = driver.findElement(HomePage.aboutUsDescription1);
        System.out.println(eleDescription1.getText());
        String desc1 = "Headquartered in downtown St. Louis at the intersection of Fourth, St. Charles and Broadway, ";
        desc1 += "the Federal Reserve Bank of St. Louis takes great pride in serving \"Main Street\" audiences and representing their views.";
        Assert.assertEquals(eleDescription1.getText(), desc1);

        WebElement eleDescription2 = driver.findElement(HomePage.aboutUsDescription2);
        System.out.println(eleDescription2.getText());
        String desc2 = "The St. Louis Fed is located in the Eighth Federal Reserve District, which includes all of Arkansas and portions of six other states: ";
        desc2 += "Illinois, Indiana, Kentucky, Mississippi, Missouri and Tennessee. The St. Louis Bank serves most of eastern Missouri and southern Illinois. ";
        desc2 += "We also have branch locations in Little Rock, Louisville and Memphis.";
        Assert.assertEquals(eleDescription2.getText(), desc2);
    }

    // Test case is to test Hamburger menu
    @Test(enabled = true)
    public void testHamburgerMenu() throws InterruptedException {
        goHomePage();
        // Show hamburger menu
        Thread.sleep(2000);
        driver.findElement(HomePage.hamburgerMenu).click();
        Thread.sleep(2000);

        // Verify menu shown below hamburger menu
        Assert.assertEquals(driver.findElement(HomePage.aboutUsMenu).getText(),"About Us");
        Assert.assertEquals(driver.findElement(HomePage.fromPresidentMenu).getText(),"From President\nJim Bullard");
        Assert.assertEquals(driver.findElement(HomePage.publicationsMenu).getText(),"Publications");
        Assert.assertEquals(driver.findElement(HomePage.forTeacherStudentMenu).getText(),"For Teachers\n& Students");
        Assert.assertEquals(driver.findElement(HomePage.workingWithCommunitiesMenu).getText(),"Working with\nCommunities");
        Assert.assertEquals(driver.findElement(HomePage.supervisingBanksMenu).getText(),"Supervising\nBanks");
        Assert.assertEquals(driver.findElement(HomePage.researchDatabasesMenu).getText(),"Research &\nDatabases");

        // Verify links
        Assert.assertEquals(driver.findElement(HomePage.careersLink).getText(),"Careers");
        Assert.assertEquals(driver.findElement(HomePage.eventsLink).getText(),"Events");
        Assert.assertEquals(driver.findElement(HomePage.museumLink).getText(),"Museum");
        Assert.assertEquals(driver.findElement(HomePage.newsroomLink).getText(),"Newsroom");
        // Close menu
        driver.findElement(HomePage.closeHamburgerMenu).click();
    }

}
