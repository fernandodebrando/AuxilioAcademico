/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.DAO.CursoDAO;
import Model.VO.*;
import util.ExecuteSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author fernando
 */
@ApplicationScoped
public class GradeCurricularBO {

    public String getDiaSemana(int diaS) {

        String dia = "";

        switch (diaS) {
            case 1:
                dia = "segunda-feira";
                break;
            case 2:
                dia = "terça-feira";
                break;
            case 3:
                dia = "quarta-feira";
                break;
            case 4:
                dia = "quinta-feira";
                break;
            case 5:
                dia = "sexta-feira";
                break;
            case 6:
                dia = "Sábado";
                break;
        }

        return dia;

    }

    public List<Curso_old> list() {

        try {

            List<Curso_old> arrayList = new ArrayList();
            ExecuteSQL exec = new ExecuteSQL();
            String sql = "select *, p.nome as nome_professor, td.id as id_turma_disciplina,\n"
                    + "		(SELECT situacao \n"
                    + "			FROM aluno_turma_disciplina as atd \n"
                    + "			WHERE atd.id_turma_disciplina = td.id) as situacao \n"
                    + "from curso as c \n"
                    + "join curso_disciplina as cd on (c.id = cd.id_curso) \n"
                    + "join disciplina as d on(cd.id_disciplina = d.id) \n"
                    + "join turma_disciplina as td on(d.id = td.id_disciplina) \n"
                    + "join turma as t on(td.id_turma = t.id)\n"
                    + "join cad_turma as ct on(t.id_cad_turma = ct.id) \n"
                    + "join professor as p on(p.id = td.id_professor)";
            ResultSet rs = exec.executeQuery(sql);
            
            // List<Curso_old> listGrade  = CursoDAO.getInstance().getByWhere(sql);

            while (rs.next()) {
                Curso_old c = new Curso_old();
                c.setNome(rs.getString("nome"));
                c.setNomeDisciplina(rs.getString("nome_disciplina"));
                c.setHoras(rs.getString("horas"));
                c.setSemestre(rs.getString("semestre"));
                c.setEad(rs.getString("ead"));
                c.setPreRequisito(rs.getString("pre_requisito"));
                c.setCaracterizacao(rs.getString("caracterizacao"));
                c.setCompetenciaEssencial(rs.getString("competencia_essencial"));
                c.setNivelDificuldade(rs.getString("nivel_dificuldade"));
                c.setSala(rs.getString("sala"));
                c.setDiaSemana(rs.getString("dia_semana"));
                c.setTurno(rs.getString("turno"));
                c.setNomeProfessor(rs.getString("nome_professor"));
                c.setCurriculo(rs.getString("curriculo"));

                arrayList.add(c);
            }

            return arrayList;
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}
