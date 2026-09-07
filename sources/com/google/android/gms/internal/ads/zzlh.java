package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzlh implements zzvj, zzru {
    final /* synthetic */ zzll zza;
    private final zzlj zzb;

    public zzlh(zzll zzllVar, zzlj zzljVar) {
        this.zza = zzllVar;
        this.zzb = zzljVar;
    }

    private final Pair zzf(int i, zzuy zzuyVar) {
        zzuy zzuyVarZza;
        zzuy zzuyVar2 = null;
        if (zzuyVar != null) {
            zzlj zzljVar = this.zzb;
            int i2 = 0;
            while (true) {
                List list = zzljVar.zzc;
                if (i2 >= list.size()) {
                    zzuyVarZza = null;
                    break;
                }
                if (((zzuy) list.get(i2)).zzd == zzuyVar.zzd) {
                    Object obj = zzuyVar.zza;
                    Object obj2 = zzljVar.zzb;
                    int i3 = zzls.zzb;
                    zzuyVarZza = zzuyVar.zza(Pair.create(obj2, obj));
                    break;
                }
                i2++;
            }
            if (zzuyVarZza == null) {
                return null;
            }
            zzuyVar2 = zzuyVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzuyVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzag(int i, zzuy zzuyVar, final zzuu zzuuVar) {
        final Pair pairZzf = zzf(0, zzuyVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlf
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzuy) pair.second, zzuuVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzah(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar) {
        final Pair pairZzf = zzf(0, zzuyVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzle
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzuy) pair.second, zzupVar, zzuuVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzai(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar) {
        final Pair pairZzf = zzf(0, zzuyVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlg
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzuy) pair.second, zzupVar, zzuuVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzaj(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzuyVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzld
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaj(((Integer) pair.first).intValue(), (zzuy) pair.second, zzupVar, zzuuVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzak(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar, final int i2) {
        final Pair pairZzf = zzf(0, zzuyVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlc
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzak(((Integer) pair.first).intValue(), (zzuy) pair.second, zzupVar, zzuuVar, i2);
                }
            });
        }
    }
}
