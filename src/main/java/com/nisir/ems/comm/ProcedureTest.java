package com.nisir.ems.comm;

import oracle.jdbc.OracleTypes;
import org.junit.jupiter.api.Test;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ProcedureTest {
    /**
     * create or replace procedure selectUserById(uid in number,
     uName out VARCHAR2,
     uAge out number,
     uSex out char)
     */

    @Test
    public void testProcedure(){

        String sql = "{call selectUserById(?,?,?,?)}";

        Connection conn = null;
        CallableStatement call = null;
        try {
            //得到一个数据库连接
            conn = JDBCUtils.getConnection();
            //通过连接创建出statement
            call = conn.prepareCall(sql);
            //对于in参数，赋值
            call.setInt(1, 2);  // (第几个问号,要赋的值)
            //对out参数，声明
            call.registerOutParameter(2, OracleTypes.VARCHAR);  //(第几个问号，声明的类型)
            call.registerOutParameter(3, OracleTypes.NUMBER);
            call.registerOutParameter(4, OracleTypes.CHAR);

            //执行调用
            call.execute();

            //取出结果
            String userName = call.getString(2);
            int userAge = call.getInt(3);
            String userSex = call.getString(4);

            System.out.println("用户姓名："+userName+"\n\t年龄:"+userAge+"\n\t性别："+userSex);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //关闭连接，释放资源
                 JDBCUtils.release(conn, call, null);
        }

    }

}
