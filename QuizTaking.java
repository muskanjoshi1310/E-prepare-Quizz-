package Eprepration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuizTaking {
   public static void takeQuiz(int quizId, int userId){
    Connection con= DB_Connection.getConnection();
    String sql = "Select * from questions where quiz_id=?";
    int score =0;
     Scanner sc = new Scanner(System.in);

     try{
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,quizId);
        ResultSet rs=pstmt.executeQuery();

        while(rs.next()){
       System.out.println(rs.getString("question_text"));
       System.out.println("1."+rs.getString("option1"));
       System.out.println("2."+rs.getString("option2"));
       System.out.println("3."+rs.getString("option3"));
       System.out.println("4."+rs.getString("option4"));
       System.out.println("Enter your answer(1-4):");
       int userAnswer = sc.nextInt();

       if( userAnswer==rs.getInt("correct_option")){
         score++;
       }
        }
        System.out.println("/n You Scored:"+score);
        String resultSql = "insert into results(user_id,quiz_id,score)values(?,?,?)";
        pstmt = con.prepareStatement(resultSql);
        pstmt.setInt(1, userId);
        pstmt.setInt(2, quizId);
        pstmt.setInt(3,score);
        pstmt.executeUpdate();
     }
     catch(SQLException e){
   e.printStackTrace();
     }


   } 
}