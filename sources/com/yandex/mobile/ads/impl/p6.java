package com.yandex.mobile.ads.impl;

import android.widget.TextView;
import com.yandex.mobile.ads.R;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class p6 implements cn0 {
    private static final int c = R.string.monetization_ads_internal_instream_ad_position;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9897a;
    private final int b;

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        TextView textViewB = uiElements.b();
        if (textViewB != null) {
            String string = textViewB.getContext().getResources().getString(c);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f9897a), Integer.valueOf(this.b)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textViewB.setText(str);
        }
    }

    public p6(int i, int i2) {
        this.f9897a = i;
        this.b = i2;
    }
}
