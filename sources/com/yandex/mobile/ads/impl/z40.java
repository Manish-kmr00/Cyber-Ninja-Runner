package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z40 implements gc {
    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewN = uiElements.n();
        if (textViewN != null) {
            textViewN.setVisibility(8);
        }
        ImageView imageViewM = uiElements.m();
        if (imageViewM == null) {
            return;
        }
        imageViewM.setVisibility(8);
    }
}
