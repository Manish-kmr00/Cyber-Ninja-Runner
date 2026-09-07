package com.five_corp.ad.internal.viewability;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.five_corp.ad.internal.context.l;
import com.five_corp.ad.internal.context.t;
import com.five_corp.ad.internal.util.h;
import com.five_corp.ad.internal.view.G;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1589a;
    public final int b;
    public final double c;
    public final boolean d;
    public final G e;
    public View f;
    public final Object g = new Object();
    public boolean h = true;
    public final h i;

    static {
        a.class.toString();
    }

    public a(Context context, l lVar, G g) {
        this.f1589a = context;
        this.b = lVar.e.d;
        t tVar = lVar.d;
        this.c = tVar.c.e;
        this.d = tVar.b.f;
        this.i = new h();
        this.e = g;
        this.f = null;
    }

    /* JADX WARN: Code duplicated, block: B:88:0x01a6  */
    public final double a(HashSet hashSet, View view) {
        Context context = this.f1589a;
        double d = 0.0d;
        if (view.isShown() && ((PowerManager) context.getSystemService("power")).isScreenOn() && !((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() && view.getWindowVisibility() == 0) {
            Object parent = view;
            while (parent != null && (parent instanceof View)) {
                View view2 = (View) parent;
                if (view2.getAlpha() > 0.0f) {
                    parent = view2.getParent();
                }
            }
            boolean z = this.d;
            int height = view.getHeight() * view.getWidth();
            Rect rect = new Rect();
            View view3 = view;
            if (view3.getGlobalVisibleRect(rect)) {
                if (z) {
                    d = ((double) ((rect.right - rect.left) * (rect.bottom - rect.top))) / ((double) height);
                } else {
                    double scaleY = 1.0d;
                    while (view3 != null) {
                        ViewParent parent2 = view3.getParent();
                        if (parent2 != null && (parent2 instanceof ViewGroup) && !hashSet.contains(parent2)) {
                            ViewGroup viewGroup = (ViewGroup) parent2;
                            int i = 1;
                            int i2 = 0;
                            int i3 = 0;
                            while (i3 < viewGroup.getChildCount()) {
                                View childAt = viewGroup.getChildAt(i3);
                                if (childAt == view3) {
                                    i = i2;
                                } else if (childAt.isShown() && childAt.getAlpha() > d && ((!(childAt instanceof ViewGroup) || ((ViewGroup) childAt).getChildCount() != 0) && view3.getZ() <= childAt.getZ() && ((view3.getZ() != childAt.getZ() || i == 0) && !hashSet.contains(childAt)))) {
                                    Rect rect2 = new Rect();
                                    if (childAt.getGlobalVisibleRect(rect2) && rect.right > rect2.left && rect.bottom > rect2.top && rect2.right > rect.left && rect2.bottom > rect.top) {
                                        Rect rect3 = new Rect(i2, i2, i2, i2);
                                        if (rect.left < rect2.left) {
                                            rect3 = new Rect(rect.left, rect.top, rect2.left, rect.bottom);
                                        }
                                        if (rect2.right < rect.right) {
                                            Rect rect4 = new Rect(rect2.right, rect.top, rect.right, rect.bottom);
                                            if ((rect3.right - rect3.left) * (rect3.bottom - rect3.top) < (rect4.right - rect4.left) * (rect4.bottom - rect4.top)) {
                                                rect3 = rect4;
                                            }
                                        }
                                        if (rect2.bottom < rect.bottom) {
                                            Rect rect5 = new Rect(rect.left, rect2.bottom, rect.right, rect.bottom);
                                            if ((rect3.right - rect3.left) * (rect3.bottom - rect3.top) < (rect5.right - rect5.left) * (rect5.bottom - rect5.top)) {
                                                rect3 = rect5;
                                            }
                                        }
                                        if (rect.top < rect2.top) {
                                            Rect rect6 = new Rect(rect.left, rect.top, rect.right, rect2.top);
                                            if ((rect3.right - rect3.left) * (rect3.bottom - rect3.top) < (rect6.right - rect6.left) * (rect6.bottom - rect6.top)) {
                                                rect = rect6;
                                            } else {
                                                rect = rect3;
                                            }
                                        } else {
                                            rect = rect3;
                                        }
                                    }
                                }
                                i3++;
                                hashSet = hashSet;
                                d = 0.0d;
                                i2 = 0;
                            }
                        }
                        scaleY *= (double) (view3.getScaleY() * view3.getScaleX());
                        Object parent3 = view3.getParent();
                        if (!(parent3 instanceof View)) {
                            break;
                        }
                        view3 = (View) parent3;
                        d = 0.0d;
                    }
                    double d2 = ((double) height) * scaleY;
                    d = 0.0d;
                    if (d2 > 0.0d) {
                        d = ((double) ((rect.right - rect.left) * (rect.bottom - rect.top))) / d2;
                    }
                }
            }
            if (this.c + d >= 1.0d) {
                return 1.0d;
            }
            return d;
        }
        return 0.0d;
    }

    public final void a(View view, int i) {
        synchronized (this.g) {
            h hVar = this.i;
            hVar.getClass();
            HashSet hashSet = new HashSet();
            hVar.a(hashSet);
            if (hashSet.contains(view)) {
                return;
            }
            if (this.b == 2 && i == 0) {
                return;
            }
            this.i.f1561a.add(new WeakReference(view));
        }
    }
}
