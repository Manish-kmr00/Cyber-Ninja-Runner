package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ka extends hy<fy.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<String, Unit> f9396a;
    private final TextView b;
    private final TextView c;
    private final TextView d;

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(final fy.a unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.b.setText(unit.c());
        this.c.setText(unit.a());
        this.d.setText(unit.b());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.ka$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ka.a(this.f$0, unit, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ka(Function1 onAdUnitClick, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onAdUnitClick, "onAdUnitClick");
        this.f9396a = onAdUnitClick;
        View viewFindViewById = itemView.findViewById(R.id.item_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.b = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.item_ad_unit_format);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.item_ad_unit_id);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.d = (TextView) viewFindViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ka this$0, fy.a unit, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unit, "$unit");
        this$0.f9396a.invoke(unit.b());
    }
}
