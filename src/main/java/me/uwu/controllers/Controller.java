package me.uwu.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodTextRun;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import me.uwu.IGStonks;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {

    public static Controller instance;

    public TextField user;
    public PasswordField pass;

    public Label unTxt;
    public Label pwTxt;
    public Label failTxt;

    public CheckBox sm;
    public CheckBox rf;

    public Controller(){instance = this;}

    @FXML
    protected void goStonks() throws IOException, InterruptedException {
        if(isValidUsername(user)){
            unTxt.setText("Valid username");
            unTxt.setTextFill(Color.web("#A3BE8C"));
        }else {
            unTxt.setText("Enter valid username...");
            unTxt.setTextFill(Color.web("#BF616A"));
        }

        if(isValidPassword(pass)){
            pwTxt.setText("Valid password");
            pwTxt.setTextFill(Color.web("#A3BE8C"));
        }else {
            pwTxt.setText("Enter valid password...");
            pwTxt.setTextFill(Color.web("#BF616A"));
        }

        if(isValidUsername(user) && isValidPassword(pass)){
            IGStonks.user = user.getText();
            IGStonks.pass = pass.getText();

            if(rf.isSelected()){
                IGStonks.onlyLike = false;
            } else {
                IGStonks.onlyLike = true;
            }

            if(sm.isSelected()){
                IGStonks.safeMode = true;
            } else {
                IGStonks.safeMode = false;
            }

            IGStonks.goStonks();
        }
    }

      public void cleanUp() {
        IGStonks.cleanUp();
      }

      private static boolean isValidUsername(TextField user) {
        String u = user.getText();
          if(u.length() >= 3 && !u.contains("%") && !u.contains(",") && !u.contains("#") && !u.contains("µ") && !u.contains("²") && !u.contains("°"))
          return true;
          else return false;
      }

    private static boolean isValidPassword(TextField pass) {
        return pass.getText().length() >= 7;
    }

    public void failed(){
        failTxt.setText("Login failed");
    }

    public void reloadList(MouseEvent mouseEvent) {

    }
}
