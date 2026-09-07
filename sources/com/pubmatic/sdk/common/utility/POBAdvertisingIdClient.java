package com.pubmatic.sdk.common.utility;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes13.dex */
public class POBAdvertisingIdClient {
    private static volatile POBAdvertisingIdClient d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f7625a = Executors.newSingleThreadExecutor();
    private final Context b;
    private Future c;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(POBAdvertisingIdClient.this.b);
                String id = advertisingIdInfo.getId();
                boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                if (id != null && !id.equals(POBAdvertisingIdClient.this.getStoredAdvertisingId())) {
                    POBAdvertisingIdClient.this.saveAndroidAid(id);
                }
                if (zIsLimitAdTrackingEnabled != POBAdvertisingIdClient.this.getStoredLMTState()) {
                    POBAdvertisingIdClient.this.saveLMTState(zIsLimitAdTrackingEnabled);
                }
            } catch (Exception | NoClassDefFoundError e) {
                POBLog.error("POBAdvertisingIdClient", "Error while requesting AAID: ", e.getMessage());
            }
        }
    }

    private POBAdvertisingIdClient(Context context) {
        this.b = context.getApplicationContext();
    }

    public static POBAdvertisingIdClient getInstance(Context context) {
        if (d == null) {
            synchronized (POBAdvertisingIdClient.class) {
                if (d == null) {
                    d = new POBAdvertisingIdClient(context);
                }
            }
        }
        return d;
    }

    public String getStoredAdvertisingId() {
        return this.b.getSharedPreferences(POBCommonConstants.POB_AID_STORAGE, 0).getString(POBCommonConstants.POB_AID_KEY, null);
    }

    public boolean getStoredLMTState() {
        return this.b.getSharedPreferences(POBCommonConstants.POB_AID_STORAGE, 0).getBoolean(POBCommonConstants.POB_LIMITED_TRACKING_AD_KEY, false);
    }

    protected boolean isReadyToUpdate() {
        Future future = this.c;
        if (future != null) {
            return future.isDone();
        }
        return true;
    }

    protected void saveAndroidAid(String str) {
        SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(POBCommonConstants.POB_AID_STORAGE, 0).edit();
        if (editorEdit != null) {
            editorEdit.putString(POBCommonConstants.POB_AID_KEY, str);
            editorEdit.apply();
        }
    }

    protected void saveLMTState(boolean z) {
        SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(POBCommonConstants.POB_AID_STORAGE, 0).edit();
        if (editorEdit != null) {
            editorEdit.putBoolean(POBCommonConstants.POB_LIMITED_TRACKING_AD_KEY, z);
            editorEdit.apply();
        }
    }

    public boolean updateAAID() {
        if (isReadyToUpdate()) {
            a();
            return true;
        }
        POBLog.debug("POBAdvertisingIdClient", "Skipping AAID update as last request is in progress", new Object[0]);
        return false;
    }

    private void a() {
        try {
            this.c = this.f7625a.submit(new a());
        } catch (OutOfMemoryError | RejectedExecutionException e) {
            POBLog.error("POBAdvertisingIdClient", "Unable to dispatch thread while requesting AAID: ", e.getMessage());
        }
    }
}
