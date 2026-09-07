package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzevb {
    private final zzbuy zza;
    private final int zzb;

    public zzevb(zzbuy zzbuyVar, int i) {
        this.zza = zzbuyVar;
        this.zzb = i;
    }

    public final int zza() {
        return this.zzb;
    }

    final int zzb() {
        Bundle bundle = this.zza.zza.getBundle("extras");
        if (bundle == null || bundle.isEmpty()) {
            return -1;
        }
        switch (bundle.getString("query_info_type", "")) {
            case "requester_type_0":
                return 0;
            case "requester_type_1":
                return 1;
            case "requester_type_2":
                return 2;
            case "requester_type_3":
                return 3;
            case "requester_type_4":
                return 4;
            case "requester_type_5":
                return 5;
            case "requester_type_6":
                return 6;
            case "requester_type_7":
                return 7;
            case "requester_type_8":
                return 8;
            default:
                return -1;
        }
    }

    final int zzc() {
        return this.zza.zzo;
    }

    public final PackageInfo zzd() {
        return this.zza.zzf;
    }

    public final String zze() {
        return this.zza.zzd;
    }

    public final String zzf() {
        return zzfun.zzc(this.zza.zza.getString("ms"));
    }

    public final String zzg() {
        return this.zza.zzh;
    }

    public final List zzh() {
        return this.zza.zze;
    }

    final boolean zzi() {
        return this.zza.zzl;
    }

    final boolean zzj() {
        return this.zza.zza.getBoolean("is_gbid");
    }

    final boolean zzk() {
        return this.zza.zzk;
    }
}
