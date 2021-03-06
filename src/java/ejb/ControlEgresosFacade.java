/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import beans.ControlEgresos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eduje
 */
@Stateless
public class ControlEgresosFacade extends AbstractFacade<ControlEgresos> {

    @PersistenceContext(unitName = "Proyecto_ADSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlEgresosFacade() {
        super(ControlEgresos.class);
    }
    
}
