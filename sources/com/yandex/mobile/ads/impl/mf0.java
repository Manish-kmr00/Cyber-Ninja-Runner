package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mf0 extends hy<fy.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f9635a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf0(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.item_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f9635a = (TextView) viewFindViewById;
    }

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(fy fyVar) {
        fy.e unit = (fy.e) fyVar;
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.f9635a.setText(unit.a());
    }
}
