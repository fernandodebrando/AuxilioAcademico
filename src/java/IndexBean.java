 
import Model.Curso;
import Model.GradeCurricular;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 
@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean implements Serializable {
  
 
    private List<Curso> cursos;
     
    private Curso selectedCurso;
      
    @PostConstruct
    public void init() {
        GradeCurricular gc = new GradeCurricular();
        try{
            
        cursos = gc.list();
        
        }catch(Exception e){
            
        }
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
     
    public Curso getSelectedCurso() {
        return selectedCurso;
    }
 
    public void setSelectedCurso(Curso selectedCurso) {
        this.selectedCurso = selectedCurso;
    }
    
    
}