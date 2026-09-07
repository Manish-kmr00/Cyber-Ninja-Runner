package com.fyber.inneractive.sdk.cache.session;

import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends PriorityQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1652a;

    public k(int i) {
        super(1, new l());
        this.f1652a = i;
    }

    @Override // java.util.PriorityQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public final boolean add(g gVar) {
        boolean zAdd = super.add(gVar);
        if (super.size() > this.f1652a) {
            poll();
        }
        return zAdd;
    }
}
