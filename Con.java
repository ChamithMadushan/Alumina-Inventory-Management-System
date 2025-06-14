
package alumina.inventory.management.system;

import java.sql.Connection;
import java.sql.DriverManager;


public class Con {
    static Connection con;
    
    public static Connection getConnection(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/alumina_inventory_management","root","");
    
}
    catch(Exception ex){
    System.out.println(""+ex);
}
    return con;
}
}
