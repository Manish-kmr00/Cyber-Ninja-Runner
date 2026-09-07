package com.yandex.mobile.ads.impl;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r30 implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f10070a;
    private final mg b;

    public r30(ig<?> igVar, mg clickConfigurator) {
        Intrinsics.checkNotNullParameter(clickConfigurator, "clickConfigurator");
        this.f10070a = igVar;
        this.b = clickConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewF = uiElements.f();
        ig<?> igVar = this.f10070a;
        Object objD = igVar != null ? igVar.d() : null;
        if (textViewF != null) {
            if (!(objD instanceof String)) {
                textViewF.setVisibility(8);
                return;
            }
            textViewF.setText((CharSequence) objD);
            textViewF.setVisibility(0);
            this.b.a(textViewF, this.f10070a);
        }
    }
}
