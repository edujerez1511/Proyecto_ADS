/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import beans.ControlGastos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eduje
 */
@Stateless
public class ControlGastosFacade extends AbstractFacade<ControlGastos> {

    @PersistenceContext(unitName = "Proyecto_ADSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlGastosFacade() {
        super(ControlGastos.class);
    }
    
}
