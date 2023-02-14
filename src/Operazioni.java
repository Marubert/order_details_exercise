import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Operazioni {
    public int cancella(int orderID){
     // TODO add your handling code here:
         try {
            Class.forName("com.mysql.jdbc.Driver");
            // Connessione al database Northwind
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
            // Creazione dell'oggetto per l'esecuzione della query
            Statement st = con.createStatement();
            // inserimento nella tabella
            String sql = "delete from orders where OrderID = " + orderID + " ;";
            int nrow= st.executeUpdate(sql);
            if (nrow==1){
                // Chiusura della connessione
                con.close();
                return 0;
            }
        } catch (Exception e) {
            return 2;
        }
        return 1;
    }
    
    
    public int retriveID(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("cipolla");
            // Connessione al database Northwind
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
            System.out.println("salve");
            // Creazione dell'oggetto per l'esecuzione della query
            Statement st = con.createStatement();
            System.out.println("Giorno!");
            // inserimento nella tabella
            String sql = "SELECT MAX(OrderID) from orders;";
            System.out.println(sql);
            ResultSet nrow= st.executeQuery(sql);
             if (nrow==1){
                // Chiusura della connessione
                con.close();
                return ord++;
            }
        } catch (Exception e) {
            return 4;
        }
        return 5;
    }
    
    
}
