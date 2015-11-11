package controller;

import facade.FaseFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Fase;

@ManagedBean(name="fase")
@SessionScoped
@Stateless
public class FaseController
implements Serializable {
    private static final long serialVersionUID = 1;
    String opt;
    @EJB
    private FaseFacade faseFacade;
    private Fase fase = new Fase(false, false, false, false, false);

    public Fase getFase() {
        return this.fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public String getOpt() {
        return this.opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public void Verifica() {
        if ("afinidades".equals(this.opt)) {
            this.fase.setAfinidades(true);
        } else if ("fase11".equals(this.opt)) {
            this.fase.setFase1_quad1(true);
        } else if ("fase12".equals(this.opt)) {
            this.fase.setFase1_quad2(true);
        } else if ("fase13".equals(this.opt)) {
            this.fase.setFase1_quad3(true);
        } else if ("fase2".equals(this.opt)) {
            this.fase.setFase2(true);
        } else {
            this.fase.setAfinidades(false);
            this.fase.setFase1_quad1(false);
            this.fase.setFase1_quad2(false);
            this.fase.setFase1_quad3(false);
            this.fase.setFase2(false);
        }
    }

    public void saveData() {
        this.fase.setAfinidades(false);
        this.fase.setFase1_quad1(false);
        this.fase.setFase1_quad2(false);
        this.fase.setFase1_quad3(false);
        this.fase.setFase2(false);
        this.Verifica();
        this.faseFacade.save(this.fase);
    }
}

