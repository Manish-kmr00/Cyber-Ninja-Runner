package com.five_corp.ad.internal.layouter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.five_corp.ad.internal.E;
import com.five_corp.ad.internal.ad.fullscreen.o;
import com.five_corp.ad.internal.ad.fullscreen.p;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.view.G;
import com.five_corp.ad.internal.view.J;
import com.five_corp.ad.internal.view.m;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements d, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f1418a;
    public final Activity b;
    public final f c;
    public final E d;
    public final com.five_corp.ad.internal.cache.f e;
    public final com.five_corp.ad.internal.view.l g;
    public ImageView h;
    public View i;
    public View j;
    public final com.five_corp.ad.internal.fullscreen.c m;
    public final com.five_corp.ad.internal.logger.a n;
    public h o;
    public final HashSet f = new HashSet();
    public FrameLayout k = null;
    public final FrameLayout.LayoutParams l = new FrameLayout.LayoutParams(-1, -1);

    static {
        g.class.toString();
    }

    public g(m mVar, Activity activity, E e, com.five_corp.ad.internal.logger.a aVar, G g, com.five_corp.ad.internal.context.l lVar, f fVar, com.five_corp.ad.internal.fullscreen.c cVar, com.five_corp.ad.internal.viewability.a aVar2, j jVar) {
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f1418a = frameLayout;
        this.b = activity;
        this.c = fVar;
        this.d = e;
        this.m = cVar;
        this.g = new com.five_corp.ad.internal.view.l(activity, aVar, g, this, lVar, null, aVar2, fVar.f, jVar);
        this.h = new ImageView(activity);
        this.e = lVar.h;
        this.n = aVar;
        jVar.f1420a.f1561a.add(new WeakReference(this));
        this.o = jVar.b;
        mVar.addView(frameLayout);
        BitmapDrawable bitmapDrawableA = l.a(lVar.c, activity.getResources(), aVar);
        if (bitmapDrawableA != null) {
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setClickable(false);
            frameLayout2.setFocusable(false);
            frameLayout2.setBackground(bitmapDrawableA);
            mVar.addView(frameLayout2);
        }
    }

    public final void a(View view, com.five_corp.ad.internal.ad.fullscreen.d dVar, int i, int i2) {
        int i3;
        double d;
        double d2;
        int i4;
        if (this.d.f1264a.getResources().getConfiguration().orientation == 1) {
            i3 = (int) (((double) i2) * dVar.f1292a);
            d = i3;
            d2 = dVar.b;
        } else {
            i3 = (int) (((double) i2) * dVar.c);
            d = i3;
            d2 = dVar.d;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, (int) (d * d2));
        switch (com.five_corp.ad.e.a(i)) {
            case 1:
                i4 = 51;
                break;
            case 2:
                i4 = 53;
                break;
            case 3:
                i4 = 83;
                break;
            case 4:
                i4 = 85;
                break;
            case 5:
                i4 = 49;
                break;
            case 6:
                i4 = 19;
                break;
            case 7:
                i4 = 17;
                break;
            case 8:
                i4 = 21;
                break;
            case 9:
                i4 = 81;
                break;
            default:
                this.f.add(view);
                view.setLayoutParams(layoutParams);
                this.f1418a.addView(view);
        }
        layoutParams.gravity = i4;
        this.f.add(view);
        view.setLayoutParams(layoutParams);
        this.f1418a.addView(view);
    }

    public final void b(View view) {
        try {
            com.five_corp.ad.internal.fullscreen.c cVar = this.m;
            boolean zBooleanValue = this.c.f1417a.booleanValue();
            if (cVar.m.get()) {
                return;
            }
            com.five_corp.ad.f fVar = cVar.i;
            if (fVar.v != null) {
                fVar.o();
                if (zBooleanValue) {
                    fVar.d.post(new com.five_corp.ad.b(fVar));
                }
            }
        } catch (Throwable th) {
            this.n.a(th);
        }
    }

    public final void c(View view) {
        try {
            this.m.i.r();
        } catch (Throwable th) {
            this.n.a(th);
        }
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void d() {
        this.m.i.r();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void e() {
        this.m.i.k();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void f() {
        com.five_corp.ad.f fVar;
        com.five_corp.ad.internal.fullscreen.c cVar;
        com.five_corp.ad.internal.fullscreen.c cVar2 = this.m;
        if (cVar2.m.get() || (cVar = (fVar = cVar2.i).v) == null) {
            return;
        }
        cVar.c();
        int currentPositionMs = fVar.h.getCurrentPositionMs();
        fVar.h.f();
        fVar.o.r(currentPositionMs, fVar.t);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void g() {
        com.five_corp.ad.internal.fullscreen.c cVar = this.m;
        boolean zBooleanValue = this.c.f1417a.booleanValue();
        cVar.f.a("PLAY_IN_FULLSCREEN feature is currently not supported (ResizableFullScreen).", 4);
        if (cVar.m.get()) {
            return;
        }
        com.five_corp.ad.f fVar = cVar.i;
        if (fVar.v != null) {
            fVar.o();
            if (zBooleanValue) {
                fVar.d.post(new com.five_corp.ad.b(fVar));
            }
        }
    }

    public final void h() {
        FrameLayout frameLayout;
        View view;
        if (this.k == null || this.c.d == null) {
            return;
        }
        if (this.o.f) {
            J.a(this.j);
            View view2 = this.i;
            if (view2 == null || view2.getParent() != null) {
                return;
            }
            frameLayout = this.k;
            view = this.i;
        } else {
            J.a(this.i);
            View view3 = this.j;
            if (view3 == null || view3.getParent() != null) {
                return;
            }
            frameLayout = this.k;
            view = this.j;
        }
        frameLayout.addView(view, this.l);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void c() {
        this.m.i.h.g();
    }

    public static View a(Context context, com.five_corp.ad.internal.cache.f fVar, com.five_corp.ad.internal.ad.fullscreen.a aVar) {
        s sVar;
        int iA = com.five_corp.ad.e.a(aVar.f1291a);
        if (iA != 0) {
            if (iA == 1 && (sVar = aVar.c) != null) {
                return fVar.a(context, sVar);
            }
            return null;
        }
        com.five_corp.ad.internal.ad.fullscreen.e eVar = aVar.b;
        if (eVar == null) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(eVar.b);
        textView.setTextColor(J.a(eVar.c));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(J.a(eVar.f1293a));
        gradientDrawable.setCornerRadius(5.0f);
        gradientDrawable.setStroke(1, J.a(eVar.c));
        J.a(textView, gradientDrawable);
        textView.setGravity(17);
        return textView;
    }

    public final FrameLayout.LayoutParams a(int i, int i2) {
        com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig = this.g.getCustomLayoutConfig();
        if (customLayoutConfig == null) {
            return new FrameLayout.LayoutParams(0, 0);
        }
        return customLayoutConfig.b * i < customLayoutConfig.f1277a * i2 ? new FrameLayout.LayoutParams(i, (customLayoutConfig.b * i) / customLayoutConfig.f1277a, 17) : new FrameLayout.LayoutParams((customLayoutConfig.f1277a * i2) / customLayoutConfig.b, i2, 17);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void b() {
        this.m.i.j();
    }

    public final void a(View view) {
        try {
            this.m.i.j();
        } catch (Throwable th) {
            this.n.a(th);
        }
    }

    public final void b(int i, int i2) {
        View viewA;
        View viewA2;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            J.a((View) it.next());
        }
        this.f.clear();
        com.five_corp.ad.internal.ad.fullscreen.f fVar = this.c.b;
        if (fVar != null && (viewA2 = a(this.b, this.e, fVar.c)) != null) {
            viewA2.setOnClickListener(new View.OnClickListener() { // from class: com.five_corp.ad.internal.layouter.g$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
            a(viewA2, fVar.b, fVar.f1294a, i);
        }
        o oVar = this.c.c;
        if (oVar != null && (viewA = a(this.b, this.e, oVar.c)) != null) {
            viewA.setOnClickListener(new View.OnClickListener() { // from class: com.five_corp.ad.internal.layouter.g$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
            a(viewA, oVar.b, oVar.f1300a, i);
        }
        p pVar = this.c.d;
        if (pVar != null) {
            this.i = a(this.b, this.e, pVar.c);
            this.j = a(this.b, this.e, pVar.d);
            this.k = new FrameLayout(this.b);
            h();
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.five_corp.ad.internal.layouter.g$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
            a(this.k, pVar.b, pVar.f1301a, i);
        }
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a(String str) {
        this.m.i.b(str);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a() {
        com.five_corp.ad.internal.fullscreen.c cVar = this.m;
        boolean zBooleanValue = this.c.f1417a.booleanValue();
        if (cVar.m.get()) {
            return;
        }
        com.five_corp.ad.f fVar = cVar.i;
        if (fVar.v != null) {
            fVar.o();
            if (zBooleanValue) {
                fVar.d.post(new com.five_corp.ad.b(fVar));
            }
        }
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a(com.five_corp.ad.internal.o oVar) {
        com.five_corp.ad.f fVar = this.m.i;
        fVar.a(fVar.h.getCurrentPositionMs(), oVar);
    }

    @Override // com.five_corp.ad.internal.layouter.i
    public final void a(h hVar) {
        this.o = hVar;
        h();
    }
}
