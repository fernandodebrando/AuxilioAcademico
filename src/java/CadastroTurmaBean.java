/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import util.ConexaoMySQL;
import util.ExecuteSQL;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@RequestScoped
public class CadastroTurmaBean {

    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void cadastroTurma() throws SQLException{
        
        ExecuteSQL executa = new ExecuteSQL();
        
        String disciplina = nome ;
        
        String cadastro = "INSERT INTO cad_disciplina (nome) VALUES ($disciplina)"; 
        
        executa.executeQuery(cadastro);
        
    }
    public CadastroTurmaBean() {
    }
    
}
