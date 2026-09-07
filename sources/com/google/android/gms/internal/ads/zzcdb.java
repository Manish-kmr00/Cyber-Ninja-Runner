package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcdb extends zzccs implements zzcaw {
    public static final /* synthetic */ int zzd = 0;
    private zzcax zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcck zzi;
    private long zzj;
    private long zzk;

    public zzcdb(zzcbg zzcbgVar, zzcbf zzcbfVar) {
        super(zzcbgVar);
        zzcdt zzcdtVar = new zzcdt(zzcbgVar.getContext(), zzcbfVar, (zzcbg) this.zzc.get(), null);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcdtVar;
        zzcdtVar.zzL(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.gms.internal.ads.zzccs, com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.google.android.gms.internal.ads.zzccs, com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
    public static /* synthetic */ void zzb(zzcdb zzcdbVar) throws Throwable {
        ?? r6;
        ?? BooleanValue;
        ?? r3;
        ?? r4;
        long j;
        String str;
        long j2;
        String strZzc = zzc(zzcdbVar.zzf);
        ?? r17 = "error";
        try {
            ?? LongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzN)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzt)).intValue();
            BooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue();
            try {
                synchronized (zzcdbVar) {
                    try {
                        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
                        long j3 = zzcdbVar.zzj;
                        if (jCurrentTimeMillis - j3 <= LongValue) {
                            try {
                                if (zzcdbVar.zzg) {
                                    throw new IOException("Abort requested before buffering finished. ");
                                }
                                if (!zzcdbVar.zzh) {
                                    if (!zzcdbVar.zze.zzV()) {
                                        throw new IOException("ExoPlayer was released during preloading.");
                                    }
                                    long jZzz = zzcdbVar.zze.zzz();
                                    if (jZzz > 0) {
                                        long jZzv = zzcdbVar.zze.zzv();
                                        if (jZzv != zzcdbVar.zzk) {
                                            try {
                                                str = strZzc;
                                                try {
                                                    zzcdbVar.zzo(zzcdbVar.zzf, strZzc, jZzv, jZzz, jZzv > 0, BooleanValue != 0 ? zzcdbVar.zze.zzA() : -1L, BooleanValue != 0 ? zzcdbVar.zze.zzx() : -1L, BooleanValue != 0 ? zzcdbVar.zze.zzB() : -1L, zzcax.zzs(), zzcax.zzu());
                                                    BooleanValue = zzcdbVar;
                                                    j = jZzv;
                                                    try {
                                                        ((zzcdb) BooleanValue).zzk = j;
                                                        j2 = jZzz;
                                                        BooleanValue = BooleanValue;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        r6 = str;
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    BooleanValue = zzcdbVar;
                                                    r6 = str;
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                str = strZzc;
                                                BooleanValue = zzcdbVar;
                                            }
                                        } else {
                                            j = jZzv;
                                            str = strZzc;
                                            BooleanValue = zzcdbVar;
                                            j2 = jZzz;
                                        }
                                        if (j >= j2) {
                                            BooleanValue.zzj(((zzcdb) BooleanValue).zzf, str, j2);
                                            r3 = BooleanValue;
                                        } else if (((zzcdb) BooleanValue).zze.zzw() >= jIntValue && j > 0) {
                                            r3 = BooleanValue;
                                        }
                                    } else {
                                        r4 = zzcdbVar;
                                    }
                                    r4.zzx(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzO)).longValue());
                                    return;
                                }
                                r3 = zzcdbVar;
                                com.google.android.gms.ads.internal.zzv.zzz().zzc(((zzcdb) r3).zzi);
                            } catch (Throwable th4) {
                                th = th4;
                                r17 = LongValue;
                                r6 = j3;
                            }
                        } else {
                            r6 = strZzc;
                            BooleanValue = zzcdbVar;
                            try {
                                throw new IOException("Timeout reached. Limit: " + LongValue + " ms");
                            } catch (Throwable th5) {
                                th = th5;
                                r17 = "downloadTimeout";
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r6 = strZzc;
                        BooleanValue = zzcdbVar;
                    }
                    try {
                        throw th;
                    } catch (Exception e) {
                        e = e;
                        ?? r1 = r17;
                        String str2 = "Failed to preload url " + ((zzcdb) BooleanValue).zzf + " Exception: " + e.getMessage();
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
                        com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
                        zzcdbVar.release();
                        BooleanValue.zzg(((zzcdb) BooleanValue).zzf, r6, r1, zzd(r1, e));
                        r3 = BooleanValue;
                        com.google.android.gms.ads.internal.zzv.zzz().zzc(((zzcdb) r3).zzi);
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e2) {
            e = e2;
            r6 = strZzc;
            BooleanValue = zzcdbVar;
        }
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcda
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzcdb.zzb(this.zza);
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzccs, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcax zzcaxVar = this.zze;
        if (zzcaxVar != null) {
            zzcaxVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzD(int i, int i2) {
    }

    public final zzcax zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcax zzcaxVar = this.zze;
        this.zze = null;
        return zzcaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzi(final boolean z, final long j) {
        final zzcbg zzcbgVar = (zzcbg) this.zzc.get();
        if (zzcbgVar != null) {
            zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccz
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzcdb.zzd;
                    zzcbgVar.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzk(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzl(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzcbg] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzccs, com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcdb] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzccs] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzu(String str, String[] strArr) throws Throwable {
        ?? r6;
        String str2;
        ?? r5;
        long j;
        ?? r1;
        String str3;
        long j2;
        ?? r2;
        ?? r15 = this;
        ?? r13 = str;
        r15.zzf = r13;
        ?? r17 = "error";
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            r15.zze.zzF(uriArr, r15.zzb);
            ?? r0 = (zzcbg) r15.zzc.get();
            if (r0 != 0) {
                r0.zzt(strZzc, r15);
            }
            Clock clockZzC = com.google.android.gms.ads.internal.zzv.zzC();
            long jCurrentTimeMillis = clockZzC.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzO)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzN)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzt)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue();
            ?? r3 = -1;
            long j3 = jIntValue;
            r13 = r13;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzC.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (r15.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!r15.zzh) {
                            if (!r15.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = r15.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = r15.zze.zzv();
                                if (jZzv != r3) {
                                    try {
                                        long j4 = jZzz;
                                        str3 = strZzc;
                                        try {
                                            zzo(str, strZzc, jZzv, j4, jZzv > 0, zBooleanValue ? r15.zze.zzA() : -1L, zBooleanValue ? r15.zze.zzx() : -1L, zBooleanValue ? r15.zze.zzB() : -1L, zzcax.zzs(), zzcax.zzu());
                                            r2 = jZzv;
                                            j2 = jZzz;
                                            r6 = j4;
                                        } catch (Throwable th) {
                                            th = th;
                                            r5 = this;
                                            r6 = str;
                                            str2 = str3;
                                            try {
                                                throw th;
                                            } catch (Exception e) {
                                                e = e;
                                                ?? r4 = r17;
                                                String str4 = "Failed to preload url " + r6 + " Exception: " + e.getMessage();
                                                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzj(str4);
                                                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
                                                release();
                                                r5.zzg(r6, str2, r4, zzd(r4, e));
                                                return false;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str3 = strZzc;
                                    }
                                } else {
                                    str3 = strZzc;
                                    j2 = jZzz;
                                    r2 = r3;
                                    r6 = j3;
                                }
                                r5 = (jZzv > j2 ? 1 : (jZzv == j2 ? 0 : -1));
                                if (r5 >= 0) {
                                    zzj(str, str3, j2);
                                } else {
                                    try {
                                        zzcdb zzcdbVar = this;
                                        r6 = str;
                                        str2 = str3;
                                        if (zzcdbVar.zze.zzw() < j3 || jZzv <= 0) {
                                            r1 = r2;
                                            r5 = zzcdbVar;
                                            j = j3;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                }
                            } else {
                                j = j3;
                                jLongValue2 = jLongValue2;
                                r6 = r13;
                                str2 = strZzc;
                                r5 = r15;
                                r1 = r3;
                            }
                            try {
                                try {
                                    r5.wait(jLongValue);
                                } catch (InterruptedException unused) {
                                    throw new IOException("Wait interrupted.");
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                r17 = r1;
                                throw th;
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        r6 = r13;
                        str2 = strZzc;
                        r5 = r15;
                    }
                }
                return true;
                jLongValue = jLongValue;
                r15 = r5;
                r13 = r6;
                strZzc = str2;
                j3 = j;
                jLongValue2 = jLongValue2;
                r3 = r1;
            }
        } catch (Exception e2) {
            e = e2;
            r6 = r13;
            str2 = strZzc;
            r5 = r15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzv() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzw(String str, String[] strArr, zzcck zzcckVar) {
        this.zzf = str;
        this.zzi = zzcckVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcbg zzcbgVar = (zzcbg) this.zzc.get();
            if (zzcbgVar != null) {
                zzcbgVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            String str2 = "Failed to preload url " + str + " Exception: " + e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e));
            return false;
        }
    }
}
