/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecteuraudio.modele;


import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nahel
 */
public abstract class PlayList extends NoeudMusique{
    
    private  ListProperty<Musique> playlist= new SimpleListProperty<>(FXCollections.observableArrayList());

    protected String titre;
    
    public void setPlayList(ListProperty<Musique> playList) {
        this.playlist = playList;
    }

    public ObservableList<Musique> getPlayList() {
        return playlist.get(); 

    }
    
    public void setPlayList(ObservableList<Musique> value) {
        playlist.set(value); 

    }
    
    public ListProperty<Musique> playlistProperty() { 
        return playlist ; 
    }
    
    
    public String getNom(){ 
        return titre;
    }
    
    public void setNom (String nom){ 
        this.titre=nom; 
    }
    
    public void ajouter(Musique m){ 
            playlist.add(m);
        
    }
    
    public void supprimer(Musique m){
        playlist.remove(m);      
    }
    
    
    public boolean isEmpty(){
        return playlist.isEmpty();
    }
            
            
    @Override
    public String toString() { 
        return titre; 
    }
   
    
    
}
