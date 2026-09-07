package com.bytedance.sdk.openadsdk.yFO.pA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.WV.ML;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv {
    private static volatile ZZv Og;
    private final Handler pA;
    private int KZx = 0;
    private int ZZv = 2;
    private int ML = 3600000;
    private final ArrayList<Og> JG = new ArrayList<>();

    public static ZZv pA() {
        if (Og == null) {
            synchronized (ZZv.class) {
                if (Og == null) {
                    Og = new ZZv();
                }
            }
        }
        return Og;
    }

    private ZZv() {
        xy.Og(new omh("pag_pre_render_init") { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                ZZv.this.KZx = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_pre_render_enable", 0);
                ZZv.this.ZZv = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_pre_render_max_count", 2);
                if (ZZv.this.ZZv <= 0 || ZZv.this.ZZv > 4) {
                    ZZv.this.ZZv = 2;
                }
                ZZv.this.ML = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_pre_render_alive_time", 3600000);
                if (ZZv.this.ML <= 0 || ZZv.this.ML > 3600000) {
                    ZZv.this.ML = 3600000;
                }
            }
        });
        this.pA = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (!(message.obj instanceof Og)) {
                    return false;
                }
                ZZv.this.JG.remove(message.obj);
                ((Og) message.obj).ZZv();
                return true;
            }
        });
    }

    public void pA(final yFO yfo) {
        if (Og() && yfo != null && WQf.JG(yfo)) {
            final String strIj = yfo.Ij();
            if (TextUtils.isEmpty(strIj)) {
                return;
            }
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ZZv.this.JG.size() >= ZZv.this.ZZv) {
                            new Object[]{"inUse size is : ", Integer.valueOf(ZZv.this.JG.size()), ", recycle last old plb"};
                            Og og = (Og) ZZv.this.JG.remove(0);
                            if (og != null) {
                                ZZv.this.pA.removeMessages(og.omh().hashCode());
                                og.ZZv();
                            }
                        }
                        yfo.SGo(true);
                        Context contextPA = aBv.pA();
                        yFO yfo2 = yfo;
                        final Og og2 = new Og(contextPA, yfo2, yfo2.rtW(), true, new FrameLayout(aBv.pA()), strIj);
                        ZZv.this.JG.add(og2);
                        og2.SD();
                        Message messageObtain = Message.obtain();
                        messageObtain.what = strIj.hashCode();
                        messageObtain.obj = og2;
                        ZZv.this.pA.sendMessageDelayed(messageObtain, ZZv.this.ML);
                        og2.pA(new pA.InterfaceC0260pA() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.3.1
                            @Override // com.bytedance.sdk.openadsdk.yFO.pA.pA.InterfaceC0260pA
                            public void pA() {
                                ZZv.this.pA.removeMessages(strIj.hashCode());
                                ZZv.this.JG.remove(og2);
                                og2.ZZv();
                            }
                        });
                        yFO yfo3 = yfo;
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo3, gbA.KZx(yfo3.rB().getDurationSlotType()), "PL_start_pre_render", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.3.2
                            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                            public JSONObject pA() {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("is_pre_render", 1);
                                } catch (JSONException unused) {
                                }
                                return jSONObject;
                            }
                        });
                    } catch (Throwable th) {
                        new Object[]{"preRenderPlayable exception is ", th.getMessage()};
                    }
                }
            });
        }
    }

    public Og pA(yFO yfo, FrameLayout frameLayout, ML ml) {
        Og og;
        if (Og() && yfo.rB() != null && !TextUtils.isEmpty(yfo.rB().getBidAdm()) && WQf.JG(yfo) && frameLayout != null) {
            String strIj = yfo.Ij();
            if (TextUtils.isEmpty(strIj)) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i >= this.JG.size()) {
                    i = -1;
                    og = null;
                    break;
                }
                og = this.JG.get(i);
                if (strIj.equals(og.omh())) {
                    break;
                }
                i++;
            }
            if (og != null) {
                this.pA.removeMessages(strIj.hashCode());
                this.JG.remove(i);
                new Object[]{"getPreRenderPlayable success, size:", Integer.valueOf(this.JG.size())};
                yfo.SGo(true);
                og.pA(frameLayout, ml);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, gbA.KZx(yfo.rB().getDurationSlotType()), "PL_use_pre_render", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.ZZv.4
                    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                    public JSONObject pA() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_pre_render", 1);
                        } catch (JSONException unused) {
                        }
                        return jSONObject;
                    }
                });
                return og;
            }
        }
        return null;
    }

    public boolean Og() {
        return this.KZx == 1;
    }
}
