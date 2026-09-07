package com.bytedance.sdk.openadsdk.core.widget.pA;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.json.b9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class JG implements TV.pA {
    float BSW;
    String Bzk;
    float DX;
    private long IG;
    yFO Og;
    boolean SD;
    int SGo;
    float Sn;
    float WV;
    float Wx;
    boolean XT;
    WebView ZZv;
    boolean aBv;
    private final boolean eG;
    private boolean lT;
    long oX;
    boolean omh;
    Context pA;
    long yFO;
    private final Handler du = new TV(Sn.Og().getLooper(), this);
    String KZx = "landingpage";
    int JG = 0;
    private final String roi = ".*\\/serp\\?sc=.*&clkt=\\d+$";
    private final String Mc = ".*\\/\\?caf_results=.*&clkt=\\d+$";
    pA WQf = new pA() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.JG.1
        @Override // com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA
        public void pA() {
            JG.this.omh = true;
            JG.this.JG();
            JG jg = JG.this;
            jg.pA(2, jg.Bzk, JG.this.SGo);
        }
    };
    GestureDetector TV = new GestureDetector(aBv.pA(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.JG.2
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            JG.this.aBv = true;
            return false;
        }
    });
    int ML = aBv.ZZv().Qj();
    Map<Integer, Long> vZF = new HashMap();
    Map<Integer, Float> Sd = new HashMap();
    Map<Integer, Long> TX = new HashMap();
    List<Integer> BF = new ArrayList();

    public interface pA {
        void pA();
    }

    public JG(WebView webView, yFO yfo, Context context, boolean z) {
        this.Og = yfo;
        this.ZZv = webView;
        this.pA = context;
        this.eG = z;
    }

    public void pA(String str) {
        this.KZx = str;
    }

    public void Og(String str) {
        this.Bzk = str;
        omh();
        this.vZF.put(Integer.valueOf(this.SGo), Long.valueOf(SystemClock.elapsedRealtime()));
        this.TX.put(Integer.valueOf(this.SGo), Long.valueOf(SystemClock.elapsedRealtime()));
        this.lT = ML();
    }

    public void pA() {
        Og(this.SGo);
    }

    public void pA(int i) {
        float height = (i + this.ZZv.getHeight()) / Vgu.KZx(this.pA, this.ZZv.getContentHeight());
        Float f = this.Sd.get(Integer.valueOf(this.SGo));
        float fFloatValue = f == null ? 0.0f : f.floatValue();
        new Object[]{"onScrollChange, oldPerUnBox is:", Float.valueOf(fFloatValue), ", browsingPer is:", Float.valueOf(height), ", index is: ", Integer.valueOf(this.SGo)};
        if (height > fFloatValue) {
            this.Sd.put(Integer.valueOf(this.SGo), Float.valueOf(height));
        }
    }

    public void Og() {
        this.ZZv.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.JG.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z) {
                new Object[]{"trigger onWindowFocusChanged: ", Boolean.valueOf(z)};
                if (!z) {
                    if (!JG.this.omh) {
                        JG.this.JG();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (jElapsedRealtime - JG.this.IG >= 50) {
                            JG jg = JG.this;
                            jg.pA(3, jg.Bzk, JG.this.SGo);
                            JG.this.IG = jElapsedRealtime;
                            return;
                        }
                        return;
                    }
                    JG.this.omh = false;
                }
                if (z) {
                    JG.this.omh();
                    JG.this.vZF.put(Integer.valueOf(JG.this.SGo), Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        });
    }

    public void KZx(String str) {
        if (this.SD) {
            this.XT = true;
        }
        if (this.SGo == 1 && !TextUtils.isEmpty(str) && str.contains("query=")) {
            int iIndexOf = str.indexOf("query=") + 6;
            int iIndexOf2 = str.indexOf(b9.i.c, iIndexOf);
            if (iIndexOf < 0 || iIndexOf2 >= str.length() || iIndexOf2 <= iIndexOf) {
                return;
            }
            ZZv(str.substring(iIndexOf, iIndexOf2));
        }
    }

    public void pA(MotionEvent motionEvent) {
        this.TV.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.BSW = motionEvent.getX();
            this.WV = motionEvent.getY();
            this.oX = SystemClock.elapsedRealtime();
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            KZx(2);
        } else {
            this.yFO = SystemClock.elapsedRealtime() - this.oX;
            if (Og(motionEvent)) {
                ZZv();
            } else {
                KZx(1);
            }
        }
    }

    public pA KZx() {
        return this.WQf;
    }

    private void ZZv(String str) {
        if (SD()) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.Og, new com.bytedance.sdk.openadsdk.Sn.pA.pA.C0213pA().pA(this.Bzk).Og(Uri.decode(str)).pA(), this.KZx);
    }

    private void Og(int i) {
        if (SD() || this.BF.contains(Integer.valueOf(i))) {
            return;
        }
        this.BF.add(Integer.valueOf(i));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.TX.get(Integer.valueOf(i));
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.Og, new com.bytedance.sdk.openadsdk.Sn.pA.pA.C0213pA().pA(this.Bzk).pA(this.SGo).SGo(jElapsedRealtime - (l != null ? l.longValue() : jElapsedRealtime)).pA(), this.KZx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i, String str, int i2) {
        if (SD()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.vZF.get(Integer.valueOf(i2));
        long jLongValue = l != null ? l.longValue() : jElapsedRealtime;
        Float f = this.Sd.get(Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(this.Og, new com.bytedance.sdk.openadsdk.Sn.pA.pA.C0213pA().pA(str).pA(i2).omh(jElapsedRealtime - jLongValue).Bzk(f == null ? 0.0f : f.floatValue()).Og(i).pA(), this.KZx);
    }

    private void ZZv() {
        if (SD()) {
            return;
        }
        com.bytedance.sdk.openadsdk.Sn.pA.pA pAVarPA = new com.bytedance.sdk.openadsdk.Sn.pA.pA.C0213pA().pA(this.Bzk).pA(this.SGo).ZZv(this.BSW).ML(this.WV).JG(this.DX).SD(this.yFO).pA();
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = pAVarPA;
        this.du.sendMessageDelayed(messageObtain, 20L);
    }

    private void KZx(int i) {
        if (SD()) {
            return;
        }
        JG();
        this.SD = true;
        com.bytedance.sdk.openadsdk.Sn.pA.pA pAVarPA = new com.bytedance.sdk.openadsdk.Sn.pA.pA.C0213pA().pA(this.Bzk).pA(this.SGo).pA(this.BSW).Og(this.WV).KZx(this.yFO).KZx(i).pA();
        try {
            if (this.lT) {
                WebView.HitTestResult hitTestResult = this.ZZv.getHitTestResult();
                pAVarPA.pA(hitTestResult.getExtra());
                pAVarPA.pA(hitTestResult.getType());
            }
        } catch (Throwable unused) {
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 200;
        messageObtain.obj = pAVarPA;
        this.du.sendMessageDelayed(messageObtain, 100L);
    }

    private boolean ML() {
        try {
            int i = this.SGo;
            if (i == 2 || i == 3) {
                return Pattern.matches(".*\\/serp\\?sc=.*&clkt=\\d+$", this.Bzk) || Pattern.matches(".*\\/\\?caf_results=.*&clkt=\\d+$", this.Bzk);
            }
            return false;
        } catch (Throwable th) {
            WV.pA("WebArbitrageBehavior", th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (this.Sd.get(Integer.valueOf(this.SGo)) != null) {
            return;
        }
        float height = this.ZZv.getHeight() / Vgu.KZx(this.pA, this.ZZv.getContentHeight());
        if (height < 0.0f || height > 1.0f) {
            height = 0.0f;
        }
        new Object[]{"initBrowsingPer, browsingPer is: ", Float.valueOf(height), "index is: ", Integer.valueOf(this.SGo)};
        this.Sd.put(Integer.valueOf(this.SGo), Float.valueOf(height));
    }

    private boolean SD() {
        int i = this.JG + 1;
        this.JG = i;
        if (i > this.ML) {
            return true;
        }
        return ("landingpage".equals(this.KZx) || "landingpage_endcard".equals(this.KZx) || "landingpage_split_screen".equals(this.KZx) || "landingpage_direct".equals(this.KZx) || "landingpage_split_ceiling".equals(this.KZx)) ? false : true;
    }

    private boolean Og(MotionEvent motionEvent) {
        this.Wx = motionEvent.getX();
        float y = motionEvent.getY();
        this.Sn = y;
        float f = this.WV;
        if (y - f == 0.0f) {
            return false;
        }
        this.DX = y - f;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void omh() {
        WebBackForwardList webBackForwardListCopyBackForwardList = this.ZZv.copyBackForwardList();
        if (webBackForwardListCopyBackForwardList != null) {
            int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
            this.SGo = currentIndex + 1;
            if (this.eG) {
                this.SGo = currentIndex + 2;
            }
        }
        new Object[]{"trigger onPageStarted, and index is: ", Integer.valueOf(this.SGo)};
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        int i = message.what;
        com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar = (com.bytedance.sdk.openadsdk.Sn.pA.pA) message.obj;
        if (i == 100) {
            pAVar.ZZv(this.aBv ? 2 : 1);
            com.bytedance.sdk.openadsdk.ZZv.KZx.ZZv(this.Og, pAVar, this.KZx);
            this.aBv = false;
        } else if (i == 200) {
            if (this.XT) {
                pA(1, pAVar.KZx(), pAVar.ZZv());
            }
            pAVar.KZx(this.XT ? 1 : 0);
            com.bytedance.sdk.openadsdk.ZZv.KZx.ML(this.Og, pAVar, this.KZx);
            this.SD = false;
            this.XT = false;
        }
    }
}
