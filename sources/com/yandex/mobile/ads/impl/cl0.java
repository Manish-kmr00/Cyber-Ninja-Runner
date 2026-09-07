package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
public final class cl0 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f8622a;
    private final nm b;
    private final TextView c;
    private final View.OnClickListener d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl0(Context context, l10 dimensionConverter) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        this.f8622a = dimensionConverter;
        this.b = new nm(context, dimensionConverter);
        this.c = new TextView(context);
        this.d = new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.cl0$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cl0.a(this.f$0, view);
            }
        };
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(cl0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean zIsSelected = this$0.b.isSelected();
        this$0.b.setSelected(!zIsSelected);
        this$0.c.setVisibility(!zIsSelected ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setDescription(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.c.setText(description);
    }

    private final void a(Context context) {
        setOrientation(0);
        this.f8622a.getClass();
        int iA = l10.a(context, 4.0f);
        setPadding(iA, iA, iA, iA);
        this.b.setOnClickListener(this.d);
        addView(this.b);
        this.f8622a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt = MathKt.roundToInt(TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics()));
        this.c.setPadding(iRoundToInt, iRoundToInt, iRoundToInt, iRoundToInt);
        this.f8622a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt2 = MathKt.roundToInt(TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(iRoundToInt2, SupportMenu.CATEGORY_MASK);
        this.c.setBackgroundDrawable(gradientDrawable);
        addView(this.c);
        this.f8622a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt3 = MathKt.roundToInt(TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(iRoundToInt3, 0, iRoundToInt3, iRoundToInt3);
        this.c.setLayoutParams(layoutParams2);
        this.c.setVisibility(8);
    }
}
