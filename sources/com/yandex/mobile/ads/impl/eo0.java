package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class eo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8818a;
    private final tl0 b;
    private final Context c;

    public final dt a(p2 adBreak, List<eb2> videoAds) {
        et etVarA;
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        String strC = adBreak.c();
        if (strC != null && (etVarA = this.b.a(adBreak.f())) != null) {
            long jA = ti0.a();
            jo0 jo0Var = new jo0(adBreak, etVarA, jA, new kz1(), new m10(adBreak), new qb2(), new bm0());
            Context context = this.c;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ArrayList arrayListA = new vb2(context, jo0Var).a(videoAds);
            if (!arrayListA.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListA, 10));
                Iterator it = arrayListA.iterator();
                while (it.hasNext()) {
                    arrayList.add((do0) ((rb2) it.next()).d());
                }
                return new dt(this.f8818a, arrayListA, arrayList, strC, adBreak, etVarA, jA);
            }
        }
        return null;
    }

    public /* synthetic */ eo0(Context context, uu1 uu1Var) {
        this(context, uu1Var, new tl0());
    }

    public eo0(Context context, uu1 sdkEnvironmentModule, tl0 adBreakPositionParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adBreakPositionParser, "adBreakPositionParser");
        this.f8818a = sdkEnvironmentModule;
        this.b = adBreakPositionParser;
        this.c = context.getApplicationContext();
    }
}
