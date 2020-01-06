package pradyunjava;

//planet class
public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    //override of add Satellite to ensure that the satellite added is a moon
    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.MOON) {
            System.out.println("Moon " + moon.getKey().getName() + " added to" + this.getKey().getName());
            return super.addSatellite(moon);
        } else {
            System.out.println("This body is not a moon.");
            return false;
        }
    }
}
