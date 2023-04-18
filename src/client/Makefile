GS = -g
JC = javac
JR = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java -Xlint

# This uses the line continuation character (\) for readability
# You can list these all on a single line, separated by a space instead.
# If your version of make can't handle the leading tabs on each
# line, just remove them (these are also just added for readability).
CLASSES = \
	MDMClient.java \
	Command.java \
	UI.java

default: classes

run:
	$(JR) MDMClient

classes: $(CLASSES:.java=.class)

clean:
	 $(RM) *.class
