package com.json.mediationsdk.bidding;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface BiddingDataCallback {
    void onFailure(String str);

    void onSuccess(Map<String, Object> map);
}
