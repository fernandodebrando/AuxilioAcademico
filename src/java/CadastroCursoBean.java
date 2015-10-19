
import javax.faces.bean.ManagedBean;
import Model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ViewScoped
public class CadastroCursoBean implements Serializable {

    private List<Curso> cursos;

    private Curso selectedCurso;

    @PostConstruct
    public void init() {
        Curso c = new Curso();
        try {

            cursos = c.list();

        } catch (Exception e) {

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

    public void salvar(ActionEvent event) {
        
        Curso c = new Curso();
        //c.salvar(selectedCurso.getId(), selectedCurso.getNome());

    }

    public void excluir(Curso curso) {
        
        Curso c = new Curso();
        c.excluir(curso.getId());
    }
    
     public void buscar() {
        
        
    }

}
