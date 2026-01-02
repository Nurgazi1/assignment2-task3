public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen;
    private String model;
    private int year;
    private double basePrize;

    Vehicle() {
        id = idGen++;
    }

    public Vehicle(String model, int year, double basePrize){
        this();
        setModel(model);
        setYear(year);
        setBasePrize(basePrize);
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            this.model = model;
        }

    }

    public void setYear(int year) {
        if (year < 1950 || year > 2026) {
            throw new IllegalArgumentException();
        }
        else {
            this.year = year;
        }
    }

    public void setBasePrize(double basePrize) {
        this.basePrize = basePrize;
    }

    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public int getId() {
        return id;
    }
    public double getBasePrize() {
        return basePrize;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }
    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "Model: " + model + ". Year: " + year + ". Base Price: " + basePrize + ". ID: " + id;
    }
}
