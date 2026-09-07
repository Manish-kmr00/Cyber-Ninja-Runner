package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Bzk {
    public static final Set<String> Og = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.1
        {
            add("8025677");
            add("5001121");
        }
    };
    private static boolean XT;
    public static Wx pA;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA> BF;
    private int BSW;
    private String Bzk;
    private Integer DX;
    private String JG;
    private boolean KZx;
    private String ML;
    private int SD;
    private String SGo;
    private String Sd;
    private Bitmap Sn;
    private com.bytedance.sdk.openadsdk.core.Wx.KZx.KZx TX;
    private boolean WV;
    private boolean Wx;
    private String ZZv;
    private Integer aBv;
    private Integer oX;
    private boolean omh;
    private boolean vZF;
    private int yFO;

    public boolean DX() {
        return true;
    }

    public static void pA(Wx wx) {
        pA = wx;
    }

    public boolean pA() {
        return this.vZF;
    }

    public void pA(boolean z) {
        this.vZF = z;
    }

    private Bzk() {
        this.KZx = false;
        this.BSW = 0;
        this.WV = true;
        this.Wx = false;
        this.Sn = null;
        this.DX = null;
        this.oX = null;
        this.aBv = null;
        this.yFO = 0;
        this.BF = null;
        try {
            com.bykv.vk.openvk.pA.pA.pA.SD.pA.pA(aBv.pA());
        } catch (Throwable unused) {
        }
    }

    public static Bzk Og() {
        return pA.pA;
    }

    private static class pA {
        private static final Bzk pA = new Bzk();
    }

    public boolean KZx() {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "sdk_activate_init", true);
    }

    public void Og(boolean z) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
    }

    public String ZZv() {
        if (TextUtils.isEmpty(this.ZZv)) {
            String strPA = pA("app_id", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(strPA)) {
                this.ZZv = strPA;
            }
        }
        return this.ZZv;
    }

    public void pA(String str) {
        omh(str);
        this.ZZv = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pA("app_id", str);
        com.bytedance.sdk.openadsdk.core.settings.oX.vkV().ZZv(7);
    }

    public String ML() {
        String str = this.ML;
        if (str != null) {
            return str;
        }
        String strPA = pA("mediation_info", Long.MAX_VALUE);
        this.ML = strPA;
        if (strPA == null) {
            this.ML = "";
        }
        return this.ML;
    }

    public void Og(String str) {
        this.ML = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pA("mediation_info", str);
    }

    public String JG() {
        if (TextUtils.isEmpty(this.JG)) {
            this.JG = pA(aBv.pA());
        }
        return this.JG;
    }

    private String pA(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Throwable unused) {
            return "";
        }
    }

    public void pA(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_icon_id", "icon_id", Integer.valueOf(i));
        }
        this.SD = i;
    }

    public int SD() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_icon_id", "icon_id", 0);
        }
        return this.SD;
    }

    public void Og(final int i) {
        if (i == 0 || i == 1 || i == -1) {
            final Integer num = this.DX;
            if (num == null || num.intValue() != i) {
                this.DX = Integer.valueOf(i);
                if (!com.bytedance.sdk.openadsdk.utils.xy.ML()) {
                    pA(num, i);
                } else {
                    Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Bzk.this.pA(num, i);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(Integer num, int i) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "sdk_coppa", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(3, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "sdk_coppa", -1) != i) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "sdk_coppa", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(3, true);
        }
    }

    public int omh() {
        Integer num = this.DX;
        if (num != null) {
            return num.intValue();
        }
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "sdk_coppa", -1);
    }

    public int Bzk() {
        Integer num = this.oX;
        if (num != null) {
            return num.intValue();
        }
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "tt_gdpr", -1);
    }

    public void KZx(final int i) {
        if (i == 1) {
            i = 0;
        } else if (i == 0) {
            i = 1;
        }
        if (i == 0 || i == 1 || i == -1) {
            final Integer num = this.oX;
            if (num == null || num.intValue() != i) {
                this.oX = Integer.valueOf(i);
                if (!com.bytedance.sdk.openadsdk.utils.xy.ML()) {
                    Og(num, i);
                } else {
                    Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Bzk.this.Og(num, i);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(Integer num, int i) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(4, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "tt_gdpr", -1) != i) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(4, true);
        }
    }

    public void ZZv(int i) {
        if (i != 0 && i != 1) {
            i = -99;
        }
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_coppa", Integer.valueOf(i));
        this.yFO = i;
    }

    public int SGo() {
        int iPA = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_coppa", -99);
        this.yFO = iPA;
        if (iPA == -99) {
            this.yFO = omh();
        }
        return this.yFO;
    }

    public boolean BSW() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "is_paid", false);
        }
        return this.omh;
    }

    public String WV() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("sp_global_file", "keywords", null);
        }
        return this.Bzk;
    }

    public String Wx() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("sp_global_file", "extra_data", null);
        }
        return this.SGo;
    }

    public void KZx(final String str) {
        Bzk(str);
        if (com.bytedance.sdk.openadsdk.utils.xy.ML()) {
            Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.4
                @Override // java.lang.Runnable
                public void run() {
                    if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "extra_data", str);
                    }
                }
            });
        } else if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "extra_data", str);
        }
        this.SGo = str;
    }

    public void ML(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "title_bar_theme", Integer.valueOf(i));
        }
        this.BSW = i;
    }

    private static void omh(String str) {
        Wx wx;
        if (TextUtils.isEmpty(str) && (wx = pA) != null) {
            wx.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", "appid cannot be empty");
    }

    private static void Bzk(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        Wx wx = pA;
        if (wx != null) {
            wx.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    public com.bytedance.sdk.openadsdk.core.Wx.KZx.KZx Sn() {
        if (this.TX == null) {
            this.TX = new com.bytedance.sdk.openadsdk.core.Wx.KZx.KZx(10, 8);
        }
        return this.TX;
    }

    public Bitmap oX() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return com.bytedance.sdk.component.utils.ZZv.pA(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("sp_global_file", "pause_icon", null));
        }
        return this.Sn;
    }

    public boolean aBv() {
        return Og.contains(this.ZZv);
    }

    public boolean XT() {
        return "com.union_test.internationad".equals(gbA.ML());
    }

    public String yFO() {
        if (!TextUtils.isEmpty(this.Sd)) {
            return this.Sd;
        }
        String strPA = com.bytedance.sdk.openadsdk.utils.SGo.pA();
        this.Sd = strPA;
        if (!TextUtils.isEmpty(strPA)) {
            return this.Sd;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.SGo.pA(strValueOf);
        this.Sd = strValueOf;
        return strValueOf;
    }

    private static JSONObject SGo(String str) {
        String strOg = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("sp_global_file", str, null);
        if (TextUtils.isEmpty(strOg)) {
            return null;
        }
        try {
            return PangleNetworkBridge.jsonObjectInit(strOg);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public static void pA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", e.getMessage());
        }
    }

    public static String pA(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectSGo = SGo(str);
            if (jSONObjectSGo == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectSGo.getLong("time") <= j) {
                return jSONObjectSGo.getString("value");
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", e.getMessage());
        }
        return null;
    }

    public static Pair<String, Long> ZZv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectSGo = SGo(str);
            if (jSONObjectSGo == null) {
                return null;
            }
            return new Pair<>(jSONObjectSGo.getString("value"), Long.valueOf(jSONObjectSGo.getLong("time")));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public int vZF() {
        Integer num = this.aBv;
        if (num != null) {
            return num.intValue();
        }
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_ccpa", -1);
    }

    public void JG(final int i) {
        if (i == 0 || i == 1 || i == -1) {
            final Integer num = this.aBv;
            if (num == null || num.intValue() != i) {
                this.aBv = Integer.valueOf(i);
                if (!com.bytedance.sdk.openadsdk.utils.xy.ML()) {
                    KZx(num, i);
                } else {
                    Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Bzk.this.KZx(num, i);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(Integer num, int i) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_ccpa", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(5, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_ccpa", -1) != i) {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "global_ccpa", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(5, true);
        }
    }

    public com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA ML(String str) {
        try {
            if (this.BF == null || str == null) {
                return null;
            }
            return this.BF.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void pA(String str, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar) {
        try {
            if (TextUtils.isEmpty(str) || pAVar == null) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                com.bytedance.sdk.openadsdk.KZx.SGo.pA(6, str, pAVar);
                return;
            }
            if (this.BF == null) {
                synchronized (Bzk.class) {
                    if (this.BF == null) {
                        this.BF = new ConcurrentHashMap<>();
                    }
                }
            }
            if (this.BF != null) {
                this.BF.put(str, pAVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void JG(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                com.bytedance.sdk.openadsdk.KZx.SGo.pA(6, str);
            } else if (this.BF != null) {
                this.BF.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void Sd() {
        try {
            if (this.BF == null || this.BF.size() != 0) {
                return;
            }
            this.BF = null;
        } catch (Throwable th) {
            new Object[]{"removeClickCloseListenerObj()", th.getMessage()};
        }
    }

    public void KZx(boolean z) {
        this.KZx = z;
    }

    public static boolean TX() {
        return XT;
    }

    public static void BF() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            XT = true;
        }
    }

    public static boolean SD(String str) {
        return (TextUtils.isEmpty(str) || !com.bytedance.sdk.openadsdk.utils.TV.pA || str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad") || str.contains("pag_sp_bad_par")) ? false : true;
    }
}
