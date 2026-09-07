package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeft {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;
    final Integer zze;

    zzeft(String str, String str2, int i, long j, Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = j;
        this.zze = num;
    }

    public final String toString() {
        Integer num;
        String str = this.zza + "." + this.zzc + "." + this.zzd;
        String str2 = this.zzb;
        if (!TextUtils.isEmpty(str2)) {
            str = str + "." + str2;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbO)).booleanValue() || (num = this.zze) == null || TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "." + num;
    }
}
