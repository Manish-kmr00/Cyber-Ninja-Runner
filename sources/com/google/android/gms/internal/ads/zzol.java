package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import com.json.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzol implements zzmg {
    private final zzdg zza;
    private final zzbj zzb;
    private final zzbk zzc;
    private final zzok zzd;
    private final SparseArray zze;
    private zzdw zzf;
    private zzbh zzg;
    private zzdq zzh;
    private boolean zzi;

    public static /* synthetic */ void zzX(zzol zzolVar) {
        final zzmh zzmhVarZzV = zzolVar.zzV();
        zzolVar.zzaa(zzmhVarZzV, 1028, new zzdt(zzmhVarZzV) { // from class: com.google.android.gms.internal.ads.zzml
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
        zzolVar.zzf.zze();
    }

    private final zzmh zzac(int i, zzuy zzuyVar) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        if (zzuyVar != null) {
            return this.zzd.zza(zzuyVar) != null ? zzab(zzuyVar) : zzW(zzbl.zza, i, zzuyVar);
        }
        zzbl zzblVarZzo = zzbhVar.zzo();
        if (i >= zzblVarZzo.zzc()) {
            zzblVarZzo = zzbl.zza;
        }
        return zzW(zzblVarZzo, i, null);
    }

    private final zzmh zzad() {
        return zzab(this.zzd.zzd());
    }

    private final zzmh zzae() {
        return zzab(this.zzd.zze());
    }

    private final zzmh zzaf(zzba zzbaVar) {
        zzuy zzuyVar;
        return (!(zzbaVar instanceof zzii) || (zzuyVar = ((zzii) zzbaVar).zzh) == null) ? zzV() : zzab(zzuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzA(final zzhy zzhyVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1007, new zzdt(zzmhVarZzae, zzhyVar) { // from class: com.google.android.gms.internal.ads.zzmm
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzB(final zzz zzzVar, final zzhz zzhzVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1009, new zzdt() { // from class: com.google.android.gms.internal.ads.zzny
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zze(zzmhVarZzae, zzzVar, zzhzVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzC(final long j) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1010, new zzdt(zzmhVarZzae, j) { // from class: com.google.android.gms.internal.ads.zzna
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzD(final Exception exc) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1014, new zzdt(zzmhVarZzae, exc) { // from class: com.google.android.gms.internal.ads.zzog
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzE(final zzpz zzpzVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1031, new zzdt(zzmhVarZzae, zzpzVar) { // from class: com.google.android.gms.internal.ads.zznu
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzF(final zzpz zzpzVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1032, new zzdt(zzmhVarZzae, zzpzVar) { // from class: com.google.android.gms.internal.ads.zzof
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzG(final int i, final long j, final long j2) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1011, new zzdt(zzmhVarZzae, i, j, j2) { // from class: com.google.android.gms.internal.ads.zzmw
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzH(final int i, final long j) {
        final zzmh zzmhVarZzad = zzad();
        zzaa(zzmhVarZzad, 1018, new zzdt() { // from class: com.google.android.gms.internal.ads.zzng
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzh(zzmhVarZzad, i, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzI(final Object obj, final long j) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 26, new zzdt() { // from class: com.google.android.gms.internal.ads.zzoc
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj2) {
                ((zzmj) obj2).zzn(zzmhVarZzae, obj, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzJ(final int i, final int i2, final boolean z) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, new zzdt(zzmhVarZzae, i, i2, z) { // from class: com.google.android.gms.internal.ads.zznj
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzK(final Exception exc) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1030, new zzdt(zzmhVarZzae, exc) { // from class: com.google.android.gms.internal.ads.zzmv
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzL(final String str, final long j, final long j2) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1016, new zzdt(zzmhVarZzae, str, j2, j) { // from class: com.google.android.gms.internal.ads.zzoe
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzM(final String str) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1019, new zzdt(zzmhVarZzae, str) { // from class: com.google.android.gms.internal.ads.zznf
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzN(final zzhy zzhyVar) {
        final zzmh zzmhVarZzad = zzad();
        zzaa(zzmhVarZzad, 1020, new zzdt() { // from class: com.google.android.gms.internal.ads.zzns
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzo(zzmhVarZzad, zzhyVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzO(final zzhy zzhyVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1015, new zzdt(zzmhVarZzae, zzhyVar) { // from class: com.google.android.gms.internal.ads.zzoa
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzP(final long j, final int i) {
        final zzmh zzmhVarZzad = zzad();
        zzaa(zzmhVarZzad, 1021, new zzdt(zzmhVarZzad, j, i) { // from class: com.google.android.gms.internal.ads.zznm
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzQ(final zzz zzzVar, final zzhz zzhzVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1017, new zzdt() { // from class: com.google.android.gms.internal.ads.zznt
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzp(zzmhVarZzae, zzzVar, zzhzVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzR() {
        zzdq zzdqVar = this.zzh;
        zzdc.zzb(zzdqVar);
        zzdqVar.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzob
            @Override // java.lang.Runnable
            public final void run() {
                zzol.zzX(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzS(zzmj zzmjVar) {
        this.zzf.zzf(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzT(final zzbh zzbhVar, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzdc.zzf(z);
        zzbhVar.getClass();
        this.zzg = zzbhVar;
        this.zzh = this.zza.zzd(looper, null);
        this.zzf = this.zzf.zza(looper, new zzdu() { // from class: com.google.android.gms.internal.ads.zzmy
            @Override // com.google.android.gms.internal.ads.zzdu
            public final void zza(Object obj, zzv zzvVar) {
                zzmj zzmjVar = (zzmj) obj;
                zzmjVar.zzi(zzbhVar, new zzmi(zzvVar, this.zza.zze));
            }
        });
    }

    protected final zzmh zzV() {
        return zzab(this.zzd.zzb());
    }

    @RequiresNonNull({"player"})
    protected final zzmh zzW(zzbl zzblVar, int i, zzuy zzuyVar) {
        zzuy zzuyVar2 = true == zzblVar.zzo() ? null : zzuyVar;
        long jZzb = this.zza.zzb();
        boolean z = zzblVar.equals(this.zzg.zzo()) && i == this.zzg.zze();
        long jZzv = 0;
        if (zzuyVar2 == null || !zzuyVar2.zzb()) {
            if (z) {
                jZzv = this.zzg.zzk();
            } else if (!zzblVar.zzo()) {
                long j = zzblVar.zze(i, this.zzc, 0L).zzl;
                jZzv = zzeu.zzv(0L);
            }
        } else if (z && this.zzg.zzc() == zzuyVar2.zzb && this.zzg.zzd() == zzuyVar2.zzc) {
            jZzv = this.zzg.zzl();
        }
        return new zzmh(jZzb, zzblVar, i, zzuyVar2, jZzv, this.zzg.zzo(), this.zzg.zze(), this.zzd.zzb(), this.zzg.zzl(), this.zzg.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzZ(final int i, final long j, final long j2) {
        final zzmh zzmhVarZzab = zzab(this.zzd.zzc());
        zzaa(zzmhVarZzab, 1006, new zzdt() { // from class: com.google.android.gms.internal.ads.zzmt
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzf(zzmhVarZzab, i, j, j2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zza(final int i) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 21, new zzdt(zzmhVarZzae, i) { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    protected final void zzaa(zzmh zzmhVar, int i, zzdt zzdtVar) {
        this.zze.put(i, zzmhVar);
        zzdw zzdwVar = this.zzf;
        zzdwVar.zzd(i, zzdtVar);
        zzdwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzag(int i, zzuy zzuyVar, final zzuu zzuuVar) {
        final zzmh zzmhVarZzac = zzac(i, zzuyVar);
        zzaa(zzmhVarZzac, 1004, new zzdt() { // from class: com.google.android.gms.internal.ads.zznl
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzg(zzmhVarZzac, zzuuVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzah(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar) {
        final zzmh zzmhVarZzac = zzac(i, zzuyVar);
        zzaa(zzmhVarZzac, 1002, new zzdt(zzmhVarZzac, zzupVar, zzuuVar) { // from class: com.google.android.gms.internal.ads.zznn
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzai(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar) {
        final zzmh zzmhVarZzac = zzac(i, zzuyVar);
        zzaa(zzmhVarZzac, 1001, new zzdt(zzmhVarZzac, zzupVar, zzuuVar) { // from class: com.google.android.gms.internal.ads.zznr
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzaj(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar, final IOException iOException, final boolean z) {
        final zzmh zzmhVarZzac = zzac(i, zzuyVar);
        zzaa(zzmhVarZzac, 1003, new zzdt() { // from class: com.google.android.gms.internal.ads.zzmx
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzj(zzmhVarZzac, zzupVar, zzuuVar, iOException, z);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzak(int i, zzuy zzuyVar, final zzup zzupVar, final zzuu zzuuVar, final int i2) {
        final zzmh zzmhVarZzac = zzac(i, zzuyVar);
        zzaa(zzmhVarZzac, 1000, new zzdt(zzmhVarZzac, zzupVar, zzuuVar, i2) { // from class: com.google.android.gms.internal.ads.zzoj
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzb(final zzbd zzbdVar) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 13, new zzdt(zzmhVarZzV, zzbdVar) { // from class: com.google.android.gms.internal.ads.zzmp
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzc(final boolean z) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 3, new zzdt(zzmhVarZzV, z) { // from class: com.google.android.gms.internal.ads.zzmn
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzd(final boolean z) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 7, new zzdt(zzmhVarZzV, z) { // from class: com.google.android.gms.internal.ads.zznb
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zze(final zzap zzapVar, final int i) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 1, new zzdt(zzmhVarZzV, zzapVar, i) { // from class: com.google.android.gms.internal.ads.zzmr
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzf(final zzat zzatVar) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 14, new zzdt(zzmhVarZzV, zzatVar) { // from class: com.google.android.gms.internal.ads.zzoh
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzg(final boolean z, final int i) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 5, new zzdt(zzmhVarZzV, z, i) { // from class: com.google.android.gms.internal.ads.zzni
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzh(final zzbb zzbbVar) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 12, new zzdt(zzmhVarZzV, zzbbVar) { // from class: com.google.android.gms.internal.ads.zzmk
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzi(final int i) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 4, new zzdt() { // from class: com.google.android.gms.internal.ads.zznq
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzk(zzmhVarZzV, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzj(final int i) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 6, new zzdt(zzmhVarZzV, i) { // from class: com.google.android.gms.internal.ads.zzne
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzk(final zzba zzbaVar) {
        final zzmh zzmhVarZzaf = zzaf(zzbaVar);
        zzaa(zzmhVarZzaf, 10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzno
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzl(zzmhVarZzaf, zzbaVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzl(final zzba zzbaVar) {
        final zzmh zzmhVarZzaf = zzaf(zzbaVar);
        zzaa(zzmhVarZzaf, 10, new zzdt(zzmhVarZzaf, zzbaVar) { // from class: com.google.android.gms.internal.ads.zznh
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzm(final boolean z, final int i) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, -1, new zzdt(zzmhVarZzV, z, i) { // from class: com.google.android.gms.internal.ads.zzmz
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzo(final boolean z) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 23, new zzdt(zzmhVarZzae, z) { // from class: com.google.android.gms.internal.ads.zzms
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzp(final int i, final int i2) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 24, new zzdt(zzmhVarZzae, i, i2) { // from class: com.google.android.gms.internal.ads.zzoi
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzr(final zzbt zzbtVar) {
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 2, new zzdt(zzmhVarZzV, zzbtVar) { // from class: com.google.android.gms.internal.ads.zznc
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzs(final zzcd zzcdVar) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 25, new zzdt() { // from class: com.google.android.gms.internal.ads.zznw
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                zzmh zzmhVar = zzmhVarZzae;
                zzcd zzcdVar2 = zzcdVar;
                ((zzmj) obj).zzq(zzmhVar, zzcdVar2);
                int i = zzcdVar2.zzb;
                int i2 = zzcdVar2.zzc;
                float f = zzcdVar2.zzd;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzt(final float f) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 22, new zzdt(zzmhVarZzae, f) { // from class: com.google.android.gms.internal.ads.zzmu
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzu(zzmj zzmjVar) {
        this.zzf.zzb(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzv() {
        if (this.zzi) {
            return;
        }
        final zzmh zzmhVarZzV = zzV();
        this.zzi = true;
        zzaa(zzmhVarZzV, -1, new zzdt(zzmhVarZzV) { // from class: com.google.android.gms.internal.ads.zznx
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzw(final Exception exc) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1029, new zzdt(zzmhVarZzae, exc) { // from class: com.google.android.gms.internal.ads.zzod
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzx(final String str, final long j, final long j2) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1008, new zzdt(zzmhVarZzae, str, j2, j) { // from class: com.google.android.gms.internal.ads.zznd
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzy(final String str) {
        final zzmh zzmhVarZzae = zzae();
        zzaa(zzmhVarZzae, 1012, new zzdt(zzmhVarZzae, str) { // from class: com.google.android.gms.internal.ads.zzmo
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzz(final zzhy zzhyVar) {
        final zzmh zzmhVarZzad = zzad();
        zzaa(zzmhVarZzad, 1013, new zzdt(zzmhVarZzad, zzhyVar) { // from class: com.google.android.gms.internal.ads.zznp
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    private final zzmh zzab(zzuy zzuyVar) {
        this.zzg.getClass();
        zzbl zzblVarZza = zzuyVar == null ? null : this.zzd.zza(zzuyVar);
        if (zzuyVar != null && zzblVarZza != null) {
            return zzW(zzblVarZza, zzblVarZza.zzn(zzuyVar.zza, this.zzb).zzc, zzuyVar);
        }
        int iZze = this.zzg.zze();
        zzbl zzblVarZzo = this.zzg.zzo();
        if (iZze >= zzblVarZzo.zzc()) {
            zzblVarZzo = zzbl.zza;
        }
        return zzW(zzblVarZzo, iZze, null);
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final void zzU(List list, zzuy zzuyVar) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        this.zzd.zzh(list, zzuyVar, zzbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzn(final zzbf zzbfVar, final zzbf zzbfVar2, final int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzok zzokVar = this.zzd;
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        zzokVar.zzg(zzbhVar);
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 11, new zzdt() { // from class: com.google.android.gms.internal.ads.zznz
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                ((zzmj) obj).zzm(zzmhVarZzV, zzbfVar, zzbfVar2, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzq(zzbl zzblVar, final int i) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        this.zzd.zzi(zzbhVar);
        final zzmh zzmhVarZzV = zzV();
        zzaa(zzmhVarZzV, 0, new zzdt(zzmhVarZzV, i) { // from class: com.google.android.gms.internal.ads.zzmq
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
            }
        });
    }

    public zzol(zzdg zzdgVar) {
        zzdgVar.getClass();
        this.zza = zzdgVar;
        this.zzf = new zzdw(zzeu.zzz(), zzdgVar, new zzdu() { // from class: com.google.android.gms.internal.ads.zznk
            @Override // com.google.android.gms.internal.ads.zzdu
            public final void zza(Object obj, zzv zzvVar) {
            }
        });
        zzbj zzbjVar = new zzbj();
        this.zzb = zzbjVar;
        this.zzc = new zzbk();
        this.zzd = new zzok(zzbjVar);
        this.zze = new SparseArray();
    }
}
