package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f6938a;
    public List<String> b;
    public final List<String> c;
    public final l d;

    public h(List<String> list, List<String> list2, List<String> list3, l vastTracker) {
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.f6938a = list;
        this.b = list2;
        this.c = list3;
        this.d = vastTracker;
    }

    public final void a() {
        List<String> list = this.b;
        if (list != null) {
            l.a.a(this.d, list, null, null, null, 14, null);
            this.b = null;
        }
    }

    public final boolean b() {
        List<String> list = this.f6938a;
        if (list == null) {
            return false;
        }
        l.a.a(this.d, list, null, null, null, 14, null);
        this.f6938a = null;
        return true;
    }

    public static /* synthetic */ void a(h hVar, x xVar, int i, Object obj) {
        if ((i & 1) != 0) {
            xVar = null;
        }
        hVar.a(xVar);
    }

    public final void a(x xVar) {
        List<String> list = this.c;
        if (list != null) {
            l.a.a(this.d, list, xVar, null, null, 12, null);
        }
    }

    public /* synthetic */ h(List list, List list2, List list3, l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, (i & 8) != 0 ? n.a() : lVar);
    }
}
