import java.io.*;
import java.util.*;
import java.text.Collator;

public class Lab04{
    public static void main(String[] args){
        StringBuffer textLines = new StringBuffer();
        StringBuffer text = new StringBuffer();
        try{
            BufferedReader stdin = new BufferedReader(new FileReader(args[0]));
            String s;
            while( (s=stdin.readLine()) != null){
                //System.out.println(s);
                textLines.append(s + "\n");
                if(s != ""){
                    text.append(s);
                }
            }
        }
        catch(Throwable e){
            System.out.println("Blad wczytywania pliku!");
        }

        //zad1
        String[] lines = textLines.toString().split("\n");
        for(int i = 0; i < 3; i++){
            System.out.println(i + " " + lines[i]);
        }
        for(int i = 0; i < 3; i++){
            System.out.println((lines.length - i - 1) + " " + lines[lines.length - i - 1]);
        }

        //zad2
        String[] words = textLines.toString().split(" |\\,|\\.|\n| \\.| \\,|\\, |\\. |  ");
        System.out.println("Rozmiar tablicy z liniami: " + lines.length + "\nIlosc slow: " + words.length + "\nSrednia ilosc slow w linii: " + (words.length*1.0 / lines.length));
    
    
        //zad3
        //Arrays.sort(words);
        Collator polishCollator = Collator.getInstance(new Locale("pl","PL"));
        List<String> list = Arrays.asList(words);
        list.sort(polishCollator);
        words = list.toArray(new String[0]);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String from = "0";
        String to = "1";
        try{
            System.out.println("Podaj wartosc od: ");
            from = input.readLine();
            System.out.println("do: ");
            to = input.readLine();
        }
        catch(Throwable e){
            System.out.println("Blad!");
        }
        int fromWord = Integer.valueOf(from.toString());
        int toWord = Integer.valueOf(to.toString());
        //System.out.println(lines[0]);
        for(int i = fromWord; i < toWord; i++){
            System.out.println(i + ": " + words[i].toString());
        }
    

        //zad4
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String chars = "2";
        try{
            System.out.println("Podaj ilosc liter: ");
            from = input.readLine();
        }
        catch(Throwable e){
            System.out.println("Blad !");
        }
        int count = Integer.valueOf(from.toString());
        
        HashMap<String,Integer> wordCount = new HashMap<String,Integer>(); 
        String[] goodWords = new String[words.length];
        int wcount = 0;
        for(var w: words){
            if(w.length() == count){
                if(!wordCount.containsKey(w)){
                    wordCount.put(w,1);
                    goodWords[wcount] = w;
                    //System.out.println(goodWords[wcount]);
                    wcount = wcount + 1;
                }
                else{
                    wordCount.put(w, wordCount.get(w) + 1);
                }
            }
        }
        int max = 0;
        //System.out.println(" DDD  " + goodWords[0].toString());
        String goodKey = "";
        int z = 0;
        for(int i = 0; i < 5; i++){
                goodKey = goodWords[z];
                max = wordCount.get(goodKey.toString());
            for(var keys: wordCount.keySet()){
                int countW = wordCount.get(keys);
                if(countW > max){
                    max = countW;
                    goodKey = keys;
                }
            }
            System.out.println(i + " " + goodKey + " " + wordCount.get(goodKey));
            wordCount.remove(goodKey);
            if(goodKey.toString() == goodWords[z]) {
                z = z + 1;
                //System.out.println("Wykonalem sie");
            }

        }        

    }
}