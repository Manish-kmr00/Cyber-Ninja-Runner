package io.bidmachine.ads.networks.gam_dynamic.versions;

import io.bidmachine.utils.version.Version;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseVersionWrapper implements VersionWrapper {
    private final int minDeviceApiVersion;
    private final Version versionForWhichCompiled;

    public BaseVersionWrapper(int i, Version version) {
        this.minDeviceApiVersion = i;
        this.versionForWhichCompiled = version;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper
    public int getMinDeviceApiVersion() {
        return this.minDeviceApiVersion;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper
    public Version getVersionForWhichCompiled() {
        return this.versionForWhichCompiled;
    }
}
