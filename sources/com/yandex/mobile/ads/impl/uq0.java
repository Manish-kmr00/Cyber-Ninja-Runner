package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class uq0 extends hy<fy.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f10413a;
    private final TextView b;
    private final TextView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq0(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.item_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f10413a = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.item_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.b = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.item_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.c = (TextView) viewFindViewById3;
    }

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(fy fyVar) {
        fy.f unit = (fy.f) fyVar;
        Intrinsics.checkNotNullParameter(unit, "unit");
        String strA = unit.a();
        yx yxVarB = unit.b();
        ww wwVarC = unit.c();
        Context context = this.itemView.getContext();
        if (strA != null) {
            this.f10413a.setVisibility(0);
            this.f10413a.setText(strA);
        } else {
            this.f10413a.setVisibility(8);
        }
        if (yxVarB != null && !StringsKt.isBlank(yxVarB.d())) {
            this.b.setVisibility(0);
            this.b.setText(yxVarB.d());
            Intrinsics.checkNotNull(context);
            this.b.setTextColor(nh.a(context, yxVarB.a()));
            Integer numB = yxVarB.b();
            this.b.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, numB != null ? numB.intValue() : 0, 0);
        } else {
            this.b.setVisibility(8);
        }
        if (wwVarC != null && !StringsKt.isBlank(wwVarC.c())) {
            this.c.setVisibility(0);
            this.c.setText(wwVarC.c());
            Intrinsics.checkNotNull(context);
            this.c.setTextColor(nh.a(context, wwVarC.a()));
            return;
        }
        this.c.setVisibility(8);
    }
}
