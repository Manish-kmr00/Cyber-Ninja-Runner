package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o00 implements dz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9766a;

    public o00(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9766a = context;
    }

    @Override // com.yandex.mobile.ads.impl.dz
    public final ig<?> a() {
        CharSequence text = this.f9766a.getResources().getText(R.string.monetization_ads_internal_instream_sponsored_default);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return new ig<>("sponsored", "string", text, null, false, true);
    }
}
