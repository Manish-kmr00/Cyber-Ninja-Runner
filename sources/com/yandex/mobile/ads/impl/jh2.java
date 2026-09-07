package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class jh2 {
    public static final fh2 a(CustomizableMediaView customizableMediaView, String mediaType) {
        ru0 ru0Var;
        ru0 ru0Var2;
        Intrinsics.checkNotNullParameter(customizableMediaView, "<this>");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        ViewGroup.LayoutParams layoutParams = customizableMediaView.getLayoutParams();
        Integer numValueOf = layoutParams != null ? Integer.valueOf(x72.a(layoutParams.width)) : null;
        ViewGroup.LayoutParams layoutParams2 = customizableMediaView.getLayoutParams();
        Integer numValueOf2 = layoutParams2 != null ? Integer.valueOf(x72.a(layoutParams2.height)) : null;
        int iA = x72.a(View.MeasureSpec.getSize(customizableMediaView.getWidthMeasureSpec()));
        int iA2 = x72.a(View.MeasureSpec.getSize(customizableMediaView.getHeightMeasureSpec()));
        int mode = View.MeasureSpec.getMode(customizableMediaView.getWidthMeasureSpec());
        if (mode != Integer.MIN_VALUE) {
            ru0Var = (mode == 0 || mode != 1073741824) ? ru0.d : ru0.b;
        } else {
            ru0Var = ru0.c;
        }
        int mode2 = View.MeasureSpec.getMode(customizableMediaView.getHeightMeasureSpec());
        if (mode2 != Integer.MIN_VALUE) {
            ru0Var2 = (mode2 == 0 || mode2 != 1073741824) ? ru0.d : ru0.b;
        } else {
            ru0Var2 = ru0.c;
        }
        return new fh2(new eh2(x72.a(customizableMediaView.getWidth()), x72.a(customizableMediaView.getHeight())), new jr0(numValueOf, numValueOf2), new pu0(new qu0(iA, ru0Var), new qu0(iA2, ru0Var2)), MapsKt.mapOf(TuplesKt.to("asset", "media"), TuplesKt.to("media_type", mediaType)));
    }
}
