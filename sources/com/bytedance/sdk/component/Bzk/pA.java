package com.bytedance.sdk.component.Bzk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.SD;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.du;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements View.OnTouchListener, TV.pA {
    private long BSW;
    private final Context JG;
    private final int KZx;
    private final int ML;
    private final int Og;
    private volatile float SD;
    private ViewConfiguration Sd;
    private long WV;
    private int Wx;
    private float XT;
    private final List<Integer> ZZv;
    private float aBv;
    private boolean oX;
    private volatile float omh;
    private View.OnTouchListener vZF;
    private String yFO;
    private float Bzk = -1.0f;
    private float SGo = -1.0f;
    private final Handler DX = new TV(SD.pA().getLooper(), this);
    InterfaceC0186pA pA = new InterfaceC0186pA() { // from class: com.bytedance.sdk.component.Bzk.pA.1
        @Override // com.bytedance.sdk.component.Bzk.pA.InterfaceC0186pA
        public void pA() {
            if (pA.this.Bzk == -1.0f && pA.this.SGo == -1.0f && pA.this.WV == -1) {
                new Object[]{"first trigger triggerJump()", ", mTriggerX: ", Float.valueOf(pA.this.Bzk), ", mTriggerY: ", Float.valueOf(pA.this.SGo)};
                pA pAVar = pA.this;
                pAVar.Bzk = pAVar.SD;
                pA pAVar2 = pA.this;
                pAVar2.SGo = pAVar2.omh;
                pA pAVar3 = pA.this;
                pAVar3.WV = pAVar3.BSW;
                pA.this.oX = true;
            }
            new Object[]{"everytime trigger triggerJump()", ", mTriggerX: ", Float.valueOf(pA.this.Bzk), ", mTriggerY: ", Float.valueOf(pA.this.SGo)};
        }

        @Override // com.bytedance.sdk.component.Bzk.pA.InterfaceC0186pA
        public void pA(int i) {
            pA.this.Wx = i;
            pA.this.Og();
        }
    };
    private int TX = -1;
    private final List<Integer> Sn = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Bzk.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0186pA {
        void pA();

        void pA(int i);
    }

    public pA(Context context, int i, int i2, List<Integer> list, int i3) {
        this.JG = context;
        if (i == -1) {
            this.Og = du.pA(context);
        } else {
            this.Og = du.pA(context, i);
        }
        this.KZx = du.pA(context, i2);
        this.ZZv = list;
        this.ML = i3;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        new Object[]{"action: ", Integer.valueOf(action), ", x: ", Float.valueOf(motionEvent.getX()), ",y: ", Float.valueOf(motionEvent.getY())};
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.BSW = SystemClock.elapsedRealtime();
        this.SD = x;
        this.omh = y;
        if (action == 0) {
            this.aBv = x;
            this.XT = y;
            new Object[]{"ACTION_DOWN: ", "downX: ", Float.valueOf(x), "downY: ", Float.valueOf(this.XT)};
        } else if (action == 1) {
            new Object[]{"ACTION_UP: ", "upX: ", Float.valueOf(x), "upY: ", Float.valueOf(y)};
            if (pA(x, y)) {
                int iPA = pA(this.SD, this.omh, this.BSW);
                boolean zContains = this.Sn.contains(Integer.valueOf(this.Wx));
                pA(view, motionEvent, iPA, !zContains);
                if (!zContains) {
                    this.Sn.add(Integer.valueOf(this.Wx));
                }
                if (iPA == 0) {
                    motionEvent.setAction(3);
                }
            }
        }
        View.OnTouchListener onTouchListener = this.vZF;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    public void pA(View.OnTouchListener onTouchListener) {
        this.vZF = onTouchListener;
    }

    public InterfaceC0186pA pA() {
        return this.pA;
    }

    private void pA(View view, MotionEvent motionEvent, int i, boolean z) {
        String url;
        JSONObject jSONObject = new JSONObject();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            try {
                url = webView.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = "";
        }
        jSONObject.put("arbi_current_url", url);
        jSONObject.put("click_x", motionEvent.getX());
        jSONObject.put("click_y", motionEvent.getY());
        int i2 = 1;
        if (i != 0) {
            i2 = 0;
        }
        jSONObject.put("is_interceptor", i2);
        jSONObject.put("is_first_click", z ? 1 : 0);
        jSONObject.put("click_timestamp", System.currentTimeMillis());
        jSONObject.put("arbi_interceptor_type", i);
        jSONObject.put("current_url_index", this.Wx);
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = jSONObject;
        this.DX.sendMessageDelayed(messageObtain, 200L);
    }

    private boolean pA(float f, float f2) {
        if (this.Sd == null) {
            this.Sd = ViewConfiguration.get(this.JG);
        }
        if (this.TX == -1) {
            this.TX = this.Sd.getScaledTouchSlop();
        }
        new Object[]{"mTouchSlop is: ", Integer.valueOf(this.TX)};
        if (Math.abs(f - this.aBv) <= this.TX && Math.abs(f2 - this.XT) <= this.TX) {
            new Object[]{"isClick", "upX: ", Float.valueOf(f), " ,downX: ", Float.valueOf(this.aBv), " ,upY: ", Float.valueOf(f2), "downY: ", Float.valueOf(this.XT)};
            return true;
        }
        new Object[]{"notClick", "upX: ", Float.valueOf(f), " ,downX: ", Float.valueOf(this.aBv), " ,upY: ", Float.valueOf(f2), "downY: ", Float.valueOf(this.XT)};
        return false;
    }

    public void pA(String str) {
        this.yFO = str;
    }

    private int pA(float f, float f2, long j) {
        if (this.Bzk == -1.0f && this.SGo == -1.0f && this.WV == -1) {
            return 1;
        }
        new Object[]{"mInterceptorPageList: ", this.ZZv, "mPageIndex:", Integer.valueOf(this.Wx)};
        if (!this.ZZv.contains(Integer.valueOf(this.Wx))) {
            return 2;
        }
        if (j - this.WV > this.ML) {
            Og();
            return 3;
        }
        float fAbs = Math.abs(f - this.Bzk);
        float fAbs2 = Math.abs(f2 - this.SGo);
        new Object[]{"mTouchX: ", Float.valueOf(f), ", mTriggerX : ", Float.valueOf(this.Bzk), " ,x distance：", Float.valueOf(fAbs)};
        new Object[]{"mTouchY: ", Float.valueOf(f2), ", mTriggerY: ", Float.valueOf(this.SGo), " ,y distance：", Float.valueOf(fAbs2)};
        new Object[]{"mInterceptorXPx: ", Integer.valueOf(this.Og), ", mInterceptorYPx: ", Integer.valueOf(this.KZx)};
        if (fAbs <= this.Og / 2.0f && fAbs2 <= this.KZx / 2.0f) {
            return 0;
        }
        Og();
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        this.Bzk = -1.0f;
        this.SGo = -1.0f;
        this.WV = -1L;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        int i = message.what;
        Object obj = message.obj;
        JSONObject jSONObject = new JSONObject();
        if (i == 100) {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put("is_trigger_jump", this.oX ? 1 : 0);
                    this.oX = false;
                } catch (Throwable unused) {
                }
            }
            if (com.bytedance.sdk.component.Bzk.pA.pA.pA().Og() != null) {
                com.bytedance.sdk.component.Bzk.pA.pA.pA().Og().pA(this.yFO, "arbitrage_click_event", jSONObject);
            }
        }
    }
}
