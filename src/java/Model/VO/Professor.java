/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome"),
    @NamedQuery(name = "Professor.findBySexo", query = "SELECT p FROM Professor p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Professor.findByFacebook", query = "SELECT p FROM Professor p WHERE p.facebook = :facebook"),
    @NamedQuery(name = "Professor.findByLinkedin", query = "SELECT p FROM Professor p WHERE p.linkedin = :linkedin"),
    @NamedQuery(name = "Professor.findByTwitter", query = "SELECT p FROM Professor p WHERE p.twitter = :twitter"),
    @NamedQuery(name = "Professor.findByGoogle", query = "SELECT p FROM Professor p WHERE p.google = :google"),
    @NamedQuery(name = "Professor.findByCurriculoLattes", query = "SELECT p FROM Professor p WHERE p.curriculoLattes = :curriculoLattes")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Size(max = 65535)
    @Column(name = "curriculo")
    private String curriculo;
    @Column(name = "sexo")
    private Character sexo;
    @Size(max = 45)
    @Column(name = "facebook")
    private String facebook;
    @Size(max = 45)
    @Column(name = "linkedin")
    private String linkedin;
    @Size(max = 45)
    @Column(name = "twitter")
    private String twitter;
    @Size(max = 45)
    @Column(name = "google")
    private String google;
    @Size(max = 100)
    @Column(name = "curriculo_lattes")
    private String curriculoLattes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessor")
    private Collection<TurmaDisciplina> turmaDisciplinaCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;

    public Professor() {
    }

    public Professor(Integer id) {
        this.id = id;
    }

    public Professor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getCurriculoLattes() {
        return curriculoLattes;
    }

    public void setCurriculoLattes(String curriculoLattes) {
        this.curriculoLattes = curriculoLattes;
    }

    @XmlTransient
    public Collection<TurmaDisciplina> getTurmaDisciplinaCollection() {
        return turmaDisciplinaCollection;
    }

    public void setTurmaDisciplinaCollection(Collection<TurmaDisciplina> turmaDisciplinaCollection) {
        this.turmaDisciplinaCollection = turmaDisciplinaCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.Professor[ id=" + id + " ]";
    }
    
}
