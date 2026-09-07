package com.yandex.mobile.ads.impl;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f10249a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, 32000};
    private static final int[] c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 139, 174, 208, 243, POBNativeConstants.POB_NATIVE_MAIN_IMG_W, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, IronSourceConstants.RV_CALLBACK_AD_CLICKED, 1253, 1393};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10250a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private a(String str, int i, int i2, int i3, int i4) {
            this.f10250a = str;
            this.c = i;
            this.b = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public static gc0 b(wf1 wf1Var, String str, String str2, c40 c40Var) {
        String str3;
        wf1Var.f(2);
        int i = b[(wf1Var.t() & 192) >> 6];
        int iT = wf1Var.t();
        int i2 = d[(iT & 14) >> 1];
        if ((iT & 1) != 0) {
            i2++;
        }
        if (((wf1Var.t() & 30) >> 1) > 0 && (2 & wf1Var.t()) != 0) {
            i2 += 2;
        }
        if (wf1Var.a() > 0 && (wf1Var.t() & 1) != 0) {
            str3 = "audio/eac3-joc";
        } else {
            str3 = "audio/eac3";
        }
        return new gc0.a().b(str).e(str3).c(i2).l(i).a(c40Var).d(str2).a();
    }

    private static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= 3 || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= 19) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return ((i2 % 2) + iArr2[i3]) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static gc0 a(wf1 wf1Var, String str, String str2, c40 c40Var) {
        int i = b[(wf1Var.t() & 192) >> 6];
        int iT = wf1Var.t();
        int i2 = d[(iT & 56) >> 3];
        if ((iT & 4) != 0) {
            i2++;
        }
        return new gc0.a().b(str).e("audio/ac3").c(i2).l(i).a(c40Var).d(str2).a();
    }

    public static int a(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f10249a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static a a(vf1 vf1Var) {
        int iA;
        int i;
        int i2;
        int i3;
        String str;
        int iB;
        int i4;
        int i5;
        String str2;
        int i6;
        int i7;
        int iE = vf1Var.e();
        vf1Var.d(40);
        boolean z = vf1Var.b(5) > 10;
        vf1Var.c(iE);
        int i8 = -1;
        if (z) {
            vf1Var.d(16);
            int iB2 = vf1Var.b(2);
            if (iB2 == 0) {
                i8 = 0;
            } else if (iB2 == 1) {
                i8 = 1;
            } else if (iB2 == 2) {
                i8 = 2;
            }
            vf1Var.d(3);
            iA = (vf1Var.b(11) + 1) * 2;
            int iB3 = vf1Var.b(2);
            if (iB3 == 3) {
                i3 = c[vf1Var.b(2)];
                i4 = 6;
                iB = 3;
            } else {
                iB = vf1Var.b(2);
                i4 = f10249a[iB];
                i3 = b[iB3];
            }
            i2 = i4 * 256;
            int iB4 = vf1Var.b(3);
            boolean zF = vf1Var.f();
            i = d[iB4] + (zF ? 1 : 0);
            vf1Var.d(10);
            if (vf1Var.f()) {
                vf1Var.d(8);
            }
            if (iB4 == 0) {
                vf1Var.d(5);
                if (vf1Var.f()) {
                    vf1Var.d(8);
                }
            }
            if (i8 == 1 && vf1Var.f()) {
                vf1Var.d(16);
            }
            if (vf1Var.f()) {
                if (iB4 > 2) {
                    vf1Var.d(2);
                }
                if ((iB4 & 1) == 0 || iB4 <= 2) {
                    i6 = 6;
                } else {
                    i6 = 6;
                    vf1Var.d(6);
                }
                if ((iB4 & 4) != 0) {
                    vf1Var.d(i6);
                }
                if (zF && vf1Var.f()) {
                    vf1Var.d(5);
                }
                if (i8 == 0) {
                    if (vf1Var.f()) {
                        i7 = 6;
                        vf1Var.d(6);
                    } else {
                        i7 = 6;
                    }
                    if (iB4 == 0 && vf1Var.f()) {
                        vf1Var.d(i7);
                    }
                    if (vf1Var.f()) {
                        vf1Var.d(i7);
                    }
                    int iB5 = vf1Var.b(2);
                    if (iB5 == 1) {
                        vf1Var.d(5);
                    } else if (iB5 == 2) {
                        vf1Var.d(12);
                    } else if (iB5 == 3) {
                        int iB6 = vf1Var.b(5);
                        if (vf1Var.f()) {
                            vf1Var.d(5);
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                vf1Var.d(4);
                            }
                            if (vf1Var.f()) {
                                if (vf1Var.f()) {
                                    vf1Var.d(4);
                                }
                                if (vf1Var.f()) {
                                    vf1Var.d(4);
                                }
                            }
                        }
                        if (vf1Var.f()) {
                            vf1Var.d(5);
                            if (vf1Var.f()) {
                                vf1Var.d(7);
                                if (vf1Var.f()) {
                                    vf1Var.d(8);
                                }
                            }
                        }
                        vf1Var.d((iB6 + 2) * 8);
                        vf1Var.c();
                    }
                    if (iB4 < 2) {
                        if (vf1Var.f()) {
                            vf1Var.d(14);
                        }
                        if (iB4 == 0 && vf1Var.f()) {
                            vf1Var.d(14);
                        }
                    }
                    if (vf1Var.f()) {
                        if (iB == 0) {
                            vf1Var.d(5);
                        } else {
                            for (int i9 = 0; i9 < i4; i9++) {
                                if (vf1Var.f()) {
                                    vf1Var.d(5);
                                }
                            }
                        }
                    }
                }
            }
            if (vf1Var.f()) {
                vf1Var.d(5);
                if (iB4 == 2) {
                    vf1Var.d(4);
                }
                if (iB4 >= 6) {
                    vf1Var.d(2);
                }
                if (vf1Var.f()) {
                    vf1Var.d(8);
                }
                if (iB4 == 0 && vf1Var.f()) {
                    vf1Var.d(8);
                }
                if (iB3 < 3) {
                    vf1Var.h();
                }
            }
            if (i8 == 0 && iB != 3) {
                vf1Var.h();
            }
            if (i8 == 2 && (iB == 3 || vf1Var.f())) {
                i5 = 6;
                vf1Var.d(6);
            } else {
                i5 = 6;
            }
            if (vf1Var.f() && vf1Var.b(i5) == 1 && vf1Var.b(8) == 1) {
                str2 = "audio/eac3-joc";
            } else {
                str2 = "audio/eac3";
            }
            str = str2;
        } else {
            vf1Var.d(32);
            int iB7 = vf1Var.b(2);
            String str3 = iB7 == 3 ? null : "audio/ac3";
            iA = a(iB7, vf1Var.b(6));
            vf1Var.d(8);
            int iB8 = vf1Var.b(3);
            if ((iB8 & 1) != 0 && iB8 != 1) {
                vf1Var.d(2);
            }
            if ((iB8 & 4) != 0) {
                vf1Var.d(2);
            }
            if (iB8 == 2) {
                vf1Var.d(2);
            }
            i8 = iB7 < 3 ? b[iB7] : -1;
            i = d[iB8] + (vf1Var.f() ? 1 : 0);
            i2 = 1536;
            i3 = i8;
            str = str3;
        }
        return new a(str, i, i3, iA, i2);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return a((b2 & 192) >> 6, b2 & 63);
    }
}
