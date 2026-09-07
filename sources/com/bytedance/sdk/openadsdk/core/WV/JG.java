package com.bytedance.sdk.openadsdk.core.WV;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class JG {
    private SD Og;
    final Set<Pair<View, FriendlyObstructionPurpose>> pA = new HashSet();

    private JG() {
        ML.pA(aBv.pA());
    }

    private Handler ML() {
        return com.bytedance.sdk.component.utils.SD.Og();
    }

    public static JG pA() {
        return new JG();
    }

    public void pA(final WebView webView) {
        if (webView == null || this.Og != null) {
            return;
        }
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(webView);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.1
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(webView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(WebView webView) {
        try {
            if (this.Og == null) {
                this.Og = omh.pA(webView);
            }
        } catch (Throwable th) {
            WV.Og("createWebViewSession failed : ".concat(String.valueOf(th)));
            HashMap map = new HashMap();
            map.put("scene", "createWebViewSession");
            map.put("message", th.getMessage());
            ML.pA(map);
        }
    }

    public void pA(final View view, final Set<SGo> set) {
        if (this.Og != null || view == null || set == null) {
            return;
        }
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(view, set);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.4
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(view, (Set<SGo>) set);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(View view, Set<SGo> set) {
        try {
            if (this.Og == null) {
                this.Og = omh.pA(view, set);
            }
        } catch (Throwable th) {
            WV.Og("createVideoSession failed : ".concat(String.valueOf(th)));
            HashMap map = new HashMap();
            map.put("scene", "createVideoSession");
            map.put("message", th.getMessage());
            ML.pA(map);
        }
    }

    public void Og() {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            JG();
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.5
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.JG();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (this.Og != null) {
            try {
                pA((View) null, (FriendlyObstructionPurpose) null);
                this.Og.Og();
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(final boolean z, final float f) {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(z, f);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.6
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(z, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z, float f) {
        if (this.Og != null) {
            try {
                pA((View) null, (FriendlyObstructionPurpose) null);
                this.Og.pA(z, f);
            } catch (Throwable unused) {
            }
        }
    }

    public void KZx() {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            SD();
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.7
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.SD();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        SD sd = this.Og;
        if (sd != null) {
            try {
                sd.ZZv();
            } catch (Throwable unused) {
            }
        }
    }

    public void ZZv() {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            omh();
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.8
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.omh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void omh() {
        SD sd = this.Og;
        if (sd != null) {
            try {
                sd.KZx();
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(final View view, final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(view, friendlyObstructionPurpose);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.9
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(view, friendlyObstructionPurpose);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        SD sd = this.Og;
        try {
            if (sd == null) {
                if (view == null || friendlyObstructionPurpose == null) {
                    return;
                }
                this.pA.add(new Pair<>(view, friendlyObstructionPurpose));
                return;
            }
            if (view != null && friendlyObstructionPurpose != null) {
                sd.pA(view, friendlyObstructionPurpose);
            }
            if (this.pA.size() > 0) {
                sd.pA(this.pA);
                this.pA.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public void pA(final long j, final boolean z) {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(j, z);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.10
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(j, z);
                }
            });
        }
    }

    public void Og(long j, boolean z) {
        SD sd = this.Og;
        if (sd != null) {
            try {
                sd.pA(j / 1000.0f, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(final boolean z) {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(z);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.2
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z) {
        SD sd = this.Og;
        if (sd != null) {
            try {
                sd.pA(z);
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(final int i) {
        if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            Og(i);
        } else {
            ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.JG.3
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.Og(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i) {
        SD sd = this.Og;
        if (sd != null) {
            try {
                sd.Og(i);
            } catch (Throwable unused) {
            }
        }
    }
}
