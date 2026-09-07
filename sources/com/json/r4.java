package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e2 f4214a;

    public r4(e2 e2Var) {
        this.f4214a = e2Var;
    }

    String a(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder("interstitial=");
        sb.append(i).append(";rewarded=").append(i2).append(";banner=").append(i3).append(";native=").append(i4);
        return sb.toString();
    }

    public void a() {
        this.f4214a.a(b2.AUCTION_REQUEST, null);
    }

    public void a(int i, String str) {
        HashMap map = new HashMap();
        map.put("errorCode", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f4214a.a(b2.AUCTION_FAILED_NO_CANDIDATES, map);
    }

    public void a(long j, int i, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put("errorCode", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f4214a.a(b2.AUCTION_FAILED, map);
    }

    public void a(long j, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f4214a.a(b2.AUCTION_SUCCESS, map);
    }

    public void a(String str) {
        HashMap map = new HashMap();
        map.put("auctionId", str);
        this.f4214a.a(b2.AD_FORMAT_CAPPED, map);
    }

    public void b(String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f4214a.a(b2.AUCTION_REQUEST_WATERFALL, map);
    }

    public void c(String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f4214a.a(b2.AUCTION_RESULT_WATERFALL, map);
    }
}
