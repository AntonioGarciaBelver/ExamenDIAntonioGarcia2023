module com.mycompany.exameninterfacesantoniogarcia2023 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.base;
    requires jasperreports;
    requires javafx.swing;
    requires java.persistence;
    requires javafx.base;

    opens models;
    opens com.mycompany.exameninterfacesantoniogarcia2023 to javafx.fxml;
    exports com.mycompany.exameninterfacesantoniogarcia2023;
}
