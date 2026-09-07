package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfqk {
    private static zzfqk zzb;
    final zzfql zza;

    private zzfqk(Context context) {
        this.zza = zzfql.zzb(context);
    }

    public static final zzfqk zza(Context context) {
        zzfqk zzfqkVar;
        synchronized (zzfqk.class) {
            if (zzb == null) {
                zzb = new zzfqk(context);
            }
            zzfqkVar = zzb;
        }
        return zzfqkVar;
    }

    public final void zzb(boolean z) throws IOException {
        synchronized (zzfqk.class) {
            this.zza.zzd("paidv2_user_option", Boolean.valueOf(z));
        }
    }

    public final void zzc(boolean z) throws IOException {
        synchronized (zzfqk.class) {
            zzfql zzfqlVar = this.zza;
            zzfqlVar.zzd("paidv2_publisher_option", Boolean.valueOf(z));
            if (!z) {
                zzfqlVar.zze("paidv2_creation_time");
                zzfqlVar.zze("paidv2_id");
                zzfqlVar.zze("vendor_scoped_gpid_v2_id");
                zzfqlVar.zze("vendor_scoped_gpid_v2_creation_time");
            }
        }
    }

    public final boolean zzd() {
        boolean zZzf;
        synchronized (zzfqk.class) {
            zZzf = this.zza.zzf("paidv2_publisher_option", true);
        }
        return zZzf;
    }

    public final boolean zze() {
        boolean zZzf;
        synchronized (zzfqk.class) {
            zZzf = this.zza.zzf("paidv2_user_option", true);
        }
        return zZzf;
    }
}
