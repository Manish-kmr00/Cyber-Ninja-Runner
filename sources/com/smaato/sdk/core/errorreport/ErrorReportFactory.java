package com.smaato.sdk.core.errorreport;

import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.remoteconfig.publisher.Param;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ErrorReportFactory {
    private final DataCollector dataCollector;

    public ErrorReportFactory(DataCollector dataCollector) {
        this.dataCollector = (DataCollector) Objects.requireNonNull(dataCollector);
    }

    public Report create(String str, String str2, long j) {
        return new Report(createParams(str, str2, j), 100);
    }

    private List createParams(String str, String str2, long j) {
        return Lists.of(new Param.PublisherId(str2), new Param.Timestamp(Long.valueOf(j)), new Param.SdkVersion(), new Param.ConnectionType(this.dataCollector), new Param.SampleRate(100), new Param.ErrorType(str));
    }
}
