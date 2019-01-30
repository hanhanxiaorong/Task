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
  @TableName("usr_real")
public class UsrReal extends BaseDTO<UsrReal> {

    /**真实姓名*/
    private String trueName;

    /**身份证号*/
    private String idNumber;

    /**照片关联*/
    private String photoId;

    /**用户ID*/
    private String userId;

    /**自定义用户名称*/
    @TableField(exist = false)
    private String userName;

    /**自定义图片路径*/
    @TableField(exist = false)
    private String path;

    public String getTrueName() {
        return this.trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("UsrReal{\n");
        strBuf.append("trueName:").append(this.trueName).append(",\n");
        strBuf.append("idNumber:").append(this.idNumber).append(",\n");
        strBuf.append("photoId:").append(this.photoId).append(",\n");
        strBuf.append("userId:").append(this.userId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
