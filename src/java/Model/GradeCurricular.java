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

    public ArrayList<String> list() throws SQLException {

        ArrayList<String> arrayList = new ArrayList();
        ExecuteSQL exec = new ExecuteSQL();
        String sql = "select *, p.nome as nome_professor, td.id as id_turma_disciplina,\n"
                + "		(SELECT situacao \n"
                + "			FROM aluno_turma_disciplina as atd \n"
                + "			WHERE atd.id_turma_disciplina = td.id) as situacao \n"
                + "from aluno as a \n"
                + "join aluno_curso as ac on(a.id = ac.id_aluno) \n"
                + "join curso as c on(ac.id_curso = c.id) \n"
                + "join curso_disciplina as cd on (c.id = cd.id_curso) \n"
                + "join disciplina as d on(cd.id_disciplina = d.id) \n"
                + "join turma_disciplina as td on(d.id = td.id_disciplina) \n"
                + "join turma as t on(td.id_turma = t.id)\n"
                + "join cad_turma as ct on(t.id_cad_turma = ct.id) \n"
                + "join professor as p on(p.id = td.id_professor)";
        ResultSet rs = exec.select(sql);

        while (rs.next()) {
            arrayList.add(rs.getString("nome_disciplina"));
        }

        return arrayList;

    }

}
