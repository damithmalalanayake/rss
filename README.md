# rss

Spring boot rss feed demo project

### Functionalities

The main purpose of this artifact is to gather latest information through RSS feed and parse them into a json.

* Scheduler task to retrieve and persist information from RSS feed.
* Exposed API to get rss feed information as JSON.
* Scheduler task to regularly cleanup the database.

### Design

* JDK - Java 17
* DB - H2 in-memory database

### Build

-mvn clean install -Dspring.profiles.active=test

### Run

-mvn spring-boot:run  
