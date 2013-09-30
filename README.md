scala-spray-heroku
==================

Bolierplate for deploying a spray app to Heroku

The particular issues in a spray app to be deployed to Heroku are:

##Procfile
Este archivo indica que lo que se ejecutará en Heroku será el _start_.
El _start_ se genera a partir de la ejecución de stage via sbt.
El _stage_ es posible ejecutarlo gracias a que se está usando el _SbtStartScript_ de Typesafe.


##buid.sbt

Las partes importantes del build.sbt (con respecto al deploy en Heroku) son las siguientes:

*import com.typesafe.sbt.SbtStartScript*

_seq(SbtStartScript.startScriptForClassesSettings: _*)_

Este plugin permitirá la ejecución de la tarea stage (una extensión de sbt) que generará el start.

##Compilación
_sbt clean compile stage_

##Ejecución

###Local

_foreman start_ 

###Heroku
git push Heroku master
