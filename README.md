ShuRegister
===========

An electronic register system used as a case study in my Web Architectures module.

This project is a case study in the 12/13 Web Architectures module at Sheffield Hallam University.

It's used to explore various aspects of web Application including:

Configuration management - how the web dev process interacts with git.
Domain modelling - Transitioning from class models to MVC database structures.
Controller development.
RESTful web services.

*Currently Scaffolds still remain.

How to Checkout and Run the Project
===================================

Some info here about how to run the project

Prerequisites

The project needs a running local mysql database called ShuRegister and by default connects to the database using a user called webarch and a password of webarch. Obviously this should be changed in a production environment.

The mysql create database command should be create database ShuRegister default charset utf8 default collate utf8_bin; The character set encoding is important as the web application is capable of accepting UTF8 input.

The project is a groovy/grails project and needs an installed Java7 JDK and installed grails SDK (http://www.grails.org).

Running the app
===============

If you are using a machine that run Debian than in the command line enter :

git clone https://github.com/b1008932/ShuRegister.git

After this has finished use the CD command to enter the ShuRegister directory, "cd ShuRegister" . (hint: you must use the cd ShuRegister command twice)

you can check that you are in the right place by using the " ls " command. If you can see a "grails app" then you are in the right place.

to run the app use the command "grails run-app"

once the app is running it will give you a localhost link. Open the link and you will be able to view the app.

to view the tables, you can use the MYSQL command. "mysql -u webarch -pwebarch ShuRegister"


