package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tp extends ng2<TextView, rp> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp(TextView view) {
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
    public final void b(View view, rp rpVar) {
        TextView view2 = (TextView) view;
        rp value = rpVar;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        if (rp.a.b == value.b()) {
            view2.setText(value.a());
        }
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, rp rpVar) {
        TextView view2 = (TextView) view;
        rp value = rpVar;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        if (rp.a.b == value.b()) {
            return Intrinsics.areEqual(view2.getText().toString(), value.a());
        }
        return true;
    }
}
