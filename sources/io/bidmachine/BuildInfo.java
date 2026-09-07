package io.bidmachine;

import android.content.Context;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.lazy.LazyCachedValue;
import io.bidmachine.utils.lazy.LazyValue;

/* JADX INFO: loaded from: classes11.dex */
public final class BuildInfo {
    private static volatile BuildInfo instance;
    private final LazyCachedValue<Boolean> isDebuggable;
    private volatile String sha1Signature = null;
    private volatile String sha256Signature = null;

    public static BuildInfo obtain(Context context) {
        BuildInfo buildInfo = instance;
        if (buildInfo == null) {
            synchronized (BuildInfo.class) {
                buildInfo = instance;
                if (buildInfo == null) {
                    buildInfo = new BuildInfo(context.getApplicationContext());
                    instance = buildInfo;
                }
            }
        }
        return buildInfo;
    }

    private BuildInfo(final Context context) {
        this.isDebuggable = new LazyCachedValue<>(new LazyValue() { // from class: io.bidmachine.BuildInfo$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
            }
        });
    }

    public boolean isDebuggable() {
        return this.isDebuggable.get().booleanValue();
    }

    public String getSha1Signature(Context context) {
        String str = this.sha1Signature;
        if (str != null) {
            return str;
        }
        String sha1Signature = DeviceUtils.getSha1Signature(context);
        this.sha1Signature = sha1Signature;
        return sha1Signature;
    }

    public String getSha256Signature(Context context) {
        String str = this.sha256Signature;
        if (str != null) {
            return str;
        }
        String sha256Signature = DeviceUtils.getSha256Signature(context);
        this.sha256Signature = sha256Signature;
        return sha256Signature;
    }
}
