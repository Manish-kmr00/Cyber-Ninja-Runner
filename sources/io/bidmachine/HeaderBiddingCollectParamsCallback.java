package io.bidmachine;

import io.bidmachine.utils.BMError;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface HeaderBiddingCollectParamsCallback {
    void onCollectFail(BMError bMError);

    void onCollectFinished(Map<String, String> map);
}
