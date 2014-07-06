/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IPDGES;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Martín
 */
@Named(value = "createConsentForm")
@ViewScoped
public class createConsentForm {

    /**
     * Creates a new instance of createConsentForm
     */
    public createConsentForm() {
    
    }
    public void print(Integer rut){
        RequestContext.getCurrentInstance().execute("window.open('concentForm?rut="+rut+"')");
    }
    
}
