package com.mindata.ecserver.main.model.secondary;

import com.mindata.ecserver.main.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hanliqiang wrote on 2017/11/15
 */
@Entity
@Table(name = "pt_customer_tag")
public class PtCustomerTag extends BaseEntity {
    /**
     * 标签ID
     */
    private Long classId;
    /**
     * 标签名称
     */
    private String className;
    /**
     * 分组排序或者标签排序
     */
    private Integer sort;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}