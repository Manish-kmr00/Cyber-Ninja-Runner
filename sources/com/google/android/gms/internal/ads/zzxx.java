package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzxx extends zzyi implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzyb zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;

    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    public zzxx(int i, zzbm zzbmVar, int i2, zzyb zzybVar, int i3, boolean z, zzftx zzftxVar, int i4) {
        int i5;
        int iZzc;
        byte b;
        boolean z2;
        int i6;
        int iZzc2;
        boolean z3;
        super(i, zzbmVar, i2);
        this.zzh = zzybVar;
        int i7 = 1;
        int i8 = true != zzybVar.zzP ? 16 : 24;
        boolean z4 = zzybVar.zzL;
        this.zzg = zzyn.zzh(this.zzd.zzd);
        this.zzi = zzlv.zza(i3, false);
        int i9 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i9 >= zzybVar.zzp.size()) {
                iZzc = 0;
                i9 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc = zzyn.zzc(this.zzd, (String) zzybVar.zzp.get(i9), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        this.zzk = i9;
        this.zzj = iZzc;
        int i10 = this.zzd.zzf;
        int i11 = zzybVar.zzq;
        this.zzl = zzyn.zzb(i10, 0);
        zzz zzzVar = this.zzd;
        int i12 = zzzVar.zzf;
        this.zzm = i12 == 0 || (i12 & 1) != 0;
        this.zzp = 1 == (zzzVar.zze & 1);
        String str = zzzVar.zzo;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2123537834) {
                if (iHashCode != 187078297) {
                    if (iHashCode == 1504698186 && str.equals("audio/iamf")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("audio/ac4")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("audio/eac3-joc")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0 || b == 1 || b == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.zzw = z2;
        this.zzq = zzzVar.zzE;
        this.zzr = zzzVar.zzF;
        this.zzs = zzzVar.zzj;
        int i13 = zzzVar.zzj;
        this.zzf = (i13 == -1 || i13 <= zzybVar.zzs) && ((i6 = zzzVar.zzE) == -1 || i6 <= zzybVar.zzr) && zzftxVar.zza(zzzVar);
        int i14 = zzeu.zza;
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzeu.zza >= 24 ? configuration.getLocales().toLanguageTags().split(StringUtils.COMMA, -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i15 = 0; i15 < strArrSplit.length; i15++) {
            strArrSplit[i15] = zzeu.zzE(strArrSplit[i15]);
        }
        int i16 = 0;
        while (true) {
            if (i16 >= strArrSplit.length) {
                iZzc2 = 0;
                i16 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc2 = zzyn.zzc(this.zzd, strArrSplit[i16], false);
                if (iZzc2 > 0) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        this.zzn = i16;
        this.zzo = iZzc2;
        for (int i17 = 0; i17 < zzybVar.zzt.size(); i17++) {
            String str2 = this.zzd.zzo;
            if (str2 != null && str2.equals(zzybVar.zzt.get(i17))) {
                i5 = i17;
                break;
            }
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzyb zzybVar2 = this.zzh;
        if (zzlv.zza(i3, zzybVar2.zzR) && ((z3 = this.zzf) || zzybVar2.zzK)) {
            int i18 = zzybVar2.zzu.zzb;
            if (zzlv.zza(i3, false) && z3 && this.zzd.zzj != -1) {
                boolean z5 = zzybVar2.zzC;
                boolean z6 = zzybVar2.zzB;
                if ((zzybVar2.zzT || !z) && (i8 & i3) != 0) {
                    i7 = 2;
                }
            }
        } else {
            i7 = 0;
        }
        this.zze = i7;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final /* bridge */ /* synthetic */ boolean zzc(zzyi zzyiVar) {
        String str;
        zzyb zzybVar = this.zzh;
        zzxx zzxxVar = (zzxx) zzyiVar;
        boolean z = zzybVar.zzN;
        zzz zzzVar = this.zzd;
        int i = zzzVar.zzE;
        if (i == -1) {
            return false;
        }
        zzz zzzVar2 = zzxxVar.zzd;
        if (i != zzzVar2.zzE || (str = zzzVar.zzo) == null || !TextUtils.equals(str, zzzVar2.zzo)) {
            return false;
        }
        boolean z2 = zzybVar.zzM;
        int i2 = zzzVar.zzF;
        if (i2 == -1 || i2 != zzzVar2.zzF) {
            return false;
        }
        boolean z3 = zzybVar.zzO;
        return this.zzu == zzxxVar.zzu && this.zzv == zzxxVar.zzv;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxx zzxxVar) {
        boolean z = this.zzf;
        zzfyh zzfyhVarZza = (z && this.zzi) ? zzyn.zzc : zzyn.zzc.zza();
        zzfwl zzfwlVarZzc = zzfwl.zzj().zzd(this.zzi, zzxxVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzxxVar.zzk), zzfyh.zzc().zza()).zzb(this.zzj, zzxxVar.zzj).zzb(this.zzl, zzxxVar.zzl).zzd(this.zzp, zzxxVar.zzp).zzd(this.zzm, zzxxVar.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzxxVar.zzn), zzfyh.zzc().zza()).zzb(this.zzo, zzxxVar.zzo).zzd(z, zzxxVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzxxVar.zzt), zzfyh.zzc().zza());
        boolean z2 = this.zzh.zzB;
        zzfwl zzfwlVarZzc2 = zzfwlVarZzc.zzd(this.zzu, zzxxVar.zzu).zzd(this.zzv, zzxxVar.zzv).zzd(this.zzw, zzxxVar.zzw).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzxxVar.zzq), zzfyhVarZza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzxxVar.zzr), zzfyhVarZza);
        if (Objects.equals(this.zzg, zzxxVar.zzg)) {
            zzfwlVarZzc2 = zzfwlVarZzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzxxVar.zzs), zzfyhVarZza);
        }
        return zzfwlVarZzc2.zza();
    }
}
