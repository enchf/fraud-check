# Fraud Check Project

Implementation of a sample fraud check module

## Assumptions

- Given an user, identified by phone and email, evaluate and give index of how much fraudulent his identity could be.
- User can be provided from internal database, externally, from a chain processor, etc.
- Fraud check logic is decoupled using IoC/DI to be injected in any flow (web, batch, etc).
- From the articles I read about the problem, most of them use machine learning solutions.
- I know some external tools that perform the evaluation heuristics, so I decided to delegate them the main logic.
- Email and phone values are validated against proven regular expressions.

## Technologies used

- Enforce the use of Gradle as a CLI to run tests, compile, build and run the application.
- Avoid any special manual configuration at performing any of the above activities.
- The application is structured using Spring, to let the fraud check work as an isolated module.
- Application skeleton is generated using Spring Initializr.
- Lombok project is used to support the application in terms of common Java boilerplate elimination.
- In order to show a working demo, a web endpoint is enabled using Spring Web to perform calls to the fraud evaluation.
- Module is left scalable to support multiple fraud evaluators, configured through application.properties.
- A class that consolidates the results is left open and injectable too.
- Unit testing is enforced. Any logic related to infrastructure classes or heuristics is tested prior to development.
- External dependencies are mocked during testing, to left unit test classes run standalone.

## Application setup and run

Clone the application and run `gradle build` to compile, execute testing and build.

To run the application, run `gradle bootRun`. By default it will run using `prod` as the default environment.
To run the application in `dev` mode, run `gradle bootRun -Penv=dev`.

The fraud check module is run in web at `http://localhost:8080/fraud-check?phone={phone}&email={email}`.
Substitute the place holder by values to receive an evaluation.
Also a `/health` endpoint is provided to test if the application is running.

To run the test, use Gradle as `gradle clean test`.
If you use IntelliJ, make sure you add `-Dspring.profiles.active=dev` in the VM options of Running configurations.

## Changelog

- [EX1] Project setup. Using Java 8, Lombok, Spring and Gradle as base technologies.
- [EX2] Enable configurable properties from Gradle.
- [EX3] Create some Phone and Email fraud scorers.
