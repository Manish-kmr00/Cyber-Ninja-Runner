package com.google.android.gms.internal.ads;

import android.text.Layout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.appevents.UserDataStore;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzala implements zzaka {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzaky zzh = new zzaky(30.0f, 1, 1);

    /* JADX WARN: Code duplicated, block: B:50:0x0101  */
    private static long zzc(String str, zzaky zzakyVar) throws zzajw {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        byte b = 2;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j2 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d3 = j + j2;
            double d4 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d5 = 0.0d;
            double d6 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d7 = d3 + d4;
            String strGroup5 = matcher.group(5);
            double d8 = strGroup5 != null ? Long.parseLong(strGroup5) / zzakyVar.zza : 0.0d;
            double d9 = d7 + d6;
            String strGroup6 = matcher.group(6);
            if (strGroup6 != null) {
                d5 = (Long.parseLong(strGroup6) / ((double) zzakyVar.zzb)) / ((double) zzakyVar.zza);
            }
            return (long) ((d9 + d8 + d5) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzajw("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d10 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        int iHashCode = strGroup8.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode != 115) {
                            if (iHashCode == 116 && strGroup8.equals(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP)) {
                                b = 5;
                            } else {
                                b = -1;
                            }
                        } else if (!strGroup8.equals("s")) {
                            b = -1;
                        }
                    } else if (strGroup8.equals("ms")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                } else if (strGroup8.equals("m")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strGroup8.equals("h")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (strGroup8.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
            b = 4;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b != 1) {
                if (b == 3) {
                    d2 = 1000.0d;
                } else if (b == 4) {
                    d2 = zzakyVar.zza;
                } else if (b == 5) {
                    d2 = zzakyVar.zzc;
                }
                d10 /= d2;
            } else {
                d = 60.0d;
            }
            return (long) (d10 * 1000000.0d);
        }
        d = 3600.0d;
        d10 *= d;
        return (long) (d10 * 1000000.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    private static Layout.Alignment zzd(String str) {
        byte b;
        switch (zzftc.zza(str)) {
            case "center":
                b = 4;
                break;
            case "end":
                b = 3;
                break;
            case "left":
                b = 0;
                break;
            case "right":
                b = 2;
                break;
            case "start":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0 || b == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (b == 2 || b == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (b != 4) {
            return null;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static zzald zze(zzald zzaldVar) {
        return zzaldVar == null ? new zzald() : zzaldVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v89 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r6v90 */
    private static zzald zzf(XmlPullParser xmlPullParser, zzald zzaldVar) {
        ?? r6;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        boolean z = false;
        zzald zzaldVarZze = zzaldVar;
        int i = 0;
        while (i < attributeCount) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            ?? r10 = -1;
             = -1;
             = -1;
             = -1;
             = -1;
            ?? r11 = -1;
             = -1;
             = -1;
            ?? r12 = -1;
             = -1;
             = -1;
             = -1;
             = -1;
             = -1;
             = -1;
            ?? r13 = -1;
             = -1;
             = -1;
            ?? r14 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    r6 = !attributeName.equals("fontStyle") ? -1 : 6;
                    break;
                case -1289044182:
                    r6 = !attributeName.equals("extent") ? -1 : 16;
                    break;
                case -1224696685:
                    r6 = !attributeName.equals("fontFamily") ? -1 : 3;
                    break;
                case -1065511464:
                    r6 = !attributeName.equals("textAlign") ? -1 : 7;
                    break;
                case -1008619738:
                    r6 = !attributeName.equals("origin") ? -1 : 15;
                    break;
                case -879295043:
                    r6 = !attributeName.equals("textDecoration") ? -1 : 12;
                    break;
                case -734428249:
                    r6 = !attributeName.equals("fontWeight") ? -1 : 5;
                    break;
                case 3355:
                    r6 = !attributeName.equals("id") ? -1 : z;
                    break;
                case 3511770:
                    r6 = !attributeName.equals("ruby") ? -1 : 10;
                    break;
                case 94842723:
                    r6 = !attributeName.equals("color") ? -1 : 2;
                    break;
                case 109403361:
                    r6 = !attributeName.equals("shear") ? -1 : 14;
                    break;
                case 110138194:
                    r6 = !attributeName.equals("textCombine") ? -1 : 9;
                    break;
                case 365601008:
                    r6 = !attributeName.equals("fontSize") ? -1 : 4;
                    break;
                case 921125321:
                    r6 = !attributeName.equals("textEmphasis") ? -1 : 13;
                    break;
                case 1115953443:
                    r6 = !attributeName.equals("rubyPosition") ? -1 : 11;
                    break;
                case 1287124693:
                    r6 = !attributeName.equals("backgroundColor") ? -1 : 1;
                    break;
                case 1754920356:
                    r6 = !attributeName.equals("multiRowAlign") ? -1 : 8;
                    break;
                default:
                    r6 = -1;
                    break;
            }
            switch (r6) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzt(attributeValue);
                    }
                    break;
                case 1:
                    zzaldVarZze = zze(zzaldVarZze);
                    try {
                        zzaldVarZze.zzm(zzdi.zzb(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        zzdx.zzf("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 2:
                    zzaldVarZze = zze(zzaldVarZze);
                    try {
                        zzaldVarZze.zzp(zzdi.zzb(attributeValue));
                    } catch (IllegalArgumentException unused2) {
                        zzdx.zzf("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 3:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzq(attributeValue);
                    break;
                case 4:
                    try {
                        zzaldVarZze = zze(zzaldVarZze);
                        int i2 = zzeu.zza;
                        String[] strArrSplit = attributeValue.split("\\s+", -1);
                        int length = strArrSplit.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzajw("Invalid number of entries for fontSize: " + length + ".");
                            }
                            matcher = zze.matcher(strArrSplit[1]);
                            zzdx.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzajw("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String strGroup = matcher.group(3);
                        if (strGroup == null) {
                            throw null;
                        }
                        String str = strGroup;
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 37) {
                            if (iHashCode != 3240) {
                                if (iHashCode == 3592 && strGroup.equals("px")) {
                                    r10 = 0;
                                }
                            } else if (strGroup.equals(UserDataStore.EMAIL)) {
                                r10 = 1;
                            }
                        } else if (strGroup.equals("%")) {
                            r10 = 2;
                        }
                        if (r10 == 0) {
                            zzaldVarZze.zzs(1);
                        } else if (r10 == 1) {
                            zzaldVarZze.zzs(2);
                        } else {
                            if (r10 != 2) {
                                throw new zzajw("Invalid unit for fontSize: '" + strGroup + "'.");
                            }
                            zzaldVarZze.zzs(3);
                        }
                        String strGroup2 = matcher.group(1);
                        if (strGroup2 == null) {
                            throw null;
                        }
                        String str2 = strGroup2;
                        zzaldVarZze.zzr(Float.parseFloat(strGroup2));
                    } catch (zzajw unused3) {
                        zzdx.zzf("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 5:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzn("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzu("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzB(zzd(attributeValue));
                    break;
                case 8:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzw(zzd(attributeValue));
                    break;
                case 9:
                    String strZza = zzftc.zza(attributeValue);
                    int iHashCode2 = strZza.hashCode();
                    if (iHashCode2 != 96673) {
                        if (iHashCode2 == 3387192 && strZza.equals("none")) {
                            r14 = z;
                        }
                    } else if (strZza.equals("all")) {
                        r14 = 1;
                    }
                    if (r14 == 0) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzC(z);
                    } else if (r14 == 1) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzC(true);
                    }
                    break;
                case 10:
                    String strZza2 = zzftc.zza(attributeValue);
                    switch (strZza2.hashCode()) {
                        case -618561360:
                            if (strZza2.equals("baseContainer")) {
                                r13 = 2;
                            }
                            break;
                        case -410956671:
                            if (strZza2.equals("container")) {
                                r13 = z;
                            }
                            break;
                        case -250518009:
                            if (strZza2.equals("delimiter")) {
                                r13 = 5;
                            }
                            break;
                        case -136074796:
                            if (strZza2.equals("textContainer")) {
                                r13 = 4;
                            }
                            break;
                        case 3016401:
                            if (strZza2.equals("base")) {
                                r13 = 1;
                            }
                            break;
                        case 3556653:
                            if (strZza2.equals("text")) {
                                r13 = 3;
                            }
                            break;
                    }
                    if (r13 == 0) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzz(1);
                    } else if (r13 == 1 || r13 == 2) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzz(2);
                    } else if (r13 == 3 || r13 == 4) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzz(3);
                    } else if (r13 == 5) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzz(4);
                    }
                    break;
                case 11:
                    String strZza3 = zzftc.zza(attributeValue);
                    int iHashCode3 = strZza3.hashCode();
                    if (iHashCode3 != -1392885889) {
                        if (iHashCode3 == 92734940 && strZza3.equals("after")) {
                            r12 = 1;
                        }
                    } else if (strZza3.equals("before")) {
                        r12 = z;
                    }
                    if (r12 == 0) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzy(1);
                    } else if (r12 == 1) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzy(2);
                    }
                    break;
                case 12:
                    String strZza4 = zzftc.zza(attributeValue);
                    switch (strZza4.hashCode()) {
                        case -1461280213:
                            if (strZza4.equals("nounderline")) {
                                r11 = 3;
                            }
                            break;
                        case -1026963764:
                            if (strZza4.equals("underline")) {
                                r11 = 2;
                            }
                            break;
                        case 913457136:
                            if (strZza4.equals("nolinethrough")) {
                                r11 = 1;
                            }
                            break;
                        case 1679736913:
                            if (strZza4.equals("linethrough")) {
                                r11 = z;
                            }
                            break;
                    }
                    if (r11 == 0) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzv(true);
                    } else if (r11 == 1) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzv(z);
                    } else if (r11 == 2) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzE(true);
                    } else if (r11 == 3) {
                        zzaldVarZze = zze(zzaldVarZze);
                        zzaldVarZze.zzE(z);
                    }
                    break;
                case 13:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzD(zzakw.zza(attributeValue));
                    break;
                case 14:
                    zzald zzaldVarZze2 = zze(zzaldVarZze);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String strGroup3 = matcher2.group(1);
                            if (strGroup3 == null) {
                                throw null;
                            }
                            String str3 = strGroup3;
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup3)));
                        } catch (NumberFormatException e) {
                            zzdx.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                        }
                    } else {
                        zzdx.zzf("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                    }
                    zzaldVarZze2.zzA(fMin);
                    zzaldVarZze = zzaldVarZze2;
                    break;
                case 15:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzx(attributeValue);
                    break;
                case 16:
                    zzaldVarZze = zze(zzaldVarZze);
                    zzaldVarZze.zzo(attributeValue);
                    break;
            }
            i++;
            z = false;
        }
        return zzaldVarZze;
    }

    private static String[] zzg(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = zzeu.zza;
        return strTrim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzaju.zza(zzb(bArr, i, i2), zzajzVar, zzdkVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:238:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:245:0x04da  */
    /* JADX WARN: Code duplicated, block: B:266:0x051e  */
    /* JADX WARN: Code duplicated, block: B:275:0x052e  */
    /* JADX WARN: Code duplicated, block: B:282:0x0550 A[LOOP:1: B:117:0x028c->B:282:0x0550, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:309:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:320:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:365:0x066f  */
    /* JADX WARN: Code duplicated, block: B:367:0x0673  */
    /* JADX WARN: Code duplicated, block: B:368:0x067a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:369:0x067c  */
    /* JADX WARN: Code duplicated, block: B:373:0x0684  */
    /* JADX WARN: Code duplicated, block: B:376:0x068a  */
    /* JADX WARN: Code duplicated, block: B:378:0x068f  */
    /* JADX WARN: Code duplicated, block: B:383:0x06a6 A[Catch: zzajw -> 0x06b1, IOException -> 0x074b, XmlPullParserException -> 0x0755, TRY_LEAVE, TryCatch #16 {zzajw -> 0x06b1, blocks: (B:381:0x06a1, B:383:0x06a6), top: B:456:0x06a1 }] */
    /* JADX WARN: Code duplicated, block: B:479:0x054a A[SYNTHETIC] */
    public final zzajv zzb(byte[] bArr, int i, int i2) {
        String str;
        zzale zzaleVar;
        ArrayDeque arrayDeque;
        zzaky zzakyVar;
        int attributeCount;
        zzajw zzajwVar;
        long j;
        zzakx zzakxVar;
        long j2;
        long j3;
        zzakx zzakxVarZzb;
        long j4;
        zzaky zzakyVar2;
        byte b;
        float f;
        float f2;
        String str2;
        float f3;
        float f4;
        float f5;
        int i3;
        int i4;
        zzalb zzalbVar;
        byte b2;
        byte b3;
        String strZza;
        zzald zzaldVar;
        float f6;
        float f7;
        String strZza2;
        zzald zzaldVar2;
        String strZza3;
        float f8;
        int i5;
        boolean z;
        String str3 = "";
        String str4 = "http://www.w3.org/ns/ttml#parameter";
        try {
            XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new zzalb("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            zzaky zzakyVar3 = zzh;
            zzale zzaleVar2 = null;
            zzakz zzakzVar = null;
            zzaky zzakyVar4 = zzakyVar3;
            int i6 = 0;
            int i7 = 15;
            while (eventType != 1) {
                zzakx zzakxVar2 = (zzakx) arrayDeque2.peek();
                if (i6 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    str = str3;
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(str4, "frameRate");
                            int i8 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str4, "frameRateMultiplier");
                            zzaleVar = zzaleVar2;
                            if (attributeValue2 != null) {
                                int i9 = zzeu.zza;
                                String[] strArrSplit = attributeValue2.split(" ", -1);
                                zzdc.zze(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f8 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                            } else {
                                f8 = 1.0f;
                            }
                            int i10 = zzakyVar3.zzb;
                            String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str4, "subFrameRate");
                            if (attributeValue3 != null) {
                                i10 = Integer.parseInt(attributeValue3);
                            }
                            int i11 = zzakyVar3.zzc;
                            String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str4, "tickRate");
                            zzaky zzakyVar5 = new zzaky(i8 * f8, i10, attributeValue4 != null ? Integer.parseInt(attributeValue4) : i11);
                            String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str4, "cellResolution");
                            if (attributeValue5 == null) {
                                str4 = str4;
                                zzakyVar4 = zzakyVar5;
                                i7 = 15;
                            } else {
                                Matcher matcher = zzg.matcher(attributeValue5);
                                if (matcher.matches()) {
                                    try {
                                        String strGroup = matcher.group(1);
                                        if (strGroup == null) {
                                            throw null;
                                        }
                                        String str5 = strGroup;
                                        int i12 = Integer.parseInt(strGroup);
                                        String strGroup2 = matcher.group(2);
                                        if (strGroup2 == null) {
                                            throw null;
                                        }
                                        String str6 = strGroup2;
                                        int i13 = Integer.parseInt(strGroup2);
                                        if (i12 == 0) {
                                            i5 = i13;
                                            z = false;
                                        } else if (i13 != 0) {
                                            i5 = i13;
                                            z = true;
                                        } else {
                                            z = false;
                                            i5 = 0;
                                        }
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            zzakyVar4 = zzakyVar5;
                                            try {
                                                sb.append("Invalid cell resolution ");
                                                sb.append(i12);
                                                sb.append(" ");
                                                sb.append(i5);
                                                zzdc.zze(z, sb.toString());
                                                i7 = i5;
                                            } catch (NumberFormatException unused) {
                                                zzdx.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                i7 = 15;
                                            }
                                        } catch (NumberFormatException unused2) {
                                            zzakyVar4 = zzakyVar5;
                                        }
                                    } catch (NumberFormatException unused3) {
                                        str4 = str4;
                                    }
                                    zzakyVar4 = zzakyVar5;
                                    zzdx.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    i7 = 15;
                                } else {
                                    zzdx.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    str4 = str4;
                                    zzakyVar4 = zzakyVar5;
                                    i7 = 15;
                                }
                            }
                            String strZza4 = zzev.zza(xmlPullParserNewPullParser, "extent");
                            if (strZza4 == null) {
                                zzakzVar = null;
                            } else {
                                Matcher matcher2 = zzf.matcher(strZza4);
                                if (matcher2.matches()) {
                                    try {
                                        String strGroup3 = matcher2.group(1);
                                        if (strGroup3 == null) {
                                            throw null;
                                        }
                                        String str7 = strGroup3;
                                        int i14 = Integer.parseInt(strGroup3);
                                        String strGroup4 = matcher2.group(2);
                                        if (strGroup4 == null) {
                                            throw null;
                                        }
                                        String str8 = strGroup4;
                                        zzakzVar = new zzakz(i14, Integer.parseInt(strGroup4));
                                    } catch (NumberFormatException unused4) {
                                        zzdx.zzf("TtmlParser", "Ignoring malformed tts extent: ".concat(strZza4));
                                        zzakzVar = null;
                                    }
                                } else {
                                    zzdx.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZza4));
                                }
                                zzakzVar = null;
                            }
                        } else {
                            str4 = str4;
                            arrayDeque2 = arrayDeque2;
                            zzakyVar3 = zzakyVar3;
                            zzaleVar = zzaleVar2;
                            i6 = i6;
                        }
                        zzaky zzakyVar6 = zzakyVar4;
                        int i15 = i7;
                        zzakz zzakzVar2 = zzakzVar;
                        String str9 = "metadata";
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals("style") || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("image") || name.equals("data") || name.equals("information")) {
                            if ("head".equals(name)) {
                                while (true) {
                                    xmlPullParserNewPullParser.next();
                                    if (zzev.zzc(xmlPullParserNewPullParser, "style")) {
                                        String strZza5 = zzev.zza(xmlPullParserNewPullParser, "style");
                                        zzald zzaldVarZzf = zzf(xmlPullParserNewPullParser, new zzald());
                                        if (strZza5 != null) {
                                            String[] strArrZzg = zzg(strZza5);
                                            int i16 = 0;
                                            for (int length = strArrZzg.length; i16 < length; length = length) {
                                                zzaldVarZzf.zzl((zzald) map.get(strArrZzg[i16]));
                                                i16++;
                                            }
                                        }
                                        String strZzH = zzaldVarZzf.zzH();
                                        if (strZzH != null) {
                                            map.put(strZzH, zzaldVarZzf);
                                        }
                                    } else {
                                        zzakyVar6 = zzakyVar6;
                                        if (zzev.zzc(xmlPullParserNewPullParser, "region")) {
                                            String strZza6 = zzev.zza(xmlPullParserNewPullParser, "id");
                                            if (strZza6 != null) {
                                                String strZza7 = zzev.zza(xmlPullParserNewPullParser, "origin");
                                                if (strZza7 == null && (strZza2 = zzev.zza(xmlPullParserNewPullParser, "style")) != null && (zzaldVar2 = (zzald) map.get(strZza2)) != null) {
                                                    strZza7 = zzaldVar2.zzI();
                                                }
                                                if (strZza7 != null) {
                                                    Matcher matcher3 = zzb.matcher(strZza7);
                                                    Matcher matcher4 = zzf.matcher(strZza7);
                                                    if (matcher3.matches()) {
                                                        try {
                                                            String strGroup5 = matcher3.group(1);
                                                            if (strGroup5 == null) {
                                                                throw null;
                                                            }
                                                            String str10 = strGroup5;
                                                            f2 = Float.parseFloat(strGroup5) / 100.0f;
                                                            String strGroup6 = matcher3.group(2);
                                                            if (strGroup6 == null) {
                                                                throw null;
                                                            }
                                                            String str11 = strGroup6;
                                                            f6 = Float.parseFloat(strGroup6);
                                                            f7 = 100.0f;
                                                            f = f6 / f7;
                                                        } catch (NumberFormatException unused5) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza7));
                                                            str2 = str9;
                                                        }
                                                    } else {
                                                        if (!matcher4.matches()) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza7));
                                                        } else if (zzakzVar2 == null) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza7));
                                                        } else {
                                                            try {
                                                                String strGroup7 = matcher4.group(1);
                                                                if (strGroup7 == null) {
                                                                    throw null;
                                                                }
                                                                String str12 = strGroup7;
                                                                int i17 = Integer.parseInt(strGroup7);
                                                                String strGroup8 = matcher4.group(2);
                                                                if (strGroup8 == null) {
                                                                    throw null;
                                                                }
                                                                String str13 = strGroup8;
                                                                int i18 = Integer.parseInt(strGroup8);
                                                                f2 = i17 / zzakzVar2.zza;
                                                                f6 = i18;
                                                                f7 = zzakzVar2.zzb;
                                                                f = f6 / f7;
                                                            } catch (NumberFormatException unused6) {
                                                                zzdx.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza7));
                                                                str2 = str9;
                                                            }
                                                        }
                                                        str2 = str9;
                                                        zzalbVar = null;
                                                    }
                                                } else {
                                                    f = 0.0f;
                                                    f2 = 0.0f;
                                                }
                                                float f9 = f2;
                                                String strZza8 = zzev.zza(xmlPullParserNewPullParser, "extent");
                                                if (strZza8 == null && (strZza = zzev.zza(xmlPullParserNewPullParser, "style")) != null && (zzaldVar = (zzald) map.get(strZza)) != null) {
                                                    strZza8 = zzaldVar.zzF();
                                                }
                                                if (strZza8 != null) {
                                                    Matcher matcher5 = zzb.matcher(strZza8);
                                                    str2 = str9;
                                                    Matcher matcher6 = zzf.matcher(strZza8);
                                                    if (matcher5.matches()) {
                                                        try {
                                                            String strGroup9 = matcher5.group(1);
                                                            if (strGroup9 == null) {
                                                                throw null;
                                                            }
                                                            String str14 = strGroup9;
                                                            float f10 = Float.parseFloat(strGroup9) / 100.0f;
                                                            String strGroup10 = matcher5.group(2);
                                                            if (strGroup10 == null) {
                                                                throw null;
                                                            }
                                                            String str15 = strGroup10;
                                                            f4 = Float.parseFloat(strGroup10) / 100.0f;
                                                            f3 = f10;
                                                        } catch (NumberFormatException unused7) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZza7)));
                                                            zzalbVar = null;
                                                        }
                                                    } else {
                                                        if (!matcher6.matches()) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(strZza7)));
                                                        } else if (zzakzVar2 == null) {
                                                            zzdx.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(String.valueOf(strZza7)));
                                                        } else {
                                                            try {
                                                                String strGroup11 = matcher6.group(1);
                                                                if (strGroup11 == null) {
                                                                    throw null;
                                                                }
                                                                String str16 = strGroup11;
                                                                int i19 = Integer.parseInt(strGroup11);
                                                                String strGroup12 = matcher6.group(2);
                                                                if (strGroup12 == null) {
                                                                    throw null;
                                                                }
                                                                String str17 = strGroup12;
                                                                int i20 = Integer.parseInt(strGroup12);
                                                                float f11 = i19 / zzakzVar2.zza;
                                                                f4 = i20 / zzakzVar2.zzb;
                                                                f3 = f11;
                                                            } catch (NumberFormatException unused8) {
                                                                zzdx.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZza7)));
                                                                zzalbVar = null;
                                                            }
                                                        }
                                                        zzalbVar = null;
                                                    }
                                                } else {
                                                    str2 = str9;
                                                    f3 = 1.0f;
                                                    f4 = 1.0f;
                                                }
                                                String strZza9 = zzev.zza(xmlPullParserNewPullParser, "displayAlign");
                                                if (strZza9 != null) {
                                                    String strZza10 = zzftc.zza(strZza9);
                                                    int iHashCode = strZza10.hashCode();
                                                    if (iHashCode != -1364013995) {
                                                        if (iHashCode == 92734940 && strZza10.equals("after")) {
                                                            b3 = 1;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                    } else if (strZza10.equals("center")) {
                                                        b3 = 0;
                                                    } else {
                                                        b3 = -1;
                                                    }
                                                    if (b3 == 0) {
                                                        f5 = f + (f4 / 2.0f);
                                                        i3 = 1;
                                                    } else if (b3 != 1) {
                                                        f5 = f;
                                                        i3 = 0;
                                                    } else {
                                                        f5 = f + f4;
                                                        i3 = 2;
                                                    }
                                                } else {
                                                    f5 = f;
                                                    i3 = 0;
                                                }
                                                float f12 = 1.0f / i15;
                                                String strZza11 = zzev.zza(xmlPullParserNewPullParser, "writingMode");
                                                if (strZza11 != null) {
                                                    String strZza12 = zzftc.zza(strZza11);
                                                    int iHashCode2 = strZza12.hashCode();
                                                    if (iHashCode2 != 3694) {
                                                        if (iHashCode2 != 3553396) {
                                                            if (iHashCode2 == 3553576 && strZza12.equals("tbrl")) {
                                                                b2 = 2;
                                                            } else {
                                                                b2 = -1;
                                                            }
                                                        } else if (strZza12.equals("tblr")) {
                                                            b2 = 1;
                                                        } else {
                                                            b2 = -1;
                                                        }
                                                    } else if (strZza12.equals("tb")) {
                                                        b2 = 0;
                                                    } else {
                                                        b2 = -1;
                                                    }
                                                    if (b2 == 0 || b2 == 1) {
                                                        i4 = 2;
                                                    } else if (b2 != 2) {
                                                        i4 = Integer.MIN_VALUE;
                                                    } else {
                                                        i4 = 1;
                                                    }
                                                } else {
                                                    i4 = Integer.MIN_VALUE;
                                                }
                                                zzalbVar = new zzalb(strZza6, f9, f5, 0, i3, f3, f4, 1, f12, i4);
                                            } else {
                                                str2 = str9;
                                                zzalbVar = null;
                                            }
                                            if (zzalbVar != null) {
                                                map2.put(zzalbVar.zza, zzalbVar);
                                            }
                                        } else if (zzev.zzc(xmlPullParserNewPullParser, str9)) {
                                            do {
                                                xmlPullParserNewPullParser.next();
                                                if (zzev.zzc(xmlPullParserNewPullParser, "image") && (strZza3 = zzev.zza(xmlPullParserNewPullParser, "id")) != null) {
                                                    map3.put(strZza3, xmlPullParserNewPullParser.nextText());
                                                }
                                            } while (!zzev.zzb(xmlPullParserNewPullParser, str9));
                                        }
                                        if (zzev.zzb(xmlPullParserNewPullParser, "head")) {
                                            zzakyVar = zzakyVar6;
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            zzakyVar6 = zzakyVar6;
                                            str9 = str2;
                                        }
                                    }
                                    str2 = str9;
                                    if (zzev.zzb(xmlPullParserNewPullParser, "head")) {
                                        zzakyVar = zzakyVar6;
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        zzakyVar6 = zzakyVar6;
                                        str9 = str2;
                                    }
                                }
                            } else {
                                zzaky zzakyVar7 = zzakyVar6;
                                try {
                                    attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                    zzald zzaldVarZzf2 = zzf(xmlPullParserNewPullParser, null);
                                    String str18 = str;
                                    int i21 = 0;
                                    long jZzc = -9223372036854775807L;
                                    long jZzc2 = -9223372036854775807L;
                                    long jZzc3 = -9223372036854775807L;
                                    String[] strArr = null;
                                    String strSubstring = null;
                                    while (i21 < attributeCount) {
                                        try {
                                            String attributeName = xmlPullParserNewPullParser.getAttributeName(i21);
                                            String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(i21);
                                            int i22 = attributeCount;
                                            switch (attributeName) {
                                                case "region":
                                                    b = 4;
                                                    break;
                                                case "dur":
                                                    b = 2;
                                                    break;
                                                case "end":
                                                    b = 1;
                                                    break;
                                                case "begin":
                                                    b = 0;
                                                    break;
                                                case "style":
                                                    b = 3;
                                                    break;
                                                case "backgroundImage":
                                                    b = 5;
                                                    break;
                                                default:
                                                    b = -1;
                                                    break;
                                            }
                                            if (b == 0) {
                                                zzakyVar2 = zzakyVar7;
                                                attributeCount = 1;
                                                jZzc2 = zzc(attributeValue6, zzakyVar2);
                                            } else if (b == 1) {
                                                attributeCount = 1;
                                                zzakyVar2 = zzakyVar7;
                                                jZzc = zzc(attributeValue6, zzakyVar2);
                                            } else if (b != 2) {
                                                if (b == 3) {
                                                    attributeCount = 1;
                                                    String[] strArrZzg2 = zzg(attributeValue6);
                                                    if (strArrZzg2.length > 0) {
                                                        strArr = strArrZzg2;
                                                    }
                                                } else if (b == 4) {
                                                    attributeCount = 1;
                                                    if (map2.containsKey(attributeValue6)) {
                                                        str18 = attributeValue6;
                                                    }
                                                } else if (b != 5) {
                                                    attributeCount = 1;
                                                } else {
                                                    try {
                                                        if (attributeValue6.startsWith("#")) {
                                                            attributeCount = 1;
                                                            try {
                                                                strSubstring = attributeValue6.substring(1);
                                                            } catch (zzajw e) {
                                                                e = e;
                                                                zzajwVar = e;
                                                                zzakyVar = zzakyVar7;
                                                                arrayDeque = arrayDeque2;
                                                                zzdx.zzg("TtmlParser", "Suppressing parser error", zzajwVar);
                                                                i6 = attributeCount;
                                                                i7 = i15;
                                                                zzakzVar = zzakzVar2;
                                                                zzakyVar4 = zzakyVar;
                                                                zzaleVar2 = zzaleVar;
                                                                xmlPullParserNewPullParser.next();
                                                                eventType = xmlPullParserNewPullParser.getEventType();
                                                                arrayDeque2 = arrayDeque;
                                                                str3 = str;
                                                                zzakyVar3 = zzakyVar3;
                                                                str4 = str4;
                                                            }
                                                        } else {
                                                            attributeCount = 1;
                                                        }
                                                    } catch (zzajw e2) {
                                                        e = e2;
                                                        attributeCount = 1;
                                                    }
                                                }
                                                zzakyVar2 = zzakyVar7;
                                            } else {
                                                zzakyVar2 = zzakyVar7;
                                                attributeCount = 1;
                                                jZzc3 = zzc(attributeValue6, zzakyVar2);
                                            }
                                            try {
                                                i21++;
                                                zzakyVar7 = zzakyVar2;
                                                attributeCount = i22;
                                            } catch (zzajw e3) {
                                                e = e3;
                                                zzajwVar = e;
                                                zzakyVar = zzakyVar2;
                                                arrayDeque = arrayDeque2;
                                                zzdx.zzg("TtmlParser", "Suppressing parser error", zzajwVar);
                                                i6 = attributeCount;
                                                i7 = i15;
                                                zzakzVar = zzakzVar2;
                                                zzakyVar4 = zzakyVar;
                                                zzaleVar2 = zzaleVar;
                                                xmlPullParserNewPullParser.next();
                                                eventType = xmlPullParserNewPullParser.getEventType();
                                                arrayDeque2 = arrayDeque;
                                                str3 = str;
                                                zzakyVar3 = zzakyVar3;
                                                str4 = str4;
                                            }
                                        } catch (zzajw e4) {
                                            e = e4;
                                            zzakyVar2 = zzakyVar7;
                                            attributeCount = 1;
                                        }
                                    }
                                    zzaky zzakyVar8 = zzakyVar7;
                                    attributeCount = 1;
                                    try {
                                        try {
                                            if (zzakxVar2 != null) {
                                                long j5 = zzakxVar2.zzd;
                                                if (j5 != -9223372036854775807L) {
                                                    j = jZzc2 != -9223372036854775807L ? jZzc2 + j5 : -9223372036854775807L;
                                                    if (jZzc != -9223372036854775807L) {
                                                        jZzc += j5;
                                                        zzakxVar = zzakxVar2;
                                                    } else {
                                                        zzakxVar = zzakxVar2;
                                                        j2 = -9223372036854775807L;
                                                        jZzc = -9223372036854775807L;
                                                    }
                                                    if (jZzc == j2) {
                                                        zzakyVar = zzakyVar8;
                                                        j3 = jZzc;
                                                    } else if (jZzc3 != j2) {
                                                        zzakyVar = zzakyVar8;
                                                        j3 = j + jZzc3;
                                                    } else {
                                                        if (zzakxVar != null) {
                                                            zzakyVar = zzakyVar8;
                                                            try {
                                                                j4 = zzakxVar.zze;
                                                                if (j4 != j2) {
                                                                    j3 = j4;
                                                                }
                                                            } catch (zzajw e5) {
                                                                zzajwVar = e5;
                                                                arrayDeque = arrayDeque2;
                                                                zzdx.zzg("TtmlParser", "Suppressing parser error", zzajwVar);
                                                                i6 = attributeCount;
                                                                i7 = i15;
                                                                zzakzVar = zzakzVar2;
                                                                zzakyVar4 = zzakyVar;
                                                                zzaleVar2 = zzaleVar;
                                                            }
                                                        } else {
                                                            zzakyVar = zzakyVar8;
                                                        }
                                                        j3 = j2;
                                                    }
                                                    zzakxVarZzb = zzakx.zzb(xmlPullParserNewPullParser.getName(), j, j3, zzaldVarZzf2, strArr, str18, strSubstring, zzakxVar);
                                                    arrayDeque = arrayDeque2;
                                                    arrayDeque.push(zzakxVarZzb);
                                                    if (zzakxVar2 != null) {
                                                        zzakxVar2.zzf(zzakxVarZzb);
                                                    }
                                                } else {
                                                    zzakxVar = zzakxVar2;
                                                    j = jZzc2;
                                                }
                                            } else {
                                                j = jZzc2;
                                                zzakxVar = null;
                                            }
                                            arrayDeque.push(zzakxVarZzb);
                                            if (zzakxVar2 != null) {
                                                zzakxVar2.zzf(zzakxVarZzb);
                                            }
                                        } catch (zzajw e6) {
                                            e = e6;
                                            zzajwVar = e;
                                            zzdx.zzg("TtmlParser", "Suppressing parser error", zzajwVar);
                                            i6 = attributeCount;
                                            i7 = i15;
                                            zzakzVar = zzakzVar2;
                                            zzakyVar4 = zzakyVar;
                                            zzaleVar2 = zzaleVar;
                                        }
                                        zzakxVarZzb = zzakx.zzb(xmlPullParserNewPullParser.getName(), j, j3, zzaldVarZzf2, strArr, str18, strSubstring, zzakxVar);
                                        arrayDeque = arrayDeque2;
                                    } catch (zzajw e7) {
                                        e = e7;
                                        arrayDeque = arrayDeque2;
                                    }
                                    j2 = -9223372036854775807L;
                                    if (jZzc == j2) {
                                        zzakyVar = zzakyVar8;
                                        j3 = jZzc;
                                    } else if (jZzc3 != j2) {
                                        zzakyVar = zzakyVar8;
                                        j3 = j + jZzc3;
                                    } else {
                                        if (zzakxVar != null) {
                                            zzakyVar = zzakyVar8;
                                            j4 = zzakxVar.zze;
                                            if (j4 != j2) {
                                                j3 = j4;
                                            }
                                        } else {
                                            zzakyVar = zzakyVar8;
                                        }
                                        j3 = j2;
                                    }
                                } catch (zzajw e8) {
                                    e = e8;
                                    zzakyVar = zzakyVar7;
                                    arrayDeque = arrayDeque2;
                                    attributeCount = 1;
                                }
                            }
                            i7 = i15;
                            zzakzVar = zzakzVar2;
                            zzakyVar4 = zzakyVar;
                        } else {
                            zzdx.zze("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            zzakyVar4 = zzakyVar6;
                            i7 = i15;
                            zzakzVar = zzakzVar2;
                            zzaleVar2 = zzaleVar;
                            arrayDeque = arrayDeque2;
                            i6 = 1;
                        }
                    } else {
                        str4 = str4;
                        zzakyVar3 = zzakyVar3;
                        zzaleVar = zzaleVar2;
                        i6 = i6;
                        arrayDeque = arrayDeque2;
                        if (eventType != 4) {
                            if (eventType == 3) {
                                if (xmlPullParserNewPullParser.getName().equals("tt")) {
                                    zzakx zzakxVar3 = (zzakx) arrayDeque.peek();
                                    if (zzakxVar3 == null) {
                                        throw null;
                                    }
                                    zzaleVar2 = new zzale(zzakxVar3, map, map2, map3);
                                } else {
                                    zzaleVar2 = zzaleVar;
                                }
                                arrayDeque.pop();
                            }
                            i6 = i6;
                        } else {
                            if (zzakxVar2 == null) {
                                throw null;
                            }
                            zzakxVar2.zzf(zzakx.zzc(xmlPullParserNewPullParser.getText()));
                        }
                    }
                    zzaleVar2 = zzaleVar;
                    i6 = i6;
                } else {
                    str = str3;
                    str4 = str4;
                    zzakyVar3 = zzakyVar3;
                    zzaleVar = zzaleVar2;
                    i6 = i6;
                    arrayDeque = arrayDeque2;
                    if (eventType == 2) {
                        i6++;
                    } else {
                        if (eventType == 3) {
                            i6--;
                        }
                        zzaleVar2 = zzaleVar;
                        i6 = i6;
                    }
                    zzaleVar2 = zzaleVar;
                }
                xmlPullParserNewPullParser.next();
                eventType = xmlPullParserNewPullParser.getEventType();
                arrayDeque2 = arrayDeque;
                str3 = str;
                zzakyVar3 = zzakyVar3;
                str4 = str4;
            }
            zzale zzaleVar3 = zzaleVar2;
            if (zzaleVar3 != null) {
                return zzaleVar3;
            }
            throw null;
        } catch (IOException e9) {
            throw new IllegalStateException("Unexpected error when reading input.", e9);
        } catch (XmlPullParserException e10) {
            throw new IllegalStateException("Unable to decode source", e10);
        }
    }

    public zzala() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
