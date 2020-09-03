/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author root
 */
public class IndexBean extends org.apache.struts.action.ActionForm {
    
    private String txtusername;
    
    private String txtpassword;

    public String getTxtusername() {
        return txtusername;
    }

    public void setTxtusername(String txtusername) {
        this.txtusername = txtusername;
    }

    public String getTxtpassword() {
        return txtpassword;
    }

    public void setTxtpassword(String txtpassword) {
        this.txtpassword = txtpassword;
    }



    /**
     *
     */
    public IndexBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getTxtusername()== null || this.getTxtusername().equalsIgnoreCase("")) {
            errors.add("lblusernameError", new ActionMessage("error.lblpassError.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getTxtpassword()== null || this.getTxtpassword().equalsIgnoreCase("")) {
            errors.add("lblpassError", new ActionMessage("error.lblpassError.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        setTxtusername("");
        setTxtpassword("");
        super.reset(mapping, request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
