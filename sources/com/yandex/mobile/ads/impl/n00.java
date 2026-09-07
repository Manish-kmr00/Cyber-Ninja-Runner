package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n00 implements dz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9684a;

    public n00(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9684a = context;
    }

    @Override // com.yandex.mobile.ads.impl.dz
    public final ig<?> a() {
        CharSequence text = this.f9684a.getResources().getText(R.string.monetization_ads_internal_instream_sponsored_social);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return new ig<>("sponsored", "string", text, null, false, true);
    }
}
