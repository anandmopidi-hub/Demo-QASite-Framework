Demo-QASite-Framework

📌 Project Overview

This project is a **Selenium Automation Framework** built using **Java + TestNG** to automate test scenarios on the DemoQA website.

It follows a **Page Object Model (POM)** design with reusable utilities for better scalability, maintainability, and readability.

🚀 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports

📂 Project Structure
```
Demo-QASite-Framework
├── base
│   └── BaseTest.java
├── pages
│   ├── HomePage.java
│   ├── TextBoxPage.java
│   ├── CheckBoxPage.java
│   ├── RadioButtonPage.java
│   ├── WebTablePage.java
│   ├── ButtonsPage.java
│   ├── LinksPage.java
│   └── BrokenLinksPage.java
├── tests
│   └── DemoQATest.java
├── utils
│   ├── ActionUtil.java
│   ├── WaitUtil.java
│   ├── LoggerUtil.java
│   ├── ScreenshotUtil.java
│   ├── ExtentManager.java
│   └── TestListener.java
```
⚙️ Framework Features

* Page Object Model (POM) design
* Reusable utility classes
* Explicit waits implementation
* Extent HTML reporting
* Screenshot capture on failure
* TestNG listeners integration

▶️ How to Run Tests

1. Clone the repository:
git clone <your-repo-url>

2. Navigate to project folder:
cd Demo-QASite-Framework
3. Run tests using Maven:
mvn test
📊 Reports

* Extent HTML report is generated inside:
/reports/


* Includes:

  * Pass/Fail status
  * Step logs
  * Failure screenshots

🧪 Test Coverage

* Text Box
* Check Box
* Radio Button
* Web Tables
* Buttons
* Links
* Broken Links & Images

💡 Key Highlights

* Clean and scalable automation framework
* Industry-standard design patterns
* Easy to extend for new test cases
* Suitable for beginners and intermediate QA engineers

👨‍💻 Author

Anand Mopidi

Future Enhancements

* Jenkins CI/CD integration
* Parallel test execution
* Cross-browser testing
* API validation for broken links/images
