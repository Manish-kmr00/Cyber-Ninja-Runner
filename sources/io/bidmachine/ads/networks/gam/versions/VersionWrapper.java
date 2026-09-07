package io.bidmachine.ads.networks.gam.versions;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.utils.version.Version;

/* JADX INFO: loaded from: classes2.dex */
public interface VersionWrapper {
    InternalGAMAd createAd(GAMLoader gAMLoader, AdsFormat adsFormat, GAMUnitData gAMUnitData);

    int getMinDeviceApiVersion();

    Version getVersion() throws Throwable;

    Version getVersionForWhichCompiled();

    void initialize(Context context) throws Throwable;

    boolean isGAMPresent(Context context);
}
