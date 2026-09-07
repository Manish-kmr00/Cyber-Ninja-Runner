package com.bytedance.sdk.component.Og.pA.pA.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.SGo;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.component.Og.pA.oX;
import com.bytedance.sdk.component.utils.WV;
import com.google.common.net.HttpHeaders;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class SD extends DX {
    public static int pA = -1;
    Wx KZx;
    String ML;
    HttpURLConnection Og;
    int ZZv;

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public long Og() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public long pA() {
        return 0L;
    }

    public SD(HttpURLConnection httpURLConnection, Wx wx) {
        this.ZZv = pA;
        this.Og = httpURLConnection;
        this.KZx = wx;
    }

    public SD(int i, String str, Wx wx) {
        this.ML = str;
        this.KZx = wx;
        this.ZZv = i;
    }

    public Wx SGo() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public int KZx() {
        try {
            return PangleNetworkBridge.httpUrlConnectionGetResponseCode(this.Og);
        } catch (Exception unused) {
            return this.ZZv;
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public boolean ZZv() {
        return KZx() >= 200 && KZx() < 300;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public String ML() throws IOException {
        if (!TextUtils.isEmpty(this.ML)) {
            return this.ML;
        }
        return this.Og.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public oX JG() {
        omh omhVar;
        Wx wx = this.KZx;
        if (wx != null && wx.Og != null) {
            this.KZx.Og.BSW();
        }
        try {
            try {
                omhVar = new omh(this.Og);
            } catch (Exception unused) {
                HttpURLConnection httpURLConnection = this.Og;
                omhVar = new omh(httpURLConnection, httpURLConnection.getErrorStream());
            }
        } catch (Throwable th) {
            WV.Og(th.getMessage());
            omhVar = null;
        }
        Wx wx2 = this.KZx;
        if (wx2 != null && wx2.Og != null) {
            this.KZx.Og.Wx();
        }
        return omhVar;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public com.bytedance.sdk.component.Og.pA.JG SD() {
        if (this.Og == null) {
            return new com.bytedance.sdk.component.Og.pA.JG(new String[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.Og.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || KZx() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.Og.pA.JG((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String pA(String str) {
        HttpURLConnection httpURLConnection = this.Og;
        if (httpURLConnection == null) {
            return "";
        }
        return httpURLConnection.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public String pA(String str, String str2) {
        return !TextUtils.isEmpty(pA(str)) ? pA(str) : str2;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            JG().close();
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public com.bytedance.sdk.component.Og.pA.WV omh() {
        return com.bytedance.sdk.component.Og.pA.WV.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.Og.pA.DX
    public SGo Bzk() {
        if (SGo() == null || SGo().Og == null) {
            return null;
        }
        return new SGo(SGo().Og);
    }
}
