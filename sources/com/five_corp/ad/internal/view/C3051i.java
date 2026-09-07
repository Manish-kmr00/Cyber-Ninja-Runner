package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Locale;

/* JADX INFO: renamed from: com.five_corp.ad.internal.view.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3051i extends FrameLayout implements com.five_corp.ad.internal.layouter.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1572a;
    public final C3052j b;
    public final float c;
    public final com.five_corp.ad.internal.logger.a d;

    public C3051i(Context context, com.five_corp.ad.internal.ad.custom_layout.i iVar, int i, com.five_corp.ad.internal.logger.a aVar) {
        float f;
        super(context);
        this.d = aVar;
        C3052j c3052j = new C3052j(context, iVar, aVar);
        this.b = c3052j;
        addView(c3052j, new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        this.f1572a = textView;
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        textView.setTextSize(0, getHeight() * 0.8f);
        textView.setTextColor(J.a(iVar.d));
        textView.setSingleLine();
        addView(textView, layoutParams);
        if (i >= 100000) {
            f = 0.5f;
        } else {
            if (i < 10000) {
                this.c = 0.8f;
                return;
            }
            f = 0.65f;
        }
        this.c = f;
    }

    @Override // com.five_corp.ad.internal.layouter.k
    public final void a(com.five_corp.ad.internal.layouter.h hVar) {
        TextView textView = this.f1572a;
        Locale locale = Locale.ENGLISH;
        int i = hVar.b / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        textView.setText(sb.toString());
        C3052j c3052j = this.b;
        c3052j.getClass();
        c3052j.d = hVar.d;
        c3052j.invalidate();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        try {
            this.f1572a.setTextSize(0, getHeight() * this.c);
        } catch (Throwable th) {
            this.d.a(th);
        }
    }
}
