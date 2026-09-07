package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnm implements zzgnp {
    private final zzgvs zza;
    private final zzgst zzb;

    private zzgnm(zzgst zzgstVar, zzgvs zzgvsVar) {
        this.zzb = zzgstVar;
        this.zza = zzgvsVar;
    }

    public static zzgnm zza(zzgst zzgstVar) throws GeneralSecurityException {
        return new zzgnm(zzgstVar, zzgnx.zza(zzgstVar.zzi()));
    }

    public static zzgnm zzb(zzgst zzgstVar) {
        return new zzgnm(zzgstVar, zzgnx.zzb(zzgstVar.zzi()));
    }

    public final zzgst zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgnp
    public final zzgvs zzd() {
        return this.zza;
    }
}
