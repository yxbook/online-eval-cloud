package com.sjy.eval.oss.controller;

import com.eval.common.base.BaseEnum;
import com.eval.common.base.BaseResult;
import com.sjy.eval.oss.entity.Article;
import com.sjy.eval.oss.entity.Author;
import com.sjy.eval.oss.entity.Tutorial;
import com.sjy.eval.oss.service.ArticleSearchRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-26 09:56
 **/
@RestController
@RequestMapping("/user")
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleSearchRepository articleSearchRepository;


    @PostMapping("createIndex")
    public BaseResult testSaveArticleIndex(){
        Author author=new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial=new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article =new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        return new BaseResult(BaseEnum.SUCCESS.getStatus(), "创建成功", true);
    }



    @PutMapping("search")
    public BaseResult testSearch(@RequestParam("searchField") String searchField){
        LOGGER.info("输入参数searchField=" + searchField);
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(searchField);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        return new BaseResult(BaseEnum.SUCCESS.getStatus(), "查询成功", iterator);

    }

    @PutMapping("index")
    public BaseResult index() {
        LOGGER.debug("debug测试debug");
        LOGGER.info("info测试info");
        LOGGER.warn("warn测试为人类历史");
        LOGGER.error("error奥术大师");
        return new BaseResult(BaseEnum.SUCCESS.getStatus(), "查询成功", true);
    }



}
