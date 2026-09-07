package com.yandex.mobile.ads.impl;

import android.widget.TextView;
import com.monetization.ads.fullscreen.template.view.ExtendedTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cj2 implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f8617a;
    private final mg b;

    public cj2(ig<?> igVar, mg assetClickConfigurator) {
        Intrinsics.checkNotNullParameter(assetClickConfigurator, "assetClickConfigurator");
        this.f8617a = igVar;
        this.b = assetClickConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewQ = uiElements.q();
        ig<?> igVar = this.f8617a;
        Object objD = igVar != null ? igVar.d() : null;
        if (!(textViewQ instanceof ExtendedTextView) || !(objD instanceof String)) {
            if (textViewQ == null) {
                return;
            }
            textViewQ.setVisibility(8);
            return;
        }
        hb0 hb0Var = new hb0(uiElements.a());
        ExtendedTextView extendedTextView = (ExtendedTextView) textViewQ;
        extendedTextView.setText((CharSequence) objD);
        extendedTextView.setVisibility(0);
        extendedTextView.setAutoSizeTextType(1);
        extendedTextView.setMeasureSpecProvider(hb0Var);
        this.b.a(textViewQ, this.f8617a);
    }
}
