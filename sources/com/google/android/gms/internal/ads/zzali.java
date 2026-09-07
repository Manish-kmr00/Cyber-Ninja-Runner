package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzali implements zzaka {
    private final zzek zza = new zzek();

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzcu zzcuVarZzp;
        zzek zzekVar = this.zza;
        zzekVar.zzJ(bArr, i2 + i);
        zzekVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        while (zzekVar.zza() > 0) {
            zzdc.zze(zzekVar.zza() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZzg = zzekVar.zzg() - 8;
            if (zzekVar.zzg() == 1987343459) {
                CharSequence charSequenceZza = null;
                zzcs zzcsVarZzb = null;
                while (iZzg > 0) {
                    zzdc.zze(iZzg >= 8, "Incomplete vtt cue box header found.");
                    int iZzg2 = zzekVar.zzg();
                    int iZzg3 = zzekVar.zzg();
                    int i3 = iZzg - 8;
                    int i4 = iZzg2 - 8;
                    String strZzC = zzeu.zzC(zzekVar.zzN(), zzekVar.zzc(), i4);
                    zzekVar.zzM(i4);
                    if (iZzg3 == 1937011815) {
                        zzcsVarZzb = zzals.zzb(strZzC);
                    } else if (iZzg3 == 1885436268) {
                        charSequenceZza = zzals.zza(null, strZzC.trim(), Collections.emptyList());
                    }
                    iZzg = i3 - i4;
                }
                if (charSequenceZza == null) {
                    charSequenceZza = "";
                }
                if (zzcsVarZzb != null) {
                    zzcsVarZzb.zzl(charSequenceZza);
                    zzcuVarZzp = zzcsVarZzb.zzp();
                } else {
                    Pattern pattern = zzals.zza;
                    zzalq zzalqVar = new zzalq();
                    zzalqVar.zzc = charSequenceZza;
                    zzcuVarZzp = zzalqVar.zza().zzp();
                }
                arrayList.add(zzcuVarZzp);
            } else {
                zzekVar.zzM(iZzg);
            }
        }
        zzdkVar.zza(new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
