package com.nisir.ems.entities;

import java.io.Serializable;

public class EmsUser implements Serializable {
    private Long  id;   //主键
    private String userCode; //用户编号
    private String userName;   //名称
    private String userSex; //m:male,boy;f:female,girl
    private String idCardNo; //身份证号码，加密
    private String pwdString; //密码，加密
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String  dbSource;

    public EmsUser() {
    }

    public EmsUser(Long id, String userCode, String userName, String userSex, String idCardNo, String pwdString, String dbSource) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userSex = userSex;
        this.idCardNo = idCardNo;
        this.pwdString = pwdString;
        this.dbSource = dbSource;
    }

    public Long getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public String getPwdString() {
        return pwdString;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public void setPwdString(String pwdString) {
        this.pwdString = pwdString;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
