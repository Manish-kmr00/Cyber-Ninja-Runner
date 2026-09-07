package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzki;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class zzcg {
    public static final /* synthetic */ int zza = 0;

    static {
        int i = zzch.zza;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + ":" + com.google.android.gms.internal.play_billing.zzbf.zzb(exc.getMessage());
            int i = com.google.android.gms.internal.play_billing.zze.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zzjz zzb(int i, int i2, BillingResult billingResult) {
        try {
            zzjx zzjxVarZzc = zzjz.zzc();
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(billingResult.getResponseCode());
            zzkeVarZzc.zzm(billingResult.getDebugMessage());
            zzkeVarZzc.zzo(i);
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(i2);
            return (zzjz) zzjxVarZzc.zzf();
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }

    public static zzjz zzc(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(billingResult.getResponseCode());
            zzkeVarZzc.zzm(billingResult.getDebugMessage());
            zzkeVarZzc.zzo(i);
            if (str != null) {
                zzkeVarZzc.zza(str);
            }
            zzjx zzjxVarZzc = zzjz.zzc();
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(i2);
            return (zzjz) zzjxVarZzc.zzf();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzkd zzd(int i) {
        try {
            zzkb zzkbVarZzc = zzkd.zzc();
            zzkbVarZzc.zzn(i);
            return (zzkd) zzkbVarZzc.zzf();
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
