public class Bus extends Vehicle {
    int passangrCapacity;
    boolean bodyInjuryFee;
    double fee;

    public Bus(String model, int year, double basePrice, int passangrCapacity, boolean bodyInjuryFee) {
        super(model, year, basePrice);
        this.passangrCapacity = passangrCapacity;
        this.bodyInjuryFee = bodyInjuryFee;
    }



    @Override
    public double calculateInsuranceFee() {
        if (bodyInjuryFee) {
            fee += 1000;
        }
        fee += getBasePrize() * 0.1;
        return 0;
    }

    @Override
    public String toString() {
        return "Model: " + getModel() + ". Year: " + getYear() + ". Base Price: " + getBasePrize() + ". ID: " + getId() + ". Passanger capacity: " + passangrCapacity + ". Has Airbags: " + bodyInjuryFee + ". Insurance Fee: " + calculateInsuranceFee();
    }

    @Override
    public void performService() {
        System.out.println("Picking up passangers.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 1000;
    }
}
