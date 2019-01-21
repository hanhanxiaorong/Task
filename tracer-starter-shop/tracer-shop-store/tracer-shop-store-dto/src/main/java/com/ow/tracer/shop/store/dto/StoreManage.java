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
  @TableName("store_manage")
public class StoreManage extends BaseDTO<StoreManage> {

    /**用户ID*/
    private String userId;

    /**店铺等级*/
    private String gradeId;

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

    /**0：审批成功，未缴费，1：正常，2：到期未续费，3：封店状态*/
    private int storeStatus;

    /**营业执照照片*/
    private String businessImgId;

    /**店铺头图片*/
    private String bannerImgId;

    /**店铺LOGO图片*/
    private String logoImgId;

    /**是否推荐商店*/
    private int storeRecommend;

    /**推荐时间*/
    private Date storeRecommendTime;

    /**有效时间*/
    private Date validityTime;

    /**店铺信用*/
    private String storeCredit;

    /**店铺模板*/
    private String templateId;

    /**店铺详细信息*/
    private String storeInfo;

    /**店铺优化简介*/
    private String storeSeoDescription;

    /**店铺优化关键字*/
    private String storeSeoKeywords;

    /**二级域名前缀*/
    private String storeSecondDomain;

    /**收藏次数*/
    private int favoriteCount;

    /**经度*/
    private double storeLat;

    /**纬度*/
    private double storeLng;

    /**店铺开通时间*/
    private Date openingTime;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
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

    public int getStoreStatus() {
        return this.storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getBusinessImgId() {
        return this.businessImgId;
    }

    public void setBusinessImgId(String businessImgId) {
        this.businessImgId = businessImgId;
    }

    public String getBannerImgId() {
        return this.bannerImgId;
    }

    public void setBannerImgId(String bannerImgId) {
        this.bannerImgId = bannerImgId;
    }

    public String getLogoImgId() {
        return this.logoImgId;
    }

    public void setLogoImgId(String logoImgId) {
        this.logoImgId = logoImgId;
    }

    public int getStoreRecommend() {
        return this.storeRecommend;
    }

    public void setStoreRecommend(int storeRecommend) {
        this.storeRecommend = storeRecommend;
    }

    public Date getStoreRecommendTime() {
        return this.storeRecommendTime;
    }

    public void setStoreRecommendTime(Date storeRecommendTime) {
        this.storeRecommendTime = storeRecommendTime;
    }

    public Date getValidityTime() {
        return this.validityTime;
    }

    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    public String getStoreCredit() {
        return this.storeCredit;
    }

    public void setStoreCredit(String storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getStoreInfo() {
        return this.storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public String getStoreSeoDescription() {
        return this.storeSeoDescription;
    }

    public void setStoreSeoDescription(String storeSeoDescription) {
        this.storeSeoDescription = storeSeoDescription;
    }

    public String getStoreSeoKeywords() {
        return this.storeSeoKeywords;
    }

    public void setStoreSeoKeywords(String storeSeoKeywords) {
        this.storeSeoKeywords = storeSeoKeywords;
    }

    public String getStoreSecondDomain() {
        return this.storeSecondDomain;
    }

    public void setStoreSecondDomain(String storeSecondDomain) {
        this.storeSecondDomain = storeSecondDomain;
    }

    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public double getStoreLat() {
        return this.storeLat;
    }

    public void setStoreLat(double storeLat) {
        this.storeLat = storeLat;
    }

    public double getStoreLng() {
        return this.storeLng;
    }

    public void setStoreLng(double storeLng) {
        this.storeLng = storeLng;
    }

    public Date getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreManage{\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("gradeId:").append(this.gradeId).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("idNumber:").append(this.idNumber).append(",\n");
        strBuf.append("storeName:").append(this.storeName).append(",\n");
        strBuf.append("classId:").append(this.classId).append(",\n");
        strBuf.append("areaId:").append(this.areaId).append(",\n");
        strBuf.append("address:").append(this.address).append(",\n");
        strBuf.append("zip:").append(this.zip).append(",\n");
        strBuf.append("phone:").append(this.phone).append(",\n");
        strBuf.append("cardImgId:").append(this.cardImgId).append(",\n");
        strBuf.append("storeStatus:").append(this.storeStatus).append(",\n");
        strBuf.append("businessImgId:").append(this.businessImgId).append(",\n");
        strBuf.append("bannerImgId:").append(this.bannerImgId).append(",\n");
        strBuf.append("logoImgId:").append(this.logoImgId).append(",\n");
        strBuf.append("storeRecommend:").append(this.storeRecommend).append(",\n");
        strBuf.append("storeRecommendTime:").append(this.storeRecommendTime).append(",\n");
        strBuf.append("validityTime:").append(this.validityTime).append(",\n");
        strBuf.append("storeCredit:").append(this.storeCredit).append(",\n");
        strBuf.append("templateId:").append(this.templateId).append(",\n");
        strBuf.append("storeInfo:").append(this.storeInfo).append(",\n");
        strBuf.append("storeSeoDescription:").append(this.storeSeoDescription).append(",\n");
        strBuf.append("storeSeoKeywords:").append(this.storeSeoKeywords).append(",\n");
        strBuf.append("storeSecondDomain:").append(this.storeSecondDomain).append(",\n");
        strBuf.append("favoriteCount:").append(this.favoriteCount).append(",\n");
        strBuf.append("storeLat:").append(this.storeLat).append(",\n");
        strBuf.append("storeLng:").append(this.storeLng).append(",\n");
        strBuf.append("openingTime:").append(this.openingTime).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
