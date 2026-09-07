package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzepb implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzepb(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxbVarZzn;
        zzepz zzepzVarZzb = ((zzeqb) this.zza).zzb();
        Context contextZza = ((zzcgs) this.zzb).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlw)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzq();
            if (com.google.android.gms.ads.internal.util.zzs.zzC(contextZza)) {
                zzfxbVarZzn = zzfxb.zzo(zzepzVarZzb);
            } else {
                zzfxbVarZzn = zzfxb.zzn();
            }
        } else {
            zzfxbVarZzn = zzfxb.zzn();
        }
        zzhfg.zzb(zzfxbVarZzn);
        return zzfxbVarZzn;
    }
}
