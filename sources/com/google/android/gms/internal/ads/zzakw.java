package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakw {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzfxb zze = zzfxb.zzp("auto", "none");
    private static final zzfxb zzf = zzfxb.zzq("dot", "sesame", "circle");
    private static final zzfxb zzg = zzfxb.zzp("filled", "open");
    private static final zzfxb zzh = zzfxb.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzakw(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    public static zzakw zza(String str) {
        byte b;
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzftc.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzfxb zzfxbVarZzm = zzfxb.zzm(TextUtils.split(strZza, zzd));
        String str2 = (String) zzfxc.zza(zzfyy.zzb(zzh, zzfxbVarZzm), "outside");
        int iHashCode = str2.hashCode();
        int i2 = -1;
        int i3 = 0;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals("after")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str2.equals("outside")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        zzfyw zzfywVarZzb = zzfyy.zzb(zze, zzfxbVarZzm);
        if (zzfywVarZzb.isEmpty()) {
            zzfyw zzfywVarZzb2 = zzfyy.zzb(zzg, zzfxbVarZzm);
            zzfyw zzfywVarZzb3 = zzfyy.zzb(zzf, zzfxbVarZzm);
            if (!zzfywVarZzb2.isEmpty() || !zzfywVarZzb3.isEmpty()) {
                String str3 = (String) zzfxc.zza(zzfywVarZzb2, "filled");
                int i4 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzfxc.zza(zzfywVarZzb3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i2 = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    i2 = 2;
                } else if (i2 != 1) {
                    i3 = i4;
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                i3 = i4;
            }
        } else {
            String str5 = (String) zzfywVarZzb.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i2 = 0;
            }
        }
        return new zzakw(i2, i3, i);
    }
}
