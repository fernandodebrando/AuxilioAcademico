 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.TreeNode;
import Model.Curso;
import Model.CursoService;
 
@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean implements Serializable {
     
    private TreeNode root;
     
    private Curso selectedCurso;
         
    @ManagedProperty("#{cursoService}")
    private CursoService service;
     
    @PostConstruct
    public void init() {
        root = service.createCursos();
    }
 
    public TreeNode getRoot() {
        return root;
    }
 
    public void setService(CursoService service) {
        this.service = service;
    }
 
    public Curso getSelectedCurso() {
        return selectedCurso;
    }
 
    public void setSelectedCurso(Curso selectedCurso) {
        this.selectedCurso = selectedCurso;
    }
}