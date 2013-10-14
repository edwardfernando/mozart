#mozart

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