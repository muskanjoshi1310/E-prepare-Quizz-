package Eprepration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class L {
    public static boolean loginUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        int attempts =0;

        while(attempts<3){
            System.out.println("Enter password");
            String password=sc.nextLine();

            if(password.length()<8){
           System.out.println("Password must be at least 8 characters long! Try again");
           continue;
            }

        Connection con = DB_Connection.getConnection();
        String sql = "select * from users where username=?";

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
             String correctPassword = rs.getString("password");


            if(correctPassword.equals(password)){
              System.out.println("Login Successfully");
              return true;
             }else{
                attempts++;
                System.out.println("Incorrect password");
                System.out.println("Hint: Last two characters of password are:"
                +correctPassword.substring(correctPassword.length()-2));

                if(attempts==3){
                    System.out.println("to many feild attempts, Account locked.");
                    return false;
                }

             }
            }else{
                System.out.println("username not found");
                return false;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
     }
     return false;
    }
    }
