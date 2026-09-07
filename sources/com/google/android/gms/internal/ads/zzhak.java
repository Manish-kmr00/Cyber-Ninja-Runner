package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhak extends RuntimeException {
    public zzhak(zzgzg zzgzgVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgyk zza() {
        return new zzgyk(getMessage());
    }
}
