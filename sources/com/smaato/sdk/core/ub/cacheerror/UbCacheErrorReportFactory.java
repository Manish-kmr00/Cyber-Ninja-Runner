package com.smaato.sdk.core.ub.cacheerror;

import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.errorreport.Report;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.remoteconfig.publisher.ConfigurationProvider;
import com.smaato.sdk.core.remoteconfig.publisher.Param;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class UbCacheErrorReportFactory {
    private final ConfigurationProvider configurationProvider;
    private final DataCollector dataCollector;
    private final Logger logger;

    public UbCacheErrorReportFactory(Logger logger, DataCollector dataCollector, ConfigurationProvider configurationProvider) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.dataCollector = (DataCollector) Objects.requireNonNull(dataCollector);
        this.configurationProvider = (ConfigurationProvider) Objects.requireNonNull(configurationProvider);
    }

    public Report create(UbCacheError ubCacheError, UbCacheErrorReportingParams ubCacheErrorReportingParams) {
        int creative = this.configurationProvider.getConfiguration(ubCacheErrorReportingParams.publisherId()).getErrorLoggingRate().getCreative();
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ub$cacheerror$UbCacheError[ubCacheError.ordinal()];
        if (i == 1) {
            return new Report(Lists.of(createCommonParams(ubCacheErrorReportingParams), createForExpiredCache(creative)), creative);
        }
        if (i == 2) {
            return new Report(Lists.of(createCommonParams(ubCacheErrorReportingParams), createForFailedCacheAccess(creative)), creative);
        }
        this.logger.error(LogDomain.UNIFIED_BIDDING, String.format("Cannot create error report: unexpected %s: %s", "UbCacheError", ubCacheError), new Object[0]);
        return Report.EMPTY;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ub$cacheerror$UbCacheError;

        static {
            int[] iArr = new int[UbCacheError.values().length];
            $SwitchMap$com$smaato$sdk$core$ub$cacheerror$UbCacheError = iArr;
            try {
                iArr[UbCacheError.TTL_EXPIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ub$cacheerror$UbCacheError[UbCacheError.NO_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private List createCommonParams(UbCacheErrorReportingParams ubCacheErrorReportingParams) {
        return Lists.of(new Param.PublisherId(ubCacheErrorReportingParams.publisherId()), new Param.Timestamp(ubCacheErrorReportingParams.requestTimestamp()), new Param.SdkVersion(), new Param.ConnectionType(this.dataCollector), new Param.AdSpaceId(ubCacheErrorReportingParams.adSpaceId()), new Param.SessionId(ubCacheErrorReportingParams.sessionId()), new Param.Sci(ubCacheErrorReportingParams.creativeId()), new Param.FormatOfAd(this.logger, ubCacheErrorReportingParams.adFormat()));
    }

    private List createForFailedCacheAccess(int i) {
        return Lists.of(new Param.ErrorType("HB_AD_FAILED_CACHE_ACCESS"), new Param.SampleRate(i));
    }

    private List createForExpiredCache(int i) {
        return Lists.of(new Param.ErrorType("HB_AD_EXPIRED_CACHE"), new Param.SampleRate(i));
    }
}
