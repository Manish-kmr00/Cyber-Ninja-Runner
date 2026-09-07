package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaum {
    public static final String zza(Context context, String str, long j, boolean z) {
        try {
            zzatd zzatdVarZza = zzate.zza();
            zzatdVarZza.zzb(str);
            zzatdVarZza.zza("0.460000000");
            zzatdVarZza.zzc(context.getPackageName());
            zzatdVarZza.zze((System.currentTimeMillis() - j) / 1000);
            zzatdVarZza.zzd(System.currentTimeMillis() / 1000);
            try {
                zzatdVarZza.zzf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzatdVarZza.zzf(-1L);
            }
            zzatk zzatkVarZza = zzatw.zza(((zzate) zzatdVarZza.zzbr()).zzaV(), null);
            zzatkVarZza.zzd(5);
            zzatkVarZza.zzc(2);
            return Base64.encodeToString(((zzatl) zzatkVarZza.zzbr()).zzaV(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}
