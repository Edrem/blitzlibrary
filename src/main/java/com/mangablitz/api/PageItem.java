package com.mangablitz.api;

import android.os.Parcel;
import android.os.Parcelable;

public class PageItem implements Parcelable {
	//@formatter:off
	public int pageNumber = 0;
	public String pageUrl = "";
	//@formatter:on

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(pageNumber);
		dest.writeString(pageUrl);
	}

	public static final Parcelable.Creator<PageItem> CREATOR = new Parcelable.Creator<PageItem>() {
		public PageItem createFromParcel(Parcel in) {
			return new PageItem(in);
		}

		public PageItem[] newArray(int size) {
			return new PageItem[size];
		}
	};

	public PageItem(Parcel in) {
		if (in != null) {
			pageNumber = in.readInt();
			pageUrl = in.readString();
		}
	}
}