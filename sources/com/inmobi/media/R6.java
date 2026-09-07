package com.inmobi.media;

import android.app.Activity;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class R6 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3181a;
    public final /* synthetic */ C3313b7 b;

    public R6(C3313b7 c3313b7, C3313b7 originalContainer) {
        Intrinsics.checkNotNullParameter(originalContainer, "originalContainer");
        this.b = c3313b7;
        this.f3181a = new WeakReference(originalContainer);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x011a  */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        C3313b7 c3313b7;
        L4 l4;
        C3313b7 c3398h8;
        Activity context = this.b.f();
        String str2 = "access$getTAG$p(...)";
        if (context == null) {
            Intrinsics.checkNotNullExpressionValue(this.b.m, str2);
            return;
        }
        C3313b7 c3313b8 = (C3313b7) this.f3181a.get();
        if (c3313b8 == null || c3313b8.t) {
            return;
        }
        try {
            C3625x7 c3625x7 = c3313b8.b;
            JSONArray jSONArray = c3625x7.f;
            try {
                if (jSONArray != null && !AbstractC3420j2.a(jSONArray)) {
                    Intrinsics.checkNotNullExpressionValue(this.b.m, str2);
                    JSONObject jSONObjectE = c3625x7.e();
                    if (jSONObjectE == null) {
                        return;
                    }
                    boolean z = this.b.f3274a == 0;
                    C3313b7 c3313b9 = this.b;
                    C3625x7 dataModel = new C3625x7(c3313b9.f3274a, jSONObjectE, c3625x7, z, c3313b9.s, c3313b9.j);
                    if (!dataModel.f()) {
                        C3313b7 c3313b10 = this.b;
                        L4 l5 = c3313b10.j;
                        if (l5 != null) {
                            String str3 = c3313b10.m;
                            Intrinsics.checkNotNullExpressionValue(str3, str2);
                            ((M4) l5).b(str3, "Invalid data model for end-card container! End card will not be shown ...");
                            return;
                        }
                        return;
                    }
                    String adImpressionId = this.b.getImpressionId();
                    C3313b7 c3313b11 = this.b;
                    AdConfig adConfig = c3313b11.s;
                    long j = c3313b11.e;
                    boolean z2 = c3313b11.f;
                    String creativeId = c3313b11.getCreativeId();
                    C3313b7 c3313b12 = this.b;
                    C3297a6 c3297a6 = c3313b12.i;
                    L4 l6 = c3313b12.j;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                    Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
                    Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                    Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                    try {
                        if (dataModel.c().contains(ShareConstants.VIDEO_URL)) {
                            try {
                                c3398h8 = new C3398h8(context, (byte) 0, dataModel, adImpressionId, null, adConfig, j, z2, creativeId, null, c3297a6, l6);
                            } catch (Exception e) {
                                e = e;
                                str2 = str2;
                                str = str2;
                                c3313b7 = this.b;
                                l4 = c3313b7.j;
                                if (l4 != null) {
                                    String str4 = c3313b7.m;
                                    Intrinsics.checkNotNullExpressionValue(str4, str);
                                    ((M4) l4).a(str4, "Encountered unexpected error in EndCardBuilder: ", e);
                                }
                                C3339d5 c3339d5 = C3339d5.f3292a;
                                C3339d5.c.a(I4.a(e, "event"));
                                return;
                            }
                        } else {
                            c3398h8 = new C3313b7(context, (byte) 0, dataModel, adImpressionId, null, adConfig, j, z2, creativeId, null, c3297a6, l6);
                        }
                        C3313b7 c3313b13 = c3398h8;
                        c3313b13.H = c3313b8.H;
                        c3313b13.v = c3313b8;
                        C3313b7 c3313b14 = this.b;
                        L4 l7 = c3313b14.j;
                        if (l7 != null) {
                            String str5 = c3313b14.m;
                            Intrinsics.checkNotNullExpressionValue(str5, str2);
                            ((M4) l7).a(str5, "End-card container built successfully ...");
                        }
                        c3313b8.J = c3313b13;
                        return;
                    } catch (Exception e2) {
                        e = e2;
                    }
                    c3313b7 = this.b;
                    l4 = c3313b7.j;
                    if (l4 != null) {
                        String str6 = c3313b7.m;
                        Intrinsics.checkNotNullExpressionValue(str6, str);
                        ((M4) l4).a(str6, "Encountered unexpected error in EndCardBuilder: ", e);
                    }
                    C3339d5 c3339d6 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(this.b.m, str2);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            str = str2;
        }
    }
}
