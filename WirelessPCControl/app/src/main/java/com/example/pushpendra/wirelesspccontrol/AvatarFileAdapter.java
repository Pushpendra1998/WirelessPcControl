package com.example.pushpendra.wirelesspccontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import file.AvatarFile;

public class AvatarFileAdapter extends ArrayAdapter<AvatarFile> {
	Context context;
	int layoutResourceID;
	ArrayList<AvatarFile> objects;
	public AvatarFileAdapter(Context context, int layoutResourceID,
                             ArrayList<AvatarFile> objects) {
		super(context, layoutResourceID, objects);
		this.context = context;
		this.layoutResourceID = layoutResourceID;
		this. objects = objects;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		AvatarFileHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = NavigationDrawerItemAdapter.scanForActivity(context).getLayoutInflater();
			row = inflater.inflate(layoutResourceID, parent, false);
			holder = new AvatarFileHolder();
			holder.icon = (ImageView) row.findViewById(R.id.avatarImageView);
			holder.avatarHeading = (TextView) row.findViewById(R.id.avatarHeadingTextView);
			holder.avatarSubheading = (TextView) row.findViewById(R.id.avatarSubheadingTextView);
			row.setTag(holder);
		} else {
			holder = (AvatarFileHolder) row.getTag();
		}
		AvatarFile item = objects.get(position);
		Bitmap bitmap;
		Utility utility = new Utility();
		String type = item.getType();
		if (type.equals("image")) {
			//files from server has icon -1
			if (item.getIcon() != -1) {
				bitmap = utility.decodeImageFile(item.getPath());
				holder.icon.setImageBitmap(bitmap);
			} else {
				holder.icon.setImageResource(R.mipmap.image);
			}
		} else if (type.equals("mp3")) {
			holder.icon.setImageResource(R.mipmap.music_png);
		} else if (type.equals("pdf")) {
			holder.icon.setImageResource(R.mipmap.pdf);
		} else if (type.equals("file")) {
			holder.icon.setImageResource(R.mipmap.file);
		} else if (type.equals("folder")) {
			holder.icon.setImageResource(R.mipmap.folder);
		}
		holder.avatarHeading.setText(item.getHeading());
		holder.avatarSubheading.setText(item.getSubheading());
		return row;
	}
    static class AvatarFileHolder {
    	ImageView icon;
    	TextView avatarHeading, avatarSubheading;
    }
}
