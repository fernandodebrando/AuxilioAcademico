/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class GradeCurricular {

    public ArrayList<ArrayList<String>> list() throws SQLException {

        ArrayList<ArrayList<String>> arrayList = new ArrayList();
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
        ResultSet rs = exec.select(sql);

        while (rs.next()) {
           ArrayList<String> arrayString = new ArrayList();
            arrayString.add(rs.getString("nome"));
            arrayString.add(rs.getString("nome_disciplina"));
            arrayString.add(rs.getString("horas"));
            arrayString.add(rs.getString("semestre"));
            arrayString.add(rs.getString("ead"));
            arrayString.add(rs.getString("pre_requisito"));
            arrayString.add(rs.getString("caracterizacao"));
            arrayString.add(rs.getString("competencia_essencial"));
            arrayString.add(rs.getString("nivel_dificuldade"));
            arrayString.add(rs.getString("sala"));
            arrayString.add(rs.getString("dia_semana"));
            arrayString.add(rs.getString("turno"));
            arrayString.add(rs.getString("nome_professor"));
            arrayString.add(rs.getString("curriculo"));
            
            arrayList.add(arrayString);
        }

        return arrayList;

    }

}
