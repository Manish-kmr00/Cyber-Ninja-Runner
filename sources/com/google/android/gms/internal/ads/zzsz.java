package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import com.json.b9;
import com.smaato.sdk.core.dns.DnsName;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzsz {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    private final boolean zzi;

    public static zzsz zzc(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (codecCapabilities == null || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
            z6 = false;
        } else {
            int i = zzeu.zza;
            z6 = true;
        }
        return new zzsz(str, str2, str3, codecCapabilities, z, z2, z3, z6, codecCapabilities != null && codecCapabilities.isFeatureSupported("tunneled-playback"), z5 || (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback")), (zzeu.zza < 35 || codecCapabilities == null || !codecCapabilities.isFeatureSupported("detached-surface") || Build.MANUFACTURER.equals("Xiaomi") || Build.MANUFACTURER.equals("OPPO")) ? false : true);
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzeu.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        zzdx.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + zzeu.zzb + b9.i.e);
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointZzi = zzi(videoCapabilities, i, i2);
        int i3 = pointZzi.x;
        int i4 = pointZzi.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0162 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:39:0x009e  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9 A[PHI: r5
  0x00a9: PHI (r5v4 int) = (r5v3 int), (r5v5 int) binds: [B:42:0x00a2, B:45:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:73:0x0102  */
    /* JADX WARN: Code duplicated, block: B:75:0x0107  */
    /* JADX WARN: Code duplicated, block: B:76:0x010a  */
    /* JADX WARN: Code duplicated, block: B:78:0x010f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0112  */
    /* JADX WARN: Code duplicated, block: B:82:0x0118  */
    /* JADX WARN: Code duplicated, block: B:84:0x011d  */
    /* JADX WARN: Code duplicated, block: B:85:0x011f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0124  */
    /* JADX WARN: Code duplicated, block: B:88:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x0138  */
    /* JADX WARN: Code duplicated, block: B:94:0x013e  */
    private final boolean zzl(zzz zzzVar, boolean z) {
        int iIntValue;
        int iIntValue2;
        int i;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzh;
        int length;
        int i2;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        int iIntValue3;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str;
        int iHashCode;
        int i3 = zztt.zza;
        Pair pairZza = zzdh.zza(zzzVar);
        String str2 = zzzVar.zzo;
        byte b = -1;
        if (str2 != null && str2.equals("video/mv-hevc")) {
            String strZze = zzay.zze(this.zzc);
            if (!strZze.equals("video/mv-hevc")) {
                if (strZze.equals("video/hevc")) {
                    String strZzh = zzfq.zzh(zzzVar.zzr);
                    if (strZzh == null) {
                        pairZza = null;
                    } else {
                        String strTrim = strZzh.trim();
                        int i4 = zzeu.zza;
                        pairZza = zzdh.zzb(strZzh, strTrim.split(DnsName.ESCAPED_DOT, -1), zzzVar.zzC);
                    }
                }
                if (pairZza != null) {
                    iIntValue = ((Integer) pairZza.first).intValue();
                    iIntValue2 = ((Integer) pairZza.second).intValue();
                    i = 8;
                    if ("video/dolby-vision".equals(str2)) {
                        str = this.zzb;
                        iHashCode = str.hashCode();
                        if (iHashCode != -1662735862) {
                            if (iHashCode != -1662541442) {
                                if (iHashCode == 1331836730) {
                                    b = 0;
                                }
                            } else if (str.equals("video/hevc")) {
                                b = 1;
                            }
                        } else if (str.equals("video/av01")) {
                            b = 2;
                        }
                        if (b == 0) {
                            if (b != 1) {
                            }
                            iIntValue = 2;
                        } else {
                            iIntValue = 8;
                        }
                        iIntValue2 = 0;
                    }
                    if (this.zzi) {
                        codecProfileLevelArrZzh = zzh();
                        if (zzeu.zza <= 23) {
                            codecCapabilities = this.zzd;
                            if (codecCapabilities != null) {
                                iIntValue3 = 0;
                            } else {
                                iIntValue3 = 0;
                            }
                            if (iIntValue3 >= 180000000) {
                                i = 1024;
                            } else if (iIntValue3 >= 120000000) {
                                i = 512;
                            } else if (iIntValue3 >= 60000000) {
                                i = 256;
                            } else if (iIntValue3 >= 30000000) {
                                i = 128;
                            } else if (iIntValue3 >= 18000000) {
                                i = 64;
                            } else if (iIntValue3 >= 12000000) {
                                i = 32;
                            } else if (iIntValue3 >= 7200000) {
                                i = 16;
                            } else if (iIntValue3 < 3600000) {
                                if (iIntValue3 >= 1800000) {
                                    i = 4;
                                } else if (iIntValue3 >= 800000) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                            }
                            MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = new MediaCodecInfo.CodecProfileLevel();
                            codecProfileLevel2.profile = 1;
                            codecProfileLevel2.level = i;
                            codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel2};
                        }
                        length = codecProfileLevelArrZzh.length;
                        for (i2 = 0; i2 < length; i2++) {
                            codecProfileLevel = codecProfileLevelArrZzh[i2];
                            if (codecProfileLevel.profile == iIntValue) {
                            }
                        }
                        zzj("codec.profileLevel, " + zzzVar.zzk + ", " + this.zzc);
                        return false;
                    }
                    if (iIntValue == 42) {
                        iIntValue = 42;
                        codecProfileLevelArrZzh = zzh();
                        if (zzeu.zza <= 23) {
                            codecCapabilities = this.zzd;
                            if (codecCapabilities != null) {
                                iIntValue3 = 0;
                            } else {
                                iIntValue3 = 0;
                            }
                            if (iIntValue3 >= 180000000) {
                                i = 1024;
                            } else if (iIntValue3 >= 120000000) {
                                i = 512;
                            } else if (iIntValue3 >= 60000000) {
                                i = 256;
                            } else if (iIntValue3 >= 30000000) {
                                i = 128;
                            } else if (iIntValue3 >= 18000000) {
                                i = 64;
                            } else if (iIntValue3 >= 12000000) {
                                i = 32;
                            } else if (iIntValue3 >= 7200000) {
                                i = 16;
                            } else if (iIntValue3 < 3600000) {
                                if (iIntValue3 >= 1800000) {
                                    i = 4;
                                } else if (iIntValue3 >= 800000) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                            }
                            MediaCodecInfo.CodecProfileLevel codecProfileLevel3 = new MediaCodecInfo.CodecProfileLevel();
                            codecProfileLevel3.profile = 1;
                            codecProfileLevel3.level = i;
                            codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel3};
                        }
                        length = codecProfileLevelArrZzh.length;
                        while (i2 < length) {
                            codecProfileLevel = codecProfileLevelArrZzh[i2];
                            if (codecProfileLevel.profile == iIntValue) {
                            }
                        }
                        zzj("codec.profileLevel, " + zzzVar.zzk + ", " + this.zzc);
                        return false;
                    }
                }
            }
        } else if (pairZza != null) {
            iIntValue = ((Integer) pairZza.first).intValue();
            iIntValue2 = ((Integer) pairZza.second).intValue();
            i = 8;
            if ("video/dolby-vision".equals(str2)) {
                str = this.zzb;
                iHashCode = str.hashCode();
                if (iHashCode != -1662735862) {
                    if (iHashCode != -1662541442) {
                        if (iHashCode == 1331836730 && str.equals("video/avc")) {
                            b = 0;
                        }
                    } else if (str.equals("video/hevc")) {
                        b = 1;
                    }
                } else if (str.equals("video/av01")) {
                    b = 2;
                }
                if (b == 0) {
                    iIntValue = 8;
                } else if (b != 1 || b == 2) {
                    iIntValue = 2;
                }
                iIntValue2 = 0;
            }
            if (this.zzi) {
                codecProfileLevelArrZzh = zzh();
                if (zzeu.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && codecProfileLevelArrZzh.length == 0) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                        iIntValue3 = 0;
                    } else {
                        iIntValue3 = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    }
                    if (iIntValue3 >= 180000000) {
                        i = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i = 16;
                    } else if (iIntValue3 < 3600000) {
                        if (iIntValue3 >= 1800000) {
                            i = 4;
                        } else if (iIntValue3 >= 800000) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel4 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel4.profile = 1;
                    codecProfileLevel4.level = i;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel4};
                }
                length = codecProfileLevelArrZzh.length;
                while (i2 < length) {
                    codecProfileLevel = codecProfileLevelArrZzh[i2];
                    if (codecProfileLevel.profile == iIntValue || ((codecProfileLevel.level < iIntValue2 && z) || ("video/hevc".equals(this.zzb) && iIntValue == 2 && ("sailfish".equals(Build.DEVICE) || "marlin".equals(Build.DEVICE))))) {
                    }
                }
                zzj("codec.profileLevel, " + zzzVar.zzk + ", " + this.zzc);
                return false;
            }
            if (iIntValue == 42) {
                iIntValue = 42;
                codecProfileLevelArrZzh = zzh();
                if (zzeu.zza <= 23) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null) {
                        iIntValue3 = 0;
                    } else {
                        iIntValue3 = 0;
                    }
                    if (iIntValue3 >= 180000000) {
                        i = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i = 16;
                    } else if (iIntValue3 < 3600000) {
                        if (iIntValue3 >= 1800000) {
                            i = 4;
                        } else if (iIntValue3 >= 800000) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel5 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel5.profile = 1;
                    codecProfileLevel5.level = i;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel5};
                }
                length = codecProfileLevelArrZzh.length;
                while (i2 < length) {
                    codecProfileLevel = codecProfileLevelArrZzh[i2];
                    if (codecProfileLevel.profile == iIntValue) {
                    }
                }
                zzj("codec.profileLevel, " + zzzVar.zzk + ", " + this.zzc);
                return false;
            }
        }
        return true;
    }

    private final boolean zzm(zzz zzzVar) {
        return (Objects.equals(zzzVar.zzo, "audio/flac") && zzzVar.zzG == 22 && zzeu.zza < 34 && this.zza.equals("c2.android.flac.decoder")) ? false : true;
    }

    private final boolean zzn(zzz zzzVar) {
        String str = this.zzb;
        return str.equals(zzzVar.zzo) || str.equals(zztt.zzb(zzzVar));
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zzhz zzb(zzz zzzVar, zzz zzzVar2) {
        int i = true != Objects.equals(zzzVar.zzo, zzzVar2.zzo) ? 8 : 0;
        if (this.zzi) {
            if (zzzVar.zzy != zzzVar2.zzy) {
                i |= 1024;
            }
            if (!this.zze && (zzzVar.zzv != zzzVar2.zzv || zzzVar.zzw != zzzVar2.zzw)) {
                i |= 512;
            }
            zzk zzkVar = zzzVar.zzC;
            if ((!zzk.zzg(zzkVar) || !zzk.zzg(zzzVar2.zzC)) && !Objects.equals(zzkVar, zzzVar2.zzC)) {
                i |= 2048;
            }
            String str = this.zza;
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzzVar.zzd(zzzVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzhz(str, zzzVar, zzzVar2, true != zzzVar.zzd(zzzVar2) ? 2 : 3, 0);
            }
        } else {
            if (zzzVar.zzE != zzzVar2.zzE) {
                i |= 4096;
            }
            if (zzzVar.zzF != zzzVar2.zzF) {
                i |= 8192;
            }
            if (zzzVar.zzG != zzzVar2.zzG) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                int i2 = zztt.zza;
                Pair pairZza = zzdh.zza(zzzVar);
                Pair pairZza2 = zzdh.zza(zzzVar2);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzhz(this.zza, zzzVar, zzzVar2, 3, 0);
                    }
                }
            }
            if (!zzzVar.zzd(zzzVar2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzhz(this.zza, zzzVar, zzzVar2, 1, 0);
            }
        }
        return new zzhz(this.zza, zzzVar, zzzVar2, 0, i);
    }

    public final boolean zzd(zzz zzzVar) {
        return zzn(zzzVar) && zzl(zzzVar, false) && zzm(zzzVar);
    }

    public final boolean zze(zzz zzzVar) throws zztn {
        int i;
        int i2;
        if (!zzn(zzzVar) || !zzl(zzzVar, true) || !zzm(zzzVar)) {
            return false;
        }
        if (this.zzi) {
            int i3 = zzzVar.zzv;
            if (i3 <= 0 || (i2 = zzzVar.zzw) <= 0) {
                return true;
            }
            return zzg(i3, i2, zzzVar.zzx);
        }
        int i4 = zzzVar.zzF;
        if (i4 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i4)) {
                zzj("sampleRate.support, " + i4);
                return false;
            }
        }
        int i5 = zzzVar.zzE;
        if (i5 == -1) {
            return true;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
        if (codecCapabilities2 == null) {
            zzj("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
        if (audioCapabilities2 == null) {
            zzj("channelCount.aCaps");
            return false;
        }
        String str = this.zza;
        String str2 = this.zzb;
        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((zzeu.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
            if ("audio/ac3".equals(str2)) {
                i = 6;
            } else {
                i = "audio/eac3".equals(str2) ? 16 : 30;
            }
            zzdx.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + b9.i.e);
            maxInputChannelCount = i;
        }
        if (maxInputChannelCount >= i5) {
            return true;
        }
        zzj("channelCount.support, " + i5);
        return false;
    }

    public final boolean zzf(zzz zzzVar) {
        if (this.zzi) {
            return this.zze;
        }
        int i = zztt.zza;
        Pair pairZza = zzdh.zza(zzzVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    public final boolean zzg(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzeu.zza >= 29) {
            int iZza = zztb.zza(videoCapabilities, i, i2, d);
            if (iZza != 2) {
                if (iZza == 1) {
                    zzj("sizeAndRate.cover, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d);
                    return false;
                }
                if (!zzk(videoCapabilities, i, i2, d)) {
                    if (i < i2) {
                        str = this.zza;
                        if ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str)) {
                            zzdx.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d) + "] [" + str + ", " + this.zzb + "] [" + zzeu.zzb + b9.i.e);
                        } else {
                            zzdx.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d) + "] [" + str + ", " + this.zzb + "] [" + zzeu.zzb + b9.i.e);
                        }
                    }
                    zzj("sizeAndRate.support, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d);
                    return false;
                }
            }
        } else if (!zzk(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                str = this.zza;
                if (("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Build.DEVICE)) && zzk(videoCapabilities, i2, i, d)) {
                    zzdx.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d) + "] [" + str + ", " + this.zzb + "] [" + zzeu.zzb + b9.i.e);
                }
            }
            zzj("sizeAndRate.support, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d);
            return false;
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecCapabilities.profileLevels;
    }

    zzsz(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = z7;
        this.zzi = zzay.zzj(str2);
    }
}
