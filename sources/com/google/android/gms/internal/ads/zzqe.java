package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzqe extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzz zzc;

    public zzqe(int i, zzz zzzVar, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzzVar;
    }
}
