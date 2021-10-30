/* Plik Example01_1.java */

public class Example00 {
	public static void main (String[] args) {

		// "zwykla" zmienna:
		int i = 555;

		// tablica:
		int[] t;
		t = new int[10];

		// tworzymy nowy obiekt klasy 'Liczba' (definicja ponizej):
		Liczba x = new Liczba();

		// wywolujemy funkcje (metody) zdefiniowana w klasie 'Liczba':
		x.setN(7);
		i = x.getN();

		// funkcje biblioteczne print oraz println:
		for(int k=0; k < t.length; k++) {
			t[k]=k*k/2;
			System.out.println("t["+k+"]="+t[k]);
		}
		
		System.out.println("\nNasza liczba = " + i);
		System.out.print("x =");
		System.out.print(x);
		System.out.println();

		// itd. itp. ...
		x.setN(99);
		System.out.print("a teraz = " + x.getN() + ";");
		System.out.print(" ** KONIEC **\n");
	}
 }

 class Liczba {

// Dane:
	private int n;
	private String nazwa;

// Konstruktory:
	public Liczba(){
		n=0;
		nazwa = "nienazwany";
	}

	public Liczba(String nazwa){
		this.nazwa = nazwa ;
	}

// Inne funkcje:
	public void setN(int k){
		n=k;
	}

	public int getN(){
		return n;
	}
 }
