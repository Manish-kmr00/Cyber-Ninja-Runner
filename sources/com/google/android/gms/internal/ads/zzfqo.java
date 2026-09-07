package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfqo extends zzfqm {
    private static zzfqo zzd;

    private zzfqo(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfqo zzi(Context context) {
        zzfqo zzfqoVar;
        synchronized (zzfqo.class) {
            if (zzd == null) {
                zzd = new zzfqo(context);
            }
            zzfqoVar = zzd;
        }
        return zzfqoVar;
    }

    public final zzfqj zzh(long j, boolean z) throws IOException {
        synchronized (zzfqo.class) {
            if (this.zzc.zzd()) {
                return zzb(null, null, j, z);
            }
            return new zzfqj();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfqo.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }
}
