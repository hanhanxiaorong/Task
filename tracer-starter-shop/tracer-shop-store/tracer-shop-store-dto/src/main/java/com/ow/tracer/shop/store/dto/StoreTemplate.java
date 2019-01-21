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
  @TableName("store_template")
public class StoreTemplate extends BaseDTO<StoreTemplate> {

    /**标题*/
    private String title;

    /**路径*/
    private String path;

    /**开关状态*/
    private int open;

    /**介绍*/
    private String info;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOpen() {
        return this.open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreTemplate{\n");
        strBuf.append("title:").append(this.title).append(",\n");
        strBuf.append("path:").append(this.path).append(",\n");
        strBuf.append("open:").append(this.open).append(",\n");
        strBuf.append("info:").append(this.info).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
