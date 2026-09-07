package com.five_corp.ad.internal.movie.partialcache;

import android.animation.TimeAnimator;
import com.five_corp.ad.internal.movie.RunnableC2990l;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C3002f implements TimeAnimator.TimeListener {
    public final com.five_corp.ad.internal.movie.x f;
    public boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TimeAnimator f1478a = null;
    public long d = 0;
    public long e = 0;
    public boolean b = true;

    public C3002f(com.five_corp.ad.internal.movie.x xVar) {
        this.f = xVar;
    }

    public final void a(long j) {
        this.d = j;
        this.e = 0L;
        this.b = true;
        TimeAnimator timeAnimator = new TimeAnimator();
        this.f1478a = timeAnimator;
        timeAnimator.setTimeListener(this);
        this.f1478a.start();
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public final void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        if (this.c) {
            return;
        }
        if (this.b) {
            this.b = false;
            com.five_corp.ad.internal.movie.x xVar = this.f;
            long j3 = this.d;
            xVar.getClass();
            xVar.n.post(new RunnableC2990l(xVar, new com.five_corp.ad.internal.movie.u(xVar, j3)));
            return;
        }
        long j4 = (j2 * 1000) + this.e;
        this.e = j4;
        com.five_corp.ad.internal.movie.x xVar2 = this.f;
        long j5 = this.d + j4;
        xVar2.getClass();
        xVar2.n.post(new RunnableC2990l(xVar2, new com.five_corp.ad.internal.movie.u(xVar2, j5)));
    }

    public final void a() {
        TimeAnimator timeAnimator = this.f1478a;
        if (timeAnimator == null) {
            return;
        }
        timeAnimator.end();
        this.f1478a = null;
    }
}
