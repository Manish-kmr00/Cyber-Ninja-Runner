package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzvi {
    public final int zza;
    public final zzuy zzb;
    private final CopyOnWriteArrayList zzc;

    public zzvi() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzvi(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzuy zzuyVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuyVar;
    }

    public final zzvi zza(int i, zzuy zzuyVar) {
        return new zzvi(this.zzc, 0, zzuyVar);
    }

    public final void zzb(Handler handler, zzvj zzvjVar) {
        this.zzc.add(new zzvh(handler, zzvjVar));
    }

    public final void zzc(final zzdk zzdkVar) {
        for (zzvh zzvhVar : this.zzc) {
            final zzvj zzvjVar = zzvhVar.zzb;
            zzeu.zzP(zzvhVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzvg
                @Override // java.lang.Runnable
                public final void run() {
                    zzdkVar.zza(zzvjVar);
                }
            });
        }
    }

    public final void zzd(final zzuu zzuuVar) {
        zzc(new zzdk() { // from class: com.google.android.gms.internal.ads.zzvb
            @Override // com.google.android.gms.internal.ads.zzdk
            public final void zza(Object obj) {
                ((zzvj) obj).zzag(0, this.zza.zzb, zzuuVar);
            }
        });
    }

    public final void zze(final zzup zzupVar, final zzuu zzuuVar) {
        zzc(new zzdk() { // from class: com.google.android.gms.internal.ads.zzvf
            @Override // com.google.android.gms.internal.ads.zzdk
            public final void zza(Object obj) {
                ((zzvj) obj).zzah(0, this.zza.zzb, zzupVar, zzuuVar);
            }
        });
    }

    public final void zzf(final zzup zzupVar, final zzuu zzuuVar) {
        zzc(new zzdk() { // from class: com.google.android.gms.internal.ads.zzvd
            @Override // com.google.android.gms.internal.ads.zzdk
            public final void zza(Object obj) {
                ((zzvj) obj).zzai(0, this.zza.zzb, zzupVar, zzuuVar);
            }
        });
    }

    public final void zzg(final zzup zzupVar, final zzuu zzuuVar, final IOException iOException, final boolean z) {
        zzc(new zzdk() { // from class: com.google.android.gms.internal.ads.zzve
            @Override // com.google.android.gms.internal.ads.zzdk
            public final void zza(Object obj) {
                ((zzvj) obj).zzaj(0, this.zza.zzb, zzupVar, zzuuVar, iOException, z);
            }
        });
    }

    public final void zzh(final zzup zzupVar, final zzuu zzuuVar, final int i) {
        zzc(new zzdk() { // from class: com.google.android.gms.internal.ads.zzvc
            @Override // com.google.android.gms.internal.ads.zzdk
            public final void zza(Object obj) {
                ((zzvj) obj).zzak(0, this.zza.zzb, zzupVar, zzuuVar, i);
            }
        });
    }

    public final void zzi(zzvj zzvjVar) {
        CopyOnWriteArrayList<zzvh> copyOnWriteArrayList = this.zzc;
        for (zzvh zzvhVar : copyOnWriteArrayList) {
            if (zzvhVar.zzb == zzvjVar) {
                copyOnWriteArrayList.remove(zzvhVar);
            }
        }
    }
}
