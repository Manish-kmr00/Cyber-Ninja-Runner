package com.ogury.ad.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ogury.ad.internal.t1;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s1<T extends ViewGroup & t1> implements r1 {
    public static final a e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f7397a;
    public float b;
    public float c;
    public long d;

    public static final class a implements r1 {
        @Override // com.ogury.ad.internal.r1
        public final boolean a(MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            return false;
        }
    }

    public s1(T adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        this.f7397a = adLayout;
    }

    @Override // com.ogury.ad.internal.r1
    public final boolean a(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f7397a.a();
                if (Calendar.getInstance().getTimeInMillis() - this.d >= 200) {
                    int childCount = this.f7397a.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.f7397a.getChildAt(i);
                        if (childAt instanceof d5) {
                            h5.a(((d5) childAt).getMraidCommandExecutor().f7364a, "ogySdkMraidGateway.callEventListeners(\"ogyOnTouchEnd\", {})");
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        this.d = Calendar.getInstance().getTimeInMillis();
        int action2 = ev.getAction();
        if (action2 == 0) {
            this.b = this.f7397a.getX() - ev.getRawX();
            this.c = this.f7397a.getY() - ev.getRawY();
        } else if (action2 == 2) {
            this.f7397a.bringToFront();
            float rawX = ev.getRawX() + this.b + (this.f7397a.getWidth() / 4);
            if (rawX > 0.0f && rawX + (this.f7397a.getWidth() / 2) < this.f7397a.getContainerWidth()) {
                this.f7397a.setX(ev.getRawX() + this.b);
            }
            float rawY = ev.getRawY() + this.c + (this.f7397a.getHeight() / 4);
            if (rawY > 0.0f && rawY + (this.f7397a.getHeight() / 2) < this.f7397a.getContainerHeight()) {
                this.f7397a.setY(ev.getRawY() + this.c);
            }
        }
        return false;
    }
}
