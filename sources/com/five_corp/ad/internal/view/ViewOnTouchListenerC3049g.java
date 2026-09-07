package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: com.five_corp.ad.internal.view.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class ViewOnTouchListenerC3049g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1570a;
    public final InterfaceC3048f b;
    public final com.five_corp.ad.internal.logger.a c;

    public ViewOnTouchListenerC3049g(Context context, InterfaceC3048f interfaceC3048f, com.five_corp.ad.internal.logger.a aVar) {
        this.f1570a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.b = interfaceC3048f;
        this.c = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            int iMax = Math.max(view.getWidth(), 1);
            int iMax2 = Math.max(view.getHeight(), 1);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (motionEvent.getActionMasked() == 1) {
                int i = this.f1570a;
                float f = -i;
                if (f <= x && x <= iMax + i && f <= y && y <= iMax2 + i) {
                    this.b.a(x, y);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            this.c.a(th);
            return false;
        }
    }
}
