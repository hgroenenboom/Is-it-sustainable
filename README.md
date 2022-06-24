# IsItSustainable 
A website on which a user can lookup the sustainability of any organization. And if they want to, submit data which can add to their overall sustainability report. 

![Website screenshot](./resources/screenshot.png)

## I. Core Concepts

### A. Crowd controlled
All sumbitted data is crowd controlled. Why do we want it to be crown controlled?

- There's an uncountable amount of organizations to submit and research for a single person, using crowd submissions only requires a *review* step per submission and makes this manageable.
- People will be more involved with the idea/concept of sustainability in general.

There are multiple types of possible submissions:

### B. Data quality
In order to make sure the data is useful there are several strategies:

- Reviewing system

    No new user submission immediatally enter the database. First, there is a *staging* state in which reviewing has to be done. This can be done by hand by a selected group of neutral journalists and additionally an AI can filter out harmful/nonsensical requests. Reviewers will make no judgement at all regarding the sustainability of the data or regarding the reliability of a submitted source. Only the quality will be checked. The crowd is in charge of determining what it's worth.

    This ensures only whether the information is:
    - Correctly documented.
    - Not duplicate.
- Specific computing logic:
    - Information is rated based on reliability.
    - Information is rated on sustainability.
    - Sustainability is seperated in 3 simple sections.
- Accounts are required to submit new data.

### C. Multipurpose
This tool should be usable in a variety of ways:
- Sustainable shopping guide.
- Communication/information facilitator.
- Organization evaluation guidelines.

### D. All categories
Using a completely customizable tagging system and by allowing all sorts of organizations, all categories of organizations can be listed:
- Parent/daughter companies.
- Freelancers.
- Foundations.
- Charities.
- Government.
  *etc.*

## II. Documents
- [Conceptual documentation](documentation/Documentation.md)
- [UX design](documentation/UX.md)
- [Technical overview](documentation/Technical_Design.md)

## III. Building
This repository comprises two projects:
1. A Java *Spring* project for the backend.
2. An *Angular* project for the frontend.

#### Prerequisites
- Node package manager (`npm`)
- Java 8 (at least)
    - Maven (`mvn`)
- (L)AMP stack
    *for instance XAMPP*
    - Apache
    - MySQL
    
Make sure MySQL and Apache/NGINX are running.

### 1. Backend
Spring guide: [Spring Boot Guide](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html)

#### 1a. application.properties file
Make sure you have or create a database for your build.

Create an `application.properties` file in the folder `backend` with the following content:
```
spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=<yourdatabaseurl>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

security.basic.enabled=false
management.security.enabled=false

# Currently hardcoded communication port in Angular frontend
server.port=8082
```
Replace the placeholders by an URL to your database and specify the username and password for your database.

#### 1b. Run via maven
*In a CLI in directory 'backend'*
`mvn spring-boot:run`

#### 1c. Or compile via maven and run jar file
*In a CLI in directory 'backend'*
`mvn package`
`java -jar ./target/<GeneratedJarFile> --spring.config.location="./application.properties"`

### 2. Frontend
*In a seperate CLI in directory 'frontend'*

Install node-js dependecies
`npm install`

Compile and host Angular server (on default port)
`ng serve`

### 3. Done!
Navigate in your browser to: [http://localhost:4200/](http://localhost:4200/)

### Shields
![GitHub](https://img.shields.io/github/license/hgroenenboom/Is-it-sustainable)
![GitHub commit activity](https://img.shields.io/github/commit-activity/y/hgroenenboom/Is-it-sustainable)
![GitHub last commit](https://img.shields.io/github/last-commit/hgroenenboom/Is-it-sustainable)

![GitHub repo file count](https://img.shields.io/github/directory-file-count/hgroenenboom/Is-it-sustainable)
![GitHub top language](https://img.shields.io/github/languages/top/hgroenenboom/Is-it-sustainable)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/hgroenenboom/Is-it-sustainable)
![GitHub repo size](https://img.shields.io/github/repo-size/hgroenenboom/Is-it-sustainable)
![GitHub language count](https://img.shields.io/github/languages/count/hgroenenboom/Is-it-sustainable)

![GitHub issues](https://img.shields.io/github/issues-raw/hgroenenboom/Is-it-sustainable)
![GitHub pull requests](https://img.shields.io/github/issues-pr/hgroenenboom/Is-it-sustainable)
![GitHub contributors](https://img.shields.io/github/contributors/hgroenenboom/Is-it-sustainable)
