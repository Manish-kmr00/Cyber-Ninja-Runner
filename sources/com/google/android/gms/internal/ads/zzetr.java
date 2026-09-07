package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetr implements zzesu {
    final String zza;
    final int zzb;

    /* synthetic */ zzetr(String str, int i, zzetq zzetqVar) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcue zzcueVar = (zzcue) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzky)).booleanValue()) {
            String str = this.zza;
            if (!TextUtils.isEmpty(str)) {
                zzcueVar.zza.putString("topics", str);
            }
            int i = this.zzb;
            if (i != -1) {
                zzcueVar.zza.putInt("atps", i);
            }
        }
    }
}
