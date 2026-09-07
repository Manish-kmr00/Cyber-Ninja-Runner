package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaar {
    private final Context zza;
    private final zzabb zzb;
    private zzby zzc;
    private zzca zzd;
    private final List zze = zzfww.zzn();
    private final zzbv zzf = zzbv.zza;
    private zzdg zzg = zzdg.zza;
    private boolean zzh;

    public zzaar(Context context, zzabb zzabbVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzabbVar;
    }

    public final zzaar zze(zzdg zzdgVar) {
        this.zzg = zzdgVar;
        return this;
    }

    public final zzaax zzf() {
        zzdc.zzf(!this.zzh);
        if (this.zzd == null) {
            if (this.zzc == null) {
                this.zzc = new zzaau(false);
            }
            this.zzd = new zzaav(this.zzc);
        }
        zzaax zzaaxVar = new zzaax(this, null);
        this.zzh = true;
        return zzaaxVar;
    }
}
