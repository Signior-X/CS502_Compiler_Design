rm *.class
rm */*.class
javac *.java
java Main < TC02.java > validator/Out.java


cd validator
javac *.java
java Main < Out.java > spills


java TC02 > obtainedRes
cd ..
java TC02 > actualRes
