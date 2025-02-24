Hello!

This Repo contains Test project that I have created using Java-based Selenium Automation Framework for the website https://www.demoblaze.com/.
I used TestNG for the test Execution, then Log4j2 for Logging. This Automation Framework also supports parallel testing in multiple browser (Chrome and Edge).

**🛠 Tech Used**
- **Programming Language:** Java
- **Test Framework:** TestNG
- **Automation Tool:** Selenium
- **Logging:** Log4j2
- **Build Tool**: Maven
- **Browsers Supported:** Chrome, Edge


**Prerequisites**
- **Java Development Kit (JDK) 8 or highe**r - Download here
- **Apache Maven** - Installation Guide
- **Chrome Browser** - Download here
- **Edge Browser** - Download here
- **IDE** (e.g., IntelliJ IDEA, Eclipse)


**Installation Guide**
- **1. Clone the Repository:**
    - git clone https://github.com/your-username/https://github.com/jofel06/DemoBlaze
    - cd DemoBlaze
  
- **2. Configure Browser Drivers:**
  - Ensure the browser drivers are set up in the system path or configured in the framework.
    - **ChromeDriver:** [Download here](https://storage.googleapis.com/chrome-for-testing-public/133.0.6943.98/win64/chromedriver-win64.zip)
    - **EdgeDriver:** [Download here](https://msedgedriver.azureedge.net/133.0.3065.59/edgedriver_win64.zip)
  
-  **3. Import the Project into Your IDE:**
    - Open your IDE and select Import Project.
    - Choose the pom.xml file to import as a Maven project.

- **4. Install Dependencies:**
  - In the project root directory, run:
    - mvn clean install

**Running the Test**
- **To run all Test using Maven Command:**
    - mvn test
- **To run Specific Test Suite:**
    - mvn test "-Dsurefire.suiteXmlFiles=/path_to_testng_suites.xml"
  
- **Using IDE:**
    - Right-click on the TestNG suite XML file and select Run.


**Logging**
- The project uses Log4j2 for logging. Separate log files are generated for each browser when running in parallel. Log configuration can be adjusted in the log4j2.xml file located in the src/main/resources directory.


**Screenshots on Failure**
- Screenshots are automatically captured on test failures and stored in the screenshots directory under the project root.
