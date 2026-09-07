package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzaus {
    protected volatile Boolean zzb;
    private final zzawb zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfor zza = null;
    private static volatile Random zzd = null;

    public zzaus(zzawb zzawbVar) {
        this.zze = zzawbVar;
        zzawbVar.zzj().execute(new zzaur(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzaus.class) {
                    if (zzd == null) {
                        zzd = new Random();
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i, int i2, long j, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzarf zzarfVarZza = zzarj.zza();
            zzarfVarZza.zza(this.zze.zza.getPackageName());
            zzarfVarZza.zze(j);
            if (str != null) {
                zzarfVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzarfVarZza.zzf(stringWriter.toString());
                zzarfVarZza.zzd(exc.getClass().getName());
            }
            zzfop zzfopVarZza = zza.zza(((zzarj) zzarfVarZza.zzbr()).zzaV());
            zzfopVarZza.zza(i);
            if (i2 != -1) {
                zzfopVarZza.zzb(i2);
            }
            zzfopVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
