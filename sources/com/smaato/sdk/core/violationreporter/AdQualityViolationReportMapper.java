package com.smaato.sdk.core.violationreporter;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.HeaderUtils;
import com.smaato.sdk.core.util.Objects;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class AdQualityViolationReportMapper {
    private final HeaderUtils headerUtils;
    private final Logger logger;

    AdQualityViolationReportMapper(Logger logger, HeaderUtils headerUtils) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.headerUtils = (HeaderUtils) Objects.requireNonNull(headerUtils);
    }

    Report mapToReport(String str, Map<String, List<String>> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<String> list, long j) {
        String strExtractHeaderMultiValue = this.headerUtils.extractHeaderMultiValue(map, "X-SMT-SessionId");
        if (strExtractHeaderMultiValue == null) {
            this.logger.warning(LogDomain.CORE, "header %s is not found in SOMA response", "X-SMT-SessionId");
            strExtractHeaderMultiValue = randomiseSessionIdWhenNull();
        }
        String str11 = strExtractHeaderMultiValue;
        String strExtractHeaderMultiValue2 = this.headerUtils.extractHeaderMultiValue(map, "SCI");
        if (strExtractHeaderMultiValue2 == null) {
            this.logger.warning(LogDomain.CORE, "header %s is not found in SOMA response", "SCI");
        }
        return mapToReport(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list, j, str11, strExtractHeaderMultiValue2);
    }

    public Report mapToReport(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<String> list, long j, String str11, String str12) {
        return Report.builder().setType(str).setSessionId(str11).setOriginalUrl(str7).setViolatedUrl(str6).setTimestamp(String.valueOf(j)).setSci(str12 == null ? "" : str12).setPublisher(str2).setAdSpace(str3).setApiVersion("").setBundleId(str4).setRedirectUrl(str8).setClickUrl(str9).setAdMarkup(str10).setTraceUrls(list).setError("").setPlatform("android").setSdkVersion(str5).setApiKey("").setCreativeId("").setAsnId("0").build();
    }

    private String randomiseSessionIdWhenNull() {
        return "invldssid_" + ((int) ((Math.random() * 90000.0d) + 10000.0d)) + "_" + ((int) ((Math.random() * 90.0d) + 10.0d)) + "_" + ((int) ((Math.random() * 9000.0d) + 1000.0d)) + "_" + ((int) ((Math.random() * 9000.0d) + 1000.0d)) + "_" + ((int) ((Math.random() * 9000000.0d) + 1000000.0d));
    }
}
