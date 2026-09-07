package com.fyber.inneractive.sdk.metrics;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1867a;

    public a(String str) {
        this.f1867a = str;
    }

    public static boolean a(int i, int i2, JSONArray jSONArray, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(i);
        int i3 = 0;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            long jOptLong = jSONArray.optLong(i4, 0L);
            if (jOptLong > jCurrentTimeMillis) {
                i3++;
                copyOnWriteArrayList.add(Long.valueOf(jOptLong));
            }
        }
        return i3 >= i2;
    }
}
