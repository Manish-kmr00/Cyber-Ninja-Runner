package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeih {
    private final zzdfe zza;

    public zzeih(zzdfe zzdfeVar) {
        this.zza = zzdfeVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, View view, zzeid zzeidVar) {
        zzeif zzeifVar = new zzeif(this, new zzeie(this, zzfauVar));
        zzdeb zzdebVarZzd = this.zza.zzd(new zzcqw(zzfbgVar, zzfauVar, null), zzeifVar);
        zzeidVar.zzd(new zzeig(this, zzdebVarZzd));
        return zzdebVarZzd.zzg();
    }
}
