package com.ubb.pcis2083.soa.labels.dao;

import com.ubb.pcis2083.soa.common.dao.Dao;
import com.ubb.pcis2083.soa.common.misc.SOAException;
import com.ubb.pcis2083.soa.labels.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelDao implements Dao<Long, Label> {
    private Map<Long, Label> labels = new HashMap<>();
    private Long seed = -1L;

    public LabelDao(Boolean addInitialData) {
        Label external = Label.newBuilder().setName("EXTERNAL").build();
        save(external);

        if (addInitialData == true) {
            populate();
        }
    }

    private void populate() {
        Label first = Label.newBuilder().setName("sports").build();
        Label second = Label.newBuilder().setName("politics").build();
        Label third = Label.newBuilder().setName("tech").build();
        List<Label> labelsToAdd = List.of(first, second, third);
        for (Label label : labelsToAdd) {
            save(label);
        }
    }

    @Override
    public List<Label> getAll() {
        return new ArrayList<>(labels.values());
    }

    @Override
    public Long save(Label entity) {
        Label label = Label.newBuilder().setId(++seed).setName(entity.getName()).build();
        labels.put(label.getId(),label);
        return label.getId();
    }

    @Override
    public void delete(Label entity) {
        if (labels.containsKey(entity.getId())) {
            labels.remove(entity.getId());
        } else {
            System.out.println("Noting to delete.");
        }
    }

    @Override
    public void update(Label entity) {
        if (labels.containsKey(entity.getId())) {
            labels.put(entity.getId(), entity);
        } else {
            throw new SOAException("Label with ID: " + entity.getId() + " does not exist");
        }
    }

    @Override
    public Label findById(Long id) {
        if (labels.containsKey(id)) {
            return labels.get(id);
        } else {
            throw new SOAException("No entity with id " + id + " exists.");
        }
    }

    @Override
    public void deleteById(Long id) {
        if (labels.containsKey(id)) {
            labels.remove(id);
        } else {
            System.out.println("Noting to delete.");
        }
    }
}
