package com.smaato.sdk.core.datacollector;

import android.content.Context;
import com.json.b9;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Pair;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.reflection.MethodAccessor;

/* JADX INFO: loaded from: classes4.dex */
public final class GoogleAdvertisingClientInfo {
    private final Context context;
    private final Logger logger;
    private MethodAccessor methodAccessor;
    private String advertisingId = null;
    private Boolean isAdTrackingEnabled = null;

    public GoogleAdvertisingClientInfo(Logger logger, Context context) {
        this.logger = logger;
        this.context = context;
        init();
    }

    public void init() {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.datacollector.GoogleAdvertisingClientInfo$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.fetchGAIDandTrackingEnabled();
            }
        });
    }

    public void fetchGAIDandTrackingEnabled() {
        try {
            Object googleAdvertisingIdInfo = getGoogleAdvertisingIdInfo();
            if (googleAdvertisingIdInfo == null) {
                throw new MethodAccessor.MethodAccessingException(new Throwable("Cannot fetch AdvertisingIdClient.Info: null received"));
            }
            Boolean bool = (Boolean) new MethodAccessor.Builder().fromObjectInstance(googleAdvertisingIdInfo).setMethodName(b9.i.M).build().execute();
            bool.booleanValue();
            this.isAdTrackingEnabled = bool;
            if (bool.booleanValue()) {
                this.advertisingId = null;
            } else {
                this.advertisingId = (String) new MethodAccessor.Builder().fromObjectInstance(googleAdvertisingIdInfo).setMethodName("getId").build().execute();
            }
        } catch (MethodAccessor.MethodAccessingException | ClassNotFoundException unused) {
            this.logger.info(LogDomain.DATA_COLLECTOR, "Cannot fetch AdvertisingIdClient.Info: AdvertisingID or isLimitAdTrackingEnabled is null", new Object[0]);
        } catch (Exception unused2) {
            this.logger.info(LogDomain.DATA_COLLECTOR, "Cannot fetch AdvertisingIdClient.Info: Unknown Error", new Object[0]);
        }
    }

    public String getAdvertisingId() {
        return this.advertisingId;
    }

    public boolean isLimitAdTrackingEnabled() {
        Boolean bool = this.isAdTrackingEnabled;
        return bool != null && bool.booleanValue();
    }

    private Object getGoogleAdvertisingIdInfo() {
        MethodAccessor methodAccessorBuild = new MethodAccessor.Builder().fromClassInstance("com.google.android.gms.ads.identifier.AdvertisingIdClient").setMethodName("getAdvertisingIdInfo").withParametersOfResolvedTypes(Pair.of(Context.class, this.context)).build();
        this.methodAccessor = methodAccessorBuild;
        return methodAccessorBuild.execute();
    }
}
