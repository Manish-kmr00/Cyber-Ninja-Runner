package com.bykv.vk.openvk.preload.falconx.statistic;

import android.os.SystemClock;
import com.bykv.vk.openvk.preload.a.a.b;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.playon.bridge.Ad;

/* JADX INFO: loaded from: classes13.dex */
public class InterceptorModel {

    @b(a = CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)
    public String ac;

    @b(a = "access_key")
    public String accessKey;

    @b(a = "channel")
    public String channel;

    @b(a = "err_code")
    public String errCode;

    @b(a = "err_msg")
    public String errMsg;

    @b(a = "log_id")
    public String logId;

    @b(a = Ad.MIME_TYPE)
    public String mimeType;

    @b(a = "offline_duration")
    public Long offlineDuration;

    @b(a = "offline_rule")
    public String offlineRule;

    @b(a = "offline_status")
    public Integer offlineStatus;

    @b(a = "online_duration")
    public Long onlineDuration;

    @b(a = "page_url")
    public String pageUrl;

    @b(a = "pkg_version")
    public Long pkgVersion;

    @b(a = "res_root_dir")
    public String resRootDir;
    public Long startTime = Long.valueOf(SystemClock.uptimeMillis());

    @b(a = DownloadModel.RESOURCE_URL)
    public String url;

    public void setErrorCode(String str) {
        this.errCode = str;
    }

    public void setErrorMsg(String str) {
        this.errMsg = str;
    }

    public void loadFinish(boolean z) {
        if (z) {
            this.offlineDuration = Long.valueOf(SystemClock.uptimeMillis() - this.startTime.longValue());
            this.offlineStatus = 1;
        } else {
            this.offlineStatus = 0;
        }
    }
}
