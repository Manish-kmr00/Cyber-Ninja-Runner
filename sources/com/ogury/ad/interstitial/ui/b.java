package com.ogury.ad.interstitial.ui;

import android.content.Context;
import com.ogury.ad.internal.q8;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7479a = new b();
    public static final InterstitialActivity.a b = InterstitialActivity.d;

    @Override // com.ogury.ad.internal.q8
    public final void a(Context context, List<com.ogury.ad.internal.c> ads) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ads, "ads");
        if (ads.isEmpty()) {
            return;
        }
        b.a(context, ads.remove(0), ads);
    }
}
