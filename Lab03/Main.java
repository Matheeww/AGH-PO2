
public class Main {
    public static void main(String[] args) {
        Kwota x1 = new Kwota( 9, 99 );
        Kwota x2 = new Kwota( 2, 07 );
        Kwota x3 = new Kwota( 0, 12 );
        System.out.println("1a)  " + x1 + " ;  " + x2 + " ;  " + x3);
        Kwota y1 = Kwota.dodaj(x1, x3);
        System.out.println("1b)  " + x1 + " + " + x3 + " = " + y1);
        y1 = Kwota.odejmij(x2, x3);
        System.out.println("1b)  " + x2 + " - " + x3 + " = " + y1);
        System.out.println();
        
        String id = "12 3456 7890";
        Konto konto1 = new Konto(id, x1);
        System.out.println("2a)  " + konto1);
        x1.set( 0, 00 );
        System.out.println("2b)  " + konto1);
        Kwota x5 = konto1.getStan();
        x5.set( -1000, 00 );
        System.out.println("2c)  " + konto1);
        konto1.setStan( new Kwota(99, 11) );
        System.out.println("2d)  " + konto1);
        System.out.println();
        
        Bank bank = new Bank();
        bank.utworzKonto("22 8765 0001");
        bank.utworzKonto("33 8765 0002");
        System.out.println("3a)  " + bank);
        x1.set( 9, 99 );
        bank.wplataNaKonto("22 8765 0001", x1);
        bank.wplataNaKonto("33 8765 0002", x1);
        System.out.println("3b)  " + bank);
        bank.wyplataZKonta("22 8765 0001", x2);
        System.out.println("3c)  " + bank);
        y1 = bank.stanKonta("33 8765 0002");
        y1.set(0,0);
        System.out.println("3d)  " + bank);
    }
}