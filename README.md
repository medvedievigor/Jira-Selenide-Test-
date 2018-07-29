# Jira-Selenide-Test-
Tests of  Jira by selenide

This is  project for testing of  functionality in Jira software.

Project uses Selenium-Grid server.

To run on local environment:

Download selenium-server-standalone.jar https://www.seleniumhq.org/download/
Download binraies for browser and put them in the same folder with selenium-server-standalone.jar
https://github.com/mozilla/geckodriver/releases
http://chromedriver.chromium.org/
Start GRID server
java -jar selenium-server-standalone-3.13.0.jar -role hub
java -jar selenium-server-standalone-3.13.0.jar -role node
Run test mvn clean test
