package com.fyber.inneractive.sdk.config;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes13.dex */
public final class S implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f1680a = new LinkedList();
    public boolean b = true;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f1680a.iterator();
    }
}
