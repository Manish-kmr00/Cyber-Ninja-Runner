package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagr extends zzagm {
    public final String zza;
    public final zzfww zzb;

    public zzagr(String str, String str2, List list) {
        super(str);
        zzdc.zzd(!list.isEmpty());
        this.zza = str2;
        zzfww zzfwwVarZzl = zzfww.zzl(list);
        this.zzb = zzfwwVarZzl;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagr zzagrVar = (zzagr) obj;
            if (Objects.equals(this.zzf, zzagrVar.zzf) && Objects.equals(this.zza, zzagrVar.zza) && this.zzb.equals(zzagrVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final String toString() {
        return this.zzf + ": description=" + this.zza + ": values=" + String.valueOf(this.zzb);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzagm, com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        byte b;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                b = !str.equals("TAL") ? (byte) -1 : (byte) 6;
                break;
            case 82878:
                b = !str.equals("TCM") ? (byte) -1 : Ascii.DLE;
                break;
            case 82897:
                b = !str.equals("TDA") ? (byte) -1 : Ascii.FF;
                break;
            case 83253:
                b = !str.equals("TP1") ? (byte) -1 : (byte) 2;
                break;
            case 83254:
                b = !str.equals("TP2") ? (byte) -1 : (byte) 4;
                break;
            case 83255:
                b = !str.equals("TP3") ? (byte) -1 : Ascii.DC2;
                break;
            case 83341:
                b = !str.equals("TRK") ? (byte) -1 : (byte) 8;
                break;
            case 83378:
                b = !str.equals("TT2") ? (byte) -1 : (byte) 0;
                break;
            case 83536:
                b = !str.equals("TXT") ? (byte) -1 : Ascii.DC4;
                break;
            case 83552:
                b = !str.equals("TYE") ? (byte) -1 : (byte) 10;
                break;
            case 2567331:
                b = !str.equals("TALB") ? (byte) -1 : (byte) 7;
                break;
            case 2569357:
                b = !str.equals("TCOM") ? (byte) -1 : (byte) 17;
                break;
            case 2569358:
                b = !str.equals("TCON") ? (byte) -1 : Ascii.SYN;
                break;
            case 2569891:
                b = !str.equals("TDAT") ? (byte) -1 : Ascii.CR;
                break;
            case 2570401:
                b = !str.equals("TDRC") ? (byte) -1 : Ascii.SO;
                break;
            case 2570410:
                b = !str.equals("TDRL") ? (byte) -1 : Ascii.SI;
                break;
            case 2571565:
                b = !str.equals("TEXT") ? (byte) -1 : Ascii.NAK;
                break;
            case 2575251:
                b = !str.equals("TIT2") ? (byte) -1 : (byte) 1;
                break;
            case 2581512:
                b = !str.equals("TPE1") ? (byte) -1 : (byte) 3;
                break;
            case 2581513:
                b = !str.equals("TPE2") ? (byte) -1 : (byte) 5;
                break;
            case 2581514:
                b = !str.equals("TPE3") ? (byte) -1 : (byte) 19;
                break;
            case 2583398:
                b = !str.equals("TRCK") ? (byte) -1 : (byte) 9;
                break;
            case 2590194:
                b = !str.equals("TYER") ? (byte) -1 : Ascii.VT;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
                zzarVar.zzr((CharSequence) this.zzb.get(0));
                break;
            case 2:
            case 3:
                zzarVar.zze((CharSequence) this.zzb.get(0));
                break;
            case 4:
            case 5:
                zzarVar.zzc((CharSequence) this.zzb.get(0));
                break;
            case 6:
            case 7:
                zzarVar.zzd((CharSequence) this.zzb.get(0));
                break;
            case 8:
            case 9:
                String str2 = (String) this.zzb.get(0);
                int i = zzeu.zza;
                String[] strArrSplit = str2.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                try {
                    int i2 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzarVar.zzu(Integer.valueOf(i2));
                    zzarVar.zzt(numValueOf);
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case 10:
            case 11:
                try {
                    zzarVar.zzm(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case 12:
            case 13:
                try {
                    String str3 = (String) this.zzb.get(0);
                    int i3 = Integer.parseInt(str3.substring(2, 4));
                    int i4 = Integer.parseInt(str3.substring(0, 2));
                    zzarVar.zzl(Integer.valueOf(i3));
                    zzarVar.zzk(Integer.valueOf(i4));
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case 14:
                List listZzb = zzb((String) this.zzb.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzarVar.zzk((Integer) listZzb.get(2));
                        }
                    }
                    zzarVar.zzl((Integer) listZzb.get(1));
                }
                zzarVar.zzm((Integer) listZzb.get(0));
                break;
            case 15:
                List listZzb2 = zzb((String) this.zzb.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzarVar.zzn((Integer) listZzb2.get(2));
                        }
                    }
                    zzarVar.zzo((Integer) listZzb2.get(1));
                }
                zzarVar.zzp((Integer) listZzb2.get(0));
                break;
            case 16:
            case 17:
                zzarVar.zzf((CharSequence) this.zzb.get(0));
                break;
            case 18:
            case 19:
                zzarVar.zzg((CharSequence) this.zzb.get(0));
                break;
            case 20:
            case 21:
                zzarVar.zzv((CharSequence) this.zzb.get(0));
                break;
            case 22:
                zzfww zzfwwVar = this.zzb;
                Integer numZzg = zzfzz.zzg((String) zzfwwVar.get(0), 10);
                if (numZzg != null) {
                    String strZza = zzagn.zza(numZzg.intValue());
                    if (strZza != null) {
                        zzarVar.zzj(strZza);
                    }
                } else {
                    zzarVar.zzj((CharSequence) zzfwwVar.get(0));
                }
                break;
        }
    }
}
