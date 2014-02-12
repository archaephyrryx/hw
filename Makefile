all: Fibonacci.class Factorial.class

.SUFFIXES : .java .class

.java.class: 
	javac $<

clean:
	$(RM) *.class
