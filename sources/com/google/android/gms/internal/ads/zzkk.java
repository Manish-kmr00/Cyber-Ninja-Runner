package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkk {
    public zzlm zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    private boolean zze;

    public zzkk(zzlm zzlmVar) {
        this.zza = zzlmVar;
    }

    public final void zza(int i) {
        this.zze = 1 == ((this.zze ? 1 : 0) | i);
        this.zzb += i;
    }

    public final void zzb(zzlm zzlmVar) {
        this.zze |= this.zza != zzlmVar;
        this.zza = zzlmVar;
    }

    public final void zzc(int i) {
        if (this.zzc && this.zzd != 5) {
            zzdc.zzd(i == 5);
            return;
        }
        this.zze = true;
        this.zzc = true;
        this.zzd = i;
    }
}
