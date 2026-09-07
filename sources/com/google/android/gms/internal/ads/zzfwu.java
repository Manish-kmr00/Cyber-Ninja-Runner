package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfwu extends zzfuw {
    private final zzfww zza;

    zzfwu(zzfww zzfwwVar, int i) {
        super(zzfwwVar.size(), i);
        this.zza = zzfwwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuw
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
