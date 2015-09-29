

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Model.ConexaoMySQL;


/**
 *
 * @author Guilherme
 */
@ManagedBean
@RequestScoped
public class CadastroCursoBean {

   
    
    private String nomecurso;

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }
    
    public void cadastrarCurso(){
         ConexaoMySQL conecta = new ConexaoMySQL(); 
         
    }
    
    
}
