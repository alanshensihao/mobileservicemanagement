package models;

public class Bundle {
    
    public String name;
    public String callingPlan;
    public String messagingPlan;
    public String dataPlan;
    public double monthlyFees;

    public Bundle(String name, String callingPlan, String messagingPlan, String dataPlan, double monthlyFees) {
        this.name = name;
        this.callingPlan = callingPlan;
        this.messagingPlan = messagingPlan;
        this.dataPlan = dataPlan;
        this.monthlyFees = monthlyFees;
    }

}
