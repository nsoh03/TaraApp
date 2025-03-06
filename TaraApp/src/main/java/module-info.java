module com.mycompany.taratesting {
    requires javafx.controls;
    
    requires org.hibernate.orm.core; 
    requires java.naming;  
    requires java.persistence;
    requires java.sql;

    opens com.mycompany.taratesting to org.hibernate.orm.core;
    exports com.mycompany.taratesting;
    
}
