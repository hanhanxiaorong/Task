package com.ow.tracer.shop.usr.dto;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;

import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-14 22:16:05]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("usr_user")
public class UsrUser extends BaseDTO<UsrUser> {

    /**QQ号*/
    private String qq;

    /**微信号*/
    private String wechat;

    /**常住地址*/
    private String address;

    /**可用余额*/
    private double availableBalance;

    /**生日*/
    private Date birthday;

    /**邮箱*/
    private String email;

    /**冻结余额*/
    private double freezeBlance;

    /**金币*/
    private int gold;

    /**积分*/
    private int integral;

    /**手机号*/
    private String mobile;

    /**密码*/
    private String password;

    /**性别*/
    private int sex;

    /**用户账号*/
    private String userName;

    /**用户信用*/
    private int userCredit;

    /**头像*/
    private String photoId;

    /**店铺*/
    private String storeId;

    /**QQ开放平台ID*/
    private String qqOpenid;

    /**微信的开放平台ID*/
    private String wxOpenid;

    /**地区*/
    private String areaId;

    /**自定义真实姓名*/
    @TableField(exist = false)
    private String trueName;

    /**自定义身份证号*/
    @TableField(exist = false)
    private String idNumber;

    /**自定义图片路径*/
    @TableField(exist = false)
    private String path;

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return this.wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvailableBalance() {
        return this.availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFreezeBlance() {
        return this.freezeBlance;
    }

    public void setFreezeBlance(double freezeBlance) {
        this.freezeBlance = freezeBlance;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getIntegral() {
        return this.integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserCredit() {
        return this.userCredit;
    }

    public void setUserCredit(int userCredit) {
        this.userCredit = userCredit;
    }

    public String getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getQqOpenid() {
        return this.qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getWxOpenid() {
        return this.wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getTrueName() { return trueName; }

    public void setTrueName(String trueName) { this.trueName = trueName; }

    public String getIdNumber() { return idNumber; }

    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getPath() { return path; }

    public void setPathl(String path) { this.path = path; }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("UsrUser{\n");
        strBuf.append("qq:").append(this.qq).append(",\n");
        strBuf.append("wechat:").append(this.wechat).append(",\n");
        strBuf.append("address:").append(this.address).append(",\n");
        strBuf.append("availableBalance:").append(this.availableBalance).append(",\n");
        strBuf.append("birthday:").append(this.birthday).append(",\n");
        strBuf.append("email:").append(this.email).append(",\n");
        strBuf.append("freezeBlance:").append(this.freezeBlance).append(",\n");
        strBuf.append("gold:").append(this.gold).append(",\n");
        strBuf.append("integral:").append(this.integral).append(",\n");
        strBuf.append("mobile:").append(this.mobile).append(",\n");
        strBuf.append("password:").append(this.password).append(",\n");
        strBuf.append("sex:").append(this.sex).append(",\n");
        strBuf.append("userName:").append(this.userName).append(",\n");
        strBuf.append("userCredit:").append(this.userCredit).append(",\n");
        strBuf.append("photoId:").append(this.photoId).append(",\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("qqOpenid:").append(this.qqOpenid).append(",\n");
        strBuf.append("wxOpenid:").append(this.wxOpenid).append(",\n");
        strBuf.append("areaId:").append(this.areaId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
