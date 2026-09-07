package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.smaato.sdk.core.dns.DnsName;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdh {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    /* JADX WARN: Code duplicated, block: B:57:0x0110  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v64 int, still in use, count: 1, list:
  (r1v64 int) from 0x0061: IF  (r1v64 int) != (1567 int)  -> B:18:0x0063 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v64 int, still in use, count: 1, list:
  (r1v64 int) from 0x0061: IF  (r1v64 int) != (1567 int)  -> B:18:0x0063 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Pair zza(zzz zzzVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Pair pair;
        Integer num;
        Integer num2;
        String str = zzzVar.zzk;
        if (str != null) {
            String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
            int i7 = 3;
            int i8 = 2;
            if (!"video/dolby-vision".equals(zzzVar.zzo)) {
                switch (strArrSplit[0]) {
                    case "s263":
                        String str2 = zzzVar.zzk;
                        Pair pair2 = new Pair(1, 1);
                        if (strArrSplit.length < 3) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: ".concat(String.valueOf(str2)));
                            return pair2;
                        }
                        try {
                            return new Pair(Integer.valueOf(Integer.parseInt(strArrSplit[1])), Integer.valueOf(Integer.parseInt(strArrSplit[2])));
                        } catch (NumberFormatException unused) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: ".concat(String.valueOf(str2)));
                            return pair2;
                        }
                    case "avc1":
                    case "avc2":
                        String str3 = zzzVar.zzk;
                        int length = strArrSplit.length;
                        if (length < 2) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str3)));
                            break;
                        } else {
                            try {
                                if (strArrSplit[1].length() == 6) {
                                    i = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                                    i2 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                                } else if (length < 3) {
                                    zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str3);
                                } else {
                                    i = Integer.parseInt(strArrSplit[1]);
                                    i2 = Integer.parseInt(strArrSplit[2]);
                                }
                                if (i == 66) {
                                    i8 = 1;
                                } else if (i != 77) {
                                    if (i == 88) {
                                        i8 = 4;
                                    } else if (i == 100) {
                                        i8 = 8;
                                    } else if (i == 110) {
                                        i8 = 16;
                                    } else if (i != 122) {
                                        i8 = i != 244 ? -1 : 64;
                                    } else {
                                        i8 = 32;
                                    }
                                }
                                if (i8 == -1) {
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown AVC profile: " + i);
                                } else {
                                    switch (i2) {
                                        case 10:
                                            i3 = 1;
                                            break;
                                        case 11:
                                            i3 = 4;
                                            break;
                                        case 12:
                                            i3 = 8;
                                            break;
                                        case 13:
                                            i3 = 16;
                                            break;
                                        default:
                                            switch (i2) {
                                                case 20:
                                                    i3 = 32;
                                                    break;
                                                case 21:
                                                    i3 = 64;
                                                    break;
                                                case 22:
                                                    i3 = 128;
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 30:
                                                            i3 = 256;
                                                            break;
                                                        case 31:
                                                            i3 = 512;
                                                            break;
                                                        case 32:
                                                            i3 = 1024;
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 40:
                                                                    i3 = 2048;
                                                                    break;
                                                                case 41:
                                                                    i3 = 4096;
                                                                    break;
                                                                case 42:
                                                                    i3 = 8192;
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case 50:
                                                                            i3 = 16384;
                                                                            break;
                                                                        case 51:
                                                                            i3 = 32768;
                                                                            break;
                                                                        case 52:
                                                                            i3 = 65536;
                                                                            break;
                                                                        default:
                                                                            i3 = -1;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    if (i3 != -1) {
                                        return new Pair(Integer.valueOf(i8), Integer.valueOf(i3));
                                    }
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown AVC level: " + i2);
                                }
                            } catch (NumberFormatException unused2) {
                                zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str3)));
                            }
                            break;
                        }
                        break;
                    case "vp09":
                        String str4 = zzzVar.zzk;
                        if (strArrSplit.length < 3) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str4)));
                            break;
                        } else {
                            try {
                                int i9 = Integer.parseInt(strArrSplit[1]);
                                int i10 = Integer.parseInt(strArrSplit[2]);
                                if (i9 == 0) {
                                    i4 = 1;
                                } else if (i9 == 1) {
                                    i4 = 2;
                                } else if (i9 != 2) {
                                    i4 = i9 != 3 ? -1 : 8;
                                } else {
                                    i4 = 4;
                                }
                                if (i4 == -1) {
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown VP9 profile: " + i9);
                                } else {
                                    if (i10 == 10) {
                                        i8 = 1;
                                    } else if (i10 != 11) {
                                        if (i10 == 20) {
                                            i8 = 4;
                                        } else if (i10 == 21) {
                                            i8 = 8;
                                        } else if (i10 == 30) {
                                            i8 = 16;
                                        } else if (i10 == 31) {
                                            i8 = 32;
                                        } else if (i10 == 40) {
                                            i8 = 64;
                                        } else if (i10 == 41) {
                                            i8 = 128;
                                        } else if (i10 == 50) {
                                            i8 = 256;
                                        } else if (i10 != 51) {
                                            switch (i10) {
                                                case 60:
                                                    i8 = 2048;
                                                    break;
                                                case 61:
                                                    i8 = 4096;
                                                    break;
                                                case 62:
                                                    i8 = 8192;
                                                    break;
                                                default:
                                                    i8 = -1;
                                                    break;
                                            }
                                        } else {
                                            i8 = 512;
                                        }
                                    }
                                    if (i8 != -1) {
                                        return new Pair(Integer.valueOf(i4), Integer.valueOf(i8));
                                    }
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown VP9 level: " + i10);
                                }
                            } catch (NumberFormatException unused3) {
                                zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str4)));
                            }
                            break;
                        }
                        break;
                    case "hev1":
                    case "hvc1":
                        return zzb(zzzVar.zzk, strArrSplit, zzzVar.zzC);
                    case "av01":
                        String str5 = zzzVar.zzk;
                        zzk zzkVar = zzzVar.zzC;
                        if (strArrSplit.length < 4) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str5)));
                            break;
                        } else {
                            try {
                                int i11 = Integer.parseInt(strArrSplit[1]);
                                int i12 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                                int i13 = Integer.parseInt(strArrSplit[3]);
                                if (i11 != 0) {
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown AV1 profile: " + i11);
                                } else {
                                    if (i13 == 8) {
                                        i5 = 1;
                                    } else if (i13 != 10) {
                                        zzdx.zzf("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + i13);
                                    } else {
                                        i5 = (zzkVar == null || !(zzkVar.zze != null || (i6 = zzkVar.zzd) == 7 || i6 == 6)) ? 2 : 4096;
                                    }
                                    switch (i12) {
                                        case 0:
                                            i8 = 1;
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            i8 = 4;
                                            break;
                                        case 3:
                                            i8 = 8;
                                            break;
                                        case 4:
                                            i8 = 16;
                                            break;
                                        case 5:
                                            i8 = 32;
                                            break;
                                        case 6:
                                            i8 = 64;
                                            break;
                                        case 7:
                                            i8 = 128;
                                            break;
                                        case 8:
                                            i8 = 256;
                                            break;
                                        case 9:
                                            i8 = 512;
                                            break;
                                        case 10:
                                            i8 = 1024;
                                            break;
                                        case 11:
                                            i8 = 2048;
                                            break;
                                        case 12:
                                            i8 = 4096;
                                            break;
                                        case 13:
                                            i8 = 8192;
                                            break;
                                        case 14:
                                            i8 = 16384;
                                            break;
                                        case 15:
                                            i8 = 32768;
                                            break;
                                        case 16:
                                            i8 = 65536;
                                            break;
                                        case 17:
                                            i8 = 131072;
                                            break;
                                        case 18:
                                            i8 = 262144;
                                            break;
                                        case 19:
                                            i8 = 524288;
                                            break;
                                        case 20:
                                            i8 = 1048576;
                                            break;
                                        case 21:
                                            i8 = 2097152;
                                            break;
                                        case 22:
                                            i8 = 4194304;
                                            break;
                                        case 23:
                                            i8 = 8388608;
                                            break;
                                        default:
                                            i8 = -1;
                                            break;
                                    }
                                    if (i8 != -1) {
                                        return new Pair(Integer.valueOf(i5), Integer.valueOf(i8));
                                    }
                                    zzdx.zzf("CodecSpecificDataUtil", "Unknown AV1 level: " + i12);
                                }
                            } catch (NumberFormatException unused4) {
                                zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str5)));
                            }
                            break;
                        }
                        break;
                    case "mp4a":
                        if (strArrSplit.length != 3) {
                            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: ".concat(str));
                            break;
                        } else {
                            try {
                                if ("audio/mp4a-latm".equals(zzay.zzd(Integer.parseInt(strArrSplit[1], 16)))) {
                                    int i14 = Integer.parseInt(strArrSplit[2]);
                                    if (i14 == 17) {
                                        i7 = 17;
                                    } else if (i14 == 20) {
                                        i7 = 20;
                                    } else if (i14 == 23) {
                                        i7 = 23;
                                    } else if (i14 == 29) {
                                        i7 = 29;
                                    } else if (i14 == 39) {
                                        i7 = 39;
                                    } else if (i14 != 42) {
                                        switch (i14) {
                                            case 1:
                                                i7 = 1;
                                                break;
                                            case 2:
                                                i7 = 2;
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                i7 = 4;
                                                break;
                                            case 5:
                                                i7 = 5;
                                                break;
                                            case 6:
                                                i7 = 6;
                                                break;
                                            default:
                                                i7 = -1;
                                                break;
                                        }
                                    } else {
                                        i7 = 42;
                                    }
                                    if (i7 != -1) {
                                        pair = new Pair(Integer.valueOf(i7), 0);
                                        return pair;
                                    }
                                }
                            } catch (NumberFormatException unused5) {
                                zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: ".concat(str));
                            }
                            break;
                        }
                        break;
                }
            } else if (strArrSplit.length < 3) {
                zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
            } else {
                Matcher matcher = zzd.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup != null) {
                        if (strGroup.hashCode() != 1567) {
                            switch (strGroup) {
                                case "00":
                                    num = 1;
                                    break;
                                case "01":
                                    num = 2;
                                    break;
                                case "02":
                                    num = 4;
                                    break;
                                case "03":
                                    num = 8;
                                    break;
                                case "04":
                                    num = 16;
                                    break;
                                case "05":
                                    num = 32;
                                    break;
                                case "06":
                                    num = 64;
                                    break;
                                case "07":
                                    num = 128;
                                    break;
                                case "08":
                                    num = 256;
                                    break;
                                case "09":
                                    num = 512;
                                    break;
                                default:
                                    num = null;
                                    break;
                            }
                        } else if (strGroup.equals("10")) {
                            num = 1024;
                        } else {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num == null) {
                        zzdx.zzf("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(strGroup)));
                    } else {
                        String str6 = strArrSplit[2];
                        if (str6 != null) {
                            str6.hashCode();
                            switch (str6) {
                                case "01":
                                    num2 = 1;
                                    break;
                                case "02":
                                    num2 = 2;
                                    break;
                                case "03":
                                    num2 = 4;
                                    break;
                                case "04":
                                    num2 = 8;
                                    break;
                                case "05":
                                    num2 = 16;
                                    break;
                                case "06":
                                    num2 = 32;
                                    break;
                                case "07":
                                    num2 = 64;
                                    break;
                                case "08":
                                    num2 = 128;
                                    break;
                                case "09":
                                    num2 = 256;
                                    break;
                                default:
                                    switch (str6) {
                                        case 1567:
                                            if (!str6.equals("10")) {
                                                num2 = null;
                                            } else {
                                                num2 = 512;
                                            }
                                            break;
                                        case 1568:
                                            if (!str6.equals(Protocol.VAST_4_1)) {
                                                num2 = null;
                                            } else {
                                                num2 = 1024;
                                            }
                                            break;
                                        case 1569:
                                            if (!str6.equals(Protocol.VAST_4_1_WRAPPER)) {
                                                num2 = null;
                                            } else {
                                                num2 = 2048;
                                            }
                                            break;
                                        case 1570:
                                            if (!str6.equals(Protocol.VAST_4_2)) {
                                                num2 = null;
                                            } else {
                                                num2 = 4096;
                                            }
                                            break;
                                        default:
                                            num2 = null;
                                            break;
                                    }
                            }
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            pair = new Pair(num, num2);
                            return pair;
                        }
                        zzdx.zzf("CodecSpecificDataUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str6)));
                    }
                } else {
                    zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0196  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Pair zzb(String str, String[] strArr, zzk zzkVar) {
        int i;
        Integer num;
        if (strArr.length < 4) {
            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            zzdx.zzf("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String strGroup = matcher.group(1);
        byte b = 6;
        if ("1".equals(strGroup)) {
            i = 1;
        } else if ("2".equals(strGroup)) {
            i = (zzkVar == null || zzkVar.zzd != 6) ? 2 : 4096;
        } else {
            if (!"6".equals(strGroup)) {
                zzdx.zzf("CodecSpecificDataUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                return null;
            }
            i = 6;
        }
        String str2 = strArr[3];
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 70821:
                    if (!str2.equals("H30")) {
                        b = -1;
                    } else {
                        b = Ascii.CR;
                    }
                    break;
                case 70914:
                    if (!str2.equals("H60")) {
                        b = -1;
                    } else {
                        b = Ascii.SO;
                    }
                    break;
                case 70917:
                    if (!str2.equals("H63")) {
                        b = -1;
                    } else {
                        b = Ascii.SI;
                    }
                    break;
                case 71007:
                    if (!str2.equals("H90")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 71010:
                    if (!str2.equals("H93")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 74665:
                    if (!str2.equals("L30")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 74758:
                    if (!str2.equals("L60")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 74761:
                    if (!str2.equals("L63")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 74851:
                    if (!str2.equals("L90")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 74854:
                    if (!str2.equals("L93")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2193639:
                    if (!str2.equals("H120")) {
                        b = -1;
                    } else {
                        b = Ascii.DC2;
                    }
                    break;
                case 2193642:
                    if (!str2.equals("H123")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 2193732:
                    if (!str2.equals("H150")) {
                        b = -1;
                    } else {
                        b = Ascii.DC4;
                    }
                    break;
                case 2193735:
                    if (!str2.equals("H153")) {
                        b = -1;
                    } else {
                        b = Ascii.NAK;
                    }
                    break;
                case 2193738:
                    if (!str2.equals("H156")) {
                        b = -1;
                    } else {
                        b = Ascii.SYN;
                    }
                    break;
                case 2193825:
                    if (!str2.equals("H180")) {
                        b = -1;
                    } else {
                        b = Ascii.ETB;
                    }
                    break;
                case 2193828:
                    if (!str2.equals("H183")) {
                        b = -1;
                    } else {
                        b = Ascii.CAN;
                    }
                    break;
                case 2193831:
                    if (!str2.equals("H186")) {
                        b = -1;
                    } else {
                        b = Ascii.EM;
                    }
                    break;
                case 2312803:
                    if (!str2.equals("L120")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 2312806:
                    if (!str2.equals("L123")) {
                        b = -1;
                    }
                    break;
                case 2312896:
                    if (!str2.equals("L150")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 2312899:
                    if (!str2.equals("L153")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 2312902:
                    if (!str2.equals("L156")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 2312989:
                    if (!str2.equals("L180")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 2312992:
                    if (!str2.equals("L183")) {
                        b = -1;
                    } else {
                        b = Ascii.VT;
                    }
                    break;
                case 2312995:
                    if (!str2.equals("L186")) {
                        b = -1;
                    } else {
                        b = Ascii.FF;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    num = 1;
                    break;
                case 1:
                    num = 4;
                    break;
                case 2:
                    num = 16;
                    break;
                case 3:
                    num = 64;
                    break;
                case 4:
                    num = 256;
                    break;
                case 5:
                    num = 1024;
                    break;
                case 6:
                    num = 4096;
                    break;
                case 7:
                    num = 16384;
                    break;
                case 8:
                    num = 65536;
                    break;
                case 9:
                    num = 262144;
                    break;
                case 10:
                    num = 1048576;
                    break;
                case 11:
                    num = 4194304;
                    break;
                case 12:
                    num = 16777216;
                    break;
                case 13:
                    num = 2;
                    break;
                case 14:
                    num = 8;
                    break;
                case 15:
                    num = 32;
                    break;
                case 16:
                    num = 128;
                    break;
                case 17:
                    num = 512;
                    break;
                case 18:
                    num = 2048;
                    break;
                case 19:
                    num = 8192;
                    break;
                case 20:
                    num = 32768;
                    break;
                case 21:
                    num = 131072;
                    break;
                case 22:
                    num = 524288;
                    break;
                case 23:
                    num = 2097152;
                    break;
                case 24:
                    num = 8388608;
                    break;
                case 25:
                    num = 33554432;
                    break;
                default:
                    num = null;
                    break;
            }
        } else {
            num = null;
        }
        if (num != null) {
            return new Pair(Integer.valueOf(i), num);
        }
        zzdx.zzf("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(String.valueOf(str2)));
        return null;
    }

    public static String zzc(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzd(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        int i6 = zzeu.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i7 = 6;
        while (true) {
            if (i7 <= 0) {
                break;
            }
            int i8 = i7 - 1;
            if (iArr[i8] != 0) {
                break;
            }
            i7 = i8;
        }
        for (i5 = 0; i5 < i7; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static byte[] zze(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }
}
