package pages;

import org.openqa.selenium.By;

public class HomePageSample {

    // The list of web element for homepage of website philadelphiafed.org
    public static By hamburgerMenu = By.id("nav-control-links");
    public static By aboutUsMenu = By.xpath("//*[@id='nav-links']/ul[2]/li[1]/a");
    public static By aboutUsTitle = By.xpath("//*[@id='content']/header/div/h1");
    public static By aboutUsDescription = By.xpath("//*[@id='content']/header/div/p[2]");
}
