package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class p42 extends ng2<TextView, String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p42(TextView view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(View view) {
        TextView view2 = (TextView) view;
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setText("");
        super.a(view2);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, String str) {
        TextView view2 = (TextView) view;
        String value = str;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        view2.setText(value);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, String str) {
        TextView view2 = (TextView) view;
        String value = str;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        CharSequence text = view2.getText();
        if (text != null) {
            return StringsKt.equals(String.valueOf(text), value, true);
        }
        return false;
    }
}
