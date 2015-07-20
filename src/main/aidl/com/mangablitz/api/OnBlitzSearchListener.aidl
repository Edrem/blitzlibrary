package com.mangablitz.api;

import com.mangablitz.api.SearchResult;

interface OnBlitzSearchListener {
	void onSearchResult(in int resultCode, in SearchResult result);
	boolean checkCoverExists(in String name);
}