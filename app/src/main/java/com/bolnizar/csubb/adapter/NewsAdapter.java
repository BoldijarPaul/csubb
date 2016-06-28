package com.bolnizar.csubb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolnizar.csubb.R;
import com.bolnizar.csubb.models.database.NewsRecord;
import com.bolnizar.csubb.mvp.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Paul on 6/28/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private NewsPresenter mNewsPresenter;
    private List<NewsRecord> mRecordList = new ArrayList<>();

    public NewsAdapter(NewsPresenter newsPresenter) {
        mNewsPresenter = newsPresenter;
    }

    public void refresh() {
        mRecordList = mNewsPresenter.getNewsFromDatabase();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsRecord newsRecord = mRecordList.get(position);
        holder.title.setText(newsRecord.title);
        holder.subtitle.setText(newsRecord.description);
    }

    @Override
    public int getItemCount() {
        return mRecordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.news_title)
        TextView title;
        @InjectView(R.id.news_subtitle)
        TextView subtitle;

        public ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
            ButterKnife.inject(this, itemView);
        }
    }
}
