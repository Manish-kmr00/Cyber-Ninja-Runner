package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes10.dex */
public class Og {
    private static pA pA;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.Og$Og, reason: collision with other inner class name */
    public interface InterfaceC0208Og {
        void pA();

        void pA(Throwable th);
    }

    public interface pA {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    public static void pA(pA pAVar) {
        pA = pAVar;
    }

    public static boolean pA(Context context, Intent intent, InterfaceC0208Og interfaceC0208Og) {
        return pA(context, intent, interfaceC0208Og, false);
    }

    public static boolean pA(final Context context, final Intent intent, final InterfaceC0208Og interfaceC0208Og, boolean z) {
        pA pAVar;
        ExecutorService asyncStartActivityThreadPool;
        if (z && (pAVar = pA) != null && pAVar.isEnableAsyncStartActivity() && (asyncStartActivityThreadPool = pA.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.omh.omh("startAct") { // from class: com.bytedance.sdk.component.utils.Og.1
                @Override // java.lang.Runnable
                public void run() {
                    Og.KZx(context, intent, interfaceC0208Og);
                }
            });
            return true;
        }
        return KZx(context, intent, interfaceC0208Og);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean KZx(Context context, Intent intent, InterfaceC0208Og interfaceC0208Og) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                if (interfaceC0208Og == null) {
                    return true;
                }
                interfaceC0208Og.pA();
                return true;
            } catch (Throwable th) {
                if (interfaceC0208Og != null) {
                    interfaceC0208Og.pA(th);
                }
            }
        }
        return false;
    }

    public static Activity pA(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
