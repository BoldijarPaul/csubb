package com.bolnizar.csubb.mvp;

import com.bolnizar.csubb.models.database.NewsRecord;

import java.util.List;

/**
 * Created by Paul on 6/27/2016.
 */
public interface NewsView {
    void showError();

    void showNews(List<NewsRecord> newsFromDatabase);
}
