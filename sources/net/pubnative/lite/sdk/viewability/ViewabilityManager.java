package net.pubnative.lite.sdk.viewability;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.iab.omid.library.pubnativenet.Omid;
import com.iab.omid.library.pubnativenet.adsession.Partner;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes11.dex */
public class ViewabilityManager {
    private static final String TAG = "ViewabilityManager";
    private static String VIEWABILITY_JS_SERVICE_CONTENT = null;
    public static final String VIEWABILITY_PARTNER_NAME = "Pubnativenet";
    private Partner mPubNativePartner = null;
    private boolean mShouldMeasureViewability = true;

    public ViewabilityManager(final Application application) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.viewability.ViewabilityManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9784x666ebf04(application);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$net-pubnative-lite-sdk-viewability-ViewabilityManager, reason: not valid java name */
    /* synthetic */ void m9784x666ebf04(Application application) {
        try {
            if (!Omid.isActive()) {
                Omid.activate(application);
            }
        } catch (IllegalArgumentException unused) {
            Logger.e(TAG, "Could not initialise Omid");
        }
        if (Omid.isActive() && this.mPubNativePartner == null) {
            try {
                this.mPubNativePartner = Partner.createPartner(VIEWABILITY_PARTNER_NAME, "3.3.0");
            } catch (IllegalArgumentException unused2) {
                Logger.e(TAG, "Could not initialise Omid");
            }
        }
        if (TextUtils.isEmpty(VIEWABILITY_JS_SERVICE_CONTENT)) {
            VIEWABILITY_JS_SERVICE_CONTENT = new String(Base64.decode(Assets.omsdkjs, 0));
        }
    }

    public boolean isViewabilityMeasurementActivated() {
        return Omid.isActive() && this.mShouldMeasureViewability;
    }

    public Partner getPartner() {
        return this.mPubNativePartner;
    }

    public void setViewabilityMeasurementEnabled(boolean z) {
        this.mShouldMeasureViewability = z;
    }

    public boolean isViewabilityMeasurementEnabled() {
        return this.mShouldMeasureViewability;
    }

    public String getServiceJs() {
        return VIEWABILITY_JS_SERVICE_CONTENT;
    }
}
