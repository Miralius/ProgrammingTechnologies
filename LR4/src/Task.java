
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@SessionScoped
@Stateless
@XmlRootElement
public class Task {
    private Double source;
    private Double result;
    private Double number;

    public Task() {
    }

    public Double getSource() {
        return source;
    }

    public void setSource(Double inputString) {
        this.source = inputString;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double count) {
        this.number = count;
    }


    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }


    public String result(){
        result=Math.log(number)/Math.log(source);
        return "/result.xhtml?faces-redirect=true";
    }
}
