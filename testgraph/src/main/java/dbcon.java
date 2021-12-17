import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Siddqd
 */
public class dbcon {
    private String dbname = new String("SortArrDB");
    private String login = new String("root");
    private String pass = new String("password");
    
    public String recdate = new String();
    public String rectime = new String();
    public String sortedarr = new String();
    
    public void setRecdate(String s) {
        recdate = s;
    }
    public void setRectime(String s) {
        rectime = s;
    }
    public void setsortedarr(String s) {
        sortedarr = s;
    }
    
    public void recToDB() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "INSERT arrtable(rectime,recdate,sortedarr) VALUES("+rectime+","+recdate+","+sortedarr+")";
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SortArrDB",login,pass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        //} catch (ClassNotFoundException e) {
        } catch (SQLException sqlEx) {    
            sqlEx.printStackTrace();
        } finally {
            try { conn.close();} catch(SQLException se) {}
            try { stmt.close();} catch(SQLException se) {}
            try { rs.close();} catch(SQLException se) {}
        }
    }
}
