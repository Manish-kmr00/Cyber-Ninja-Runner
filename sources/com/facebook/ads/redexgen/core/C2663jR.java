package com.facebook.ads.redexgen.core;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.util.common.Preconditions;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2663jR implements C9O {
    public static byte[] A03;
    public static String[] A04 = {"Mm6eOmxrkeU2", "MUq44yb", "oKRPVLX0GnKoqIxxSACkHhthyeGglJDi", "kpHGdbOqKKCIQYGNabgqln8bHLF6fw56", "0pAnM9hA2pxuChyanVmC1wYC", "qxO1zNdoKC3MMUxTs0mhMJ4wGZPx", "", "oKuuJ477mGyxhVSdv1rWN1Mids3hq7ZK"};
    public static final String A05;
    public final C2698k0 A00;
    public final C9Z<A4> A01;
    public final C9Z<A4> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr = A04;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A04[4] = "X42DzCMkQ4HFIzVdD0OsfCNEPJzG";
            bArrCopyOfRange[i4] = (byte) (i5 - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        if (A04[4].length() == 9) {
            throw new RuntimeException();
        }
        A04[4] = "UWvzDGqGj7QUhJ5x6ip4Rlib";
        A03 = new byte[]{101, 99, -78, -87, 99, -73, -68, -77, -88, 125, 99, 115, -106, 119, -88, -105, -96, -90, -123, -90, -95, -92, -109, -103, -105, -124, -105, -107, -95, -92, -106, 118, -109, -90, -109, -108, -109, -91, -105, -110, -77, -70, -77, -62, -77, -78, 110, -77, -60, -77, -68, -62, -120, 110, 112, -90, -63, -55, -52, -59, -60, -128, -44, -49, -128, -61, -52, -59, -63, -46, -128, -59, -42, -59, -50, -44, -45, -128, -45, -44, -49, -46, -63, -57, -59, 107, -122, -114, -111, -118, -119, 69, -103, -108, 69, -119, -118, -104, -118, -105, -114, -122, -111, -114, -97, -118, 69, -122, -109, 69, -118, -101, -118, -109, -103, 69, -117, -105, -108, -110, 69, -119, -122, -103, -122, -121, -122, -104, -118, 69, -74, -47, -39, -36, -43, -44, -112, -28, -33, -112, -35, -33, -26, -43, -112, -43, -26, -43, -34, -28, -29, -112, -42, -30, -33, -35, -112, -39, -34, -99, -42, -36, -39, -41, -40, -28, -112, -29, -28, -33, -30, -47, -41, -43, -112, -46, -47, -45, -37, -112, -28, -33, -112, -43, -26, -43, -34, -28, -29, -112, -44, -47, -28, -47, -46, -47, -29, -43, -40, -13, -5, -2, -9, -10, -78, 6, 1, -78, 2, -13, 4, 5, -9, -78, -13, 0, -78, -9, 8, -9, 0, 6, -78, -8, 4, 1, -1, -78, -5, 0, -65, -8, -2, -5, -7, -6, 6, -78, 5, 6, 1, 4, -13, -7, -9, 112, -117, -109, -106, -113, -114, 74, -98, -103, 74, -100, -113, -117, -114, 74, -98, -110, -113, 74, -104, -97, -105, -116, -113, -100, 74, -103, -112, 74, -113, -96, -113, -104, -98, -99, 74, -112, -100, -103, -105, 74, -114, -117, -98, -117, -116, -117, -99, -113, -121, -94, -86, -83, -90, -91, 97, -75, -80, 97, -76, -90, -77, -86, -94, -83, -86, -69, -90, 97, -94, -91, 97, -90, -73, -90, -81, -75, -64, -27, -35, -29, -32, -34, -33, -21, -92, -72, -37, -68, -19, -36, -27, -21, -54, -21, -26, -23, -40, -34, -36, -55, -36, -38, -26, -23, -37, -69, -40, -21, -40, -39, -40, -22, -36, -37, -18, -20, -8, -5, -19, -87, -19, -22, -3, -22, -21, -22, -4, -18, -87, -17, -22, -14, -11, -2, -5, -18, -87, -8, -20, -20, -2, -5, -5, -18, -19, -87, 0, -15, -18, -9, -87, -5, -18, -22, -19, -14, -9, -16, -87, -18, -1, -18, -9, -3, -4, -73, -16, 3, 3, -12, -4, -1, 3, -78, -81, -62, -81, -14, -19, -116, 127, 125, -119, -116, 126, 121, 126, 123, -114, 123, 124, 123, -115, 127, -98, -112, -98, -98, -108, -102, -103, -118, -108, -113, 7, -7, 7, 7, -3, 3, 2, -13, 8, -3, 1, -7, -68, -79, -75, -83, -22, -27, -31, -37, -28, -93, -88, -97, -108, -3, -10, -13, -10, -9, -1, -10};
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f2 A[Catch: 9i -> 0x0138, TryCatch #6 {9i -> 0x0138, blocks: (B:33:0x00e6, B:35:0x00f2, B:36:0x0101, B:22:0x0089, B:24:0x008f, B:26:0x009b, B:27:0x00dc, B:39:0x010a, B:40:0x010e, B:42:0x0114, B:43:0x0124, B:44:0x0128, B:46:0x012e), top: B:63:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0149  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final int A0B(int i, Set<String> set, Set<String> set2) {
        String strA00 = A00(412, 7, 120);
        int i2 = 0;
        int[] iArr = new int[30];
        byte[] bArr = new byte[30000];
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.add(this.A02.A6M(bArr, iArr));
            List<JSONObject> listA01 = A01(new LinkedList(), bArr, iArr);
            while (((C9Y) linkedList.getLast()).ABk()) {
                Arrays.fill(iArr, 0);
                linkedList.add(this.A02.A6M(bArr, iArr));
                listA01 = A01(listA01, bArr, iArr);
            }
            Iterator<JSONObject> it = listA01.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                try {
                    String string = next.getString(A00(TypedValues.CycleType.TYPE_WAVE_PERIOD, 2, 114));
                    try {
                        if (set.contains(string)) {
                            int i3 = next.getInt(strA00) + 1;
                            if (i3 < i) {
                                try {
                                    next.put(strA00, i3);
                                    this.A01.AJM(A09(next));
                                } catch (C14459i e) {
                                    e = e;
                                    if (this.A00.A05().AAD()) {
                                        Log.e(A05, A00(130, 68, 89), e);
                                    }
                                    A05(AbstractC14128a.A2L, e);
                                    return i2;
                                } catch (JSONException e2) {
                                    e = e2;
                                    try {
                                        if (this.A00.A05().AAD()) {
                                            Log.e(A05, A00(198, 47, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), e);
                                        }
                                        A05(AbstractC14128a.A2P, e);
                                    } catch (C14459i e3) {
                                        e = e3;
                                        if (this.A00.A05().AAD()) {
                                            Log.e(A05, A00(130, 68, 89), e);
                                        }
                                        A05(AbstractC14128a.A2L, e);
                                        return i2;
                                    }
                                }
                            } else {
                                i2++;
                            }
                            it.remove();
                        } else {
                            try {
                                if (set2.contains(string)) {
                                    if (this.A00.A05().AAD()) {
                                        String str = A00(39, 16, 55) + string + A00(0, 11, 44) + next.optString(A00(471, 4, 24), A00(475, 7, 113));
                                    }
                                    it.remove();
                                }
                            } catch (JSONException e4) {
                                e = e4;
                                if (this.A00.A05().AAD()) {
                                    Log.e(A05, A00(198, 47, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), e);
                                }
                                A05(AbstractC14128a.A2P, e);
                            }
                        }
                    } catch (C14459i e5) {
                        e = e5;
                    } catch (JSONException e6) {
                        e = e6;
                    }
                } catch (JSONException e7) {
                    e = e7;
                }
            }
            Iterator<JSONObject> it2 = listA01.iterator();
            while (it2.hasNext()) {
                this.A02.AJM(A09(it2.next()));
            }
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                ((C9Y) it3.next()).A5f();
            }
        } catch (C14459i e8) {
            e = e8;
        }
        return i2;
    }

    static {
        A03();
        A05 = C2663jR.class.getSimpleName();
    }

    public C2663jR(C2698k0 c2698k0) throws IOException {
        this.A00 = c2698k0;
        this.A01 = new C2660jO(C9W.A00(A00(11, 28, 27), c2698k0), new C2665jT(this));
        this.A02 = new C2660jO(C9W.A00(A00(322, 37, 96), c2698k0), new C2664jS(this));
    }

    private List<JSONObject> A01(List<JSONObject> list, byte[] bArr, int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (i2 == 0) {
                break;
            }
            try {
                list.add(A02(bArr, i, i2));
            } catch (JSONException jsone) {
                if (this.A00.A05().AAD()) {
                    Log.e(A05, A00(85, 45, 14), jsone);
                }
                int start = AbstractC14128a.A2P;
                A05(start, jsone);
            }
            i += i2;
        }
        return list;
    }

    public static JSONObject A02(byte[] bArr, int i, int i2) throws JSONException {
        return new JSONObject(new String(Arrays.copyOfRange(bArr, i, i + i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(int i, String str) {
        C14138b c14138b = new C14138b(str);
        c14138b.A05(1);
        this.A00.A08().AAv(A00(TypedValues.CycleType.TYPE_WAVE_PHASE, 15, 3), i, c14138b);
    }

    private void A05(int i, Throwable th) {
        this.A00.A08().AAu(A00(TypedValues.CycleType.TYPE_WAVE_PHASE, 15, 3), i, new C14138b(th));
    }

    public static byte[] A07(AnonymousClass85 anonymousClass85, String str, A4 a4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(TypedValues.CycleType.TYPE_WAVE_PERIOD, 2, 114), str);
            jSONObject.put(A00(466, 5, 95), a4.A08());
            jSONObject.put(A00(471, 4, 24), a4.A06().toString());
            jSONObject.put(A00(462, 4, 49), C1517Cu.A03(a4.A04()));
            jSONObject.put(A00(450, 12, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), C1517Cu.A03(a4.A03()));
            jSONObject.put(A00(440, 10, 20), a4.A07());
            jSONObject.put(A00(419, 4, 55), new JSONObject(a4.A09()));
            jSONObject.put(A00(412, 7, 120), 0);
        } catch (JSONException e) {
            if (anonymousClass85.A05().AAD()) {
                Log.e(A05, A00(294, 28, 42), e);
            }
        }
        String string = jSONObject.toString();
        if (A04[3].charAt(18) == '3') {
            throw new RuntimeException();
        }
        A04[3] = "qXIRiOsc7TnqBEY389oLdIOolYF6NOqr";
        return string.getBytes();
    }

    public static byte[] A09(JSONObject jSONObject) {
        return jSONObject.toString().getBytes();
    }

    public final int A0A() {
        try {
            return this.A01.A8i();
        } catch (C14459i e) {
            if (this.A00.A05().AAD()) {
                Log.e(A05, A00(245, 49, 19), e);
                return 0;
            }
            return 0;
        }
    }

    public final List<JSONObject> A0C(int i) {
        int totalFetched = 0;
        if (i == -1) {
            totalFetched = 1;
            i = 30;
        }
        int[] eventSizes = new int[i];
        byte[] bArr = new byte[i * 1000];
        List<JSONObject> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        try {
            C9Y c9yA6M = this.A01.A6M(bArr, eventSizes);
            linkedList2.add(c9yA6M);
            int iA6N = c9yA6M.A6N();
            linkedList = A01(linkedList, bArr, eventSizes);
            while (noLimit && (iA6N < i || totalFetched != 0)) {
                if (totalFetched != 0) {
                    Arrays.fill(eventSizes, 0);
                } else {
                    eventSizes = new int[i - iA6N];
                }
                c9yA6M = this.A01.A6M(bArr, eventSizes);
                linkedList2.add(c9yA6M);
                linkedList = A01(linkedList, bArr, eventSizes);
            }
            Iterator<JSONObject> it = linkedList.iterator();
            while (noLimit) {
                this.A02.AJM(A09(it.next()));
            }
            Iterator it2 = linkedList2.iterator();
            while (noLimit) {
                ((C9Y) it2.next()).A5f();
            }
        } catch (C14459i e) {
            boolean noLimit = this.A00.A05().AAD();
            if (noLimit) {
                Log.e(A05, A00(359, 53, 114), e);
            }
            A05(AbstractC14128a.A2M, e);
        }
        return linkedList;
    }

    @Override // com.facebook.ads.redexgen.core.C9O
    public final void A4r() {
        try {
            this.A01.clear();
            this.A02.clear();
        } catch (C14459i e) {
            if (this.A00.A05().AAD()) {
                Log.e(A05, A00(55, 30, 73), e);
            }
            A05(AbstractC14128a.A2J, e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9L != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    @Override // com.facebook.ads.redexgen.core.C9O
    public final void AKB(final A4 a4, final C9L<String> c9l) {
        Executor executor = D8.A07;
        final C9Z<A4> c9z = this.A01;
        final C2698k0 c2698k0 = this.A00;
        D5.A00(executor, new AsyncTask<Void, Void, String>(a4, c9l, c9z, c2698k0) { // from class: com.facebook.ads.redexgen.X.9P
            public static byte[] A05;
            public C14459i A00;
            public final AnonymousClass85 A01;
            public final C9L<String> A02;
            public final C9Z<A4> A03;
            public final A4 A04;

            static {
                A02();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 12);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A02() {
                A05 = new byte[]{Ascii.DC4, 89, 110, 110, 115, 110, 60, 113, 121, 111, 111, 125, 123, 121, 60, 127, 125, 114, 114, 115, 104, 60, 126, 121, 60, 114, 105, 112, 112, 99, SignedBytes.MAX_POWER_OF_TWO, 72, 72, 70, 65, 72, Ascii.SI, 74, 89, 74, 65, 91, Ascii.NAK, Ascii.SI, 102, 113, 119, 123, 102, 112, 75, 112, 117, 96, 117, 118, 117, 103, 113};
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9L != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9Z != com.facebook.ads.internal.eventstorage.record.RecordDatabase<com.facebook.ads.internal.logging.AdEvent> */
            {
                this.A04 = a4;
                this.A03 = c9z;
                this.A02 = c9l;
                this.A01 = c2698k0;
            }

            private final String A01(Void... voidArr) throws Throwable {
                if (BQ.A02(this)) {
                    return null;
                }
                String string = null;
                try {
                    try {
                        string = UUID.randomUUID().toString();
                        this.A01.A08().A9t(this.A04.A06().toString());
                        if (TextUtils.isEmpty(this.A04.A08())) {
                            return null;
                        }
                        if (this.A01.A05().AAD()) {
                            String str = A00(29, 15, 35) + this.A04.A06().toString() + A00(0, 1, 56) + this.A04.A09().toString();
                        }
                        this.A03.AJM(C2663jR.A07(this.A01, string, this.A04));
                        return string;
                    } catch (C14459i e) {
                        this.A00 = e;
                        this.A01.A08().AAu(A00(44, 15, 24), AbstractC14128a.A2N, new C14138b(e));
                    }
                } catch (Throwable th) {
                    BQ.A00(th, this);
                    return null;
                }
            }

            private final void A03(String str) throws Throwable {
                if (BQ.A02(this)) {
                    return;
                }
                try {
                    if (this.A00 == null) {
                        this.A02.A02(str);
                    } else {
                        this.A02.A01(0, (String) Preconditions.checkNotNull(this.A00.getMessage(), A00(1, 28, 16)));
                    }
                } catch (Throwable th) {
                    BQ.A00(th, this);
                }
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ String doInBackground(Void[] voidArr) throws Throwable {
                if (BQ.A02(this)) {
                    return null;
                }
                try {
                    return A01(voidArr);
                } catch (Throwable th) {
                    BQ.A00(th, this);
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ void onPostExecute(String str) throws Throwable {
                if (BQ.A02(this)) {
                    return;
                }
                try {
                    A03(str);
                } catch (Throwable th) {
                    BQ.A00(th, this);
                }
            }
        }, new Void[0]);
    }
}
