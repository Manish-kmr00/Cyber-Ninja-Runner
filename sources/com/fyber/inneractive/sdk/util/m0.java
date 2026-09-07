package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f2368a;
    public final Uri b;
    public final List c;

    public m0(l0 l0Var, Uri uri, List list) {
        this.f2368a = l0Var;
        this.b = uri;
        this.c = list;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2368a.mPriority.compareTo(((m0) obj).f2368a.mPriority);
    }
}
