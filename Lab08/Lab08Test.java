import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab08Test {

    @Test
    public void testFunckja() {
        assertEquals(4, Funkcja.X2.wartosc(2),0.01);
        assertEquals(4, Funkcja.SQRT.wartosc(16),0.01);
        assertEquals(2.718, Funkcja.EXP.wartosc(1),0.01);    
        
        assertThrows(BladFunkcji.class, () -> {Funkcja.SQRT.wartosc(-1);});
    }

    @Test
    public void testCalka() {
        CalkaOznaczona cx2 = new CalkaOznaczona(Funkcja.X2);
        assertEquals(1/3.0 *( Math.pow(2,3) - Math.pow(1,3) ), cx2.wartoscMonteCarlo(1,2,1000), 0.1);
        assertEquals(1/3.0 *( Math.pow(2,3) - Math.pow(1,3) ), cx2.wartoscProstokaty(1,2,1000), 0.1);
    
        assertThrows(BladCalki.class, () -> {cx2.wartoscProstokaty(1,2,-3);});
        CalkaOznaczona csqrt = new CalkaOznaczona(Funkcja.SQRT);
        assertThrows(BladCalki.class, () -> {csqrt.wartoscProstokaty(-6,2,10);});
    
        CalkaOznaczona cx3 = new CalkaOznaczona(t->(t*t*t));
        assertEquals(0.25, cx3.wartoscProstokaty(0,1,10), 0.1);

        CalkaOznaczona cx22 = new CalkaOznaczona(Funkcja.X2::wartosc); 
        assertEquals(1/3.0 *( Math.pow(1,3) - Math.pow(0,3) ), cx22.wartoscProstokaty(1,2,10), 3.0);
        
    }

}