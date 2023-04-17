JC = javac
SRCDIR = src
BINDIR = bin

SOURCES := $(SRCDIR)/common/Menu.java			 	\
		  $(SRCDIR)/models/Bundle.java			 	\
		  $(SRCDIR)/models/User.java			 	\
		  $(SRCDIR)/models/ServiceAccount.java	 	\
		  $(SRCDIR)/services/AccountManagement.java \
		  $(SRCDIR)/services/UserManagement.java 	\
		  $(SRCDIR)/services/BundleManagement.java 	\
		  $(SRCDIR)/server/server/MDMServer.java 	\
		  $(SRCDIR)/client/client/MDMClient.java 	\

CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

.PHONY: all clean

all: $(CLASSES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(@D)
	$(JC) -d $(BINDIR) $<

clean:
	$(RM) -r $(BINDIR)