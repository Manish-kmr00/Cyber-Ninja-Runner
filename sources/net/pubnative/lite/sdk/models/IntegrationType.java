package net.pubnative.lite.sdk.models;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: loaded from: classes13.dex */
public enum IntegrationType {
    HEADER_BIDDING(CampaignEx.JSON_KEY_HB),
    IN_APP_BIDDING(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B),
    MEDIATION("m"),
    STANDALONE("s");

    private final String code;

    IntegrationType(String str) {
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }
}
