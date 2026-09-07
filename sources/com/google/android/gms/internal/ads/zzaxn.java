package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxn {
    private final zzawb zza;
    private final String zzb;
    private final String zzc;
    private final Class[] zze;
    private volatile Method zzd = null;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzaxn(zzawb zzawbVar, String str, String str2, Class... clsArr) {
        this.zza = zzawbVar;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzawbVar.zzj().submit(new zzaxm(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzaxn zzaxnVar) {
        try {
            zzawb zzawbVar = zzaxnVar.zza;
            Class clsLoadClass = zzawbVar.zzh().loadClass(zzaxnVar.zzc(zzawbVar.zzs(), zzaxnVar.zzb));
            if (clsLoadClass != null) {
                zzaxnVar.zzd = clsLoadClass.getMethod(zzaxnVar.zzc(zzawbVar.zzs(), zzaxnVar.zzc), zzaxnVar.zze);
                Method method = zzaxnVar.zzd;
            }
        } catch (zzavf | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } finally {
            zzaxnVar.zzf.countDown();
        }
    }

    private final String zzc(byte[] bArr, String str) throws zzavf, UnsupportedEncodingException {
        return new String(this.zza.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (this.zzf.await(2L, TimeUnit.SECONDS)) {
                return this.zzd;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
