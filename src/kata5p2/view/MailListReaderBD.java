package kata5p2.view;

import kata5p2.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    private List<Mail> emails;
    public MailListReaderBD() {
        emails= new ArrayList<Mail>();
        this.connect();
    }

    private Connection connect() {
// SQLite connection string
        String url = "jdbc:sqlite:KATA5.DB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Mail> read() {
        this.connect();
        String sql = "SELECT * FROM EMAIL";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                emails.add(new Mail(rs.getString("direccion")));
            }
            System.out.print(emails);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.emails;
    }

}