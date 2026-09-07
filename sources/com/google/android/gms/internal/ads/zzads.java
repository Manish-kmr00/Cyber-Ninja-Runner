package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzads {
    private final zzek zza = new zzek(10);

    public final zzav zza(zzadd zzaddVar, zzagj zzagjVar) throws IOException {
        zzav zzavVarZza = null;
        int i = 0;
        while (true) {
            try {
                zzek zzekVar = this.zza;
                zzaddVar.zzh(zzekVar.zzN(), 0, 10);
                zzekVar.zzL(0);
                if (zzekVar.zzo() != 4801587) {
                    break;
                }
                zzekVar.zzM(3);
                int iZzl = zzekVar.zzl();
                int i2 = iZzl + 10;
                if (zzavVarZza == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(zzekVar.zzN(), 0, bArr, 0, 10);
                    zzaddVar.zzh(bArr, 10, iZzl);
                    zzavVarZza = zzagl.zza(bArr, i2, zzagjVar, new zzafx());
                } else {
                    zzaddVar.zzg(iZzl);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzaddVar.zzj();
        zzaddVar.zzg(i);
        return zzavVarZza;
    }
}
