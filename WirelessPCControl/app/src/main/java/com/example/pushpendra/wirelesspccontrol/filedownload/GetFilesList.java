package com.example.pushpendra.wirelesspccontrol.filedownload;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import file.AvatarFile;
import com.example.pushpendra.wirelesspccontrol.AvatarFileAdapter;

class GetFilesList extends GetFilesListFromServer {
    ListView fileDownloadListView;
    Context context;
	GetFilesList(ListView fileDownloadListView, Context context) {
		this.fileDownloadListView = fileDownloadListView;
		this.context = context;
	}
	@Override
	public void receiveData(Object result) {
		ArrayList<AvatarFile> filesInFolder = (ArrayList<AvatarFile>) result;
		if (filesInFolder != null) {
			fileDownloadListView.setAdapter(new AvatarFileAdapter(context,
					com.example.pushpendra.wirelesspccontrol.R.layout.music_image_avatar, filesInFolder));
		} else {
			Toast.makeText(context, "Not Connected to PC", Toast.LENGTH_LONG).show();
		}
		
	}
	
}
