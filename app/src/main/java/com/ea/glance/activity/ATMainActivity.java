package com.ea.glance.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ea.glance.glance.R;
import com.ea.glance.adapter.ATNewsAdapter;
import com.ea.glance.presenter.ATNewsPresenter;
import com.ea.glance.view.ATINewsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ATMainActivity extends AppCompatActivity implements ATINewsView{
    @BindView(R.id.news_list)
    RecyclerView mRecyclerView;
    ATNewsPresenter presenter = new ATNewsPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.loadNews();
    }
    @Override
    public void initList(List list) {
        LinearLayoutManager a = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(a);
        mRecyclerView.setAdapter(new ATNewsAdapter(list, this));
    }
}
