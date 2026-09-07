package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Tm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11369a;
    public final int b;
    public final long c;
    public final String d;
    public final Integer e;
    public final List f;

    public Tm(String str, int i, long j, String str2, Integer num, List list) {
        this.f11369a = str;
        this.b = i;
        this.c = j;
        this.d = str2;
        this.e = num;
        this.f = list == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(list);
    }
}
