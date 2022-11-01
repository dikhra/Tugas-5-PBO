import java.sql.*;

/**
 *
 * @author Dimas Khalik Rahmahdin
 */

public class Tugas5 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            var query = "SELECT A.LAST_NAME AS 'employee', B.LAST_NAME AS 'manager' \n"
                    + "FROM employees A LEFT JOIN employees B \n"
                    + "ON A.MANAGER_ID = B.EMPLOYEE_ID\n"
                    + "WHERE B.LAST_NAME IS NOT Null";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Employees, Manager");
            while (rs.next()) {
                String employees = rs.getString(1);
                String manager = rs.getString(2);
                System.out.println(employees + ", " + manager);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}