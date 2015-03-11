<<<<<<< HEAD
# A complete nth Fibonacii number generation web api using Gradle+ Dropwizard +Heroku Deployment specifications
=======
# Dropwizard + Gradle = &hearts; [![Build Status](https://secure.travis-ci.org/smarchive/dropwizard-gradle.png)](http://travis-ci.org/smarchive/dropwizard-gradle)

Minimal SETUP of getting Dropwizard going with Gradle.


## Gotchas

You need Gradle 1.1 or higher, otherwise you'll run into a [dependency resolution bug](http://issues.gradle.org/browse/GRADLE-2285).

## Jar File creation

This example is using the [Gradle OneJar Plugin](https://github.com/rholder/gradle-one-jar) which will create
a JAR file of the project including all dependencies, similar to the [Maven Assembly Plugin](http://maven.apache.org/plugins/maven-assembly-plugin/)
or the [Maven Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/).

To create a JAR with all dependencies just run `./gradlew stage`. The resulting JAR will be saved as `./build/libs/dropwizard-gradle-master.jar`.

You can simply run the application with `java -jar build/libs/dropwizard-gradle-master server src/dist/config/helloworld.yml`.

If you want ot deply it to Heroku, follow below steps
: git clone git@github.com:KuldeepAshok/Hello-world.git
: heroku login
loginID:password

:cd hello-world

:heroku create
:git push heroku master
:heroku ps:scale web=1
:heroku open

It will provide you a link which should be appended with /kuldeep/n where n is number for which nth fibonacii number should be calculated
Ex: For me provided linl was : https://powerful-taiga-2449.herokuapp.com/ and final link was https://powerful-taiga-2449.herokuapp.com/kuldeep/1000000

## Gradle Application Plugin

An alternative to creating a fat JAR is using the [Gradle Application Plugin](http://www.gradle.org/docs/current/userguide/application_plugin.html).



You can also use the `run` task to start the application.
