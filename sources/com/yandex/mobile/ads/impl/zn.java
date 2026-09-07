package com.yandex.mobile.ads.impl;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public final class zn extends ao {
    private final wf1 g = new wf1();
    private final vf1 h = new vf1();
    private int i = -1;
    private final int j;
    private final b[] k;
    private b l;
    private List<ev> m;
    private List<ev> n;
    private c o;
    private int p;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private static final Comparator<a> c = new Comparator() { // from class: com.yandex.mobile.ads.impl.zn$a$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return zn.a.a((zn.a) obj, (zn.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ev f10832a;
        public final int b;

        public a(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
            ev.a aVarD = new ev.a().a(spannableStringBuilder).b(alignment).a(0, f).a(i).b(f2).b(i2).d(-3.4028235E38f);
            if (z) {
                aVarD.d(i3);
            }
            this.f10832a = aVarD.a();
            this.b = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(a aVar, a aVar2) {
            return Integer.compare(aVar2.b, aVar.b);
        }
    }

    private static final class b {
        private static final int[] A;
        private static final boolean[] B;
        private static final int[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        public static final int w = a(2, 2, 2, 0);
        public static final int x;
        private static final int[] y;
        private static final int[] z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f10833a = new ArrayList();
        private final SpannableStringBuilder b = new SpannableStringBuilder();
        private boolean c;
        private boolean d;
        private int e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;

        public final void b() {
            this.f10833a.clear();
            this.b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i = x;
            this.o = i;
            this.s = w;
            this.u = i;
        }

        static {
            int iA = a(0, 0, 0, 0);
            x = iA;
            int iA2 = a(0, 0, 0, 3);
            y = new int[]{0, 0, 0, 0, 0, 2, 0};
            z = new int[]{0, 0, 0, 0, 0, 0, 2};
            A = new int[]{3, 3, 3, 3, 3, 3, 1};
            B = new boolean[]{false, false, false, true, true, true, false};
            C = new int[]{iA, iA2, iA, iA, iA2, iA, iA};
            D = new int[]{0, 1, 2, 3, 4, 3, 4};
            E = new int[]{0, 0, 0, 0, 0, 3, 3};
            F = new int[]{iA, iA, iA, iA, iA, iA2, iA2};
        }

        public b() {
            b();
        }

        public final void a(char c) {
            if (c == '\n') {
                this.f10833a.add(a());
                this.b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while (true) {
                    if ((!this.k || this.f10833a.size() < this.j) && this.f10833a.size() < 15) {
                        return;
                    } else {
                        this.f10833a.remove(0);
                    }
                }
            } else {
                this.b.append(c);
            }
        }

        public static int a(int i, int i2, int i3, int i4) {
            int i5;
            hg.a(i, 4);
            hg.a(i2, 4);
            hg.a(i3, 4);
            hg.a(i4, 4);
            if (i4 != 2) {
                i5 = i4 != 3 ? 255 : 0;
            } else {
                i5 = 127;
            }
            return Color.argb(i5, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        public final void a(boolean z2, boolean z3) {
            if (this.p != -1) {
                if (!z2) {
                    this.b.setSpan(new StyleSpan(2), this.p, this.b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.b.length();
            }
            if (this.q == -1) {
                if (z3) {
                    this.q = this.b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.b.setSpan(new UnderlineSpan(), this.q, this.b.length(), 33);
                this.q = -1;
            }
        }

        public final void a(int i, int i2) {
            if (this.r != -1 && this.s != i) {
                this.b.setSpan(new ForegroundColorSpan(this.s), this.r, this.b.length(), 33);
            }
            if (i != w) {
                this.r = this.b.length();
                this.s = i;
            }
            if (this.t != -1 && this.u != i2) {
                this.b.setSpan(new BackgroundColorSpan(this.u), this.t, this.b.length(), 33);
            }
            if (i2 != x) {
                this.t = this.b.length();
                this.u = i2;
            }
        }

        public final SpannableString a() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }
    }

    private List<ev> j() {
        a aVar;
        Layout.Alignment alignment;
        float f;
        float f2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            b bVar = this.k[i];
            if (bVar.c && (!bVar.f10833a.isEmpty() || bVar.b.length() != 0)) {
                b bVar2 = this.k[i];
                if (bVar2.d) {
                    if (!bVar2.c || (bVar2.f10833a.isEmpty() && bVar2.b.length() == 0)) {
                        aVar = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < bVar2.f10833a.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) bVar2.f10833a.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) bVar2.a());
                        int i3 = bVar2.l;
                        if (i3 == 0) {
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else if (i3 == 1) {
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                        } else if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalArgumentException("Unexpected justification value: " + bVar2.l);
                            }
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        if (bVar2.f) {
                            f = bVar2.h / 99.0f;
                            f2 = bVar2.g / 99.0f;
                        } else {
                            f = bVar2.h / 209.0f;
                            f2 = bVar2.g / 74.0f;
                        }
                        float f3 = (f * 0.9f) + 0.05f;
                        float f4 = (f2 * 0.9f) + 0.05f;
                        int i4 = bVar2.i;
                        int i5 = i4 / 3;
                        int i6 = i4 % 3;
                        aVar = new a(spannableStringBuilder, alignment, f4, i5 == 0 ? 0 : i5 == 1 ? 1 : 2, f3, i6 == 0 ? 0 : i6 == 1 ? 1 : 2, bVar2.o != b.x, bVar2.o, bVar2.e);
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        arrayList.add(aVar2);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, a.c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((a) arrayList.get(i7)).f10832a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final /* bridge */ /* synthetic */ void release() {
    }

    public zn(int i, List<byte[]> list) {
        this.j = i == -1 ? 1 : i;
        if (list != null) {
            mq.a(list);
        }
        this.k = new b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.k[i2] = new b();
        }
        this.l = this.k[0];
    }

    @Override // com.yandex.mobile.ads.impl.ao, com.yandex.mobile.ads.impl.ly
    public final void flush() {
        super.flush();
        this.m = null;
        this.n = null;
        this.p = 0;
        this.l = this.k[0];
        for (int i = 0; i < 8; i++) {
            this.k[i].b();
        }
        this.o = null;
    }

    @Override // com.yandex.mobile.ads.impl.ao
    protected final boolean h() {
        return this.m != this.n;
    }

    @Override // com.yandex.mobile.ads.impl.ao
    protected final g32 c() {
        List<ev> list = this.m;
        this.n = list;
        list.getClass();
        return new bo(list);
    }

    @Override // com.yandex.mobile.ads.impl.ao
    protected final void b(k32 k32Var) {
        ByteBuffer byteBuffer = k32Var.d;
        byteBuffer.getClass();
        this.g.a(byteBuffer.limit(), byteBuffer.array());
        while (this.g.a() >= 3) {
            int iT = this.g.t();
            int i = iT & 3;
            boolean z = (iT & 4) == 4;
            byte bT = (byte) this.g.t();
            byte bT2 = (byte) this.g.t();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        i();
                        int i2 = (bT & 192) >> 6;
                        int i3 = this.i;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            for (int i4 = 0; i4 < 8; i4++) {
                                this.k[i4].b();
                            }
                            at0.d("Cea708Decoder", "Sequence number discontinuity. previous=" + this.i + " current=" + i2);
                        }
                        this.i = i2;
                        int i5 = bT & 63;
                        if (i5 == 0) {
                            i5 = 64;
                        }
                        c cVar = new c(i2, i5);
                        this.o = cVar;
                        byte[] bArr = cVar.c;
                        cVar.d = 1;
                        bArr[0] = bT2;
                    } else if (i == 2) {
                        c cVar2 = this.o;
                        if (cVar2 == null) {
                            at0.b("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.c;
                            int i6 = cVar2.d;
                            bArr2[i6] = bT;
                            cVar2.d = i6 + 2;
                            bArr2[i6 + 1] = bT2;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                    c cVar3 = this.o;
                    if (cVar3.d == (cVar3.b * 2) - 1) {
                        i();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:231:0x0638  */
    private void i() {
        boolean z;
        int i;
        char c2;
        c cVar = this.o;
        if (cVar == null) {
            return;
        }
        int i2 = 2;
        if (cVar.d != (cVar.b * 2) - 1) {
            at0.a("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.o.b * 2) - 1) + ", but current index is " + this.o.d + " (sequence number " + this.o.f10834a + ");");
        }
        vf1 vf1Var = this.h;
        c cVar2 = this.o;
        vf1Var.a(cVar2.d, cVar2.c);
        boolean z2 = false;
        while (this.h.b() > 0) {
            int i3 = 3;
            int iB = this.h.b(3);
            int iB2 = this.h.b(5);
            int i4 = 7;
            if (iB == 7) {
                this.h.d(i2);
                iB = this.h.b(6);
                if (iB < 7) {
                    tr0.a("Invalid extended service number: ", iB, "Cea708Decoder");
                }
            }
            if (iB2 != 0) {
                if (iB != this.j) {
                    this.h.e(iB2);
                } else {
                    int iE = (iB2 * 8) + this.h.e();
                    while (this.h.e() < iE) {
                        int iB3 = this.h.b(8);
                        if (iB3 != 16) {
                            if (iB3 <= 31) {
                                if (iB3 != 0) {
                                    if (iB3 == i3) {
                                        this.m = j();
                                    } else if (iB3 != 8) {
                                        switch (iB3) {
                                            case 12:
                                                for (int i5 = 0; i5 < 8; i5++) {
                                                    this.k[i5].b();
                                                }
                                                break;
                                            case 13:
                                                this.l.a('\n');
                                                break;
                                            case 14:
                                                break;
                                            default:
                                                if (iB3 >= 17 && iB3 <= 23) {
                                                    tr0.a("Currently unsupported COMMAND_EXT1 Command: ", iB3, "Cea708Decoder");
                                                    this.h.d(8);
                                                } else if (iB3 >= 24 && iB3 <= 31) {
                                                    tr0.a("Currently unsupported COMMAND_P16 Command: ", iB3, "Cea708Decoder");
                                                    this.h.d(16);
                                                } else {
                                                    tr0.a("Invalid C0 command: ", iB3, "Cea708Decoder");
                                                }
                                                break;
                                        }
                                    } else {
                                        b bVar = this.l;
                                        int length = bVar.b.length();
                                        if (length > 0) {
                                            bVar.b.delete(length - 1, length);
                                        }
                                    }
                                }
                                i = i2;
                                z = true;
                            } else {
                                if (iB3 > 127) {
                                    if (iB3 <= 159) {
                                        switch (iB3) {
                                            case 128:
                                            case 129:
                                            case 130:
                                            case MRAID_JS_WRITE_FAILED_VALUE:
                                            case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                                            case OMSDK_JS_WRITE_FAILED_VALUE:
                                            case 134:
                                            case 135:
                                                z = true;
                                                int i6 = iB3 - 128;
                                                if (this.p != i6) {
                                                    this.p = i6;
                                                    this.l = this.k[i6];
                                                }
                                                break;
                                            case 136:
                                                z = true;
                                                for (int i7 = 1; i7 <= 8; i7++) {
                                                    if (this.h.f()) {
                                                        b bVar2 = this.k[8 - i7];
                                                        bVar2.f10833a.clear();
                                                        bVar2.b.clear();
                                                        bVar2.p = -1;
                                                        bVar2.q = -1;
                                                        bVar2.r = -1;
                                                        bVar2.t = -1;
                                                        bVar2.v = 0;
                                                    }
                                                }
                                                break;
                                            case TPAT_RETRY_FAILED_VALUE:
                                                for (int i8 = 1; i8 <= 8; i8++) {
                                                    if (this.h.f()) {
                                                        this.k[8 - i8].d = true;
                                                    }
                                                }
                                                z = true;
                                                break;
                                            case 138:
                                                for (int i9 = 1; i9 <= 8; i9++) {
                                                    if (this.h.f()) {
                                                        this.k[8 - i9].d = false;
                                                    }
                                                }
                                                z = true;
                                                break;
                                            case 139:
                                                for (int i10 = 1; i10 <= 8; i10++) {
                                                    if (this.h.f()) {
                                                        b bVar3 = this.k[8 - i10];
                                                        bVar3.d = !bVar3.d;
                                                    }
                                                }
                                                z = true;
                                                break;
                                            case IronSourceConstants.USING_CACHE_FOR_INIT_EVENT /* 140 */:
                                                for (int i11 = 1; i11 <= 8; i11++) {
                                                    if (this.h.f()) {
                                                        this.k[8 - i11].b();
                                                    }
                                                }
                                                z = true;
                                                break;
                                            case 141:
                                                this.h.d(8);
                                                z = true;
                                                break;
                                            case 142:
                                                break;
                                            case 143:
                                                for (int i12 = 0; i12 < 8; i12++) {
                                                    this.k[i12].b();
                                                }
                                                z = true;
                                                break;
                                            case 144:
                                                if (!this.l.c) {
                                                    this.h.d(16);
                                                    z = true;
                                                    i3 = 3;
                                                } else {
                                                    this.h.b(4);
                                                    this.h.b(2);
                                                    this.h.b(2);
                                                    boolean zF = this.h.f();
                                                    boolean zF2 = this.h.f();
                                                    i3 = 3;
                                                    this.h.b(3);
                                                    this.h.b(3);
                                                    this.l.a(zF, zF2);
                                                    z = true;
                                                }
                                                break;
                                            case 145:
                                                if (!this.l.c) {
                                                    this.h.d(24);
                                                } else {
                                                    int iA = b.a(this.h.b(2), this.h.b(2), this.h.b(2), this.h.b(2));
                                                    int iA2 = b.a(this.h.b(2), this.h.b(2), this.h.b(2), this.h.b(2));
                                                    this.h.d(2);
                                                    b.a(this.h.b(2), this.h.b(2), this.h.b(2), 0);
                                                    this.l.a(iA, iA2);
                                                }
                                                z = true;
                                                i3 = 3;
                                                break;
                                            case POBNativeConstants.POB_NATIVE_MAIN_IMG_H /* 146 */:
                                                if (!this.l.c) {
                                                    this.h.d(16);
                                                } else {
                                                    this.h.d(4);
                                                    int iB4 = this.h.b(4);
                                                    this.h.d(2);
                                                    this.h.b(6);
                                                    b bVar4 = this.l;
                                                    if (bVar4.v != iB4) {
                                                        bVar4.a('\n');
                                                    }
                                                    bVar4.v = iB4;
                                                }
                                                z = true;
                                                i3 = 3;
                                                break;
                                            case 147:
                                            case 148:
                                            case 149:
                                            case 150:
                                            default:
                                                z = true;
                                                tr0.a("Invalid C1 command: ", iB3, "Cea708Decoder");
                                                break;
                                            case 151:
                                                if (!this.l.c) {
                                                    this.h.d(32);
                                                } else {
                                                    int iA3 = b.a(this.h.b(2), this.h.b(2), this.h.b(2), this.h.b(2));
                                                    this.h.b(2);
                                                    b.a(this.h.b(2), this.h.b(2), this.h.b(2), 0);
                                                    this.h.f();
                                                    this.h.f();
                                                    this.h.b(2);
                                                    this.h.b(2);
                                                    int iB5 = this.h.b(2);
                                                    this.h.d(8);
                                                    b bVar5 = this.l;
                                                    bVar5.o = iA3;
                                                    bVar5.l = iB5;
                                                }
                                                z = true;
                                                i3 = 3;
                                                break;
                                            case 152:
                                            case 153:
                                            case 154:
                                            case 155:
                                            case 156:
                                            case 157:
                                            case 158:
                                            case 159:
                                                int i13 = iB3 - 152;
                                                b bVar6 = this.k[i13];
                                                this.h.d(i2);
                                                boolean zF3 = this.h.f();
                                                boolean zF4 = this.h.f();
                                                this.h.f();
                                                int iB6 = this.h.b(i3);
                                                boolean zF5 = this.h.f();
                                                int iB7 = this.h.b(i4);
                                                int iB8 = this.h.b(8);
                                                int iB9 = this.h.b(4);
                                                int iB10 = this.h.b(4);
                                                this.h.d(i2);
                                                this.h.b(6);
                                                this.h.d(i2);
                                                int iB11 = this.h.b(3);
                                                int iB12 = this.h.b(3);
                                                bVar6.c = true;
                                                bVar6.d = zF3;
                                                bVar6.k = zF4;
                                                bVar6.e = iB6;
                                                bVar6.f = zF5;
                                                bVar6.g = iB7;
                                                bVar6.h = iB8;
                                                bVar6.i = iB9;
                                                int i14 = iB10 + 1;
                                                if (bVar6.j != i14) {
                                                    bVar6.j = i14;
                                                    while (true) {
                                                        if ((zF4 && bVar6.f10833a.size() >= bVar6.j) || bVar6.f10833a.size() >= 15) {
                                                            bVar6.f10833a.remove(0);
                                                        }
                                                    }
                                                }
                                                if (iB11 != 0 && bVar6.m != iB11) {
                                                    bVar6.m = iB11;
                                                    int i15 = iB11 - 1;
                                                    int i16 = b.C[i15];
                                                    boolean z3 = b.B[i15];
                                                    int i17 = b.z[i15];
                                                    int i18 = b.A[i15];
                                                    int i19 = b.y[i15];
                                                    bVar6.o = i16;
                                                    bVar6.l = i19;
                                                }
                                                if (iB12 != 0 && bVar6.n != iB12) {
                                                    bVar6.n = iB12;
                                                    int i20 = iB12 - 1;
                                                    int i21 = b.E[i20];
                                                    int i22 = b.D[i20];
                                                    bVar6.a(false, false);
                                                    bVar6.a(b.w, b.F[i20]);
                                                }
                                                if (this.p != i13) {
                                                    this.p = i13;
                                                    this.l = this.k[i13];
                                                }
                                                z = true;
                                                i3 = 3;
                                                break;
                                        }
                                        c2 = 6;
                                        z2 = z;
                                    } else {
                                        z = true;
                                        if (iB3 <= 255) {
                                            this.l.a((char) (iB3 & 255));
                                        } else {
                                            tr0.a("Invalid base command: ", iB3, "Cea708Decoder");
                                            i4 = 7;
                                            i = 2;
                                        }
                                    }
                                    i4 = 7;
                                    i = 2;
                                    c2 = 6;
                                    z2 = z;
                                } else if (iB3 == 127) {
                                    this.l.a((char) 9835);
                                } else {
                                    this.l.a((char) (iB3 & 255));
                                }
                                i = i2;
                                z = true;
                                c2 = 6;
                                z2 = z;
                            }
                            c2 = 6;
                        } else {
                            z = true;
                            int iB13 = this.h.b(8);
                            if (iB13 <= 31) {
                                i4 = 7;
                                if (iB13 > 7) {
                                    if (iB13 <= 15) {
                                        this.h.d(8);
                                    } else if (iB13 <= 23) {
                                        this.h.d(16);
                                    } else if (iB13 <= 31) {
                                        this.h.d(24);
                                    }
                                }
                            } else {
                                i4 = 7;
                                if (iB13 <= 127) {
                                    if (iB13 == 32) {
                                        this.l.a(' ');
                                    } else if (iB13 == 33) {
                                        this.l.a(Typography.nbsp);
                                    } else if (iB13 == 37) {
                                        this.l.a(Typography.ellipsis);
                                    } else if (iB13 == 42) {
                                        this.l.a((char) 352);
                                    } else if (iB13 == 44) {
                                        this.l.a((char) 338);
                                    } else if (iB13 == 63) {
                                        this.l.a((char) 376);
                                    } else if (iB13 == 57) {
                                        this.l.a(Typography.tm);
                                    } else if (iB13 == 58) {
                                        this.l.a((char) 353);
                                    } else if (iB13 == 60) {
                                        this.l.a((char) 339);
                                    } else if (iB13 != 61) {
                                        switch (iB13) {
                                            case 48:
                                                this.l.a((char) 9608);
                                                break;
                                            case 49:
                                                this.l.a(Typography.leftSingleQuote);
                                                break;
                                            case 50:
                                                this.l.a(Typography.rightSingleQuote);
                                                break;
                                            case 51:
                                                this.l.a(Typography.leftDoubleQuote);
                                                break;
                                            case 52:
                                                this.l.a(Typography.rightDoubleQuote);
                                                break;
                                            case 53:
                                                this.l.a(Typography.bullet);
                                                break;
                                            default:
                                                switch (iB13) {
                                                    case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                                                        this.l.a((char) 8539);
                                                        break;
                                                    case JSON_ENCODE_ERROR_VALUE:
                                                        this.l.a((char) 8540);
                                                        break;
                                                    case 120:
                                                        this.l.a((char) 8541);
                                                        break;
                                                    case TPAT_ERROR_VALUE:
                                                        this.l.a((char) 8542);
                                                        break;
                                                    case INVALID_ADS_ENDPOINT_VALUE:
                                                        this.l.a((char) 9474);
                                                        break;
                                                    case INVALID_RI_ENDPOINT_VALUE:
                                                        this.l.a((char) 9488);
                                                        break;
                                                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                                                        this.l.a((char) 9492);
                                                        break;
                                                    case INVALID_METRICS_ENDPOINT_VALUE:
                                                        this.l.a((char) 9472);
                                                        break;
                                                    case 126:
                                                        this.l.a((char) 9496);
                                                        break;
                                                    case 127:
                                                        this.l.a((char) 9484);
                                                        break;
                                                    default:
                                                        tr0.a("Invalid G2 character: ", iB13, "Cea708Decoder");
                                                        break;
                                                }
                                                break;
                                        }
                                    } else {
                                        this.l.a((char) 8480);
                                    }
                                    i = 2;
                                    c2 = 6;
                                } else if (iB13 > 159) {
                                    i = 2;
                                    c2 = 6;
                                    if (iB13 > 255) {
                                        tr0.a("Invalid extended command: ", iB13, "Cea708Decoder");
                                    } else if (iB13 == 160) {
                                        this.l.a((char) 13252);
                                    } else {
                                        tr0.a("Invalid G3 character: ", iB13, "Cea708Decoder");
                                        this.l.a('_');
                                    }
                                } else if (iB13 <= 135) {
                                    this.h.d(32);
                                } else if (iB13 <= 143) {
                                    this.h.d(40);
                                } else if (iB13 <= 159) {
                                    i = 2;
                                    this.h.d(2);
                                    c2 = 6;
                                    this.h.d(this.h.b(6) * 8);
                                }
                                z2 = z;
                            }
                            i = 2;
                            c2 = 6;
                        }
                        i2 = i;
                    }
                }
            } else {
                if (iB != 0) {
                    at0.d("Cea708Decoder", "serviceNumber is non-zero (" + iB + ") when blockSize is 0");
                }
                if (z2) {
                    this.m = j();
                }
                this.o = null;
            }
        }
        if (z2) {
            this.m = j();
        }
        this.o = null;
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10834a;
        public final int b;
        public final byte[] c;
        int d = 0;

        public c(int i, int i2) {
            this.f10834a = i;
            this.b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }
}
