package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class sn implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f10221a;
    private final vo b;

    public sn(ig<?> igVar, vo clickControlConfigurator) {
        Intrinsics.checkNotNullParameter(clickControlConfigurator, "clickControlConfigurator");
        this.f10221a = igVar;
        this.b = clickControlConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewE = uiElements.e();
        ImageView imageViewD = uiElements.d();
        if (textViewE != null) {
            ig<?> igVar = this.f10221a;
            Object objD = igVar != null ? igVar.d() : null;
            if (objD instanceof String) {
                textViewE.setVisibility(0);
                textViewE.setText((CharSequence) objD);
            } else {
                textViewE.setVisibility(8);
            }
            this.b.a(textViewE);
        }
        if (imageViewD != null) {
            this.b.a(imageViewD);
        }
    }
}
