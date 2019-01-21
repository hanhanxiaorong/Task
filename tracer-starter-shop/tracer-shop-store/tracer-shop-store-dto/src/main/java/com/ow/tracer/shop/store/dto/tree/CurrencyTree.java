package com.ow.tracer.shop.store.dto.tree;

import com.ow.tracer.common.vo.TreeNode;
import com.ow.tracer.shop.store.dto.StoreFeature;

import java.util.List;

/**
 * @auther: Easy
 * @date: 19-1-17 19:03
 * @description:
 */
public class CurrencyTree extends TreeNode {
    private String id;
    private String label;
    public CurrencyTree(StoreFeature storeFeature) {
        super();
        this.label=storeFeature.getFeatureName();
        this.id = storeFeature.getId();
        this.parentId=storeFeature.getParentId();
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
