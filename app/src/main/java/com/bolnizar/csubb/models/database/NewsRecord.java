package com.bolnizar.csubb.models.database;

import com.bolnizar.csubb.models.NewsModel;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Paul on 6/28/2016.
 */
public class NewsRecord extends SugarRecord {
    public String title;

    @Unique
    public String link;
    public String pubDate;
    public String author;
    public String description;
    public String content;

    public void loadFromNews(NewsModel newsModel) {
        title = newsModel.title;
        link = newsModel.link;
        pubDate = newsModel.pubDate;
        author = newsModel.author;
        description = newsModel.description;
        content = newsModel.content;
    }
}
