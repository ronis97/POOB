    /**
     * Laboratorio 1 POOB
     * Autores: Michael Perilla - Ronaldo Henao
     */
    import java.util.Random;
    public class Dice
    {
        
        private Rectangle cuadro1;
        private Rectangle cuadro2;
        private Circle[] circle = new Circle[6];
        private boolean isVisible;
        private int number;
        
       
    
        /**
         * Constructor
         */
        public Dice()
        {
            cuadro1 = new Rectangle(); // Cuadro Exterior 
            cuadro1.changeSize(100,100);
            cuadro1.changeColor("black");
            
            cuadro2 = new Rectangle();
            cuadro2.changeSize(98, 98);
            cuadro2.moveHorizontal(1);
            cuadro2.moveVertical(1);
            cuadro2.changeColor("white");
            for(int i = 0; i < 6; i++){
                circle[i] = new Circle();
                //System.out.println(circle[i]);
                circle[i].changeSize(15);
                circle[i].changeColor("black");
            }
            reset();
            isVisible = false;
            
        }
        private void reset(){
            for(int i = 0; i < 6; i++){
                
                circle[i].makeInvisible();
            }
        }
        /**
         * Los metodos a continuacion definen la estructura de cada
         * cara del dado visualmente representado.
         */
        private void cara1(){
            reset();
            int x = (int)(cuadro2.getXPosition()+cuadro2.getwidth()/2)-5;
            int y = (int)(cuadro2.getYPosition()+cuadro2.getheight()/2)-5;
            circle[0].changePosition(x,y);
            number = 1;
        }
        private void cara2(){
            reset();
            int x = (int)(cuadro2.getXPosition()+cuadro2.getwidth()/2)-5;
            int y = (int)(cuadro2.getYPosition()+cuadro2.getheight()/2)-5;
            circle[0].changePosition(x,y);
            circle[0].moveHorizontal(-30);
            circle[1].changePosition(x,y);
            circle[1].moveHorizontal(20);
            number = 2;
        }
        private void cara3(){
            reset();
            circle[0].changePosition(cuadro2.getXPosition()+25, cuadro2.getYPosition()+25);
            circle[1].changePosition(cuadro2.getXPosition()+45, cuadro2.getYPosition()+45);
            circle[2].changePosition(cuadro2.getXPosition()+65, cuadro2.getYPosition()+65);
            number = 3;
        }
        private void cara4(){
            reset();
            circle[0].changePosition(cuadro2.getXPosition()+20, cuadro2.getYPosition()+20);
            circle[1].changePosition(cuadro2.getXPosition()+20, cuadro2.getYPosition()+20);
            moveDown(2, circle[1]);
            circle[2].changePosition(cuadro2.getXPosition()+60, cuadro2.getYPosition()+20);
            circle[3].changePosition(cuadro2.getXPosition()+60, cuadro2.getYPosition()+20);
            moveDown(2, circle[3]);
            number = 4;
        }
    private void cara5(){
        reset();
        cara4();
        circle[4].changePosition(cuadro2.getXPosition()+40, cuadro2.getYPosition()+40);
        //circle[4].makeVisible();
        number = 5;
    }
    private void cara6(){
        reset();
        circle[0].changePosition(cuadro2.getXPosition()+20, cuadro2.getYPosition()+20);
        circle[1].changePosition(cuadro2.getXPosition()+20, cuadro2.getYPosition()+20);
        moveDown(1, circle[1]);
        circle[2].changePosition(cuadro2.getXPosition()+20, cuadro2.getYPosition()+20);
        moveDown(2, circle[2]);
        circle[3].changePosition(cuadro2.getXPosition()+60, cuadro2.getYPosition()+20);
        circle[4].changePosition(cuadro2.getXPosition()+60, cuadro2.getYPosition()+20);
        moveDown(1, circle[4]);
        circle[5].changePosition(cuadro2.getXPosition()+60, cuadro2.getYPosition()+20);
        moveDown(2, circle[5]);
        number = 6;
    }
    private void moveDown(int veces,Circle circle)
    {
        for(int i = 0; i<veces; i++)
        {
            circle.moveDown();
        }
    }
    /**
     * Hace visible los circulos dependiendo de la cara que
     * haya sido asignada
     */
    private void casos(int cara){
        switch(cara){
            case 1:
                cara1(); circle[0].makeVisible(); break;            
            case 2:
                cara2(); circle[0].makeVisible(); circle[1].makeVisible(); break;
            case 3:
                cara3(); for (int i = 0; i < 3; i++)circle[i].makeVisible(); break;
            case 4:
                cara4(); for (int i = 0; i < 4; i++)circle[i].makeVisible(); break;
            case 5:
                cara5(); for (int i = 0; i < 5; i++)circle[i].makeVisible(); break;
            case 6:
                cara6(); for (int i = 0; i < 6; i++)circle[i].makeVisible(); break;
        }
    }
    /**
     * "Lanza" el dado
     */
    public void roll()
    {
        Random random = new Random();        
        this.number = random.nextInt(6)+1;
        if (isVisible) casos(number);        
    }
    /**
     * Recoge el valor del dado
     */
    public int getValue(){
        return this.number;
    }
    /**
     * Cambia el color del dado
     */
    public void changeColor(String color){
        cuadro2.changeColor(color);
        if (this.number != 0 && isVisible) casos(number);
    }
    /**
     * Mueve horizontalmente el dado
     */
    public void moveHorizontal(int distance){
        //this.makeInvisible();
        cuadro1.moveHorizontal(distance);
        cuadro2.moveHorizontal(distance);
        if (isVisible){
            this.makeVisible();
        }
    }
    /**
     * Mueve verticalmente el dado, usado por Dicese
     * y Bidicese
     */
    public void moveVertical(int distance){
        cuadro1.moveVertical(distance);
        cuadro2.moveVertical(distance);
        if (isVisible){
            this.makeVisible();
        }
    }
    /**
     * Hace visible el dado
     */
    public void makeVisible()
    {
        cuadro1.makeVisible();
        cuadro2.makeVisible();
        if (this.number != 0) casos(number);
        else isVisible = true; roll();
        isVisible = true;
    }
    /**
     * Hace invisible los dados
     */
    public void makeInvisible(){
        cuadro1.makeInvisible();
        cuadro2.makeInvisible();
        reset();
        isVisible = false;
    }
}
