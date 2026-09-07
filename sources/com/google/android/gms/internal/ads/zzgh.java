package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgh {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public zzgh() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1L;
    }

    /* synthetic */ zzgh(zzgj zzgjVar, zzgi zzgiVar) {
        this.zza = zzgjVar.zza;
        this.zzb = zzgjVar.zzd;
        this.zzc = zzgjVar.zze;
        this.zzd = zzgjVar.zzf;
        this.zze = zzgjVar.zzg;
    }

    public final zzgh zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzgh zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgh zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzgh zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzgj zze() {
        if (this.zza == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        return new zzgj(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
