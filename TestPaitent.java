import java.util.Scanner;//remember to checl
enum BloodType {
    O, A, B, AB
}
enum RhFactor {
    positive,negative
}
class BloodData {
    private BloodType type;
    private RhFactor rh;
    public BloodData() {
        this.type = BloodType.O;
        this.rh = RhFactor.positive;
    }
    public BloodData(BloodType type, RhFactor rh) {
        this.type = type;
        this.rh = rh;
    }
    public BloodType getType() {
        return type;
    }
    public void setType(BloodType type) {
        this.type = type;
    }
    public RhFactor getRh() {
        return rh;
    }
    public void setRh(RhFactor rh) {
        this.rh = rh;
    }
    @Override
    public String toString() {
        return "BloodData{" +
                "type=" + type +
                ", rh=" + rh +
                '}';
    }
}
class Patient {
    private int id;
    private int age;
    private BloodData bloodData;
    public Patient() {
        this.id = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }
    public Patient(int id, int age, BloodData bloodData) {
        this.id = id;
        this.age = age;
        this.bloodData = bloodData;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public BloodData getBloodData() {
        return bloodData;
    }
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", age=" + age +
                ", bloodData=" + bloodData +
                '}';
    }
}
public class TestPatient {
    public static void main(String[] args) { //faulty
        Patient patient1 = new Patient();
        Patient patient2 = getUserPatient();
        Patient patient3 = new Patient(0, 0, new BloodData());

        System.out.println("Default Patient:");
        System.out.println(patient1);

        System.out.println("\nUser Patient:");
        System.out.println(patient2);

        System.out.println("\nDefault BloodData Patient:");
        System.out.println(patient3);
    }
    private static Patient getUserPatient() {
        Scanner scanner = new Scanner(System.in); //faulty
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("age: ");
        int age = scanner.nextInt();
        BloodData bloodData = getUserBloodData();
        return new Patient(id, age, bloodData);
    }
    private static BloodData getUserBloodData() {
        Scanner scanner = new Scanner(System.in); //faulty kinda
        System.out.print("type");
        BloodType type = null;
        String bloodTypeInput = scanner.next().toUpperCase();
        switch (bloodTypeInput) {
            case "O":
                type = BloodType.O;
                break;
            case "A":
                type = BloodType.A;
                break;
            case "B":
                type = BloodType.B;
                break;
            case "AB":
                type = BloodType.AB;
                break;
            default:
                System.out.println("invalid defulting to O.");
                type = BloodType.O;
                break;
        }
        System.out.print("Rh");
        RhFactor rh = null;
        String rhFactorInput = scanner.next().toUpperCase();
        switch (rhFactorInput) {
            case "+":
                rh = RhFactor.positive;
                break;
            case "-":
                rh = RhFactor.negative;
                break;
            default:
                System.out.println("invalid defulting to positive.");
                rh = RhFactor.positive;
                break;
        }
        return new BloodData(type, rh);
    }
}
