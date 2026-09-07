package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ie, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2615ie implements Ad, NativeAdBaseApi, Repairable, InterfaceC1465Ac {
    public static C14067t A0k;
    public static byte[] A0l;
    public static String[] A0m = {"0QrYY16WpsBKaBkyPEA33iBIoR05UhVT", "YnnsFrkLVth43aFbA8XanJ7Af1ELV", "Oxqa2FUUnPLQ7GUfsty3Y0efzjvyqNtk", "SIKP4BEcnF1kam64buW5uj4ZKlEjFxDR", "vEVPI6RQ4lovzpZyrpWOxFDddvUHwWNp", "NGWOmnzpb", "djSS0JJWnZq1rlBsvyeXY9GnDKzed", "NhvbMWoFDj5W6o0bWnGe4dztWB8buZER"};
    public static final String A0n;
    public static final WeakHashMap<View, WeakReference<C2615ie>> A0o;
    public long A00;
    public Drawable A01;
    public View.OnTouchListener A02;
    public View A03;
    public View A04;
    public View A05;
    public View A06;
    public NativeAdLayout A07;
    public C2G A08;
    public C2862mk A09;
    public C1763Mj A0A;
    public C2828mB A0B;
    public C7z A0C;
    public C14328u A0D;
    public AQ A0E;
    public ViewOnClickListenerC2616ig A0F;
    public InterfaceC2614id A0G;
    public AW A0H;
    public AX A0I;
    public EnumC1472Al A0J;
    public EB A0K;
    public F9 A0L;
    public C1618Gr A0M;
    public C1638Hl A0N;
    public JK A0O;
    public JK A0P;
    public JL A0Q;
    public JL A0R;
    public String A0S;
    public String A0T;
    public WeakReference<C2745kl> A0U;
    public WeakReference<JK> A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public C2873mv A0a;
    public final C14067t A0b;
    public final C2699k1 A0c;
    public final AT A0d;
    public final C1467Ae A0e;
    public final C1518Cv A0f;
    public final String A0g;
    public final String A0h;
    public final List<View> A0i;
    public volatile boolean A0j;

    public static String A0W(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0l, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0e() {
        A0l = new byte[]{-32, Ascii.SUB, 38, Ascii.US, Ascii.RS, -15, 34, -20, Ascii.RS, 33, -18, 32, -13, -22, -24, -22, -20, -21, -23, Ascii.SUB, -20, -62, -27, -95, -17, -16, -11, -95, -19, -16, -30, -27, -26, -27, 38, 73, 57, 74, 82, 85, 81, 70, 89, 74, 5, Ascii.FF, 10, 88, Ascii.FF, 5, 78, 88, 5, 83, 84, 89, 5, 70, 5, 83, 70, 89, 78, 91, 74, 5, 70, 73, -20, -24, -25, Ascii.ESC, 10, Ascii.SI, Ascii.VT, Ascii.DC4, 9, Ascii.VT, -12, Ascii.VT, Ascii.SUB, Ascii.GS, Ascii.NAK, Ascii.CAN, 17, -33, -6, 2, 5, -2, -3, -71, Ascii.CR, 8, -71, 5, 8, -6, -3, -71, -26, -2, -3, 2, -6, -57, -27, 0, 8, Ascii.VT, 4, 3, -65, 19, Ascii.SO, -65, Ascii.SO, 1, 19, 0, 8, Ascii.CR, -65, 19, 4, Ascii.FF, Ascii.SI, Ascii.VT, 0, 19, 4, -65, -24, -29, -65, 5, 17, Ascii.SO, Ascii.FF, -65, 1, 8, 3, -65, Ascii.SI, 0, Ascii.CAN, Ascii.VT, Ascii.SO, 0, 3, -65, -58, -60, Ascii.DC2, -58, -13, Ascii.CAN, Ascii.RS, Ascii.SI, Ascii.FS, Ascii.CAN, Ascii.VT, Ascii.SYN, -54, Ascii.SI, Ascii.FS, Ascii.FS, Ascii.EM, Ascii.FS, -40, -76, -23, Ascii.SO, Ascii.SYN, 1, Ascii.FF, 9, 4, -64, 19, 5, Ascii.DC4, -64, Ascii.SI, 6, -64, 3, Ascii.FF, 9, 3, Ascii.VT, 1, 2, Ascii.FF, 5, -64, Ascii.SYN, 9, 5, Ascii.ETB, 19, 34, 58, 57, 62, 54, 43, 62, 58, 76, -11, 59, 68, 71, -11, 62, 56, 68, 67, -11, 62, 72, -11, 62, 72, -11, 66, 62, 72, 72, 62, 67, 60, 3, 0, Ascii.CAN, Ascii.ETB, Ascii.FS, Ascii.DC4, 9, Ascii.FS, Ascii.CAN, 42, -45, Ascii.FS, 38, -45, 32, Ascii.FS, 38, 38, Ascii.FS, 33, Ascii.SUB, -31, Ascii.GS, 69, 67, 68, -16, SignedBytes.MAX_POWER_OF_TWO, 66, 63, 70, 57, 52, 53, -16, 49, -16, 38, 57, 53, 71, 52, 71, 90, 79, 92, 75, 6, 39, 74, 6, 93, 71, 89, 6, 71, 82, 88, 75, 71, 74, 95, 6, 88, 75, 77, 79, 89, 90, 75, 88, 75, 74, 6, 93, 79, 90, 78, 6, 71, 6, 60, 79, 75, 93, Ascii.DC4, 6, 39, 91, 90, 85, 6, 91, 84, 88, 75, 77, 79, 89, 90, 75, 88, 79, 84, 77, 6, 71, 84, 74, 6, 86, 88, 85, 73, 75, 75, 74, 79, 84, 77, Ascii.DC4, 35, 54, 73, 62, 75, 58, -11, 54, 57, -11, 57, 58, 72, 73, 71, 68, 78, 58, 57, -55, -36, -17, -28, -15, -32, -101, -36, -33, -101, -25, -22, -36, -33, -101, -19, -32, -20, -16, -32, -18, -17, -32, -33, -31, -12, -16, 2, -85, -20, -9, -3, -16, -20, -17, 4, -85, -3, -16, -14, -12, -2, -1, -16, -3, -16, -17, -85, 2, -12, -1, -13, -85, -20, -85, -39, -20, -1, -12, 1, -16, -52, -17, -71, -85, -52, 0, -1, -6, -85, 0, -7, -3, -16, -14, -12, -2, -1, -16, -3, -12, -7, -14, -85, -20, -7, -17, -85, -5, -3, -6, -18, -16, -16, -17, -12, -7, -14, -71, -22, -3, -7, Ascii.VT, -76, 2, 3, 8, -76, 6, -7, -5, -3, 7, 8, -7, 6, -7, -8, -76, Ascii.VT, -3, 8, -4, -76, 8, -4, -3, 7, -76, -30, -11, 8, -3, 10, -7, -43, -8, 10, Ascii.CR, -55, Ascii.SYN, Ascii.SO, Ascii.CR, Ascii.DC2, 10, -55, Ascii.GS, 34, Ascii.EM, Ascii.SO, -55, Ascii.DC2, Ascii.FS, -55, Ascii.ETB, Ascii.CAN, Ascii.GS, -55, Ascii.FS, Ascii.RS, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.ESC, Ascii.GS, Ascii.SO, Ascii.CR, -41, 46, Base64.padSymbol, 54, 56, Ascii.FF, 9, 57, 5, 10, 9, 51, 52, 66, 67, 65, 62, 72, 81, 84, 70, 73, 38, 73, 69, 72, 58, Base64.padSymbol, Ascii.SUB, Base64.padSymbol, 1, 2, -7, 60, 58, 69, 69, 62, Base64.padSymbol, -7, 70, 72, 75, 62, -7, 77, 65, 58, 71, -7, 72, 71, 60, 62, -27, -40, -21, -32, -19, -36};
        String[] strArr = A0m;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0m[3] = "WbNUBB1XQVUYjPuN5kyqwH0pcEyoS9gz";
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0332 A[LOOP:0: B:109:0x032c->B:111:0x0332, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x035f  */
    /* JADX WARN: Code duplicated, block: B:123:0x036f  */
    /* JADX WARN: Code duplicated, block: B:125:0x037f  */
    /* JADX WARN: Code duplicated, block: B:129:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:131:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:134:0x0417  */
    /* JADX WARN: Code duplicated, block: B:141:0x046a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x046c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0483  */
    /* JADX WARN: Code duplicated, block: B:148:0x0492  */
    /* JADX WARN: Code duplicated, block: B:150:0x0496  */
    /* JADX WARN: Code duplicated, block: B:153:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0224  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0g(View view, View view2, List<View> list, boolean z) {
        Iterator it;
        C14328u c14328u;
        C1574Ez c1574Ez;
        String[] strArr;
        String strA1C;
        if (!A0r()) {
            this.A0c.A0F().AGi();
        }
        if (view == null) {
            String strA0W = A0W(256, 19, 96);
            if (!A0r()) {
                this.A0c.A0F().AGh(strA0W);
            }
            throw new IllegalArgumentException(strA0W);
        }
        if (list == null || list.size() == 0) {
            String strA0W2 = A0W(172, 30, 48);
            if (!A0r()) {
                this.A0c.A0F().AGh(strA0W2);
            }
            throw new IllegalArgumentException(strA0W2);
        }
        C2873mv c2873mvA0C = A0C();
        if (c2873mvA0C == null) {
            String strA0W3 = A0W(21, 13, 17);
            if (!A0r()) {
                this.A0c.A0F().AGh(strA0W3);
            }
            Log.e(A0n, strA0W3);
            C1468Ag c1468Ag = new C1468Ag(AdErrorType.NATIVE_AD_IS_NOT_LOADED, strA0W3);
            A12().A0F().A3D(C1517Cu.A01(this.A00), c1468Ag.A03().getErrorCode(), c1468Ag.A04());
            if (!C14499m.A2d(this.A0c) || this.A0G == null) {
                return;
            }
            this.A0G.AD4(c1468Ag);
            return;
        }
        String str = this.A0T;
        if ((view instanceof FrameLayout) && str != null) {
            A0h((FrameLayout) view, str);
        }
        if (this.A07 != null) {
            ((C2728kU) this.A07.getNativeAdLayoutApi()).A02();
        }
        C2745kl c2745kl = this.A0U.get();
        if (c2745kl != null && c2873mvA0C.A08() == 1) {
            c2745kl.A03(DB.AN_INFO_ICON);
        }
        if (view2 != null) {
            boolean z2 = (view2 instanceof AdNativeComponentView) && ((AdNativeComponentView) view2).getAdContentsView() != null;
            boolean z3 = z && (view2 instanceof ImageView);
            if (!z2 && !z3) {
                if (this.A0G != null) {
                    C1468Ag c1468Ag2 = new C1468Ag(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0W(511, 31, 57));
                    A12().A0F().A3D(C1517Cu.A01(this.A00), c1468Ag2.A03().getErrorCode(), c1468Ag2.A04());
                    this.A0G.AD4(c1468Ag2);
                    return;
                }
                return;
            }
            View view3 = this.A04;
            if (A0m[3].charAt(5) != 'B') {
                String[] strArr2 = A0m;
                strArr2[6] = "BCYbWK19bS9ET6nCyqUucyCTxntwC";
                strArr2[1] = "hUEQWKvNS0BeeCCeuSbrKV1BB6cqb";
                if (view3 != null) {
                    Log.w(A0n, A0W(275, 80, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
                    unregisterView();
                }
            } else {
                A0m[3] = "VFOGhBJepBYKNQ0g15YaI4y2lFqguygQ";
                if (view3 != null) {
                    Log.w(A0n, A0W(275, 80, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
                    unregisterView();
                }
            }
            boolean zContainsKey = A0o.containsKey(view);
            String[] strArr3 = A0m;
            if (strArr3[6].length() != strArr3[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0m;
            strArr4[0] = "r1dCEV0W05obqeylsxysUOCLLtyqbDkO";
            strArr4[4] = "jsU6g8E1kSPqSuKqGJQzSRDrUMjHNr5E";
            if (zContainsKey && A0o.get(view).get() != null) {
                Log.w(A0n, A0W(398, 75, 27));
                A0o.get(view).get().unregisterView();
            }
            this.A0F = new ViewOnClickListenerC2616ig(this, this.A0c, null);
            this.A04 = view;
            this.A06 = view2;
            if (view instanceof ViewGroup) {
                this.A0K = new EB(this.A0c, new C2620ik(this));
                ((ViewGroup) view).addView(this.A0K);
            }
            if (c2873mvA0C.A0S()) {
                this.A0O = new C2619ij(this);
                this.A0Q = new JL(view, 1, new WeakReference(this.A0O), this.A0c);
                this.A0Q.A0Y(false);
                this.A0Q.A0X(c2873mvA0C.A09());
                this.A0Q.A0U();
                this.A0c.A0F().ABt();
            }
            ArrayList arrayList = new ArrayList(list);
            if (this.A05 == null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    A1L((View) it.next());
                }
                AbstractC2855md abstractC2855mdA10 = A10();
                if (z) {
                    A1L(view);
                    arrayList.add(view);
                }
                int iA00 = A00();
                this.A0P = new C2618ii(this, view2, z3, c2873mvA0C);
                if (view2 instanceof AdNativeComponentView) {
                    this.A03 = ((AdNativeComponentView) view2).getAdContentsView();
                } else {
                    this.A03 = view2;
                }
                if (C14499m.A1s(this.A0c)) {
                    strA1C = A1C();
                    AJ ajA0B = A12().A0B();
                    View view4 = this.A03;
                    if (strA1C == null) {
                        strA1C = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
                    }
                    ajA0B.AJt(view4, strA1C, this.A03 instanceof IM, true);
                }
                this.A0R = new JL(this.A03, iA00, A03(), true, new WeakReference(this.A0P), this.A0c);
                this.A0R.A0Y(!A0r());
                this.A0R.A0W(A01());
                this.A0R.A0X(A02());
                if (this.A03 instanceof C1574Ez) {
                    c1574Ez = (C1574Ez) this.A03;
                    strArr = A0m;
                    if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
                        A0m[3] = "9jWMkBrIWAaQq3BshIoiK9kOFApm7Mnb";
                        c1574Ez.A06(this.A0R);
                    }
                }
                this.A09 = new C2862mk(this.A0c, new Cif(this, null), this.A0R, this.A0a);
                this.A09.A0H(arrayList);
                A0o.put(view, new WeakReference<>(this));
                if (C14499m.A1A(this.A0c)) {
                    this.A0L = new F9();
                    this.A0L.A0C(this.A0g);
                    this.A0L.A0B(this.A0c.getPackageName());
                    this.A0L.A0A(this.A0R);
                    if (this.A0a != null) {
                        C2860mi c2860miA0E = this.A0a.A0E();
                        this.A0L.A08(c2860miA0E.A03(), c2860miA0E.A04());
                    }
                    c14328u = this.A0D;
                    if (A0m[3].charAt(5) != 'B') {
                        String[] strArr5 = A0m;
                        strArr5[6] = "iJInlaPqSCsodlo1snRpIwz9DPt1A";
                        strArr5[1] = "DYzZZFtfMBLderHMiZZFXfgJZWHC0";
                        if (c14328u != null) {
                            this.A0L.A09(this.A0D.A0C());
                        } else if (this.A0A != null) {
                            this.A0L.A09(this.A0A.A0J().A0C());
                        }
                    } else if (c14328u != null) {
                        this.A0L.A09(this.A0D.A0C());
                    } else if (this.A0A != null) {
                        this.A0L.A09(this.A0A.A0J().A0C());
                    }
                    this.A04.getOverlay().add(this.A0L);
                    return;
                }
                return;
            }
            View view5 = this.A05;
            String[] strArr6 = A0m;
            if (strArr6[2].charAt(3) != strArr6[7].charAt(3)) {
                String[] strArr7 = A0m;
                strArr7[0] = "7BxfhPTBtrovnc2SNqJYjum2f5qDPcpL";
                strArr7[4] = "Q5pxYg7VFdMmLRDnYTITcnTwa1eIsVWj";
                arrayList.add(view5);
                it = arrayList.iterator();
                while (it.hasNext()) {
                    A1L((View) it.next());
                }
                AbstractC2855md abstractC2855mdA11 = A10();
                if (z && abstractC2855mdA11 != null && abstractC2855mdA11.A1E()) {
                    A1L(view);
                    arrayList.add(view);
                }
                int iA01 = A00();
                this.A0P = new C2618ii(this, view2, z3, c2873mvA0C);
                if (view2 instanceof AdNativeComponentView) {
                    this.A03 = ((AdNativeComponentView) view2).getAdContentsView();
                } else {
                    this.A03 = view2;
                }
                if (C14499m.A1s(this.A0c)) {
                    strA1C = A1C();
                    AJ ajA0B2 = A12().A0B();
                    View view6 = this.A03;
                    if (strA1C == null) {
                        strA1C = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
                    }
                    ajA0B2.AJt(view6, strA1C, this.A03 instanceof IM, true);
                }
                this.A0R = new JL(this.A03, iA01, A03(), true, new WeakReference(this.A0P), this.A0c);
                this.A0R.A0Y(!A0r());
                this.A0R.A0W(A01());
                this.A0R.A0X(A02());
                if (this.A03 instanceof C1574Ez) {
                    c1574Ez = (C1574Ez) this.A03;
                    strArr = A0m;
                    if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
                        A0m[3] = "9jWMkBrIWAaQq3BshIoiK9kOFApm7Mnb";
                        c1574Ez.A06(this.A0R);
                    }
                }
                this.A09 = new C2862mk(this.A0c, new Cif(this, null), this.A0R, this.A0a);
                this.A09.A0H(arrayList);
                A0o.put(view, new WeakReference<>(this));
                if (C14499m.A1A(this.A0c)) {
                    this.A0L = new F9();
                    this.A0L.A0C(this.A0g);
                    this.A0L.A0B(this.A0c.getPackageName());
                    this.A0L.A0A(this.A0R);
                    if (this.A0a != null && this.A0a.A0E().A03() > 0) {
                        C2860mi c2860miA0E2 = this.A0a.A0E();
                        this.A0L.A08(c2860miA0E2.A03(), c2860miA0E2.A04());
                    }
                    c14328u = this.A0D;
                    if (A0m[3].charAt(5) != 'B') {
                        String[] strArr8 = A0m;
                        strArr8[6] = "iJInlaPqSCsodlo1snRpIwz9DPt1A";
                        strArr8[1] = "DYzZZFtfMBLderHMiZZFXfgJZWHC0";
                        if (c14328u != null) {
                            this.A0L.A09(this.A0D.A0C());
                        } else if (this.A0A != null) {
                            this.A0L.A09(this.A0A.A0J().A0C());
                        }
                    } else if (c14328u != null) {
                        this.A0L.A09(this.A0D.A0C());
                    } else if (this.A0A != null && this.A0A.A0J() != null) {
                        this.A0L.A09(this.A0A.A0J().A0C());
                    }
                    this.A04.getOverlay().add(this.A0L);
                    return;
                }
                return;
            }
        } else {
            if (this.A0J != EnumC1472Al.A06) {
                AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEBANNERAD;
                String strA0W4 = A0W(202, 33, 101);
                C1468Ag c1468Ag3 = new C1468Ag(adErrorType, strA0W4);
                A12().A0F().A3D(C1517Cu.A01(this.A00), c1468Ag3.A03().getErrorCode(), c1468Ag3.A04());
                if (this.A0G != null) {
                    this.A0G.AD4(c1468Ag3);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    String str2 = A0n;
                    if (A0m[3].charAt(5) == 'B') {
                        A0m[3] = "KISMvB3VNIc1t4pH9OUWIwxPU7abTBQu";
                        Log.e(str2, strA0W4);
                        return;
                    } else {
                        String[] strArr9 = A0m;
                        strArr9[2] = "I0o2CociGt9PfWtihtc1uzdPzn26Oc3b";
                        strArr9[7] = "DL9r7FwT46CQ5uSYOng5HfHjynm8xWWf";
                        Log.e(str2, strA0W4);
                        return;
                    }
                }
                return;
            }
            AdErrorType adErrorType2 = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
            String strA0W5 = A0W(235, 21, 67);
            C1468Ag c1468Ag4 = new C1468Ag(adErrorType2, strA0W5);
            A12().A0F().A3D(C1517Cu.A01(this.A00), c1468Ag4.A03().getErrorCode(), c1468Ag4.A04());
            if (this.A0G != null) {
                this.A0G.AD4(c1468Ag4);
            }
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            String str3 = A0n;
            if (A0m[5].length() != 3) {
                String[] strArr10 = A0m;
                strArr10[0] = "ymh7ZtbYw7oyMwS2HukMuI2t1Xj3fY7y";
                strArr10[4] = "GGURsKjIWyfUU1Vu9BOr0pf9u6pcVKo4";
                Log.e(str3, strA0W5);
                return;
            }
        }
        throw new RuntimeException();
    }

    static {
        A0e();
        A0n = C2615ie.class.getSimpleName();
        A0o = new WeakHashMap<>();
    }

    public C2615ie(Context context, String str, AT at, boolean z) {
        this.A0h = UUID.randomUUID().toString();
        this.A0J = EnumC1472Al.A06;
        this.A0E = AQ.A04;
        this.A08 = C2G.A03;
        this.A0U = new WeakReference<>(null);
        this.A0i = new ArrayList();
        this.A0f = new C1518Cv();
        this.A0Z = false;
        this.A0Y = false;
        this.A00 = -1L;
        if (context instanceof C2699k1) {
            this.A0c = (C2699k1) context;
        } else if (!z) {
            this.A0c = C13766p.A04(context);
        } else {
            this.A0c = C13766p.A03(context);
        }
        this.A0c.A0O(this);
        this.A0g = str;
        this.A0d = at;
        if (A0k != null) {
            this.A0b = A0k;
        } else {
            this.A0b = new C14067t(this.A0c);
        }
        this.A05 = new View(context);
        this.A0e = new C1467Ae(this.A0c, this);
    }

    public C2615ie(C2615ie c2615ie) {
        this((Context) c2615ie.A0c, (String) null, c2615ie.A0d, true);
        this.A0D = c2615ie.A0D;
        this.A0a = c2615ie.A0a;
        this.A0B = c2615ie.A0B;
        this.A0j = true;
        this.A05 = new View(this.A0c);
    }

    public C2615ie(C2699k1 c2699k1, C2873mv c2873mv, C14328u c14328u, AT at) {
        this((Context) c2699k1, (String) null, at, true);
        this.A0a = c2873mv;
        this.A0D = c14328u;
        this.A0j = true;
        this.A05 = new View(c2699k1);
    }

    public C2615ie(C2699k1 c2699k1, C2873mv c2873mv, C14328u c14328u, AT at, C2828mB c2828mB) {
        this(c2699k1, c2873mv, c14328u, at);
        this.A0B = c2828mB;
    }

    private int A00() {
        if (this.A0D != null) {
            return this.A0D.A04();
        }
        if (this.A0A == null || this.A0A.A0J() == null) {
            return 1;
        }
        C14328u c14328uA0J = this.A0A.A0J();
        String[] strArr = A0m;
        String str = strArr[6];
        String str2 = strArr[1];
        int length = str.length();
        int viewabilityThreshold = str2.length();
        if (length != viewabilityThreshold) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0m;
        strArr2[2] = "P5kYLn6xwAUrjDfDuw88TuaVt88D3vtD";
        strArr2[7] = "ZJzVQNISDO4cH7XUZ38T2d7bCdM1k8uN";
        return c14328uA0J.A04();
    }

    private int A01() {
        if (this.A0D != null) {
            return this.A0D.A07();
        }
        if (this.A0a != null) {
            return this.A0a.A0C();
        }
        if (this.A0A != null && this.A0A.A0J() != null) {
            return this.A0A.A0J().A07();
        }
        return 0;
    }

    private int A02() {
        if (this.A0D != null) {
            return this.A0D.A08();
        }
        if (this.A0a != null) {
            return this.A0a.A0D();
        }
        if (this.A0A != null && this.A0A.A0J() != null) {
            return this.A0A.A0J().A08();
        }
        return 1000;
    }

    private int A03() {
        if (this.A0D != null) {
            return this.A0D.A09();
        }
        C1763Mj c1763Mj = this.A0A;
        if (A0m[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        A0m[5] = "Xt";
        if (c1763Mj == null || this.A0A.A0J() == null) {
            return 0;
        }
        return this.A0A.A0J().A09();
    }

    public static Drawable A05(C2699k1 c2699k1, Bitmap bitmap, boolean z, String str) {
        BitmapDrawable bitmapDrawableA00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c2699k1.getResources(), bitmap);
        if (z && (bitmapDrawableA00 = AbstractC1637Hk.A00(c2699k1, str)) != null) {
            Drawable iconViewDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawableA00});
            return iconViewDrawable;
        }
        return bitmapDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C1469Ah {
        EnumC1472Al enumC1472AlA00 = C1476Aq.A00(str2);
        if (enumC1472AlA00 != null) {
            EnumC1472Al template = EnumC1472Al.A05;
            if (enumC1472AlA00 == template) {
                return new NativeBannerAd(context, str);
            }
            EnumC1472Al template2 = EnumC1472Al.A06;
            if (enumC1472AlA00 == template2) {
                return new NativeAd(context, str);
            }
            throw new C1469Ah(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(34, 34, 117), enumC1472AlA00));
        }
        throw new C1469Ah(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(106, 50, 47), str2));
    }

    private final C2873mv A0C() {
        C2873mv c2873mv = this.A0a;
        if (c2873mv != null && c2873mv.A0R()) {
            return c2873mv;
        }
        return null;
    }

    private C2860mi A0F() {
        return A0G(false);
    }

    private C2860mi A0G(boolean z) {
        if (this.A0a != null) {
            C2873mv c2873mv = this.A0a;
            if (A0m[3].charAt(5) == 'B') {
                String[] strArr = A0m;
                strArr[0] = "rkQiEYXoMEhriwkmxTS9YqbekXjRctvV";
                strArr[4] = "aQIgqL6bCxVEsMgFZvYj1f08oAvgjHgO";
                if (c2873mv.A0R()) {
                    if (z) {
                        C2873mv c2873mv2 = this.A0a;
                        if (A0m[3].charAt(5) == 'B') {
                            A0m[3] = "EWl26Bqfon8mX0lHHC6z05409Pwx5AXq";
                            c2873mv2.A0I();
                        }
                    }
                    return this.A0a.A0E();
                }
            }
            throw new RuntimeException();
        }
        return new C2860mi();
    }

    public static C2617ih A0K() {
        return new C2617ih();
    }

    public static C2615ie A0L(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (C2615ie) ((C6Z) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (C2615ie) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final AU getAdChoicesIcon() {
        return A0F().A0D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final AV getAdStarRating() {
        return A0F().A0G();
    }

    private AdPlacementType A0R() {
        if (this.A0J == EnumC1472Al.A06) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0a() {
        for (View view : this.A0i) {
            view.setOnClickListener(null);
            if (A0m[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            A0m[3] = "reBfvBMaH6BqwlxZ2WqAQZq3knZpIvyz";
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0i.clear();
    }

    private void A0b() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            C2.A0M(new C2(), this.A0c, C5.A00(getAdChoicesLinkUrl()), A1C());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c() {
        this.A0f.A05();
        this.A0e.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d() {
        if (this.A0Q != null) {
            this.A0Q.A0V();
            this.A0c.A0F().ABu();
            this.A0Q = null;
        }
    }

    public static void A0f(Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (A0m[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A0m;
        strArr[6] = "LXDT52DRzEPuIKBbeK5QN38hLQjcy";
        strArr[1] = "Z1aNossC2MxjaxQyIIrn4vHalGw3J";
        imageView.setBackground(null);
    }

    private void A0h(FrameLayout frameLayout, String str) {
        if (this.A0N != null) {
            frameLayout.removeView(this.A0N);
        }
        this.A0N = AbstractC1637Hk.A01(C13766p.A03(this.A0c), str);
        if (this.A0N != null) {
            frameLayout.addView(this.A0N, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0N);
        }
    }

    private void A0i(C2873mv c2873mv, boolean z) {
        if (c2873mv == null) {
            return;
        }
        boolean zEquals = this.A0E.equals(AQ.A04);
        String strA0W = A0W(595, 6, 7);
        if (zEquals) {
            C2860mi c2860miA0E = c2873mv.A0E();
            String clientToken = c2873mv.A7E();
            if (!TextUtils.isEmpty(clientToken)) {
                this.A0b.A0d(new AF(clientToken, this.A0c.A0A()));
            }
            AU auA0F = c2860miA0E.A0F();
            String[] strArr = A0m;
            if (strArr[2].charAt(3) == strArr[7].charAt(3)) {
                throw new RuntimeException();
            }
            A0m[3] = "olK6BBrMvSH2F6L4J2jXYHYWLLMocGr7";
            if (auA0F != null) {
                C14047r c14047r = new C14047r(c2860miA0E.A0F().getUrl(), c2860miA0E.A0F().getHeight(), c2860miA0E.A0F().getWidth(), c2873mv.A0G(), A0W(595, 6, 7));
                c14047r.A00 = this.A0C;
                this.A0b.A0V();
                this.A0b.A0b(c14047r);
            }
            if (!this.A0J.equals(EnumC1472Al.A05)) {
                if (c2860miA0E.A0E() != null) {
                    this.A0b.A0b(new C14047r(c2860miA0E.A0E().getUrl(), c2860miA0E.A0E().getHeight(), c2860miA0E.A0E().getWidth(), c2873mv.A0G(), A0W(595, 6, 7)));
                }
                if (c2873mv.A0H() != null) {
                    for (C2615ie c2615ie : c2873mv.A0H()) {
                        if (c2615ie.getAdCoverImage() != null) {
                            this.A0b.A0b(new C14047r(c2615ie.getAdCoverImage().getUrl(), c2615ie.getAdCoverImage().getHeight(), c2615ie.getAdCoverImage().getWidth(), c2873mv.A0G(), A0W(595, 6, 7)));
                        }
                    }
                }
                String strA0b = c2860miA0E.A0b();
                if (!TextUtils.isEmpty(strA0b)) {
                    this.A0b.A0a(new C14027p(strA0b, c2873mv.A0G(), A0W(595, 6, 7), c2860miA0E.A0A()));
                }
            }
            AbstractC2855md abstractC2855mdA0C = c2860miA0E.A0C();
            if (abstractC2855mdA0C != null && abstractC2855mdA0C.A1F()) {
                C14027p c14027p = new C14027p(abstractC2855mdA0C.A0f(), abstractC2855mdA0C.A0r(), strA0W);
                c14027p.A04 = true;
                c14027p.A03 = A0W(0, 5, 66);
                this.A0b.A0X(c14027p);
            }
        }
        this.A0b.A0W(new C2621il(this, c2873mv, z), new C13997m(c2873mv.A0G(), strA0W));
    }

    private void A0j(C2I c2i) {
        if (this.A0a == null) {
            return;
        }
        this.A0a.A0K(c2i);
    }

    public static void A0k(NativeAdImageApi nativeAdImageApi, ImageView imageView, C2699k1 c2699k1) {
        if (nativeAdImageApi != null && imageView != null) {
            new AsyncTaskC2494gc(imageView, c2699k1).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0n(InterfaceC2614id interfaceC2614id) {
        this.A0G = interfaceC2614id;
    }

    private final void A0o(String str) {
        this.A0S = str;
    }

    private void A0p(List<View> list, View view) {
        if (this.A0d != null && this.A0d.AJ3(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                A0p(list, viewGroup.getChildAt(i));
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0q() {
        return A19() == AZ.A05 || A19() == AZ.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0r() {
        return A0F().A0e();
    }

    public final long A0y() {
        return this.A00;
    }

    public final C2873mv A0z() {
        return this.A0a;
    }

    public final AbstractC2855md A10() {
        return A0F().A0C();
    }

    public final C14067t A11() {
        return this.A0b;
    }

    public final C2699k1 A12() {
        return this.A0c;
    }

    public final ViewOnClickListenerC2616ig A13() {
        return this.A0F;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A14, reason: merged with bridge method [inline-methods] */
    public final AU getAdCoverImage() {
        return A0F().A0E();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A15, reason: merged with bridge method [inline-methods] */
    public final AU getAdIcon() {
        return A0F().A0F();
    }

    public final InterfaceC2614id A16() {
        return this.A0G;
    }

    public final AW A17() {
        return this.A0H;
    }

    public final AX A18() {
        return this.A0I;
    }

    public final AZ A19() {
        return A0F().A0H();
    }

    public final C1518Cv A1A() {
        return this.A0f;
    }

    public final JL A1B() {
        return this.A0R;
    }

    public final String A1C() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A7E();
    }

    public final String A1D() {
        return this.A0T;
    }

    public final String A1E() {
        return A0G(true).A0N();
    }

    public final String A1F() {
        return A0G(true).A0O();
    }

    public final String A1G() {
        return A0F().A0a();
    }

    public final String A1H() {
        if (this.A0a == null || TextUtils.isEmpty(this.A0a.A0E().A0b())) {
            return null;
        }
        return this.A0b.A0S(this.A0a.A0E().A0b());
    }

    public final List<C2615ie> A1I() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A0H();
    }

    public final void A1J() {
        if (!AbstractC12933h.A00(this.A0c.A02()).A0O(this.A0c, false)) {
            A0b();
            if (A0m[5].length() == 3) {
                throw new RuntimeException();
            }
            A0m[3] = "yREZ0BSYt8CSunaR9f1myx0zIAs3a5bO";
            return;
        }
        EH ehA01 = EI.A01(this.A0c, this.A0c.A0A(), A1C(), this.A07);
        if (ehA01 == null) {
            A0b();
        } else {
            ((C2728kU) this.A07.getNativeAdLayoutApi()).A03(ehA01);
            ehA01.A0K();
        }
    }

    public final void A1K(Drawable drawable) {
        this.A01 = drawable;
        A1f(drawable != null, true);
    }

    public final void A1L(View view) {
        this.A0i.add(view);
        view.setOnClickListener(this.A0F);
        view.setOnTouchListener(this.A0F);
        if (C14499m.A1A(view.getContext())) {
            view.setOnLongClickListener(this.A0F);
        }
    }

    public final void A1M(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, imageView, arrayList, true);
    }

    public final void A1N(View view, ImageView imageView, List<View> clickableViews) {
        A0g(view, imageView, clickableViews, true);
    }

    public final void A1O(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, adNativeComponentView, arrayList, false);
    }

    public final void A1P(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews) {
        A0g(view, adNativeComponentView, clickableViews, false);
    }

    public final void A1Q(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews, boolean z) {
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1R(View view, AdNativeComponentView adNativeComponentView, boolean z) {
        List<View> clickableViews = new ArrayList<>();
        A0p(clickableViews, view);
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1S(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Y = true;
        }
    }

    public final void A1T(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Z = true;
        }
    }

    public final void A1U(NativeAdBase nativeAdBase, NativeAdListener nativeAdListener) {
        if (nativeAdListener == null) {
            return;
        }
        A0n(new M0(nativeAdListener, nativeAdBase));
    }

    public final void A1V(NativeAdLayout nativeAdLayout) {
        this.A07 = nativeAdLayout;
    }

    public final void A1W(C2873mv c2873mv) {
        A0i(c2873mv, true);
        if (this.A0G != null && c2873mv.A0H() != null) {
            C2623in c2623in = new C2623in(this);
            for (C2615ie c2615ie : c2873mv.A0H()) {
                if (A0m[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0m;
                strArr[0] = "7JUEXy8BV6wMe69mvRG8Hisl1h58kfsH";
                strArr[4] = "Ag7M0cktqfZPxcWhbEyn8XCMGlxm5ALn";
                c2615ie.A0j(c2623in);
            }
        }
    }

    public final void A1X(C2745kl c2745kl) {
        this.A0U = new WeakReference<>(c2745kl);
    }

    public final void A1Y(AQ aq, String str, C7z c7z) {
        if (str == null) {
            this.A0c.A0F().A3G();
        } else {
            this.A0c.A0F().A3F();
        }
        this.A00 = System.currentTimeMillis();
        boolean z = this.A0j;
        String[] strArr = A0m;
        if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
            String[] strArr2 = A0m;
            strArr2[0] = "knecuAJjZigTf7VsFCGhTGCW7dxKplKn";
            strArr2[4] = "uRrNlLGUJL1gxvEKewtOLFu1Ztix0dl1";
            if (z) {
                AdSettings.IntegrationErrorMode integrationErrorModeA00 = C3A.A00(this.A0c);
                String strA0W = A0W(565, 30, 105);
                AdSettings.IntegrationErrorMode integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
                if (!integrationErrorMode.equals(integrationErrorModeA00)) {
                    C1468Ag c1468Ag = new C1468Ag(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0W(565, 30, 105));
                    A12().A0F().A3D(C1517Cu.A01(this.A00), c1468Ag.A03().getErrorCode(), c1468Ag.A04());
                    if (this.A0G != null) {
                        this.A0G.AD4(c1468Ag);
                    } else {
                        Log.e(A0W(68, 17, 54), strA0W);
                    }
                    C14138b c14138b = new C14138b(strA0W);
                    A12().A08().AAu(A0W(542, 3, 93), AbstractC14128a.A0c, c14138b);
                } else {
                    throw new C3F(strA0W);
                }
            }
            this.A0j = true;
            this.A0E = aq;
            if (aq.equals(AQ.A05)) {
                C2G c2g = C2G.A05;
                if (A0m[3].charAt(5) == 'B') {
                    A0m[3] = "N11XMBa1eBkGGouoRChlRsXEwEtHvHDZ";
                    this.A08 = c2g;
                }
            }
            this.A0C = c7z;
            AnonymousClass37 anonymousClass37 = new AnonymousClass37(this.A0g, this.A0J, A0R(), null, 1, new C2821m4());
            anonymousClass37.A05(aq);
            anonymousClass37.A06(this.A0S);
            anonymousClass37.A07(this.A0T);
            this.A0A = new C1763Mj(this.A0c, anonymousClass37);
            this.A0A.A0S(new C2624io(this));
            this.A0A.A0W(str);
            return;
        }
        throw new RuntimeException();
    }

    public final void A1Z(AW aw) {
        this.A0H = aw;
    }

    public final void A1a(AX ax) {
        this.A0I = ax;
    }

    public final void A1b(EnumC1472Al enumC1472Al) {
        if (!A0r()) {
            if (EnumC1472Al.A05.equals(enumC1472Al)) {
                this.A0c.A0F().A3J(AdPlacementType.NATIVE_BANNER.toString(), this.A0g);
            } else {
                this.A0c.A0F().A3J(AdPlacementType.NATIVE.toString(), this.A0g);
            }
        }
        this.A0J = enumC1472Al;
    }

    public final void A1c(JK jk) {
        this.A0V = new WeakReference<>(jk);
    }

    public final void A1d(boolean z) {
        this.A0W = z;
    }

    public final void A1e(boolean z) {
        this.A0X = z;
    }

    public final void A1f(boolean z, boolean z2) {
        String strA0W;
        if (z) {
            if (this.A0E.equals(AQ.A05)) {
                boolean zA0r = A0r();
                if (A0m[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0m;
                strArr[6] = "maLBxQjysuwmJ75m3YPaJDHU5JlBu";
                strArr[1] = "hXXEi4DazsshJWFEyRiAh7tUxgC1d";
                if (!zA0r && this.A0G != null) {
                    this.A0G.AE5();
                }
            }
            if (this.A0R != null) {
                this.A0R.A0U();
                this.A0e.A09();
                return;
            }
            return;
        }
        if (this.A0R != null) {
            C2873mv adapter = A0z();
            if (adapter != null) {
                strA0W = adapter.A0G();
            } else if (A0m[5].length() != 3) {
                String[] strArr2 = A0m;
                strArr2[2] = "2ETmOz1YodPf8MKRGGB9YcIoy7FDTpAq";
                strArr2[7] = "k5VZ8yDbY0Zqj8FxkeEerY08JJe7M6tR";
                strA0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            } else {
                String[] strArr3 = A0m;
                strArr3[0] = "JjUCnZOckAfeDcKZajvIf0dyi7sruRRg";
                strArr3[4] = "GlO3j5qd4HFQ8L5mPWBpkp3onxgG8Q98";
                strA0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            }
            this.A0e.A0C(this.A0c, strA0W);
            this.A0R.A0V();
        }
        if (this.A0G != null && z2) {
            C1468Ag c1468AgA01 = C1468Ag.A01(AdErrorType.BROKEN_MEDIA_ERROR, A0W(85, 21, 41));
            A12().A0F().A3D(C1517Cu.A01(this.A00), c1468AgA01.A03().getErrorCode(), c1468AgA01.A04());
            this.A0G.AD4(c1468AgA01);
        }
    }

    public final boolean A1g() {
        return this.A07 == null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1465Ac
    public final int A7T() {
        View view = this.A06;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof IM) {
                return ((IM) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C1463Aa(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1477Au.A05(A0W(552, 7, 95), A0W(355, 19, 101), A0W(545, 7, 101));
        if (C14499m.A1s(this.A0c)) {
            A12().A0B().AJZ(this.A03);
        }
        if (!A0r()) {
            this.A0c.A0F().A3K();
        }
        if (this.A0A != null) {
            this.A0A.A0Y(true);
            this.A0A.A0K();
            this.A0A = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0E.equals(AQ.A05)) {
            this.A08 = C2G.A04;
        }
        this.A0E = AQ.A04;
        A0i(this.A0a, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdBodyText() {
        return A0G(true).A0I();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdCallToAction() {
        return A0G(true).A0W();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        return getAdChoicesIcon().getUrl();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesLinkUrl() {
        return A0F().A0J();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesText() {
        return A0F().A0K();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdHeadline() {
        return A0G(true).A0L();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdLinkDescription() {
        return A0G(true).A0M();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdSocialContext() {
        return A0G(true).A0Q();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdTranslation() {
        return A0G(true).A0T();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdUntrimmedBodyText() {
        return A0G(true).A0U();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdvertiserName() {
        return A0G(true).A0V();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        AU nativeAdImage;
        if (this.A0a == null || (nativeAdImage = this.A0a.A0E().A0E()) == null) {
            return 0.0f;
        }
        int width = nativeAdImage.getWidth();
        int height = nativeAdImage.getHeight();
        if (height <= 0) {
            return 0.0f;
        }
        float f = width;
        float f2 = height;
        String[] strArr = A0m;
        if (strArr[0].charAt(21) == strArr[4].charAt(21)) {
            throw new RuntimeException();
        }
        A0m[3] = "OUTl4BjdLTzCi4kmpI6eA9pKBM08eKMp";
        return f / f2;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0h;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0g;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final Drawable getPreloadedIconViewDrawable() {
        AU auA0F;
        Bitmap bitmapA0M;
        C2873mv adapter = this.A0a;
        if (adapter != null && (auA0F = A0F().A0F()) != null && (bitmapA0M = this.A0b.A0M(auA0F.getUrl())) != null) {
            return A05(A12(), bitmapA0M, A1g(), A1D());
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getPromotedTranslation() {
        return A0G(true).A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getSponsoredTranslation() {
        return A0G(true).A0R();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        return this.A0a != null && this.A0a.A0Q();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean zA0A = true;
        if (this.A0A != null) {
            C1763Mj c1763Mj = this.A0A;
            String[] strArr = A0m;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[2] = "gqyuy6F7WThaJUOfAsIyr4sziGGBhw0f";
            strArr2[7] = "L6lbko7Rv34huPFym8TvMBezY1vQkdWf";
            zA0A = c1763Mj.A0Z();
        } else if (this.A0B != null) {
            zA0A = this.A0B.A0A();
        }
        this.A0c.A0F().A5V(zA0A);
        return zA0A;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        return this.A0a != null && this.A0a.A0R();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1477Au.A05(A0W(559, 6, 117), A0W(374, 24, 11), A0W(13, 8, 68));
        A1Y(AQ.A00(NativeAdBase.MediaCacheFlag.ALL), null, new C7z(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        AbstractC1477Au.A05(A0W(559, 6, 117), A0W(374, 24, 11), A0W(5, 8, 76));
        ((C1463Aa) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        if (this.A05 != null) {
            this.A05.performClick();
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A04 != null) {
            this.A04.post(new C2625ip(this));
        }
        String str = A0W(156, 16, 58) + AbstractC1508Cl.A03(this.A0c, th);
        A12().A0F().A3D(C1517Cu.A01(this.A00), 2001, str);
        if (this.A0G != null) {
            this.A0G.AD4(new C1468Ag(2001, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0o(extraHints.getHints());
        this.A0T = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void unregisterView() {
        C1638Hl c1638Hl = this.A0N;
        if (c1638Hl != null) {
            ViewParent parent = c1638Hl.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(c1638Hl);
            }
            this.A0N = null;
        }
        if (this.A04 == null || this.A06 == null) {
            return;
        }
        if (!A0r()) {
            InterfaceC12391f interfaceC12391fA0F = this.A0c.A0F();
            String[] strArr = A0m;
            if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
                A0m[3] = "w9n8TBisrss8zAM8EiwpgeUnlq2PaQ6F";
                interfaceC12391fA0F.unregisterView();
                if (C14499m.A1s(this.A0c)) {
                    A12().A0B().AJZ(this.A03);
                }
                if (!A0o.containsKey(this.A04) && A0o.get(this.A04).get() == this) {
                    View view = this.A04;
                    String[] strArr2 = A0m;
                    if (strArr2[2].charAt(3) != strArr2[7].charAt(3)) {
                        String[] strArr3 = A0m;
                        strArr3[6] = "1kkuB6xtwDeF3EtU3aavEsH64nQcK";
                        strArr3[1] = "rb6NM7K87kMKFcLdVL5rugEXgDuZd";
                        if ((view instanceof ViewGroup) && this.A0K != null) {
                            ((ViewGroup) this.A04).removeView(this.A0K);
                            this.A0K = null;
                        }
                        if (this.A0a != null) {
                            this.A0a.A0J();
                        }
                        if (this.A0L != null && C14499m.A1A(this.A0c)) {
                            this.A0L.A07();
                            View view2 = this.A04;
                            String[] strArr4 = A0m;
                            if (strArr4[2].charAt(3) == strArr4[7].charAt(3)) {
                                throw new RuntimeException();
                            }
                            String[] strArr5 = A0m;
                            strArr5[0] = "4gE9LeNlQroHqEeWf1EzJsbNX9PRfDme";
                            strArr5[4] = "TBDkrxJbHtSaZ13hkNs0RNY8SzE0jpKy";
                            view2.getOverlay().remove(this.A0L);
                        }
                        A0o.remove(this.A04);
                        A0a();
                        this.A04 = null;
                        this.A06 = null;
                        if (this.A0R != null) {
                            this.A0R.A0V();
                            this.A0R = null;
                        }
                        A0d();
                        this.A09 = null;
                        return;
                    }
                } else {
                    throw new IllegalStateException(A0W(473, 38, 36));
                }
            }
        } else {
            if (C14499m.A1s(this.A0c)) {
                A12().A0B().AJZ(this.A03);
            }
            if (!A0o.containsKey(this.A04)) {
            }
            throw new IllegalStateException(A0W(473, 38, 36));
        }
        throw new RuntimeException();
    }
}
