package com.five_corp.ad.internal.view;

import android.R;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.five_corp.ad.internal.view.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3045c extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3043a f1568a;
    public final InterfaceC3044b b;

    public C3045c(Activity activity, ArrayList arrayList, InterfaceC3043a interfaceC3043a, InterfaceC3044b interfaceC3044b) {
        super(activity);
        this.f1568a = interfaceC3043a;
        this.b = interfaceC3044b;
        a(activity, arrayList);
    }

    public final void a(Activity activity, ArrayList arrayList) {
        setOrientation(1);
        int iA = this.f1568a.a(8);
        setPadding(iA, iA, iA, iA);
        setBackgroundColor(-1);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final Pair pair = (Pair) it.next();
            String str = (String) pair.first;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.five_corp.ad.internal.view.c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ((Runnable) pair.second).run();
                }
            };
            TextView textView = new TextView(activity);
            int iA2 = this.f1568a.a(8);
            int iA3 = this.f1568a.a(16);
            textView.setPadding(iA3, iA2, iA3, iA2);
            textView.setText(str);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setGravity(17);
            textView.setOnClickListener(onClickListener);
            textView.setClickable(true);
            textView.setFocusable(true);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
            shapeDrawable.getPaint().setColor(-1);
            textView.setBackground(new RippleDrawable(ColorStateList.valueOf(-3355444), shapeDrawable, null));
            addView(textView);
        }
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f1568a.a(5)));
        addView(view);
        String string = activity.getString(R.string.cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.five_corp.ad.internal.view.c$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.a(view2);
            }
        };
        Button button = new Button(activity);
        button.setText(string);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        button.setOnClickListener(onClickListener2);
        button.setStateListAnimator(null);
        button.setElevation(0.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(this.f1568a.a(8));
        gradientDrawable.setStroke(this.f1568a.a(2), -3355444);
        button.setBackground(new RippleDrawable(ColorStateList.valueOf(-3355444), gradientDrawable, null));
        addView(button);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
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

    public final /* synthetic */ void a(View view) {
        this.b.a();
    }
}
