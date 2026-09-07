package com.inmobi.media;

import android.os.SystemClock;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.r4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC3537r4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3415a;
    public final ArrayList b;
    public final WeakReference c;

    public RunnableC3537r4(C3552s4 impressionTracker) {
        Intrinsics.checkNotNullParameter(impressionTracker, "impressionTracker");
        this.f3415a = "r4";
        this.b = new ArrayList();
        this.c = new WeakReference(impressionTracker);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intrinsics.checkNotNull(this.f3415a);
        C3552s4 c3552s4 = (C3552s4) this.c.get();
        if (c3552s4 != null) {
            for (Map.Entry entry : c3552s4.b.entrySet()) {
                View view = (View) entry.getKey();
                C3524q4 c3524q4 = (C3524q4) entry.getValue();
                Intrinsics.checkNotNull(this.f3415a);
                Objects.toString(c3524q4);
                if (SystemClock.uptimeMillis() - c3524q4.d >= c3524q4.c) {
                    Intrinsics.checkNotNull(this.f3415a);
                    c3552s4.h.a(view, c3524q4.f3404a);
                    this.b.add(view);
                }
            }
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                c3552s4.a((View) it.next());
            }
            this.b.clear();
            if (c3552s4.b.isEmpty() || c3552s4.e.hasMessages(0)) {
                return;
            }
            c3552s4.e.postDelayed(c3552s4.f, c3552s4.g);
        }
    }
}
