.SUFFIXES: .java .class

all: CircleBugRunner.class SpiralBugRunner.class ZBugRunner.class \
	DancingBugRunner.class JumperRunner.class

CircleBugRunner.class: CircleBugRunner.java CircleBug.class
ZBugRunner.class: ZBugRunner.java ZBug.class
SpiralBugRunner.class: SpiralBugRunner.java SpiralBug.class
DancingBugRunner.class: DancingBugRunner.java DancingBug.class
JumperRunner.class: JumperRunner.java Jumper.class

.java.class:
	javac -cp ./gridworld.jar:. $<

clean:
	$(RM) *.class

