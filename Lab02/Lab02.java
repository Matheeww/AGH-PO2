public class Lab02 {
    public static void main(String[] args){

        Obywatel jeden = new Obywatel("12345678910","Adam","Myszko");

        System.out.println(jeden.getPesel());
        System.out.println(jeden.informacje());
        System.out.println(jeden.getImie());
        System.out.println(jeden.getNazwisko());
        System.out.println(jeden);
        Obywatel dwa = new Obywatel("09876543211","Piotr","Kowalski");
        System.out.println(dwa);
        Obywatel trzy = new Obywatel("52345678963", "Kuba", "Trzeci");
        Obywatel cztery = new Obywatel("34567890342","Jan","Janowski");
        System.out.println(Obywatel.iloscKlas());

        BazaLudnosci baza = new BazaLudnosci();
        baza.dodaj(jeden);
        baza.dodaj(dwa);
        baza.dodaj(trzy);
        baza.dodaj(cztery);

        System.out.println("left from root " + baza.mRoot.left.mObywatel);
        System.out.println(baza.wyszukaj(jeden.getPesel(),jeden.getImie()));
        System.out.println(baza.wyszukaj(dwa.getPesel(),dwa.getImie()));

        baza.wypiszDrzewo();
    }
}


class Obywatel{

    String mPesel;
    String mImie;
    String mNazwisko;
    static int ilosc;

    Obywatel(String pesel, String imie, String nazwisko){
        mPesel = pesel;
        mImie = imie;
        mNazwisko = nazwisko;
        ilosc++;
    }

    public String getPesel(){
        return mPesel;
    }

    public String getImie(){
        return mImie;
    }

    public String getNazwisko(){
        return mNazwisko;
    }

    @Override
    public String toString(){
        return mPesel + " " + mImie + " " + mNazwisko;
    }

    public String informacje(){
        return this.toString();
    }

    static public int iloscKlas(){
        return ilosc;
    }
    
}


class BSTNode{
    BSTNode p, left, right;
    String key = "00000000000";
    String val;
    Obywatel mObywatel;

    BSTNode( String pesel, String imie, Obywatel obywatel){
        key = pesel;
        val = imie;
        mObywatel = obywatel;
        System.out.println("New BSTNode " + mObywatel);
    }

    BSTNode left(){
        return left;
    }

    static boolean BSTInsert(BSTNode root, BSTNode n){ 
        long start = System.nanoTime();

        BSTNode y = null;
        BSTNode x = root;
        n.left = null;
        n.right = null;
        
        long nKey = Long.parseLong(n.key);
        long xKey = Long.parseLong(x.key);
        
        while(x != null){
            if(n.key == x.key){
                return false;
            }
            y = x;
            x = nKey < xKey ? x.left : x.right;
        }
        
        n.p = y;
        
        long yKey = Long.parseLong(y.key);
        
        if(nKey < yKey) y.left = n;
        else y.right = n;

        long finish = System.nanoTime();
        System.out.println("Elapsed time: " + (finish - start));
        return true;

    }


    static public BSTNode BSTsearch(BSTNode root, String key, String val){
        BSTNode x = root;
        long xKey = Long.parseLong(x.key);
        long passedKey = Long.parseLong(key);

        while((x != null) && (xKey != passedKey)){
            x = (passedKey < xKey) ? x.left : x.right;
            xKey = Long.parseLong(x.key);
        }

        return x;
    } 
}


class BazaLudnosci{

    BSTNode mRoot = null;

    void dodaj(Obywatel O){
        if(mRoot == null) mRoot = new BSTNode(O.getPesel(), O.getImie(), O);
        else BSTNode.BSTInsert(mRoot, new BSTNode(O.getPesel(), O.getImie(), O));
    }

    Obywatel wyszukaj(String key, String val){
        return BSTNode.BSTsearch(mRoot,key,val).mObywatel;
        
    }

    void wypisz(BSTNode current, int n ){
        System.out.println("/".repeat(n) + current.mObywatel);
        
        if(current.left != null){
            n += 1;
            this.wypisz(current.left,n);
            n -= 1; 
        }
        if(current.right != null){
            n += 1;
            this.wypisz(current.right,n);
            n -= 1;
        }
        return;
    }
    
    void wypiszDrzewo(){
        this.wypisz(mRoot,0);
        return;
    }

}