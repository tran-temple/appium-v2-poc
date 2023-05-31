## **Appium (2.x) - Mobile Testing on real devices and emulators/simulators**
This repository contains samples to show how to use non COE-Mac + Appium (2.x) to develop some simple test scripts running on real devices (e.g iPhone, iPad, Android tablet, Android phone) and Android Emulators + iOS Simulators

### **Getting Started**
1. Install Homebrew (it’s a package management system that makes it easier to install software on Mac OS machines)
    
    Please follow the instructions on the website [Homebrew](https://brew.sh/) to install.
2. Install Carthage (a dependency manager)
    ```
    brew install carthage
    ```
3. Install Node.js and NPM (Node Package Manager)
    ```
   brew install node
   ```
4. Install Java JDK
5. Install Android Studio
6. Install Xcode
7. Install Maven
8. Set up system environment variables (JAVA_HOME, ANDROID_HOME, M2_HOME)
    
    **Note:** I use the MacBook Air (M2), so after setting up, my .zprofile file will look like the following:
    ```
   eval $(/opt/homebrew/bin/brew shellenv)
   
    export JAVA_HOME=$(/usr/libexec/java_home)
    export PATH=$JAVA_HOME/bin:$PATH
   
    export ANDROID_HOME=/Users/$USER/Library/Android/sdk
    export PATH=$ANDROID_HOME/platform-tools:$PATH
    export PATH=$ANDROID_HOME/cmdline-tools:$PATH
    export PATH=$ANDROID_HOME/cmdline-tools/latest/bin:$PATH
   
    export M2_HOME=/Users/$USER/apache-maven-3.9.1
    export PATH=$M2_HOME/bin:$PATH
   ```
9. Install IntelliJ community edition
10. Install Appium 2.0
    ```
    npm i -g appium@next
    ```
11. Install drivers: XCUITest and UiAutomator2
    ```
    appium driver install xcuitest
    appium driver install uiautomator2
    ```
12. Install Appium Inspector
    ```
    brew install --cask appium-inspector
    ```
13. Install Appium Doctor
    ```
    npm install appium-doctor -g
    ```
14. Run the Appium Doctor to check if everything is configured properly. The Doctor will provide detailed information on issues, if any:
    ```
    appium-doctor
    ```
### **Sample Test Scripts**
1. SetUpHelpers.java:
    - The file contains methods to set up Android Driver and iOS driver.
2. HomePage.java
    - The file includes the list of web elements for the homepage of the website stlouisfed.org.
3. NgBase.java
    - The file contains methods to run and start driver before executing test cases in HomePageIT.
    - It also contains setting up the device type to switch between Android and iOS devices.
4. HomePageIT.java:
    - The file includes two test cases: testing for About Us information and hamburger menu of the website stlouisfed.org.
5. HomePageSample.java
    - The file includes the list of web elements for the homepage of the website philadelphiafed.org.
6. NgBaseSample.java
   - The file contains methods to start Appium server programmatically and initiate Android driver before executing test cases in HomePageSampleIT.
7. HomePageSampleIT.java
   - The file includes one test case: testing for About Us information of the website philadelphiafed.org.

### **Running test scripts**
- For running HomePageIT test scripts, it requires to start Appium server manually before executing test scripts.
- For running HomePageSampleIT test script, only select and execute the testng.xml.
