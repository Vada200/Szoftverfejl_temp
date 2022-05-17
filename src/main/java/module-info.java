module com.example.tic_tac_toe_proj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tic_tac_toe_proj to javafx.fxml;
    exports com.example.tic_tac_toe_proj;
}