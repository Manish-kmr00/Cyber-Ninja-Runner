package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y extends hy<fy.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<fy.c.a, Unit> f10690a;
    private final TextView b;

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(final fy.c unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.b.setText(unit.b());
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.y$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.a(this.f$0, unit, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Function1 onButtonClick, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        this.f10690a = onButtonClick;
        View viewFindViewById = itemView.findViewById(R.id.item_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.b = (TextView) viewFindViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(y this$0, fy.c unit, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unit, "$unit");
        this$0.f10690a.invoke(unit.a());
    }
}
