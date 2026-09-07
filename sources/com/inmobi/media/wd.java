package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class wd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3468a;
    public final WeakReference b;

    public wd(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3468a = new ArrayList();
        this.b = new WeakReference(view);
        if (C3435k3.f3355a.F()) {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.inmobi.media.wd$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return wd.a(this.f$0, view2, windowInsets);
                }
            });
        }
    }

    public static final WindowInsets a(wd this$0, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        if (this$0.f3468a.isEmpty()) {
            return windowInsets;
        }
        Iterator it = this$0.f3468a.iterator();
        while (it.hasNext()) {
            Ad ad = (Ad) ((vd) it.next());
            ad.getClass();
            Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
            try {
                Activity activity = (Activity) ad.d.get();
                if (!ad.f3029a.f()) {
                    L4 l4 = ad.b;
                    if (l4 != null) {
                        ((M4) l4).a("WindowInsetsHandler", "listener is not interested in computing insets, skipping");
                    }
                } else if (activity == null) {
                    L4 l5 = ad.b;
                    if (l5 != null) {
                        ((M4) l5).b("WindowInsetsHandler", "Activity is null, skipping safeArea computation");
                    }
                } else {
                    yd ydVarB = AbstractC3420j2.a(activity) ? Ka.b(windowInsets) : Ka.a(windowInsets);
                    Integer numF = AbstractC3565t3.f();
                    int iIntValue = numF != null ? numF.intValue() : AbstractC3565t3.a(windowInsets);
                    AbstractC3565t3.a(Integer.valueOf(iIntValue));
                    ad.a(ydVarB, iIntValue);
                }
            } catch (Error e) {
                L4 l6 = ad.b;
                if (l6 != null) {
                    ((M4) l6).b("WindowInsetsHandler", "Error in getting safeArea " + e.getMessage());
                }
            } catch (Exception e2) {
                L4 l7 = ad.b;
                if (l7 != null) {
                    ((M4) l7).a("WindowInsetsHandler", "Exception in getting safeArea", e2);
                }
            }
        }
        return windowInsets;
    }

    public final void a() {
        View view;
        this.f3468a.clear();
        if (!C3435k3.f3355a.F() || (view = (View) this.b.get()) == null) {
            return;
        }
        view.setOnApplyWindowInsetsListener(null);
    }
}
