
abstract class Rakieta{
    static String producent(){
        return "NASA";
    } 

    static class Zaloga{
        int z = 1;
        Zaloga(){
            z = 0;
        }
    }

    class Ladownik implements PojazdKosmiczny{}

    public Apollo ladownikApollo(){
        Rakieta r = new SaturnV(5);
        return new Apollo(r);
    }
}


class Apollo extends Rakieta.Ladownik{
    Apollo(Rakieta r){
        r.super();
    }
}

interface Latajacy{
    default void startuj(){}
}

interface Odrzutowy {
    default void ustawCiag(int c){

    }
}

interface PojazdKosmiczny extends Odrzutowy, Latajacy{
    String BAZA = "Kennedy Space Center";
}

class SaturnV extends Rakieta implements PojazdKosmiczny{
    int i = 0;
    Zaloga zal = null;

    SaturnV(int newi){
        i = newi;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " nr " + i;
    }


}


class Wahadlowiec extends Jezdzi implements PojazdKosmiczny{
    String name = "";

    Wahadlowiec(String newName){
        name = newName;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + name;
    }
}

abstract class Jezdzi{
    void skrecKola(){}
}

class JetCar extends Jezdzi implements Odrzutowy{

}


class Caracal implements Latajacy{

}


public class Lab07{
    public static void main(String[] args){

    }
}