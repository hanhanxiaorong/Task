package com.ow.tracer.shop.store.dto;

import com.ow.tracer.common.vo.TreeNode;

import java.util.List;

/**
 * @auther: Easy
 * @date: 19-1-10 22:19
 * @description:
 */
public class StoreFeatureTree  extends TreeNode {
        private String featureName;
        private String shopName;
        private int type;
        private int level;
        private int approveStatus;
        private String classId;
        private String className;


    public StoreFeatureTree(StoreFeature storeFeature) {
        super();
        this.approveStatus=storeFeature.getApproveStatus();
        this.shopName=storeFeature.getUserId();
        this.classId=storeFeature.getClassId();
        this.featureName=storeFeature.getFeatureName();
        this.level = storeFeature.getLevel();
        this.id = storeFeature.getId();
        this.type=storeFeature.getType();
        this.parentId=storeFeature.getParentId();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(int approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
