package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t12 implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f10257a;
    private final w9 b;
    private final mg c;
    private final u12 d;

    public t12(ig<?> igVar, w9 w9Var, mg clickConfigurator, u12 sponsoredTextFormatter) {
        Intrinsics.checkNotNullParameter(clickConfigurator, "clickConfigurator");
        Intrinsics.checkNotNullParameter(sponsoredTextFormatter, "sponsoredTextFormatter");
        this.f10257a = igVar;
        this.b = w9Var;
        this.c = clickConfigurator;
        this.d = sponsoredTextFormatter;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewN = uiElements.n();
        if (textViewN != null) {
            ig<?> igVar = this.f10257a;
            Object objD = igVar != null ? igVar.d() : null;
            if (objD instanceof String) {
                textViewN.setText((CharSequence) objD);
                textViewN.setVisibility(0);
            }
            w9 w9Var = this.b;
            if (w9Var != null && w9Var.b()) {
                textViewN.setText(this.d.a(textViewN.getText().toString(), this.b));
                textViewN.setVisibility(0);
                textViewN.setSelected(true);
                textViewN.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                textViewN.setMarqueeRepeatLimit(-1);
            }
            this.c.a(textViewN, this.f10257a);
        }
    }
}
