package com.pubmatic.sdk.common.network;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;

/* JADX INFO: loaded from: classes11.dex */
public class POBRequestQueue extends RequestQueue {
    POBRequestQueue(Cache cache, Network network) {
        super(cache, network);
    }
}
