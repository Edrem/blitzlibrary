package com.mangablitz.api;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadData implements Parcelable {
	public String name;
	public int pages = 0;
	public String metaData;
	public List<PageItem> pageItems = null;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(pages);
		dest.writeString(metaData);
		dest.writeList(pageItems);
	}

	public static final Parcelable.Creator<DownloadData> CREATOR = new Parcelable.Creator<DownloadData>() {
		public DownloadData createFromParcel(Parcel in) {
			return new DownloadData(in);
		}

		public DownloadData[] newArray(int size) {
			return new DownloadData[size];
		}
	};

	public DownloadData(Parcel in) {
		if (in != null) {
			name = in.readString();
			pages = in.readInt();
			metaData = in.readString();
			pageItems = new ArrayList<PageItem>();
			in.readList(pageItems, PageItem.class.getClassLoader());
		}
	}

	public DownloadData() {
		pageItems = new ArrayList<PageItem>();
	}
}