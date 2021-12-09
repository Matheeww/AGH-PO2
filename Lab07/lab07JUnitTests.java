/*

# pobranie JUnit-a
wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar

# kompilacja testów i reszty projektu
javac *.java -cp junit-platform-console-standalone-1.8.1.jar 

# uruchomienie testów
java -jar junit-platform-console-standalone-1.8.1.jar -cp .  --scan-class-path


*/


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class lab07JUnitTests {

    @Test
    public void test0() {
        int n = 2;
        assertEquals(2, n );
    }
    

    @Test
    public void testA__1_punkt() {
        SaturnV s1 = new SaturnV(1);
        assertEquals("SaturnV nr 1", s1+"" );
        
        SaturnV s2 = new SaturnV(2);
        assertEquals("SaturnV nr 2", s2+"" );
        
        Wahadlowiec w1 = new Wahadlowiec("Discovery");
        assertEquals("Wahadlowiec Discovery", w1+"" );

        Wahadlowiec w2 = new Wahadlowiec("Atlantis");
        assertEquals("Wahadlowiec Atlantis", w2+"" );
        
        assertThrows(ClassCastException.class, () -> { Object o = s1; Wahadlowiec x = (Wahadlowiec) o; } );
        assertThrows(ClassCastException.class, () -> { Object o = w1; SaturnV x = (SaturnV) o; } );
    }
    
    @Test
    public void testB__2_punkt() {
        Object objS = new SaturnV(3);
        Object objW = new Wahadlowiec("Discovery");
        
        Rakieta r = (Rakieta) objS;
        Wahadlowiec w = (Wahadlowiec) objW;
        
        assertThrows(ClassCastException.class, () -> { Rakieta x = (Rakieta) objW; } );
        
        assertEquals("NASA", r.producent() );
        assertEquals("NASA", Rakieta.producent() );
        assertEquals("NASA", SaturnV.producent() );
        
        int mod = Rakieta.class.getModifiers();
        Assertions.assertTrue(Modifier.isAbstract(mod) && !Modifier.isInterface(mod));
    }

    @Test
    public void testC__2_punkty() {
        Rakieta r = new SaturnV(4);
        Wahadlowiec w = new Wahadlowiec("Discovery");
        Object objR = r;
        Object objW = w;
        
        PojazdKosmiczny pR = (PojazdKosmiczny) objR;
        PojazdKosmiczny pW = (PojazdKosmiczny) objW;
        assertEquals("Kennedy Space Center", PojazdKosmiczny.BAZA );
        assertEquals("Kennedy Space Center", pW.BAZA );
        
        Odrzutowy oR = pR;
        Odrzutowy oW = pW;
        
        oR.ustawCiag(7);
        pW.ustawCiag(5);
        
        Latajacy lR = pR;
        Latajacy lW = pW;
        
        lR.startuj();
        pW.startuj();
        
    }
    
    @Test
    public void testD__3_punkty() {
        Rakieta r = new SaturnV(4);
        Wahadlowiec w = new Wahadlowiec("Discovery");
        Object objR = r;
        Object objW = w;
        
        JetCar j = new JetCar();
        Odrzutowy lJ = (Odrzutowy) j;
        Jezdzi jJ = j;
        lJ.ustawCiag(5);
        jJ.skrecKola();
        Object objJ = j;
        assertThrows(ClassCastException.class, () -> { Latajacy x = (Latajacy) objJ; } );
        
        Caracal c = new Caracal();
        Latajacy lC = (Latajacy) c;
        lC.startuj();
        Object objC = c;
        assertThrows(ClassCastException.class, () -> { Odrzutowy x = (Odrzutowy) objC; } );
        assertThrows(ClassCastException.class, () -> { Jezdzi x = (Jezdzi) objC; } );
        
        assertThrows(ClassCastException.class, () -> { Jezdzi x = (Jezdzi) objR; } );
        
        Jezdzi x = (Jezdzi) objW;
        w.skrecKola();
        x.skrecKola();
    }

    @Test
    public void testE__2_punkty() {
        Rakieta r = new SaturnV(4);
        Rakieta.Zaloga z = new Rakieta.Zaloga();
        Rakieta.Ladownik l = r.new Ladownik();
        PojazdKosmiczny pL = l;
        Apollo a = r.ladownikApollo();
        Rakieta.Ladownik lA = a;
        Apollo a2 = (Apollo) lA;
        assertThrows(ClassCastException.class, () -> { Apollo x = (Apollo) l; } );
    }
    
}