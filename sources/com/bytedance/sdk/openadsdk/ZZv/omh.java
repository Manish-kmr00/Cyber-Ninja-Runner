package com.bytedance.sdk.openadsdk.ZZv;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class omh {
    private int JG;
    private final boolean ML;
    private int SD;
    private long SGo;
    private final WebView omh;
    private final yFO pA;
    private String Bzk = "landingpage";
    private final Map<Integer, Long> Og = new HashMap();
    private final List<Integer> KZx = new ArrayList();
    private final Map<Integer, String> ZZv = new HashMap();

    public omh(yFO yfo, WebView webView, boolean z) {
        this.pA = yfo;
        this.omh = webView;
        this.ML = z;
    }

    public void pA(String str, int i) {
        if (this.ML) {
            i++;
        }
        if (pA(true)) {
            KZx.pA(this.pA, this.Bzk, this.JG, str, i);
            this.ZZv.put(Integer.valueOf(this.JG), str);
            this.SGo = SystemClock.elapsedRealtime();
        }
    }

    public void pA(String str) {
        if (pA(false)) {
            KZx.pA(this.pA, this.Bzk, this.JG, str, SystemClock.elapsedRealtime() - this.SGo);
        }
    }

    public void pA(WebView webView, String str) {
        yFO yfo = this.pA;
        if (yfo == null || !com.bytedance.sdk.component.Bzk.Og.pA(yfo.BSW().KZx(), str)) {
            return;
        }
        String str2 = this.ZZv.get(Integer.valueOf(this.JG));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        KZx.pA(this.pA, this.Bzk, this.JG, str2, str, 2);
    }

    public void Og(String str) {
        String str2 = this.ZZv.get(Integer.valueOf(this.JG));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        int i = this.JG;
        if (i > 0) {
            KZx.pA(this.pA, this.Bzk, i, str3, str, 1);
        }
    }

    private boolean pA(boolean z) {
        int i = z ? this.JG : this.SD;
        Og(z);
        int i2 = z ? this.JG : this.SD;
        return i2 > 0 && i2 != i;
    }

    private void Og(boolean z) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = this.omh.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                if (z) {
                    int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                    this.JG = currentIndex + 1;
                    if (this.ML) {
                        this.JG = currentIndex + 2;
                        return;
                    }
                    return;
                }
                int currentIndex2 = webBackForwardListCopyBackForwardList.getCurrentIndex();
                this.SD = currentIndex2 + 1;
                if (this.ML) {
                    this.SD = currentIndex2 + 2;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("ArbitrageLandingLog", th.toString());
        }
    }

    public void KZx(String str) {
        this.Bzk = str;
    }
}
