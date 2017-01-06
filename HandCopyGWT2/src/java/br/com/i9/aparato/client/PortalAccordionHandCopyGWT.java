/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client;

import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;

/**
 *
 * @author geoleite
 */
public class PortalAccordionHandCopyGWT extends PortalAccordionGWT {

    public PortalAccordionHandCopyGWT() {
        //tabPanel.add(tiWelcome);
        this(0);
    }
    public PortalAccordionHandCopyGWT(int alturaBanner) {
        super(alturaBanner);
        //tabPanel.add(tiWelcome);
        getTabPanel().remove(getTiWelcome());
    }

    public void createMenu() {
        super.createMenu();
        AdminHandCopyAccordion menuHandler = (AdminHandCopyAccordion) getMenuHandler().get(0);
        menuHandler.actionEventMenu(null, "HANDCOPY.MinhasSolicitacoes");
    }
}
