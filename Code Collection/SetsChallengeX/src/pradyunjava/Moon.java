package pradyunjava;

//moon class
public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }

    @Override
    boolean addSatellite(HeavenlyBody moon) {
        System.out.println("Moons cannot have satellites.");
        return false;
    }
}
