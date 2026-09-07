package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgvn extends ThreadLocal {
    final /* synthetic */ zzgvo zza;

    zzgvn(zzgvo zzgvoVar) {
        this.zza = zzgvoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            zzgva zzgvaVar = zzgva.zzb;
            zzgvo zzgvoVar = this.zza;
            Mac mac = (Mac) zzgvaVar.zza(zzgvoVar.zzb);
            mac.init(zzgvoVar.zzc);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
