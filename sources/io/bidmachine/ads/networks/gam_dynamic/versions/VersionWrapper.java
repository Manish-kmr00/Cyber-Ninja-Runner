package io.bidmachine.ads.networks.gam_dynamic.versions;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.InternalAd;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdListener;
import io.bidmachine.ads.networks.gam_dynamic.NetworkParams;
import io.bidmachine.ads.networks.gam_dynamic.TaskExecutor;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.version.Version;

/* JADX INFO: loaded from: classes11.dex */
public interface VersionWrapper {
    InternalAd createAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener);

    int getMinDeviceApiVersion();

    Version getVersion() throws Throwable;

    Version getVersionForWhichCompiled();

    void initialize(Context context) throws Throwable;

    boolean isGAMPresent(Context context);
}
