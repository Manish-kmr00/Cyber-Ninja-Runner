package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzauo implements zzfok {
    final /* synthetic */ zzfmm zza;

    zzauo(zzauq zzauqVar, zzfmm zzfmmVar) {
        this.zza = zzfmmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
