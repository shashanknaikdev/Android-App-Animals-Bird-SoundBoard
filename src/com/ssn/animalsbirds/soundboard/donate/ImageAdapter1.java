package com.ssn.animalsbirds.soundboard.donate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter1 extends BaseAdapter {
	private Context mContext;

	public ImageAdapter1(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			imageView = new ImageView(mContext);
			// DisplayMetrics displayMetrics = new DisplayMetrics();

			imageView.setLayoutParams(new GridView.LayoutParams(
					android.view.ViewGroup.LayoutParams.FILL_PARENT,
					android.view.ViewGroup.LayoutParams.FILL_PARENT));
			// imageView.
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(0, 0, 0, 0);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);

		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.bear_1, R.drawable.cat_1,
			R.drawable.dog_1, R.drawable.elephant_1, R.drawable.pig_1,
			R.drawable.horse_1, R.drawable.lion_1, R.drawable.tiger_1 };
}