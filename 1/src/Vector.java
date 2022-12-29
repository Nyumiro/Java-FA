public class Vector {
    public int x, y, z;
    public Vector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getLen(){
        return Math.sqrt(x * x + y * y + z * z);
    }
    public double getScalarProduct(Vector a){
        return x * a.x + y * a.y + z * a.z;
    }
    public Vector getVectorProduct(Vector a){
        return new Vector(y * a.z - z * a.y, z * a.x - x * a.z, x * a.y - y * a.x);
    }
    public double getCos(Vector a){
        return getScalarProduct(a) / (getLen() * a.getLen());
    }
    public Vector add(Vector a){
        return new Vector(x + a.x, y + a.y, z + a.z);
    }
    public Vector subtract(Vector a){
        return new Vector(x - a.x, y - a.y, z - a.z);
    }

    public static Vector[] generateVectors(int n) {
        var value = new Vector[n];
        for (int i = 0; i < n; i++) {
            value[i] = new Vector((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10));
        }
        return value;
    }
    public String toString(){
        return "(" + x + ", " + y + ", " + z  + ")";
    }
}
