module fri.ris.hoopstat {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens fri.ris.hoopstat to javafx.fxml;
    exports fri.ris.hoopstat;
}