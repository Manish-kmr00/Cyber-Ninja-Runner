package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\b\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0005j\u0002`\tH\u0016J:\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0006\u001a\u00060\u0005j\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0005j\u0002`\tH\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\b\u0010\u001c\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/ironsource/zo;", "Lcom/ironsource/ff;", "Lcom/ironsource/ff$a;", "Lcom/ironsource/yo;", DTBMetricsConfiguration.CONFIG_DIR, "", "identifier", "", "a", "Lcom/ironsource/services/capping/Identifier;", "Lcom/ironsource/l8;", "Lcom/ironsource/n8;", "cappingType", "Lcom/ironsource/df;", "cappingConfig", "Lkotlin/Result;", "", "(Ljava/lang/String;Lcom/ironsource/n8;Lcom/ironsource/df;)Ljava/lang/Object;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/q9;", "Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/yf;", "Lcom/ironsource/yf;", "repository", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/Map;", "()Ljava/util/Map;", ug.p, "<init>", "(Lcom/ironsource/q9;Lcom/ironsource/yf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class zo implements ff, ff.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q9 currentTimeProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final yf repository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, yo> configs;

    public zo(q9 currentTimeProvider, yf repository) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.currentTimeProvider = currentTimeProvider;
        this.repository = repository;
        this.configs = new LinkedHashMap();
    }

    private final boolean a(yo config, String identifier) {
        Long lA = this.repository.a(identifier);
        if (lA == null) {
            return false;
        }
        lA.longValue();
        return this.currentTimeProvider.a() - lA.longValue() < config.getTimeInterval();
    }

    @Override // com.json.ff
    public l8 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        yo yoVar = this.configs.get(identifier);
        if (yoVar != null && a(yoVar, identifier)) {
            return new l8(true, n8.Pacing);
        }
        return new l8(false, null, 2, null);
    }

    @Override // com.ironsource.ff.a
    public Object a(String identifier, n8 cappingType, df cappingConfig) {
        Object objCreateFailure;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        Object objB = cappingConfig.b();
        if (!Result.m7911isSuccessimpl(objB)) {
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objB);
            if (thM7907exceptionOrNullimpl != null) {
                Result.Companion companion = Result.INSTANCE;
                objCreateFailure = ResultKt.createFailure(thM7907exceptionOrNullimpl);
            }
            return Result.m7904constructorimpl(objCreateFailure);
        }
        yo yoVar = (yo) objB;
        if (yoVar != null) {
            this.configs.put(identifier, yoVar);
        }
        Result.Companion companion2 = Result.INSTANCE;
        objCreateFailure = Unit.INSTANCE;
        return Result.m7904constructorimpl(objCreateFailure);
    }

    public final Map<String, yo> a() {
        return this.configs;
    }

    @Override // com.ironsource.ff.a
    public void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (this.configs.get(identifier) == null) {
            return;
        }
        this.repository.a(this.currentTimeProvider.a(), identifier);
    }
}
