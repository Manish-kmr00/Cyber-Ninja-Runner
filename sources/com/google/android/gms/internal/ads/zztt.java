package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zztt {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzsz zza() throws zztn {
        List listZzd = zzd("audio/raw", false, false);
        if (listZzd.isEmpty()) {
            return null;
        }
        return (zzsz) listZzd.get(0);
    }

    public static String zzb(zzz zzzVar) {
        Pair pairZza;
        String str = zzzVar.zzo;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (pairZza = zzdh.zza(zzzVar)) != null) {
            int iIntValue = ((Integer) pairZza.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    public static List zzc(zzti zztiVar, zzz zzzVar, boolean z, boolean z2) throws zztn {
        String strZzb = zzb(zzzVar);
        return strZzb == null ? zzfww.zzn() : zztiVar.zza(strZzb, z, z2);
    }

    public static synchronized List zzd(String str, boolean z, boolean z2) throws zztn {
        zztm zztmVar = new zztm(str, z, z2);
        HashMap map = zzb;
        List list = (List) map.get(zztmVar);
        if (list != null) {
            return list;
        }
        ArrayList arrayListZzg = zzg(zztmVar, new zztq(z, z2, str.equals("video/mv-hevc")));
        if (z && arrayListZzg.isEmpty() && zzeu.zza <= 23) {
            arrayListZzg = zzg(zztmVar, new zztp(null));
            if (!arrayListZzg.isEmpty()) {
                zzdx.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsz) arrayListZzg.get(0)).zza);
            }
        }
        if ("audio/raw".equals(str)) {
            if (zzeu.zza < 26 && Build.DEVICE.equals("R9") && arrayListZzg.size() == 1 && ((zzsz) arrayListZzg.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListZzg.add(zzsz.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            zzh(arrayListZzg, new zztr() { // from class: com.google.android.gms.internal.ads.zztk
                @Override // com.google.android.gms.internal.ads.zztr
                public final int zza(Object obj) {
                    int i = zztt.zza;
                    String str2 = ((zzsz) obj).zza;
                    if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                        return 1;
                    }
                    return (zzeu.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                }
            });
        }
        if (zzeu.zza < 32 && arrayListZzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsz) arrayListZzg.get(0)).zza)) {
            arrayListZzg.add((zzsz) arrayListZzg.remove(0));
        }
        zzfww zzfwwVarZzl = zzfww.zzl(arrayListZzg);
        map.put(zztmVar, zzfwwVarZzl);
        return zzfwwVarZzl;
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zze(zzti zztiVar, zzz zzzVar, boolean z, boolean z2) throws zztn {
        List listZza = zztiVar.zza(zzzVar.zzo, z, z2);
        List listZzc = zzc(zztiVar, zzzVar, z, z2);
        int i = zzfww.zzd;
        zzfwt zzfwtVar = new zzfwt();
        zzfwtVar.zzh(listZza);
        zzfwtVar.zzh(listZzc);
        return zzfwtVar.zzi();
    }

    public static List zzf(List list, final zzz zzzVar) {
        ArrayList arrayList = new ArrayList(list);
        zzh(arrayList, new zztr() { // from class: com.google.android.gms.internal.ads.zztl
            @Override // com.google.android.gms.internal.ads.zztr
            public final int zza(Object obj) {
                int i = zztt.zza;
                return ((zzsz) obj).zzd(zzzVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018e  */
    /* JADX WARN: Code duplicated, block: B:101:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0192  */
    /* JADX WARN: Code duplicated, block: B:105:0x0197 A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:91:0x0175, B:97:0x0180, B:105:0x0197, B:110:0x01a9, B:112:0x01b1, B:113:0x01b6, B:115:0x01c6, B:117:0x01ce, B:106:0x019e), top: B:166:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x019e A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:91:0x0175, B:97:0x0180, B:105:0x0197, B:110:0x01a9, B:112:0x01b1, B:113:0x01b6, B:115:0x01c6, B:117:0x01ce, B:106:0x019e), top: B:166:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:112:0x01b1 A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:91:0x0175, B:97:0x0180, B:105:0x0197, B:110:0x01a9, B:112:0x01b1, B:113:0x01b6, B:115:0x01c6, B:117:0x01ce, B:106:0x019e), top: B:166:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01b6 A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:91:0x0175, B:97:0x0180, B:105:0x0197, B:110:0x01a9, B:112:0x01b1, B:113:0x01b6, B:115:0x01c6, B:117:0x01ce, B:106:0x019e), top: B:166:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x01c6 A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:91:0x0175, B:97:0x0180, B:105:0x0197, B:110:0x01a9, B:112:0x01b1, B:113:0x01b6, B:115:0x01c6, B:117:0x01ce, B:106:0x019e), top: B:166:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:122:0x01dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x01de  */
    /* JADX WARN: Code duplicated, block: B:124:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:126:0x01e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:133:0x0210 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:180:0x0293 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0126 A[EDGE_INSN: B:70:0x0126->B:88:0x0165 BREAK  A[LOOP:1: B:48:0x00d5->B:52:0x00e2]] */
    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    private static ArrayList zzg(zztm zztmVar, zzto zztoVar) throws zztn {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        int i3;
        String str5;
        boolean zZzd;
        boolean z;
        boolean zIsHardwareAccelerated;
        boolean zZzi;
        String strZza;
        boolean zIsVendor;
        boolean z2;
        zztm zztmVar2 = zztmVar;
        String str6 = "tunneled-playback";
        try {
            ArrayList arrayList = new ArrayList();
            String str7 = zztmVar2.zza;
            boolean zZze = zztoVar.zze();
            int i4 = 0;
            for (int iZza = zztoVar.zza(); i4 < iZza; iZza = i3) {
                MediaCodecInfo mediaCodecInfoZzb = zztoVar.zzb(i4);
                int i5 = zzeu.zza;
                if (i5 < 29 || !mediaCodecInfoZzb.isAlias()) {
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || ((!zZze && name.endsWith(".secure")) || ((i5 < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && Constants.REFERRER_API_SAMSUNG.equals(Build.MANUFACTURER) && (Build.DEVICE.startsWith("zeroflte") || Build.DEVICE.startsWith("zerolte") || Build.DEVICE.startsWith("zenlte") || "SC-05G".equals(Build.DEVICE) || "marinelteatt".equals(Build.DEVICE) || "404SC".equals(Build.DEVICE) || "SC-04G".equals(Build.DEVICE) || "SCV31".equals(Build.DEVICE)))) || ((i = zzeu.zza) <= 23 && "audio/eac3-joc".equals(str7) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name))))) {
                        str3 = str6;
                        i2 = i4;
                        i3 = iZza;
                        str5 = str7;
                    } else {
                        String[] supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 < length) {
                                str = supportedTypes[i6];
                                if (!str.equalsIgnoreCase(str7)) {
                                    i6++;
                                }
                            } else if (str7.equals("video/dolby-vision")) {
                                if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    if (!"OMX.RTK.video.decoder".equals(name) && !"OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str2 = null;
                                        break;
                                    }
                                    str = "video/dv_hevc";
                                } else {
                                    str = "video/hevcdv";
                                }
                            } else if (str7.equals("video/mv-hevc")) {
                                if (!"c2.qti.mvhevc.decoder".equals(name) && !"c2.qti.mvhevc.decoder.secure".equals(name)) {
                                    str2 = null;
                                    break;
                                }
                                str = "video/x-mvhevc";
                            } else if (str7.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
                                str = "audio/x-lg-alac";
                            } else if (str7.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
                                str = "audio/x-lg-flac";
                            } else {
                                if (!str7.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(name)) {
                                    str2 = null;
                                    break;
                                }
                                str = "audio/lg-ac3";
                            }
                            str2 = str;
                            break;
                        }
                        if (str2 != null) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str2);
                                boolean zZzd2 = zztoVar.zzd(str6, str2, capabilitiesForType);
                                boolean zZzc = zztoVar.zzc(str6, str2, capabilitiesForType);
                                str3 = str6;
                                try {
                                    if (zztmVar2.zzc) {
                                        if (zZzd2) {
                                            zZzd = zztoVar.zzd("secure-playback", str2, capabilitiesForType);
                                            boolean zZzc2 = zztoVar.zzc("secure-playback", str2, capabilitiesForType);
                                            z = zztmVar2.zzb;
                                            if (z) {
                                                if (z) {
                                                    if (zZzd) {
                                                        zZzd = true;
                                                    }
                                                }
                                                if (i >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzi(mediaCodecInfoZzb, str7)) {
                                                    zIsHardwareAccelerated = false;
                                                } else {
                                                    zIsHardwareAccelerated = true;
                                                }
                                                zZzi = zzi(mediaCodecInfoZzb, str7);
                                                if (i >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzftc.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (!zZze) {
                                                    z2 = zZzd;
                                                } else if (z != zZzd) {
                                                    z2 = true;
                                                } else {
                                                    i2 = i4;
                                                    i3 = iZza;
                                                    str5 = str7;
                                                    arrayList.add(zzsz.zzc(name, str7, str2, capabilitiesForType, zIsHardwareAccelerated, zZzi, zIsVendor, false, false));
                                                }
                                                if (zZze) {
                                                }
                                                i2 = i4;
                                                i3 = iZza;
                                                str5 = str7;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (z) {
                                                    if (zZzd) {
                                                        zZzd = true;
                                                    }
                                                }
                                                if (i >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzi(mediaCodecInfoZzb, str7)) {
                                                    zIsHardwareAccelerated = true;
                                                } else {
                                                    zIsHardwareAccelerated = false;
                                                }
                                                zZzi = zzi(mediaCodecInfoZzb, str7);
                                                if (i >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzftc.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (!zZze) {
                                                    z2 = zZzd;
                                                } else if (z != zZzd) {
                                                    z2 = true;
                                                } else {
                                                    i2 = i4;
                                                    i3 = iZza;
                                                    str5 = str7;
                                                    arrayList.add(zzsz.zzc(name, str7, str2, capabilitiesForType, zIsHardwareAccelerated, zZzi, zIsVendor, false, false));
                                                }
                                                if (zZze) {
                                                }
                                                i2 = i4;
                                                i3 = iZza;
                                                str5 = str7;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } else if (!zZzc) {
                                        zZzd = zztoVar.zzd("secure-playback", str2, capabilitiesForType);
                                        boolean zZzc3 = zztoVar.zzc("secure-playback", str2, capabilitiesForType);
                                        z = zztmVar2.zzb;
                                        if (z || !zZzc3) {
                                            if (z) {
                                                if (zZzd) {
                                                    zZzd = true;
                                                }
                                            }
                                            if (i >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str7)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str7);
                                            if (i >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzftc.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = true;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd;
                                            } else if (z != zZzd) {
                                                z2 = true;
                                            } else {
                                                i2 = i4;
                                                i3 = iZza;
                                                str5 = str7;
                                                arrayList.add(zzsz.zzc(name, str7, str2, capabilitiesForType, zIsHardwareAccelerated, zZzi, zIsVendor, false, false));
                                            }
                                            if (!zZze || z) {
                                                i2 = i4;
                                                i3 = iZza;
                                                str5 = str7;
                                                if (zZze && z2) {
                                                    try {
                                                        StringBuilder sb = new StringBuilder();
                                                        try {
                                                            sb.append(name);
                                                            sb.append(".secure");
                                                            str4 = name;
                                                            try {
                                                                arrayList.add(zzsz.zzc(sb.toString(), str5, str2, capabilitiesForType, zIsHardwareAccelerated, zZzi, zIsVendor, false, true));
                                                                break;
                                                            } catch (Exception e) {
                                                                e = e;
                                                                if (zzeu.zza <= 23) {
                                                                }
                                                                zzdx.zzc("MediaCodecUtil", "Failed to query codec " + str4 + " (" + str2 + ")");
                                                                throw e;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            str4 = name;
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str4 = name;
                                                    }
                                                }
                                            } else {
                                                i2 = i4;
                                                i3 = iZza;
                                                str5 = str7;
                                                arrayList.add(zzsz.zzc(name, str7, str2, capabilitiesForType, zIsHardwareAccelerated, zZzi, zIsVendor, false, false));
                                            }
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    str4 = name;
                                    i2 = i4;
                                    i3 = iZza;
                                    str5 = str7;
                                    if (zzeu.zza <= 23 || arrayList.isEmpty()) {
                                        zzdx.zzc("MediaCodecUtil", "Failed to query codec " + str4 + " (" + str2 + ")");
                                        throw e;
                                    }
                                    zzdx.zzc("MediaCodecUtil", "Skipping codec " + str4 + " (failed to query capabilities)");
                                    i4 = i2 + 1;
                                    zztmVar2 = zztmVar;
                                    str7 = str5;
                                    str6 = str3;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str3 = str6;
                            }
                        } else {
                            str3 = str6;
                        }
                        i2 = i4;
                        i3 = iZza;
                        str5 = str7;
                    }
                } else {
                    str3 = str6;
                    i2 = i4;
                    i3 = iZza;
                    str5 = str7;
                }
                i4 = i2 + 1;
                zztmVar2 = zztmVar;
                str7 = str5;
                str6 = str3;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new zztn(e6, null);
        }
    }

    private static void zzh(List list, final zztr zztrVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zztt.zza;
                zztr zztrVar2 = zztrVar;
                return zztrVar2.zza(obj2) - zztrVar2.zza(obj);
            }
        });
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzeu.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzay.zzh(str)) {
            return true;
        }
        String strZza = zzftc.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}
