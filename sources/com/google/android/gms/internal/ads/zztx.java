package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zztx implements zzva {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzvi zzc = new zzvi();
    private final zzrt zzd = new zzrt();
    private Looper zze;
    private zzbl zzf;
    private zzoz zzg;

    @Override // com.google.android.gms.internal.ads.zzva
    public /* synthetic */ zzbl zzM() {
        return null;
    }

    protected final zzoz zzb() {
        zzoz zzozVar = this.zzg;
        zzdc.zzb(zzozVar);
        return zzozVar;
    }

    protected final zzrt zzc(zzuy zzuyVar) {
        return this.zzd.zza(0, zzuyVar);
    }

    protected final zzrt zzd(int i, zzuy zzuyVar) {
        return this.zzd.zza(0, zzuyVar);
    }

    protected final zzvi zze(zzuy zzuyVar) {
        return this.zzc.zza(0, zzuyVar);
    }

    protected final zzvi zzf(int i, zzuy zzuyVar) {
        return this.zzc.zza(0, zzuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzg(Handler handler, zzru zzruVar) {
        this.zzd.zzb(handler, zzruVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzh(Handler handler, zzvj zzvjVar) {
        this.zzc.zzb(handler, zzvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzi(zzuz zzuzVar) {
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(zzuzVar);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        zzj();
    }

    protected void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzk(zzuz zzuzVar) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zzuzVar);
        if (zIsEmpty) {
            zzl();
        }
    }

    protected void zzl() {
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzm(zzuz zzuzVar, zzhe zzheVar, zzoz zzozVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        zzdc.zzd(z);
        this.zzg = zzozVar;
        zzbl zzblVar = this.zzf;
        this.zza.add(zzuzVar);
        if (this.zze == null) {
            this.zze = looperMyLooper;
            this.zzb.add(zzuzVar);
            zzn(zzheVar);
        } else if (zzblVar != null) {
            zzk(zzuzVar);
            zzuzVar.zza(this, zzblVar);
        }
    }

    protected abstract void zzn(zzhe zzheVar);

    protected final void zzo(zzbl zzblVar) {
        this.zzf = zzblVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzuz) arrayList.get(i)).zza(this, zzblVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzp(zzuz zzuzVar) {
        ArrayList arrayList = this.zza;
        arrayList.remove(zzuzVar);
        if (!arrayList.isEmpty()) {
            zzi(zzuzVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzq();
    }

    protected abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzr(zzru zzruVar) {
        this.zzd.zzc(zzruVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzs(zzvj zzvjVar) {
        this.zzc.zzi(zzvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public /* synthetic */ void zzt(zzap zzapVar) {
        throw null;
    }

    protected final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public /* synthetic */ boolean zzv() {
        return true;
    }
}
