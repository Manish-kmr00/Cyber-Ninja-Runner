package net.pubnative.lite.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.json.b9;
import java.lang.ref.WeakReference;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.network.ApiExecutor;
import net.pubnative.lite.sdk.utils.reflection.MethodBuilderFactory;

/* JADX INFO: loaded from: classes9.dex */
public class HyBidAdvertisingId {
    private static final String TAG = "HyBidAdvertisingId";
    private static final String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private final WeakReference<Context> mContextRef;

    public interface Listener {
        void onHyBidAdvertisingIdFinish(String str, Boolean bool);
    }

    public HyBidAdvertisingId(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public void execute(final Listener listener) {
        ApiExecutor.getInstance().execute(new Runnable() { // from class: net.pubnative.lite.sdk.utils.HyBidAdvertisingId$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9744lambda$execute$0$netpubnativelitesdkutilsHyBidAdvertisingId(listener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$execute$0$net-pubnative-lite-sdk-utils-HyBidAdvertisingId, reason: not valid java name */
    /* synthetic */ void m9744lambda$execute$0$netpubnativelitesdkutilsHyBidAdvertisingId(Listener listener) {
        if (this.mContextRef.get() != null) {
            try {
                Object objExecute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(sAdvertisingIdClientClassName)).addParam(Context.class, this.mContextRef.get()).execute();
                post(listener, reflectedGetAdvertisingId(objExecute, null), reflectedIsLimitAdTrackingEnabled(objExecute, false));
            } catch (Exception e) {
                HyBid.reportException(e);
                Logger.e(TAG, "Unable to obtain Advertising ID.");
            }
        }
    }

    private static void post(final Listener listener, final String str, final boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.utils.HyBidAdvertisingId$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HyBidAdvertisingId.lambda$post$1(listener, str, z);
            }
        }, 0L);
    }

    static /* synthetic */ void lambda$post$1(Listener listener, String str, boolean z) {
        if (listener != null) {
            listener.onHyBidAdvertisingIdFinish(str, Boolean.valueOf(z));
        }
    }

    private String reflectedGetAdvertisingId(Object obj, String str) {
        try {
            return (String) MethodBuilderFactory.create(obj, "getId").execute();
        } catch (Exception e) {
            HyBid.reportException(e);
            return str;
        }
    }

    private boolean reflectedIsLimitAdTrackingEnabled(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) MethodBuilderFactory.create(obj, b9.i.M).execute();
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            HyBid.reportException(e);
            return z;
        }
    }
}
