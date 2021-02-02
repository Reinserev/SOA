package com.ubb.pcis2083.soa.news.core.service;

import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.news.core.dao.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    private final LabelDao labelDao;

    @Autowired
    public LabelServiceImpl(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    @Override
    public Label createLabel(String name) {
        Label label = Label.newBuilder().setName(name).build();
        Long assignedId = labelDao.save(label);
        return labelDao.findById(assignedId);
    }

    @Override
    public List<Label> getAllLabels() {
        return labelDao.getAll();
    }

    @Override
    public Label updateLabel(Long labelId, String name) {
        Label label = Label.newBuilder().setId(labelId).setName(name).build();
        labelDao.update(label);
        return labelDao.findById(labelId);
    }

    @Override
    public Label deleteLabel(Long labelId) {
        Label label = labelDao.findById(labelId);
        labelDao.deleteById(labelId);
        return label;
    }

    @Override
    public Label findLabelByName(String name) {
        return labelDao.findLabelByName(name);
    }
}
