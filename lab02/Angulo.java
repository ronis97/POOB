import java.lang.Math;
/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados, radianes, o gradianes 
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias.
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author ECI, 
 */
public class Angulo {

    /** Constantes para indicar que el argumento está en radianes */
    public static final int RADIANES = 0;
    /** Constantes para indicar que el argumento está en grados */
    public static final int GRADOS = 1;
    /** Constantes para indicar que el argumento está en gradianes */
    public static final int GRADIANES = 2;
    /** Constante para maximo error admitido al comparar dos angulos.  
     *  Recuerde que los cálculos en el computador con variables de plunto flotante
     *  tienen una precisión limitada, y se requiere un margen de tolerancia
     */    
    public static final double MAXERROR = 0.00000000000001;
    private double valor;
    private int tipo;
    /** Crea un angulo a partir del valor dado en grados o en radianes
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public Angulo (double valor, int tipo){
        this.valor = valor;
        this.tipo = tipo;
    }
    
    /**Valor del angulo en grados
     * @return el valor del angulo en grados, 0 <= result < 360
     */
    public double grados () {
        //System.out.println(valor);
        if (tipo == Angulo.GRADOS) return valor;
        else if (tipo == Angulo.RADIANES){
            valor = valor*180 / Math.PI;
            return valor;
        }
        else {
            valor = valor*180 / 200;
            return valor;
        }
    }
    /**Valor del angulo en radianes
     * @return el valor del angulo en radianes, 0 <= result < 2*PI
     */
    public double radianes () {
        if (tipo == Angulo.RADIANES) return valor;
        else if (tipo == Angulo.GRADOS){
            valor = valor * Math.PI / 180;
            return valor;
        }
        else {
            valor = valor * Math.PI / 200;
            return valor;
        }
    }
    
    /**Valor del angulo en gradianes
     * @return el valor del angulo en gradianes, 0 <= result < 400
     */
    public double gradianes () {
        if (tipo == Angulo.GRADIANES) return valor;
        else if (tipo == Angulo.GRADOS){
            valor = valor * 200 / 180;
            return valor;
        }
        else{
            valor = valor * 200 / Math.PI;
            return valor;
        }
    }
    
    /**
     * Suma este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this + a
     */
    public Angulo sume (Angulo ang) {
        if (this.tipo == ang.tipo){
            this.valor += ang.valor;
            return this;
        }
        else{
            this.valor = this.grados() + ang.grados();
            return this;
        }
    }
    /**
     * Resta este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this - a
     */
    public Angulo reste (Angulo a) {
        if (this.tipo == a.tipo){
            this.valor -= a.valor;
            return this;
        }
        else{
            this.valor = this.grados() - a.grados();
            return this;
        }
    }

    /**
     * Multiplica este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a multiplicar
     * @return this * a
     */
    public Angulo multiplique (Angulo ang) {
        if (this.tipo == ang.tipo){
            this.valor *= ang.valor;
            return this;
        }
        else{
            this.valor = this.grados() * ang.grados();
            return this;
        }
    }

    /**
     * Divide este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a dividir
     * @return this / a
     */
    public Angulo divida (Angulo a) {
        if (this.tipo == a.tipo){
            this.valor /= a.valor;
            return this;
        }
        else{
            this.valor = this.grados() / a.grados();
            return this;
        }
    }
    
    
    /**
     * Multiplica esta angulo por un real
     * @param r real para hacer el producto 
     * @return r * this
     */
    public Angulo multiplique (double r) {
        this.valor *= r;
        return this;
    }
    
    /**
     * Compara a este angulo con otro, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param a angulo para compararse
     * @return |this - a| < MAXERROR
     */
    public boolean equals (Angulo a) {
        if (this.tipo == a.tipo){
            if (tipo == 1){
                if (a.valor >= 360) return true;
                else if(a.valor == 0) return true;
                else if(a.valor == 720) return true;
            }
            else{
                return Math.abs(this.valor-a.valor) < MAXERROR;
            }            
        }
        else{
            this.valor = grados();
            a.valor = grados();
            return Math.abs(this.valor-a.valor) < MAXERROR;
        }
        return false;
    }
    
    /** overrides Object.equals()
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals (Object o) {
        Angulo a = (Angulo) o;
        return equals (a) ;
    }

    /**Calcula el seno
     * @return el seno de este angulo
     */
    public double seno () {
        valor = Math.sin(valor);
        return valor;
    }

    /**Calcula el coseno
     * @return el coseno de este angulo
     */
    public double coseno () {
        valor = Math.cos(valor);
        return valor;
    }

    /**
     * Retorna el valor del angulo en grados
     * @return the information of this object
     */
    public String toString() {
      valor = grados();
      String s = String.valueOf(valor);
      return s;
    }
}
