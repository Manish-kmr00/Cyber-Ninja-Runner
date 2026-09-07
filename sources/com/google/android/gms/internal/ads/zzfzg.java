package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfzg extends zzfzi {
    private zzfzg(zzfze zzfzeVar, Character ch) {
        super(zzfzeVar, ch);
        zzftw.zze(zzfzeVar.zzf.length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzfzi, com.google.android.gms.internal.ads.zzfzj
    final int zza(byte[] bArr, CharSequence charSequence) throws zzfzh {
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzfze zzfzeVar = this.zzb;
        if (!zzfzeVar.zzd(length)) {
            throw new zzfzh("Invalid input length " + charSequenceZzg.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzg.length()) {
            int i3 = i2 + 1;
            int iZzb = (zzfzeVar.zzb(charSequenceZzg.charAt(i + 1)) << 12) | (zzfzeVar.zzb(charSequenceZzg.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzb >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZzg.length()) {
                int i5 = i + 3;
                int iZzb2 = iZzb | (zzfzeVar.zzb(charSequenceZzg.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzb2 >>> 8) & 255);
                if (i5 < charSequenceZzg.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzb2 | zzfzeVar.zzb(charSequenceZzg.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfzi
    final zzfzj zzb(zzfze zzfzeVar, Character ch) {
        return new zzfzg(zzfzeVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzfzi, com.google.android.gms.internal.ads.zzfzj
    final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzftw.zzk(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzfze zzfzeVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzfzeVar.zza(i8 >>> 18));
            appendable.append(zzfzeVar.zza((i8 >>> 12) & 63));
            appendable.append(zzfzeVar.zza((i8 >>> 6) & 63));
            appendable.append(zzfzeVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzh(appendable, bArr, i3, i2 - i3);
        }
    }

    zzfzg(String str, String str2, Character ch) {
        this(new zzfze(str, str2.toCharArray()), ch);
    }
}
