/**baza danych z kontami */
public class Bank{
    private static Konto listaKont = null;
    private static Konto root = null;

    /**tworzy nowe konto w bazie
    *@param numer tworzonego konta */
    static void utworzKonto(String numer){
        if(listaKont == null){
            Konto temp = new Konto(numer, new Kwota(0)); 
            listaKont = temp;
            root = temp;
        }
        else{
            while(listaKont.getNext() != null){
                listaKont = listaKont.getNext();
            }
            listaKont.setNext(new Konto(numer, new Kwota(0)));
        }
        listaKont = root;
    }

    /**zwraca informacje o wszystkich kontach w banku */
    @Override 
    public String toString(){
        String ret = "";
        while(listaKont != null){
            ret += listaKont;
            ret += " ; ";
            listaKont = listaKont.getNext();
        }
        listaKont = root;
        return ret;
    }

    /**znajduje konto po numerze i dodaje do niego obieky Kwota
    *@param numer konta do wplaty
    *@param kwota kwota do wplaty */
    public void wplataNaKonto(String numer, Kwota kwota){
        while(listaKont.getNumer() != numer){
            if(listaKont.getNext() != null)
            {
                listaKont = listaKont.getNext();
            }
        }
        if(listaKont.getNumer() == numer){
            Kwota temp = new Kwota(0,0);
            temp = Kwota.dodaj(listaKont.getStan(), kwota);
            listaKont.setStan( temp );
        }
        listaKont = root;
    }

    /**znajduje konto po numerze i zmniejsza stan o podana kwote
    *@param numer numer konta
    *@param kwota do wyplacenia */
    public void wyplataZKonta(String numer, Kwota kwota){
        while(listaKont.getNumer() != numer){
            if(listaKont.getNext() != null)
            {
                listaKont = listaKont.getNext();
            }
        }
        if(listaKont.getNumer() == numer){
            Kwota temp;
            temp = Kwota.odejmij(listaKont.getStan(), kwota);
            listaKont.setStan( temp );
        }
        listaKont = root;
    }

    /**zwraca stan konta jako obiekt Kwota
    *@param numer string z numereme konta */
    public Kwota stanKonta(String numer){
        while(listaKont.getNumer() != numer){
            if(listaKont.getNext() != null)
            {
                listaKont = listaKont.getNext();
            }
        }
        Kwota temp = null;
        if(listaKont.getNumer() == numer){
            temp = new Kwota(listaKont.getStan().getStan());
        }
        listaKont = root;
        return temp;
    }
}