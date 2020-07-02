public class UsCrimeObject {

    private int year;

    private int population = 1;
    private int violentCrime = 2;
    private int violentCrimeRate = 3;
    private int murderNonnegligentManslaughter = 4;
    private int murderNonnegligentManslaughterRate = 5;
    private int rape = 6;
    private int rapeRate = 7;
    private int robbery = 8;
    private int robberyRate = 9;
    private int aggravatedAssault = 10;
    private int aggravatedAssaultRate = 11;
    private int propertyCrime = 12;
    private int propertyCrimeRate = 13;
    private int burglary = 14;
    private int burglaryRate = 15;
    private int larcenyTheft = 16;
    private int larcenyTheftRate = 17;
    private int motorVehicleTheft = 18;
    private int motorVehicleTheftRate =19;

    private float[] values = new float[20];

    UsCrimeObject(String line) {
        line = line.replace("{", "");
        line = line.replace("}", "");
        line = line.replace(" ", "");
        String[] stringValues = line.split(",");
        year = Integer.valueOf(stringValues[0]);
        for (int i = 0; i < 20; i++) {
            values[i] = Float.valueOf(stringValues[i]);
        }
    }

    int getYear() {
        return year;
    }

    float getPopulation() {
        return values [population];
    }


    public float getViolentCrime() {
        return values [violentCrime];
    }

    public float getViolentCrimeRate() {
        return values [violentCrimeRate];
    }

    public float getMurderNonnegligentManslaughter() {
        return values [murderNonnegligentManslaughter];
    }

    float getMurderNonnegligentManslaughterRate() {
        return values [murderNonnegligentManslaughterRate];
    }

    public float getRape() {
        return values [rape];
    }

    public float getRapeRate() {
        return values [rapeRate];
    }

    public float getRobbery() {
        return values [robbery];
    }

    float getRobberyRate() {
        return values [robberyRate];
    }

    public float getAggravatedAssault() {
        return values [aggravatedAssault];
    }

    public float getAggravatedAssaultRate() {
        return values [aggravatedAssaultRate];
    }

    public float getPropertyCrime() {
        return values [propertyCrime];
    }

    public float getPropertyCrimeRate() {
        return values [propertyCrimeRate];
    }

    public float getBurglary() {
        return values [burglary];
    }

    public float getBurglaryRate() {
        return values [burglaryRate];
    }

    public float getLarcenyTheft() {
        return values [larcenyTheft];
    }

    public float getLarcenyTheftRate() {
        return values [larcenyTheftRate];
    }

    public float getMotorVehicleTheft() {
        return values [motorVehicleTheft];
    }

    public float getMotorVehicleTheftRate() {
        return values [motorVehicleTheftRate];
    }
}
