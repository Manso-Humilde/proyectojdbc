import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class03BuscadorPlantillaFuncion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la función: ");
        String idFuncion = teclado.nextLine();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectioString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = 
                DriverManager.getConnection(connectioString, "root", "root");
    //select APELLIDO, FUNCION, SALARIO from PLANTILLA where FUNCION='ENFERMERA';
    // "select APELLIDO, FUNCION, SALARIO from PLANTILLA "
    //+ " where FUNCION='" + funcion + "'";
            String sql = 
                "select APELLIDO, FUNCION, SALARIO from PLANTILLA " + "where FUNCION='" + idFuncion + "'";
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String apellido = rs.getString("APELLIDO");
                String funcion = rs.getString("FUNCION");
                String salario = rs.getString("SALARIO");
                System.out.println(apellido + " _ " + funcion + " _ " + salario);
            }
            rs.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error gordo " + e);
        }
        
    }
}
