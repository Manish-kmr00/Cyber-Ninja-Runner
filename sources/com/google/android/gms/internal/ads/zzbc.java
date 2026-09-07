package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbc {
    private final zzt zza = new zzt();

    public final zzbc zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzbc zzb(zzbd zzbdVar) {
        zzv zzvVar = zzbdVar.zza;
        for (int i = 0; i < zzvVar.zzb(); i++) {
            this.zza.zza(zzvVar.zza(i));
        }
        return this;
    }

    public final zzbc zzc(int... iArr) {
        for (int i = 0; i < 20; i++) {
            this.zza.zza(iArr[i]);
        }
        return this;
    }

    public final zzbc zzd(int i, boolean z) {
        if (z) {
            this.zza.zza(i);
        }
        return this;
    }

    public final zzbd zze() {
        return new zzbd(this.zza.zzb(), null);
    }
}
