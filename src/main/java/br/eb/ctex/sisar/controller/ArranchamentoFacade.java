/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eb.ctex.sisar.controller;

import br.eb.ctex.sisar.modelo.Arranchamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ralfh
 */
@Stateless
public class ArranchamentoFacade extends AbstractFacade<Arranchamento> {

    @PersistenceContext(unitName = "br.eb.ctex_SisAr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArranchamentoFacade() {
        super(Arranchamento.class);
    }
    
}
