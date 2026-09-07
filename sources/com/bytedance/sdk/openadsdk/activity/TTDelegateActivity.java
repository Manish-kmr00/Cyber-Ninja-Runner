package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.du;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA> KZx = Collections.synchronizedMap(new HashMap());
    private du Og;
    private Intent pA;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    public static void pA(yFO yfo, String str, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar) {
        if (yfo == null) {
            return;
        }
        Intent intent = new Intent(aBv.pA(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("ext_info", yfo.tM());
        intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.pA.pA(yfo.QI()));
        intent.putExtra("creative_info", yfo.jO().toString());
        intent.putExtra("closed_listener_key", str);
        if (pAVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                Bzk.Og().pA(str, pAVar);
            } else {
                KZx.put(str, pAVar);
            }
        }
        com.bytedance.sdk.component.utils.Og.pA(aBv.pA(), intent, null);
    }

    public static void pA(yFO yfo, String str) {
        pA(yfo, str, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!Sn.ML()) {
            finish();
            return;
        }
        Og();
        this.pA = getIntent();
        if (aBv.pA() == null) {
            aBv.Og(this);
        }
    }

    private void Og() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (aBv.pA() == null) {
            aBv.Og(this);
        }
        setIntent(intent);
        this.pA = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        du duVar = this.Og;
        if ((duVar == null || ((com.bytedance.sdk.openadsdk.KZx.KZx) duVar).pA == null || !((com.bytedance.sdk.openadsdk.KZx.KZx) this.Og).pA.isShowing()) && this.pA != null) {
            KZx();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        du duVar = this.Og;
        if (duVar != null) {
            duVar.Og();
        }
    }

    private void KZx() {
        int intExtra = this.pA.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra == 6) {
                pA(this.pA.getStringExtra("ext_info"), this.pA.getStringExtra("filter_words"), this.pA.getStringExtra("closed_listener_key"), this.pA.getStringExtra("creative_info"));
                return;
            }
            finish();
        }
    }

    private void pA(String str, String str2, final String str3, String str4) {
        if (str2 != null && str != null && this.Og == null) {
            com.bytedance.sdk.openadsdk.KZx.KZx kZx = new com.bytedance.sdk.openadsdk.KZx.KZx(this, str, com.bytedance.sdk.openadsdk.tool.pA.pA(str2), str4, "other");
            this.Og = kZx;
            kZx.pA(str3);
            this.Og.pA(new du.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.du.pA
                public void pA(int i, String str5) {
                    com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVarML;
                    if (TTDelegateActivity.KZx != null && TTDelegateActivity.KZx.size() > 0 && !TextUtils.isEmpty(str3) && !com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar = (com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA) TTDelegateActivity.KZx.get(str3);
                        if (pAVar != null) {
                            pAVar.pA();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (pAVarML = Bzk.Og().ML(str3)) != null) {
                        pAVarML.pA();
                        Bzk.Og().JG(str3);
                    }
                    TTDelegateActivity.this.pA(str3);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.du.pA
                public void pA() {
                    if (!((com.bytedance.sdk.openadsdk.KZx.KZx) TTDelegateActivity.this.Og).KZx()) {
                        TTDelegateActivity.this.pA(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.KZx.KZx) TTDelegateActivity.this.Og).pA(false);
                }
            });
        }
        du duVar = this.Og;
        if (duVar != null) {
            duVar.pA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str) {
        Map<String, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA> map = KZx;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (WV.ZZv()) {
            map.size();
        }
    }
}
