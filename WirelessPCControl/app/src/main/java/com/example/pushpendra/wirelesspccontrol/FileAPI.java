package com.example.pushpendra.wirelesspccontrol;

public class FileAPI {
	public String getExternalStoragePath() {
		String internal = System.getenv("EXTERNAL_STORAGE");
		String sdCard = System.getenv("SECONDARY_STORAGE");
		//System.out.println(internal);
		//System.out.println(sdCard);
        if (sdCard == null || sdCard.equals("")) {
            return internal;
        }
		return sdCard;

	}
}
