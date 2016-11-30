/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecteuraudio.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import lecteuraudio.modele.GestionnaireImport;
import lecteuraudio.modele.GestionnaireRepertoire;
import lecteuraudio.modele.Lecteur;
import lecteuraudio.modele.ListePlayLists;
import lecteuraudio.modele.Musique;
import lecteuraudio.modele.PlayList;
import lecteuraudio.modele.PlayListSimple;

/**
 *
 * @author nachazot1
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button play;
    
    @FXML
    private ListView listMusique;
    
    @FXML 
    private ListView listeplaylists; 
    
    @FXML
    private Button previous;
    @FXML
    private Button next;
    @FXML
    private Label titreMusique;
    @FXML
    private Label tempsEcoule;
    @FXML
    private Label tempsRestant;
    @FXML
    private Label auteur;
    
    @FXML
    private ListePlayLists liste=ListePlayLists.getInstance();
    
    @FXML 
    private PlayList listemusiques; 
    
    Lecteur lec=new Lecteur();
    private GestionnaireRepertoire gesRep= new GestionnaireRepertoire(); 
    private GestionnaireImport gesImp= new GestionnaireImport(gesRep);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        PlayList tout=new PlayListSimple("Tout"); 
        liste.ajouterPlayList(tout);
        gesRep.ouverture();
        gesImp.importerRepertoireMusiques(new File(gesRep.getRepositoryPath()),tout);
        lec.setPlaylist(liste.getPlayListTout());
    }    

    
    @FXML
    private void playPressed(ActionEvent event) {
        
        if("play".equals(play.getId())){          
            lec.play();
            play.setId("pause");
        }
        else {
            play.setId("play");
            lec.pause();
        }
    }
     
    
    @FXML 
    private void importPressed(ActionEvent event) { 
       gesImp.chercherDisqueDur(liste.getPlayListTout()); 
        
    }

    @FXML
    private void previousPressed(ActionEvent event) {
        if("play".equals(play.getId())){
            play.setId("pause");
        }
        lec.precedent();
    }

    @FXML
    private void nextPressed(ActionEvent event) {
        if("play".equals(play.getId())){
            play.setId("pause");
        }
        lec.next();
    }
    
 
    @FXML 
    private void onPlayListChoisie (MouseEvent event){ 
        ListView listeV=(ListView) event.getSource(); 
        PlayList choisie= (PlayList)listeV.getSelectionModel().getSelectedItem();      
        listemusiques=choisie; 
        lec.setPlaylist(choisie); 
        
        
    }
    
   
    
    
    
}
