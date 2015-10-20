
import javax.faces.bean.ManagedBean;
import Model.Curso;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class CadastroCursoBean implements Serializable {

    private List<Curso> cursos;

    private Curso selectedCurso;
    private Integer id;
    private String nome;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public void salvar() {  
         
        Curso c = new Curso();
        c.salvar(this.getId(), this.getNome());  
        

    }

    public void excluir(Curso curso) {
        
        Curso c = new Curso();
        c.excluir(curso.getId());
    }
    
     public void buscar() {
        
        
    }

}
