package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: loaded from: classes9.dex */
final class PendingPostQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PendingPost f4857a;
    private PendingPost b;

    PendingPostQueue() {
    }

    synchronized void a(PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.b;
            if (pendingPost2 != null) {
                pendingPost2.c = pendingPost;
                this.b = pendingPost;
            } else {
                if (this.f4857a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = pendingPost;
                this.f4857a = pendingPost;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f4857a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.c;
            this.f4857a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    synchronized PendingPost a(int i) throws InterruptedException {
        if (this.f4857a == null) {
            wait(i);
        }
        return a();
    }
}
