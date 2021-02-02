package com.ubb.pcis2083.soa.news.core.service;

import com.ubb.pcis2083.soa.labels.Label;

import java.util.List;

public interface LabelService {
    Label createLabel(String name);
    List<Label> getAllLabels();
    Label updateLabel(Long labelId, String name);
    Label deleteLabel(Long labelId);
    Label findLabelByName(String name);
}
