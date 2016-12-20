/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecteuraudio.modele;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Window;

/**
 *
 * @author alexd
 */
public class Manager {
    
    private GestionnaireImport gesImp; 
    private IDataManager datamanager;  
    
    private ObjectProperty noeudCourant = new SimpleObjectProperty();
    public ObjectProperty noeudCourantProperty() { return noeudCourant;}
    public NoeudMusique getNoeudCourant() { return (NoeudMusique) noeudCourant.get();}
    public void setNoeudCourant(NoeudMusique noeud) { this.noeudCourant.set(noeud);}
    
    public Manager (){ 
        gesImp= new GestionnaireImport();             
    }
    
    public void setDataManager (IDataManager m){ 
        datamanager=m ;
    }
    
    public void charger(ListePlayLists liste){ 
        datamanager.charger(liste);
    }
    
    public void sauver (ListePlayLists liste){ 
        datamanager.sauver(liste);
    }
    
    
    public void ouverture (ListePlayLists liste){ 
        gesImp.ouverture();
        gesImp.importerRepertoireMusiques(liste.getPlayListTout());    
    }
    
    
    public void chercherDisqueDur(Window window,ListePlayLists liste){
        gesImp.chercherDisqueDur(liste.getPlayListTout(), window);
    }
    
}
