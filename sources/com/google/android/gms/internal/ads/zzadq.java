package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadq {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = zzeu.zza;
            String str2 = strGroup;
            int i2 = Integer.parseInt(strGroup, 16);
            String strGroup2 = matcher.group(2);
            String str3 = strGroup2;
            int i3 = Integer.parseInt(strGroup2, 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.zza = i2;
            this.zzb = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzav zzavVar) {
        for (int i = 0; i < zzavVar.zza(); i++) {
            zzau zzauVarZzb = zzavVar.zzb(i);
            if (zzauVarZzb instanceof zzagh) {
                zzagh zzaghVar = (zzagh) zzauVarZzb;
                if ("iTunSMPB".equals(zzaghVar.zzb) && zzc(zzaghVar.zzc)) {
                    return true;
                }
            } else if (zzauVarZzb instanceof zzago) {
                zzago zzagoVar = (zzago) zzauVarZzb;
                if ("com.apple.iTunes".equals(zzagoVar.zza) && "iTunSMPB".equals(zzagoVar.zzb) && zzc(zzagoVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
