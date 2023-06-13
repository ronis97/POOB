import java.util.Collection;

public class SwFactory {

    private String[] clients;

    private Collection<Team> teams;

    private Collection<Project> projects;

    private Collection<Inscription> inscriptions;

    private Collection<Certificates> certificates;

    private Collection<Feedbacker> feedbackers;
    
    /**
     * Encuentra un equipo para el proyecto especifico
     * @param idProyect El id del proyecto donde se quiere buscar el equipo
     * @return Team el equipo que tiene el mayor porcentaje
     * @throws SwFactoryException PROJECT NOT FOUND el proyecto no fue encontrado
     * @throws SwFactoryException PROJECT HAS WINNER el proyecto ya tiene ganador
     */
    public Team foundTeamWinner(String idProyect){
	try{
            Project project = loadProjectById(idProyect);
            Inscription inscription = loadInscriptionByProject(idProyect);
            Team winner = null;
            int percentage = 0;
            for (Inscription i: inscriptions){
                int newPercentage = i.evaluatePercentage();
                if (newPercentage > percentage) {
                    percentage = newPercentage;
                    winner = inscription.getWinner();
                }
            }
            return winner;
        }
        catch (SwFactoryException sw){
        
        }
        return null;
    }
    /**
     * Devuelve el proyecto por su identificacion
     * @param idProyect el id del proyecto a encontrar
     * @return Project el proyecto solicitado
     * @throws SwFactoryException PROJECT NOT FOUND el proyecto no fue encontrado
     */
    public Project loadProjectById(String idProyect) throws SwFactoryException{
        Project project = null;
        for (Project i: projects){
            if (i.getId().equals(idProyect)) project = i;
    	}    	
    	if (project == null) throw new SwFactoryException(SwFactoryException.PROJECT_NOT_FOUND);
    	else return project;
    }
    /**
     * Devuelve la inscripcion por el id del proyecto
     * @param idProyect el id del proyecto asociado a la inscripcion
     * @return Inscription la inscripcion solicitada
     */
    public Inscription loadInscriptionByProject(String idProyect){
        for (Inscription i: inscriptions){
            if (i.getIdProject().equals(idProyect)) return i;
        }
        return null;
    }
}
/*
 * Conceptos
 * 1. ¿Cuando utilizaría herencia y cuando una interfaz y por qué?
 * 2. Explique cuales son los 3 momentos de una excepción.
 * Herencia la utilizo cuando necesito funcionalidades iguales en varias clases pero cada clase tiene comportamiento distinto bajo 
 * diferentes circuntancias
 * Interfaz la usaria para declarar los metodos de las clases necesarias, especificar que deben hacer pero no el como.
 * Los 3 momentos de una excepcion son lanzar, propagar y atender. Lanzar permite generar la excepcion bajo comportamiento no deseado,
 * propagar es basicamente que el metodo tiene la excepcion pero no la atiende (no hay bloque try, catch) pero sigue la excepcion
 * y atender es basicamente usar un bloque try catch para ejecutar codigo de acorde al comportamiento no deseado
 */