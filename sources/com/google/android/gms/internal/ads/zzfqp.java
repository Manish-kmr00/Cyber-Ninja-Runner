package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfqp {
    private static zzfqp zzb;
    final zzfql zza;

    private zzfqp(Context context) {
        this.zza = zzfql.zzb(context);
        zzfqk.zza(context);
    }

    public static final zzfqp zza(Context context) {
        zzfqp zzfqpVar;
        synchronized (zzfqp.class) {
            if (zzb == null) {
                zzb = new zzfqp(context);
            }
            zzfqpVar = zzb;
        }
        return zzfqpVar;
    }

    public final void zzb(zzfqj zzfqjVar) throws IOException {
        synchronized (zzfqp.class) {
            zzfql zzfqlVar = this.zza;
            zzfqlVar.zze("vendor_scoped_gpid_v2_id");
            zzfqlVar.zze("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
