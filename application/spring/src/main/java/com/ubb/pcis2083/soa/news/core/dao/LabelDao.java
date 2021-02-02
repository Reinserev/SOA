package com.ubb.pcis2083.soa.news.core.dao;


import com.ubb.pcis2083.soa.labels.Label;

public interface LabelDao extends Dao<Long, Label> {
    Label findLabelByName(String name);
}
