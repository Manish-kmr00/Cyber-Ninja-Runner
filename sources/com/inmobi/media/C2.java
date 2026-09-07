package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.unity3d.services.UnityAdsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class C2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Config f3038a;
    public final int b;
    public C3620x2 c;

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[PHI: r5
  0x0028: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:9:0x0021, B:11:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    public C2(JSONObject jSONObject, Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f3038a = config;
        int i = -1;
        this.b = -1;
        if (jSONObject != null) {
            try {
                int i2 = jSONObject.getInt("status");
                if (i2 == 200) {
                    i = 200;
                } else if (i2 != 304) {
                    int i3 = 404;
                    if (i2 != 404) {
                        i3 = 500;
                        if (i2 == 500) {
                            i = i3;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    i = 304;
                }
                this.b = i;
                if (i != 200) {
                    if (i == 304) {
                        Intrinsics.checkNotNullExpressionValue("G2", "access$getTAG$cp(...)");
                        config.getType();
                        return;
                    } else {
                        C3620x2 c3620x2 = new C3620x2((byte) 1, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR);
                        Intrinsics.checkNotNullExpressionValue("G2", "access$getTAG$cp(...)");
                        config.getType();
                        this.c = c3620x2;
                        return;
                    }
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                C3464m2 c3464m2 = Config.Companion;
                String type = config.getType();
                Intrinsics.checkNotNull(jSONObject2);
                String accountId$media_release = config.getAccountId$media_release();
                long jCurrentTimeMillis = System.currentTimeMillis();
                c3464m2.getClass();
                Config configA = C3464m2.a(type, jSONObject2, accountId$media_release, jCurrentTimeMillis);
                if (configA == null) {
                    this.c = new C3620x2((byte) 3, "The received config has failed backend contract.");
                } else {
                    this.f3038a = configA;
                }
                Intrinsics.checkNotNullExpressionValue("G2", "access$getTAG$cp(...)");
                this.f3038a.getType();
                this.f3038a.isValid();
                if (this.f3038a.isValid()) {
                    return;
                }
                C3620x2 c3620x3 = new C3620x2((byte) 2, "The received config has failed validation.");
                Intrinsics.checkNotNullExpressionValue("G2", "access$getTAG$cp(...)");
                this.f3038a.getType();
                this.c = c3620x3;
            } catch (JSONException e) {
                String localizedMessage = e.getLocalizedMessage();
                C3620x2 c3620x4 = new C3620x2((byte) 2, localizedMessage == null ? "Exception in config validation" : localizedMessage);
                this.f3038a.getType();
                this.c = c3620x4;
            }
        }
    }
}
