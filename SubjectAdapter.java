package com.example.localservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {
    private Context context;
    private List<subject_item> subjectList;

    public SubjectAdapter(Context context, List<subject_item> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return subjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false);

        subject_item subject = subjectList.get(position);

        TextView subjectName = convertView.findViewById(R.id.subjectName);
        TextView subjectCredits = convertView.findViewById(R.id.subjectCredits);

        subjectName.setText(subject.getName());
        subjectCredits.setText(String.valueOf(subject.getCredits()));

        return convertView;
    }
}
