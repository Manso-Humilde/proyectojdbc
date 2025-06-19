import java.sql.Connection; //paso obligatorio
import java.sql.DriverManager;//paso obligatorio
import java.sql.ResultSet;//paso obligatorio
import java.sql.Statement;//paso obligatorio
import java.util.Scanner;//paso obligatorio

public class Class02BuscadorEmpleadoDept {//paso obligatorio
    public static void main(String[] args) {//paso obligatorio
        Scanner teclado = new Scanner(System.in);//paso obligatorio
        System.out.println("Introduzca el número de departamento: ");//paso obligatorio
        String idDepartamento = teclado.nextLine();//paso obligatorio


        try {//paso obligatorio
            Class.forName("com.mysql.cj.jdbc.Driver");//paso obligatorio
            String connectioString = //paso obligatorio
                "jdbc:mysql://localhost:3306/hospital";//paso obligatorio
            Connection cn = //paso obligatorio
                DriverManager.getConnection(connectioString,//paso obligatorio 
                    "root", "root");//paso obligatorio
            String sql =
                "select APELLIDO, OFICIO from EMP where DEPT_NO=" + idDepartamento;
                System.out.println(sql);
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String apellido = rs.getString("APELLIDO");
                    String oficio = rs.getString("OFICIO");
                    System.out.println(apellido + " _ " + oficio);
                }
                rs.close();
                cn.close();
            
        }catch (Exception e){ //paso obligatorio
            System.out.println("Error gordo " + e); //paso obligatorio
        }
    }
}
