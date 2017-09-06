package com.app.entity;

import org.apache.ibatis.mapping.FetchType;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable {

    private static final long serialVersionUID = 82448545945073751L;
    private Integer id;

    private String name;

    private String description;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}