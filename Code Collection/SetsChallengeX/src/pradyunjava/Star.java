package pradyunjava;

public class Star extends HeavenlyBody{

    public Star(String name) {
        super(name, 0, BodyTypes.STAR);
    }

    @Override
    boolean addSatellite(HeavenlyBody moon) {
        if((moon.getKey().getBodyType() == BodyTypes.PLANET) ||
                (moon.getKey().getBodyType() == BodyTypes.DWARF_PLANET)){
            System.out.println("Planet " + moon.getKey().getName() + " added to" + this.getKey().getName());
            return super.addSatellite(moon);
        } else {
            System.out.println("This body is not a planet.");
            return false;
        }
    }
}
