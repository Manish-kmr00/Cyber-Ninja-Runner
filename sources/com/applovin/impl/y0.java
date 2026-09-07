package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f748a;
    private final int b;
    private List c;
    private String d;
    private u0 e;
    private t0.c f;
    private u0 g;
    private Dialog h;
    private t0.b i = new t0.b();
    private final com.applovin.impl.b j = new a();

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || y0.this.g == null) {
                return;
            }
            if (y0.this.h != null) {
                y0 y0Var = y0.this;
                if (!com.applovin.impl.d.d(y0Var.a(y0Var.h))) {
                    y0.this.h.dismiss();
                }
                y0.this.h = null;
            }
            u0 u0Var = y0.this.g;
            y0.this.g = null;
            y0 y0Var2 = y0.this;
            y0Var2.a(y0Var2.e, u0Var, activity);
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f750a;
        final /* synthetic */ u0 b;
        final /* synthetic */ Activity c;

        b(w0 w0Var, u0 u0Var, Activity activity) {
            this.f750a = w0Var;
            this.b = u0Var;
            this.c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            y0.this.g = null;
            y0.this.h = null;
            u0 u0VarA = y0.this.a(this.f750a.a());
            if (u0VarA == null) {
                y0.this.a("Destination state for TOS/PP alert is null");
                return;
            }
            y0.this.a(this.b, u0VarA, this.c);
            if (u0VarA.c() != u0.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f751a;
        final /* synthetic */ Activity b;

        c(Uri uri, Activity activity) {
            this.f751a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            k7.a(this.f751a, this.b, y0.this.f748a);
        }
    }

    class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f752a;
        final /* synthetic */ Activity b;

        d(Uri uri, Activity activity) {
            this.f752a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            k7.a(this.f752a, this.b, y0.this.f748a);
        }
    }

    class e implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f753a;
        final /* synthetic */ Activity b;

        e(u0 u0Var, Activity activity) {
            this.f753a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            y0.this.i.a(appLovinCmpError);
            y0.this.a(this.f753a, this.b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class f implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f754a;
        final /* synthetic */ Activity b;

        f(u0 u0Var, Activity activity) {
            this.f754a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            y0.this.i.a(appLovinCmpError);
            y0.this.a(this.f754a, this.b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class g implements CmpServiceImpl.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f755a;
        final /* synthetic */ Activity b;

        g(u0 u0Var, Activity activity) {
            this.f755a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.f
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                y0.this.i.a(appLovinCmpError);
            } else {
                y0.this.i.c();
            }
            y0.this.b(this.f755a, this.b);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f756a;

        h(u0 u0Var) {
            this.f756a = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0 y0Var = y0.this;
            y0Var.a(y0Var.e, this.f756a, y0.this.f748a.v0());
        }
    }

    public y0(com.applovin.impl.sdk.k kVar) {
        this.f748a = kVar;
        this.b = ((Integer) kVar.a(v4.N6)).intValue();
    }

    private void c(final u0 u0Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.y0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(u0Var, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u0 u0Var, Activity activity) {
        a(u0Var, activity, (Boolean) null);
    }

    private void b() {
        this.c = null;
        this.e = null;
        this.f748a.e().b(this.j);
        t0.c cVar = this.f;
        if (cVar != null) {
            cVar.a(this.i);
            this.f = null;
        }
        this.i = new t0.b();
    }

    public void a(Activity activity, t0.c cVar) {
        a(u0.a.IS_AL_GDPR.b(), activity, cVar);
    }

    public void a(int i, Activity activity, t0.c cVar) {
        if (this.c != null) {
            this.f748a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f748a.O().a("ConsentFlowStateMachine", "Unable to start states: " + this.c);
            }
            this.f748a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f748a.O().a("ConsentFlowStateMachine", "Consent flow already in progress for states: " + this.c);
            }
            cVar.a(new t0.b(new s0(s0.d, "Consent flow is already in progress.")));
            return;
        }
        List listA = z0.a(this.f748a);
        this.c = listA;
        this.d = String.valueOf(listA);
        this.f = cVar;
        u0 u0VarA = a(i);
        this.f748a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f748a.O().a("ConsentFlowStateMachine", "Starting consent flow with states: " + this.c + "\nInitial state: " + u0VarA);
        }
        com.applovin.impl.sdk.k.a(activity).a(this.j);
        a((u0) null, u0VarA, activity);
    }

    public boolean a() {
        return this.c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u0 u0Var, Activity activity, Boolean bool) {
        a(u0Var, a(u0Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u0 u0Var, u0 u0Var2, Activity activity) {
        this.e = u0Var;
        c(u0Var2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(u0 u0Var, final Activity activity) {
        SpannableString spannableString;
        if (u0Var == null) {
            a("Consent flow state is null");
            return;
        }
        this.f748a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f748a.O().a("ConsentFlowStateMachine", "Transitioning to state: " + u0Var);
        }
        if (u0Var.c() == u0.b.ALERT) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            }
            this.f748a.G().trackEvent("cf_start");
            v0 v0Var = (v0) u0Var;
            this.g = v0Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (w0 w0Var : v0Var.d()) {
                b bVar = new b(w0Var, u0Var, activity);
                if (w0Var.c() == w0.a.POSITIVE) {
                    builder.setPositiveButton(w0Var.d(), bVar);
                } else if (w0Var.c() == w0.a.NEGATIVE) {
                    builder.setNegativeButton(w0Var.d(), bVar);
                } else {
                    builder.setNeutralButton(w0Var.d(), bVar);
                }
            }
            String strF = v0Var.f();
            if (StringUtils.isValidString(strF)) {
                spannableString = new SpannableString(strF);
                String strA = com.applovin.impl.sdk.k.a(R.string.applovin_terms_of_service_text);
                String strA2 = com.applovin.impl.sdk.k.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(strF, Arrays.asList(strA, strA2))) {
                    Uri uriH = this.f748a.y().h();
                    if (uriH != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(strA), new c(uriH, activity), true);
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(strA2), new d(this.f748a.y().f(), activity), true);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(v0Var.e()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.y0$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f$0.a(alertDialogCreate, activity, dialogInterface);
                }
            });
            this.h = alertDialogCreate;
            alertDialogCreate.show();
            this.i.d();
            return;
        }
        if (u0Var.c() == u0.b.POST_ALERT) {
            if (this.f748a.y().k() && this.f748a.y().m()) {
                if (com.applovin.impl.d.d(activity)) {
                    a(u0Var);
                    return;
                } else {
                    this.f748a.t().loadCmp(activity, new e(u0Var, activity));
                    return;
                }
            }
            a(u0Var, activity, Boolean.FALSE);
            return;
        }
        if (u0Var.c() == u0.b.EVENT) {
            x0 x0Var = (x0) u0Var;
            String strE = x0Var.e();
            Map<String, ?> mapD = x0Var.d();
            if (mapD == null) {
                mapD = new HashMap<>(1);
            }
            mapD.put("flow_type", "unified");
            this.f748a.G().trackEvent(strE, mapD);
            b(x0Var, activity);
            return;
        }
        if (u0Var.c() == u0.b.CMP_LOAD) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            } else if (this.f748a.y().m()) {
                this.f748a.t().preloadCmp(activity);
                a(u0Var, activity, Boolean.FALSE);
                return;
            } else {
                this.f748a.t().loadCmp(activity, new f(u0Var, activity));
                return;
            }
        }
        if (u0Var.c() == u0.b.CMP_SHOW) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            }
            if (!this.f748a.y().m()) {
                this.f748a.G().trackEvent("cf_start");
            }
            this.f748a.t().showCmp(activity, new g(u0Var, activity));
            return;
        }
        if (u0Var.c() == u0.b.DECISION) {
            u0.a aVarA = u0Var.a();
            if (aVarA == u0.a.IS_AL_GDPR) {
                a(u0Var, activity, Boolean.valueOf(this.f748a.y().k()));
                return;
            }
            if (aVarA == u0.a.IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT) {
                a(u0Var, activity, Boolean.valueOf(!this.f748a.A0() || ((Boolean) this.f748a.a(x4.s, Boolean.FALSE)).booleanValue()));
                return;
            } else if (aVarA == u0.a.HAS_TERMS_OF_SERVICE_URI) {
                a(u0Var, activity, Boolean.valueOf(this.f748a.y().h() != null));
                return;
            } else {
                a("Invalid consent flow decision type: " + aVarA);
                return;
            }
        }
        if (u0Var.c() == u0.b.REINIT) {
            b();
        } else {
            a("Invalid consent flow destination state: " + u0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
    }

    private void a(u0 u0Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new h(u0Var), TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        k1.a(str, new Object[0]);
        this.f748a.E().a(c2.B0, str, CollectionUtils.hashMap("details", "Last started states: " + this.d + "\nLast successful state: " + this.e));
        t0.b bVar = this.i;
        if (bVar != null) {
            bVar.a(new s0(s0.e, str));
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u0 a(int i) {
        List<u0> list = this.c;
        if (list == null) {
            return null;
        }
        for (u0 u0Var : list) {
            if (i == u0Var.b()) {
                return u0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }
}
