package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfqn extends zzfqm {
    private static zzfqn zzd;

    private zzfqn(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfqn zzj(Context context) {
        zzfqn zzfqnVar;
        synchronized (zzfqn.class) {
            if (zzd == null) {
                zzd = new zzfqn(context);
            }
            zzfqnVar = zzd;
        }
        return zzfqnVar;
    }

    public final zzfqj zzh(long j, boolean z) throws IOException {
        zzfqj zzfqjVarZzb;
        synchronized (zzfqn.class) {
            zzfqjVarZzb = zzb(null, null, j, z);
        }
        return zzfqjVarZzb;
    }

    public final zzfqj zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfqj zzfqjVarZzb;
        synchronized (zzfqn.class) {
            zzfqjVarZzb = zzb(str, str2, j, z);
        }
        return zzfqjVarZzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfqn.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfqn.class) {
            zzf(true);
        }
    }
}
