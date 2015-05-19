package com.asia.recycleviewdemo;

import com.asia.recycleviewdemo.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button button;
        private final ProgressBar progressBar;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textview);
            button = (Button) v.findViewById(R.id.button);
            progressBar = (ProgressBar) v.findViewById(R.id.progress);
        }

        public TextView getTextView() {
            return textView;
        }
        
        public Button getButton() {
            return button;
        }
        
        public ProgressBar getProgressBar() {
            return progressBar;
        }
    }
    
    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(mDataSet[position]);
        viewHolder.getButton().setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                viewHolder.getTextView().setText("点我");
                mDataSet[position] = "点我!";
                new Thread(new MyRunable(viewHolder.getProgressBar())).start();
            }
        });
    }
    
    class MyRunable implements Runnable{
        private int progress = 0;
        private ProgressBar bar;
        public MyRunable(ProgressBar bar){
            this.bar = bar;
        }

        @Override
        public void run() {
            while (progress < 101) {
                System.out.println(progress);
                bar.setProgress(progress);
                progress++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
