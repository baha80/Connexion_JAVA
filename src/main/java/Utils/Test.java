package Utils;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection con1 = DataSource.getInstance().getConnection();
        Connection con2 = DataSource.getInstance().getConnection();

        System.out.println(con1);
        System.out.println(con2);
    }
    
}
