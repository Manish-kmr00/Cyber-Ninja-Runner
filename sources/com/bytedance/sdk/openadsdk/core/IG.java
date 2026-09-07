package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Ascii;
import com.json.b9;
import com.json.m5;
import com.json.yk;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.client.utils.CacheControl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class IG implements com.bytedance.sdk.component.adexpress.ML.Og, com.bytedance.sdk.component.utils.TV.pA, com.bytedance.sdk.openadsdk.SGo.Og {
    private static final Map<String, Boolean> omh;
    private com.bytedance.sdk.openadsdk.WV.pA BF;
    private WeakReference<View> BSW;
    private boolean Bf;
    private com.bytedance.sdk.openadsdk.SGo.KZx Bzk;
    private String CIG;
    private int DX;
    private com.bytedance.sdk.openadsdk.core.widget.pA.pA FQ;
    private com.bytedance.sdk.openadsdk.WV.JG Gx;
    private boolean HSv;
    private Context JBA;
    private String JG;
    private com.bytedance.sdk.openadsdk.WV.Bzk Mc;
    boolean Og;
    private com.bytedance.sdk.openadsdk.core.widget.JG SD;
    private String SGo;
    private JSONObject Sd;
    private String Sn;
    private com.bytedance.sdk.openadsdk.WV.ZZv TV;
    private com.bytedance.sdk.openadsdk.SGo.ZZv TX;
    private com.bytedance.sdk.component.pA.aBv Vgu;
    private com.bytedance.sdk.openadsdk.WV.ML WQf;
    private String WV;
    private int Wx;
    private JSONObject XT;
    private WeakReference<com.bytedance.sdk.component.Bzk.ZZv> ZZv;
    private com.bytedance.sdk.openadsdk.core.model.yFO aBv;
    private com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og agB;
    private KZx dmv;
    private JSONObject du;
    private com.bytedance.sdk.openadsdk.core.Og.ZZv eG;
    private pA fN;
    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML gbA;
    private List<com.bytedance.sdk.openadsdk.core.model.yFO> lT;
    protected Map<String, Object> pA;
    private HashMap<String, SGo> rB;
    private com.bytedance.sdk.openadsdk.WV.Og roi;
    private com.bytedance.sdk.openadsdk.core.omh.Sn vZF;
    private com.bytedance.sdk.component.adexpress.Og.BSW yFO;
    private boolean oX = true;
    private boolean IG = true;
    private boolean xy = false;
    private boolean qmB = false;
    boolean KZx = false;
    private boolean SzT = false;
    private final com.bytedance.sdk.component.utils.TV ML = new com.bytedance.sdk.component.utils.TV(Looper.getMainLooper(), this);

    public static class Og {
        public String KZx;
        public int ML;
        public String Og;
        public JSONObject ZZv;
        public String pA;
    }

    public interface pA {
        void pA();
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        omh = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put(CacheControl.PRIVATE, Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
    }

    public IG pA(com.bytedance.sdk.openadsdk.core.widget.pA.pA pAVar) {
        this.FQ = pAVar;
        return this;
    }

    public IG(Context context) {
        this.JBA = context;
    }

    public IG Og(String str) {
        this.JG = str;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.core.widget.JG jg) {
        this.SD = jg;
        return this;
    }

    public IG pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        WebView webView = zZv.getWebView();
        if (webView == null) {
            return this;
        }
        try {
            com.bytedance.sdk.component.pA.aBv abvOg = com.bytedance.sdk.component.pA.aBv.pA(webView).pA(new com.bytedance.sdk.openadsdk.BSW.pA()).pA("ToutiaoJSBridge").pA(new com.bytedance.sdk.component.pA.WV() { // from class: com.bytedance.sdk.openadsdk.core.IG.1
                @Override // com.bytedance.sdk.component.pA.WV
                public <T> T pA(String str, Type type) {
                    return null;
                }

                @Override // com.bytedance.sdk.component.pA.WV
                public <T> String pA(T t) {
                    return null;
                }
            }).pA(Bzk.Og().aBv()).Og(true).pA().Og();
            this.Vgu = abvOg;
            com.bytedance.sdk.openadsdk.BSW.pA.SD.pA(abvOg, this);
            com.bytedance.sdk.openadsdk.BSW.pA.pA.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.Og.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.KZx.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.JG.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.Bzk.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.BSW.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.SGo.pA(this.Vgu, zZv);
            com.bytedance.sdk.openadsdk.BSW.pA.omh.pA(this.Vgu, this);
            com.bytedance.sdk.openadsdk.BSW.pA.ML.pA(this.Vgu, this.Sd);
            com.bytedance.sdk.openadsdk.BSW.pA.ZZv.pA(this.Vgu, this);
        } catch (Exception unused) {
        }
        return this;
    }

    public com.bytedance.sdk.component.pA.aBv pA() {
        return this.Vgu;
    }

    private WebView Wx() {
        com.bytedance.sdk.component.Bzk.ZZv zZv;
        WeakReference<com.bytedance.sdk.component.Bzk.ZZv> weakReference = this.ZZv;
        if (weakReference == null || (zZv = weakReference.get()) == null) {
            return null;
        }
        return zZv.getWebView();
    }

    public IG Og(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        this.ZZv = new WeakReference<>(zZv);
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml) {
        this.gbA = ml;
        return this;
    }

    public IG pA(boolean z) {
        this.Og = z;
        return this;
    }

    public IG Og(boolean z) {
        this.qmB = z;
        return this;
    }

    public IG KZx(String str) {
        this.SGo = str;
        return this;
    }

    public IG pA(View view) {
        this.BSW = new WeakReference<>(view);
        return this;
    }

    @JProtect
    private JSONObject Sn() {
        try {
            View view = this.BSW.get();
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.ZZv.get();
            if (view == null || zZv == null) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrOg = Vgu.Og(view);
            int[] iArrOg2 = Vgu.Og((View) zZv);
            if (iArrOg != null && iArrOg2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, Vgu.ZZv(aBv.pA(), iArrOg[0] - iArrOg2[0]));
                jSONObject.put(VastAttributes.VERTICAL_POSITION, Vgu.ZZv(aBv.pA(), iArrOg[1] - iArrOg2[1]));
                jSONObject.put("w", Vgu.ZZv(aBv.pA(), view.getWidth()));
                jSONObject.put("h", Vgu.ZZv(aBv.pA(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable unused) {
        }
    }

    public IG pA(int i) {
        this.DX = i;
        return this;
    }

    public void Og() {
        com.bytedance.sdk.component.pA.aBv abv = this.Vgu;
        if (abv == null) {
            return;
        }
        abv.pA();
        this.Vgu = null;
    }

    public IG pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        this.aBv = yfo;
        if (yfo != null) {
            this.XT = yfo.Ld();
        }
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.Og og) {
        this.roi = og;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.Bzk bzk) {
        this.Mc = bzk;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.model.yFO KZx() {
        return this.aBv;
    }

    public boolean ZZv() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
        return yfo != null && yfo.WQf();
    }

    public IG ZZv(String str) {
        this.WV = str;
        return this;
    }

    public IG Og(int i) {
        this.Wx = i;
        return this;
    }

    public IG ML(String str) {
        this.Sn = str;
        return this;
    }

    private static List<String> DX() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public IG pA(Map<String, Object> map) {
        this.pA = map;
        return this;
    }

    public IG pA(com.bytedance.sdk.component.adexpress.Og.BSW bsw) {
        this.yFO = bsw;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.core.omh.Sn sn) {
        this.vZF = sn;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.core.Og.ZZv zZv) {
        this.eG = zZv;
        return this;
    }

    public IG pA(JSONObject jSONObject) {
        this.Sd = jSONObject;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.pA pAVar) {
        this.BF = pAVar;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.ML ml) {
        this.WQf = ml;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.ZZv zZv) {
        this.TV = zZv;
        return this;
    }

    public IG pA(List<com.bytedance.sdk.openadsdk.core.model.yFO> list) {
        this.lT = list;
        return this;
    }

    public IG pA(com.bytedance.sdk.openadsdk.WV.JG jg) {
        this.Gx = jg;
        return this;
    }

    public boolean ML() {
        return this.KZx;
    }

    @JProtect
    public static void Og(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = DX().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.Og.pA());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.Og.ML());
        jSONObject.put(yk.SESSION_HISTORY_KEY_AD_ID, com.bytedance.sdk.openadsdk.common.Og.Og());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.Og.KZx());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.common.Og.ZZv());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.Og.JG());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.Og.pA(aBv.pA()));
        if (DeviceUtils.Og(aBv.pA())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", "Android");
        }
        jSONObject.put(CommonUrlParts.DEVICE_TYPE, Build.VERSION.RELEASE);
    }

    private void Bzk(JSONObject jSONObject) throws Exception {
        if (this.Bf) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
            if ((yfo instanceof com.bytedance.sdk.openadsdk.core.model.vZF) && ((com.bytedance.sdk.openadsdk.core.model.vZF) yfo).PF()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("adInfos", jSONArray);
                for (com.bytedance.sdk.openadsdk.core.model.yFO yfo2 : ((com.bytedance.sdk.openadsdk.core.model.vZF) this.aBv).tfE()) {
                    JSONObject jSONObject2 = new JSONObject();
                    pA(jSONObject2, yfo2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        pA(jSONObject, this.aBv);
    }

    public static void pA(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.yFO yfo) throws Exception {
        String strNCO = yfo.nCO();
        if (!TextUtils.isEmpty(strNCO)) {
            jSONObject.put("cid", strNCO);
        }
        String strTM = yfo.tM();
        if (!TextUtils.isEmpty(strTM)) {
            jSONObject.put("log_extra", strTM);
        }
        String strJK = yfo.jK();
        if (!TextUtils.isEmpty(strJK)) {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, strJK);
        }
        jSONObject.put("dc", TextUtils.isEmpty(aBv.ZZv().CIG()) ? aBv.ZZv().CIG() : "SG");
        jSONObject.put(POBConstants.KEY_LANGUAGE, WV.Og());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().SXO());
    }

    private void SGo(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.WQf.BSW(this.aBv))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.WQf.BSW(this.aBv));
    }

    /* JADX WARN: Code duplicated, block: B:225:0x03a6 A[PHI: r4
  0x03a6: PHI (r4v19 org.json.JSONObject) = (r4v14 org.json.JSONObject), (r4v20 org.json.JSONObject) binds: [B:224:0x03a4, B:206:0x0359] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @JProtect
    public JSONObject pA(Og og, int i) throws Exception {
        byte b;
        JSONObject jSONObjectSn;
        Context context;
        JSONObject jSONObject;
        if (!NotificationCompat.CATEGORY_CALL.equals(og.pA)) {
            return null;
        }
        if (Bzk.Og().aBv()) {
            Log.d("TTAD.AndroidObject", "[JSB-REQ] version:" + i + " method:" + og.KZx);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str = og.KZx;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                b = !str.equals("subscribe_app_ad") ? (byte) -1 : (byte) 0;
                break;
            case -1423303823:
                b = !str.equals("adInfo") ? (byte) -1 : (byte) 1;
                break;
            case -1330994877:
                b = !str.equals("pauseWebView") ? (byte) -1 : (byte) 2;
                break;
            case -1169135450:
                b = !str.equals("changeVideoState") ? (byte) -1 : (byte) 3;
                break;
            case -1023873614:
                b = !str.equals("openAdLandPageLinks") ? (byte) -1 : (byte) 4;
                break;
            case -844321441:
                b = !str.equals("webview_time_track") ? (byte) -1 : (byte) 5;
                break;
            case -800853518:
                b = !str.equals("clickEvent") ? (byte) -1 : (byte) 6;
                break;
            case -794273169:
                b = !str.equals("appInfo") ? (byte) -1 : (byte) 7;
                break;
            case -715147645:
                b = !str.equals("getScreenSize") ? (byte) -1 : (byte) 8;
                break;
            case -511324706:
                b = !str.equals("openPrivacy") ? (byte) -1 : (byte) 9;
                break;
            case -489318846:
                b = !str.equals("getMaterialMeta") ? (byte) -1 : (byte) 10;
                break;
            case -278382602:
                b = !str.equals("send_temai_product_ids") ? (byte) -1 : Ascii.VT;
                break;
            case -173752734:
                b = !str.equals("getTeMaiAds") ? (byte) -1 : Ascii.FF;
                break;
            case 27837080:
                b = !str.equals("download_app_ad") ? (byte) -1 : Ascii.CR;
                break;
            case 94756344:
                b = !str.equals("close") ? (byte) -1 : Ascii.SO;
                break;
            case 105049135:
                b = !str.equals("unsubscribe_app_ad") ? (byte) -1 : Ascii.SI;
                break;
            case 399543522:
                b = !str.equals("getCloseButtonInfo") ? (byte) -1 : Ascii.DLE;
                break;
            case 402955465:
                b = !str.equals(b9.h.o) ? (byte) -1 : (byte) 17;
                break;
            case 425443791:
                b = !str.equals("getNativeSiteCustomData") ? (byte) -1 : Ascii.DC2;
                break;
            case 442647767:
                b = !str.equals("sendReward") ? (byte) -1 : (byte) 19;
                break;
            case 571273292:
                b = !str.equals("dynamicTrack") ? (byte) -1 : Ascii.DC4;
                break;
            case 650209982:
                b = !str.equals("getTemplateInfo") ? (byte) -1 : Ascii.NAK;
                break;
            case 672928467:
                b = !str.equals("cancel_download_app_ad") ? (byte) -1 : Ascii.SYN;
                break;
            case 711635577:
                b = !str.equals("getCurrentVideoState") ? (byte) -1 : Ascii.ETB;
                break;
            case 885131792:
                b = !str.equals("getVolume") ? (byte) -1 : Ascii.CAN;
                break;
            case 1107374321:
                b = !str.equals("pauseWebViewTimers") ? (byte) -1 : Ascii.EM;
                break;
            case 1151744482:
                b = !str.equals("muteVideo") ? (byte) -1 : Ascii.SUB;
                break;
            case 1237100796:
                b = !str.equals("renderDidFinish") ? (byte) -1 : Ascii.ESC;
                break;
            case 1532142616:
                b = !str.equals("removeLoading") ? (byte) -1 : Ascii.FS;
                break;
            case 1634511418:
                b = !str.equals("endcard_load") ? (byte) -1 : Ascii.GS;
                break;
            case 1713585602:
                b = !str.equals("getNetworkData") ? (byte) -1 : Ascii.RS;
                break;
            case 1731806400:
                b = !str.equals("playable_style") ? (byte) -1 : Ascii.US;
                break;
            case 1979895452:
                b = !str.equals("sendLog") ? (byte) -1 : (byte) 32;
                break;
            case 2086000188:
                b = !str.equals("skipVideo") ? (byte) -1 : (byte) 33;
                break;
            case 2105008900:
                b = !str.equals("landscape_click") ? (byte) -1 : (byte) 34;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                BF();
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.aBv, this.CIG, 0, (JSONObject) null);
                Context context2 = this.JBA;
                if (context2 != null) {
                    this.Bzk.pA(context2, og.ZZv, this.WV, this.Wx, this.oX);
                } else {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.aBv, this.CIG, -1, (JSONObject) null);
                }
                break;
            case 1:
                Bzk(jSONObject2);
                break;
            case 2:
                aBv();
                break;
            case 3:
                Wx(og.ZZv);
                break;
            case 4:
                JSONObject jSONObject3 = og.ZZv;
                if (pA(jSONObject3, jSONObject2)) {
                    KZx(jSONObject3);
                }
                break;
            case 5:
                BSW(og.ZZv);
                break;
            case 6:
                ML(og.ZZv);
                break;
            case 7:
                Og(jSONObject2);
                break;
            case 8:
                com.bytedance.sdk.openadsdk.WV.pA pAVar = this.BF;
                if (pAVar != null) {
                    int iOg = pAVar.Og();
                    int iPA = this.BF.pA();
                    jSONObject2.put("width", iOg);
                    jSONObject2.put("height", iPA);
                }
                break;
            case 9:
                vZF();
                break;
            case 10:
                yFO(jSONObject2);
                break;
            case 11:
                XT(og.ZZv);
                break;
            case 12:
                jSONObjectSn = this.du;
                if (jSONObjectSn != null) {
                    jSONObject2 = jSONObjectSn;
                }
                break;
            case 13:
                this.SzT = true;
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.aBv, this.CIG, 1, (JSONObject) null);
                com.bytedance.sdk.openadsdk.core.Og.ZZv zZv = this.eG;
                if (zZv != null) {
                    zZv.pA(this.IG);
                } else {
                    com.bytedance.sdk.openadsdk.SGo.KZx kZx = this.Bzk;
                    if (kZx != null && (context = this.JBA) != null) {
                        kZx.pA(context, og.ZZv, this.CIG);
                        com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og2 = this.agB;
                        if (og2 != null) {
                            og2.ZZv();
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.aBv, this.CIG, -2, (JSONObject) null);
                    }
                }
                break;
            case 14:
                JG();
                break;
            case 15:
                com.bytedance.sdk.openadsdk.SGo.KZx kZx2 = this.Bzk;
                if (kZx2 != null) {
                    kZx2.pA(og.ZZv);
                }
                break;
            case 16:
                jSONObjectSn = Sn();
                if (jSONObjectSn != null) {
                    jSONObject2 = jSONObjectSn;
                }
                break;
            case 17:
                jSONObject2.put("viewStatus", this.qmB ? 1 : 0);
                break;
            case 18:
                com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
                if (yfo != null && !TextUtils.isEmpty(yfo.qmB())) {
                    jSONObject2.put("data", this.aBv.qmB());
                }
                break;
            case 19:
                this.KZx = true;
                com.bytedance.sdk.openadsdk.WV.ML ml = this.WQf;
                if (ml != null) {
                    ml.pA();
                }
                break;
            case 20:
                aBv(og.ZZv);
                break;
            case 21:
                JSONObject jSONObject4 = this.Sd;
                if (jSONObject4 != null) {
                    jSONObject4.put("setting", Sd());
                    com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.aBv;
                    if (yfo2 != null) {
                        this.Sd.put(ShareConstants.MEDIA_EXTENSION, yfo2.PU());
                    }
                }
                jSONObject2 = this.Sd;
                break;
            case 23:
                Sn(jSONObject2);
                break;
            case 24:
                AudioManager audioManager = (AudioManager) aBv.pA().getSystemService("audio");
                jSONObject2.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 25:
                XT();
                break;
            case 26:
                Og(this.vZF, og.ZZv);
                break;
            case 27:
                DX(og.ZZv);
                break;
            case 28:
                com.bytedance.sdk.openadsdk.WV.ZZv zZv2 = this.TV;
                if (zZv2 != null) {
                    zZv2.pA();
                }
                break;
            case 29:
                WV(og.ZZv);
                break;
            case 30:
                pA(og, jSONObject2);
                break;
            case 31:
                SGo(jSONObject2);
                break;
            case 32:
                JSONObject jSONObject5 = og.ZZv;
                if (jSONObject5 != null && (jSONObject = jSONObject5.getJSONObject("extJson")) != null && jSONObject.has("category") && jSONObject.has("tag") && jSONObject.has("label")) {
                    String strOptString = jSONObject.optString("category");
                    String strOptString2 = jSONObject.optString("tag");
                    String strOptString3 = jSONObject.optString("label");
                    long jOptLong = jSONObject5.optLong("value");
                    long jOptLong2 = jSONObject5.optLong("extValue");
                    try {
                        jSONObject.putOpt("ua_policy", Integer.valueOf(this.DX));
                        break;
                    } catch (Exception unused) {
                    }
                    if ("click".equals(strOptString3)) {
                        jSONObject = Sd(jSONObject);
                    }
                    String strPA = pA(strOptString2, strOptString3);
                    boolean zML = com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.aBv);
                    pA(jSONObject, zML, strOptString3);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.aBv, strOptString, strPA, strOptString3, jOptLong, jOptLong2, jSONObject, zML);
                }
                break;
            case 33:
                yFO();
                break;
            case 34:
                Context context3 = this.JBA;
                if (context3 instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) {
                    ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) context3).ZZv();
                }
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(og.Og)) {
            Og(og.Og, jSONObject2);
            if (Bzk.Og().aBv()) {
                Log.d("TTAD.AndroidObject", "[JSB-RSP] version:" + i + " data=" + jSONObject2);
            }
        }
        return jSONObject2;
    }

    private void pA(JSONObject jSONObject, boolean z, String str) {
        com.bytedance.sdk.openadsdk.core.widget.JG jg;
        if (z) {
            try {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(strOptString) || PangleNetworkBridge.jsonObjectInit(strOptString).optInt("agg_request_type", -1) != 1 || !"click".equals(str) || (jg = this.SD) == null) {
                    return;
                }
                jg.pA();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "callAggClickListener faile", th);
            }
        }
    }

    private boolean pA(JSONObject jSONObject, JSONObject jSONObject2) {
        String strOptString;
        int iOptInt;
        String strOptString2;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("landingStyle");
            strOptString = jSONObject.optString("url");
            strOptString2 = jSONObject.optString("fallback_url");
        } else {
            strOptString = null;
            iOptInt = -1;
            strOptString2 = null;
        }
        boolean z = false;
        if (iOptInt == 1) {
            if (!com.bytedance.sdk.component.utils.DX.pA(strOptString)) {
                try {
                    jSONObject2.put("invalid_url", 1);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "handleUrl, EX1->: ", e);
                }
            }
            return z;
        }
        if (iOptInt == 2) {
            try {
                if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) {
                    jSONObject2.put("empty_url", 1);
                } else if (!com.bytedance.sdk.component.utils.DX.pA(strOptString2)) {
                    jSONObject2.put("invalid_url", 1);
                }
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "handleUrl, EX2->: ", e2);
            }
        }
        return z;
        z = true;
        return z;
    }

    public void JG() {
        com.bytedance.sdk.openadsdk.WV.Og og;
        if (this.HSv && (og = this.roi) != null) {
            og.pA();
            return;
        }
        Context context = this.JBA;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.vZF.pA((Activity) context)) {
            ((Activity) this.JBA).finish();
        }
    }

    public void KZx(JSONObject jSONObject) {
        XT.pA(oX(), this.JBA instanceof Activity, jSONObject, this.aBv, this.CIG, this.Wx, Wx(), this.SD);
    }

    private Context oX() {
        WeakReference<com.bytedance.sdk.component.Bzk.ZZv> weakReference = this.ZZv;
        Activity activityPA = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.Og.pA(this.ZZv.get());
        return activityPA == null ? this.JBA : activityPA;
    }

    private void BSW(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml;
        if (jSONObject == null || (ml = this.gbA) == null) {
            return;
        }
        ml.Og(jSONObject);
    }

    private void pA(String str, boolean z) {
        if (this.gbA == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.gbA.pA(str);
        } else {
            this.gbA.Og(str);
        }
    }

    private void aBv() {
        com.bytedance.sdk.openadsdk.WV.Bzk bzk = this.Mc;
        if (bzk == null) {
            return;
        }
        bzk.pA();
    }

    private void XT() {
        com.bytedance.sdk.openadsdk.WV.Bzk bzk = this.Mc;
        if (bzk == null) {
            return;
        }
        bzk.Og();
    }

    private void WV(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.WV.Og og = this.roi;
        if (og == null || jSONObject == null) {
            return;
        }
        og.pA(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            Bzk(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            Og(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public String getTemplateInfo() {
        pA("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.Sd;
            if (jSONObject != null) {
                jSONObject.put("setting", Sd());
                com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
                if (yfo != null) {
                    this.Sd.put(ShareConstants.MEDIA_EXTENSION, yfo.PU());
                }
            }
            pA("getTemplateInfo", false);
            return this.Sd.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            DX(PangleNetworkBridge.jsonObjectInit(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            KZx kZx = this.dmv;
            if (kZx != null) {
                com.bytedance.sdk.openadsdk.utils.xy.Og(kZx);
            }
            KZx kZx2 = new KZx(this.vZF, jSONObjectJsonObjectInit);
            this.dmv = kZx2;
            com.bytedance.sdk.openadsdk.utils.xy.pA(kZx2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            aBv(PangleNetworkBridge.jsonObjectInit(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            com.bytedance.sdk.openadsdk.utils.xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IG.2
                @Override // java.lang.Runnable
                public void run() {
                    IG.this.Wx(jSONObjectJsonObjectInit);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            com.bytedance.sdk.openadsdk.utils.xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IG.3
                @Override // java.lang.Runnable
                public void run() {
                    IG.this.ML(jSONObjectJsonObjectInit);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IG.4
            @Override // java.lang.Runnable
            public void run() {
                IG.this.yFO();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        Sn(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.openadsdk.utils.xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IG.5
            @Override // java.lang.Runnable
            public void run() {
                if (IG.this.FQ != null) {
                    IG.this.FQ.pA();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    public void pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            int iOptInt = jSONObjectJsonObjectInit.optInt("time");
            String strOptString = jSONObjectJsonObjectInit.optString("flag");
            com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
            if (sn != null) {
                sn.pA(iOptInt, strOptString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.Sd.toString();
        }
        try {
            JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(this.Sd, PangleNetworkBridge.jsonObjectInit(str));
            if (jSONObjectPA == null) {
                return this.Sd.toString();
            }
            return jSONObjectPA.toString();
        } catch (Exception unused) {
            return this.Sd.toString();
        }
    }

    public void ZZv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("zoom_type", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.Og.Sn sn = new com.bytedance.sdk.component.adexpress.Og.Sn();
        if (jSONObjectOptJSONObject != null) {
            double dOptDouble = jSONObjectOptJSONObject.optDouble(VastAttributes.HORIZONTAL_POSITION);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble(VastAttributes.VERTICAL_POSITION);
            double dOptDouble3 = jSONObjectOptJSONObject.optDouble("width");
            double dOptDouble4 = jSONObjectOptJSONObject.optDouble("height");
            sn.KZx(dOptDouble);
            sn.ZZv(dOptDouble2);
            sn.ML(dOptDouble3);
            sn.JG(dOptDouble4);
        }
        com.bytedance.sdk.openadsdk.core.omh.Sn sn2 = this.vZF;
        if (sn2 != null) {
            sn2.pA(iOptInt, sn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yFO() {
        com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
        if (sn != null) {
            sn.pA();
        }
    }

    private void vZF() {
        if (this.JBA == null || TextUtils.isEmpty(aBv.ZZv().qmB())) {
            return;
        }
        TTWebsiteActivity.pA(this.JBA, this.aBv, this.CIG);
    }

    public void SD() {
        com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
        if (sn != null) {
            sn.Og();
        }
    }

    public void JG(String str) {
        this.CIG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(com.bytedance.sdk.openadsdk.core.omh.Sn sn, JSONObject jSONObject) {
        if (sn == null || jSONObject == null) {
            return;
        }
        try {
            sn.pA(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wx(JSONObject jSONObject) {
        if (this.vZF == null || jSONObject == null) {
            return;
        }
        try {
            this.vZF.pA(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    private boolean Sn(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
        if (sn != null && jSONObject != null) {
            double dKZx = sn.KZx();
            int iZZv = this.vZF.ZZv();
            new Object[]{"current:", Double.valueOf(dKZx), "state", Integer.valueOf(iZZv)};
            try {
                jSONObject.put("currentTime", dKZx / 1000.0d);
                jSONObject.put("state", iZZv);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @JProtect
    private JSONObject Sd() {
        return Og(this.aBv);
    }

    public static JSONObject Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        int iWf;
        boolean zABv;
        JSONObject jSONObject = new JSONObject();
        if (aBv.ZZv() == null) {
            return jSONObject;
        }
        int i = 0;
        if (yfo != null) {
            try {
                iWf = yfo.Wf();
            } catch (Exception unused) {
            }
        } else {
            iWf = 0;
        }
        int iPKZ = yfo != null ? yfo.PKZ() : 0;
        int iSGo = aBv.ZZv().SGo(String.valueOf(iWf));
        int iYFO = aBv.ZZv().yFO(String.valueOf(iWf));
        boolean zJG = aBv.ZZv().JG(String.valueOf(iWf));
        boolean z = aBv.ZZv().Wx(String.valueOf(iWf)) == 1;
        if (iPKZ == 7 || iPKZ == 8) {
            zABv = aBv.ZZv().aBv(String.valueOf(iWf));
        } else {
            zABv = aBv.ZZv().KZx(String.valueOf(iWf));
        }
        jSONObject.put("voice_control", zABv);
        jSONObject.put("rv_skip_time", iSGo);
        jSONObject.put("fv_skip_show", zJG);
        jSONObject.put("iv_skip_time", iYFO);
        jSONObject.put("show_dislike", yfo != null && yfo.uQ());
        jSONObject.put("video_adaptation", yfo != null ? yfo.Mc() : 0);
        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(yfo)) {
            jSONObject.put("skip_change_to_close", true);
        } else {
            jSONObject.put("skip_change_to_close", z);
        }
        if (yfo.fS() && com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Lm()) {
            i = 1;
        }
        jSONObject.put("bar_render_platform", i);
        return jSONObject;
    }

    public void ML(JSONObject jSONObject) {
        double d;
        double d2;
        double dOptDouble;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.TX.pA("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickInfo");
            double d9 = 0.0d;
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble2 = jSONObjectOptJSONObject2.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject2.optDouble("down_y", 0.0d);
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("up_x", 0.0d);
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("up_y", 0.0d);
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("down_time", 0.0d);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("up_time", 0.0d);
                double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("button_x", 0.0d);
                double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("button_y", 0.0d);
                double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("button_width", 0.0d);
                double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("button_height", 0.0d);
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("rectInfo");
                d8 = dOptDouble10;
                d9 = dOptDouble2;
                d2 = dOptDouble3;
                d3 = dOptDouble5;
                d4 = dOptDouble6;
                d5 = dOptDouble7;
                d6 = dOptDouble8;
                d7 = dOptDouble9;
                d = dOptDouble4;
            } else {
                d = 0.0d;
                d2 = 0.0d;
                dOptDouble = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                jSONObjectOptJSONObject = null;
            }
            com.bytedance.sdk.openadsdk.core.model.Sn snPA = new com.bytedance.sdk.openadsdk.core.model.Sn.pA().ZZv((float) d9).KZx((float) dOptDouble).Og((float) d2).pA((float) d).Og((long) d3).pA((long) d4).KZx((int) d5).ZZv((int) d6).ML((int) d7).JG((int) d8).pA(strOptString2).pA((SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA>) null).pA(true).Og(iOptInt).pA(jSONObjectOptJSONObject).pA(jSONObject.optInt("clickAreaCategory", -1)).Og(jSONObjectOptJSONObject2).pA();
            com.bytedance.sdk.component.adexpress.Og.BSW bsw = this.yFO;
            if (bsw != null) {
                bsw.pA(null, iOptInt, snPA);
            }
            pA(strOptString, iOptInt, snPA);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.Og.BSW bsw2 = this.yFO;
            if (bsw2 != null) {
                bsw2.pA(null, -1, null);
            }
        }
    }

    @JProtect
    private void DX(JSONObject jSONObject) {
        int i;
        double dOptDouble;
        double dOptDouble2;
        com.bytedance.sdk.openadsdk.WV.JG jg;
        IG ig = this;
        if (ig.yFO == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = ig.gbA;
        if (ml != null) {
            ml.oX();
        }
        com.bytedance.sdk.component.adexpress.Og.Sn sn = new com.bytedance.sdk.component.adexpress.Og.Sn();
        sn.pA(1);
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            if (jSONObjectOptJSONObject != null) {
                dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
            } else {
                dOptDouble = 0.0d;
                dOptDouble2 = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    double dOptDouble3 = jSONObjectOptJSONObject2.optDouble(VastAttributes.HORIZONTAL_POSITION);
                    double dOptDouble4 = jSONObjectOptJSONObject2.optDouble(VastAttributes.VERTICAL_POSITION);
                    double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                    double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                    if (ig.oX(jSONObjectOptJSONObject2)) {
                        sn.pA((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft"));
                        sn.Og((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight"));
                        sn.KZx((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft"));
                        sn.ZZv((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight"));
                    }
                    sn.KZx(dOptDouble3);
                    sn.ZZv(dOptDouble4);
                    sn.ML(dOptDouble5);
                    sn.JG(dOptDouble6);
                } catch (Exception unused) {
                    i = 101;
                    ig = this;
                }
            } else {
                dOptDouble2 = dOptDouble2;
            }
            try {
                String strOptString = jSONObject.optString("msg", omh.pA(101));
                int iOptInt = jSONObject.optInt("code", 101);
                try {
                    sn.pA(zOptBoolean);
                    sn.pA(dOptDouble);
                    sn.Og(dOptDouble2);
                    sn.pA(strOptString);
                    sn.Og(iOptInt);
                    ig = this;
                    ig.yFO.pA(sn);
                    if (jSONObjectOptJSONObject2 == null || (jg = ig.Gx) == null) {
                        return;
                    }
                    jg.pA(sn);
                    return;
                } catch (Exception unused2) {
                    ig = this;
                }
            } catch (Exception unused3) {
                ig = this;
                i = 101;
            }
        } catch (Exception unused4) {
        }
        i = 101;
        sn.Og(i);
        sn.pA(omh.pA(i));
        ig.yFO.pA(sn);
    }

    private boolean oX(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void aBv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.aBv.pA(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void XT(JSONObject jSONObject) {
        if (jSONObject == null || this.TX == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.TX.pA(true, jSONArrayOptJSONArray);
            } else {
                this.TX.pA(false, null);
            }
        } catch (Exception unused) {
            this.TX.pA(false, null);
        }
    }

    private boolean yFO(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", Og(this.lT));
        } catch (Exception unused) {
        }
        return true;
    }

    private void pA(final Og og, final JSONObject jSONObject) {
        if (og == null) {
            return;
        }
        try {
            pA(og.ZZv, new com.bytedance.sdk.openadsdk.WV.KZx() { // from class: com.bytedance.sdk.openadsdk.core.IG.6
                @Override // com.bytedance.sdk.openadsdk.WV.KZx
                public void pA(boolean z, List<com.bytedance.sdk.openadsdk.core.model.yFO> list) {
                    if (!z) {
                        IG.this.Og(og.Og, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", IG.Og(list));
                        IG.this.Og(og.Og, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @JProtect
    private boolean pA(String str, int i, com.bytedance.sdk.openadsdk.core.model.Sn sn) {
        HashMap<String, SGo> map;
        if (TextUtils.isEmpty(str) || (map = this.rB) == null || map.get(str) == null) {
            return false;
        }
        throw null;
    }

    @JProtect
    public void pA(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.WV.KZx kZx) {
        if (kZx == null) {
            return;
        }
        try {
            final com.bytedance.sdk.openadsdk.WV.KZx kZx2 = new com.bytedance.sdk.openadsdk.WV.KZx() { // from class: com.bytedance.sdk.openadsdk.core.IG.7
                @Override // com.bytedance.sdk.openadsdk.WV.KZx
                public void pA(final boolean z, final List<com.bytedance.sdk.openadsdk.core.model.yFO> list) {
                    com.bytedance.sdk.openadsdk.utils.xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IG.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            kZx.pA(z, list);
                        }
                    });
                }
            };
            if (this.aBv != null && !TextUtils.isEmpty(this.WV)) {
                int iPKZ = this.aBv.PKZ();
                AdSlot adSlotRB = this.aBv.rB();
                com.bytedance.sdk.openadsdk.core.model.TX tx = new com.bytedance.sdk.openadsdk.core.model.TX();
                tx.JG = true;
                if (this.aBv.CIG() != null || this.aBv.FQ() != null) {
                    tx.omh = 2;
                }
                JSONObject jSONObject2 = this.XT;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
                tx.SD = jSONObject2;
                aBv.KZx().pA(adSlotRB, tx, iPKZ, new yFO.pA() { // from class: com.bytedance.sdk.openadsdk.core.IG.8
                    @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
                    public void pA(int i, String str) {
                        kZx2.pA(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
                    public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                        if (pAVar.ZZv() != null && !pAVar.ZZv().isEmpty()) {
                            com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.ZZv().get(0);
                            if (yfo != null) {
                                IG.this.XT = yfo.Ld();
                            }
                            kZx2.pA(true, pAVar.ZZv());
                            return;
                        }
                        kZx2.pA(false, null);
                        og.pA(-3);
                        com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
                    }
                });
                return;
            }
            kZx2.pA(false, null);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AndroidObject", "get ads error", e);
        }
    }

    public static JSONArray Og(List<com.bytedance.sdk.openadsdk.core.model.yFO> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).jO());
        }
        return jSONArray;
    }

    private boolean TX() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
        if (yfo == null || yfo.Ld() == null || com.bytedance.sdk.openadsdk.core.model.WQf.Og(this.aBv) || this.xy || this.aBv.Ld().optInt("parent_type") != 2) {
            return false;
        }
        int iPKZ = this.aBv.PKZ();
        if (iPKZ != 8 && iPKZ != 7) {
            return false;
        }
        this.xy = true;
        return true;
    }

    public void KZx(boolean z) {
        this.KZx = z;
    }

    public boolean omh() {
        return this.SzT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            vZF(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void vZF(JSONObject jSONObject) {
        WebView webViewWx;
        if (jSONObject == null || (webViewWx = Wx()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.BSW.pA(webViewWx, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private void KZx(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            vZF(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void SD(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Og og = new Og();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        og.pA = jSONObjectOptJSONObject.optString("__msg_type", null);
                        og.Og = jSONObjectOptJSONObject.optString("__callback_id", null);
                        og.KZx = jSONObjectOptJSONObject.optString("func");
                        og.ZZv = jSONObjectOptJSONObject.optJSONObject("params");
                        og.ML = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(og.pA) && !TextUtils.isEmpty(og.KZx)) {
                    Message messageObtainMessage = this.ML.obtainMessage(11);
                    messageObtainMessage.obj = og;
                    this.ML.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public boolean pA(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (omh.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void Og(final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (CacheControl.PRIVATE.equals(host) || "dispatch_message".equals(host)) {
                    Bzk(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.IG.9
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    String strPA;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter("tag");
                    IG.this.CIG = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter("label");
                    if (IG.this.omh(queryParameter3)) {
                        long j2 = 0;
                        try {
                            j = Long.parseLong(uri.getQueryParameter("value"));
                        } catch (Exception unused) {
                            j = 0;
                        }
                        try {
                            j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j3 = j2;
                        String queryParameter4 = uri.getQueryParameter("extra");
                        JSONObject jSONObjectSd = null;
                        if (!TextUtils.isEmpty(queryParameter4)) {
                            try {
                                JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(queryParameter4);
                                try {
                                    jSONObjectJsonObjectInit.putOpt("ua_policy", Integer.valueOf(IG.this.DX));
                                } catch (Exception unused3) {
                                }
                                jSONObjectSd = jSONObjectJsonObjectInit;
                            } catch (Exception unused4) {
                            }
                        }
                        if ("click".equals(queryParameter3)) {
                            jSONObjectSd = IG.this.Sd(jSONObjectSd);
                        }
                        if (!"landing_perf_error".equals(queryParameter3) && !"landing_perf_stats".equals(queryParameter3)) {
                            strPA = IG.this.pA(queryParameter2, queryParameter3);
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                for (String str : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str)) {
                                            jSONObject.put("ad_extra_data", PangleNetworkBridge.jsonObjectInit(uri.getQueryParameter(str)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject.put(str, uri.getQueryParameter(str));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                strPA = IG.this.JG;
                                jSONObjectSd = jSONObject;
                            } catch (Exception unused6) {
                                return;
                            }
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(IG.this.aBv, queryParameter, strPA, queryParameter3, j, j3, jSONObjectSd, com.bytedance.sdk.openadsdk.core.model.aBv.ML(IG.this.aBv));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean omh(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return Bzk();
        }
        return true;
    }

    boolean Bzk() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
        return yfo != null && yfo.Gx() == 1;
    }

    public void KZx(int i) {
        com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
        if (sn != null) {
            sn.Og(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Sd(JSONObject jSONObject) {
        if (this.pA != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = PangleNetworkBridge.jsonObjectInit(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.pA.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.Og(e.toString());
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pA(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.aBv)) {
            if (m5.v.equals(str2)) {
                return gbA.pA(this.Wx);
            }
            return "aggregate_page";
        }
        if (com.bytedance.sdk.openadsdk.core.model.WQf.ML(this.aBv)) {
            return this.JG;
        }
        if (this.roi != null) {
            return gbA.pA(this.Wx);
        }
        return this.yFO == null ? gbA.Og(this.Wx) : str;
    }

    private void Bzk(String str) {
        int length;
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewWx = Wx();
                    if (webViewWx != null) {
                        com.bytedance.sdk.component.utils.BSW.pA(webViewWx, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, (length = "bytedance://private/setresult/".length()))) <= 0) {
                    return;
                }
                String strSubstring = str.substring(length, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                SD(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public void SGo() {
        TX();
    }

    public void BSW() {
        com.bytedance.sdk.openadsdk.SGo.KZx kZx = this.Bzk;
        if (kZx != null) {
            kZx.pA();
        }
        KZx kZx2 = this.dmv;
        if (kZx2 != null) {
            com.bytedance.sdk.openadsdk.utils.xy.Og(kZx2);
            this.dmv = null;
        }
        this.JBA = null;
        this.agB = null;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof Og)) {
            try {
                pA((Og) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    private void BF() {
        if (this.Bzk == null) {
            this.Bzk = com.bytedance.sdk.openadsdk.SGo.pA.pA(this, this.aBv);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.Og
    public void pA(String str, JSONObject jSONObject) {
        KZx(str, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.Og
    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            int iOptInt = jSONObjectJsonObjectInit.optInt("video_choose");
            long jOptLong = jSONObjectJsonObjectInit.optLong("video_choose_duration");
            com.bytedance.sdk.openadsdk.WV.JG jg = this.Gx;
            if (jg != null) {
                jg.pA(iOptInt, jOptLong);
            }
        } catch (Exception unused) {
        }
    }

    public void WV() {
        pA pAVar = this.fN;
        if (pAVar != null) {
            pAVar.pA();
        }
    }

    public void ZZv(boolean z) {
        this.Bf = z;
    }

    public void ML(boolean z) {
        this.HSv = z;
    }

    public void JG(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfoPA = com.bytedance.sdk.openadsdk.core.Og.pA(jSONObject);
        if (yfoPA != null) {
            boolean zML = com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.aBv);
            pA(yfoPA, zML ? gbA.Og(this.Wx) : this.CIG, !zML);
        }
    }

    private void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(aBv.pA(), yfo, str, this.Wx);
        pAVar.pA(com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(aBv.pA(), yfo, str));
        if (!z) {
            pAVar.pA(false);
        }
        pAVar.onClick(null);
    }

    public JSONObject SD(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
            if (yfo instanceof com.bytedance.sdk.openadsdk.core.model.vZF) {
                List<com.bytedance.sdk.openadsdk.core.model.yFO> listZZv = ((com.bytedance.sdk.openadsdk.core.model.vZF) yfo).xoO().ZZv();
                for (int i = 0; i < listZZv.size(); i++) {
                    jSONArray.put(KZx(listZZv.get(i)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private JSONObject KZx(com.bytedance.sdk.openadsdk.core.model.yFO yfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put("cid", yfo.ZQ());
        jSONObject2.put("req_id", yfo.Ij());
        jSONObject2.put(CreativeInfo.c, yfo.nCO());
        jSONObject2.put("log_extra", yfo.tM());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().SXO());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", yfo.ewI());
        return jSONObject;
    }

    public void omh(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarXoO;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("index");
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.aBv;
        if (!(yfo instanceof com.bytedance.sdk.openadsdk.core.model.vZF) || (pAVarXoO = ((com.bytedance.sdk.openadsdk.core.model.vZF) yfo).xoO()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.yFO> listZZv = pAVarXoO.ZZv();
        if (iOptInt < 0 || iOptInt >= listZZv.size()) {
            return;
        }
        pA(listZZv.get(iOptInt), this.CIG, false);
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og = this.agB;
        if (og != null) {
            og.ZZv();
        }
    }

    public void pA(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.omh.Sn sn = this.vZF;
        if (sn != null) {
            sn.pA(str, jSONObject);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        this.agB = og;
    }

    public void pA(pA pAVar) {
        this.fN = pAVar;
    }

    private static class KZx implements Runnable {
        private final JSONObject Og;
        private final com.bytedance.sdk.openadsdk.core.omh.Sn pA;

        public KZx(com.bytedance.sdk.openadsdk.core.omh.Sn sn, JSONObject jSONObject) {
            this.pA = sn;
            this.Og = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            IG.Og(this.pA, this.Og);
        }
    }
}
