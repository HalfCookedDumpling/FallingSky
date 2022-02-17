echo off

cd bin

jar -cfm FallingSky.jar Manifest.txt fallingSky\*.class

copy FallingSky.jar ..\jars

del FallingSky.jar