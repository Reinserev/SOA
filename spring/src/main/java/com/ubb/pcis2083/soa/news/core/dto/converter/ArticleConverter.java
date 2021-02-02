package com.ubb.pcis2083.soa.news.core.dto.converter;

import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.news.core.dto.ArticleDto;
import com.ubb.pcis2083.soa.news.core.service.LabelService;
import com.ubb.pcis2083.soa.news.core.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleConverter extends AbstractConverter<Article, ArticleDto> {

    @Override
    public Article convertDtoToModel(ArticleDto articleDto) {
        return Article.newBuilder()
                .setTitle(articleDto.getTitle())
                .setText(articleDto.getTitle())
                .setLabelId(articleDto.getLabel())
                .build();
    }

    @Override
    public ArticleDto convertModelToDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setText(article.getText());
        articleDto.setLabel(article.getLabelId());
        return articleDto;
    }

    public ArticleDto convertModeltoDtoModded(Article article)
    {
        ArticleDto articleDto = convertModelToDto(article);
        articleDto.setId(article.getId());
        articleDto.setText(Utils.cleanString(articleDto.getText()));
        articleDto.setTitle(Utils.cleanString(articleDto.getTitle()));
        return articleDto;
    }

    public List<ArticleDto> convertModelsToDtosModded(List<Article> models) {
        return models.stream()
                .map(this::convertModeltoDtoModded)
                .collect(Collectors.toList());
    }
}
