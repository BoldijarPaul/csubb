package com.bolnizar.csubb.dagger;

import com.bolnizar.csubb.models.service.ApiService;
import com.bolnizar.csubb.mvp.NewsPresenter;

/**
 * Created by Paul on 6/27/2016.
 */
public interface AppGraph {
    void inject(BaseApp baseApp);
    void inject(NewsPresenter newsPresenter);
}
