package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpg implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzcpg(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3) {
        this.zza = zzhfhVar2;
        this.zzb = zzhfhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        boolean zBooleanValue = Boolean.valueOf(zzcpe.zza()).booleanValue();
        zzecf zzecfVarZzb = ((zzefn) this.zza).zzb();
        zzehm zzehmVarZzb = ((zzehn) this.zzb).zzb();
        if (true != zBooleanValue) {
            zzecfVarZzb = zzehmVarZzb;
        }
        return zzecfVarZzb;
    }
}
