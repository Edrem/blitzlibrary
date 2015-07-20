package com.mangablitz.api;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchInfo implements Parcelable {
	public String searchTerm;
	public List<String> includeGenres = null;
	public List<String> excludegenres = null;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(searchTerm);
		dest.writeList(includeGenres);
		dest.writeList(excludegenres);
	}

	public static final Parcelable.Creator<SearchInfo> CREATOR = new Parcelable.Creator<SearchInfo>() {
		public SearchInfo createFromParcel(Parcel in) {
			return new SearchInfo(in);
		}

		public SearchInfo[] newArray(int size) {
			return new SearchInfo[size];
		}
	};

	public SearchInfo(Parcel in) {
		if (in != null) {
			searchTerm = in.readString();
			includeGenres = new ArrayList<String>();
			in.readList(includeGenres, null);
			excludegenres = new ArrayList<String>();
			in.readList(excludegenres, null);
		}
	}

	public SearchInfo() {
		includeGenres = new ArrayList<String>();
		excludegenres = new ArrayList<String>();
	}
}
