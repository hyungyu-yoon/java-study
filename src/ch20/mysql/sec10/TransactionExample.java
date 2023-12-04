package ch20.mysql.sec10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
//JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
//연결하기
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "root", "apple");
//트랜잭션 시작 ----------------------------------------------------
            conn.setAutoCommit(false);

            //출금 작업
            String sql1 = "UPDATE accounts SET balance = balance-? WHERE ano = ?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1, 10000);
            pstmt1.setString(2, "111-111-1111");
            int rows1 = pstmt1.executeUpdate();
            if (rows1 == 0) throw new Exception("출금되지 않았음");
            pstmt1.close();

            //입금 작업
            String sql2 = "UPDATE accounts SET balance = balance+? WHERE ano = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, 10000);
            pstmt2.setString(2, "232-222-2222");
            int rows2 = pstmt2.executeUpdate();
            if (rows2 == 0) throw new Exception("입금되지 않았음");
            pstmt2.close();

            conn.commit();
            System.out.println("계좌 이체 성공");
            //트랜잭션 종료 ----------------------------------------------------
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
            System.out.println("계좌 이체");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    //연결 끊기
                    conn.close();

                } catch (SQLException e) {
                }
            }
        }
    }
}