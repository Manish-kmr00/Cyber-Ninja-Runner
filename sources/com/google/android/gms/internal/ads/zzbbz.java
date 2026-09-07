package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzbbz {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbbz(int i, String str, Object obj, Object obj2, zzbby zzbbyVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzbd.zza().zzd(this);
    }

    public static zzbbz zzf(int i, String str, float f, float f2) {
        return new zzbbw(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbbz zzg(int i, String str, int i2, int i3) {
        return new zzbbu(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbbz zzh(int i, String str, long j, long j2) {
        return new zzbbv(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbbz zzi(int i, String str) {
        zzbbx zzbbxVar = new zzbbx(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zza().zzc(zzbbxVar);
        return zzbbxVar;
    }

    protected abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzj() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(this);
    }

    public final Object zzk() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzf() ? this.zzd : this.zzc;
    }

    public final String zzl() {
        return this.zzb;
    }
}
