package com.ea.glance.glance.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.ea.glance.glance.R;
import com.ea.glance.glance.adapter.ATNewsAdapter;
import com.ea.glance.glance.presenter.ATNewsPresenter;
import com.ea.glance.glance.view.ATINewsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ATMainActivity extends AppCompatActivity implements ATINewsView{
    @BindView(R.id.news_list) RecyclerView mRecyclerView;
    List l;
    ATNewsPresenter presenter = new ATNewsPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.loadNews();
        ButterKnife.bind(this);
        LinearLayoutManager a = new LinearLayoutManager(this);
        Glide.with(this);
        mRecyclerView.setLayoutManager(a);
        mRecyclerView.setAdapter(new ATNewsAdapter(l,this));

    }

    @Override
    public void setList(List l) {
        this.l = l;
    }
}
