import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class01ReadEmpleados {
    public static void main(String[] args) {
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectioString = "jdbc:mysql://localhost:3306/hospital";

            Connection cn = DriverManager.getConnection(connectioString, 
            "root", "root");

            String sql = "select * from EMP";

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String apellido = 
                    rs.getString("APELLIDO");
                System.out.println("Apellido: " + apellido);
                
            }
            rs.close();
            cn.close();
           
        } catch (ClassNotFoundException e) {
            System.out.println("Class" + e);
        } catch (SQLException ex) {
            System.out.println("Sql: " + ex);
        }
    }
}
