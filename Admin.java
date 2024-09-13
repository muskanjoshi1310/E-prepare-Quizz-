package Eprepration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Admin {
    public static void createQuiz(){
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter Quiz Subject");
   String subject = sc.nextLine();

   Connection con= DB_Connection.getConnection();
   String sql = "insert into quizzes(subject)values(?)";

   try{
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, subject);
    pstmt.executeUpdate();
    System.out.println("Quiz created successfully!");
   }catch(SQLException e){
    e.printStackTrace();
   }
    }

    public static void addQuestion(int quizid){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter question text:");
    String questionText= sc.nextLine();

   System.out.println("Enter option 1:");
   String option1=sc.nextLine();

   System.out.println("Enter option 2:");
   String option2=sc.nextLine();

   System.out.println("Enter option 3:");
   String option3=sc.nextLine();

   System.out.println("Enter option 4:");
   String option4=sc.nextLine();

   System.out.println("Enter correct option (1-4:0");
   int correctOption = sc.nextInt();

   Connection con = DB_Connection.getConnection();
   String sql = "insert into questions(quiz_id,question_text,option1,option2,option3,option4,correct_option)"+
   "values(?,?,?,?,?,?,?)";

   try{
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setInt(1,quizid);
    pstmt.setString(2, questionText);
    pstmt.setString(3, option1);
    pstmt.setString(4, option2);
    pstmt.setString(5, option3);
    pstmt.setString(6, option4);
    pstmt.setInt(7,correctOption);
    pstmt.executeUpdate();

    System.out.println("Question added successfully!");
   }catch(SQLException e){
    e.printStackTrace();
   }

    }
}