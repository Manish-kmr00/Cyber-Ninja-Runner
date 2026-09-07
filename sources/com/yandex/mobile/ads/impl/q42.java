package com.yandex.mobile.ads.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q42 extends Spannable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f9982a;
    private final int b;
    private final int c;

    @Override // android.text.Spannable.Factory
    public final Spannable newSpannable(CharSequence source) {
        Intrinsics.checkNotNullParameter(source, "source");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f9982a != null && this.b > 0) {
            spannableStringBuilder.append((CharSequence) "  ");
            Drawable drawable = this.f9982a;
            int i = this.b;
            drawable.setBounds(0, 0, i, i);
            ad adVar = new ad(drawable);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            int i2 = this.c;
            colorDrawable.setBounds(0, 0, i2, i2);
            ad adVar2 = new ad(colorDrawable);
            spannableStringBuilder.setSpan(adVar, 0, 1, 33);
            spannableStringBuilder.setSpan(adVar2, 1, 2, 33);
        }
        spannableStringBuilder.append(source);
        return spannableStringBuilder;
    }

    public q42(Drawable drawable, int i, int i2) {
        this.f9982a = drawable;
        this.b = i;
        this.c = i2;
    }
}
