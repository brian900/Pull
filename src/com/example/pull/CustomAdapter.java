package com.example.pull;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Person> data;//modify here
	public CustomAdapter(Context context, ArrayList<Person> data) //modify here
	{
		this.mContext = context;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}
	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}
	@Override
	public long getItemId(int id) {
		return id;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//modify here
			viewHolder = new ViewHolder();
			viewHolder.textViewNames = (TextView) convertView.findViewById(R.id.tvNames);//modify here
			viewHolder.textViewEmail = (TextView) convertView.findViewById(R.id.tvEmail);//modify here
			viewHolder.textViewId = (TextView) convertView.findViewById(R.id.tvId);//modify here
			viewHolder.textViewCity = (TextView) convertView.findViewById(R.id.tvCity);//modify here
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Person p = data.get(position);//modify here
		viewHolder.textViewNames.setText(p.getNames());//modify here
		viewHolder.textViewEmail.setText(p.getEmail());//modify here
		viewHolder.textViewId.setText(p.getId());//modify here
		viewHolder.textViewCity.setText(p.getCity());//modify here
		return convertView;
	}
	static class ViewHolder {
		TextView textViewNames;//modify here
		TextView textViewEmail;//modify here
		TextView textViewId;//modify here
		TextView textViewCity;//modify here
	}
}
