echo off
cd src
javac -d ../bin -target 1.8 -source 1.8 Main.java Renderer.java Window.java Player.java Obstacle.java HoleInTheWall.java
cd ../bin
java fallingSky/Main