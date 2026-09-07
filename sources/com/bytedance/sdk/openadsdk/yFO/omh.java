package com.bytedance.sdk.openadsdk.yFO;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.json.b9;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class omh {
    private String BDQ;
    private boolean BF;
    private Runnable BSW;
    private String Bf;
    private String Bpk;
    private Runnable Bzk;
    private long CIG;
    private Og DX;
    private volatile boolean EC;
    private JSONObject FGT;
    private String FHA;
    private boolean FK;
    private String FQ;
    private JG Gag;
    private int GbR;
    private String Gx;
    private boolean HMH;
    private int HSv;
    private long IG;
    private String IIF;
    private pA Itl;
    private int JBA;
    private final String JG;
    public final String KZx;
    private boolean Kj;
    private int Ld;
    private volatile boolean LhC;
    private String Lm;
    public final String ML;
    private long Mc;
    public final String Og;
    private String PKZ;
    private int PU;
    private int PV;
    private WeakReference<View> QI;
    private boolean Qd;
    private com.bytedance.sdk.openadsdk.yFO.pA Qj;
    private WebView RS;
    private final String SD;
    private Runnable SGo;
    private int SXO;
    private String Sd;
    private Runnable Sn;
    private String SzT;
    private String TV;
    private boolean TX;
    private boolean Tsy;
    private String Uz;
    private long Vgu;
    private boolean WQf;
    private final Handler WV;
    private int Wf;
    private int Wo;
    private Runnable Wx;
    private boolean XT;
    private int Xj;
    private int YkC;
    public final String ZZv;
    private boolean aBv;
    private boolean agB;
    private int aj;
    private int bA;
    private int bU;
    private int cFQ;
    private int dC;
    private float dGZ;
    private int dmv;
    private long du;
    private long eG;
    private int fJy;
    private int fN;
    private String fg;
    private long fw;
    private long gbA;
    private String guZ;
    private long gy;
    private Map<String, String> jO;
    private ViewTreeObserver.OnGlobalLayoutListener juv;
    private boolean kK;
    private int ka;
    private long lT;
    private int lgT;
    private int lx;
    private String mK;
    private boolean mM;
    private boolean mY;
    private JSONObject nCO;
    private JSONObject npn;
    private boolean oX;
    private final Handler omh;
    public final String pA;
    private float qQU;
    private long qmB;
    private long rB;
    private List<JSONObject> rX;
    private float rjD;
    private int roi;
    private JSONObject rtW;
    private int sPI;
    private KZx sk;
    private String slz;
    private Context tM;
    private int tZW;
    private String uQ;
    private int uhO;
    private boolean vA;
    private String vZF;
    private int vkV;
    private String xkn;
    private boolean xt;
    private long xy;
    private Set<String> yFO;

    public enum pA {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    static /* synthetic */ int WV(omh omhVar) {
        int i = omhVar.HSv;
        omhVar.HSv = i + 1;
        return i;
    }

    static /* synthetic */ int Wx(omh omhVar) {
        int i = omhVar.JBA;
        omhVar.JBA = i + 1;
        return i;
    }

    private omh(Context context, WebView webView, KZx kZx, com.bytedance.sdk.openadsdk.yFO.pA pAVar, pA pAVar2) {
        this.JG = "playable_stuck_check_ping";
        this.SD = "playable_apply_media_permission_callback";
        this.omh = new Handler(Looper.getMainLooper());
        this.WV = new Handler(Looper.getMainLooper());
        this.oX = true;
        this.aBv = true;
        this.XT = true;
        this.pA = "PL_sdk_playable_global_viewable";
        this.Og = "PL_sdk_page_screen_blank";
        this.KZx = "PL_sdk_playable_destroy_analyze_summary";
        this.ZZv = "PL_sdk_playable_hardware_dialog_cancel";
        this.ML = "PL_sdk_playable_hardware_dialog_setting";
        this.yFO = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.vZF = null;
        this.Sd = "embeded_ad";
        this.TX = true;
        this.BF = true;
        this.WQf = false;
        this.TV = "";
        this.du = 10L;
        this.eG = 10L;
        this.roi = 700;
        this.Mc = 0L;
        this.IG = 0L;
        this.lT = -1L;
        this.rB = -1L;
        this.xy = -1L;
        this.qmB = -1L;
        this.gbA = -1L;
        this.Vgu = -1L;
        this.CIG = -1L;
        this.SzT = "";
        this.FQ = "";
        this.Gx = "";
        this.Bf = "";
        this.HSv = 0;
        this.JBA = 0;
        this.agB = false;
        this.fN = 0;
        this.dmv = -1;
        this.fJy = 0;
        this.YkC = 0;
        this.dC = 0;
        this.IIF = null;
        this.vA = false;
        this.PV = 0;
        this.cFQ = 0;
        this.lx = 0;
        this.SXO = 0;
        this.fw = 0L;
        this.gy = 0L;
        this.bU = -2;
        this.Wo = 0;
        this.tZW = 0;
        this.Ld = 0;
        this.rtW = new JSONObject();
        this.jO = new HashMap();
        this.FGT = new JSONObject();
        this.guZ = "";
        this.rjD = 0.0f;
        this.dGZ = 0.0f;
        this.Tsy = false;
        this.HMH = false;
        this.Kj = false;
        this.rX = new ArrayList();
        this.kK = true;
        this.EC = true;
        this.LhC = true;
        this.juv = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) omh.this.QI.get();
                    if (view == null) {
                        return;
                    }
                    omh.this.Og(view);
                } catch (Throwable th) {
                    SD.pA("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.Wf = -1;
        this.bU = 0;
        this.Itl = pAVar2;
        this.RS = webView;
        Bzk.pA(webView);
        pA(webView);
        pA(context, kZx, pAVar);
    }

    private omh(Context context, int i, KZx kZx, com.bytedance.sdk.openadsdk.yFO.pA pAVar) {
        this.JG = "playable_stuck_check_ping";
        this.SD = "playable_apply_media_permission_callback";
        this.omh = new Handler(Looper.getMainLooper());
        this.WV = new Handler(Looper.getMainLooper());
        this.oX = true;
        this.aBv = true;
        this.XT = true;
        this.pA = "PL_sdk_playable_global_viewable";
        this.Og = "PL_sdk_page_screen_blank";
        this.KZx = "PL_sdk_playable_destroy_analyze_summary";
        this.ZZv = "PL_sdk_playable_hardware_dialog_cancel";
        this.ML = "PL_sdk_playable_hardware_dialog_setting";
        this.yFO = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.vZF = null;
        this.Sd = "embeded_ad";
        this.TX = true;
        this.BF = true;
        this.WQf = false;
        this.TV = "";
        this.du = 10L;
        this.eG = 10L;
        this.roi = 700;
        this.Mc = 0L;
        this.IG = 0L;
        this.lT = -1L;
        this.rB = -1L;
        this.xy = -1L;
        this.qmB = -1L;
        this.gbA = -1L;
        this.Vgu = -1L;
        this.CIG = -1L;
        this.SzT = "";
        this.FQ = "";
        this.Gx = "";
        this.Bf = "";
        this.HSv = 0;
        this.JBA = 0;
        this.agB = false;
        this.fN = 0;
        this.dmv = -1;
        this.fJy = 0;
        this.YkC = 0;
        this.dC = 0;
        this.IIF = null;
        this.vA = false;
        this.PV = 0;
        this.cFQ = 0;
        this.lx = 0;
        this.SXO = 0;
        this.fw = 0L;
        this.gy = 0L;
        this.bU = -2;
        this.Wo = 0;
        this.tZW = 0;
        this.Ld = 0;
        this.rtW = new JSONObject();
        this.jO = new HashMap();
        this.FGT = new JSONObject();
        this.guZ = "";
        this.rjD = 0.0f;
        this.dGZ = 0.0f;
        this.Tsy = false;
        this.HMH = false;
        this.Kj = false;
        this.rX = new ArrayList();
        this.kK = true;
        this.EC = true;
        this.LhC = true;
        this.juv = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) omh.this.QI.get();
                    if (view == null) {
                        return;
                    }
                    omh.this.Og(view);
                } catch (Throwable th) {
                    SD.pA("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.Wf = -1;
        this.bU = i;
        this.Itl = pA.LAND_PAGE;
        pA(context, kZx, pAVar);
    }

    private void pA(Context context, KZx kZx, com.bytedance.sdk.openadsdk.yFO.pA pAVar) {
        this.vZF = UUID.randomUUID().toString();
        this.tM = context;
        this.Qj = pAVar;
        this.sk = kZx;
        SGo.pA(pAVar);
        this.Gag = new JG(this);
        SzT();
        if (this.RS == null) {
            this.Wf = 4;
            this.omh.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.4
                @Override // java.lang.Runnable
                public void run() {
                    omh.this.pA(5, "webview is null");
                }
            });
        }
    }

    private void SzT() {
        this.DX = new Og(this, this.roi);
        this.Bzk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.5
            @Override // java.lang.Runnable
            public void run() {
                if (omh.this.TX) {
                    omh.this.TX = false;
                    omh.this.omh.removeCallbacks(omh.this.SGo);
                    omh.this.pA(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.SGo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.6
            @Override // java.lang.Runnable
            public void run() {
                if (omh.this.TX) {
                    omh.this.TX = false;
                    omh.this.EC = false;
                    omh.this.omh.removeCallbacks(omh.this.Bzk);
                    omh.this.pA(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.Wx = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.7
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (omh.this.RS != null) {
                    omh.this.RS.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.7.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (omh.this.DX != null) {
                                omh.this.DX.pA(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (omh.this.WV != null) {
                    omh.this.WV.postDelayed(this, 500L);
                }
            }
        };
        this.Sn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.8
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                omh.this.pA("playable_stuck_check_ping", new JSONObject());
                if (omh.this.WV != null) {
                    omh.this.WV.postDelayed(this, 500L);
                }
            }
        };
        this.BSW = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.9
            @Override // java.lang.Runnable
            public void run() {
                if (omh.this.gy <= 0) {
                    omh.this.Og(1, "Clicking on the hot zone causes the program to freeze.");
                } else {
                    if (omh.this.gy - omh.this.fw <= omh.this.roi) {
                        omh.this.lT();
                        omh.this.fw = 0L;
                        omh.this.gy = 0L;
                        return;
                    }
                    omh.this.Og(1, "Clicking on the hot zone causes the program to freeze.");
                }
            }
        };
    }

    private boolean WV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public void pA(View view) {
        if (view == null) {
            return;
        }
        try {
            this.QI = new WeakReference<>(view);
            Og(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.juv);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.tZW == view.getWidth() && this.Ld == view.getHeight()) {
                return;
            }
            this.tZW = view.getWidth();
            this.Ld = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.tZW);
            jSONObject.put("height", this.Ld);
            pA("resize", jSONObject);
            this.rtW = jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context pA() {
        return this.tM;
    }

    public omh pA(String str, String str2) {
        this.jO.put(str, str2);
        return this;
    }

    public Map<String, String> Og() {
        return this.jO;
    }

    public omh pA(String str) {
        this.slz = str;
        return this;
    }

    public omh Og(String str) {
        this.Uz = str;
        return this;
    }

    public JSONObject KZx() {
        return this.npn;
    }

    public omh KZx(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.npn = jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public String ZZv() {
        return this.Uz;
    }

    public String ML() {
        return this.slz;
    }

    public omh ZZv(String str) {
        this.uQ = str;
        return this;
    }

    public String JG() {
        return this.uQ;
    }

    public omh ML(String str) {
        this.BDQ = str;
        return this;
    }

    public String SD() {
        return this.BDQ;
    }

    public omh pA(boolean z) {
        this.FK = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.FK);
            pA("volumeChange", jSONObject);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean omh() {
        return this.FK;
    }

    public omh Og(boolean z) {
        this.xt = z;
        return this;
    }

    public omh pA(long j) {
        if (j <= 0) {
            this.du = 10L;
        } else {
            this.du = j;
        }
        return this;
    }

    public omh Og(long j) {
        if (j <= 0) {
            this.eG = 10L;
        } else {
            this.eG = j;
        }
        return this;
    }

    public void pA(int i) {
        this.Wf = i;
    }

    public omh KZx(boolean z) {
        if (this.Wf == -1 || this.mY == z) {
            return this;
        }
        this.mY = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.mY) {
                jSONObject.put("playable_background_show_type", this.cFQ);
            }
        } catch (JSONException unused) {
        }
        KZx(this.mY ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.rB == -1 && this.mY) {
            this.rB = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("render_type", this.Wf == 1 ? 1 : 2);
                int i = this.Wf;
                if (i != -1) {
                    jSONObject2.put("webview_state", i);
                }
            } catch (JSONException unused2) {
            }
            KZx("PL_sdk_page_show", jSONObject2);
        }
        if (this.rB != -1 && !this.mY && !this.Tsy) {
            this.Tsy = true;
        }
        if (this.mY) {
            this.lT = System.currentTimeMillis();
        } else if (this.lT != -1) {
            this.Mc += System.currentTimeMillis() - this.lT;
            this.lT = -1L;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("viewStatus", this.mY);
            pA(b9.g.V, jSONObject3);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "setViewable error", th);
        }
        if (this.mY) {
            lT();
        } else {
            rB();
        }
        return this;
    }

    public boolean Bzk() {
        return this.mY;
    }

    public omh ZZv(boolean z) {
        this.Qd = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.Qd);
            pA("change_playable_click", jSONObject);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public JSONObject SGo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.Qd);
            return jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> BSW() {
        return this.Gag.pA();
    }

    public JSONObject WV() {
        try {
            boolean zPA = ML.pA(this.tM, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zPA);
            return jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject Wx() {
        try {
            boolean zPA = ML.pA(this.tM, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zPA);
            return jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject Sn() {
        boolean zPA;
        boolean zPA2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zPA = ML.pA(this.tM, "android.permission.READ_MEDIA_IMAGES");
                zPA2 = true;
            } else {
                zPA = ML.pA(this.tM, "android.permission.READ_EXTERNAL_STORAGE");
                zPA2 = ML.pA(this.tM, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zPA);
            jSONObject.put("isHasWrite", zPA2);
            if (!zPA || !zPA2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void pA(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.yFO.pA pAVar = this.Qj;
        if (pAVar == null || pAVar.Og(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            Og(strOptString2, strOptString);
        }
    }

    public void Og(JSONObject jSONObject) {
        if (this.Qj != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject DX() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.Itl.ordinal());
            jSONObject.put("safe_area_top_height", this.rjD);
            jSONObject.put("safe_area_bottom_height", this.dGZ);
            jSONObject.put("playable_enter_from", this.YkC);
            jSONObject.put("playable_retry_count", this.fJy);
            jSONObject.put("playable_card_session", this.SzT);
            jSONObject.put("playable_video_session", this.FQ);
            jSONObject.put("playable_network_type", oX());
            jSONObject.put("aweme_id", this.Bf);
            return jSONObject;
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public void pA(String str, JSONObject jSONObject) {
        if (SD.pA() && jSONObject != null) {
            jSONObject.toString();
        }
        KZx kZx = this.sk;
        if (kZx != null) {
            kZx.pA(str, jSONObject);
        }
    }

    public void Og(String str, String str2) {
        Bitmap bitmapPA;
        if (TextUtils.isEmpty(str2) || (bitmapPA = ML.pA(str2)) == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(this.tM.getContentResolver(), bitmapPA, str, "");
    }

    public String oX() {
        com.bytedance.sdk.openadsdk.yFO.pA pAVar;
        if (TextUtils.isEmpty(this.Gx) && (pAVar = this.Qj) != null) {
            this.Gx = pAVar.pA().toString();
        }
        return this.Gx;
    }

    public com.bytedance.sdk.openadsdk.yFO.pA aBv() {
        return this.Qj;
    }

    public JSONObject XT() {
        if (this.rtW.isNull("width")) {
            View view = this.QI.get();
            if (view == null) {
                return this.rtW;
            }
            Og(view);
        }
        return this.rtW;
    }

    public JSONObject yFO() {
        return this.FGT;
    }

    public omh KZx(JSONObject jSONObject) {
        this.FGT = jSONObject;
        return this;
    }

    public omh JG(String str) {
        this.Sd = str;
        return this;
    }

    public omh SD(String str) {
        int iIndexOf;
        String strDecode;
        this.guZ = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                Og(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if (b9.h.K.equalsIgnoreCase(host) || (host != null && host.contains(b9.h.K))) {
                    Og(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.bU == -1) {
                        Og(2);
                    } else {
                        Og(1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.Lm = str;
        return this;
    }

    public omh Og(int i) {
        this.bU = i;
        return this;
    }

    public omh pA(float f) {
        this.qQU = f;
        return this;
    }

    public JSONObject vZF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.qQU);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.Xj);
            jSONObject2.put("height", this.vkV);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(VastAttributes.HORIZONTAL_POSITION, this.ka);
            jSONObject3.put(VastAttributes.VERTICAL_POSITION, this.PU);
            jSONObject3.put("width", this.uhO);
            jSONObject3.put("height", this.bA);
            jSONObject.put(b9.h.K, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(VastAttributes.HORIZONTAL_POSITION, this.GbR);
            jSONObject4.put(VastAttributes.VERTICAL_POSITION, this.lgT);
            jSONObject4.put("width", this.aj);
            jSONObject4.put("height", this.sPI);
            jSONObject.put(VastAttributes.VISIBLE, jSONObject4);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void Sd() {
        com.bytedance.sdk.openadsdk.yFO.pA pAVar = this.Qj;
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    public void TX() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.gbA > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.gbA);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.xy > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.xy;
                this.CIG = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            KZx("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void ZZv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.IIF = jSONObject.optString("section");
        }
    }

    public void BF() {
        this.dmv = 2;
    }

    public void WQf() {
        this.vA = true;
    }

    public void TV() {
        if (this.Qj != null) {
            pA pAVar = pA.FEED_AWEME;
        }
    }

    public void du() {
        if (this.Qj != null) {
            pA pAVar = pA.FEED_AWEME;
        }
    }

    public void ML(JSONObject jSONObject) {
        this.nCO = jSONObject;
        this.dC++;
        rB();
        this.omh.removeCallbacks(this.BSW);
        if (this.BF) {
            this.Vgu = System.currentTimeMillis();
            this.fw = System.currentTimeMillis();
            this.gy = 0L;
            int i = this.bU;
            if (i == 0) {
                WebView webView = this.RS;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.10
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            omh.this.gy = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                pA("playable_stuck_check_ping", new JSONObject());
            }
            this.omh.postDelayed(this.BSW, this.roi);
        }
    }

    public void eG() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.gbA > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.gbA);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.xy > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.xy);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            KZx("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void JG(JSONObject jSONObject) {
        Og(2, jSONObject != null ? jSONObject.optString("error_msg", "The material directly invokes the exception pocket mask on the client") : "The material directly invokes the exception pocket mask on the client");
    }

    public void roi() {
        Og og;
        this.gy = System.currentTimeMillis();
        int i = this.bU;
        if ((i == 1 || i == 2) && (og = this.DX) != null) {
            og.pA(System.currentTimeMillis());
        }
    }

    public JSONObject SD(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return WV();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : Sn();
        }
        return Wx();
    }

    public JSONObject omh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt == 1) {
                jSONObject2.put("result", ML.Og(this.tM, "android.permission.RECORD_AUDIO"));
            } else {
                if (iOptInt != 2) {
                    if (iOptInt == 3) {
                        jSONObject2.put("result", ML.pA(this.tM));
                    }
                    return jSONObject2;
                }
                jSONObject2.put("result", ML.Og(this.tM, "android.permission.CAMERA"));
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void omh(String str) {
        this.Wo = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.xy = jCurrentTimeMillis;
            long j = this.rB;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        KZx("PL_sdk_html_load_start", jSONObject);
        this.EC = true;
        this.LhC = true;
        if (this.kK) {
            Mc();
            this.EC = false;
            this.LhC = false;
        }
        if (this.aBv) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ML.pA(this.tM, ML.WV)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ML.Og(this.tM, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ML.pA(this.tM, ML.BSW)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ML.pA(this.tM, ML.SGo)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ML.pA(this.tM, ML.Bzk)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ML.pA(this.tM, ML.omh)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ML.Og(this.tM, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ML.pA(this.tM, ML.SD)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ML.pA(this.tM)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                KZx("PL_sdk_hardware_detect", jSONObject2);
                this.aBv = false;
            } catch (Throwable th2) {
                SD.pA("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void Mc() {
        int i;
        int i2 = this.bU;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            if (this.EC) {
                this.omh.postDelayed(this.Bzk, this.du * 1000);
            }
            if ((this.LhC && WV(this.Lm)) || (i = this.bU) == 1 || i == 2) {
                this.omh.postDelayed(this.SGo, this.eG * 1000);
            }
        }
    }

    public void Bzk(String str) {
        WebView webView;
        boolean z = this.Wo == -1;
        this.Wo = 2;
        if (!z) {
            this.xkn = str;
            JSONObject jSONObject = new JSONObject();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.qmB = jCurrentTimeMillis;
                long j = this.xy;
                jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
                jSONObject.put("playable_has_show", gbA());
            } catch (Throwable th) {
                SD.pA("PlayablePlugin", "reportUrlLoadFinish error", th);
            }
            KZx("PL_sdk_html_load_finish", jSONObject);
        }
        this.EC = false;
        this.omh.removeCallbacks(this.Bzk);
        try {
            if (this.bU == 0) {
                if (this.oX && (webView = this.RS) != null) {
                    this.oX = false;
                    webView.evaluateJavascript(Vgu(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.11
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                lT();
            }
        } catch (Throwable th2) {
            SD.pA("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void IG() {
        this.LhC = false;
        this.omh.removeCallbacks(this.SGo);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.xy > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.xy);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            KZx("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void Bzk(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.Wo = 3;
                lT();
            } else {
                this.Wo = -2;
            }
            if (zOptBoolean || !this.TX) {
                return;
            }
            this.TX = false;
            this.EC = false;
            this.LhC = false;
            this.omh.removeCallbacks(this.Bzk);
            this.omh.removeCallbacks(this.SGo);
            pA(4, "CaseRenderFail");
        }
    }

    private void KZx(int i, String str) {
        com.bytedance.sdk.openadsdk.yFO.pA pAVar = this.Qj;
        if (pAVar != null) {
            pAVar.pA(i, str);
        }
    }

    protected void pA(int i, String str) {
        rB();
        KZx(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "reportRenderFatal error", th);
        }
        KZx("PL_sdk_global_faild", jSONObject);
    }

    public void Og(int i, String str) {
        this.dmv = i;
        if (this.nCO == null) {
            this.nCO = new JSONObject();
        }
        try {
            this.nCO.put("playable_stuck_type", i);
            this.nCO.put("playable_stuck_reason", str);
            if (this.Vgu > 0) {
                this.nCO.put("playable_stuck_duration", System.currentTimeMillis() - this.Vgu);
            } else {
                this.nCO.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        KZx("PL_sdk_page_stuck", this.nCO);
        rB();
        if (this.Qj == null || i != 2) {
            return;
        }
        this.nCO = new JSONObject();
    }

    protected void Og(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ML(str, jSONObject);
    }

    private String KZx(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.mK) && !TextUtils.isEmpty(this.guZ)) {
            Uri uri = Uri.parse(this.guZ);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.mK = builderAppendQueryParameter.toString();
        }
        return this.mK;
    }

    private String ZZv(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.Lm = str3;
        return str3;
    }

    private void FQ() {
        String str;
        if (this.FGT == null || (str = this.Lm) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.FGT.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.Lm).getHost();
        if (TextUtils.isEmpty(host)) {
            this.Lm += "/cid_" + strOptString;
        } else {
            this.Lm = this.Lm.replace(host, host + "/cid_" + strOptString);
        }
    }

    private void ML(String str, JSONObject jSONObject) {
        try {
            int i = this.bU;
            if (i == 0) {
                if (this.Itl != pA.LAND_PAGE && !WV(this.Lm)) {
                    FQ();
                }
                jSONObject.put("playable_url", this.Lm);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ZZv(this.PKZ, this.FHA));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", KZx(this.Bpk, this.fg));
            }
            jSONObject.put("playable_render_type", this.bU);
            if (this.Qj != null) {
                if (this.bU == 0 && (this.Itl != pA.LAND_PAGE || WV(this.Lm))) {
                    this.Qj.pA(jSONObject);
                } else if (this.bU != 0) {
                    this.Qj.pA(jSONObject);
                }
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void KZx(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.agB && this.JBA > 0) {
                this.agB = true;
            }
            if ("PL_sdk_html_load_start".equals(str) || "PL_sdk_html_load_finish".equals(str) || "PL_sdk_html_load_error".equals(str)) {
                jSONObject.put("usecache", this.mM ? 1 : 0);
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.mY);
            jSONObject.put("playable_session_id", this.vZF);
            int i = this.bU;
            if (i == 0) {
                if (this.Itl != pA.LAND_PAGE && !WV(this.Lm)) {
                    FQ();
                }
                jSONObject.put("playable_url", this.Lm);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ZZv(this.PKZ, this.FHA));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", KZx(this.Bpk, this.fg));
            }
            jSONObject.put("playable_full_url", this.guZ);
            jSONObject.put("playable_replay_count", this.fN);
            jSONObject.put("playable_is_prerender", this.xt);
            jSONObject.put("playable_is_preload", this.agB);
            jSONObject.put("playable_render_type", this.bU);
            jSONObject.put("playable_scenes_type", this.Itl.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.Bpk) ? "" : this.Bpk);
            if (!TextUtils.isEmpty(this.fg)) {
                str2 = this.fg;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.6.0");
            jSONObject.put("playable_minigamelite_id", this.PKZ);
            jSONObject.put("playable_minigamelite_schema", this.FHA);
            jSONObject.put("playable_is_debug", this.HMH);
            jSONObject.put("playable_retry_count", this.fJy);
            jSONObject.put("playable_enter_from", this.YkC);
            jSONObject.put("playable_sequence", this.dC);
            jSONObject.put("playable_current_section", this.IIF);
            jSONObject.put("is_playable_finish", this.vA);
            jSONObject.put("playable_card_session", this.SzT);
            jSONObject.put("playable_video_session", this.FQ);
            jSONObject.put("playable_network_type", oX());
            jSONObject.put("playable_lynx_version", this.TV);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.Sd);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.FGT.opt("cid"));
            jSONObject2.put("log_extra", this.FGT.opt("log_extra"));
            int i2 = this.bU;
            if (i2 != -1 && i2 != -2) {
                if (this.Qj != null) {
                    List<JSONObject> list = this.rX;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.rX.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.bU);
                                jSONObjectOptJSONObject.put("playable_url", this.Lm);
                            }
                            this.Qj.pA(jSONObjectOptJSONObject);
                        }
                        this.rX.clear();
                    }
                    if (this.bU == 0 && (this.Itl != pA.LAND_PAGE || WV(this.Lm))) {
                        this.Qj.pA(jSONObject);
                        return;
                    } else {
                        if (this.bU != 0) {
                            this.Qj.pA(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.rX == null) {
                this.rX = new ArrayList();
            }
            this.rX.add(jSONObject2);
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void SGo(String str) {
        this.omh.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.2
            @Override // java.lang.Runnable
            public void run() {
                omh.WV(omh.this);
            }
        });
    }

    public void BSW(String str) {
        this.omh.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.omh.3
            @Override // java.lang.Runnable
            public void run() {
                omh.Wx(omh.this);
            }
        });
    }

    public void lT() {
        if (this.BF) {
            this.Vgu = System.currentTimeMillis();
            if (this.Itl == pA.FEED_AWEME) {
                if (this.mY && this.Wo == 3) {
                    Og og = this.DX;
                    if (og != null && og.Og()) {
                        Gx();
                        return;
                    } else {
                        if (this.DX == null) {
                            this.DX = new Og(this, this.roi);
                            Gx();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.mY && this.Wo == 2) {
                Og og2 = this.DX;
                if (og2 != null && og2.Og()) {
                    Gx();
                } else if (this.DX == null) {
                    this.DX = new Og(this, this.roi);
                    Gx();
                }
            }
        }
    }

    private void Gx() {
        Runnable runnable;
        Runnable runnable2;
        this.DX.pA(System.currentTimeMillis());
        Handler handler = this.WV;
        if (handler != null) {
            int i = this.bU;
            if (i == 0 && (runnable2 = this.Wx) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.Sn) != null) {
                handler.post(runnable);
            }
            this.DX.pA(500);
        }
    }

    public void rB() {
        try {
            Og og = this.DX;
            if (og != null) {
                og.pA();
            }
            Handler handler = this.WV;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            new StringBuilder("The stuttering detection has been paused due to a crash.-- ").append(th);
        }
    }

    public void xy() {
        this.tZW = 0;
        this.Ld = 0;
        this.qQU = 0.0f;
        this.Xj = 0;
        this.vkV = 0;
        this.PU = 0;
        this.ka = 0;
        this.uhO = 0;
        this.bA = 0;
        this.lgT = 0;
        this.GbR = 0;
        this.aj = 0;
        this.sPI = 0;
    }

    public void qmB() {
        if (this.Kj) {
            return;
        }
        this.Kj = true;
        this.IG = 0L;
        this.aBv = true;
        xy();
        try {
            View view = this.QI.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.juv);
            }
        } catch (Throwable unused) {
        }
        try {
            this.Gag.Fba();
        } catch (Throwable unused2) {
        }
        try {
            Og og = this.DX;
            if (og != null) {
                og.pA();
                this.DX = null;
            }
            Handler handler = this.WV;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            new StringBuilder("crash -- ").append(th);
        }
        try {
            if (!TextUtils.isEmpty(this.Lm)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.HSv);
                jSONObject.put("playable_hit_times", this.JBA);
                int i = this.HSv;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.JBA) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                KZx("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.Lm)) {
                if (this.lT != -1) {
                    this.Mc += System.currentTimeMillis() - this.lT;
                    this.lT = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.Mc);
                KZx("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.EC = false;
        this.LhC = false;
        this.omh.removeCallbacks(this.Bzk);
        this.omh.removeCallbacks(this.SGo);
        this.omh.removeCallbacksAndMessages(null);
    }

    public void pA(int i, String str, String str2) {
        this.Wo = -1;
        this.xkn = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
            jSONObject.put("playable_has_show", gbA());
        } catch (Throwable th) {
            SD.pA("PlayablePlugin", "onWebReceivedError error", th);
        }
        KZx("PL_sdk_html_load_error", jSONObject);
        if (this.TX) {
            this.TX = false;
            this.EC = false;
            this.LhC = false;
            this.omh.removeCallbacks(this.Bzk);
            this.omh.removeCallbacks(this.SGo);
            pA(1, "ContainerLoadFail");
        }
    }

    public int gbA() {
        return (this.rB == -1 || !this.mY) ? 1 : 2;
    }

    public void pA(boolean z, String str, int i) {
        if (z) {
            this.Wo = -1;
            this.xkn = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
                jSONObject.put("playable_has_show", gbA());
            } catch (Throwable th) {
                SD.pA("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            KZx("PL_sdk_html_load_error", jSONObject);
            if (this.TX) {
                this.TX = false;
                this.EC = false;
                this.LhC = false;
                this.omh.removeCallbacks(this.Bzk);
                this.omh.removeCallbacks(this.SGo);
                pA(1, "ContainerLoadFail");
            }
        }
    }

    public String Vgu() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public int CIG() {
        return this.Wf;
    }

    public JSONObject ZZv(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        if (SD.pA() && jSONObject != null) {
            jSONObject.toString();
        }
        JSONObject jSONObjectPA = this.Gag.pA(str, jSONObject);
        if (SD.pA()) {
            System.currentTimeMillis();
            if (jSONObjectPA != null) {
                jSONObjectPA.toString();
            }
        }
        return jSONObjectPA;
    }

    public omh ML(boolean z) {
        this.kK = z;
        return this;
    }

    public void JG(boolean z) {
        this.mM = z;
    }

    public static omh pA(Context context, WebView webView, KZx kZx, com.bytedance.sdk.openadsdk.yFO.pA pAVar) {
        if (kZx == null || pAVar == null) {
            return null;
        }
        if (webView == null) {
            return new omh(context, 0, kZx, pAVar);
        }
        return new omh(context, webView, kZx, pAVar, pA.LAND_PAGE);
    }
}
