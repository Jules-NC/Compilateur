All:
	java -cp ./javacc.jar javacc Jagger.jj
	javac *.java
	java Jagger

clean:
	rm *.class
	rm *.ctxt

