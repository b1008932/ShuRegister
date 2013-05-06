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





