🚀 OpenCartV121 – Selenium Automation Framework

This project is a Selenium Automation Testing Framework developed using Java,
TestNG, Maven, and Page Object Model (POM) for an OpenCart e-commerce application.
The framework follows industry best practices and is CI/CD ready.

--------------------------------------------------

🛠 TECH STACK
- ☕ Java
- 🌐 Selenium WebDriver
- 🧪 TestNG
- 📦 Maven
- 🧩 Page Object Model (POM)
- 📊 Extent Reports
- 🔁 Jenkins (CI/CD)
- 🧑‍💻 Git & GitHub

--------------------------------------------------

📂 PROJECT STRUCTURE

OpenCartV121
|
|-- src/test/java
|   |-- pageObjects      (Page Object classes)
|   |-- testCases        (Test cases)
|   |-- testBase         (Base setup and WebDriver configuration)
|   |-- utilities        (Excel utility, DataProviders, Reports)
|
|-- src/test/resources
|   |-- config.properties
|   |-- log4j2.xml
|
|-- testData             (Excel test data)
|-- testng.xml           (TestNG suite file)
|-- pom.xml              (Maven dependencies)
|-- .gitignore
|-- README.txt

--------------------------------------------------

🧪 AUTOMATED TEST SCENARIOS
- ✅ User Account Registration
- ✅ Login Functionality
- ✅ Data-Driven Login Testing
- ✅ Product Search
- ✅ Add to Cart
- ✅ Checkout Process
- ✅ End-to-End E-commerce Flow
- ✅ Cross Browser Testing

--------------------------------------------------

▶️ HOW TO RUN THE TESTS

Run using Maven:
mvn clean test

Run using TestNG suite:
mvn clean test -DsuiteXmlFile=testng.xml

Run using Jenkins:
- Create Jenkins job
- Connect GitHub repository
- Run Maven goal: clean test

--------------------------------------------------

📊 REPORTS AND SCREENSHOTS

Test execution reports and screenshots are generated automatically during runtime.
These files are excluded from GitHub using .gitignore as per industry best practices.
Fresh reports are generated on every execution.

--------------------------------------------------

✨ KEY FEATURES
- 📌 Page Object Model based framework
- ♻️ Reusable and maintainable code
- ⚙️ Centralized WebDriver management
- 📑 Data-driven testing using Excel
- 🌍 Cross browser execution support
- 🔁 Jenkins CI compatible
- 🧼 Clean and professional project structure

--------------------------------------------------

👨‍💻 AUTHOR
Mohammad Rehan Fazal  
QA / Automation Tester  
GitHub: https://github.com/rehan2352

--------------------------------------------------

📌 NOTE
This project is created for learning and real-world automation practice
and follows professional QA automation standards.
