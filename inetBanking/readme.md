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
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>

## About Framework

Framework is build with hybrid framework which is combination of TestNG and BDD Framework. It is easy to use and for arranging testcases.

Framework is helpful for writing testcases and easy access of them.

In this framework we use Jenkins CI-CD for continuous integration.

Framework is execute in virtual machine using docker container which help to execute framework virtually

Allure report is used in this project for reporting which shows detailed summary of report.

## Getting Started 

### Prerequisites

#### System Configuration
* jdk 8 and above
* jenkins 
* Allure
* Maven 
* Docker
* Eclipse or IntelliJ

### Installation
* First we need to install jdk in system for that go to: 

   <https://www.oracle.com/in/java/technologies/javase-downloads.html> 
download jdk executable file and run executable file
* Set system environmental 

   ``
JAVA_HOME "C:\Program Files\Java\jdk-11.0.12"
``
* Set
		
		Path as "C:\Program Files\Java\jdk-11.0.12\bin"
* Download Eclipse or IntelliJ from browser and install.
* For maven go to:

   <https://maven.apache.org/download.cgi>
and download binary zip archive 

* Set system variable 

  	 ``MAVEN_HOME to "C:\apache-maven-3.8.1"``

* also add M2_HOME to 

  	 ``"C:\apache-maven-3.8.1"``
* Download Allure and seth system variable 
		
		path to "C:\allure-2.14.0\allure-2.14.0\bin"
* For jenkins go to: 

  	 <https://www.jenkins.io/download/>
* For run jenkins server open command prompt go to path where jenkins.war file is store then hit command: 

		java -jar jenkins.war
* For Docker go to: 

  <https://www.docker.com/products/docker-desktop>
  
  download docker desktop and install and open windows powershell and enable wsl2 using following command: 
  
  ``wsl --set-default-version 2``
  
  then download ubuntu LTS version from Microsoft store.

## Usage

1. To execute framework first we need to ready docker container for that first we need to pull docker images and run docker container.
    * To pull docker images open powershell and run command.
        * ``docker pull selenium/hub``
        * ``docker pull selenium/node-chrome-debug``
        * ``docker pull selenium/node-firefox-debug``
    * To run container run command 
        * ``docker run -d -p 4545:4444 —name selenium-hub selenium/hub``
        * ``docker run -d -P —link  selenium-hub:hub selenium/node-chrome-debug``
        * ``docker run -d -P —link  selenium-hub:hub selenium/node-firefox-debug``
    * For checking container status execute command in powershell
        * ``docker ps -a``
    * For remove container from docker execute command in powershell
        * ``docker rm -f $(docker ps -a -q)``

2. Next step is to run jenkins server for that 
    * For creating jenkins server execute command into cmd
      * ``java -jar -jenkins.war``
      * Bydefault it will run on 
         ``http://localhost:8080``
    * Open jenkins using port 8080
    * Create new project.
    * Select freestyle project
    * Open build configure go to build and select add build step select Execute windows batch command then give command for start docker container
       * ``docker run -d -p 4545:4444 —name selenium-hub selenium/hub``
       * ``docker run -d -P —link  selenium-hub:hub selenium/node-chrome-debug``
       * ``docker run -d -P —link  selenium-hub:hub selenium/node-firefox-debug``
    * Again select add build step select Execute windows batch command and give command
      * ``cd "path of the framework"``
      * ``mvn clean test``
    * For allure report select post build action in jenkins project configuration and select allure report
      * Give path ``target\allure-results``
3. Framework is execute successful after step 2

