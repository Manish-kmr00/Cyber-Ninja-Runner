package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzii extends zzba {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzz zzf;
    public final int zzg;
    public final zzuy zzh;
    final boolean zzi;

    private zzii(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, null, false);
    }

    public static zzii zzb(Throwable th, String str, int i, zzz zzzVar, int i2, zzuy zzuyVar, boolean z, int i3) {
        return new zzii(1, th, null, i3, str, i, zzzVar, zzzVar == null ? 4 : i2, zzuyVar, z);
    }

    public static zzii zzc(IOException iOException, int i) {
        return new zzii(0, iOException, i);
    }

    public static zzii zzd(RuntimeException runtimeException, int i) {
        return new zzii(2, runtimeException, i);
    }

    final zzii zza(zzuy zzuyVar) {
        String message = getMessage();
        int i = zzeu.zza;
        return new zzii(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzuyVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzii(int i, Throwable th, String str, int i2, String str2, int i3, zzz zzzVar, int i4, zzuy zzuyVar, boolean z) {
        String str3;
        String str4;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzzVar);
            int i5 = zzeu.zza;
            if (i4 == 0) {
                str4 = "NO";
            } else if (i4 == 1) {
                str4 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            str3 = str2 + " error, index=" + i3 + ", format=" + strValueOf + ", format_supported=" + str4;
        }
        this(TextUtils.isEmpty(null) ? str3 : str3.concat(": null"), th, i2, i, str2, i3, zzzVar, i4, zzuyVar, SystemClock.elapsedRealtime(), z);
    }

    private zzii(String str, Throwable th, int i, int i2, String str2, int i3, zzz zzzVar, int i4, zzuy zzuyVar, long j, boolean z) {
        int i5;
        boolean z2;
        super(str, th, i, Bundle.EMPTY, j);
        if (z) {
            i5 = i2;
            if (i5 == 1) {
                i5 = 1;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            i5 = i2;
            z2 = true;
        }
        zzdc.zzd(z2);
        zzdc.zzd(th != null);
        this.zzc = i5;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzzVar;
        this.zzg = i4;
        this.zzh = zzuyVar;
        this.zzi = z;
    }
}
