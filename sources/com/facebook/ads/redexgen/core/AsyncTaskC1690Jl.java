package com.facebook.ads.redexgen.core;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC1690Jl extends AsyncTask<String, Void, C1691Jm> {
    public static byte[] A05;
    public static String[] A06 = {"naFNcZuGe", "C9JAYYW4", "8H9N3VrVfLlJ9IUdYMoO", "YylQBw7bkupjVtNcwFivzoGwGcTau", "utPcy8I9vNMcCezdgtn", "ehhspVm5", "7sb5kaLRz1R8p", "m"};
    public static final String A07;
    public static final Set<String> A08;
    public AnonymousClass85 A00;
    public JQ A01;
    public InterfaceC1689Jk A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C1691Jm A00(String... strArr) throws Throwable {
        if (BQ.A02(this)) {
            return null;
        }
        String[] strArr2 = A06;
        if (strArr2[4].length() == strArr2[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr3 = A06;
        strArr3[3] = "OBWBCzNqNMhSgl0vUrcBODbII9DBW";
        strArr3[2] = "nuEeWi2rsMih0JuNdplL";
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String strA02 = A02(str);
                if (this.A03 != null && !this.A03.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        strA02 = A03(strA02, entry.getKey(), entry.getValue());
                    }
                }
                int i = 1;
                while (true) {
                    int i2 = i + 1;
                    if (i > 2) {
                        return null;
                    }
                    if (A06(strA02)) {
                        return new C1691Jm(this.A01);
                    }
                    i = i2;
                }
            }
            return null;
        } catch (Throwable th) {
            BQ.A00(th, this);
            return null;
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{75, 62, 43, 105, 56, Ascii.SI, Ascii.SI, Ascii.DC2, Ascii.SI, 93, Ascii.DC2, Ascii.CR, Ascii.CAN, 19, Ascii.DC4, 19, Ascii.SUB, 93, 8, Ascii.SI, 17, 71, 93, Ascii.SI, 0, Ascii.SI, 2, 1, 9, 54, 45, 52, 52};
    }

    static {
        A04();
        A07 = AsyncTaskC1690Jl.class.getSimpleName();
        A08 = new HashSet();
        A08.add(A01(0, 1, 15));
        A08.add(A01(29, 4, 63));
    }

    public AsyncTaskC1690Jl(AnonymousClass85 anonymousClass85) {
        this(anonymousClass85, null, null);
    }

    public AsyncTaskC1690Jl(AnonymousClass85 anonymousClass85, Map<String, String> extraData) {
        this(anonymousClass85, extraData, null);
    }

    public AsyncTaskC1690Jl(AnonymousClass85 anonymousClass85, Map<String, String> extraData, Map<String, String> postData) {
        this.A00 = anonymousClass85;
        this.A03 = extraData != null ? new HashMap(extraData) : null;
        this.A04 = postData != null ? new HashMap(postData) : null;
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 9), CV.A01(this.A00.A04().A6m()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String strA01 = A01(3, 1, 49);
        if (str.contains(strA01)) {
            strA01 = A01(1, 1, 127);
        }
        StringBuilder sbAppend = new StringBuilder().append(str).append(strA01).append(str2);
        String prepend = A01(2, 1, 113);
        StringBuilder sbAppend2 = sbAppend.append(prepend);
        String prepend2 = URLEncoder.encode(str3);
        return sbAppend2.append(prepend2).toString();
    }

    private final void A05(C1691Jm response) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A02 != null) {
                this.A02.AGK(response);
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }

    private boolean A06(String str) {
        JQ jqAG4;
        JR jrA00 = C1688Jj.A00(this.A00);
        try {
            if (this.A04 == null || this.A04.size() == 0) {
                jqAG4 = jrA00.AG4(str, new C1684Jf());
            } else {
                C1684Jf params = new C1684Jf();
                params.A05(this.A04);
                jqAG4 = jrA00.AG5(str, params.A08());
            }
            this.A01 = jqAG4;
        } catch (Exception e) {
            Log.e(A07, A01(4, 19, 26) + str, e);
        }
        return this.A01 != null && this.A01.A92() == 200;
    }

    public final void A07(InterfaceC1689Jk interfaceC1689Jk) {
        this.A02 = interfaceC1689Jk;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ C1691Jm doInBackground(String[] strArr) throws Throwable {
        if (BQ.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            BQ.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        if (this.A02 != null) {
            this.A02.AGI();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(C1691Jm c1691Jm) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            A05(c1691Jm);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
