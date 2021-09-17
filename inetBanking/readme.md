# Framework Design as per CI-CD Pipeline

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Framework</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
    <li><a href="#How-to-run-automation-test-for-web-application">How to run automation test for web application</a></li>
      <li><a href="#Publishing-Reports">Publishing Reports
</a></li>  
</ol>
</details>

## About Framework

Framework is build with hybrid framework which is combination of TestNG and BDD Framework. It is easy to use and for arranging testcases.

Framework is support gherkin language it will easy to read content for normal user as well.

In this framework we use Jenkins CI-CD for continuous integration.

Framework is execute in virtual machine using docker container which help to execute framework virtually

Allure report is used in this project for reporting which shows detailed summary of report.

## Getting Started

### Prerequisites

##### Setup / Required Tools

* jdk 8 and above
* jenkins [Latest Version]
* Allure [Latest Version]
* Maven 
* Cucumber & TestNG plugins install with IDE [Latest Version]
* Docker 
* Any IDE Eclipse or IntelliJ [Latest Version] 


## How to run automation test for web application

1. Pull Docker Images and Run docker container
2. Open jenkins server 
3. Add project into jenkins and build project OR Execute without Jenkins follow the steps
4. Execute Targeted testng.xml file using testng runner OR
5. mvn test package [Running all cucumber tests / it will execute all testng.xml's playlist files]



## Publishing Reports

Allure reports is  generating test result data and screenshot in that folder. You can generate report after this. Follow the below steps.

Add this dependency ``allure-testng`` in pom.xml file

Add post build action in Jenkin project configuration.

Add allure report
Add path as:

``target/allure-results``

Allure report will display Project dashboard as well as in project directory in allure-report folder

#### Annotations
*

#### Common steps
*

#### Validation steps
*

#### Login
*

#### Registration
*

#### Logout
*
