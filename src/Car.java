public class Car extends Vehicle {
    private int numberOfDoors;
    private double fee;
    private boolean hasAirbags;

    public Car(String model, int year, double basePrice, boolean hasAirbags, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
        this.hasAirbags = hasAirbags;
    }

    @Override
    public double calculateInsuranceFee() {
        if (hasAirbags) {
            fee += 500;
        }
        fee += getBasePrize() * 0.05;
        return fee;

    }

    @Override
    public String toString() {
        return "Model: " + getModel() + ". Year: " + getYear() + ". Base Price: " + getBasePrize() + ". ID: " + getId() + ". Number of doors: " + numberOfDoors + ". Has Airbags: " + hasAirbags + ". Insurance Fee: " + calculateInsuranceFee();
    }

    @Override
    public void performService() {
        System.out.println("Driving to destination");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }
}
