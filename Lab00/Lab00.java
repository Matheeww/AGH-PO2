import java.lang.Math;

public class Lab00 {
    public static void main(String[] args) {

        LiczbyRzeczywiste tabelaLiczb  = new LiczbyRzeczywiste(5, 7);
        tabelaLiczb.printTab();
        tabelaLiczb.srednia();
        tabelaLiczb.min();
        tabelaLiczb.max();
        tabelaLiczb.histogram();
    }
}

class LiczbyRzeczywiste {

    private double[] tab;
    private int n;
    private int k;

    public LiczbyRzeczywiste(int newN, int newK){
        n = newN;
        k = newK;

        tab = new double[n];
        for(int temp = 0; temp < n; temp++){
            for(int i = 0; i < k; i++){
                tab[temp] += Math.random();
            }
        }
    }

    public void printTab(){
        for(var temp : tab){
            System.out.println(temp);
        }
    }

    public void srednia(){
        double srednia = 0.0;
        for(var temp : tab){
            srednia += temp;
        }
        srednia /= n;
        System.out.println("Srednia: " + srednia);
    }

    public void max(){
        if(n <= 0) return;
        double max = tab[0];
        for(var temp : tab){
            if(temp > max) max = temp;
        }
        System.out.println("Max: " + max);
    }

    public void min(){
        if(n <= 0) return;
        double min = tab[0];
        for(var temp : tab){
            if(temp < min) min = temp;
        }
        System.out.println("Min: " + min);
    }

    public void histogram(){
        System.out.println("Histogram: \n");
        for(var temp : tab){
           for(int i = 1; i < Math.abs(temp); i++){
               System.out.print("*");
           } 
           System.out.println();
        }
    } 
}