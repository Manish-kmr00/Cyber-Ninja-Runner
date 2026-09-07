package com.yandex.mobile.ads.impl;

import android.os.Looper;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes13.dex */
public final class bz implements ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hp f8548a;
    private final b52.b b;
    private final b52.d c;
    private final a d;
    private final SparseArray<ld.a> e;
    private wr0<ld> f;
    private di1 g;
    private ef0 h;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld ldVar, yb0 yb0Var) {
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onRenderedFirstFrame() {
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(jw0 jw0Var) {
        this.f.a(jw0Var);
    }

    public bz(hp hpVar) {
        this.f8548a = (hp) hg.a(hpVar);
        this.f = new wr0<>(x82.c(), hpVar, new wr0.b() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda25
            @Override // com.yandex.mobile.ads.impl.wr0.b
            public final void a(Object obj, yb0 yb0Var) {
                bz.a((ld) obj, yb0Var);
            }
        });
        b52.b bVar = new b52.b();
        this.b = bVar;
        this.c = new b52.d();
        this.d = new a(bVar);
        this.e = new SparseArray<>();
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void release() {
        ef0 ef0Var = this.h;
        if (ef0Var != null) {
            ef0Var.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onVolumeChanged(final float f) {
        final ld.a aVarB = b();
        a(aVarB, 22, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                float f2 = f;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final ld.a aVarB = b();
        a(aVarB, 24, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda18
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                int i3 = i;
                int i4 = i2;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onIsLoadingChanged(final boolean z) {
        final ld.a aVarA = a();
        a(aVarA, 3, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda8
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                boolean z2 = z;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onPlayerStateChanged(final boolean z, final int i) {
        final ld.a aVarA = a();
        a(aVarA, -1, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda56
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                boolean z2 = z;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onPlaybackStateChanged(final int i) {
        final ld.a aVarA = a();
        a(aVarA, 4, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final ld.a aVarA = a();
        a(aVarA, 5, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda15
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                boolean z2 = z;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final ld.a aVarA = a();
        a(aVarA, 6, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda32
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onIsPlayingChanged(final boolean z) {
        final ld.a aVarA = a();
        a(aVarA, 7, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda33
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                boolean z2 = z;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onCues(final List<ev> list) {
        final ld.a aVarA = a();
        a(aVarA, 27, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda29
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                List list2 = list;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final ld.a aVarB = b();
        a(aVarB, 23, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda36
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                boolean z2 = z;
                ((ld) obj).getClass();
            }
        });
    }

    protected final ld.a a() {
        return a(this.d.d);
    }

    private ld.a b() {
        return a(this.d.f);
    }

    private ld.a e(int i, rw0.b bVar) {
        this.g.getClass();
        if (bVar != null) {
            if (((b52) this.d.c.get(bVar)) != null) {
                return a(bVar);
            }
            return a(b52.b, i, bVar);
        }
        b52 currentTimeline = this.g.getCurrentTimeline();
        if (i >= currentTimeline.b()) {
            currentTimeline = b52.b;
        }
        return a(currentTimeline, i, (rw0.b) null);
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b52.b f8549a;
        private hk0<rw0.b> b = hk0.h();
        private ik0<rw0.b, b52> c = ik0.g();
        private rw0.b d;
        private rw0.b e;
        private rw0.b f;

        public a(b52.b bVar) {
            this.f8549a = bVar;
        }

        private void a(ik0.a<rw0.b, b52> aVar, rw0.b bVar, b52 b52Var) {
            if (bVar == null) {
                return;
            }
            if (b52Var.a(bVar.f9759a) != -1) {
                aVar.a(bVar, b52Var);
                return;
            }
            b52 b52Var2 = this.c.get(bVar);
            if (b52Var2 != null) {
                aVar.a(bVar, b52Var2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static rw0.b a(di1 di1Var, hk0<rw0.b> hk0Var, rw0.b bVar, b52.b bVar2) {
            b52 currentTimeline = di1Var.getCurrentTimeline();
            int currentPeriodIndex = di1Var.getCurrentPeriodIndex();
            Object objA = currentTimeline.c() ? null : currentTimeline.a(currentPeriodIndex);
            int iA = (di1Var.isPlayingAd() || currentTimeline.c()) ? -1 : currentTimeline.a(currentPeriodIndex, bVar2).a(x82.a(di1Var.getCurrentPosition()) - bVar2.c());
            for (int i = 0; i < hk0Var.size(); i++) {
                rw0.b bVar3 = hk0Var.get(i);
                if (a(bVar3, objA, di1Var.isPlayingAd(), di1Var.getCurrentAdGroupIndex(), di1Var.getCurrentAdIndexInAdGroup(), iA)) {
                    return bVar3;
                }
            }
            if (hk0Var.isEmpty() && bVar != null) {
                if (a(bVar, objA, di1Var.isPlayingAd(), di1Var.getCurrentAdGroupIndex(), di1Var.getCurrentAdIndexInAdGroup(), iA)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean a(rw0.b bVar, Object obj, boolean z, int i, int i2, int i3) {
            if (bVar.f9759a.equals(obj)) {
                return (z && bVar.b == i && bVar.c == i2) || (!z && bVar.b == -1 && bVar.e == i3);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b52 b52Var) {
            ik0.a<rw0.b, b52> aVarA = ik0.a();
            if (this.b.isEmpty()) {
                a(aVarA, this.e, b52Var);
                if (!vd1.a(this.f, this.e)) {
                    a(aVarA, this.f, b52Var);
                }
                if (!vd1.a(this.d, this.e) && !vd1.a(this.d, this.f)) {
                    a(aVarA, this.d, b52Var);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    a(aVarA, this.b.get(i), b52Var);
                }
                if (!this.b.contains(this.d)) {
                    a(aVarA, this.d, b52Var);
                }
            }
            this.c = aVarA.a();
        }
    }

    private ld.a a(rw0.b bVar) {
        this.g.getClass();
        b52 b52Var = bVar == null ? null : (b52) this.d.c.get(bVar);
        if (bVar != null && b52Var != null) {
            return a(b52Var, b52Var.a(bVar.f9759a, this.b).d, bVar);
        }
        int currentMediaItemIndex = this.g.getCurrentMediaItemIndex();
        b52 currentTimeline = this.g.getCurrentTimeline();
        if (currentMediaItemIndex >= currentTimeline.b()) {
            currentTimeline = b52.b;
        }
        return a(currentTimeline, currentMediaItemIndex, (rw0.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ld.a aVar, int i, long j, long j2, ld ldVar) {
        ((jw0) ldVar).a(aVar, i, j);
    }

    @RequiresNonNull({"player"})
    protected final ld.a a(b52 b52Var, int i, rw0.b bVar) {
        rw0.b bVar2 = b52Var.c() ? null : bVar;
        long jB = this.f8548a.b();
        boolean z = b52Var.equals(this.g.getCurrentTimeline()) && i == this.g.getCurrentMediaItemIndex();
        long jB2 = 0;
        if (bVar2 == null || !bVar2.a()) {
            if (z) {
                jB2 = this.g.getContentPosition();
            } else if (!b52Var.c()) {
                jB2 = x82.b(b52Var.a(i, this.c, 0L).n);
            }
        } else if (z && this.g.getCurrentAdGroupIndex() == bVar2.b && this.g.getCurrentAdIndexInAdGroup() == bVar2.c) {
            jB2 = this.g.getCurrentPosition();
        }
        return new ld.a(jB, b52Var, i, bVar2, jB2, this.g.getCurrentTimeline(), this.g.getCurrentMediaItemIndex(), this.d.d, this.g.getCurrentPosition(), this.g.getTotalBufferedDuration());
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void d(int i, rw0.b bVar) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1026, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda26
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void d(final my myVar) {
        final ld.a aVarB = b();
        a(aVarB, 1015, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda11
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                my myVar2 = myVar;
                ((ld) obj).getClass();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ld.a aVar, my myVar, ld ldVar) {
        ((jw0) ldVar).a(myVar);
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void c(int i, rw0.b bVar) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1023, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda31
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.sw0
    public final void c(int i, rw0.b bVar, final as0 as0Var, final hw0 hw0Var) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1000, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda24
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                as0 as0Var2 = as0Var;
                hw0 hw0Var2 = hw0Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void c(final Exception exc) {
        final ld.a aVarB = b();
        a(aVarB, 1030, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda39
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                Exception exc2 = exc;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void c(final my myVar) {
        final ld.a aVarA = a(this.d.e);
        a(aVarA, 1020, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda5
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.c(aVarA, myVar, (ld) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final ld.a aVarA = a();
        a(aVarA, 1028, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda45
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                ((ld) obj).getClass();
            }
        });
        this.f.b();
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final Exception exc) {
        final ld.a aVarB = b();
        a(aVarB, 1029, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda40
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                Exception exc2 = exc;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final String str, final long j, final long j2) {
        final ld.a aVarB = b();
        a(aVarB, 1008, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda38
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                String str2 = str;
                long j3 = j2;
                long j4 = j;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final String str) {
        final ld.a aVarB = b();
        a(aVarB, 1012, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda47
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                String str2 = str;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final my myVar) {
        final ld.a aVarB = b();
        a(aVarB, 1007, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda7
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                my myVar2 = myVar;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.vi.a
    public final void b(final int i, final long j, final long j2) {
        Object next;
        Object obj;
        rw0.b bVar;
        a aVar = this.d;
        if (aVar.b.isEmpty()) {
            bVar = null;
        } else {
            hk0 hk0Var = aVar.b;
            if (hk0Var instanceof List) {
                if (!hk0Var.isEmpty()) {
                    obj = hk0Var.get(hk0Var.size() - 1);
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                Iterator<E> it = hk0Var.iterator();
                do {
                    next = it.next();
                } while (it.hasNext());
                obj = next;
            }
            bVar = (rw0.b) obj;
        }
        final ld.a aVarA = a(bVar);
        a(aVarA, 1006, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda37
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj2) {
                bz.b(aVarA, i, j, j2, (ld) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld.a aVar, hw0 hw0Var, ld ldVar) {
        ((jw0) ldVar).a(aVar, hw0Var);
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void b(int i, rw0.b bVar) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1027, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda9
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final int i, final long j) {
        final ld.a aVarA = a(this.d.e);
        a(aVarA, 1018, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda48
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                int i2 = i;
                long j2 = j;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.sw0
    public final void b(int i, rw0.b bVar, final as0 as0Var, final hw0 hw0Var) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1001, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda43
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                as0 as0Var2 = as0Var;
                hw0 hw0Var2 = hw0Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void b(final j60 j60Var) {
        final ld.a aVarA;
        nw0 nw0Var;
        if ((j60Var instanceof j60) && (nw0Var = j60Var.i) != null) {
            aVarA = a(new rw0.b(nw0Var));
        } else {
            aVarA = a();
        }
        a(aVarA, 10, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda4
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.a(aVarA, j60Var, (ld) obj);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void b(final gc0 gc0Var, final qy qyVar) {
        final ld.a aVarB = b();
        a(aVarB, 1017, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda28
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                gc0 gc0Var2 = gc0Var;
                qy qyVar2 = qyVar;
                ((ld) obj).getClass();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld.a aVar, as0 as0Var, hw0 hw0Var, IOException iOException, boolean z, ld ldVar) {
        ((jw0) ldVar).a(hw0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld.a aVar, uh1 uh1Var, ld ldVar) {
        ((jw0) ldVar).a(uh1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld.a aVar, int i, di1.c cVar, di1.c cVar2, ld ldVar) {
        ldVar.getClass();
        ((jw0) ldVar).a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ld.a aVar, uf2 uf2Var, ld ldVar) {
        ((jw0) ldVar).a(uf2Var);
        int i = uf2Var.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(di1 di1Var, ld ldVar, yb0 yb0Var) {
        ((jw0) ldVar).a(di1Var, new ld.b(yb0Var, this.e));
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final my myVar) {
        final ld.a aVarA = a(this.d.e);
        a(aVarA, 1013, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda19
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                my myVar2 = myVar;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final gc0 gc0Var, final qy qyVar) {
        final ld.a aVarB = b();
        a(aVarB, 1009, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda20
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                gc0 gc0Var2 = gc0Var;
                qy qyVar2 = qyVar;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final long j) {
        final ld.a aVarB = b();
        a(aVarB, 1010, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda3
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                long j2 = j;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final Exception exc) {
        final ld.a aVarB = b();
        a(aVarB, 1014, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda10
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                Exception exc2 = exc;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final int i, final long j, final long j2) {
        final ld.a aVarB = b();
        a(aVarB, 1011, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda50
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                int i2 = i;
                long j3 = j;
                long j4 = j2;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final di1.a aVar) {
        final ld.a aVarA = a();
        a(aVarA, 13, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda16
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar2 = aVarA;
                di1.a aVar3 = aVar;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final gv gvVar) {
        final ld.a aVarA = a();
        a(aVarA, 27, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda23
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                gv gvVar2 = gvVar;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final f10 f10Var) {
        final ld.a aVarA = a();
        a(aVarA, 29, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda52
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                f10 f10Var2 = f10Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final boolean z, final int i) {
        final ld.a aVarA = a();
        a(aVarA, 30, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda55
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                int i2 = i;
                boolean z2 = z;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.sw0
    public final void a(int i, rw0.b bVar, final hw0 hw0Var) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1004, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda30
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.a(aVarE, hw0Var, (ld) obj);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void a(int i, rw0.b bVar) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1025, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda17
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void a(int i, rw0.b bVar, final int i2) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1022, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda14
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                int i3 = i2;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.e40
    public final void a(int i, rw0.b bVar, final Exception exc) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1024, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda12
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                Exception exc2 = exc;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.sw0
    public final void a(int i, rw0.b bVar, final as0 as0Var, final hw0 hw0Var) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1002, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda49
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarE;
                as0 as0Var2 = as0Var;
                hw0 hw0Var2 = hw0Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.sw0
    public final void a(int i, rw0.b bVar, final as0 as0Var, final hw0 hw0Var, final IOException iOException, final boolean z) {
        final ld.a aVarE = e(i, bVar);
        a(aVarE, 1003, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda44
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.a(aVarE, as0Var, hw0Var, iOException, z, (ld) obj);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final fw0 fw0Var, final int i) {
        final ld.a aVarA = a();
        a(aVarA, 1, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda54
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                fw0 fw0Var2 = fw0Var;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final iw0 iw0Var) {
        final ld.a aVarA = a();
        a(aVarA, 14, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda27
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                iw0 iw0Var2 = iw0Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final g01 g01Var) {
        final ld.a aVarA = a();
        a(aVarA, 28, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda22
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                g01 g01Var2 = g01Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final xh1 xh1Var) {
        final ld.a aVarA = a();
        a(aVarA, 12, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda51
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                xh1 xh1Var2 = xh1Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final j60 j60Var) {
        final ld.a aVarA;
        nw0 nw0Var;
        if ((j60Var instanceof j60) && (nw0Var = j60Var.i) != null) {
            aVarA = a(new rw0.b(nw0Var));
        } else {
            aVarA = a();
        }
        a(aVarA, 10, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda2
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                uh1 uh1Var = j60Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final di1.c cVar, final di1.c cVar2, final int i) {
        a aVar = this.d;
        di1 di1Var = this.g;
        di1Var.getClass();
        aVar.d = a.a(di1Var, aVar.b, aVar.e, aVar.f8549a);
        final ld.a aVarA = a();
        a(aVarA, 11, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda35
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.a(aVarA, i, cVar, cVar2, (ld) obj);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final Object obj, final long j) {
        final ld.a aVarB = b();
        a(aVarB, 26, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda34
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj2) {
                ld.a aVar = aVarB;
                Object obj3 = obj;
                long j2 = j;
                ((ld) obj2).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final int i) {
        a aVar = this.d;
        di1 di1Var = this.g;
        di1Var.getClass();
        aVar.d = a.a(di1Var, aVar.b, aVar.e, aVar.f8549a);
        aVar.a(di1Var.getCurrentTimeline());
        final ld.a aVarA = a();
        a(aVarA, 0, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda21
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar2 = aVarA;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final u62 u62Var) {
        final ld.a aVarA = a();
        a(aVarA, 2, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda13
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                u62 u62Var2 = u62Var;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final String str, final long j, final long j2) {
        final ld.a aVarB = b();
        a(aVarB, 1016, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda53
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                String str2 = str;
                long j3 = j2;
                long j4 = j;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final String str) {
        final ld.a aVarB = b();
        a(aVarB, 1019, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda46
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarB;
                String str2 = str;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final int i, final long j) {
        final ld.a aVarA = a(this.d.e);
        a(aVarA, 1021, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda57
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ld.a aVar = aVarA;
                long j2 = j;
                int i2 = i;
                ((ld) obj).getClass();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(final uf2 uf2Var) {
        final ld.a aVarB = b();
        a(aVarB, 25, new wr0.a() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda42
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                bz.a(aVarB, uf2Var, (ld) obj);
            }
        });
    }

    protected final void a(ld.a aVar, int i, wr0.a<ld> aVar2) {
        this.e.put(i, aVar);
        wr0<ld> wr0Var = this.f;
        wr0Var.a(i, aVar2);
        wr0Var.a();
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(final di1 di1Var, Looper looper) {
        if (this.g != null && !this.d.b.isEmpty()) {
            throw new IllegalStateException();
        }
        this.g = di1Var;
        this.h = this.f8548a.a(looper, null);
        this.f = this.f.a(looper, new wr0.b() { // from class: com.yandex.mobile.ads.impl.bz$$ExternalSyntheticLambda6
            @Override // com.yandex.mobile.ads.impl.wr0.b
            public final void a(Object obj, yb0 yb0Var) {
                this.f$0.a(di1Var, (ld) obj, yb0Var);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ed
    public final void a(List<rw0.b> list, rw0.b bVar) {
        a aVar = this.d;
        di1 di1Var = this.g;
        di1Var.getClass();
        aVar.getClass();
        aVar.b = hk0.a((Collection) list);
        if (!list.isEmpty()) {
            aVar.e = list.get(0);
            bVar.getClass();
            aVar.f = bVar;
        }
        if (aVar.d == null) {
            aVar.d = a.a(di1Var, aVar.b, aVar.e, aVar.f8549a);
        }
        aVar.a(di1Var.getCurrentTimeline());
    }
}
