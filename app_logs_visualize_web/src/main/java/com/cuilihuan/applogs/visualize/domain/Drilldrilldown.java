package com.cuilihuan.applogs.visualize.domain;

import java.util.ArrayList;
import java.util.List;

public class Drilldrilldown {
    String name;
    String id;
    List<List<Object>> data = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }
}