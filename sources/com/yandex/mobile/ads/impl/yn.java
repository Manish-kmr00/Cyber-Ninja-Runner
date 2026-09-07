package com.yandex.mobile.ads.impl;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class yn extends ao {
    private final int h;
    private final int i;
    private final int j;
    private List<ev> n;
    private List<ev> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private byte t;
    private byte u;
    private boolean w;
    private long x;
    private static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 120, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 249, Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 245, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 92, 94, 95, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 126, 196, 228, Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 246, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final wf1 g = new wf1();
    private final ArrayList<a> l = new ArrayList<>();
    private a m = new a(0, 4);
    private int v = 0;
    private final long k = 16000000;

    @Override // com.yandex.mobile.ads.impl.ly
    public final void release() {
    }

    public yn(String str, int i) {
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i != 4) {
            at0.d("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        a(0);
        j();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    private ArrayList i() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            ev evVarA = this.l.get(i).a(Integer.MIN_VALUE);
            arrayList.add(evVarA);
            if (evVarA != null) {
                iMin = Math.min(iMin, evVarA.j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            ev evVarA2 = (ev) arrayList.get(i2);
            if (evVarA2 != null) {
                if (evVarA2.j != iMin) {
                    evVarA2 = this.l.get(i2).a(iMin);
                    evVarA2.getClass();
                }
                arrayList2.add(evVarA2);
            }
        }
        return arrayList2;
    }

    @Override // com.yandex.mobile.ads.impl.ao, com.yandex.mobile.ads.impl.ly
    public final void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        a(0);
        this.q = 4;
        this.m.h = 4;
        j();
        this.r = false;
        this.s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // com.yandex.mobile.ads.impl.ao, com.yandex.mobile.ads.impl.ly
    /* JADX INFO: renamed from: e */
    public final l32 a() throws i32 {
        l32 l32VarF;
        l32 l32VarA = super.a();
        if (l32VarA != null) {
            return l32VarA;
        }
        if (this.k == -9223372036854775807L || this.x == -9223372036854775807L || g() - this.x < this.k || (l32VarF = f()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = -9223372036854775807L;
        l32VarF.a(g(), c(), Long.MAX_VALUE);
        return l32VarF;
    }

    @Override // com.yandex.mobile.ads.impl.ao
    protected final boolean h() {
        return this.n != this.o;
    }

    @Override // com.yandex.mobile.ads.impl.ao
    protected final g32 c() {
        List<ev> list = this.n;
        this.o = list;
        list.getClass();
        return new bo(list);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x0207 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x0209  */
    /* JADX WARN: Code duplicated, block: B:142:0x020f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0213  */
    /* JADX WARN: Code duplicated, block: B:145:0x0216  */
    /* JADX WARN: Code duplicated, block: B:148:0x021c  */
    /* JADX WARN: Code duplicated, block: B:149:0x0228  */
    /* JADX WARN: Code duplicated, block: B:150:0x0234  */
    /* JADX WARN: Code duplicated, block: B:151:0x0240 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:152:0x0242  */
    /* JADX WARN: Code duplicated, block: B:154:0x0247  */
    /* JADX WARN: Code duplicated, block: B:155:0x0252  */
    /* JADX WARN: Code duplicated, block: B:156:0x0257 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x0259  */
    /* JADX WARN: Code duplicated, block: B:159:0x0265  */
    /* JADX WARN: Code duplicated, block: B:164:0x027b  */
    /* JADX WARN: Code duplicated, block: B:167:0x02ac A[LOOP:1: B:165:0x02a2->B:167:0x02ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:168:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:170:0x02be A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:172:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:173:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:174:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:177:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:180:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:182:0x0307  */
    /* JADX WARN: Code duplicated, block: B:200:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:51:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00af A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0127  */
    /* JADX WARN: Code duplicated, block: B:97:0x0161  */
    /* JADX WARN: Code duplicated, block: B:99:0x0165  */
    @Override // com.yandex.mobile.ads.impl.ao
    protected final void b(k32 k32Var) {
        boolean z2;
        int i;
        a aVar;
        int[] iArr;
        char c;
        a aVar2;
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        a aVar3;
        a aVar4;
        int iMin;
        int i6;
        ByteBuffer byteBuffer = k32Var.d;
        byteBuffer.getClass();
        this.g.a(byteBuffer.limit(), byteBuffer.array());
        boolean z3 = false;
        while (true) {
            int iA = this.g.a();
            int i7 = this.h;
            if (iA < i7) {
                if (z3) {
                    int i8 = this.p;
                    if (i8 == 1 || i8 == 3) {
                        this.n = i();
                        this.x = g();
                        return;
                    }
                    return;
                }
                return;
            }
            byte bT = i7 == 2 ? (byte) -4 : (byte) this.g.t();
            int iT = this.g.t();
            int iT2 = this.g.t();
            if ((bT & 2) == 0 && (bT & 1) == this.i) {
                byte b = (byte) (iT & 127);
                byte b2 = (byte) (iT2 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z4 = this.r;
                    if ((bT & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[iT] && zArr[iT2]) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    this.r = z2;
                    if (z2 && (b & 240) == 16) {
                        if (this.s && this.t == b && this.u == b2) {
                            this.s = false;
                        } else {
                            this.s = true;
                            this.t = b;
                            this.u = b2;
                            if (!z2) {
                                if (1 > b) {
                                    if ((b & 247) == 20) {
                                        if (b2 == 32) {
                                            this.w = true;
                                        } else {
                                            this.w = true;
                                        }
                                    }
                                } else if ((b & 247) == 20) {
                                    if (b2 == 32) {
                                        this.w = true;
                                    } else {
                                        this.w = true;
                                    }
                                }
                                if (this.w) {
                                    i = b & 224;
                                    if (i == 0) {
                                        this.v = (b >> 3) & 1;
                                    }
                                    if (this.v != this.j) {
                                        if (i == 0) {
                                            i2 = b & 247;
                                            if (i2 == 17) {
                                                i3 = b & 246;
                                                if (i3 != 18) {
                                                    if (i2 != 17) {
                                                        if ((b & 240) != 16) {
                                                            if (i2 != 23) {
                                                                if (i3 == 20) {
                                                                    if (b2 == 32) {
                                                                        a(2);
                                                                    } else if (b2 != 41) {
                                                                        switch (b2) {
                                                                            case 37:
                                                                                a(1);
                                                                                this.q = 2;
                                                                                this.m.h = 2;
                                                                                break;
                                                                            case 38:
                                                                                a(1);
                                                                                this.q = 3;
                                                                                this.m.h = 3;
                                                                                break;
                                                                            case 39:
                                                                                a(1);
                                                                                this.q = 4;
                                                                                this.m.h = 4;
                                                                                break;
                                                                            default:
                                                                                i4 = this.p;
                                                                                if (i4 != 0) {
                                                                                    if (b2 != 33) {
                                                                                        switch (b2) {
                                                                                            case 44:
                                                                                                this.n = Collections.emptyList();
                                                                                                i5 = this.p;
                                                                                                if (i5 != 1) {
                                                                                                    j();
                                                                                                } else {
                                                                                                    j();
                                                                                                }
                                                                                                break;
                                                                                            case 45:
                                                                                                if (i4 == 1) {
                                                                                                    aVar3 = this.m;
                                                                                                    if (aVar3.f10755a.isEmpty()) {
                                                                                                        aVar4 = this.m;
                                                                                                        aVar4.b.add(aVar4.b());
                                                                                                        aVar4.c.setLength(0);
                                                                                                        aVar4.f10755a.clear();
                                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                                            aVar4.b.remove(0);
                                                                                                        }
                                                                                                    } else {
                                                                                                        aVar4 = this.m;
                                                                                                        aVar4.b.add(aVar4.b());
                                                                                                        aVar4.c.setLength(0);
                                                                                                        aVar4.f10755a.clear();
                                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                                            aVar4.b.remove(0);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                break;
                                                                                            case 46:
                                                                                                j();
                                                                                                break;
                                                                                            case 47:
                                                                                                this.n = i();
                                                                                                j();
                                                                                                break;
                                                                                        }
                                                                                    } else {
                                                                                        this.m.a();
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        a(3);
                                                                    }
                                                                }
                                                            } else if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if ((b & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i2 != 17) {
                                                    if ((b & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if ((b & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b2 == 32) {
                                                        a(2);
                                                    } else if (b2 != 41) {
                                                        switch (b2) {
                                                            case 37:
                                                                a(1);
                                                                this.q = 2;
                                                                this.m.h = 2;
                                                                break;
                                                            case 38:
                                                                a(1);
                                                                this.q = 3;
                                                                this.m.h = 3;
                                                                break;
                                                            case 39:
                                                                a(1);
                                                                this.q = 4;
                                                                this.m.h = 4;
                                                                break;
                                                            default:
                                                                i4 = this.p;
                                                                if (i4 != 0) {
                                                                    if (b2 != 33) {
                                                                        switch (b2) {
                                                                            case 44:
                                                                                this.n = Collections.emptyList();
                                                                                i5 = this.p;
                                                                                if (i5 != 1) {
                                                                                    j();
                                                                                } else {
                                                                                    j();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (i4 == 1) {
                                                                                    aVar3 = this.m;
                                                                                    if (aVar3.f10755a.isEmpty()) {
                                                                                        aVar4 = this.m;
                                                                                        aVar4.b.add(aVar4.b());
                                                                                        aVar4.c.setLength(0);
                                                                                        aVar4.f10755a.clear();
                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                            aVar4.b.remove(0);
                                                                                        }
                                                                                    } else {
                                                                                        aVar4 = this.m;
                                                                                        aVar4.b.add(aVar4.b());
                                                                                        aVar4.c.setLength(0);
                                                                                        aVar4.f10755a.clear();
                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                            aVar4.b.remove(0);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                j();
                                                                                break;
                                                                            case 47:
                                                                                this.n = i();
                                                                                j();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.m.a();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        a(3);
                                                    }
                                                }
                                            } else {
                                                i3 = b & 246;
                                                if (i3 != 18) {
                                                    if (i2 != 17) {
                                                        if ((b & 240) != 16) {
                                                            if (i2 != 23) {
                                                                if (i3 == 20) {
                                                                    if (b2 == 32) {
                                                                        a(2);
                                                                    } else if (b2 != 41) {
                                                                        switch (b2) {
                                                                            case 37:
                                                                                a(1);
                                                                                this.q = 2;
                                                                                this.m.h = 2;
                                                                                break;
                                                                            case 38:
                                                                                a(1);
                                                                                this.q = 3;
                                                                                this.m.h = 3;
                                                                                break;
                                                                            case 39:
                                                                                a(1);
                                                                                this.q = 4;
                                                                                this.m.h = 4;
                                                                                break;
                                                                            default:
                                                                                i4 = this.p;
                                                                                if (i4 != 0) {
                                                                                    if (b2 != 33) {
                                                                                        switch (b2) {
                                                                                            case 44:
                                                                                                this.n = Collections.emptyList();
                                                                                                i5 = this.p;
                                                                                                if (i5 != 1) {
                                                                                                    j();
                                                                                                } else {
                                                                                                    j();
                                                                                                }
                                                                                                break;
                                                                                            case 45:
                                                                                                if (i4 == 1) {
                                                                                                    aVar3 = this.m;
                                                                                                    if (aVar3.f10755a.isEmpty()) {
                                                                                                        aVar4 = this.m;
                                                                                                        aVar4.b.add(aVar4.b());
                                                                                                        aVar4.c.setLength(0);
                                                                                                        aVar4.f10755a.clear();
                                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                                            aVar4.b.remove(0);
                                                                                                        }
                                                                                                    } else {
                                                                                                        aVar4 = this.m;
                                                                                                        aVar4.b.add(aVar4.b());
                                                                                                        aVar4.c.setLength(0);
                                                                                                        aVar4.f10755a.clear();
                                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                                            aVar4.b.remove(0);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                break;
                                                                                            case 46:
                                                                                                j();
                                                                                                break;
                                                                                            case 47:
                                                                                                this.n = i();
                                                                                                j();
                                                                                                break;
                                                                                        }
                                                                                    } else {
                                                                                        this.m.a();
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        a(3);
                                                                    }
                                                                }
                                                            } else if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if ((b & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i2 != 17) {
                                                    if ((b & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b2 == 32) {
                                                                    a(2);
                                                                } else if (b2 != 41) {
                                                                    switch (b2) {
                                                                        case 37:
                                                                            a(1);
                                                                            this.q = 2;
                                                                            this.m.h = 2;
                                                                            break;
                                                                        case 38:
                                                                            a(1);
                                                                            this.q = 3;
                                                                            this.m.h = 3;
                                                                            break;
                                                                        case 39:
                                                                            a(1);
                                                                            this.q = 4;
                                                                            this.m.h = 4;
                                                                            break;
                                                                        default:
                                                                            i4 = this.p;
                                                                            if (i4 != 0) {
                                                                                if (b2 != 33) {
                                                                                    switch (b2) {
                                                                                        case 44:
                                                                                            this.n = Collections.emptyList();
                                                                                            i5 = this.p;
                                                                                            if (i5 != 1) {
                                                                                                j();
                                                                                            } else {
                                                                                                j();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (i4 == 1) {
                                                                                                aVar3 = this.m;
                                                                                                if (aVar3.f10755a.isEmpty()) {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                } else {
                                                                                                    aVar4 = this.m;
                                                                                                    aVar4.b.add(aVar4.b());
                                                                                                    aVar4.c.setLength(0);
                                                                                                    aVar4.f10755a.clear();
                                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                                        aVar4.b.remove(0);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            j();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.n = i();
                                                                                            j();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.m.a();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    a(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if ((b & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b2 == 32) {
                                                                a(2);
                                                            } else if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        a(1);
                                                                        this.q = 2;
                                                                        this.m.h = 2;
                                                                        break;
                                                                    case 38:
                                                                        a(1);
                                                                        this.q = 3;
                                                                        this.m.h = 3;
                                                                        break;
                                                                    case 39:
                                                                        a(1);
                                                                        this.q = 4;
                                                                        this.m.h = 4;
                                                                        break;
                                                                    default:
                                                                        i4 = this.p;
                                                                        if (i4 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.n = Collections.emptyList();
                                                                                        i5 = this.p;
                                                                                        if (i5 != 1) {
                                                                                            j();
                                                                                        } else {
                                                                                            j();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (i4 == 1) {
                                                                                            aVar3 = this.m;
                                                                                            if (aVar3.f10755a.isEmpty()) {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            } else {
                                                                                                aVar4 = this.m;
                                                                                                aVar4.b.add(aVar4.b());
                                                                                                aVar4.c.setLength(0);
                                                                                                aVar4.f10755a.clear();
                                                                                                iMin = Math.min(aVar4.h, aVar4.d);
                                                                                                while (aVar4.b.size() >= iMin) {
                                                                                                    aVar4.b.remove(0);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        j();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.n = i();
                                                                                        j();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.m.a();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                a(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b2 == 32) {
                                                            a(2);
                                                        } else if (b2 != 41) {
                                                            switch (b2) {
                                                                case 37:
                                                                    a(1);
                                                                    this.q = 2;
                                                                    this.m.h = 2;
                                                                    break;
                                                                case 38:
                                                                    a(1);
                                                                    this.q = 3;
                                                                    this.m.h = 3;
                                                                    break;
                                                                case 39:
                                                                    a(1);
                                                                    this.q = 4;
                                                                    this.m.h = 4;
                                                                    break;
                                                                default:
                                                                    i4 = this.p;
                                                                    if (i4 != 0) {
                                                                        if (b2 != 33) {
                                                                            switch (b2) {
                                                                                case 44:
                                                                                    this.n = Collections.emptyList();
                                                                                    i5 = this.p;
                                                                                    if (i5 != 1) {
                                                                                        j();
                                                                                    } else {
                                                                                        j();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i4 == 1) {
                                                                                        aVar3 = this.m;
                                                                                        if (aVar3.f10755a.isEmpty()) {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        } else {
                                                                                            aVar4 = this.m;
                                                                                            aVar4.b.add(aVar4.b());
                                                                                            aVar4.c.setLength(0);
                                                                                            aVar4.f10755a.clear();
                                                                                            iMin = Math.min(aVar4.h, aVar4.d);
                                                                                            while (aVar4.b.size() >= iMin) {
                                                                                                aVar4.b.remove(0);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    j();
                                                                                    break;
                                                                                case 47:
                                                                                    this.n = i();
                                                                                    j();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.m.a();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            a(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b2 == 32) {
                                                        a(2);
                                                    } else if (b2 != 41) {
                                                        switch (b2) {
                                                            case 37:
                                                                a(1);
                                                                this.q = 2;
                                                                this.m.h = 2;
                                                                break;
                                                            case 38:
                                                                a(1);
                                                                this.q = 3;
                                                                this.m.h = 3;
                                                                break;
                                                            case 39:
                                                                a(1);
                                                                this.q = 4;
                                                                this.m.h = 4;
                                                                break;
                                                            default:
                                                                i4 = this.p;
                                                                if (i4 != 0) {
                                                                    if (b2 != 33) {
                                                                        switch (b2) {
                                                                            case 44:
                                                                                this.n = Collections.emptyList();
                                                                                i5 = this.p;
                                                                                if (i5 != 1) {
                                                                                    j();
                                                                                } else {
                                                                                    j();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (i4 == 1) {
                                                                                    aVar3 = this.m;
                                                                                    if (aVar3.f10755a.isEmpty()) {
                                                                                        aVar4 = this.m;
                                                                                        aVar4.b.add(aVar4.b());
                                                                                        aVar4.c.setLength(0);
                                                                                        aVar4.f10755a.clear();
                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                            aVar4.b.remove(0);
                                                                                        }
                                                                                    } else {
                                                                                        aVar4 = this.m;
                                                                                        aVar4.b.add(aVar4.b());
                                                                                        aVar4.c.setLength(0);
                                                                                        aVar4.f10755a.clear();
                                                                                        iMin = Math.min(aVar4.h, aVar4.d);
                                                                                        while (aVar4.b.size() >= iMin) {
                                                                                            aVar4.b.remove(0);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                j();
                                                                                break;
                                                                            case 47:
                                                                                this.n = i();
                                                                                j();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.m.a();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        a(3);
                                                    }
                                                }
                                            }
                                        } else {
                                            aVar = this.m;
                                            iArr = B;
                                            c = (char) iArr[(b & 127) - 32];
                                            if (aVar.c.length() < 32) {
                                                aVar.c.append(c);
                                            }
                                            if ((b2 & 224) != 0) {
                                                aVar2 = this.m;
                                                c2 = (char) iArr[(b2 & 127) - 32];
                                                if (aVar2.c.length() < 32) {
                                                    aVar2.c.append(c2);
                                                }
                                            }
                                        }
                                        z3 = true;
                                    }
                                }
                            } else if (z4) {
                                j();
                                z3 = true;
                            }
                        }
                    } else {
                        this.s = false;
                        if (!z2) {
                            if (1 > b && b <= 15) {
                                this.w = false;
                            } else if ((b & 247) == 20) {
                                if (b2 == 32 && b2 != 47) {
                                    switch (b2) {
                                        default:
                                            switch (b2) {
                                                case 42:
                                                case 43:
                                                    this.w = false;
                                                    break;
                                            }
                                        case 37:
                                        case 38:
                                        case 39:
                                            this.w = true;
                                            break;
                                    }
                                } else {
                                    this.w = true;
                                }
                            }
                            if (this.w) {
                                i = b & 224;
                                if (i == 0) {
                                    this.v = (b >> 3) & 1;
                                }
                                if (this.v != this.j) {
                                    if (i == 0) {
                                        i2 = b & 247;
                                        if (i2 == 17 || (b2 & 240) != 48) {
                                            i3 = b & 246;
                                            if (i3 != 18 && (b2 & 224) == 32) {
                                                this.m.a();
                                                a aVar5 = this.m;
                                                if ((b & 1) == 0) {
                                                    i6 = D[b2 & Ascii.US];
                                                } else {
                                                    i6 = E[b2 & Ascii.US];
                                                }
                                                char c3 = (char) i6;
                                                if (aVar5.c.length() < 32) {
                                                    aVar5.c.append(c3);
                                                }
                                            } else if (i2 != 17 && (b2 & 240) == 32) {
                                                a aVar6 = this.m;
                                                if (aVar6.c.length() < 32) {
                                                    aVar6.c.append(' ');
                                                }
                                                boolean z5 = (b2 & 1) == 1;
                                                a aVar7 = this.m;
                                                aVar7.f10755a.add(new a.C0760a((b2 >> 1) & 7, aVar7.c.length(), z5));
                                            } else if ((b & 240) != 16 && (b2 & 192) == 64) {
                                                int i9 = y[b & 7];
                                                if ((b2 & 32) != 0) {
                                                    i9++;
                                                }
                                                a aVar8 = this.m;
                                                if (i9 != aVar8.d) {
                                                    if (this.p != 1 && (!aVar8.f10755a.isEmpty() || !aVar8.b.isEmpty() || aVar8.c.length() != 0)) {
                                                        a aVar9 = new a(this.p, this.q);
                                                        this.m = aVar9;
                                                        this.l.add(aVar9);
                                                    }
                                                    this.m.d = i9;
                                                }
                                                boolean z6 = (b2 & Ascii.DLE) == 16;
                                                boolean z7 = (b2 & 1) == 1;
                                                int i10 = (b2 >> 1) & 7;
                                                a aVar10 = this.m;
                                                aVar10.f10755a.add(new a.C0760a(z6 ? 8 : i10, aVar10.c.length(), z7));
                                                if (z6) {
                                                    this.m.e = z[i10];
                                                }
                                            } else if (i2 != 23 && b2 >= 33 && b2 <= 35) {
                                                this.m.f = b2 - 32;
                                            } else if (i3 == 20 && (b2 & 240) == 32) {
                                                if (b2 == 32) {
                                                    a(2);
                                                } else if (b2 != 41) {
                                                    switch (b2) {
                                                        case 37:
                                                            a(1);
                                                            this.q = 2;
                                                            this.m.h = 2;
                                                            break;
                                                        case 38:
                                                            a(1);
                                                            this.q = 3;
                                                            this.m.h = 3;
                                                            break;
                                                        case 39:
                                                            a(1);
                                                            this.q = 4;
                                                            this.m.h = 4;
                                                            break;
                                                        default:
                                                            i4 = this.p;
                                                            if (i4 != 0) {
                                                                if (b2 != 33) {
                                                                    switch (b2) {
                                                                        case 44:
                                                                            this.n = Collections.emptyList();
                                                                            i5 = this.p;
                                                                            if (i5 != 1 || i5 == 3) {
                                                                                j();
                                                                            }
                                                                            break;
                                                                        case 45:
                                                                            if (i4 == 1) {
                                                                                aVar3 = this.m;
                                                                                if (aVar3.f10755a.isEmpty() || !aVar3.b.isEmpty() || aVar3.c.length() != 0) {
                                                                                    aVar4 = this.m;
                                                                                    aVar4.b.add(aVar4.b());
                                                                                    aVar4.c.setLength(0);
                                                                                    aVar4.f10755a.clear();
                                                                                    iMin = Math.min(aVar4.h, aVar4.d);
                                                                                    while (aVar4.b.size() >= iMin) {
                                                                                        aVar4.b.remove(0);
                                                                                    }
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 46:
                                                                            j();
                                                                            break;
                                                                        case 47:
                                                                            this.n = i();
                                                                            j();
                                                                            break;
                                                                    }
                                                                } else {
                                                                    this.m.a();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    a(3);
                                                }
                                            }
                                        } else {
                                            a aVar11 = this.m;
                                            char c4 = (char) C[b2 & Ascii.SI];
                                            if (aVar11.c.length() < 32) {
                                                aVar11.c.append(c4);
                                            }
                                        }
                                    } else {
                                        aVar = this.m;
                                        iArr = B;
                                        c = (char) iArr[(b & 127) - 32];
                                        if (aVar.c.length() < 32) {
                                            aVar.c.append(c);
                                        }
                                        if ((b2 & 224) != 0) {
                                            aVar2 = this.m;
                                            c2 = (char) iArr[(b2 & 127) - 32];
                                            if (aVar2.c.length() < 32) {
                                                aVar2.c.append(c2);
                                            }
                                        }
                                    }
                                    z3 = true;
                                }
                            }
                        } else if (z4) {
                            j();
                            z3 = true;
                        }
                    }
                }
            }
        }
    }

    private void j() {
        this.m.b(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    private void a(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                this.l.get(i3).g = i;
            }
            return;
        }
        j();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = Collections.emptyList();
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f10755a = new ArrayList();
        private final ArrayList b = new ArrayList();
        private final StringBuilder c = new StringBuilder();
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.yn$a$a, reason: collision with other inner class name */
        private static class C0760a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f10756a;
            public final boolean b;
            public int c;

            public C0760a(int i, int i2, boolean z) {
                this.f10756a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            b(i);
            this.h = i2;
        }

        public final void b(int i) {
            this.g = i;
            this.f10755a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.f10755a.size()) {
                C0760a c0760a = (C0760a) this.f10755a.get(i5);
                boolean z2 = c0760a.b;
                int i7 = c0760a.f10756a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = yn.A[i7];
                    }
                    z = z3;
                }
                int i8 = c0760a.c;
                i5++;
                if (i8 != (i5 < this.f10755a.size() ? ((C0760a) this.f10755a.get(i5)).c : length)) {
                    if (i != -1 && !z2) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i, i8, 33);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        if (i3 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6, i8, 33);
                        }
                        i6 = i8;
                        i3 = i4;
                    }
                }
            }
            if (i != -1 && i != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
            }
            if (i6 != length && i3 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final void a() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.f10755a.size() - 1; size >= 0; size--) {
                    C0760a c0760a = (C0760a) this.f10755a.get(size);
                    int i = c0760a.c;
                    if (i != length) {
                        return;
                    }
                    c0760a.c = i - 1;
                }
            }
        }

        public final ev a(int i) {
            float f;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                CharSequence charSequenceSubSequence = (CharSequence) this.b.get(i4);
                int i5 = x82.f10629a;
                if (charSequenceSubSequence.length() > i3) {
                    charSequenceSubSequence = charSequenceSubSequence.subSequence(0, i3);
                }
                spannableStringBuilder.append(charSequenceSubSequence);
                spannableStringBuilder.append('\n');
            }
            SpannableString spannableStringB = b();
            int i6 = x82.f10629a;
            int length = spannableStringB.length();
            SpannableString spannableStringSubSequence = spannableStringB;
            if (length > i3) {
                spannableStringSubSequence = spannableStringB.subSequence(0, i3);
            }
            spannableStringBuilder.append((CharSequence) spannableStringSubSequence);
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length2 = i3 - spannableStringBuilder.length();
            int i7 = i2 - length2;
            if (i == Integer.MIN_VALUE) {
                if (this.g != 2 || (Math.abs(i7) >= 3 && length2 >= 0)) {
                    i = (this.g != 2 || i7 <= 0) ? 0 : 2;
                } else {
                    i = 1;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length2;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i8 = this.d;
            if (i8 > 7) {
                i8 -= 17;
            } else if (this.g == 1) {
                i8 -= this.h - 1;
            }
            return new ev.a().a(spannableStringBuilder).b(Layout.Alignment.ALIGN_NORMAL).a(1, i8).b(f).b(i).a();
        }
    }
}
