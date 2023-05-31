package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageSample;
import pages.NgBaseSample;

public class HomePageSampleIT extends NgBaseSample {

    // Test case is to test About us menu and description
    @Test(enabled = true)
    public void testAboutUs() {
        // Show hamburger menu
        WebElement eleMenu = getDriverTest().findElement(HomePageSample.hamburgerMenu);
        eleMenu.click();

        // Verify About us header and description
        WebElement eleAboutUs = getDriverTest().findElement(HomePageSample.aboutUsMenu);
        eleAboutUs.click();

        WebElement eleTitle = getDriverTest().findElement(HomePageSample.aboutUsTitle);
        WebElement eleDescription = getDriverTest().findElement(HomePageSample.aboutUsDescription);

        String originalDesc = "We are one of 12 regional Reserve Banks that, together with the Board of Governors in Washington, D.C., make up the Federal Reserve System. ";
        originalDesc += "As the central bank of the nation, we work to ensure the strength and integrity of the U.S. economy and financial system.";

        Assert.assertEquals(eleTitle.getText(), "About Us");
        Assert.assertEquals(eleDescription.getText(), originalDesc);
    }
}
