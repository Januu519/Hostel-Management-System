package lk.ijse.HostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AllReservationsFormController {
    public TableView resTable;
    public TableColumn resId;
    public TableColumn resDate;
    public TableColumn studentId;
    public TableColumn roomId;
    public TableColumn status;
    public AnchorPane allReservationContext;
    public ImageView homeBtn;
    public ImageView backBtn;

    //Navigation Part
    public void setHomeBtn(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    public void btnDeleteResOnAction(ActionEvent actionEvent) {
    }
}
