package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class PendingPost {
    private static final List<PendingPost> d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f4856a;
    Subscription b;
    PendingPost c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f4856a = obj;
        this.b = subscription;
    }

    static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new PendingPost(obj, subscription);
            }
            PendingPost pendingPostRemove = list.remove(size - 1);
            pendingPostRemove.f4856a = obj;
            pendingPostRemove.b = subscription;
            pendingPostRemove.c = null;
            return pendingPostRemove;
        }
    }

    static void a(PendingPost pendingPost) {
        pendingPost.f4856a = null;
        pendingPost.b = null;
        pendingPost.c = null;
        List<PendingPost> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
