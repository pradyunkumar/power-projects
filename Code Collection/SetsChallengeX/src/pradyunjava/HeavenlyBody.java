package pradyunjava;

import java.util.HashSet;
import java.util.Set;

//abstract class Heavenly Body simulates a type of body in space and the external attributes
abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;             //time of obital period
    private final Set<HeavenlyBody> satellites;     //set of the body's satellites

    enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    //constructor that takes in paramaters for the body
    HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {

        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }
    //getters
    double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    Key getKey() {
        return key;
    }
    Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    //adds a satellite to the set if it does not already exist
    boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }




    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    //Key class dictates the identity of a body
    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) {
                return(this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }


}
