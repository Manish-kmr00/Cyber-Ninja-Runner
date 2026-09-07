package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdau {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzeyi zzo;

    public final zzdau zza(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzdcu(zzaVar, executor));
        return this;
    }

    public final zzdau zzb(zzcvf zzcvfVar, Executor executor) {
        this.zzi.add(new zzdcu(zzcvfVar, executor));
        return this;
    }

    public final zzdau zzc(zzcvs zzcvsVar, Executor executor) {
        this.zzl.add(new zzdcu(zzcvsVar, executor));
        return this;
    }

    public final zzdau zzd(zzcvw zzcvwVar, Executor executor) {
        this.zzf.add(new zzdcu(zzcvwVar, executor));
        return this;
    }

    public final zzdau zze(zzcvc zzcvcVar, Executor executor) {
        this.zze.add(new zzdcu(zzcvcVar, executor));
        return this;
    }

    public final zzdau zzf(zzcwq zzcwqVar, Executor executor) {
        this.zzh.add(new zzdcu(zzcwqVar, executor));
        return this;
    }

    public final zzdau zzg(zzcxb zzcxbVar, Executor executor) {
        this.zzg.add(new zzdcu(zzcxbVar, executor));
        return this;
    }

    public final zzdau zzh(com.google.android.gms.ads.internal.overlay.zzr zzrVar, Executor executor) {
        this.zzn.add(new zzdcu(zzrVar, executor));
        return this;
    }

    public final zzdau zzi(zzcxo zzcxoVar, Executor executor) {
        this.zzm.add(new zzdcu(zzcxoVar, executor));
        return this;
    }

    public final zzdau zzj(zzcya zzcyaVar, Executor executor) {
        this.zzb.add(new zzdcu(zzcyaVar, executor));
        return this;
    }

    public final zzdau zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdcu(appEventListener, executor));
        return this;
    }

    public final zzdau zzl(zzddc zzddcVar, Executor executor) {
        this.zzd.add(new zzdcu(zzddcVar, executor));
        return this;
    }

    public final zzdau zzm(zzeyi zzeyiVar) {
        this.zzo = zzeyiVar;
        return this;
    }

    public final zzdaw zzn() {
        return new zzdaw(this, null);
    }
}
