package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1464Ab implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ AnonymousClass85 A00;
    public final /* synthetic */ C1467Ae A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-66, -58, -72, -6, -5, 5, 6, 1, 4, Ascii.VT, 3, -10, 1, 0, 3, 5, -6, -1, -8, -38, -51, -39, -35, -51, -37, -36, -57, -47, -52};
    }

    public RunnableC1464Ab(C1467Ae c1467Ae, String str, AnonymousClass85 anonymousClass85) {
        this.A01 = c1467Ae;
        this.A02 = str;
        this.A00 = anonymousClass85;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        ArrayList<C1466Ad> arrayList;
        if (BQ.A02(this)) {
            return;
        }
        try {
            C14138b nvl = new C14138b(A00(0, 3, 84));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(A00(3, 7, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), jSONArray);
            jSONObject.put(A00(19, 10, 76), this.A02);
            synchronized (this.A01.A0D) {
                arrayList = new ArrayList(this.A01.A0D);
                this.A01.A0D.clear();
            }
            for (C1466Ad c1466Ad : arrayList) {
                jSONArray.put(A00(0, 0, 23) + c1466Ad.A00 + ';' + c1466Ad.A02 + ';' + c1466Ad.A01);
            }
            nvl.A07(jSONObject);
            nvl.A05(1);
            this.A00.A08().AAv(A00(10, 9, 117), AbstractC14128a.A2R, nvl);
        } catch (JSONException unused) {
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
