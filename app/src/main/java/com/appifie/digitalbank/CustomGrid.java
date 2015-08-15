package com.appifie.digitalbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {
	private Context mContext;
	private final String[] button_name;
	private final int[] Imageid;
	private final int[] color;

	public CustomGrid(Context c, String[] button_name, int[] Imageid, int[] color) {
		mContext = c;
		this.Imageid = Imageid;
		this.button_name = button_name;
		this.color = color;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return button_name.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View grid;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			grid = new View(mContext);
			grid = inflater.inflate(R.layout.single_grid, null);
			TextView textView = (TextView) grid.findViewById(R.id.gtext);
			ImageView imageView = (ImageView) grid.findViewById(R.id.gico);
			textView.setText(button_name[position]);
			imageView.setImageResource(Imageid[position]);
			grid.setBackgroundResource(color[position]);
			// textView.setTextColor(co[position]);

		} else {
			grid = (View) convertView;
		}
		return grid;
	}
}
