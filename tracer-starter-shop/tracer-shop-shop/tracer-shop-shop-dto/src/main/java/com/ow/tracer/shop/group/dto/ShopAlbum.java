package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [相册表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_album")
public class ShopAlbum extends BaseDTO<ShopAlbum> {

    /**相册名称*/
    private String alblumName;

    /**相册信息*/
    private String alblumInfo;

    /**是否默认相册*/
    private int albumDefault;

    /**相册排序*/
    private int albumSequence;

    /**用户ID*/
    private String userId;

    public String getAlblumName() {
        return this.alblumName;
    }

    public void setAlblumName(String alblumName) {
        this.alblumName = alblumName;
    }

    public String getAlblumInfo() {
        return this.alblumInfo;
    }

    public void setAlblumInfo(String alblumInfo) {
        this.alblumInfo = alblumInfo;
    }

    public int getAlbumDefault() {
        return this.albumDefault;
    }

    public void setAlbumDefault(int albumDefault) {
        this.albumDefault = albumDefault;
    }

    public int getAlbumSequence() {
        return this.albumSequence;
    }

    public void setAlbumSequence(int albumSequence) {
        this.albumSequence = albumSequence;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopAlbum{\n");
        strBuf.append("alblumName:").append(this.alblumName).append(",\n");
        strBuf.append("alblumInfo:").append(this.alblumInfo).append(",\n");
        strBuf.append("albumDefault:").append(this.albumDefault).append(",\n");
        strBuf.append("albumSequence:").append(this.albumSequence).append(",\n");
        strBuf.append("userId:").append(this.userId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
