package com.inmobi.media;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3366f4 implements bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3380g4 f3310a;

    public C3366f4(C3380g4 c3380g4) {
        this.f3310a = c3380g4;
    }

    @Override // com.inmobi.media.bd
    public final void a(ArrayList visibleViews, ArrayList invisibleViews) {
        Intrinsics.checkNotNullParameter(visibleViews, "visibleViews");
        Intrinsics.checkNotNullParameter(invisibleViews, "invisibleViews");
        Iterator it = visibleViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            Yc yc = (Yc) this.f3310a.i.get(view);
            if (yc != null) {
                yc.a(view, true);
            }
        }
        Iterator it2 = invisibleViews.iterator();
        while (it2.hasNext()) {
            View view2 = (View) it2.next();
            Yc yc2 = (Yc) this.f3310a.i.get(view2);
            if (yc2 != null) {
                yc2.a(view2, false);
            }
        }
    }
}
