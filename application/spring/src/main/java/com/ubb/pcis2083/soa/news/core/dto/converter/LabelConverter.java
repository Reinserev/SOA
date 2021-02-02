package com.ubb.pcis2083.soa.news.core.dto.converter;

import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.news.core.dto.LabelDto;
import org.springframework.stereotype.Component;

@Component
public class LabelConverter extends AbstractConverter<Label, LabelDto> {
    @Override
    public Label convertDtoToModel(LabelDto labelDto) {
        return Label.newBuilder().setName(labelDto.getName()).build();
    }

    @Override
    public LabelDto convertModelToDto(Label label) {
        LabelDto labelDto = new LabelDto();
        labelDto.setName(label.getName());
        labelDto.setId(label.getId());
        return labelDto;
    }
}
