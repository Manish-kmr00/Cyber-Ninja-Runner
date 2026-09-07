package com.facebook.ads.redexgen.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class WX {
    public static String[] A00 = {"XaMN", "FvE9pjm3324a0xJnMynMkwOLQFBnA7VY", "bTXZinmnfbB6B0d8sTeuEdBC4iIH8UVK", "N9t7nxkL15CeL8BHnhp6HN26QOqkPbFY", "ebn6LH928MPI84NEPNpnK67pXTtamLRv", "SLORTYF7QadC3HEUSy6dvDOwwkjkN61c", "", "QvlqdgkREF9PaCWTAu28pJgIsiwfnHXC"};
    public static final int[] A01 = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean A00(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        int[] iArr = A01;
        String[] strArr = A00;
        if (strArr[5].charAt(27) != strArr[3].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[2] = "j5mRnpVXmsF9fFWvjjsgRXifTOGS2Czx";
        strArr2[4] = "T5lCDrnpy2Bb3DWu2FSAH2boF1NW8f68";
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A01(WJ wj) throws IOException {
        return A03(wj, true, false);
    }

    public static boolean A02(WJ wj, boolean z) throws IOException {
        return A03(wj, false, z);
    }

    public static boolean A03(WJ wj, boolean z, boolean z2) throws IOException {
        long jA8E = wj.A8E();
        long inputLength = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (jA8E != -1 && jA8E <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            inputLength = jA8E;
        }
        int i = (int) inputLength;
        C2447fq c2447fq = new C2447fq(64);
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < i) {
            int i3 = 8;
            c2447fq.A0d(8);
            if (!wj.AG2(c2447fq.A0l(), 0, 8, true)) {
                break;
            }
            long jA0Q = c2447fq.A0Q();
            int headerSize = c2447fq.A0C();
            if (jA0Q == 1) {
                i3 = 16;
                wj.AG1(c2447fq.A0l(), 8, 8);
                c2447fq.A0e(16);
                jA0Q = c2447fq.A0P();
            } else if (jA0Q == 0) {
                long jA8E2 = wj.A8E();
                if (jA8E2 != -1) {
                    jA0Q = (jA8E2 - wj.A8Y()) + ((long) 8);
                }
            }
            if (jA0Q < i3) {
                return false;
            }
            i2 += i3;
            if (headerSize == 1836019574) {
                i += (int) jA0Q;
                if (jA8E != -1 && i > jA8E) {
                    i = (int) jA8E;
                }
            } else {
                if (headerSize == 1836019558 || headerSize == 1836475768) {
                    z4 = true;
                    break;
                }
                if ((((long) i2) + jA0Q) - ((long) i3) >= i) {
                    break;
                }
                int atomDataSize = (int) (jA0Q - ((long) i3));
                i2 += atomDataSize;
                if (headerSize == 1718909296) {
                    if (atomDataSize >= 8) {
                        c2447fq.A0d(atomDataSize);
                        wj.AG1(c2447fq.A0l(), 0, atomDataSize);
                        int atomDataSize2 = atomDataSize / 4;
                        for (int brandsCount = 0; brandsCount < atomDataSize2; brandsCount++) {
                            if (brandsCount == 1) {
                                c2447fq.A0g(4);
                            } else if (A00(c2447fq.A0C(), z2)) {
                                z3 = true;
                                break;
                            }
                        }
                        if (!z3) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (atomDataSize != 0) {
                    wj.A3x(atomDataSize);
                }
            }
        }
        if (z3) {
            String[] strArr = A00;
            if (strArr[2].charAt(29) == strArr[4].charAt(29)) {
                throw new RuntimeException();
            }
            A00[7] = "pFKvHkJSq3K8vNTui4Mcu8lysNSmnddC";
            if (z == z4) {
                return true;
            }
        }
        return false;
    }
}
