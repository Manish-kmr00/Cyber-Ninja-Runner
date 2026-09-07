package com.inmobi.media;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class G7 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L7 f3080a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ C3455l7 c;

    public G7(L7 l7, ArrayList arrayList, C3455l7 c3455l7) {
        this.f3080a = l7;
        this.b = arrayList;
        this.c = c3455l7;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f3080a.l.a(this.b);
        C3313b7 c3313b7 = this.f3080a.b;
        C3455l7 c3455l7A = c3313b7.a(c3313b7.b, this.c);
        C3455l7 c3455l7 = this.c;
        C3313b7 c3313b8 = this.f3080a.b;
        if (c3455l7A == null) {
            c3455l7A = c3455l7;
        }
        c3455l7.a(EventConstants.CREATIVE_VIEW, c3313b8.a(c3455l7A), (T6) null, this.f3080a.f);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.removeOnAttachStateChangeListener(this);
        L0 l0 = this.f3080a.l;
        ArrayList arrayList = this.b;
        l0.getClass();
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((K0) it.next()).f3109a.cancel();
        }
        l0.b.removeAll(arrayList);
    }
}
