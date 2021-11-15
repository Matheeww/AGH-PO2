import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Lab05Test {

    @Test
    public void testSet(){
        Vector3D one = new Vector3D(1,2,3);
        assertEquals(one._x,1, 0.001);
        assertEquals(one._y,2, 0.001);
        assertEquals(one._z,3, 0.001);
    }

    @Test
    public void testSetX(){
        Vector3D one = new Vector3D();
        one.setX(1);
        assertEquals(one._x,1, 0.001);
    }

    @Test
    public void testSetY(){
        Vector3D one = new Vector3D();
        one.setY(1);
        assertEquals(one._y,1, 0.001);
    }
    
    @Test
    public void testSetZ(){
        Vector3D one = new Vector3D();
        one.setZ(1);
        assertEquals(one._z,1, 0.001);
    }

    @Test
    public void testGetX(){
        Vector3D one = new Vector3D(1,2,3);
        assertEquals(one.getX(), 1, 0.001);
    }

    @Test
    public void testGetY(){
        Vector3D one = new Vector3D(1,2,3);
        assertEquals(one.getY(), 2, 0.001);
    }
    
    @Test
    public void testGetZ(){
        Vector3D one = new Vector3D(1,2,3);
        assertEquals(one.getZ(), 3, 0.001);
    }

    @Test 
    public void testAdd1(){
       Vector3D one = new Vector3D(1,2,3);
       Vector3D two = new Vector3D(4,3,2);
       assertEquals(Vector3D.add(one,two).toString(), new Vector3D(5,5,5).toString()); 
    }

    @Test 
    public void testAdd2(){
       Vector3D one = new Vector3D(1.4,2.2,3.5);
       Vector3D two = new Vector3D(4.6,3.8,2.2);
       Vector3D res = Vector3D.add(one,two); 
       assertEquals(res.getX(), 6, 0.01);
       assertEquals(res.getY(), 6, 0.01);
       assertEquals(res.getZ(), 5.7, 0.01); ; 
    }

    @Test 
    public void testDe1(){
       Vector3D one = new Vector3D(3,4,5);
       Vector3D two = new Vector3D(1,2,3);
       assertEquals(Vector3D.de(one,two).toString(), new Vector3D(2,2,2).toString()); 
    }

    @Test 
    public void testDe2(){
       Vector3D one = new Vector3D(3.5,4.6,5.2);
       Vector3D two = new Vector3D(1.2,2.3,3.1);
       Vector3D res = Vector3D.de(one,two); 
       assertEquals(res.getX(), 2.3, 0.01);
       assertEquals(res.getY(), 2.3, 0.01);
       assertEquals(res.getZ(), 2.1, 0.01); 
    }

    @Test 
    public void testDot1(){
       Vector3D one = new Vector3D(1.5,2,3);
       Vector3D two = new Vector3D(4,5,6);
       assertEquals(Vector3D.dot(one,two), 34, 0.001); 
    }

    @Test 
    public void testDot2(){
       Vector3D one = new Vector3D(1.1,2.2,3.3);
       Vector3D two = new Vector3D(4.4,5.5,6.6);
       assertEquals(Vector3D.dot(one,two), 38.72, 1e-10); 
    }

    @Test 
    public void testCross1(){
       Vector3D one = new Vector3D(1.5,2,3);
       Vector3D two = new Vector3D(4,5,6);
       assertEquals(Vector3D.cross(one,two).toString(), new Vector3D(-3,3,-0.5).toString() ); 
    }

    @Test 
    public void testCross2(){
       Vector3D one = new Vector3D(1.1,2.2,3.3);
       Vector3D two = new Vector3D(4.4,5.5,6.6);
       Vector3D res = Vector3D.cross(one,two);
       assertEquals(res.getX(), -3.63, 1e-10);
       assertEquals(res.getY(), 7.26, 0.01);
       assertEquals(res.getZ(), -3.63, 0.01); 
    }
    

}