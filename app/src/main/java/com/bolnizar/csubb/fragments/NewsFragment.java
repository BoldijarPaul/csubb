package com.bolnizar.csubb.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bolnizar.csubb.R;
import com.bolnizar.csubb.adapter.NewsAdapter;
import com.bolnizar.csubb.models.database.NewsRecord;
import com.bolnizar.csubb.mvp.NewsPresenter;
import com.bolnizar.csubb.mvp.NewsView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsView {

    private NewsAdapter mNewsAdapter;
    private NewsPresenter mNewsPresenter;

    @InjectView(R.id.news_recycler)
    RecyclerView mRecyclerView;
    @InjectView(R.id.news_empty_view)
    View mEmptyView;

    public NewsFragment() {
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsPresenter = new NewsPresenter(getContext(), this);
        mNewsAdapter = new NewsAdapter(mNewsPresenter);
        mRecyclerView.setAdapter(mNewsAdapter);
        mNewsPresenter.loadFromServer();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNews(List<NewsRecord> newsFromDatabase) {
        mEmptyView.setVisibility(newsFromDatabase.size() == 0 ? View.VISIBLE : View.INVISIBLE);
        mNewsAdapter.refresh();
    }
}
