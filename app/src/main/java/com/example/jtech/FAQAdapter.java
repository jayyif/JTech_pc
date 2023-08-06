package com.example.jtech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FAQAdapter extends ArrayAdapter<FAQItem> {

    public FAQAdapter(Context context, ArrayList<FAQItem> faqItems) {
        super(context, 0, faqItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FAQItem faqItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_faq, parent, false);
        }

        TextView questionTextView = convertView.findViewById(R.id.questionTextView);
        TextView answerTextView = convertView.findViewById(R.id.answerTextView);

        questionTextView.setText(faqItem.getQuestion());
        answerTextView.setText(faqItem.getAnswer());

        return convertView;
    }
}