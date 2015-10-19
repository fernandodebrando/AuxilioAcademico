package Model;

import java.sql.ResultSet;

public class Usuario {

    private String email;
    private String senha;
    private Integer id;
    private Integer idPerfil; 

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public boolean valida(Usuario obj) {

        if (obj == null) {
            return false;
        }

        try {

            ExecuteSQL exec = new ExecuteSQL();
            String sql = "select * "
                    + "from usuario "
                    + "where email = '" + obj.email + "' and password = '" + obj.senha + "'";
            ResultSet rs = exec.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    this.setEmail(rs.getString("email"));
                    this.setSenha(rs.getString("password"));
                    this.setId(rs.getInt("id"));
                    this.setIdPerfil(rs.getInt("id_perfil"));
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
