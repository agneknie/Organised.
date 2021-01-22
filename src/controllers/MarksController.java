package controllers;

import controllers.utilities.ControlScene;
import controllers.utilities.DefaultNavigation;
import core.Session;
import core.Year;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import stages.PopupStage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MarksController extends DefaultNavigation implements Initializable {
    // Title Labels
    @FXML
    private Label bigTitleLabel;
    @FXML
    private Label optionalTitleLabel;

    // Small Panes and their elements
    @FXML
    private Pane pane1;
    @FXML
    private Label pane1Label;
    @FXML
    private Label pane1Value;

    @FXML
    private Pane pane2;
    @FXML
    private Label pane2Label;
    @FXML
    private Label pane2Value;

    @FXML
    private Pane pane3;
    @FXML
    private Label pane3Label;
    @FXML
    private Label pane3Value;

    @FXML
    private Pane pane4;
    @FXML
    private Label pane4Label;
    @FXML
    private Label pane4Value;

    // Add/Edit Buttons
    @FXML
    private Pane button1;
    @FXML
    private Label button1Label;
    @FXML
    private ImageView button1Image;

    @FXML
    private Pane button2;
    @FXML
    private Label button2Label;
    @FXML
    private ImageView button2Image;

    // Navigation buttons
    @FXML
    private ImageView goLeftButton;
    @FXML
    private ImageView goRightButton;

    // Big Panes and their elements
    // Pane 5
    @FXML
    private Pane pane5;
    @FXML
    private Label pane5Title;
    @FXML
    private Label pane5Label1;
    @FXML
    private Label pane5Value1;
    @FXML
    private Label pane5Label2;
    @FXML
    private Label pane5Value2;
    @FXML
    private Label pane5Label3;
    @FXML
    private Label pane5Value3;
    @FXML
    private Label pane5Label4;
    @FXML
    private Label pane5Value4;
    // Pane 5 button
    @FXML
    private Pane pane5Button;
    @FXML
    private ImageView pane5ButtonImage;
    @FXML
    private Label pane5ButtonLabel;

    // Pane 6
    @FXML
    private Pane pane6;
    @FXML
    private Label pane6Title;
    @FXML
    private Label pane6label1;
    @FXML
    private Label pane6Value1;
    @FXML
    private Label pane6Label2;
    @FXML
    private Label pane6Value2;
    @FXML
    private Label pane6Label3;
    @FXML
    private Label pane6Value3;
    @FXML
    private Label pane6Label4;
    @FXML
    private Label pane6Value4;
    // Pane 6 button
    @FXML
    private Pane pane6Button;
    @FXML
    private ImageView pane6ButtonImage;
    @FXML
    private Label pane6ButtonLabel;

    // Pane 7
    @FXML
    private Pane pane7;
    @FXML
    private Label pane7Title;
    @FXML
    private Label pane7Label1;
    @FXML
    private Label pane7Value1;
    @FXML
    private Label pane7Label2;
    @FXML
    private Label pane7Value2;
    @FXML
    private Label pane7Label3;
    @FXML
    private Label pane7Value3;
    @FXML
    private Label pane7Label4;
    @FXML
    private Label pane7Value4;
    // Pane 7 button
    @FXML
    private Pane pane7Button;
    @FXML
    private ImageView pane7ButtonImage;
    @FXML
    private Label pane7ButtonLabel;

    // Variables for storing user data
    private List<Year> userYears;
    private String actionViewName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cleans the session variables of marks, if there were any
        cleanSession();

        // Loads the Years of the user
        userYears = Session.getSession().getAllYears();

        loadDegree();
    }

    // Helper methods used within this controller
    /**
     * Cleans the session variable if popup is closed.
     * @param event parameter not used
     */
    private void popupClosed(WindowEvent event){
        Session.setMarksPopupType(null);
    }

    /**
     * Cleans the session variables for year, module and assignment
     */
    private void cleanSession(){
        Session.setMarksYearSelected(null);
        Session.setMarksModuleSelected(null);
        Session.setMarksAssignmentSelected(null);
    }

    /**
     * Setups the scene with degree data (panels have year data)
     */
    private void loadDegree(){
        // Sets the main titles of the page
        bigTitleLabel.setText("Your Degree.");
        optionalTitleLabel.setText("");

        // Sets up the buttons
        button1.setVisible(false);
        button2Label.setText("Add Year");

        // Sets up the name of the view if add/edit is pressed
        actionViewName = "Year";

        // Sets degree overall grade
        pane1Label.setText("Average:");
        double userGrade = Session.getSession().getDegreeGrade();
        if (userGrade == -1) pane1Value.setText("-");
        else pane1Value.setText(Double.toString(userGrade));

        // Set degree classification
        pane2Label.setText("Classification:");
        pane2Value.setText(Session.getSession().getClassification());

        // Hides unused top display panes
        pane3.setVisible(false);
        pane4.setVisible(false);

        // Load years in pane5, pane6 & pane7
        // Save loaded year numbers in array(?) so they can be traced back if clicked
        // Hide year panes if unused
    }

    // Below methods implement UI buttons
    @FXML
    private void button1Clicked() throws IOException {
        // TODO button1Clicked
        // Sets the popup type
        Session.setMarksPopupType("Edit");

        // Creates the popup
        Stage popup = new Stage();
        new PopupStage(popup, "MarksPopupView"+actionViewName+".fxml");

        // If popup gets closed from the taskbar, forwards to popupClosed method
        popup.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::popupClosed);
    }

    /**
     * Changes colour of the 1st button if hovered
     */
    @FXML
    private void button1Exited() {
        ControlScene.buttonExited(button1, button1Image, button1Label, "edit_icon.png");
    }

    /**
     * Reverts to default colour of the 1st button if exited
     */
    @FXML
    private void button1Hovered() {
        ControlScene.buttonHovered(button1, button1Image, button1Label, "edit_icon_selected.png");
    }

    @FXML
    private void button2Clicked() throws IOException {
        // TODO button2Clicked
        // Sets the popup type
        Session.setMarksPopupType("Add");

        // Creates the popup
        Stage popup = new Stage();
        new PopupStage(popup, "MarksPopupView"+actionViewName+".fxml");

        // If popup gets closed from the taskbar, forwards to popupClosed method
        popup.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::popupClosed);
    }

    /**
     * Reverts to default colour of the 2nd button if exited
     */
    @FXML
    private void button2Exited() {
        ControlScene.buttonExited(button2, button2Image, button2Label, "add_icon.png");
    }

    /**
     * Changes colour of the 2nd button if hovered
     */
    @FXML
    private void button2Hovered() {
        ControlScene.buttonHovered(button2, button2Image, button2Label, "add_icon_selected.png");
    }

    @FXML
    private void pane5ButtonClicked() {
        //TODO pane5ButtonClicked
    }

    /**
     * Reverts to default colour of pane5 button when exited
     */
    @FXML
    private void pane5ButtonExited() {
        ControlScene.buttonExited(pane5Button, pane5ButtonImage, pane5ButtonLabel, "more_icon.png");
    }

    /**
     * Changes the colour of pane5 button when hovered
     */
    @FXML
    private void pane5ButtonHovered() {
        ControlScene.buttonHovered(pane5Button, pane5ButtonImage, pane5ButtonLabel, "more_icon_selected.png");
    }

    @FXML
    private void pane6ButtonClicked() {
        //TODO pane6ButtonClicked
    }

    /**
     * Reverts to default colour of pane6 button when exited
     */
    @FXML
    private void pane6ButtonExited() {
        ControlScene.buttonExited(pane6Button, pane6ButtonImage, pane6ButtonLabel, "more_icon.png");
    }

    /**
     * Changes the colour of pane6 button when hovered
     */
    @FXML
    private void pane6ButtonHovered() {
        ControlScene.buttonHovered(pane6Button, pane6ButtonImage, pane6ButtonLabel, "more_icon_selected.png");
    }

    @FXML
    private void pane7ButtonClicked() {
        //TODO pane7ButtonClicked
    }

    /**
     * Reverts to default colour of pane7 button when exited
     */
    @FXML
    private void pane7ButtonExited() {
        ControlScene.buttonExited(pane7Button, pane7ButtonImage, pane7ButtonLabel, "more_icon.png");
    }

    /**
     * Changes the colour of pane7 button when hovered
     */
    @FXML
    private void pane7ButtonHovered() {
        ControlScene.buttonHovered(pane7Button, pane7ButtonImage, pane7ButtonLabel, "more_icon_selected.png");
    }

    // Below methods implement go left, go right, close window, go back to previous & minimize buttons
    /**
     * Method which moves the existing panes one to left and replaces
     * leftmost pane with new information.
     */
    @FXML
    private void goLeftClicked() {
        //TODO goLeftClicked
    }

    /**
     * Reverts to usual goLeft button colour if exited.
     */
    @FXML
    private void goLeftExited() {
        ControlScene.controlButtonEffect("next_element_left.png", goLeftButton);
    }

    /**
     * Changes goLeft button colour if hovered .
     */
    @FXML
    private void goLeftHovered() {
        ControlScene.controlButtonEffect("next_element_left_selected.png", goLeftButton);
    }

    /**
     * Method which moves the existing panes one to right and replaces
     * rightmost pane with new information.
     */
    @FXML
    private void goRightClicked() {
        //TODO goRightClicked
    }

    /**
     * Reverts to usual goRight button colour if exited.
     */
    @FXML
    private void goRightExited() {
        ControlScene.controlButtonEffect("next_element_right.png", goRightButton);
    }

    /**
     * Changes goRight button colour if hovered .
     */
    @FXML
    private void goRightHovered() {
        ControlScene.controlButtonEffect("next_element_right_selected.png", goRightButton);
    }

    /**
     * Method which changes the screen back to the previously visited screen
     * when goBack button is pressed.
     */
    public void goBackClicked() {
        //TODO go back to previous screen button
    }

    /**
     * Listener for keyboard events.
     * If right/left arrow is pressed, changes the pane information (triggers
     * the navigation arrows actions)
     * @param event used for identifying the key
     */
    public void keyPressed(KeyEvent event){
        KeyCode key = event.getCode();
        // If left arrow is clicked
        if (key.equals(KeyCode.LEFT)) goLeftClicked();
        // If right arrow is clicked
        if (key.equals(KeyCode.RIGHT)) goRightClicked();
    }
}
