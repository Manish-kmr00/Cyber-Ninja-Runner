package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2873mv implements InterfaceC12581y, AnonymousClass23 {
    public static byte[] A0C;
    public static String[] A0D = {"axrzCdv0FVVdCRJ2G5bzsKW6gzdnjkd", "bTiRlDodVRVUvI5asAv5OrmPjdR2kQoL", "0F0kzsbgf", "9OhtkIX5JTQzZAf31yyS0L6RFdCICf7G", "a5UohLNEI7iVSyxaj4LiJgBVL6R7sy1L", "7foeJoxu0TAivWs2uWCvQbVxkZa0ERHH", "EHJaWrfXkxbvFmDXjSXoaOL8kiGJisUm", "EwwWMCMqNj"};
    public static final String A0E;
    public int A00;
    public C2860mi A01;
    public C2I A02;
    public C2J A03;
    public AT A04;
    public List<C2615ie> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C2699k1 A0A;
    public final String A0B;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "ypXQoKhxcHRWJrqojmqi5sMtZ7xfThaX";
            strArr[6] = "2LOy6kLjroQDrfbojOuFHdbjLd88ORkx";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{55, Ascii.DC2, Ascii.ETB, 6, 2, 19, 4, 86, Ascii.ETB, Ascii.SUB, 4, 19, Ascii.ETB, Ascii.DC2, Ascii.SI, 86, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.DC2, 19, Ascii.DC2, 86, Ascii.DC2, Ascii.ETB, 2, Ascii.ETB, 2, 45, 40, 34, 42, 97, 41, 32, 49, 49, 36, 47, 36, 37, 97, 46, 47, 97, 45, 46, 34, 42, 50, 34, 51, 36, 36, 47, 97, 32, 37, 87, 120, 125, 119, 127, 52, 120, 123, 115, 115, 113, 112, 119, 117, 120, 120, 113, 102, SignedBytes.MAX_POWER_OF_TWO, 109, 100, 113, 46, 44, 63, 41, 46, 35, 57, 85, 87, 68, 82, 95, 88, 82, 114, 101, 50, Base64.padSymbol, 56, 32, 49, 38, 49, 48, Ascii.VT, 55, 56, Base64.padSymbol, 55, 63, Ascii.VT, 48, 49, 56, 53, 45, Ascii.VT, 57, 39, Ascii.SYN, Ascii.FF, 32, Ascii.FS, Ascii.CR, Ascii.SUB, Ascii.RS, Ascii.VT, Ascii.SYN, 9, Ascii.SUB, 32, Ascii.RS, Ascii.FF, 32, Ascii.FS, Ascii.VT, Ascii.RS, 32, 9, 77, 127, 112, 101, 120, 103, 116, 36, 57, 54, 39, 36, 63, 56, 35, 106, 113, 118, 110, 106, 122, 86, 123, 10, Ascii.NAK, Ascii.EM, Ascii.VT};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C2874mw(this, map2, A03(map)), this.A01.A07() * 1000);
        } catch (Exception unused) {
        }
    }

    static {
        A04();
        A0E = C2873mv.class.getSimpleName();
    }

    public C2873mv(C2699k1 c2699k1) {
        this(c2699k1, new C2860mi());
    }

    public C2873mv(C2699k1 c2699k1, C2860mi c2860mi) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = c2860mi;
        this.A0A = c2699k1;
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap map2 = new HashMap();
        String strA02 = A02(162, 4, 103);
        if (map.containsKey(strA02)) {
            map2.put(strA02, map.get(strA02));
        }
        String strA03 = A02(POBNativeConstants.POB_NATIVE_MAIN_IMG_H, 8, 76);
        if (map.containsKey(strA03)) {
            map2.put(strA03, map.get(strA03));
        }
        return map2;
    }

    private void A05(C2860mi c2860mi) {
        if (!this.A06) {
            this.A01 = c2860mi;
            List<C2860mi> listA0c = this.A01.A0c();
            if (listA0c != null && listA0c.size() > 0) {
                int size = listA0c.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    C2873mv adapter = new C2873mv(this.A0A);
                    adapter.A05(listA0c.get(i));
                    arrayList.add(new C2615ie(this.A0A, adapter, (C14328u) null, this.A04));
                }
                this.A05 = arrayList;
            }
            this.A06 = true;
            this.A07 = A07();
            return;
        }
        throw new IllegalStateException(A02(0, 27, 109));
    }

    private boolean A07() {
        return (!(this.A01.A0e() || TextUtils.isEmpty(this.A01.A0V())) || (!TextUtils.isEmpty(this.A01.A0S()) && this.A01.A0e())) && (this.A01.A0F() != null || this.A01.A0e()) && (this.A01.A0E() != null || A8a() == AdPlacementType.NATIVE_BANNER);
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int iA06 = this.A01.A06();
        if (iA06 < 0 || iA06 > 100) {
            return 0;
        }
        return iA06;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A08();
    }

    public final int A0D() {
        return this.A01.A09();
    }

    public final C2860mi A0E() {
        return this.A01;
    }

    public final C2I A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0Y();
    }

    public final List<C2615ie> A0H() {
        if (!A0R()) {
            return null;
        }
        return this.A05;
    }

    public final void A0I() {
        if (!this.A09) {
            String strA0Z = A0E().A0Z();
            if (strA0Z != null) {
                A7 a7A0A = this.A0A.A0A();
                String[] strArr = A0D;
                if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "MHNGbcOaMZIG61BxjY7eI95TuiNlx0Gr";
                strArr2[6] = "kvjKrlZQ6RBIZv1Jj5ESJw4vFB55PB3z";
                a7A0A.AG7(strA0Z);
            }
            this.A09 = true;
        }
    }

    public final void A0J() {
        if (this.A05 != null && !this.A05.isEmpty()) {
            Iterator<C2615ie> it = this.A05.iterator();
            while (it.hasNext()) {
                it.next().unregisterView();
            }
        }
    }

    public final void A0K(C2I c2i) {
        this.A02 = c2i;
    }

    public final void A0L(C2699k1 c2699k1, C2I c2i, A7 a7, AnonymousClass38 anonymousClass38, AT at) {
        int iA06;
        this.A02 = c2i;
        this.A04 = at;
        JSONObject jSONObjectA03 = anonymousClass38.A03();
        C14328u c14328uA01 = anonymousClass38.A01();
        if (c14328uA01 != null) {
            iA06 = c14328uA01.A06();
        } else {
            iA06 = 200;
        }
        this.A00 = iA06;
        A05(C2K.A00(c2699k1, jSONObjectA03, CV.A02(jSONObjectA03, A02(94, 2, 10))));
        if (AbstractC12591z.A06(c2699k1, this, a7)) {
            c2699k1.A0F().A4s();
            c2i.AEE(this, C1468Ag.A00(AdErrorType.NO_FILL));
        } else {
            if (c2i != null) {
                c2i.AEB(this);
            }
            this.A03 = new C2J(c2699k1, this.A0B, this, c2i);
            this.A03.A02();
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0101  */
    /* JADX WARN: Code duplicated, block: B:32:0x011b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0123  */
    /* JADX WARN: Code duplicated, block: B:36:0x0125  */
    /* JADX WARN: Code duplicated, block: B:38:0x012e  */
    public final void A0M(Map<String, String> extraData) {
        C12672h c12672hA1c;
        boolean zA0e;
        String[] strArr;
        boolean shouldBlockLockscreenClicks;
        if (!A0R()) {
            return;
        }
        boolean shouldBlockLockscreenClicks2 = C14499m.A1y(this.A0A);
        if (shouldBlockLockscreenClicks2) {
            boolean shouldBlockLockscreenClicks3 = D4.A03(extraData);
            if (shouldBlockLockscreenClicks3) {
                Log.e(A0E, A02(27, 31, 90));
                return;
            }
        }
        HashMap map = new HashMap();
        if (extraData != null) {
            map.putAll(extraData);
        }
        boolean shouldBlockLockscreenClicks4 = this.A01.A0e();
        if (shouldBlockLockscreenClicks4) {
            map.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
            map.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
        }
        map.put(A02(70, 10, 15), AdPlacementType.NATIVE.name());
        map.put(A02(154, 8, 4), this.A0B);
        if (this.A01.A0C() != null) {
            boolean shouldBlockLockscreenClicks5 = this.A01.A0C().A1D();
            map.put(A02(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 21, 100), String.valueOf(shouldBlockLockscreenClicks5));
            map.put(A02(96, 23, 79), String.valueOf(this.A01.A0C().A0a()));
        }
        C2699k1 c2699k1 = this.A0A;
        A7 a7A0A = this.A0A.A0A();
        String strA7E = this.A01.A7E();
        Uri uriA0B = this.A01.A0B();
        if (this.A01.A0C() != null) {
            c12672hA1c = this.A01.A0C().A1c();
        } else {
            c12672hA1c = null;
        }
        AbstractC12551v abstractC12551vA00 = C12561w.A00(c2699k1, a7A0A, strA7E, uriA0B, map, c12672hA1c);
        EnumC12541u actionOutcome = EnumC12541u.A09;
        if (abstractC12551vA00 != null) {
            actionOutcome = abstractC12551vA00.A0C(null);
        }
        boolean shouldBlockLockscreenClicks6 = abstractC12551vA00 instanceof N8;
        if (shouldBlockLockscreenClicks6) {
            zA0e = D3.A0e(this.A0A, actionOutcome, map);
            strArr = A0D;
            if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                throw new RuntimeException();
            }
            A0D[5] = "kwfiBSqx7XAKe0021CxmCpt6QDry9hKe";
            if (zA0e) {
                shouldBlockLockscreenClicks = false;
            } else {
                shouldBlockLockscreenClicks = true;
            }
        } else {
            boolean shouldBlockLockscreenClicks7 = abstractC12551vA00 instanceof NA;
            if (shouldBlockLockscreenClicks7) {
                zA0e = D3.A0e(this.A0A, actionOutcome, map);
                strArr = A0D;
                if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                    throw new RuntimeException();
                }
                A0D[5] = "kwfiBSqx7XAKe0021CxmCpt6QDry9hKe";
                if (zA0e) {
                    shouldBlockLockscreenClicks = false;
                } else {
                    shouldBlockLockscreenClicks = true;
                }
            } else {
                shouldBlockLockscreenClicks = false;
            }
        }
        if (!shouldBlockLockscreenClicks && actionOutcome != EnumC12541u.A06) {
            CC.A04(this.A0A, A02(58, 12, 15));
            if (this.A02 != null) {
                C2I c2i = this.A02;
                String[] strArr2 = A0D;
                if (strArr2[4].charAt(16) != strArr2[6].charAt(16)) {
                    c2i.AEA(this);
                } else {
                    A0D[0] = "IDlncozxZ6Zb4pDO4gSYUoZYwzxF1Fi";
                    c2i.AEA(this);
                }
            }
        }
    }

    public final void A0N(Map<String, String> extraData) {
        this.A0A.A0A().AAq(this.A01.A7E(), extraData);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:22:0x007a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:36:0x0105  */
    public final void A0O(Map<String, String> map) {
        HashMap map2;
        boolean zA0U;
        String strA0X;
        String[] strArr;
        if (A0R() && !this.A08) {
            if (this.A02 != null) {
                C2I c2i = this.A02;
                if (A0D[7].length() == 10) {
                    A0D[2] = "N1HzTzVNk";
                    c2i.AEC(this);
                    map2 = new HashMap();
                    if (map != null) {
                        map2.putAll(map);
                    }
                    if (this.A01.A0e()) {
                        map2.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
                        map2.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
                    }
                    if (TextUtils.isEmpty(A7E())) {
                        if (!this.A01.A0e()) {
                            this.A0A.A0F().A3B();
                            strA0X = this.A01.A0X();
                            strArr = A0D;
                            if (strArr[1].charAt(25) == strArr[3].charAt(25)) {
                                String[] strArr2 = A0D;
                                strArr2[1] = "Q8Us8dZOubCsANiQB8YQBmsKLdjgWIPJ";
                                strArr2[3] = "Pg8pQUM49Vm5a0t7ebabBeivyd2Kgjff";
                                AbstractC12863a.A02(strA0X, AbstractC1501Ce.A00(A02(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 6, 10)));
                            }
                        }
                        this.A0A.A0A().AB0(A7E(), map2);
                        C1485Bh.A00(this.A0A).A0E(AdPlacementType.NATIVE.toString(), A7E());
                        if (A0T()) {
                            A06(map, map2);
                        } else {
                            zA0U = A0U();
                            if (A0D[2].length() == 9) {
                                A0D[2] = "BGAjHSzJz";
                                if (zA0U) {
                                    A06(map, map2);
                                }
                            }
                        }
                        this.A08 = true;
                        return;
                    }
                    if (A0T()) {
                        zA0U = A0U();
                        if (A0D[2].length() == 9) {
                            A0D[2] = "BGAjHSzJz";
                            if (zA0U) {
                                A06(map, map2);
                            }
                        }
                    } else {
                        A06(map, map2);
                    }
                    this.A08 = true;
                    return;
                }
            } else {
                map2 = new HashMap();
                if (map != null) {
                    map2.putAll(map);
                }
                if (this.A01.A0e()) {
                    map2.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
                    map2.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
                }
                if (TextUtils.isEmpty(A7E())) {
                    if (!this.A01.A0e()) {
                        this.A0A.A0F().A3B();
                        strA0X = this.A01.A0X();
                        strArr = A0D;
                        if (strArr[1].charAt(25) == strArr[3].charAt(25)) {
                            String[] strArr3 = A0D;
                            strArr3[1] = "Q8Us8dZOubCsANiQB8YQBmsKLdjgWIPJ";
                            strArr3[3] = "Pg8pQUM49Vm5a0t7ebabBeivyd2Kgjff";
                            AbstractC12863a.A02(strA0X, AbstractC1501Ce.A00(A02(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 6, 10)));
                        }
                    }
                    this.A0A.A0A().AB0(A7E(), map2);
                    C1485Bh.A00(this.A0A).A0E(AdPlacementType.NATIVE.toString(), A7E());
                    if (A0T()) {
                        zA0U = A0U();
                        if (A0D[2].length() == 9) {
                            A0D[2] = "BGAjHSzJz";
                            if (zA0U) {
                                A06(map, map2);
                            }
                        }
                    } else {
                        A06(map, map2);
                    }
                    this.A08 = true;
                    return;
                }
                if (A0T()) {
                    zA0U = A0U();
                    if (A0D[2].length() == 9) {
                        A0D[2] = "BGAjHSzJz";
                        if (zA0U) {
                            A06(map, map2);
                        }
                    }
                } else {
                    A06(map, map2);
                }
                this.A08 = true;
                return;
            }
            throw new RuntimeException();
        }
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0B() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0d();
    }

    public final boolean A0T() {
        return C14499m.A1U(this.A0A) && A0R() && this.A01.A0f();
    }

    public final boolean A0U() {
        return C14499m.A1U(this.A0A) && A0R() && this.A01.A0g();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final String A7E() {
        return this.A01.A7E();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final Collection<String> A7f() {
        return A0E().A7f();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final EnumC12571x A8A() {
        return A0E().A8A();
    }

    public AdPlacementType A8a() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final boolean AJQ() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final void onDestroy() {
        if (this.A03 != null) {
            C2J c2j = this.A03;
            String[] strArr = A0D;
            if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                throw new RuntimeException();
            }
            A0D[7] = "xLZjaQWgus";
            c2j.A03();
        }
    }
}
