package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String[] v ={"ID", "DEBIT_ACC_ID", "CREDIT_ACC_ID", "TRANSACTION_BRANCH_ID", "AMOUNT", "STATUS", "INSERTED_DATE"};




        batch(v);

    }


    private static void batch(String[] v)
    {try(Connection con = DriverManager.getConnection("","BT_LUCIAN","Pass@Lucian321$")){

        Statement stm=con.createStatement();

        con.setAutoCommit(false);

            try {
                stm.addBatch("UPDATE TRANSACTIONS SET v[1] WHERE ID =v[0]");//DEBIT_ACC_ID
                stm.addBatch("UPDATE TRANSACTIONS SET v[2] WHERE ID =v[0]");//CREDIT_ACC_ID
                stm.addBatch("UPDATE TRANSACTIONS SET v[3] WHERE ID =v[0]");//TRANSACTION_BRANCH_ID
                stm.addBatch("UPDATE TRANSACTIONS SET v[4] WHERE ID =v[0]");//AMOUNT
                stm.addBatch("UPDATE TRANSACTIONS SET v[5] WHERE ID =v[0]");//STATUS
                stm.addBatch("UPDATE TRANSACTIONS SET v[6] WHERE ID =v[0]");//INSERTED_DATE
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        int[] updateTransaction= stm.executeBatch();
        con.commit();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    }
}