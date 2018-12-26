package com.sjy.eval.oss.service;

import com.sjy.eval.oss.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-26 09:55
 **/
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
