package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4012b9 extends AbstractC4037c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11476a;

    public C4012b9(List<Object> list) {
        this.f11476a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f11476a;
    }
}
