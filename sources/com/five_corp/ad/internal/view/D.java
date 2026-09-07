package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class D extends G {
    public final com.five_corp.ad.internal.cache.f j;
    public C k;
    public ImageView l;
    public final com.five_corp.ad.internal.ad.p m;
    public final com.five_corp.ad.internal.ad.p n;

    public D(Context context, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.k kVar, com.five_corp.ad.f fVar, com.five_corp.ad.internal.logger.a aVar) {
        super(context, lVar, kVar, fVar, aVar);
        this.j = lVar.h;
        com.five_corp.ad.internal.ad.d dVar = lVar.b.E;
        if (dVar == null || dVar.f1286a != 2) {
            return;
        }
        com.five_corp.ad.internal.ad.p pVar = new com.five_corp.ad.internal.ad.p(getContext());
        this.m = pVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        pVar.setLayoutParams(layoutParams);
        pVar.setGravity(17);
        pVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(pVar, 1);
        addView(pVar);
        com.five_corp.ad.internal.ad.p pVar2 = new com.five_corp.ad.internal.ad.p(getContext());
        this.n = pVar2;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        pVar2.setLayoutParams(layoutParams2);
        pVar2.setGravity(17);
        pVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(pVar2, 1);
        addView(pVar2);
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void a(boolean z) {
    }

    @Override // com.five_corp.ad.internal.view.G
    public final boolean c() {
        return false;
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void d() {
        if (this.k == null) {
            C c = new C(this);
            this.k = c;
            this.j.a(this.b.b.k, c);
        }
    }

    @Override // com.five_corp.ad.internal.view.G, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void e() {
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void f() {
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void g() {
    }

    @Override // com.five_corp.ad.internal.view.G
    public final int getCurrentPositionMs() {
        return 0;
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void a(com.five_corp.ad.internal.viewability.b bVar) {
        double dFloor = Math.floor(bVar.f1590a * 100.0d) / 100.0d;
        double dFloor2 = Math.floor(bVar.b * 100.0d) / 100.0d;
        com.five_corp.ad.internal.ad.p pVar = this.m;
        if (pVar != null) {
            pVar.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
        com.five_corp.ad.internal.ad.p pVar2 = this.n;
        if (pVar2 != null) {
            pVar2.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
    }
}
