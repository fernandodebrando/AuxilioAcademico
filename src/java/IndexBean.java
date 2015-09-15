/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.GradeCurricular;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fernando
 */
@ManagedBean(name = "indexBean")
@SessionScoped
public class IndexBean {

    public ArrayList<String> grade = null;

    /**
     * Creates a new instance of indexBean
    
     */
    public IndexBean() {

    }

    public ArrayList<String> getGrade() throws SQLException {

        GradeCurricular gradeCurricular = new GradeCurricular();
        this.grade = gradeCurricular.list();

        return grade;
    }

    public void setGrade(ArrayList<String> grade) {

        this.grade = grade;
    }

}
