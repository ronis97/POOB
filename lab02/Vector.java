import java.lang.Math;
/**
 * @author ECI, 2017 v01 2021 v02
 *
 */
public class Vector{

    public static final float MAXERROR = 0.00000000000001f;
    
    private float r;
    private Angulo theta;
    private float x;
    private float y;
    
    /**
     * Constructor del vector, en coordenadas polares
     * @param d longitud del vector
     * @param a angulo del vector
     */
    public Vector (float r, Angulo t) {
        this.r = r;
        this.theta = t;
    }

    /**
     * Constructor del vector, en coordenadas cartesianas
     * @param x coordenada x del vector
     * @param y coordenada y del vector
     */
    public Vector (float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Retorna la coordenada X del vector
     * @return coordenada X del vector
     */
    public float coordenadaX() {
        return this.r * (float)theta.coseno();
    
    }

    /**
     * Retorna la coordenada Y del Vector
     * @return coordenada Y del vector
     */
    public float coordenadaY() {
        return this.r * (float)theta.seno();
    }


    /**
     * Retorna el angulo del vector
     * @return angulo del vector
     */
    public Angulo angulo () {
        return this.theta;
    }


    /**
     * Retorna la longitud del vector
     * @return 
     */
    public float longitud() {
        return this.r;
    }
    
    /**
     * Retorna la distancia entre este vector y otro vector
     * @return 
     */
    public float distancia(Vector otro) {
        return (float) Math.sqrt(Math.pow((double)otro.x-this.x,2)-Math.pow((double)otro.y-this.y, 2));
    }
    
    /**
     * Compara este vector con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param v el vector a comparar con este
     */
    private boolean equals (Vector v) {
        if (this.distancia(v) < MAXERROR) return true;
        return false;
    }

    /** 
     * Compara si este Vector es igual al parametro (debe ser tambien un vector)
     */
    @Override
    public boolean equals (Object o) {
            return this.equals ((Vector) o);
    }
    
    /**
     * Translada el vector, dados los desplazamientos en dx, dy
     *
     * @param dx desplazamiento en el eje x
     * @param dy desplazamiento en el eje Y
     */
    public Vector traslade (float dx, float dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }
    
    /**
     * Calcula el producto escalar
     * @param escalar El factor de multiplicación de la distancia respecto al centro
     * @return 
     */
    public Vector productoEscalar(float escalar) {
        this.x *= escalar;
        this.y *= escalar;
        return this;
    }

    /**
     * Rota el vector el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial del vector, 
     * y la distancia es la misma.
     */
    public Vector rote(Angulo a) {
        this.theta.sume(a);
        return this;
    }

    public  Vector  sume(Vector v){
        this.x = this.r * (float)theta.coseno();
        this.y = this.r * (float)theta.seno();
        v.x = v.r * (float)theta.coseno();
        v.y = v.r * (float)theta.seno();
        this.x += v.x;
        this.y += v.y;
        return this;
    }
    
    public Vector reste(Vector v){
        this.x = this.r * (float)theta.coseno();
        this.y = this.r * (float)theta.seno();
        v.x = v.r * (float)theta.coseno();
        v.y = v.r * (float)theta.seno();
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }
    
    public Vector multiplique(Vector v){
        this.x = this.r * (float)theta.coseno();
        this.y = this.r * (float)theta.seno();
        v.x = v.r * (float)theta.coseno();
        v.y = v.r * (float)theta.seno();
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }
    
    
    /** 
     * Retorna una cadena que describe a este vector (en coordenadas polares)
     * P(r,theta)
     */
    @Override
    public String toString () {
          String s = "";
          String sr = String.valueOf(r);
          String stheta = theta.toString();
          s += "("+ sr + ","+ stheta+ ")";
          return s;
    }

}
