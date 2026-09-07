package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalp implements Comparable {
    public final int zza;
    public final zzalk zzb;

    public zzalp(int i, zzalk zzalkVar) {
        this.zza = i;
        this.zzb = zzalkVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzalp) obj).zza);
    }
}
