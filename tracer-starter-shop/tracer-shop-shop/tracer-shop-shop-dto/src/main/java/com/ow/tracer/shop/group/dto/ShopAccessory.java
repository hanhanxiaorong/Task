package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [相册图片表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_accessory")
public class ShopAccessory extends BaseDTO<ShopAccessory> {

    /**宽度*/
    private double width;

    /**高度*/
    private double height;

    /**大小*/
    private double size;

    /**后缀*/
    private String suffix;

    /**路径*/
    private String path;

    /**图片名称*/
    private String name;

    /**用户ID*/
    private String userId;

    /**文件类型*/
    private int type;

    /**相册ID*/
    private String albumId;

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopAccessory{\n");
        strBuf.append("width:").append(this.width).append(",\n");
        strBuf.append("height:").append(this.height).append(",\n");
        strBuf.append("size:").append(this.size).append(",\n");
        strBuf.append("suffix:").append(this.suffix).append(",\n");
        strBuf.append("path:").append(this.path).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("albumId:").append(this.albumId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
