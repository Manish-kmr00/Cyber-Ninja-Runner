package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfon {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfoo zzc;
    private final zzfmr zzd;
    private final zzfmm zze;
    private zzfoc zzf;
    private final Object zzg = new Object();

    public zzfon(Context context, zzfoo zzfooVar, zzfmr zzfmrVar, zzfmm zzfmmVar) {
        this.zzb = context;
        this.zzc = zzfooVar;
        this.zzd = zzfmrVar;
        this.zze = zzfmmVar;
    }

    private final synchronized Class zzd(zzfod zzfodVar) throws zzfom {
        String strZzk = zzfodVar.zza().zzk();
        HashMap map = zza;
        Class cls = (Class) map.get(strZzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zze.zza(zzfodVar.zzc())) {
                throw new zzfom(2026, "VM did not pass signature verification");
            }
            try {
                File fileZzb = zzfodVar.zzb();
                if (!fileZzb.exists()) {
                    fileZzb.mkdirs();
                }
                Class clsLoadClass = new DexClassLoader(zzfodVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                map.put(strZzk, clsLoadClass);
                return clsLoadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzfom(2008, e);
            }
        } catch (GeneralSecurityException e2) {
            throw new zzfom(2026, e2);
        }
    }

    public final zzfmu zza() {
        zzfoc zzfocVar;
        synchronized (this.zzg) {
            zzfocVar = this.zzf;
        }
        return zzfocVar;
    }

    public final zzfod zzb() {
        synchronized (this.zzg) {
            zzfoc zzfocVar = this.zzf;
            if (zzfocVar == null) {
                return null;
            }
            return zzfocVar.zzf();
        }
    }

    public final boolean zzc(zzfod zzfodVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfoc zzfocVar = new zzfoc(zzd(zzfodVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfodVar.zze(), null, new Bundle(), 2), zzfodVar, this.zzc, this.zzd);
                if (!zzfocVar.zzh()) {
                    throw new zzfom(4000, "init failed");
                }
                int iZze = zzfocVar.zze();
                if (iZze != 0) {
                    throw new zzfom(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    zzfoc zzfocVar2 = this.zzf;
                    if (zzfocVar2 != null) {
                        try {
                            zzfocVar2.zzg();
                        } catch (zzfom e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                        this.zzf = zzfocVar;
                    } else {
                        this.zzf = zzfocVar;
                    }
                    throw th;
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzfom(2004, e2);
            }
        } catch (zzfom e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        }
    }
}
