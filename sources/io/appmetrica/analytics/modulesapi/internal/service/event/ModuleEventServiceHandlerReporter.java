package io.appmetrica.analytics.modulesapi.internal.service.event;

import com.safedk.android.analytics.events.CrashEvent;
import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/event/ModuleEventServiceHandlerReporter;", "", CrashEvent.e, "", "Lio/appmetrica/analytics/coreapi/internal/event/CounterReportApi;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ModuleEventServiceHandlerReporter {
    void report(CounterReportApi report);
}
