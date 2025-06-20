import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Class07AccionesDepartamentos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = 
            "jdbc:mysql://localhost:3306/hospital";
            Connection cn = 
            DriverManager.getConnection
            (connectionString, "root", "root");

            

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
