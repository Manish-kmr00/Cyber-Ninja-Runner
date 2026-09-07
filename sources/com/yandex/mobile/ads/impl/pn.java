package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class pn<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g41 f9942a;
    private final on b;

    public pn(Context context, g41 nativeAdAssetViewProvider, on callToActionAnimationController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        Intrinsics.checkNotNullParameter(callToActionAnimationController, "callToActionAnimationController");
        this.f9942a = nativeAdAssetViewProvider;
        this.b = callToActionAnimationController;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f9942a.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        TextView textView = (TextView) container.findViewById(R.id.call_to_action);
        if (textView != null) {
            this.b.a(textView);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.b.a();
    }
}
