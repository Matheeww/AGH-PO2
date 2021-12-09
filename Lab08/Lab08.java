import java.math.*;
import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


class BladFunkcji extends ArithmeticException{}
class BladCalki extends ArithmeticException{}

interface Referencja{ double wartosc(double x);}

enum Funkcja{
    X2{
        double wartosc(double x){
            double ret = x*x;
            if(Double.isNaN(ret)) throw new BladFunkcji();
            return ret;
        }
    },
    SQRT{
        double wartosc(double x){
            double ret = Math.sqrt(x);
            if(Double.isNaN(ret)) throw new BladFunkcji();
            return ret;
        }
    },
    EXP{
        double wartosc(double x){
            double ret = Math.exp(x);
            if(Double.isNaN(ret)) throw new BladFunkcji();
            return ret;
        }
    };

    double wartosc(double x){
        return 0;
    }
}


class CalkaOznaczona{
    Referencja ref;
    Funkcja f;
    CalkaOznaczona(Funkcja fun){
        ref = fun::wartosc;
    }

    CalkaOznaczona(Referencja r){
        ref = r;
    }


    double wartoscProstokaty(double a, double b, int n){
        double step = (b - a)/(double)n;
        double sum = 0;
        if(n <= 0 ) throw new BladCalki();
        try{
            for(int i = 1; i < n; i++){
                sum += ref.wartosc((double)(a + i * step));
            }
        }
        catch(Exception e){
            throw new BladCalki();
        }
        sum = sum*step;
        return sum;
    }

    double wartoscMonteCarlo(double a, double b, int n){
        double sum = 0;
        if(n <= 0 ) throw new BladCalki();
        try{
            for(int i = 0; i < n; i++){
                sum += ref.wartosc( Math.random() * (b-a) + a);
            }
        }
        catch(Exception e){
            throw new BladCalki();
        }
        sum = sum * ((b-a)/(double)n);
        return sum;
    }
    
    
    public void draw(String filename, double min){
        
        BufferedImage myPicture = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE); 
        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
        g.drawLine(0,myPicture.getHeight()/2,myPicture.getWidth(),myPicture.getHeight()/2);
        g.drawLine(myPicture.getWidth()/2,0,myPicture.getWidth()/2,myPicture.getHeight());
        
        for(double i = min; i < 5.0; i +=0.1)
            g.fillOval((int) Math.round((myPicture.getWidth()) / 2 + 10 * i), (int) Math.round((myPicture.getHeight()) / 2 - 10 * ref.wartosc(i)), 1, 1);

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (Exception e) {
            System.out.println("I/O error while saving " + filename);
        }
    }
}


public class Lab08{
    

    public static void main(String[] args){
        CalkaOznaczona co = new CalkaOznaczona(Funkcja.X2);
        co.draw("x2.png",-5);
        CalkaOznaczona co2 = new CalkaOznaczona(Funkcja.SQRT);
        co2.draw("sqrt.png",0.1);
        CalkaOznaczona co3 = new CalkaOznaczona(Funkcja.EXP);
        co3.draw("exp.png", -5);
        
    }
}