package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("unused")
@XmlRootElement(name = "MathForm")
@XmlType(propOrder = {"base", "power", "result"})
public class MathForm {

    private Double base;
    private Double power;
    private Double result;
    @XmlTransient
    private boolean okStatus = false;

    @XmlElement(name = "base")
    public Double getBase() {

        return base;
    }

    public void setBase(Double base) {

        this.base = base;
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isOkStatus() {
        if (!okStatus) {
            if (base !=null && power !=null){
                okStatus = true;
                return okStatus;
            }
        }
        return okStatus;
    }

    @XmlElement(name = "power")
    public Double getPower() {

        return power;
    }

    public void setPower(Double power) {

        this.power = power;
    }

    @XmlElement(name = "result")
    public Double getResult() {

        return result;
    }

    public void setResult(Double result) {

        this.result = result;
    }


    public void exponentiation() {
            result = Math.pow(base, power);
    }
}