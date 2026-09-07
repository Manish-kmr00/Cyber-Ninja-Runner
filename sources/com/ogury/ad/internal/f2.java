package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f2 implements t6 {
    @Override // com.ogury.ad.internal.t6
    public final void a(Rect adLayoutRect, Rect containerRect) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        if (adLayoutRect.width() > containerRect.width()) {
            float fWidth = adLayoutRect.width() / containerRect.width();
            Intrinsics.checkNotNullParameter(adLayoutRect, "<this>");
            adLayoutRect.bottom = adLayoutRect.top + ((int) (adLayoutRect.height() / fWidth));
            adLayoutRect.right = adLayoutRect.left + ((int) (adLayoutRect.width() / fWidth));
        }
        if (adLayoutRect.height() > containerRect.height()) {
            float fHeight = adLayoutRect.height() / containerRect.height();
            Intrinsics.checkNotNullParameter(adLayoutRect, "<this>");
            adLayoutRect.bottom = adLayoutRect.top + ((int) (adLayoutRect.height() / fHeight));
            adLayoutRect.right = adLayoutRect.left + ((int) (adLayoutRect.width() / fHeight));
        }
    }
}
