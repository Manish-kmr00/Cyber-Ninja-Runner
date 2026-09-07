package com.smaato.sdk.core.errorreport;

import android.net.Uri;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.Call;
import com.smaato.sdk.core.network.Callback;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.util.Objects;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public final class ErrorReporter {
    private final HttpClient httpClient;
    private final Logger logger;
    private final String reportingUrl;

    public ErrorReporter(Logger logger, HttpClient httpClient, String str) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        HttpClient.Builder builderBuildUpon = ((HttpClient) Objects.requireNonNull(httpClient)).buildUpon();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.httpClient = builderBuildUpon.connectTimeout(15000L, timeUnit).readTimeout(15000L, timeUnit).build();
        this.reportingUrl = (String) Objects.requireNonNull(str);
    }

    public void report(Report report) {
        if (report.canBeSent()) {
            send(report.toQuery());
        }
    }

    private void send(Map map) {
        Uri.Builder builderBuildUpon = Uri.parse(this.reportingUrl).buildUpon();
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        this.httpClient.newCall(Request.get(builderBuildUpon.toString())).enqueue(new Callback() { // from class: com.smaato.sdk.core.errorreport.ErrorReporter.1
            @Override // com.smaato.sdk.core.network.Callback
            public void onResponse(Call call, Response response) {
                int iResponseCode = response.responseCode();
                if (iResponseCode >= 200 && iResponseCode < 300) {
                    ErrorReporter.this.logger.debug(LogDomain.UNIFIED_BIDDING, "Error report request has been accepted by server", new Object[0]);
                } else {
                    ErrorReporter.this.logger.error(LogDomain.UNIFIED_BIDDING, "Error report request has not been accepted, response code: %d", Integer.valueOf(iResponseCode));
                }
            }

            @Override // com.smaato.sdk.core.network.Callback
            public void onFailure(Call call, Exception exc) {
                ErrorReporter.this.logger.error(LogDomain.UNIFIED_BIDDING, "Error report request failed: %s", exc);
            }
        });
    }
}
