/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecteuraudio.persistanceBin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import javafx.beans.property.StringProperty;
import lecteuraudio.metier.IMusique;
import lecteuraudio.metier.Musique;

/**
 *
 * @author alexd
 */
public class BinaryMusique extends IMusique implements  Externalizable{
    private Musique musique = new Musique(); 
    
    public BinaryMusique(){}
    
    public BinaryMusique (String auteur, String titre, String path){ 
        musique.setAuteur(auteur); 
        musique.setTitre(titre);
        musique.setPath(path); 
    }  
    
    @Override
    public String getAuteur() {
        return musique.getAuteur(); 
    }

    @Override
    public String getPath() {
        return musique.getPath(); 
    }

    @Override
    public void setPath(String path) {
        musique.setPath(path);
    }

    @Override
    public void setAuteur(String auteur) {
        musique.setAuteur(auteur); 
    }
    
    @Override 
    public void setTitre(String titre){ 
        musique.setTitre(titre);
    }

    @Override
    public String getTitre() {
        return musique.getTitre(); 
    }
    
    @Override
    public StringProperty titreProperty(){
        return musique.titreProperty();
    }
    
    @Override
    public StringProperty auteurProperty(){
        return musique.auteurProperty(); 
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getTitre());
        out.writeObject(getPath());
        out.writeObject(getAuteur());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setTitre((String)in.readObject());
        setPath((String)in.readObject());
        setAuteur((String)in.readObject());
    }
    
}
