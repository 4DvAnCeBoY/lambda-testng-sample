# lambda-testng-sample

## Environment Setup

1. Global Dependencies
    * [Install Maven](https://maven.apache.org/install.html)
2. Sauce Credentials
    * Update Username and authkey in TestNGTodo.java:
3. Project Dependencies
	* Check that Packages are available
	```
	$ cd Java-TestNg-Selenium
	$ mvn test-compile
	```
	* You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file. The updated packages may or may not be compatible with your code.
	```
	$ mvn versions:display-dependency-updates
	```
## Running Tests

Execute Test :
	```
	$ mvn test
	```
