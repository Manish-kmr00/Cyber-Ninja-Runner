package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.inmobi.ads.core.Trackers;
import com.inmobi.ads.core.TrackingInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3404i0 {
    public static A5 a() {
        return new A5().a(new Za("ads", C3418j0.class), (Ya) new C3312b6(new C3334d0(), C3389h.class)).a(new Za("trackingInfo", C3389h.class), (Ya) new C3312b6(new C3348e0(), TrackingInfo.class)).a(new Za(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, TrackingInfo.class), (Ya) new C3312b6(new C3362f0(), Trackers.class)).a(new Za("url", Trackers.class), (Ya) new C3312b6(new C3376g0(), String.class)).a(new Za("imExts", Trackers.class), (Ya) new C3312b6(new C3390h0(), String.class));
    }

    public static C3418j0 a(JSONObject adContent, long j, String str, String requestId, L4 l4) {
        C3389h c3389h;
        Intrinsics.checkNotNullParameter(adContent, "adContent");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        try {
            long jOptLong = adContent.optLong("expiry", -1L);
            long millis = jOptLong > 0 ? TimeUnit.SECONDS.toMillis(jOptLong) : -1L;
            JSONArray jSONArray = adContent.getJSONArray("ads");
            if (jSONArray.length() == 0) {
                if (l4 != null) {
                    String str2 = C3418j0.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    ((M4) l4).b(str2, "no ads");
                }
                return null;
            }
            C3418j0 c3418j0 = (C3418j0) a().a(adContent, C3418j0.class);
            if (l4 != null) {
                String str3 = C3418j0.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                ((M4) l4).a(str3, "adSet parsing success");
            }
            if (c3418j0 == null || c3418j0.c().length() <= 0) {
                return null;
            }
            c3418j0.placementId = j;
            c3418j0.requestId = requestId;
            c3418j0.adType = str;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator<T> it = c3418j0.f().iterator();
                int i2 = 0;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        C3389h c3389h2 = (C3389h) next;
                        if (Intrinsics.areEqual(jSONObject.optString("impressionId"), c3389h2.s())) {
                            if (l4 != null) {
                                try {
                                    String str4 = C3418j0.TAG;
                                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                                    ((M4) l4).a(str4, "inflating ad at index - " + i2);
                                } catch (Exception e) {
                                    if (l4 != null) {
                                        String str5 = C3418j0.TAG;
                                        Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                                        ((M4) l4).a(str5, "Error inflating ad", e);
                                    }
                                    C3339d5 c3339d5 = C3339d5.f3292a;
                                    P1 event = new P1(e);
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    C3339d5.c.a(event);
                                    c3389h = c3389h2;
                                    break;
                                }
                            }
                            String str6 = AbstractC3589v.f3449a;
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
                            AbstractC3589v.a(c3389h2, jSONObject2, str, millis, l4);
                        } else {
                            i2 = i3;
                        }
                    }
                    c3389h = null;
                    break;
                }
                if (c3389h != null) {
                    if (l4 != null) {
                        String str7 = C3418j0.TAG;
                        Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                        ((M4) l4).b(str7, "removing invalid ad  at index - " + CollectionsKt.indexOf((List<? extends C3389h>) c3418j0.f(), c3389h));
                    }
                    TypeIntrinsics.asMutableCollection(c3418j0.f()).remove(c3389h);
                }
            }
            if (c3418j0.f().isEmpty()) {
                return null;
            }
            return c3418j0;
        } catch (JSONException e2) {
            if (l4 == null) {
                return null;
            }
            String str8 = C3418j0.TAG;
            Intrinsics.checkNotNullExpressionValue(str8, "access$getTAG$cp(...)");
            ((M4) l4).a(str8, "Exception while inflating AdSet", e2);
            return null;
        }
    }
}
