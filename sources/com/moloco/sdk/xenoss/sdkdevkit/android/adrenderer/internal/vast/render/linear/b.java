package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f7086a;
    public List<String> b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l c;

    public b(List<String> list, List<String> list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l vastTracker) {
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.f7086a = list;
        this.b = list2;
        this.c = vastTracker;
    }

    public static /* synthetic */ void a(b bVar, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        bVar.a(num, str);
    }

    public static /* synthetic */ void b(b bVar, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        bVar.b(num, str);
    }

    public final void a(Integer num, String str) {
        List<String> list = this.f7086a;
        if (list != null) {
            this.c.a(list, null, num, str);
            this.f7086a = null;
        }
    }

    public final void b(Integer num, String str) {
        List<String> list = this.b;
        if (list != null) {
            this.c.a(list, null, num, str);
            this.b = null;
        }
    }

    public /* synthetic */ b(List list, List list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? n.a() : lVar);
    }
}
