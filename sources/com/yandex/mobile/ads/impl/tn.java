package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tn implements cn0 {
    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        View viewC = uiElements.c();
        TextView textViewF = uiElements.f();
        ImageView imageViewG = uiElements.g();
        if (textViewF == null || textViewF.getVisibility() != 8 || imageViewG == null || imageViewG.getVisibility() != 8 || viewC == null) {
            return;
        }
        viewC.setBackground(null);
    }
}
