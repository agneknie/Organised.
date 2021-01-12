package controllers.utilities;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControlScene {
    /**
     * Method which closes the window when close button is clicked.
     * Also closes the database connection.
     *
     * @param event used for identifying the scene
     */
    @FXML
    public static void closeWindow(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    /**
     * Method which minimises the window when minimize button is clicked.
     *
     * @param event used for identifying the scene
     */
    @FXML
    public static void minimizeWindow(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * Method which changes the colour of navigation arrow when hovered.
     *
     * @param imageName name of the image to change to
     * @param image arrow to change
     */
    public static void navigationArrowHovered(String imageName, ImageView image){
        FileInputStream newImage = null;
        try {
            newImage = new FileInputStream("src/images/"+imageName);
            image.setImage(new Image(newImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which changes the colour of navigation arrow when exited to default.
     *
     * @param imageName name of the image to change to
     * @param image arrow to change
     */
    public static void navigationArrowExited(String imageName, ImageView image){
        FileInputStream newImage = null;
        try {
            newImage = new FileInputStream("src/images/"+imageName);
            image.setImage(new Image(newImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes styling of the button if it's hovered.
     * Used for login & register pages.
     *
     * @param button button to change the style of
     */
    public static void buttonHovered(Button button){
        button.setStyle("-fx-background-color: #E6BB9A; -fx-background-radius: 10");
    }

    /**
     * Changes styling of the button and the image if it's hovered.
     * Used for buttons in marks page.
     *
     * @param pane "button" to change the style of
     * @param image image to change the colour of
     * @param label label to change the style of
     * @param imageName name of the image
     */
    public static void buttonHovered(Pane pane, ImageView image, Label label, String imageName){
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 20");
        FileInputStream newImage = null;
        try {
            newImage = new FileInputStream("src/images/"+imageName);
            image.setImage(new Image(newImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        label.setTextFill(Color.rgb(0, 0, 0));
    }

    /**
     * Reverts to regular styling of the button if it's no longer
     * hovered.
     * Used for login & register pages.
     *
     * @param button button to change the style of
     */
    public static void buttonExited(Button button){
        button.setStyle("-fx-background-color: white; -fx-background-radius: 10");
    }

    /**
     * Changes styling of the button and the image if it's hovered.
     * Used for buttons in marks page.
     *
     * @param pane "button" to change the style of
     * @param image image to change the colour of
     * @param label label to change the style of
     * @param imageName name of the image
     */
    public static void buttonExited(Pane pane, ImageView image, Label label, String imageName){
        pane.setStyle("-fx-background-color: none; -fx-background-radius: 20; " +
                "-fx-border-style: solid; -fx-border-color: white; -fx-border-width: 3; -fx-border-radius: 20");
        FileInputStream newImage = null;
        try {
            newImage = new FileInputStream("src/images/"+imageName);
            image.setImage(new Image(newImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        label.setTextFill(Color.rgb(230,187,154));
    }

    /**
     * Changes styling of menu tab(pane) if it's hovered.
     *
     * @param pane pane to change the style of
     */
    public static void menuPaneHovered(Pane pane){
        pane.setStyle("-fx-background-color: white;");
    }

    /**
     * Reverts to regular styling of the menu tab(pane) if it's
     * no longer hovered.
     *
     * @param pane pane to change the style of
     */
    public static void menuPaneExited(Pane pane){
        pane.setStyle("-fx-background-color: none");
    }
}
