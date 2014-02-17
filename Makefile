all: Fibonacci.class Factorial.class Maze.class Knight.class Queens.class

.SUFFIXES : .java .class

.java.class: 
	javac $<

clean:
	$(RM) *.class
