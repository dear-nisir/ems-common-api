package com.nisir.ems.comm;

import oracle.jdbc.OracleTypes;
import org.junit.jupiter.api.Test;

import java.sql.CallableStatement;
import java.sql.Connection;

public class FunctionTest {
    /**
     * create or replace function selectAge(eno in number)
     return number
     */
    @Test
    public void testFunction(){
        //{？= call <procedure-name>[<arg1>,<arg2>...]}
        String sql = "{call selectAge(?)}";
        Connection conn = null;
        CallableStatement call = null;
        try {
            //得到数据库连接
            conn = JDBCUtils.getConnection();

            //通过数据库连接创建statement
            call = conn.prepareCall(sql);

            //对于输出参数，声明
            call.registerOutParameter(1, OracleTypes.NUMBER);

            //对于输入参数，赋值
            call.setInt(2, 3);

            //执行调用
            call.execute();

            //获取返回的结果
            int age = call.getInt(1);

            System.out.println("该用户年龄："+age);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(conn, call, null);
        }
    }

}
