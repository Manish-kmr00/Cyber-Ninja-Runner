package sg.bigo.ads.core.f.a;

import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;

/* JADX INFO: loaded from: classes13.dex */
public enum f {
    XML_PARSING_ERROR(StatisticData.ERROR_CODE_NOT_FOUND),
    WRAPPER_TIMEOUT("301"),
    NO_ADS_VAST_RESPONSE("303"),
    GENERAL_LINEAR_AD_ERROR("400"),
    GENERAL_COMPANION_AD_ERROR("600"),
    UNDEFINED_ERROR("900");

    public final String g;

    f(String str) {
        this.g = str;
    }
}
