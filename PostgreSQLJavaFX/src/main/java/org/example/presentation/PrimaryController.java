package org.example.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.domain.Friend;
import org.example.domain.IPersistenceHandler;
import org.example.persistence.PersistenceHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    IPersistenceHandler persistenceHandler = PersistenceHandler.getInstance();

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    private ListView<Friend> friendsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        friendsListView.getItems().addAll(persistenceHandler.getFriends());
    }

    @FXML
    void addFriend(ActionEvent event) {
        Friend friend = new Friend(null, name.getText(), Integer.parseInt(phoneNumber.getText()));
        if(persistenceHandler.createFriend(friend)){
            System.out.println("Friend inserted into database");
        } else {
            System.out.println("Something went wrong");
        }
        updateUI();
    }

    private void updateUI(){
        name.clear();
        phoneNumber.clear();
        friendsListView.getItems().clear();
        friendsListView.getItems().addAll(persistenceHandler.getFriends());
    }

}
