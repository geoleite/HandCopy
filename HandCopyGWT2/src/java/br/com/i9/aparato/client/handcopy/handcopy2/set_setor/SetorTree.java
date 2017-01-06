/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.set_setorNew;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import java.io.Serializable;

/**
 *
 * @author geoleite
 */
public class SetorTree extends BaseTreeModel implements Serializable{
  private static int ID = 0;

  public SetorTree() {
    set("id", ID++);
  }

  public SetorTree(String name) {
    set("id", ID++);
    set("name", name);
  }

  public SetorTree(int id, String name, String type) {
    set("id", id);
    set("name", name);
    set("type", type);
  }

  public SetorTree(String name, BaseTreeModel[] children) {
    this(name);
    for (int i = 0; i < children.length; i++) {
      add(children[i]);
    }
  }

  public Integer getId() {
    return (Integer) get("id");
  }

  public String getType() {
      return (String)get("type");
  }

  public String getName() {
    return (String) get("name");
  }

  public String toString() {
    return getName();
  }
}
