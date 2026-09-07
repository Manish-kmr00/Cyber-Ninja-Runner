package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
public final class zzazr extends zzazi {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzazr(int i) {
        int i2 = i >> 3;
        this.zzc = (i & 7) > 0 ? i2 + 1 : i2;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzazi
    public final byte[] zzb(String str) {
        synchronized (this.zza) {
            MessageDigest messageDigestZza = zza();
            this.zzb = messageDigestZza;
            if (messageDigestZza == null) {
                return new byte[0];
            }
            messageDigestZza.reset();
            this.zzb.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = this.zzb.digest();
            int length = bArrDigest.length;
            int i = this.zzc;
            if (length > i) {
                length = i;
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bArrDigest, 0, bArr, 0, length);
            int i2 = this.zzd & 7;
            if (i2 > 0) {
                long j = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 > 0) {
                        j <<= 8;
                    }
                    j += (long) (bArr[i3] & 255);
                }
                long j2 = j >>> (8 - i2);
                while (true) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                    bArr[i] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
