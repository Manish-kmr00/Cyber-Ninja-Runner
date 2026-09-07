package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ma extends hy<fy.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f9615a;
    private final TextView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ma(View itemView, Function0<Unit> onAdUnitsClick) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onAdUnitsClick, "onAdUnitsClick");
        this.f9615a = onAdUnitsClick;
        View viewFindViewById = itemView.findViewById(R.id.item_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.b = (TextView) viewFindViewById;
    }

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(fy.b unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.b.setText(this.itemView.getContext().getString(R.string.ad_units));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.ma$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ma.a(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ma this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f9615a.invoke();
    }
}
