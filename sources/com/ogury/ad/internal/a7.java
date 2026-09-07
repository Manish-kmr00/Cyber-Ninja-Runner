package com.ogury.ad.internal;

import android.app.Activity;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8 f7260a;
    public final b8 b;
    public final t7 c;

    public a7(a8 publisherActivityFilter, b8 publisherFragmentFilter, y8 supportLibraryChecker, t7 profigGateway) {
        Intrinsics.checkNotNullParameter(publisherActivityFilter, "publisherActivityFilter");
        Intrinsics.checkNotNullParameter(publisherFragmentFilter, "publisherFragmentFilter");
        Intrinsics.checkNotNullParameter(supportLibraryChecker, "supportLibraryChecker");
        Intrinsics.checkNotNullParameter(profigGateway, "profigGateway");
        this.f7260a = publisherActivityFilter;
        this.b = publisherFragmentFilter;
        this.c = profigGateway;
    }

    public final z6 a(Activity activity, h adLayout, j4 adController) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        q6 q6Var = new q6(adController, adLayout);
        this.c.getClass();
        z7.k overlayActivityConfig = t7.b.d.f.c;
        this.c.getClass();
        z7.l fragmentOverlayConfig = t7.b.d.f.b;
        a8 publisherActivityFilter = this.f7260a;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(publisherActivityFilter, "publisherActivityFilter");
        Intrinsics.checkNotNullParameter(overlayActivityConfig, "overlayActivityConfig");
        l6 l6Var = new l6(overlayActivityConfig, activity.getClass());
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (overlayActivityConfig.f7474a) {
            l6Var.c.add(h7.a(activity));
        }
        List<String> list = publisherActivityFilter.f7261a;
        Intrinsics.checkNotNullParameter(list, "list");
        if (overlayActivityConfig.b) {
            l6Var.c.addAll(list);
        }
        List<? extends Class<? extends Activity>> activities = publisherActivityFilter.b;
        Intrinsics.checkNotNullParameter(activities, "activities");
        if (overlayActivityConfig.c) {
            Iterator<T> it = activities.iterator();
            while (it.hasNext()) {
                Class cls = (Class) it.next();
                ArrayList arrayList = l6Var.d;
                String canonicalName = cls.getCanonicalName();
                Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
                arrayList.add(canonicalName);
            }
        }
        b8 publisherFragmentFilter = this.b;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragmentOverlayConfig, "fragmentOverlayConfig");
        Intrinsics.checkNotNullParameter(publisherFragmentFilter, "publisherFragmentFilter");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(fragmentOverlayConfig.d);
        if (fragmentOverlayConfig.b) {
            arrayList2.addAll(publisherFragmentFilter.f7270a);
        }
        if (fragmentOverlayConfig.f7474a) {
            arrayList2.add(h7.a(activity));
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(fragmentOverlayConfig.e);
        if (fragmentOverlayConfig.c) {
            Iterator<T> it2 = publisherFragmentFilter.b.iterator();
            while (it2.hasNext()) {
                Class cls2 = (Class) it2.next();
                String canonicalName2 = cls2.getCanonicalName();
                if (canonicalName2 == null) {
                    canonicalName2 = cls2.getName();
                }
                Intrinsics.checkNotNull(canonicalName2);
                arrayList3.add(canonicalName2);
            }
        }
        k2 k2Var = new k2(arrayList2, arrayList3);
        b8 b8Var = this.b;
        if ((b8Var.f7270a.isEmpty() && b8Var.b.isEmpty()) || !fragmentOverlayConfig.f) {
            return new m6(activity, q6Var, l6Var);
        }
        try {
            Class.forName("androidx.fragment.app.Fragment");
            return new y6(activity, q6Var, new x6(k2Var), g9.f7309a);
        } catch (Exception unused) {
            Intrinsics.checkNotNullParameter("Fragment filter defined for thumbnail but no fragment dependency found. Only AndroidX is supported", "msg");
            Log.e("OGURY", "Fragment filter defined for thumbnail but no fragment dependency found. Only AndroidX is supported");
            return new m6(activity, q6Var, l6Var);
        }
    }
}
