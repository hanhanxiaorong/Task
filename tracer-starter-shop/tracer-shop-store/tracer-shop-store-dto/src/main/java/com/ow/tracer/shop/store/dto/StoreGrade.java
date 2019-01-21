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
  @TableName("store_grade")
public class StoreGrade extends BaseDTO<StoreGrade> {

    /**名称*/
    private String name;

    /**价格*/
    private double price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreGrade{\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("price:").append(this.price).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
