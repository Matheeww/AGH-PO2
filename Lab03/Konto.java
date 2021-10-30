/**informacje o koncie */
public class Konto{
    private String numerKonta;
    private Kwota kwota;
    private Konto next = null;

    /**konstruktor dwuargumentowy
    *@param numer numer konta
    *@param stan stan konta */
    Konto(String numer, Kwota stan){
        numerKonta = numer;
        kwota = new Kwota(stan.getStan());
    }

    /** oddaje nastepe konto  */
    public Konto getNext(){
        return next;
    }

    /** zwraca numerKonta */
    public String getNumer(){
        return numerKonta;
    }

    /**ustawia nastepne konto w lisicie */
    public void setNext(Konto toSet){
        next = toSet;
    }

    /** zwraca obiekt Kwota ze stanem konta */
    public Kwota getStan(){
        Kwota temp = new Kwota(kwota.getStan());
        return temp; 
    }

    /**ustawia obiekt Kwota na koncie na podana kwote */
    public void setStan( Kwota danaKwota){
        kwota.set(danaKwota.getStan() / 100, danaKwota.getStan() - ((danaKwota.getStan()/100)*100));
    }

    /**zwraca info o koncie w stringu */
    @Override
    public String toString(){
        return "[" + numerKonta + "] " + kwota;
    }
}