package com.bytedance.sdk.openadsdk.core.WV.Og;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class pA extends KZx implements Comparable<pA> {
    public long pA;

    protected pA(long j, String str, KZx.EnumC0234KZx enumC0234KZx, Boolean bool) {
        super(str, enumC0234KZx, bool);
        this.pA = j;
    }

    public static int pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3) {
            try {
                return (int) ((Integer.parseInt(strArrSplit[0]) * 3600000) + (Integer.parseInt(strArrSplit[1]) * 60000) + (Float.parseFloat(strArrSplit[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean pA(long j) {
        return this.pA <= j && !ML();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(pA pAVar) {
        if (pAVar == null) {
            return 1;
        }
        long j = this.pA;
        long j2 = pAVar.pA;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.WV.Og.pA$pA, reason: collision with other inner class name */
    public static class C0235pA {
        private final long Og;
        private final String pA;
        private KZx.EnumC0234KZx KZx = KZx.EnumC0234KZx.TRACKING_URL;
        private boolean ZZv = false;

        public C0235pA(String str, long j) {
            this.pA = str;
            this.Og = j;
        }

        public pA pA() {
            return new pA(this.Og, this.pA, this.KZx, Boolean.valueOf(this.ZZv));
        }
    }

    public JSONObject pA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", KZx());
        jSONObject.put("trackingMilliseconds", this.pA);
        return jSONObject;
    }
}
