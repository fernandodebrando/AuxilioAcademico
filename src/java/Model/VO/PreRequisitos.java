/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "pre_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreRequisitos.findAll", query = "SELECT p FROM PreRequisitos p"),
    @NamedQuery(name = "PreRequisitos.findById", query = "SELECT p FROM PreRequisitos p WHERE p.id = :id")})
public class PreRequisitos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_disciplina_pre_requisito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplina idDisciplinaPreRequisito;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplina idDisciplina;

    public PreRequisitos() {
    }

    public PreRequisitos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getIdDisciplinaPreRequisito() {
        return idDisciplinaPreRequisito;
    }

    public void setIdDisciplinaPreRequisito(Disciplina idDisciplinaPreRequisito) {
        this.idDisciplinaPreRequisito = idDisciplinaPreRequisito;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
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
        if (!(object instanceof PreRequisitos)) {
            return false;
        }
        PreRequisitos other = (PreRequisitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.VO.PreRequisitos[ id=" + id + " ]";
    }
    
}
