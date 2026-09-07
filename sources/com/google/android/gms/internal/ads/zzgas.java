package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgas extends zzgax {
    private static final zzgcb zzb = new zzgcb(zzgas.class);
    private zzfwr zzc;
    private final boolean zzd;
    private final boolean zzi;

    zzgas(zzfwr zzfwrVar, boolean z, boolean z2) {
        super(zzfwrVar.size());
        zzfwrVar.getClass();
        this.zzc = zzfwrVar;
        this.zzd = z;
        this.zzi = z2;
    }

    private final void zzQ(int i, Future future) {
        try {
            zzF(i, zzgcv.zza(future));
        } catch (ExecutionException e) {
            zzS(e.getCause());
        } catch (Throwable th) {
            zzS(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzR(zzfwr zzfwrVar) {
        int iZzK = zzK();
        int i = 0;
        zzftw.zzm(iZzK >= 0, "Less than 0 remaining futures");
        if (iZzK == 0) {
            if (zzfwrVar != null) {
                zzfzc it = zzfwrVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzQ(i, future);
                    }
                    i++;
                }
            }
            zzP();
            zzG();
            zzI(2);
        }
    }

    private static void zzT(Throwable th) {
        zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", CreativeInfo.f, true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU(int i, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzc = null;
                cancel(false);
            } else {
                zzQ(i, listenableFuture);
            }
        } finally {
            zzR(null);
        }
    }

    private static boolean zzV(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    abstract void zzF(int i, Object obj);

    abstract void zzG();

    final void zzH() {
        Objects.requireNonNull(this.zzc);
        if (this.zzc.isEmpty()) {
            zzG();
            return;
        }
        if (this.zzd) {
            zzfzc it = this.zzc.iterator();
            final int i = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i2 = i + 1;
                if (listenableFuture.isDone()) {
                    zzU(i, listenableFuture);
                } else {
                    listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgaq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzU(i, listenableFuture);
                        }
                    }, zzgbg.INSTANCE);
                }
                i = i2;
            }
            return;
        }
        zzfwr zzfwrVar = this.zzc;
        final zzfwr zzfwrVar2 = true != this.zzi ? null : zzfwrVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgar
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzR(zzfwrVar2);
            }
        };
        zzfzc it2 = zzfwrVar.iterator();
        while (it2.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture) it2.next();
            if (listenableFuture2.isDone()) {
                zzR(zzfwrVar2);
            } else {
                listenableFuture2.addListener(runnable, zzgbg.INSTANCE);
            }
        }
    }

    void zzI(int i) {
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgag
    protected final String zza() {
        zzfwr zzfwrVar = this.zzc;
        return zzfwrVar != null ? "futures=".concat(zzfwrVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgag
    protected final void zzb() {
        zzfwr zzfwrVar = this.zzc;
        zzI(1);
        if ((zzfwrVar != null) && isCancelled()) {
            boolean zZzo = zzo();
            zzfzc it = zzfwrVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzo);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    final void zzE(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        zzV(set, (Throwable) Objects.requireNonNull(zzi()));
    }

    private final void zzS(Throwable th) {
        th.getClass();
        if (this.zzd && !zzd(th) && zzV(zzM(), th)) {
            zzT(th);
        } else if (th instanceof Error) {
            zzT(th);
        }
    }
}
