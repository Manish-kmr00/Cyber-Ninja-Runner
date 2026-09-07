package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalt implements zzaka {
    private final zzek zza = new zzek();
    private final zzalj zzb = new zzalj();

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzek zzekVar = this.zza;
        zzekVar.zzJ(bArr, i2 + i);
        zzekVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        try {
            int iZzc = zzekVar.zzc();
            String strZzz = zzekVar.zzz(StandardCharsets.UTF_8);
            if (strZzz == null || !strZzz.startsWith("WEBVTT")) {
                zzekVar.zzL(iZzc);
                throw zzaz.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzekVar.zzz(StandardCharsets.UTF_8))), null);
            }
            while (!TextUtils.isEmpty(zzekVar.zzz(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                byte b = -1;
                int iZzc2 = 0;
                while (b == -1) {
                    iZzc2 = zzekVar.zzc();
                    String strZzz2 = zzekVar.zzz(StandardCharsets.UTF_8);
                    if (strZzz2 == null) {
                        b = 0;
                    } else if ("STYLE".equals(strZzz2)) {
                        b = 2;
                    } else {
                        b = strZzz2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                zzekVar.zzL(iZzc2);
                if (b == 0) {
                    zzaju.zza(new zzalw(arrayList2), zzajzVar, zzdkVar);
                    return;
                }
                if (b == 1) {
                    while (!TextUtils.isEmpty(zzekVar.zzz(StandardCharsets.UTF_8))) {
                    }
                } else if (b != 2) {
                    zzall zzallVarZzc = zzals.zzc(zzekVar, arrayList);
                    if (zzallVarZzc != null) {
                        arrayList2.add(zzallVarZzc);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    zzekVar.zzz(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zzb(zzekVar));
                }
            }
        } catch (zzaz e) {
            throw new IllegalArgumentException(e);
        }
    }
}
