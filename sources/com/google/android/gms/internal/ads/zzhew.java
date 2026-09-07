package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzhew implements zzhey {
    private zzhfh zza;

    public static void zza(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        zzhew zzhewVar = (zzhew) zzhfhVar;
        if (zzhewVar.zza != null) {
            throw new IllegalStateException();
        }
        zzhewVar.zza = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final Object zzb() {
        zzhfh zzhfhVar = this.zza;
        if (zzhfhVar != null) {
            return zzhfhVar.zzb();
        }
        throw new IllegalStateException();
    }
}
