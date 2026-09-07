package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class so implements View.OnTouchListener, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.OnClickListener f10228a;
    private final int b;
    private boolean c;
    private float d;
    private float e;

    public so(Context context, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.f10228a = onClickListener;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.b = scaledTouchSlop * scaledTouchSlop;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = action & 255;
        if (i == 0) {
            this.d = x;
            this.e = y;
            this.c = true;
        } else {
            if (i == 1) {
                if (!this.c) {
                    return true;
                }
                this.f10228a.onClick(view);
                return true;
            }
            if (i != 2) {
                if (i == 3) {
                    this.c = false;
                }
            } else if (this.c) {
                int i2 = (int) (x - this.d);
                int i3 = (int) (y - this.e);
                if ((i3 * i3) + (i2 * i2) > this.b) {
                    this.c = false;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10228a.onClick(view);
    }
}
