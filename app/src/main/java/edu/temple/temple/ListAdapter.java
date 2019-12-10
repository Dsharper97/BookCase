package edu.temple.temple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context Context;
    ArrayList<String> Data;
    public ListAdapter(Context context, ArrayList<String> data){
        this.Context = context;
        this.Data = data;
    }

    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.get(position);
    }

    @Override
    public long getItemId(int Position) {
        return Position;
    }

    @Override
    public View getView(int Position, View convertView, ViewGroup Parent) {
        TextView Label = new TextView(Context);
        Label.setId(Position);
        Label.setText(Data.get(Position));
        Label.setTextSize(20);
        Label.setPadding(16, 25, 16, 25);

        return Label;
    }
}
