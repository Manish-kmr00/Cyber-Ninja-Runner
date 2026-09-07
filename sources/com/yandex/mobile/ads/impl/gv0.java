package com.yandex.mobile.ads.impl;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes11.dex */
public final class gv0 {
    private static final hv0 i = jm1.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9037a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final boolean h;

    gv0(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        this.f9037a = (String) hg.a(str);
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.g = z;
        this.e = z2;
        this.f = z3;
        this.h = s01.f(str2);
    }

    public final String toString() {
        return this.f9037a;
    }

    public final boolean b(gc0 gc0Var) {
        if (this.h) {
            return this.e;
        }
        Pair<Integer, Integer> pairB = ov0.b(gc0Var);
        return pairB != null && ((Integer) pairB.first).intValue() == 42;
    }

    public final Point a(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i4 = x82.f10629a;
        return new Point((((i2 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i3 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    public final qy a(gc0 gc0Var, gc0 gc0Var2) {
        int i2 = !x82.a(gc0Var.m, gc0Var2.m) ? 8 : 0;
        if (this.h) {
            if (gc0Var.u != gc0Var2.u) {
                i2 |= 1024;
            }
            if (!this.e && (gc0Var.r != gc0Var2.r || gc0Var.s != gc0Var2.s)) {
                i2 |= 512;
            }
            if (!x82.a(gc0Var.y, gc0Var2.y)) {
                i2 |= 2048;
            }
            String str = this.f9037a;
            String str2 = x82.d;
            hv0 hv0Var = i;
            if (str2.startsWith(hv0Var.i()) && hv0Var.g().equals(str) && !gc0Var.a(gc0Var2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new qy(this.f9037a, gc0Var, gc0Var2, gc0Var.a(gc0Var2) ? 3 : 2, 0);
            }
        } else {
            if (gc0Var.z != gc0Var2.z) {
                i2 |= 4096;
            }
            if (gc0Var.A != gc0Var2.A) {
                i2 |= 8192;
            }
            if (gc0Var.B != gc0Var2.B) {
                i2 |= 16384;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair<Integer, Integer> pairB = ov0.b(gc0Var);
                Pair<Integer, Integer> pairB2 = ov0.b(gc0Var2);
                if (pairB != null && pairB2 != null) {
                    int iIntValue = ((Integer) pairB.first).intValue();
                    int iIntValue2 = ((Integer) pairB2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new qy(this.f9037a, gc0Var, gc0Var2, 3, 0);
                    }
                }
            }
            if (!gc0Var.a(gc0Var2)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(this.b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new qy(this.f9037a, gc0Var, gc0Var2, 1, 0);
            }
        }
        return new qy(this.f9037a, gc0Var, gc0Var2, 0, i2);
    }

    public final boolean a(gc0 gc0Var) throws ov0.b {
        int i2;
        Pair<Integer, Integer> pairB;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (!this.b.equals(gc0Var.m) && !this.b.equals(ov0.a(gc0Var))) {
            return false;
        }
        int i3 = 16;
        if (gc0Var.j != null && (pairB = ov0.b(gc0Var)) != null) {
            int iIntValue = ((Integer) pairB.first).intValue();
            int iIntValue2 = ((Integer) pairB.second).intValue();
            int i4 = 8;
            if ("video/dolby-vision".equals(gc0Var.m)) {
                if ("video/avc".equals(this.b)) {
                    iIntValue2 = 0;
                    iIntValue = 8;
                } else if ("video/hevc".equals(this.b)) {
                    iIntValue2 = 0;
                    iIntValue = 2;
                }
            }
            if (this.h || iIntValue == 42) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                if (x82.f10629a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && codecProfileLevelArr.length == 0) {
                    MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.d;
                    int iIntValue3 = (codecCapabilities2 == null || (videoCapabilities = codecCapabilities2.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    if (iIntValue3 >= 180000000) {
                        i4 = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i4 = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i4 = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i4 = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i4 = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i4 = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i4 = 16;
                    } else if (iIntValue3 < 3600000) {
                        if (iIntValue3 >= 1800000) {
                            i4 = 4;
                        } else {
                            i4 = iIntValue3 >= 800000 ? 2 : 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i4;
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                int length = codecProfileLevelArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecProfileLevelArr[i5];
                        if (codecProfileLevel2.profile == iIntValue && codecProfileLevel2.level >= iIntValue2) {
                            if (!"video/hevc".equals(this.b) || 2 != iIntValue) {
                                break;
                            }
                            hv0 hv0Var = i;
                            String strJ = hv0Var.j();
                            String str = x82.b;
                            if (!strJ.equals(str) && !hv0Var.a().equals(str)) {
                                break;
                            }
                        }
                        i5++;
                    } else {
                        a("codec.profileLevel, " + gc0Var.j + ", " + this.c);
                        return false;
                    }
                }
            }
        }
        if (this.h) {
            int i6 = gc0Var.r;
            if (i6 <= 0 || (i2 = gc0Var.s) <= 0) {
                return true;
            }
            if (x82.f10629a >= 21) {
                return a(i6, i2, gc0Var.t);
            }
            boolean z = i6 * i2 <= ov0.a();
            if (!z) {
                a("legacyFrameSize, " + gc0Var.r + VastAttributes.HORIZONTAL_POSITION + gc0Var.s);
            }
            return z;
        }
        int i7 = x82.f10629a;
        if (i7 >= 21) {
            int i8 = gc0Var.A;
            if (i8 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.d;
                if (codecCapabilities3 == null) {
                    a("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities3.getAudioCapabilities();
                if (audioCapabilities == null) {
                    a("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i8)) {
                    a(oe.a("sampleRate.support, ", i8));
                    return false;
                }
            }
            int i9 = gc0Var.z;
            if (i9 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities4 = this.d;
                if (codecCapabilities4 == null) {
                    a("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities4.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    a("channelCount.aCaps");
                    return false;
                }
                String str2 = this.f9037a;
                String str3 = this.b;
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && ((i7 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str3) && !"audio/3gpp".equals(str3) && !"audio/amr-wb".equals(str3) && !"audio/mp4a-latm".equals(str3) && !"audio/vorbis".equals(str3) && !"audio/opus".equals(str3) && !"audio/raw".equals(str3) && !"audio/flac".equals(str3) && !"audio/g711-alaw".equals(str3) && !"audio/g711-mlaw".equals(str3) && !"audio/gsm".equals(str3))) {
                    if ("audio/ac3".equals(str3)) {
                        i3 = 6;
                    } else if (!"audio/eac3".equals(str3)) {
                        i3 = 30;
                    }
                    at0.d("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str2 + ", [" + maxInputChannelCount + " to " + i3 + com.ironsource.b9.i.e);
                    maxInputChannelCount = i3;
                }
                if (maxInputChannelCount < i9) {
                    a(oe.a("channelCount.support, ", i9));
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean a(int i2, int i3, double d) {
        boolean zIsSizeSupported;
        boolean zIsSizeSupported2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i4 = x82.f10629a;
        Point point = new Point((((i2 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i3 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
        int i5 = point.x;
        int i6 = point.y;
        if (d != -1.0d && d >= 1.0d) {
            zIsSizeSupported = videoCapabilities.areSizeAndRateSupported(i5, i6, Math.floor(d));
        } else {
            zIsSizeSupported = videoCapabilities.isSizeSupported(i5, i6);
        }
        if (!zIsSizeSupported) {
            if (i2 < i3) {
                String str = this.f9037a;
                hv0 hv0Var = i;
                if (!hv0Var.h().equals(str) || !hv0Var.b().equals(x82.b)) {
                    int widthAlignment2 = videoCapabilities.getWidthAlignment();
                    int heightAlignment2 = videoCapabilities.getHeightAlignment();
                    Point point2 = new Point((((i3 + widthAlignment2) - 1) / widthAlignment2) * widthAlignment2, (((i2 + heightAlignment2) - 1) / heightAlignment2) * heightAlignment2);
                    int i7 = point2.x;
                    int i8 = point2.y;
                    if (d != -1.0d && d >= 1.0d) {
                        zIsSizeSupported2 = videoCapabilities.areSizeAndRateSupported(i7, i8, Math.floor(d));
                    } else {
                        zIsSizeSupported2 = videoCapabilities.isSizeSupported(i7, i8);
                    }
                    if (zIsSizeSupported2) {
                        at0.a("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i2 + VastAttributes.HORIZONTAL_POSITION + i3 + VastAttributes.HORIZONTAL_POSITION + d) + "] [" + this.f9037a + ", " + this.b + "] [" + x82.e + com.ironsource.b9.i.e);
                    }
                }
            }
            a("sizeAndRate.support, " + i2 + VastAttributes.HORIZONTAL_POSITION + i3 + VastAttributes.HORIZONTAL_POSITION + d);
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    public static gv0 a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i2;
        if (codecCapabilities == null || (i2 = x82.f10629a) < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
            z5 = false;
        } else {
            if (i2 <= 22) {
                hv0 hv0Var = i;
                String strD = hv0Var.d();
                String str4 = x82.d;
                if ((strD.equals(str4) || hv0Var.c().equals(str4)) && (hv0Var.e().equals(str) || hv0Var.f().equals(str))) {
                    z5 = false;
                }
            }
            z5 = true;
        }
        if (codecCapabilities != null && x82.f10629a >= 21) {
            codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        return new gv0(str, str2, str3, codecCapabilities, z, z5, z4 || (codecCapabilities != null && x82.f10629a >= 21 && codecCapabilities.isFeatureSupported("secure-playback")));
    }

    public final boolean a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        if (x82.f10629a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(String str) {
        at0.a("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f9037a + ", " + this.b + "] [" + x82.e + com.ironsource.b9.i.e);
    }
}
