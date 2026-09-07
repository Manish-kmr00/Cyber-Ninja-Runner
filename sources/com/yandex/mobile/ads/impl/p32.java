package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.yandex.mobile.ads.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p32 extends hy<fy.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2<fy.h.a, Boolean, Unit> f9892a;
    private final Switch b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public p32(View itemView, Function2<? super fy.h.a, ? super Boolean, Unit> onCheckedChange) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        this.f9892a = onCheckedChange;
        View viewFindViewById = itemView.findViewById(R.id.item_switch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.b = (Switch) viewFindViewById;
    }

    @Override // com.yandex.mobile.ads.impl.hy
    public final void a(final fy.h unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.b.setOnCheckedChangeListener(null);
        this.b.setText(unit.c());
        this.b.setChecked(unit.a());
        this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yandex.mobile.ads.impl.p32$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                p32.a(this.f$0, unit, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(p32 this$0, fy.h unit, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(unit, "$unit");
        this$0.f9892a.invoke(unit.b(), Boolean.valueOf(z));
    }
}
