import java.util.HashMap;

/** Calculadora.java
 * Representa una calculadora de vectores 
 * @author ESCUELA 2017-02 v01 2121-02 v02
 */
    
public class CalVectorial{
    
    private HashMap<String,Vector> operandos;
    
    public CalVectorial(){
        
    }

    //Crea una nueva variable de memoria
    public void defina(String nombre){
        operandos.put(nombre, null);
    }
     
    //Asigna una constante a una variable
    //a := P(longitud, grados)  La variable debe estar definida
    public void asigne(String a, float longitud, float grados ){
        //operandos
    }    
    
    //Asigna el resultado de una operacion unaria a una varible
    //Los caracteres de las operaciones posibles son: u (vector unitario) v (componente vertical), h (componente horizontal)
    //a := op b  Las variables deben estar definidas  
    public void asigne(String a, char op, String b){
    }
    
    //Asigna el resultado de una operacion binaria a una varible
    //Los caracteres de las operaciones posibles son: + (suma), - (resta), . (producto punto), e (proyeccion escalar), v (proyeccion vectorial)
    //a := b op c  Las variables deben estar definidas  
    public void asigne(String a, String b, char op, String c){
    }
  
    
    //Retorna el valor de la variable a en coordenadas polares. Si no esta definida retorna 'INDEFINIDA'
    public String consulteEnPolares(String a){
        return null;
    }
    
    //Retorna el valor de la variable a en coordenadas cartesianas. Si no esta definida retorna 'INDEFINIDA'
    public String consulteEnCartesianas(String a){
        return null;
    }    
    
    //Si se logro hacer la ultima operacion
    public boolean ok(){
        return false;
    }
}
    



