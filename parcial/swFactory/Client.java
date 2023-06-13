import java.util.HashMap;


public class Client
{
    private int id;
    private String name;
    private String email;
    private HashMap<String,Project> projects;
    /**
     * Carga el proyecto dada una cadena dada.
     * @param projectName el nombre del proyecto en String
     * @return el objeto proyecto solicitado.
     */
    public  Project loadProjectByName(String projectName){
        return projects.get(projectName);
    }
    /**
     * Borra el proyecto dado el nombre
     * @param projectName el nombre del proyecto en String
     * @return Si el proyecto fue borrado exitosamente
     */
    public boolean deleteProject(String projectName){
        Project project = loadProjectByName(projectName);
        if (project != null){
            return project.deleteProject();
        }
        return false;
    }
}
