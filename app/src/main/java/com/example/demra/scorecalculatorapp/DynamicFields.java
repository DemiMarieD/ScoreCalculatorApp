package com.example.demra.scorecalculator;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DynamicFields {
    Context ctx;

    public DynamicFields(Context ctx) {
        this.ctx = ctx;
    }
    public TextView labelTextView(Context context, String text)
    {
        final ViewGroup.LayoutParams lparams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView=new TextView(context);
        textView.setLayoutParams(lparams);
        textView.setText(" "+text+ " ");
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return textView;
    }

    public EditText inputPlayerName(Context context, int id)
    {
        final ViewGroup.LayoutParams lparams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText=new EditText(context);
        editText.setId(id);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setWidth(500);
        return editText;
    }
}
