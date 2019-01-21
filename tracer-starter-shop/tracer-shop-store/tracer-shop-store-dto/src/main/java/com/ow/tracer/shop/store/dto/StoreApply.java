package com.ow.tracer.shop.store.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-09 18:27:32]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("store_apply")
public class StoreApply extends BaseDTO<StoreApply> {

    private String userId;

    private String vipId;

    /**店主姓名*/
    private String name;

    /**店主身份证号*/
    private String idNumber;

    /**店铺名称*/
    private String storeName;

    /**店铺分类ID*/
    private String classId;

    /**区县区域ID*/
    private String areaId;

    /**详细地址*/
    private String address;

    /**邮政编码*/
    private int zip;

    /**手机号码*/
    private int phone;

    /**身份证照片*/
    private String cardImgId;

    /**0：提交申请，1：申请成功，2：申请失败*/
    private int applyStatus;

    /**营业执照照片*/
    private String businessImgId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVipId() {
        return this.vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCardImgId() {
        return this.cardImgId;
    }

    public void setCardImgId(String cardImgId) {
        this.cardImgId = cardImgId;
    }

    public int getApplyStatus() {
        return this.applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getBusinessImgId() {
        return this.businessImgId;
    }

    public void setBusinessImgId(String businessImgId) {
        this.businessImgId = businessImgId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreApply{\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("vipId:").append(this.vipId).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("idNumber:").append(this.idNumber).append(",\n");
        strBuf.append("storeName:").append(this.storeName).append(",\n");
        strBuf.append("classId:").append(this.classId).append(",\n");
        strBuf.append("areaId:").append(this.areaId).append(",\n");
        strBuf.append("address:").append(this.address).append(",\n");
        strBuf.append("zip:").append(this.zip).append(",\n");
        strBuf.append("phone:").append(this.phone).append(",\n");
        strBuf.append("cardImgId:").append(this.cardImgId).append(",\n");
        strBuf.append("applyStatus:").append(this.applyStatus).append(",\n");
        strBuf.append("businessImgId:").append(this.businessImgId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
