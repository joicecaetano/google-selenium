# Google Selenium Test
This project tests the Google Search page using [Selenium](https://www.selenium.dev/)

## Prerequisites
- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome)

## Installing and running the tests
After installing the prerequisites, run the installation of the dependencies of the project. In the main folder of the project, run the following command

`mvn clean install -DskipTests`

To execute the tests, run:

`mvn clean test`

This will open the Google Chrome web browser and will execute the tests against the Google search page.

## Next steps
- Add visual information to verify test results.
- Add more test cases, to test more elements of the page and navigation aspects
- Add support for more web browsers, like Firefox and Edge
- Improve documentation with detail of each test case