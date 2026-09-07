package com.ogury.ad.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z7.k f7345a;
    public final Class<? extends Activity> b;
    public final ArrayList c;
    public final ArrayList d;

    public l6(z7.k overlayActivityConfig, Class<? extends Activity> showActivityClass) {
        Intrinsics.checkNotNullParameter(overlayActivityConfig, "overlayActivityConfig");
        Intrinsics.checkNotNullParameter(showActivityClass, "showActivityClass");
        this.f7345a = overlayActivityConfig;
        this.b = showActivityClass;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.d = arrayList2;
        if (!overlayActivityConfig.e.isEmpty()) {
            arrayList2.addAll(overlayActivityConfig.e);
        }
        if (overlayActivityConfig.d.isEmpty()) {
            return;
        }
        arrayList.addAll(overlayActivityConfig.d);
    }

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof s5) {
            return false;
        }
        if (!this.f7345a.f && !Intrinsics.areEqual(activity.getClass(), this.b)) {
            return false;
        }
        String strA = h7.a((Object) activity);
        ArrayList arrayList = this.d;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith$default(strA, (String) it.next(), false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        String strA2 = h7.a((Object) activity);
        ArrayList arrayList2 = this.c;
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (StringsKt.startsWith$default(strA2, (String) it2.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
