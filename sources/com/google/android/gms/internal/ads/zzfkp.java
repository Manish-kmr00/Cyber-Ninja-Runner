package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfkp implements zzfks {
    private static final zzfkp zza = new zzfkp(new zzfkt());
    private Date zzb;
    private boolean zzc;
    private final zzfkt zzd;
    private boolean zze;

    private zzfkp(zzfkt zzfktVar) {
        this.zzd = zzfktVar;
    }

    public static zzfkp zza() {
        return zza;
    }

    public final Date zzb() {
        Date date = this.zzb;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfks
    public final void zzc(boolean z) {
        if (!this.zze && z) {
            Date date = new Date();
            Date date2 = this.zzb;
            if (date2 == null || date.after(date2)) {
                this.zzb = date;
                if (this.zzc) {
                    Iterator it = zzfkr.zza().zzb().iterator();
                    while (it.hasNext()) {
                        ((zzfjz) it.next()).zzg().zzg(zzb());
                    }
                }
            }
        }
        this.zze = z;
    }

    public final void zzd(Context context) {
        if (this.zzc) {
            return;
        }
        zzfkt zzfktVar = this.zzd;
        zzfktVar.zzd(context);
        zzfktVar.zze(this);
        zzfktVar.zzf();
        this.zze = zzfktVar.zza;
        this.zzc = true;
    }
}
