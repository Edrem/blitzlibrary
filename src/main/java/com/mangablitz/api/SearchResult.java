package com.mangablitz.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class SearchResult implements Parcelable {
	static final public int NO_RESULTS = 0;
	static final public int ERROR = 1;
	static final public int NEW = 2;
	static final public int UPDATE = 3;

	public String name;
	public Bitmap image;
	public String url;
	public String metaData;
	public String coverUrl;

	public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
		public SearchResult createFromParcel(Parcel in) {
			return new SearchResult(in);
		}

		public SearchResult[] newArray(int size) {
			return new SearchResult[size];
		}
	};

	public SearchResult() {
	}

	private SearchResult(Parcel in) {
		name = in.readString();
		coverUrl = in.readString();
		url = in.readString();
		metaData = in.readString();
	}

	public SearchResult(String name, String coverUrl, Bitmap image, String url) {
		this.name = name;
		this.coverUrl = coverUrl;
		this.image = image;
		this.url = url;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(coverUrl);
		dest.writeString(url);
		dest.writeString(metaData);
	}

	public void readFromParcel(Parcel in) {
		name = in.readString();
		coverUrl = in.readString();
		url = in.readString();
		metaData = in.readString();
	}
}