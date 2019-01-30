package com.ow.tracer.shop.usr.dto;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-14 22:16:05]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("usr_address")
public class UsrAddress extends BaseDTO<UsrAddress> {

     /**详细地址 **/
    private String areaInfo;

    /**联系方式 **/
    private String telephone;

    /**收货人 **/
    private String trueName;

    /**邮编 **/
    private String zip;

    /**地区id **/
    private String areaId;

    /**用户id **/
    private String userId;

    /**是否是默认收获地址 **/
    private Integer type;

    /**自定义用户名称 **/
    @TableField(exist = false)
    private String userName;

    public String getAreaInfo() {
        return this.areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTrueName() {
        return this.trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("UsrAddress{\n");
        strBuf.append("areaInfo:").append(this.areaInfo).append(",\n");
        strBuf.append("telephone:").append(this.telephone).append(",\n");
        strBuf.append("trueName:").append(this.trueName).append(",\n");
        strBuf.append("zip:").append(this.zip).append(",\n");
        strBuf.append("areaId:").append(this.areaId).append(",\n");
        strBuf.append("userId:").append(this.userId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
