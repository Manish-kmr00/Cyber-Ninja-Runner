package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.smaato.sdk.core.dns.DnsName;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalj {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzek zzc = new zzek();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzek zzekVar, StringBuilder sb) {
        zzc(zzekVar);
        if (zzekVar.zza() == 0) {
            return null;
        }
        String strZzd = zzd(zzekVar, sb);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzekVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cZzm);
        return sb2.toString();
    }

    static void zzc(zzek zzekVar) {
        while (true) {
            for (boolean z = true; zzekVar.zza() > 0 && z; z = false) {
                char c = (char) zzekVar.zzN()[zzekVar.zzc()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzekVar.zzM(1);
                } else {
                    int iZzc = zzekVar.zzc();
                    int iZzd = zzekVar.zzd();
                    byte[] bArrZzN = zzekVar.zzN();
                    if (iZzc + 2 <= iZzd) {
                        int i = iZzc + 1;
                        if (bArrZzN[iZzc] == 47) {
                            int i2 = iZzc + 2;
                            if (bArrZzN[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZzd) {
                                        break;
                                    }
                                    if (((char) bArrZzN[i2]) == '*' && ((char) bArrZzN[i3]) == '/') {
                                        iZzd = i2 + 2;
                                        i2 = iZzd;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzekVar.zzM(iZzd - zzekVar.zzc());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzek zzekVar, StringBuilder sb) {
        char c;
        sb.setLength(0);
        int iZzc = zzekVar.zzc();
        int iZzd = zzekVar.zzd();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (iZzc < iZzd && !z) {
                    c = (char) zzekVar.zzN()[iZzc];
                    if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                        break;
                    }
                    z = true;
                } else {
                    break loop0;
                }
            }
            sb.append(c);
            iZzc++;
        }
        zzekVar.zzM(iZzc - zzekVar.zzc());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:110:0x0203  */
    /* JADX WARN: Code duplicated, block: B:116:0x0216  */
    /* JADX WARN: Code duplicated, block: B:118:0x021c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0224  */
    /* JADX WARN: Code duplicated, block: B:122:0x022c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0231  */
    /* JADX WARN: Code duplicated, block: B:125:0x0239  */
    /* JADX WARN: Code duplicated, block: B:126:0x023e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0246  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0253  */
    /* JADX WARN: Code duplicated, block: B:133:0x025b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0263  */
    /* JADX WARN: Code duplicated, block: B:136:0x0268  */
    /* JADX WARN: Code duplicated, block: B:138:0x0270  */
    /* JADX WARN: Code duplicated, block: B:140:0x0280  */
    /* JADX WARN: Code duplicated, block: B:141:0x0299  */
    /* JADX WARN: Code duplicated, block: B:143:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:145:0x02af  */
    /* JADX WARN: Code duplicated, block: B:151:0x02be  */
    /* JADX WARN: Code duplicated, block: B:153:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:154:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:156:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:157:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x02d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:164:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:165:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:177:0x02de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x003e  */
    /* JADX WARN: Code duplicated, block: B:96:0x01be  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:99:0x01cf  */
    /* JADX WARN: Instruction removed from duplicated block: B:140:0x0280, please report this as an issue */
    public final List zzb(zzek zzekVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b;
        boolean z;
        StringBuilder sb = this.zzd;
        int i = 0;
        sb.setLength(0);
        int iZzc = zzekVar.zzc();
        while (!TextUtils.isEmpty(zzekVar.zzz(StandardCharsets.UTF_8))) {
        }
        zzek zzekVar2 = this.zzc;
        zzekVar2.zzJ(zzekVar.zzN(), zzekVar.zzc());
        zzekVar2.zzL(iZzc);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzc(zzekVar2);
            if (zzekVar2.zza() >= 5 && "::cue".equals(zzekVar2.zzB(5, StandardCharsets.UTF_8))) {
                int iZzc2 = zzekVar2.zzc();
                String strZza = zza(zzekVar2, sb);
                if (strZza == null) {
                    strTrim = null;
                } else if ("{".equals(strZza)) {
                    zzekVar2.zzL(iZzc2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZza)) {
                        int iZzc3 = zzekVar2.zzc();
                        int iZzd = zzekVar2.zzd();
                        int i2 = i;
                        while (iZzc3 < iZzd && i2 == 0) {
                            int i3 = iZzc3 + 1;
                            i2 = ((char) zzekVar2.zzN()[iZzc3]) == ')' ? 1 : i;
                            iZzc3 = i3;
                        }
                        strTrim = zzekVar2.zzB((iZzc3 - 1) - zzekVar2.zzc(), StandardCharsets.UTF_8).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zza(zzekVar2, sb))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zza(zzekVar2, sb))) {
                break;
            }
            zzalk zzalkVar = new zzalk();
            if (!"".equals(strTrim)) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzalkVar.zzv(strGroup2);
                    }
                    strTrim = strTrim.substring(i, iIndexOf);
                }
                int i4 = zzeu.zza;
                String[] strArrSplit = strTrim.split(DnsName.ESCAPED_DOT, -1);
                String str = strArrSplit[i];
                int iIndexOf2 = str.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzalkVar.zzu(str.substring(i, iIndexOf2));
                    zzalkVar.zzt(str.substring(iIndexOf2 + 1));
                } else {
                    zzalkVar.zzu(str);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzalkVar.zzs((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            int i5 = i;
            String strZza2 = null;
            while (i5 == 0) {
                int iZzc4 = zzekVar2.zzc();
                strZza2 = zza(zzekVar2, sb);
                int i6 = (strZza2 == null || "}".equals(strZza2)) ? 1 : i;
                if (i6 == 0) {
                    zzekVar2.zzL(iZzc4);
                    zzc(zzekVar2);
                    String strZzd = zzd(zzekVar2, sb);
                    if (!"".equals(strZzd) && ":".equals(zza(zzekVar2, sb))) {
                        zzc(zzekVar2);
                        StringBuilder sb2 = new StringBuilder();
                        int i7 = i;
                        while (true) {
                            if (i7 != 0) {
                                string = sb2.toString();
                                break;
                            }
                            int iZzc5 = zzekVar2.zzc();
                            String strZza3 = zza(zzekVar2, sb);
                            if (strZza3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZza3) || ";".equals(strZza3)) {
                                zzekVar2.zzL(iZzc5);
                                i7 = 1;
                            } else {
                                sb2.append(strZza3);
                            }
                        }
                        if (string != null && !"".equals(string)) {
                            int iZzc6 = zzekVar2.zzc();
                            String strZza4 = zza(zzekVar2, sb);
                            if (";".equals(strZza4)) {
                                if ("color".equals(strZzd)) {
                                    zzalkVar.zzk(zzdi.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalkVar.zzh(zzdi.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalkVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalkVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    zzalkVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalkVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalkVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalkVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalkVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzftc.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592) {
                                                    b = -1;
                                                } else {
                                                    b = 0;
                                                }
                                            } else if (strGroup.equals(UserDataStore.EMAIL)) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalkVar.zzn(1);
                                        } else if (b != 1) {
                                            zzalkVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalkVar.zzn(3);
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        zzalkVar.zzm(Float.parseFloat(strGroup3));
                                    } else {
                                        zzdx.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZza4)) {
                                zzekVar2.zzL(iZzc6);
                                if ("color".equals(strZzd)) {
                                    zzalkVar.zzk(zzdi.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalkVar.zzh(zzdi.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalkVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalkVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzalkVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalkVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalkVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalkVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalkVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzftc.zza(string));
                                    if (matcher.matches()) {
                                        zzdx.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                    b = 0;
                                                } else {
                                                    b = -1;
                                                }
                                            } else if (strGroup.equals(UserDataStore.EMAIL)) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalkVar.zzn(1);
                                        } else if (b != 1) {
                                            zzalkVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalkVar.zzn(3);
                                        }
                                        String strGroup4 = matcher.group(1);
                                        strGroup4.getClass();
                                        zzalkVar.zzm(Float.parseFloat(strGroup4));
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i5 = i6;
                i = 0;
            }
            if ("}".equals(strZza2)) {
                arrayList.add(zzalkVar);
            }
            i = 0;
        }
        return arrayList;
    }
}
