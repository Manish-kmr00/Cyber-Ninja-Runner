package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.yandex.mobile.ads.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public final class gn1<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f9021a;
    private final hn1 b;
    private final d41 c;
    private final w41 d;

    public gn1(ot nativeAdAssets, hn1 ratingFormatter, d41 nativeAdAdditionalViewProvider, w41 nativeAdContainerViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(ratingFormatter, "ratingFormatter");
        Intrinsics.checkNotNullParameter(nativeAdAdditionalViewProvider, "nativeAdAdditionalViewProvider");
        Intrinsics.checkNotNullParameter(nativeAdContainerViewProvider, "nativeAdContainerViewProvider");
        this.f9021a = nativeAdAssets;
        this.b = ratingFormatter;
        this.c = nativeAdAdditionalViewProvider;
        this.d = nativeAdContainerViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(container, "container");
        this.d.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        ViewGroup viewGroup = (ViewGroup) container.findViewById(R.id.rating_container);
        Float fK = this.f9021a.k();
        if (fK == null) {
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        TextView textView = (TextView) container.findViewById(R.id.rating_text);
        if (textView != null) {
            hn1 hn1Var = this.b;
            float fFloatValue = fK.floatValue();
            hn1Var.getClass();
            try {
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator(AbstractJsonLexerKt.COMMA);
                strValueOf = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME, decimalFormatSymbols).format(fFloatValue);
                Intrinsics.checkNotNull(strValueOf);
            } catch (RuntimeException unused) {
                strValueOf = String.valueOf(fFloatValue);
            }
            textView.setText(strValueOf);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
