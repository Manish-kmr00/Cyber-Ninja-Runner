package com.smaato.sdk.core.framework;

import android.app.Application;
import com.smaato.sdk.core.appconfigcheck.ExpectedManifestEntries;

/* JADX INFO: loaded from: classes11.dex */
public interface CoreModuleLoaderInterface extends BaseModuleInterface {
    ExpectedManifestEntries getExpectedManifestEntries();

    void setApplication(Application application);
}
