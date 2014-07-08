package Mb;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class SelectOneView {
     
    private String option;
     
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
    
    public void validaRadio(){
         FacesContext context = FacesContext.getCurrentInstance();
         String op=getOption();
         
        if(option==null || option.equals("")){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Seleccione un tipo de examen"));
        }else{
            setOption(op);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Tipo Guardado con éxito"));
        }
    }
}
