package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfkz implements zzfks {
    private static zzfkz zza;
    private float zzb = 0.0f;
    private zzfkn zzc;
    private zzfkr zzd;

    public zzfkz(zzfko zzfkoVar, zzfkl zzfklVar) {
    }

    public static zzfkz zzb() {
        if (zza == null) {
            zza = new zzfkz(new zzfko(), new zzfkl());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfks
    public final void zzc(boolean z) {
        if (z) {
            zzfmb.zzd().zzi();
        } else {
            zzfmb.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zzc = new zzfkn(new Handler(), context, new zzfkk(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfkr.zza();
        }
        Iterator it = this.zzd.zzb().iterator();
        while (it.hasNext()) {
            ((zzfjz) it.next()).zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfkq.zza().zze(this);
        zzfkq.zza().zzf();
        zzfmb.zzd().zzi();
        this.zzc.zzc();
    }

    public final void zzg() {
        zzfmb.zzd().zzj();
        zzfkq.zza().zzg();
        this.zzc.zzd();
    }
}
