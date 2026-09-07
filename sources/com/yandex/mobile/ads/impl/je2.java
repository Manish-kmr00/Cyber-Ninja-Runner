package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class je2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9311a;
    private final dg2 b;
    private final ig2 c;

    public je2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9311a = context.getApplicationContext();
        this.b = new dg2();
        this.c = new ig2();
    }

    public final void a(List<String> rawUrls, Map<String, String> macros) {
        Intrinsics.checkNotNullParameter(rawUrls, "rawUrls");
        ArrayList trackingUrls = new ArrayList(CollectionsKt.collectionSizeOrDefault(rawUrls, 10));
        for (String url : rawUrls) {
            boolean z = macros != null;
            if (z) {
                this.b.getClass();
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(macros, "macros");
                String strReplace$default = url;
                for (Map.Entry<String, String> entry : macros.entrySet()) {
                    strReplace$default = StringsKt.replace$default(strReplace$default, entry.getKey(), entry.getValue(), false, 4, (Object) null);
                }
                url = strReplace$default;
            } else if (z) {
                throw new NoWhenBranchMatchedException();
            }
            trackingUrls.add(url);
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : trackingUrls) {
            if (!Intrinsics.areEqual((String) obj, AndroidWebViewClient.BLANK_PAGE)) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            re2.a aVar = re2.c;
            Context applicationContext = this.f9311a;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            aVar.a(applicationContext).a(str);
        }
    }
}
