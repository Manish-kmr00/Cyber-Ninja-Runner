package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeo {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzav zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzeu.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzdx.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzaga.zzb(new zzek(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e) {
                    zzdx.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzagx(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzav(arrayList);
    }

    public static zzael zzc(zzek zzekVar, boolean z, boolean z2) throws zzaz {
        if (z) {
            zzd(3, zzekVar, false);
        }
        String strZzB = zzekVar.zzB((int) zzekVar.zzs(), StandardCharsets.UTF_8);
        int length = strZzB.length();
        long jZzs = zzekVar.zzs();
        String[] strArr = new String[(int) jZzs];
        int length2 = length + 15;
        for (int i = 0; i < jZzs; i++) {
            String strZzB2 = zzekVar.zzB((int) zzekVar.zzs(), StandardCharsets.UTF_8);
            strArr[i] = strZzB2;
            length2 = length2 + 4 + strZzB2.length();
        }
        if (z2 && (zzekVar.zzm() & 1) == 0) {
            throw zzaz.zza("framing bit expected to be set", null);
        }
        return new zzael(strZzB, strArr, length2 + 1);
    }

    public static boolean zzd(int i, zzek zzekVar, boolean z) throws zzaz {
        if (zzekVar.zza() < 7) {
            if (z) {
                return false;
            }
            throw zzaz.zza("too short header: " + zzekVar.zza(), null);
        }
        if (zzekVar.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzaz.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzekVar.zzm() == 118 && zzekVar.zzm() == 111 && zzekVar.zzm() == 114 && zzekVar.zzm() == 98 && zzekVar.zzm() == 105 && zzekVar.zzm() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzaz.zza("expected characters 'vorbis'", null);
    }
}
