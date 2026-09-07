package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaax implements zzcb {
    private final Context zza;
    private final zzeq zzb = new zzeq(10);
    private final zzca zzc;
    private final SparseArray zzd;
    private final List zze;
    private final zzbv zzf;
    private final zzabv zzg;
    private final zzdg zzh;
    private final CopyOnWriteArraySet zzi;
    private final zzz zzj;
    private zzdq zzk;
    private int zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    /* synthetic */ zzaax(zzaar zzaarVar, zzaaw zzaawVar) {
        this.zza = zzaarVar.zza;
        zzca zzcaVar = zzaarVar.zzd;
        zzdc.zzb(zzcaVar);
        this.zzc = zzcaVar;
        this.zzd = new SparseArray();
        this.zze = zzaarVar.zze;
        this.zzf = zzaarVar.zzf;
        zzdg zzdgVar = zzaarVar.zzg;
        this.zzh = zzdgVar;
        this.zzg = new zzaae(zzaarVar.zzb, zzdgVar);
        this.zzi = new CopyOnWriteArraySet();
        this.zzj = new zzx().zzaj();
        this.zzp = -9223372036854775807L;
        this.zzq = -9223372036854775807L;
        this.zzr = -1;
        this.zzo = 0;
    }

    public static /* synthetic */ void zzg(zzaax zzaaxVar) {
        zzaaxVar.zzn--;
    }

    static /* bridge */ /* synthetic */ void zzj(final zzaax zzaaxVar, boolean z) {
        zzeq zzeqVar;
        if (zzaaxVar.zzo == 1) {
            zzaaxVar.zzn++;
            zzabv zzabvVar = zzaaxVar.zzg;
            zzabvVar.zzc(z);
            while (true) {
                zzeqVar = zzaaxVar.zzb;
                if (zzeqVar.zza() <= 1) {
                    break;
                } else {
                    zzeqVar.zzb();
                }
            }
            if (zzeqVar.zza() == 1) {
                Long l = (Long) zzeqVar.zzb();
                l.getClass();
                zzabvVar.zze(1, zzaaxVar.zzj, l.longValue(), zzaaxVar.zzl, zzfww.zzn());
            }
            zzaaxVar.zzp = -9223372036854775807L;
            zzaaxVar.zzq = -9223372036854775807L;
            zzdq zzdqVar = zzaaxVar.zzk;
            zzdc.zzb(zzdqVar);
            zzdqVar.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaap
                @Override // java.lang.Runnable
                public final void run() {
                    zzaax.zzg(this.zza);
                }
            });
        }
    }

    static /* bridge */ /* synthetic */ boolean zzs(zzaax zzaaxVar, zzz zzzVar, int i) throws zzabu {
        zzdc.zzf(zzaaxVar.zzo == 0);
        zzk zzkVarZzu = zzu(zzzVar.zzC);
        if (zzkVarZzu.zzd == 7 && zzeu.zza < 34) {
            zzi zziVarZzc = zzkVarZzu.zzc();
            zziVarZzc.zzd(6);
            zzkVarZzu = zziVarZzc.zzg();
        }
        zzk zzkVar = zzkVarZzu;
        zzdg zzdgVar = zzaaxVar.zzh;
        Looper looperMyLooper = Looper.myLooper();
        zzdc.zzb(looperMyLooper);
        zzaaxVar.zzk = zzdgVar.zzd(looperMyLooper, null);
        try {
            zzca zzcaVar = zzaaxVar.zzc;
            Context context = zzaaxVar.zza;
            zzn zznVar = zzn.zza;
            final zzdq zzdqVar = zzaaxVar.zzk;
            Objects.requireNonNull(zzdqVar);
            zzcaVar.zza(context, zzkVar, zznVar, zzaaxVar, new Executor() { // from class: com.google.android.gms.internal.ads.zzaaq
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    zzdqVar.zzi(runnable);
                }
            }, zzaaxVar.zzf, zzaaxVar.zze, 0L, false);
            throw null;
        } catch (zzbw e) {
            throw new zzabu(e, zzzVar);
        }
    }

    static /* bridge */ /* synthetic */ boolean zzt(zzaax zzaaxVar) {
        int i = zzaaxVar.zzr;
        return i != -1 && i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzk zzu(zzk zzkVar) {
        return (zzkVar == null || !zzkVar.zzf()) ? zzk.zza : zzkVar;
    }

    public final zzabv zze(int i) {
        SparseArray sparseArray = this.zzd;
        zzdc.zzf(!zzeu.zzH(sparseArray, 0));
        zzaas zzaasVar = new zzaas(this, this.zza, 0);
        this.zzi.add(zzaasVar);
        sparseArray.put(0, zzaasVar);
        return zzaasVar;
    }

    public final void zzn() {
        zzel.zza.zzb();
        zzel.zza.zza();
        this.zzm = null;
    }

    public final void zzo() {
        if (this.zzo == 2) {
            return;
        }
        zzdq zzdqVar = this.zzk;
        if (zzdqVar != null) {
            zzdqVar.zzf(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    public final void zzp(Surface surface, zzel zzelVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzel) this.zzm.second).equals(zzelVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzelVar);
        zzelVar.zzb();
        zzelVar.zza();
    }

    public final void zzq(int i) {
        this.zzr = 1;
    }
}
