all: Fibonacci.class Factorial.class Maze.class

.SUFFIXES : .java .class

.java.class: 
	javac $<

clean:
	$(RM) *.class
