package com.ubb.pcis2083.soa.news.core.dto.converter;

/**
 * Created by radu.
 */

public interface Converter<Model, Dto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

