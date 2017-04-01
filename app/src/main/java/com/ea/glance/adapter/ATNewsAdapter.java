package com.ea.glance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ea.glance.entity.EVNewsEntity;
import com.ea.glance.glance.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ATNewsAdapter extends RecyclerView.Adapter<ATNewsAdapter.ATViewHolder> {

    private List<EVNewsEntity>  newses;
    Context mContext;
    public ATNewsAdapter(List newses,Context context){
        this.newses = newses;
        this.mContext = context;
    }

    public ATNewsAdapter.ATViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ATNewsAdapter.ATViewHolder viewHolder = new ATNewsAdapter.ATViewHolder(view);
        final ATViewHolder holder = new ATViewHolder(view);
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                //newses.get(position).getNewsContent();//获取正文
                Toast.makeText(mContext,"sss",Toast.LENGTH_SHORT).show();

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ATViewHolder holder, int position) {
        EVNewsEntity news = newses.get(position);
        holder.title.setText(news.getTitle());
        holder.content.setText(news.getDigest());
        holder.time.setText(news.getPtime());
        Glide.with(mContext).load(news.getImgsrc()).placeholder(R.mipmap.ic_launcher).error(R.drawable.s).into(holder.image);
    }

    @Override
    public int getItemCount()
        {
            return newses.size();
        }


    class ATViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title) TextView title;
        @BindView(R.id.content)TextView content;
        @BindView(R.id.image)ImageView image;
        @BindView(R.id.time)TextView time;

//        TextView title;
//        TextView content;
//        ImageView image;
//        TextView time;

        View newsView;
        public ATViewHolder(View itemView) {
            super(itemView);
//            title = (TextView)itemView.findViewById(R.id.title);
//            content = (TextView)itemView.findViewById(R.id.content);
//            time = (TextView)itemView.findViewById(R.id.time);
//            image = (ImageView)itemView.findViewById(R.id.image);
            newsView = itemView;
            ButterKnife.bind(this,itemView);

        }
    }


}