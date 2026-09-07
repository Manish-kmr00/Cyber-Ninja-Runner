package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class H4 extends C1 {
    public static final H4 c = new H4();
    public static final AtomicBoolean d = new AtomicBoolean(true);

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        AtomicBoolean atomicBoolean = d;
        jSONObject.put("a-audioBannerEnabled", String.valueOf(atomicBoolean.get()));
        if (!atomicBoolean.get()) {
            return jSONObject;
        }
        long j = this.f3037a / 1000;
        if (j != 0) {
            jSONObject.put("a-lastAudioBannerPlayedTs", String.valueOf(j));
        }
        int i = this.b;
        if (i > 0) {
            jSONObject.put("a-audioBannerFreq", String.valueOf(i));
        }
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "banner_audio_pref_file");
            Intrinsics.checkNotNullParameter("user_mute_count", "key");
            int i2 = k5A.f3112a.getInt("user_mute_count", -1);
            if (i2 > 0) {
                jSONObject.put("a-b-umc", String.valueOf(i2));
            }
        }
        return jSONObject;
    }
}
