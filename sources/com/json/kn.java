package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0005\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u0005\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/ironsource/kn;", "", "", "g", "Lcom/ironsource/cq;", "a", "Lcom/ironsource/cq;", "e", "()Lcom/ironsource/cq;", "(Lcom/ironsource/cq;)V", "providersSettingsHolder", "Ljava/util/concurrent/atomic/AtomicBoolean;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/concurrent/atomic/AtomicBoolean;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "(Ljava/lang/String;)V", JsonStorageKeyNames.SESSION_ID_KEY, "Lcom/ironsource/s8;", "d", "Lcom/ironsource/s8;", "()Lcom/ironsource/s8;", "(Lcom/ironsource/s8;)V", "adFormatConfiguration", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class kn {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile kn f;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private cq providersSettingsHolder;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final AtomicBoolean initialized;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String sessionId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private s8 adFormatConfiguration;

    /* JADX INFO: renamed from: com.ironsource.kn$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0003\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ironsource/kn$a;", "", "Lcom/ironsource/kn;", "a", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/unity3d/ironsourceads/internal/AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/e3;", m5.p, "Lcom/ironsource/kn;", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e3 a(IronSource.AD_UNIT adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            kn knVar = kn.f;
            s8 adFormatConfiguration = knVar != null ? knVar.getAdFormatConfiguration() : null;
            kn knVar2 = kn.f;
            cq providersSettingsHolder = knVar2 != null ? knVar2.getProvidersSettingsHolder() : null;
            return (adFormatConfiguration == null || providersSettingsHolder == null) ? new kb() : new r7(adFormatConfiguration, providersSettingsHolder, adFormat);
        }

        @JvmStatic
        public final kn a() {
            kn knVar = kn.f;
            if (knVar == null) {
                synchronized (this) {
                    knVar = kn.f;
                    if (knVar == null) {
                        knVar = new kn(null);
                        Companion companion = kn.INSTANCE;
                        kn.f = knVar;
                    }
                }
            }
            return knVar;
        }
    }

    private kn() {
        this.initialized = new AtomicBoolean(false);
        this.sessionId = "";
    }

    public /* synthetic */ kn(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final kn d() {
        return INSTANCE.a();
    }

    public final void a(cq cqVar) {
        this.providersSettingsHolder = cqVar;
    }

    public final void a(s8 s8Var) {
        this.adFormatConfiguration = s8Var;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final s8 getAdFormatConfiguration() {
        return this.adFormatConfiguration;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final cq getProvidersSettingsHolder() {
        return this.providersSettingsHolder;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void g() {
        this.initialized.set(true);
    }
}
