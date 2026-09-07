package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class hz implements dz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9149a;

    public hz(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9149a = context;
    }

    @Override // com.yandex.mobile.ads.impl.dz
    public final ig<?> a() {
        CharSequence text = this.f9149a.getResources().getText(R.string.monetization_ads_internal_instream_call_to_action);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return new ig<>("call_to_action", "string", text, null, true, true);
    }
}
