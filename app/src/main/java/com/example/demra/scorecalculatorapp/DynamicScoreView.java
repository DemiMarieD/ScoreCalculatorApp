package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamicScoreView {
    Context ctx;
    public DynamicScoreView(Context ctx)
    {
        this.ctx=ctx;
    }
    public TextView nameTextView(Context context, String text)
    {
        final ViewGroup.LayoutParams lparams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView=new TextView(context);
        textView.setLayoutParams(lparams);
        textView.setText(" "+text+ " ");
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return textView;
    }

    public TextView scoreTextView(Context context, int score)
    {
        final ViewGroup.LayoutParams lparams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView=new TextView(context);
        textView.setLayoutParams(lparams);
        textView.setText(" "+score+ " ");
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return textView;
    }
}
