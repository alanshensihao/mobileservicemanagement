JC = javac
SRCDIR = src
BINDIR = bin

SOURCES := $(SRCDIR)/client/client/MDMClient.java 	\
		  $(SRCDIR)/services/UserManagement.java 	\
		  $(SRCDIR)/common/Menu.java			 	\
		  $(SRCDIR)/models/Bundle.java			 	\
		  $(SRCDIR)/models/User.java			 	\
		  $(SRCDIR)/models/ServiceAccount.java	 	\
		  $(SRCDIR)/server/server/MDMServer.java 	\
		  $(SRCDIR)/services/AccountManagement.java \
		  $(SRCDIR)/services/BundleManagement.java 	\

CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

.PHONY: all clean

all: $(CLASSES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	$(JC) -d $(BINDIR) $<

clean:
	$(RM) -r $(BINDIR)