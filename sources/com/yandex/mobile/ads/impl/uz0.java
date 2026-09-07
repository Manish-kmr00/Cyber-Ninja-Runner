package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yandex.div.core.images.LoadReference;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class uz0 extends hy<fy.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ix f10437a;
    private final Function1<fy.g, Unit> b;
    private final Function1<String, Unit> c;
    private LoadReference d;
    private final LinearLayout e;
    private final ImageView f;
    private final TextView g;
    private final ImageView h;
    private final TextView i;
    private final TextView j;
    private final ImageView k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public uz0(View itemView, ix imageLoader, Function1<? super fy.g, Unit> onNetworkClick, Function1<? super String, Unit> onWaringButtonClick) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(onNetworkClick, "onNetworkClick");
        Intrinsics.checkNotNullParameter(onWaringButtonClick, "onWaringButtonClick");
        this.f10437a = imageLoader;
        this.b = onNetworkClick;
        this.c = onWaringButtonClick;
        View viewFindViewById = itemView.findViewById(R.id.item_mediation_adapter);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.e = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.item_logo);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f = (ImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.item_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.g = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.navigation_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.h = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.item_info_first);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.i = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.item_info_second);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.j = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.item_warning_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.k = (ImageView) viewFindViewById7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(uz0 this$0, fy.g unit, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unit, "$unit");
        this$0.b.invoke(unit);
    }

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(final fy.g unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Context context = this.itemView.getContext();
        this.g.setText(unit.f());
        yx yxVarC = unit.c();
        if (yxVarC != null) {
            this.i.setVisibility(0);
            this.i.setText(yxVarC.d());
            this.i.setTextAppearance(context, yxVarC.c());
            TextView textView = this.i;
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView.setTextColor(nh.a(context2, yxVarC.a()));
            TextView textView2 = this.i;
            Integer numB = yxVarC.b();
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, numB != null ? numB.intValue() : 0, 0);
        } else {
            this.i.setVisibility(8);
        }
        ww wwVarD = unit.d();
        this.j.setText(wwVarD.c());
        this.j.setTextAppearance(context, wwVarD.b());
        TextView textView3 = this.j;
        Context context3 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        textView3.setTextColor(nh.a(context3, wwVarD.a()));
        LinearLayout linearLayout = this.e;
        String strJ = unit.j();
        linearLayout.setClickable(((strJ == null || StringsKt.isBlank(strJ)) && unit.g() == null) ? false : true);
        String strJ2 = unit.j();
        if (strJ2 == null || StringsKt.isBlank(strJ2)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.uz0$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    uz0.a(this.f$0, unit, view);
                }
            });
        }
        this.f.setImageResource(0);
        LoadReference loadReference = this.d;
        if (loadReference != null) {
            loadReference.cancel();
        }
        ix ixVar = this.f10437a;
        String strE = unit.e();
        if (strE == null) {
            strE = "";
        }
        this.d = ixVar.a(strE, this.f);
        if (unit.g() == null) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.uz0$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    uz0.b(this.f$0, unit, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(uz0 this$0, fy.g unit, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unit, "$unit");
        this$0.c.invoke(unit.j());
    }
}
