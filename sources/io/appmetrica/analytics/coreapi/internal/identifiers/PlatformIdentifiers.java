package io.appmetrica.analytics.coreapi.internal.identifiers;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/PlatformIdentifiers;", "", "Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", "component1", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "component2", "advIdentifiersProvider", "appSetIdProvider", "copy", "", "toString", "", "hashCode", "other", "", "equals", "a", "Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", "getAdvIdentifiersProvider", "()Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "getAppSetIdProvider", "()Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;", "<init>", "(Lio/appmetrica/analytics/coreapi/internal/identifiers/SimpleAdvertisingIdGetter;Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdProvider;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
public final /* data */ class PlatformIdentifiers {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SimpleAdvertisingIdGetter advIdentifiersProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final AppSetIdProvider appSetIdProvider;

    public PlatformIdentifiers(SimpleAdvertisingIdGetter simpleAdvertisingIdGetter, AppSetIdProvider appSetIdProvider) {
        this.advIdentifiersProvider = simpleAdvertisingIdGetter;
        this.appSetIdProvider = appSetIdProvider;
    }

    public static /* synthetic */ PlatformIdentifiers copy$default(PlatformIdentifiers platformIdentifiers, SimpleAdvertisingIdGetter simpleAdvertisingIdGetter, AppSetIdProvider appSetIdProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAdvertisingIdGetter = platformIdentifiers.advIdentifiersProvider;
        }
        if ((i & 2) != 0) {
            appSetIdProvider = platformIdentifiers.appSetIdProvider;
        }
        return platformIdentifiers.copy(simpleAdvertisingIdGetter, appSetIdProvider);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SimpleAdvertisingIdGetter getAdvIdentifiersProvider() {
        return this.advIdentifiersProvider;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AppSetIdProvider getAppSetIdProvider() {
        return this.appSetIdProvider;
    }

    public final PlatformIdentifiers copy(SimpleAdvertisingIdGetter advIdentifiersProvider, AppSetIdProvider appSetIdProvider) {
        return new PlatformIdentifiers(advIdentifiersProvider, appSetIdProvider);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformIdentifiers)) {
            return false;
        }
        PlatformIdentifiers platformIdentifiers = (PlatformIdentifiers) other;
        return Intrinsics.areEqual(this.advIdentifiersProvider, platformIdentifiers.advIdentifiersProvider) && Intrinsics.areEqual(this.appSetIdProvider, platformIdentifiers.appSetIdProvider);
    }

    public final SimpleAdvertisingIdGetter getAdvIdentifiersProvider() {
        return this.advIdentifiersProvider;
    }

    public final AppSetIdProvider getAppSetIdProvider() {
        return this.appSetIdProvider;
    }

    public int hashCode() {
        return this.appSetIdProvider.hashCode() + (this.advIdentifiersProvider.hashCode() * 31);
    }

    public String toString() {
        return "PlatformIdentifiers(advIdentifiersProvider=" + this.advIdentifiersProvider + ", appSetIdProvider=" + this.appSetIdProvider + ')';
    }
}
