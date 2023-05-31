package pages;

import org.openqa.selenium.By;

public class HomePage {

    // The list of web element for homepage of website stlouisfed.org
    public static By homePageIcon = By.xpath("//*[@id='header-menu-z']/div[2]/div[1]/a/img");
    public static By hamburgerMenu = By.xpath("//*[@id='header-menu-z']/div[2]/div[2]/div/div[2]/button");
    public static By closeHamburgerMenu = By.xpath("//*[@id='header-menu-z']/div[2]/div[2]/div/div[2]");
    public static By aboutUsMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[1]/div[1]/div[1]/p");
    public static By aboutUsSubMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[1]/div[2]/a/p");
    public static By aboutUsTitle = By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[2]/div[1]");
    public static By aboutUsDescription1 = By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[2]/div[2]/div/div/p[1]");
    public static By aboutUsDescription2 = By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[2]/div[2]/div/div/p[2]");
    public static By fromPresidentMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[2]/div[1]/div[1]/p");
    public static By publicationsMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[3]/div[1]/div[1]/p");
    public static By forTeacherStudentMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[4]/div[1]/div[1]/p");
    public static By workingWithCommunitiesMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[5]/div[1]/div[1]/p");
    public static By supervisingBanksMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[6]/div[1]/div[1]/p");
    public static By researchDatabasesMenu = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[7]/div[1]/div[1]/p");
    public static By careersLink = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[9]/div/ul/li[1]/a");
    public static By eventsLink = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[9]/div/ul/li[2]/a");
    public static By museumLink = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[9]/div/ul/li[3]/a");
    public static By newsroomLink = By.xpath("//*[@id='header']/div[3]/div/div[1]/nav/ul/li[9]/div/ul/li[4]/a");
    public static By videoContainer = By.xpath("//*[@id='content']/div/div[2]/div/div");

}
