/*
package aplicacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class ArticoTest
{
    private Esquimal esqui1,esqui2,esqui3,esquim4;
    private Artico artico1,artico2;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
/*
@BeforeEach
    public void setUp()
    {
        artico1 = new Artico();
        artico2 = new Artico();
        esqui1 = new Esquimal(artico1,"Ronaldo",50,50);
        esqui2 = new Esquimal(artico2,"Cesar",200,50);
        esqui2.palabras = "Te ganaré";
        esqui3 = esqui1;
    }
    
    @Test
    public void deberiaCrearEsquimal()
    {
        assertEquals(esqui1,esqui3);
        assertEquals(esqui2.palabras,"Cómo le va Juan");            
    }
    
    @Test
    public void noDeberiaCrearEsquimal()
    {
        esqui4 = new Esquimal(artico1,"Maria",40,-40);
        assertTrue(esqui4.equals(null));
    }
}
/*

 */