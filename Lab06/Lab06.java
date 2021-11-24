import java.math.BigInteger;
import java.util.Arrays;

public class lab{
    public static void main(String[] args){
        Lista lista = new Lista(); 
        lista.add(new String("to jest head"));
        lista.add(new String("to jest nizej niz head"));
        System.out.print(lista);
        System.out.println("Rozmiar listy: " + lista.getSize());
        System.out.println("Pierwszy element: " + lista.getHead());
        Lista lista2 = new Lista();
        System.out.println("Pierwszy element to null: " + lista2.getHead());
        lista.add(new BigInteger("420"));
        System.out.println("Ostatni element: " + lista.getLast());
        System.out.println("2 element listy: " + lista.getElement(1));
        System.out.println("Usuwanie elementu 1");
        lista.delElement(1);
        System.out.print(lista);
        System.out.println("Usuwanie elementu 0");
        lista.delElement(0);
        System.out.print(lista);
        lista.add(new String("nowy objekt"));
        System.out.println("Czyszczenie listy");
        lista.delAll();
        System.out.println(lista);
        ListaLiczb ll = new ListaLiczb();
        ll.add(new LiczbaWymierna(2,3));
        ll.add(new LiczbaOdZeraDoJeden(0.1));
        ll.add(new LiczbaOdZeraDoJeden(0.2));
        ll.add(new String("test"));
        System.out.print(ll);
        System.out.println("Najmniejsza wartosc: " + ll.getMin());
        System.out.println("Najwieksza wartosc: " + ll.getMax());
        System.out.println("Lista wartosci: " + Arrays.toString(ll.getTable()));
        System.out.println("Srednia wartosc: " + ll.getAverage());
        ll.add(new LiczbaOdZeraDoJeden(0.99));
        ll.add(new LiczbaOdZeraDoJeden(0.8));
        ll.add(new LiczbaOdZeraDoJeden(0.4));
        System.out.println("\nPrzed sortem: " + ll);
        ll.sort();
        System.out.println("Po sorcie; " + ll);
    }
}