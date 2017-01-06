/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.aparato.client;

import br.com.easyportal.gwt.client.AuthenticationGWT;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.easyportal.gwt.client.admin.AdminMenuHandlerAccordion;
import br.com.easyportal.gwt.client.teste.MenuHandlerTesteAccordion;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }
 
    /**
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    public void onModuleLoad() {
        br.com.easyportal.gwt.client.Constantes.URL = Constantes.URL;
        AdminHandCopyAccordion adminMenuAccordion = new AdminHandCopyAccordion();
        //PortalAccordionGWT portal = new PortalAccordionGWT();
        PortalAccordionGWT portal = new PortalAccordionHandCopyGWT(70);
        portal.checkSession(1800000);//10 minutos
        //MenuHandlerTesteAccordion mht = new MenuHandlerTesteAccordion();
        //portal.addMenuHandler(mht);
        portal.addMenuHandler(adminMenuAccordion);
        AuthenticationGWT authentication = new AuthenticationGWT();
        authentication.setPortal(portal);
        authentication.setVisible(true);
        //portal.setHeight(portal.getHeight() - 60);
    }
}
