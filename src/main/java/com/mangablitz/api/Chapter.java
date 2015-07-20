package com.mangablitz.api;

import android.os.Parcel;
import android.os.Parcelable;

public class Chapter implements Parcelable {
	//@formatter:off
	public int     number;
	public String  name;
	public int     state;
	public String  metaData;
	//@formatter:on

	public static final Parcelable.Creator<Chapter> CREATOR = new Parcelable.Creator<Chapter>() {
		public Chapter createFromParcel(Parcel in) {
			return new Chapter(in);
		}

		public Chapter[] newArray(int size) {
			return new Chapter[size];
		}
	};

	public Chapter(int id, String name, int state, String metaData) {
		this.number = id;
		this.name = name;
		this.state = state;
		this.metaData = metaData;
	}

	private Chapter(Parcel in) {
		number = in.readInt();
		name = in.readString();
		state = in.readInt();
		metaData = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(number);
		dest.writeString(name);
		dest.writeInt(state);
		dest.writeString(metaData);
	}
}