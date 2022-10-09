package com.horsesf.bootlanuch.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horsesf.bootlanuch.AjaxResponse;
import com.horsesf.bootlanuch.model.Article;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    // 查询文章，根据id
    // @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable long id){
        Article article = Article.builder()
                .id(1L)
                .author("horsesf")
                .content("Spring boot")
                .createTime(new Date())
                .title("t1").build();

        log.info("getArticle", article);

        return AjaxResponse.success(article);
    }

    // 新增文章
    // @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){

        log.info("saveArticle", article);

        return AjaxResponse.success();
    }

    // 修改文章
    // @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            // TODO 抛出异常
        }

        log.info("updateArticle", article);

        return AjaxResponse.success();
    }

    // 删除文章，根据id
    // @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable long id){

        log.info("deleteArticle", id);

        return AjaxResponse.success();
    }
}
