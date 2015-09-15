
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import Model.Usuario;

@ManagedBean
@RequestScoped        
public class UsuarioBean {
    private List<Usuario> listaUsuarios;
    private Usuario usuario;

    public UsuarioBean() {
        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("abcde","123"));
        listaUsuarios.add(new Usuario("fulano","123"));
        listaUsuarios.add(new Usuario("sicrano","123"));
        listaUsuarios.add(new Usuario("beltrano","123"));
        
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String verificaLogin()
    {
        if(listaUsuarios.contains(usuario)){
            return "grade_curricular?faces-redirect=true";
        }
        else{
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, 
                    "Login Inválido!", 
                    "Usuário e/ou senha estão errados! Digite sua senha novamente!");
            contexto.addMessage("mensagemLogin",mensagem);
            
            return "login";
        }
    }
    


}
