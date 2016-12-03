import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Seth Atkinson
 */
public class moviesDatabase {
    
    public static void main(String[] args) {
        final String QUERY = " select * from movies";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/s2emp", "katie", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                rs.getInt("id") + ", "
                + rs.getString("name") + ", "
                + rs.getString("genre") +", "
                +rs.getDouble("rating"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Retrive SQLException: " + ex.getMessage());
        }
    }
}
