#mozart

<i>RESTful API based on Java cooked using REST easy framework, mixed with one tea spoon of spring framework, 10 grams of aspectJ, hibernate, and other secret recipes. Mixed with love and hopefully it will taste good.</i>

<b>Prerequisites</b>

* Pre-installed JDK version > 1.6 
* MySql version > 5
* apache-tomcat server
* maven

<b>Running</b>

* Run mysql server and execute mozart-api.sql file

* clone mozart-core (https://github.com/edwardfernando/mozart-core) to your local machine and run:

```sh
mvn clean install
```

* clone <b>this</b> project to your local machine and run:

```sh
mvn clean install
```

and, after that:

```sh
mvn tomcat:run
```