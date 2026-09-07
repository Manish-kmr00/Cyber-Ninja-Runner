package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class ka2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dw0 f9400a;
    private final c12 b;
    private final x4 c;
    private final y9 d;
    private final cu1 e;

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList a(List videoAds) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        ArrayList arrayList = new ArrayList();
        Iterator it = videoAds.iterator();
        while (it.hasNext()) {
            eb2 eb2Var = (eb2) it.next();
            ru ruVar = (ru) CollectionsKt.firstOrNull((List) eb2Var.e());
            Object ja2Var = null;
            if (ruVar != null) {
                cu1 cu1Var = this.e;
                if (cu1Var != null && cu1Var.G() && eb2Var.o()) {
                    String strK = eb2Var.k();
                    if (strK == null) {
                        strK = "";
                    }
                    ja2Var = new ja2(eb2Var, ruVar, new aw0.a(strK).a(), null, null, null, null);
                } else {
                    aw0 aw0VarA = this.f9400a.a(ruVar);
                    if (aw0VarA != null) {
                        mb2 videoAdExtensions = eb2Var.l();
                        this.b.getClass();
                        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
                        Iterator<T> it2 = videoAdExtensions.a().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            r70 r70Var = (r70) next;
                            if (Intrinsics.areEqual(r70Var.a(), "social_ad_info") && r70Var.b().length() > 0) {
                                break;
                            }
                        }
                        r70 r70Var2 = (r70) next;
                        String strB = r70Var2 != null ? r70Var2.b() : null;
                        b12 b12Var = strB != null ? new b12(strB) : null;
                        this.c.getClass();
                        String strA = x4.a(videoAdExtensions);
                        this.c.getClass();
                        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
                        String strA2 = x4.a(videoAdExtensions);
                        JSONObject jSONObjectA = strA2 != null ? rq0.a(strA2) : null;
                        this.d.getClass();
                        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
                        Iterator<T> it3 = videoAdExtensions.a().iterator();
                        do {
                            if (!it3.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it3.next();
                        } while (!Intrinsics.areEqual(((r70) next2).a(), "AdTune"));
                        r70 r70Var3 = (r70) next2;
                        String strB2 = r70Var3 != null ? r70Var3.b() : null;
                        JSONObject jSONObjectA2 = strB2 != null ? rq0.a(strB2) : null;
                        if (jSONObjectA2 != null) {
                            boolean z = jSONObjectA2.optInt(com.json.m5.v, 0) == 1;
                            String strOptString = jSONObjectA2.optString("token");
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            String strOptString2 = jSONObjectA2.optString("advertiserInfo");
                            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                            ja2Var = new w9(strOptString, strOptString2, z);
                        }
                        ja2Var = new ja2(eb2Var, ruVar, aw0VarA, b12Var, strA, jSONObjectA, ja2Var);
                    }
                }
            }
            if (ja2Var != null) {
                arrayList.add(ja2Var);
            }
        }
        return arrayList;
    }

    public /* synthetic */ ka2(Context context) {
        dw0 dw0Var = new dw0(context);
        c12 c12Var = new c12();
        x4 x4Var = new x4();
        y9 y9Var = new y9();
        int i = iw1.l;
        this(context, dw0Var, c12Var, x4Var, y9Var, iw1.a.a().a(context));
    }

    public ka2(Context context, dw0 mediaFileProvider, c12 socialAdInfoProvider, x4 adInfoProvider, y9 adTuneInfoProvider, cu1 cu1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaFileProvider, "mediaFileProvider");
        Intrinsics.checkNotNullParameter(socialAdInfoProvider, "socialAdInfoProvider");
        Intrinsics.checkNotNullParameter(adInfoProvider, "adInfoProvider");
        Intrinsics.checkNotNullParameter(adTuneInfoProvider, "adTuneInfoProvider");
        this.f9400a = mediaFileProvider;
        this.b = socialAdInfoProvider;
        this.c = adInfoProvider;
        this.d = adTuneInfoProvider;
        this.e = cu1Var;
    }
}
