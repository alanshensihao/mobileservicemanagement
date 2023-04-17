package models;
import java.io.IOException;

public class Bundle {
    
    public String name;
    public String callingPlan;
    public String messagingPlan;
    public String dataPlan;
    public double monthlyFees;

    // General Bundle constructor that takes bundle name and sets defaults for that bundle type
    public Bundle(String name) {
        switch (name) {
            case "Platinum":
                this.name = "Platinum Bundle";
                this.callingPlan = "Unlimited US & Canada wide calling";
                this.messagingPlan = "Unlimited Messages";
                this.dataPlan = "10 GB";
                this.monthlyFees = 100;

            case "Gold":
                this.name = "Gold Bundle";
                this.callingPlan = "Unlimited Canada wide calling";
                this.messagingPlan = "10K Messages";
                this.dataPlan = "4 GB";
                this.monthlyFees = 80;

            case "Silver":
                this.name = "Silver Bundle";
                this.callingPlan = "100 min free Canada wide calling";
                this.messagingPlan = "5K Messages";
                this.dataPlan = "2 GB";
                this.monthlyFees = 45;

            case "Bronze":
                this.name = "Bronze Bundle";
                this.callingPlan = "30 min free Canada wide calling";
                this.messagingPlan = "250 Messages";
                this.dataPlan = "1 GB";
                this.monthlyFees = 25;

            case "Pick and Choose":
                this.name = name;
                this.callingPlan = "Zero min";
                this.messagingPlan = "Zero messages";
                this.dataPlan = "0 GB";
                this.monthlyFees = 10;

            default :
                throw new IllegalArgumentException("Illegal Argument - Not a recognized bundle name.");
        }
    }

    public Bundle(String name, String callingPlan, String messagingPlan, String dataPlan, double monthlyFees) {
        this.name = name;
        this.callingPlan = callingPlan;
        this.messagingPlan = messagingPlan;
        this.dataPlan = dataPlan;
        this.monthlyFees = monthlyFees;
    }

    public void setPaCCallingOption(String optionName) {
        if (this.name != "Pick and Choose") {
            System.out.println("Cannot modify preconfigured bundle options. No changes made.");
            return;
        }
        switch (optionName) {
            case "Platinum" :
                this.callingPlan = "Unlimited US & Canada wide calling";
            case "Gold" :
                this.callingPlan = "Unlimited Canada wide calling";
            case "Silver" :
                this.callingPlan = "100 min free Canada wide calling";
            case "Bronze" :
                this.callingPlan = "30 min free Canada wide calling";
            default :
                System.out.println("Not a valid PaC calling plan. This account still has the default 0 min.");
        }
    }

    public void setPaCMessagingOption(String optionName) {
        if (this.name != "Pick and Choose") {
            System.out.println("Cannot modify preconfigured bundle options. No changes made.");
            return;
        }
        switch (optionName) {
            case "Platinum" :
                this.messagingPlan = "Unlimited Messaging";
            case "Gold" :
                this.messagingPlan = "10K Messages";
            case "Silver" :
                this.messagingPlan = "5K Messages";
            case "Bronze" :
                this.messagingPlan = "250 Messages";
            default :
                System.out.println("Not a valid PaC messaging plan. This account still has the default 0 messages.");
        }
    }

    public void setPaCDataPlan(String optionName) {
        if (this.name != "Pick and Choose") {
            System.out.println("Cannot modify preconfigured bundle options. No changes made.");
            return;
        }
        switch (optionName) {
            case "Platinum" :
                this.dataPlan = "10 GB";
            case "Gold" :
                this.dataPlan = "7 GB";
            case "Silver" :
                this.dataPlan = "4 GB";
            case "Bronze" :
                this.dataPlan = "2 GB";
            default :
                System.out.println("Not a valid PaC data plan. This account still has the default 0 GB.");
        }
    }
}
