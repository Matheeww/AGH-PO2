
class Vector3D{
    double _x;
    double _y;
    double _z;
    Vector3D(){
        _x = 0;
        _y = 0;
        _z = 0;
    }

    Vector3D(double x, double y, double z){
        _x = x;
        _y = y;
        _z = z;    
    }

    @Override
    public String toString(){
        return "X: " + _x + " Y: " + _y + " Z: " + _z;
    }

    public void setX(double a){
        _x = a;
    }

    public void setY(double a){
        _y = a;
    }

    public void setZ(double a){
        _z = a;
    }
    
    public void set(double a, double b, double c){
        setX(a);
        setY(b);
        setZ(c);
    }

    public double getX(){
        return _x;
    }
    
    public double getY(){
        return _y;
    }

    public double getZ(){
        return _z;
    }

    static Vector3D add(Vector3D first, Vector3D sec){
        return new Vector3D(first.getX() + sec.getX(), first.getY() + sec.getY(), first.getZ() + sec.getZ());
    }

    static Vector3D de(Vector3D first, Vector3D sec){
        return new Vector3D(first.getX() - sec.getX(), first.getY() - sec.getY(), first.getZ() - sec.getZ());
    }

    static Vector3D multVecDoub(Vector3D first, double a){
        return new Vector3D(first.getX()*a, first.getY()*a, first.getZ()*a);
    }

    static double dot(Vector3D first, Vector3D sec){
        return first.getX() * sec.getX() + first.getY() * sec.getY() + first.getZ() * sec.getZ();
    }

    static Vector3D cross(Vector3D a, Vector3D b){
        return new Vector3D( a.getY()*b.getZ() - a.getZ()*b.getY(), a.getZ()*b.getX() - a.getX()*b.getZ(), a.getX()*b.getY() - a.getY()*b.getX());
    }

}

public class Lab05{
    public static void main(String[] args){
        Vector3D one = new Vector3D();
        Vector3D two = new Vector3D(1,2,3);
        System.out.println(one);
        System.out.println(two);
    }
}