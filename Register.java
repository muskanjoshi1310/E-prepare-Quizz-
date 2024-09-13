package Eprepration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Register{
    public static void registration(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();

        if(password.length()<8){
        System.out.println("Password must be at least 8 characters long! Try again");
        return;
        }


        Connection con = DB_Connection.getConnection();
        String sql = "insert into users(username,password)values(?,?)";

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User Registrered Successfully");
        }catch(SQLException e){
         e.printStackTrace();
        }

    }
}
