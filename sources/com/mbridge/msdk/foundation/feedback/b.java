package com.mbridge.msdk.foundation.feedback;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: FeedbackManager.java */
/* JADX INFO: loaded from: classes11.dex */
public class b {
    public static int d = -2;
    public static int e = -2;
    public static volatile boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f4946a;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.feedback.bean.a> b;
    private g c;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.feedback.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FeedbackManager.java */
    static class C0434b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f4947a = new b();
    }

    public static b b() {
        return C0434b.f4947a;
    }

    private com.mbridge.msdk.foundation.feedback.bean.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        return null;
    }

    public void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.feedback.a aVar) {
        if (a()) {
            com.mbridge.msdk.foundation.feedback.bean.a aVarB = b(str);
            if (aVar != null) {
                aVarB.a(new com.mbridge.msdk.foundation.feedback.bean.a.g(str, aVar));
            }
            FeedBackButton feedBackButtonI = aVarB.i();
            if (feedBackButtonI != null) {
                if (layoutParams == null) {
                    int iA = t0.a(c.m().d(), 10.0f);
                    this.f4946a.setMargins(iA, iA, iA, iA);
                    layoutParams = this.f4946a;
                }
                ViewGroup viewGroup2 = (ViewGroup) feedBackButtonI.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(feedBackButtonI);
                }
                Activity activityA = a(context);
                if (activityA != null && viewGroup == null) {
                    viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonI);
                    viewGroup.addView(feedBackButtonI, layoutParams);
                }
            }
        }
    }

    public void d(String str) {
        try {
            com.mbridge.msdk.foundation.feedback.bean.a aVarC = c(str);
            if (aVarC != null) {
                aVarC.f();
            }
            this.b.remove(str);
            f = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private b() {
        this.f4946a = new RelativeLayout.LayoutParams(e, d);
        this.b = new ConcurrentHashMap<>();
    }

    public com.mbridge.msdk.foundation.feedback.bean.a b(String str) {
        com.mbridge.msdk.foundation.feedback.bean.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.b.containsKey(str)) {
            aVar = this.b.get(str);
        } else {
            aVar = new com.mbridge.msdk.foundation.feedback.bean.a(str);
            this.b.put(str, aVar);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.feedback.bean.a aVar2 = new com.mbridge.msdk.foundation.feedback.bean.a(str);
        this.b.put(str, aVar2);
        return aVar2;
    }

    public void b(String str, int i) {
        b(str).c(i);
    }

    public boolean a() {
        g gVarD = h.b().d(c.m().b());
        this.c = gVarD;
        if (gVarD != null) {
            return false;
        }
        this.c = h.b().a();
        return false;
    }

    public Activity a(Context context) {
        Activity activity;
        Context contextF = c.m().f();
        Activity activity2 = null;
        try {
            Activity activity3 = contextF instanceof Activity ? (Activity) contextF : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> weakReferenceA = c.m().a();
                if (weakReferenceA != null && (activity = weakReferenceA.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing() || activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e2) {
                e = e2;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void a(String str, int i, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.feedback.bean.a aVarB = b(str);
        if (aVarB.i() != null) {
            aVarB.d(i);
            if (i == 0) {
                a(str, c.m().d(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.feedback.a) null);
            }
        }
    }

    public void a(String str, int i, int i2, int i3, float f2, float f3, float f4, String str2, String str3, float f5, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.feedback.bean.a aVarB = b(str);
        Context contextD = c.m().d();
        aVarB.a(t0.a(contextD, f2), t0.a(contextD, f3), t0.a(contextD, i), t0.a(contextD, i2), t0.a(contextD, i3), f4, str2, str3, f5, jSONArray);
    }

    public void a(String str, int i, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a aVarB = b(str);
        aVarB.a(new com.mbridge.msdk.foundation.feedback.bean.a.g(str, aVar));
        if (i == 1) {
            aVarB.g();
        } else {
            aVarB.p();
        }
    }

    public FeedBackButton a(String str) {
        return b(str).i();
    }

    public void a(String str, int i, int i2, String str2, String str3) {
        com.mbridge.msdk.foundation.feedback.bean.a aVarC = c(str + "_1");
        if (aVarC == null) {
            aVarC = c(str + "_2");
            if (aVarC == null && (aVarC = c(str + "_3")) == null && (aVarC = c(str + "_4")) == null) {
                aVarC = b(str);
            } else {
                aVarC.c(0);
            }
        }
        if (aVarC != null) {
            CampaignEx campaignExH = aVarC.h();
            j.a(campaignExH, campaignExH != null ? campaignExH.getCampaignUnitId() : "", aVarC.k(), aVarC.j(), !TextUtils.isEmpty(str2) ? str2 : "", i, campaignExH != null ? campaignExH.getAdType() : 0, i2, str3);
        }
    }

    public void a(String str, CampaignEx campaignEx) {
        b(str).a(campaignEx);
    }

    public void a(String str, String str2) {
        b(str).b(str2);
    }

    public void a(String str, FeedBackButton feedBackButton) {
        b(str).a(feedBackButton);
    }

    public void a(String str, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a aVarB = b(str);
        if (aVar != null) {
            aVarB.a(new com.mbridge.msdk.foundation.feedback.bean.a.g(str, aVar));
        }
    }

    public void a(String str, int i) {
        b(str).b(i);
    }

    public boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            o0.c("", "mbAlertDialog  is null");
            return false;
        }
        return a(context, mBFeedBackDialog);
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity activityA = a(context);
        if (activityA == null || mBFeedBackDialog == null || activityA.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || activityA.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
