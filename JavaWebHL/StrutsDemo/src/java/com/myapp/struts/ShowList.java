/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import Dao.UserDao;
import Model.UserModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author root
 */
public class ShowList extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            ArrayList beanList = new ArrayList<>();
            UserDao ud = new UserDao();
            ResultSet rs = ud.getUser();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    i++;
                    UserModel um = new UserModel();
                   
                    um.setUsername(rs.getString("FirstName"));
                    um.setPass(rs.getString("Lastname"));
                    um.setId(rs.getString("EmployeeID"));
                   
                    beanList.add(um);
                }
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mapping.findForward(SUCCESS);
    }
}
