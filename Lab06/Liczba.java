abstract public class Liczba {
    @Override
    public String toString(){
        return "klasa Liczba";
    }

    abstract double toDouble();
}

class LiczbaWymierna extends Liczba{
    int L;
    int M;
    LiczbaWymierna(){
        L = 0;
        M = 1;
    }

    LiczbaWymierna(int l, int m){
        L = l;
        M = m;
    }

    @Override
    public String toString(){
        return "Wartosc: " + L + "/" + M;
    }

    @Override
    public double toDouble(){
        return L/(double)M;
    }
}

class LiczbaOdZeraDoJeden extends Liczba{
    double value;
    LiczbaOdZeraDoJeden(){
        value = 0.0;
    }

    LiczbaOdZeraDoJeden(double val){
        if(val <= 1 && val >=0){
            value = val;
        }
        else{
            System.out.println("Not a good value, setting to 0");
            value = 0;
        }
    }

    @Override
    public String toString(){
        return "Wartosc: " + value;
    }

    @Override
    public double toDouble(){
        return value;
    }
}
