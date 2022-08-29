# How to actually run
First we created created lexer using javacc

```
javacc jtb.out.jj
```

File "TokenMgrError.java" does not exist.  Will create one.
File "ParseException.java" does not exist.  Will create one.
File "Token.java" does not exist.  Will create one.
File "JavaCharStream.java" does not exist.  Will create one.

Next, we create parser
```
java -jar jtb132.jar JT.jj
```

We are ready for this assignment now!
