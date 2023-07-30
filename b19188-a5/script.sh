rm testcase/*.class
rm testcase-output/*.class
cd validator

#!/bin/bash

rm *.class
rm visitor/*.class
rm syntaxtree/*.class


java -jar ./jtb.jar friendTJMem.jj

# Generate Parser
javacc jtb.out.jj

# Compile Classes
javac Main.java

cd ..

cd assn
javac *.java

cd ..


for file in TC21 TC02
do
    echo "$file"
    cd assn
    java Main < ../testcase/$file.java > ../testcase-output/$file.java
    cd ..
    cd validator
    
    java Main < ../testcase-output/$file.java
    # java Main < ../tcOUT/$file.java
    
    
    
    cd ..
    cd testcase/
    javac $file.java
    echo "input"
    java $file
    
    cd ..
    cd testcase-output/
    javac $file.java
    echo "output"
    java $file
    
    cd ..
    
done
