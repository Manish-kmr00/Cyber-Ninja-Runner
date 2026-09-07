package com.inmobi.media;

import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.o4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3496o4 implements bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3552s4 f3386a;

    public C3496o4(C3552s4 c3552s4) {
        this.f3386a = c3552s4;
    }

    @Override // com.inmobi.media.bd
    public final void a(ArrayList visibleViews, ArrayList invisibleViews) {
        Intrinsics.checkNotNullParameter(visibleViews, "visibleViews");
        Intrinsics.checkNotNullParameter(invisibleViews, "invisibleViews");
        Intrinsics.checkNotNullExpressionValue(this.f3386a.d, "access$getTAG$p(...)");
        Objects.toString(visibleViews);
        Objects.toString(invisibleViews);
        Iterator it = visibleViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            C3524q4 c3524q4 = (C3524q4) this.f3386a.f3424a.get(view);
            if (c3524q4 == null) {
                this.f3386a.a(view);
            } else {
                C3524q4 c3524q5 = (C3524q4) this.f3386a.b.get(view);
                if (!Intrinsics.areEqual(c3524q4.f3404a, c3524q5 != null ? c3524q5.f3404a : null)) {
                    c3524q4.d = SystemClock.uptimeMillis();
                    this.f3386a.b.put(view, c3524q4);
                }
            }
        }
        Iterator it2 = invisibleViews.iterator();
        while (it2.hasNext()) {
            this.f3386a.b.remove((View) it2.next());
        }
        C3552s4 c3552s4 = this.f3386a;
        if (c3552s4.e.hasMessages(0)) {
            return;
        }
        c3552s4.e.postDelayed(c3552s4.f, c3552s4.g);
    }
}
