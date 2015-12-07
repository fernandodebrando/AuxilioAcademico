 
import Model.VO.Curso_old;
import Model.VO.GradeCurricular;
import Model.BO.GradeCurricularBO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 
@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean implements Serializable {
  
 
    private List<Curso_old> cursos;
     
    private Curso_old selectedCurso;
      
    @PostConstruct
    public void init() {
        GradeCurricularBO gc = new GradeCurricularBO();
        try{
            
        cursos = gc.list();
        
        }catch(Exception e){
            
        }
    }
    
    public List<Curso_old> getCursos() {
        return cursos;
    }
     
    public Curso_old getSelectedCurso() {
        return selectedCurso;
    }
 
    public void setSelectedCurso(Curso_old selectedCurso) {
        this.selectedCurso = selectedCurso;
    }
    
    
}