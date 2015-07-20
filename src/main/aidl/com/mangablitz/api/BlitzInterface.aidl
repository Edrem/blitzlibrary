package com.mangablitz.api;

import com.mangablitz.api.OnBlitzSearchListener;
import com.mangablitz.api.OnBlitzInfoListener;
import com.mangablitz.api.OnBlitzPageListener;
import com.mangablitz.api.DownloadData;
import com.mangablitz.api.SearchInfo;
import com.mangablitz.api.PageItem;

interface BlitzInterface {
	void getInfo(in String name, in String metaData, in OnBlitzInfoListener callback);
	void preparePageData(in DownloadData downloadData, in OnBlitzPageListener callback);
	PageItem getPageData(in int position);
	void kill();
	void search(in SearchInfo searchInfo, in OnBlitzSearchListener callback);
}