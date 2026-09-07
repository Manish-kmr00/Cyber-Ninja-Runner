package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakq implements zzaka {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzakp zzc;
    private final zzek zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzakq() {
        this(null);
    }

    private static float zzb(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = zzeu.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zze(zzek zzekVar, Charset charset) {
        while (true) {
            String strZzz = zzekVar.zzz(charset);
            if (strZzz == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzz)) {
                while (true) {
                    String strZzz2 = zzekVar.zzz(charset);
                    if (strZzz2 == null || (zzekVar.zza() != 0 && zzekVar.zze(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzz2.split(":");
                    if (strArrSplit.length == 2) {
                        byte b = 0;
                        String strZza = zzftc.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (!strZza.equals("playresx")) {
                                    b = -1;
                                }
                                break;
                            case 1879649549:
                                if (!strZza.equals("playresy")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            this.zzf = Float.parseFloat(strArrSplit[1].trim());
                        } else if (b == 1) {
                            try {
                                this.zzg = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzz)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzakr zzakrVarZza = null;
                while (true) {
                    String strZzz3 = zzekVar.zzz(charset);
                    if (strZzz3 != null && (zzekVar.zza() == 0 || zzekVar.zze(charset) != 91)) {
                        if (strZzz3.startsWith("Format:")) {
                            zzakrVarZza = zzakr.zza(strZzz3);
                        } else if (strZzz3.startsWith("Style:")) {
                            if (zzakrVarZza == null) {
                                zzdx.zzf("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzz3));
                            } else {
                                zzakt zzaktVarZzb = zzakt.zzb(strZzz3, zzakrVarZza);
                                if (zzaktVarZzb != null) {
                                    linkedHashMap.put(zzaktVarZzb.zza, zzaktVarZzb);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzz)) {
                zzdx.zze("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzz)) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:132:0x02d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x018b  */
    /* JADX WARN: Code duplicated, block: B:67:0x019b  */
    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzakp zzakpVarZza;
        int i3;
        zzakp zzakpVar;
        int i4;
        Layout.Alignment alignment;
        int i5;
        int i6;
        int i7;
        Integer num;
        int i8;
        zzakq zzakqVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzek zzekVar = zzakqVar.zzd;
        zzekVar.zzJ(bArr, i + i2);
        zzekVar.zzL(i);
        Charset charsetZzC = zzekVar.zzC();
        if (charsetZzC == null) {
            charsetZzC = StandardCharsets.UTF_8;
        }
        if (zzakqVar.zzb) {
            zzakpVarZza = zzakqVar.zzc;
        } else {
            zzakqVar.zze(zzekVar, charsetZzC);
            zzakpVarZza = null;
        }
        while (true) {
            String strZzz = zzekVar.zzz(charsetZzC);
            if (strZzz == null) {
                int i9 = 0;
                while (i9 < arrayList.size()) {
                    List list = (List) arrayList.get(i9);
                    if (!list.isEmpty()) {
                        if (i9 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzdkVar.zza(new zzajs(list, ((Long) arrayList2.get(i9)).longValue(), ((Long) arrayList2.get(i9 + 1)).longValue() - ((Long) arrayList2.get(i9)).longValue()));
                        i3 = 1;
                    } else if (i9 != 0) {
                        i3 = 1;
                    } else {
                        i9 = 0;
                        if (i9 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzdkVar.zza(new zzajs(list, ((Long) arrayList2.get(i9)).longValue(), ((Long) arrayList2.get(i9 + 1)).longValue() - ((Long) arrayList2.get(i9)).longValue()));
                        i3 = 1;
                    }
                    i9 += i3;
                }
                return;
            }
            if (strZzz.startsWith("Format:")) {
                zzakpVarZza = zzakp.zza(strZzz);
            } else {
                if (strZzz.startsWith("Dialogue:")) {
                    if (zzakpVarZza == null) {
                        zzdx.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzz));
                    } else {
                        zzdc.zzd(strZzz.startsWith("Dialogue:"));
                        String strSubstring = strZzz.substring(9);
                        int i10 = zzakpVarZza.zze;
                        String[] strArrSplit = strSubstring.split(StringUtils.COMMA, i10);
                        if (strArrSplit.length != i10) {
                            zzdx.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzz));
                        } else {
                            long jZzd = zzd(strArrSplit[zzakpVarZza.zza]);
                            if (jZzd == -9223372036854775807L) {
                                zzdx.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzz));
                            } else {
                                long jZzd2 = zzd(strArrSplit[zzakpVarZza.zzb]);
                                if (jZzd2 == -9223372036854775807L || jZzd2 <= jZzd) {
                                    zzakpVar = zzakpVarZza;
                                    zzekVar = zzekVar;
                                    zzdx.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzz));
                                } else {
                                    Map map = zzakqVar.zze;
                                    zzakt zzaktVar = (map == null || (i8 = zzakpVarZza.zzc) == -1) ? null : (zzakt) map.get(strArrSplit[i8].trim());
                                    String str = strArrSplit[zzakpVarZza.zzd];
                                    zzaks zzaksVarZza = zzaks.zza(str);
                                    String strReplace = zzaks.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = zzakqVar.zzf;
                                    float f2 = zzakqVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzcs zzcsVar = new zzcs();
                                    zzcsVar.zzl(spannableString);
                                    if (zzaktVar != null) {
                                        Integer num2 = zzaktVar.zzc;
                                        zzakpVar = zzakpVarZza;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzaktVar.zzj == 3 && (num = zzaktVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f3 = zzaktVar.zze;
                                        if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            zzcsVar.zzn(f3 / f2, 1);
                                        }
                                        if (!zzaktVar.zzf) {
                                            i6 = 33;
                                            i7 = 0;
                                            if (zzaktVar.zzg) {
                                                i4 = 2;
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                            if (zzaktVar.zzh) {
                                                spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i6);
                                            }
                                            if (zzaktVar.zzi) {
                                                spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i6);
                                            }
                                        } else if (zzaktVar.zzg) {
                                            i6 = 33;
                                            i7 = 0;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i6 = 33;
                                            i7 = 0;
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        }
                                        i4 = 2;
                                        if (zzaktVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i6);
                                        }
                                        if (zzaktVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i6);
                                        }
                                    } else {
                                        zzakpVar = zzakpVarZza;
                                        zzekVar = zzekVar;
                                        jZzd2 = jZzd2;
                                        i4 = 2;
                                    }
                                    int i11 = zzaksVarZza.zza;
                                    if (i11 == -1) {
                                        i11 = zzaktVar != null ? zzaktVar.zzb : -1;
                                    }
                                    switch (i11) {
                                        case 0:
                                        default:
                                            zzdx.zzf("SsaParser", "Unknown alignment: " + i11);
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzcsVar.zzm(alignment);
                                    int i12 = Integer.MIN_VALUE;
                                    switch (i11) {
                                        case 0:
                                        default:
                                            zzdx.zzf("SsaParser", "Unknown alignment: " + i11);
                                        case -1:
                                            i5 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i5 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i5 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i5 = i4;
                                            break;
                                    }
                                    zzcsVar.zzi(i5);
                                    switch (i11) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            zzdx.zzf("SsaParser", "Unknown alignment: " + i11);
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i12 = i4;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i12 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i12 = 0;
                                            break;
                                    }
                                    zzcsVar.zzf(i12);
                                    PointF pointF = zzaksVarZza.zzb;
                                    if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzcsVar.zzh(zzb(zzcsVar.zzb()));
                                        zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                                    } else {
                                        zzcsVar.zzh(pointF.x / f);
                                        zzcsVar.zze(pointF.y / f2, 0);
                                    }
                                    zzcu zzcuVarZzp = zzcsVar.zzp();
                                    int iZzc = zzc(jZzd2, arrayList2, arrayList);
                                    for (int iZzc2 = zzc(jZzd, arrayList2, arrayList); iZzc2 < iZzc; iZzc2++) {
                                        ((List) arrayList.get(iZzc2)).add(zzcuVarZzp);
                                    }
                                }
                            }
                        }
                    }
                    zzakpVar = zzakpVarZza;
                    zzekVar = zzekVar;
                } else {
                    zzakpVar = zzakpVarZza;
                    zzekVar = zzekVar;
                }
                zzakqVar = this;
                charsetZzC = charsetZzC;
                zzakpVarZza = zzakpVar;
                zzekVar = zzekVar;
            }
        }
    }

    public zzakq(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzek();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzB = zzeu.zzB((byte[]) list.get(0));
        zzdc.zzd(strZzB.startsWith("Format:"));
        zzakp zzakpVarZza = zzakp.zza(strZzB);
        zzakpVarZza.getClass();
        this.zzc = zzakpVarZza;
        zze(new zzek((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
