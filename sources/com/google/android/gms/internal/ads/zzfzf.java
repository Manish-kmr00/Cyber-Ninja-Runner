package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfzf extends zzfzi {
    final char[] zza;

    private zzfzf(zzfze zzfzeVar) {
        super(zzfzeVar, null);
        this.zza = new char[512];
        zzftw.zze(zzfzeVar.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzfzeVar.zza(i >>> 4);
            this.zza[i | 256] = zzfzeVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzi, com.google.android.gms.internal.ads.zzfzj
    final int zza(byte[] bArr, CharSequence charSequence) throws zzfzh {
        if (charSequence.length() % 2 == 1) {
            throw new zzfzh("Invalid input length " + charSequence.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zzfze zzfzeVar = this.zzb;
            bArr[i2] = (byte) (zzfzeVar.zzb(charSequence.charAt(i + 1)) | (zzfzeVar.zzb(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfzi
    final zzfzj zzb(zzfze zzfzeVar, Character ch) {
        return new zzfzf(zzfzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfzi, com.google.android.gms.internal.ads.zzfzj
    final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzftw.zzk(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    zzfzf(String str, String str2) {
        this(new zzfze("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
