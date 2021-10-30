
/**kwota w gorszach */
public class Kwota{
    private int stanKonta;

    /**Konstrukto 2 argumentowy
    * @param zl ilsoc zl
    * @param gr ilosc gr 
    */
    Kwota(int zl, int gr){
        stanKonta = zl*100 + gr;
    }
    
    /**Konstruktor jednoargumentowy
    * @param stan ilosc w groszach
    */
    Kwota(int stan){
        stanKonta = stan;
    }

    /**przeladowanie funkcji, zwraca String z kwota */
    @Override
    public String toString(){
        int zl = stanKonta / 100;
        int gr = stanKonta - (zl*100); 
        return zl + "zl " + gr + "gr";
    }

    /**dodaje do kwoty wartosc
    * @param a
    */
    void dodajStan(int a){
        stanKonta += a;
    }

    /**odejmuje od kwoty wartosc
    *@param a */
    void odejmijStan(int a){
        stanKonta -= a;
    }

    /**zwraca kwote w groszach */
    int getStan(){
        return stanKonta;
    }

    /**ustawia kwote na wartosci podane w
    *@param zl ilosc zl
    *@param gr ilosc gr */
    void set(int zl, int gr){
        stanKonta = zl*100 + gr;
    }

    /**dodaje do siebie wartosci dwoch kwot i zwraca nowa kwote
    *@param a pirwsza kwota
    *@param b drugie kwota */
    public static Kwota dodaj(Kwota a, Kwota b){
        Kwota temp = new Kwota(a.getStan());
        temp.dodajStan(b.getStan());
        return temp;
    }

    /**odejmuje od 
    * @param a konto do obnizenia stanu
    * @param b konto z wartosci stanu obnizajacego
    *@return nowo utworzona kwota
    */ 
    public static Kwota odejmij(Kwota a, Kwota b){
        Kwota temp = new Kwota(a.getStan());
        temp.odejmijStan(b.getStan());
        return temp;
    }
}