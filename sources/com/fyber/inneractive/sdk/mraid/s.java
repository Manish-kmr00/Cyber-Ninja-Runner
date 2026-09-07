package com.fyber.inneractive.sdk.mraid;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.C3274m;
import com.fyber.inneractive.sdk.web.EnumC3286z;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.k0;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class s extends AbstractC3123f {
    public s(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x014b  */
    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        ViewGroup viewGroup;
        int iA = a("w");
        int iA2 = a("h");
        int iA3 = a("offsetX");
        int iA4 = a("offsetY");
        boolean zEquals = "true".equals(this.b.get("allowOffscreen"));
        if (iA <= 0) {
            iA = this.c.Z;
        }
        if (iA2 <= 0) {
            iA2 = this.c.a0;
        }
        I i = this.c;
        C3274m c3274m = i.b;
        if (c3274m == null) {
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) c3274m.getRootView().findViewById(R.id.content);
            i.R = viewGroup2;
            if (viewGroup2 == null) {
                IAlog.f("Couldn't find content in the view tree", new Object[0]);
                i.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (i.O == EnumC3286z.DISABLED) {
                return;
            }
            F f = i.N;
            if (f != F.DEFAULT && f != F.RESIZED) {
                i.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (iA < 0 && iA2 < 0) {
                i.a(k.RESIZE, "Creative size passed to resize() was invalid.");
                return;
            }
            i.X = false;
            k0 k0Var = i.g;
            if (k0Var != null) {
                ((com.fyber.inneractive.sdk.web.B) k0Var).b(false);
            }
            com.fyber.inneractive.sdk.web.D d = i.P;
            if (d == com.fyber.inneractive.sdk.web.D.ALWAYS_VISIBLE || (!i.X && d != com.fyber.inneractive.sdk.web.D.ALWAYS_HIDDEN)) {
                i.c(true);
            }
            i.d(false);
            i.e0 = AbstractC3251o.a(iA2);
            i.d0 = AbstractC3251o.a(iA);
            if (!zEquals) {
                int i2 = (iA3 + iA) - i.Z;
                if (i2 > 0) {
                    iA3 -= i2;
                }
                if (iA3 < 0) {
                    iA3 = 0;
                }
                int i3 = (iA4 + iA2) - i.a0;
                if (i3 > 0) {
                    iA4 -= i3;
                }
                if (iA4 < 0) {
                    iA4 = 0;
                }
            }
            int iA5 = AbstractC3251o.a(iA);
            int iA6 = AbstractC3251o.a(iA2);
            C3274m c3274m2 = i.b;
            ViewGroup.LayoutParams layoutParams = c3274m2.getLayoutParams();
            layoutParams.width = iA5;
            layoutParams.height = iA6;
            c3274m2.setLayoutParams(layoutParams);
            AbstractC3251o.a(i.b, 17);
            C3274m c3274m3 = i.b;
            ViewGroup.LayoutParams layoutParams2 = c3274m3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = iA3;
                marginLayoutParams.topMargin = iA4;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                c3274m3.setLayoutParams(marginLayoutParams);
            }
            F f2 = i.N;
            F f3 = F.RESIZED;
            if (f2 != f3) {
                i.N = f3;
                i.a(new D(f3));
                int i4 = i.d0;
                if (i4 != -1 && i.e0 != -1) {
                    i.a(new x(AbstractC3251o.b(i4), AbstractC3251o.b(i.e0)));
                }
            }
            i.a(k.RESIZE);
            ViewGroup viewGroup3 = (ViewGroup) i.b.getParent();
            if (viewGroup3 == null) {
                viewGroup = null;
            } else {
                View viewFindViewById = viewGroup3.findViewById(com.fyber.inneractive.sdk.R.id.ia_identifier_overlay);
                if (viewFindViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewFindViewById;
                } else {
                    viewGroup = null;
                }
            }
            C3274m c3274m4 = i.b;
            if (c3274m4 != null && viewGroup != null) {
                viewGroup.setLayoutParams(c3274m4.getLayoutParams());
            }
            k0 k0Var2 = i.g;
            if (k0Var2 != null) {
                ((com.fyber.inneractive.sdk.web.B) k0Var2).b();
            }
        } catch (Exception unused) {
            IAlog.f("Couldn't find content in the view tree", new Object[0]);
            i.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final boolean b() {
        return true;
    }
}
