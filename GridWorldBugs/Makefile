BUGS = CircleBug.java SpiralBug.java ZBug.java DancingBug.java
RUNNERS = $(BUGS:%.java=%Runner.java)
BUGOBJS = $(BUGS:%.java=%.class)
RUNNEROBJS = $(RUNNERS:%.java=%.class)


.SUFFIXES: .java .class

.java.class:
	javac -cp ./gridworld.jar:. $<

all: $(RUNNEROBJS)

$(RUNNEROBJS): $(BUGOBJS) $(RUNNERS)

$(BUGOBJS): $(BUGS)

clean:
	$(RM) *.class

