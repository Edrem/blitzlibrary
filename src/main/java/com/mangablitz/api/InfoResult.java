package com.mangablitz.api;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class InfoResult implements Parcelable {
	public String name;
	public String metaData;
	public String description;
	public String coverUrl;
	public List<Chapter> chapters = null;
	public boolean ongoing = false;
	public boolean singular = false;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(metaData);
		dest.writeString(description);
		dest.writeString(coverUrl);
		dest.writeList(chapters);
		dest.writeInt((ongoing) ? 1 : 0);
		dest.writeInt((singular) ? 1 : 0);
	}

	public static final Parcelable.Creator<InfoResult> CREATOR = new Parcelable.Creator<InfoResult>() {
		public InfoResult createFromParcel(Parcel in) {
			return new InfoResult(in);
		}

		public InfoResult[] newArray(int size) {
			return new InfoResult[size];
		}
	};

	public InfoResult(Parcel in) {
		if (in != null) {
			name = in.readString();
			metaData = in.readString();
			description = in.readString();
			coverUrl = in.readString();
			chapters = new ArrayList<Chapter>();
			in.readList(chapters, Chapter.class.getClassLoader());
			ongoing = in.readInt() > 0;
			singular = in.readInt() > 0;
		}
	}

	public InfoResult() {
	}
}