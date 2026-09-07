package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzccf extends zzaqs {
    static final zzccf zzb = new zzccf();

    zzccf() {
    }

    @Override // com.google.android.gms.internal.ads.zzaqs
    public final zzaqw zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzaqy();
        }
        return "mvhd".equals(str) ? new zzaqz() : new zzara(str);
    }
}
