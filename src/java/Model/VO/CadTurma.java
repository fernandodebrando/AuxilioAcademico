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
@Table(name = "cad_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadTurma.findAll", query = "SELECT c FROM CadTurma c"),
    @NamedQuery(name = "CadTurma.findById", query = "SELECT c FROM CadTurma c WHERE c.id = :id"),
    @NamedQuery(name = "CadTurma.findByNome", query = "SELECT c FROM CadTurma c WHERE c.nome = :nome"),
    @NamedQuery(name = "CadTurma.findByDescricao", query = "SELECT c FROM CadTurma c WHERE c.descricao = :descricao")})
public class CadTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCadTurma")
    private Collection<Turma> turmaCollection;

    public CadTurma() {
    }

    public CadTurma(Integer id) {
        this.id = id;
    }

    public CadTurma(Integer id, String nome) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Turma> getTurmaCollection() {
        return turmaCollection;
    }

    public void setTurmaCollection(Collection<Turma> turmaCollection) {
        this.turmaCollection = turmaCollection;
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
        if (!(object instanceof CadTurma)) {
            return false;
        }
        CadTurma other = (CadTurma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.CadTurma[ id=" + id + " ]";
    }
    
}
