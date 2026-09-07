package net.pubnative.lite.sdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.AuthenticationTokenClaims;
import com.json.cc;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.UByte$$ExternalSyntheticBackport0;
import net.pubnative.lite.sdk.models.PNAdRequest;
import net.pubnative.lite.sdk.models.Topic;
import net.pubnative.lite.sdk.models.bidstream.BidParam;
import net.pubnative.lite.sdk.models.bidstream.Signal;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes9.dex */
public final class PNApiUrlComposer {
    public static String getUrlQuery(String str, PNAdRequest pNAdRequest) {
        return buildUri(str, pNAdRequest).getQuery();
    }

    public static String buildUrl(String str, PNAdRequest pNAdRequest) {
        return buildUri(str, pNAdRequest).toString();
    }

    private static Uri buildUri(String str, PNAdRequest pNAdRequest) {
        String strValueOf;
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendPath("api");
        builderBuildUpon.appendPath("v3");
        builderBuildUpon.appendPath("native");
        if (!TextUtils.isEmpty(pNAdRequest.appToken)) {
            builderBuildUpon.appendQueryParameter("apptoken", pNAdRequest.appToken);
        }
        if (!TextUtils.isEmpty(pNAdRequest.os)) {
            builderBuildUpon.appendQueryParameter("os", pNAdRequest.os);
        }
        if (!TextUtils.isEmpty(pNAdRequest.osver)) {
            builderBuildUpon.appendQueryParameter("osver", pNAdRequest.osver);
        }
        if (!TextUtils.isEmpty(pNAdRequest.devicemodel)) {
            builderBuildUpon.appendQueryParameter(cc.n, pNAdRequest.devicemodel);
        }
        if (!TextUtils.isEmpty(pNAdRequest.make)) {
            builderBuildUpon.appendQueryParameter("make", pNAdRequest.make);
        }
        if (!TextUtils.isEmpty(pNAdRequest.deviceHeight)) {
            builderBuildUpon.appendQueryParameter("dh", pNAdRequest.deviceHeight);
        }
        if (!TextUtils.isEmpty(pNAdRequest.deviceWidth)) {
            builderBuildUpon.appendQueryParameter("dw", pNAdRequest.deviceWidth);
        }
        if (!TextUtils.isEmpty(pNAdRequest.orientation)) {
            builderBuildUpon.appendQueryParameter("scro", pNAdRequest.orientation);
        }
        if (!TextUtils.isEmpty(pNAdRequest.ppi)) {
            builderBuildUpon.appendQueryParameter("ppi", pNAdRequest.ppi);
        }
        if (!TextUtils.isEmpty(pNAdRequest.pxratio)) {
            builderBuildUpon.appendQueryParameter("pxratio", pNAdRequest.pxratio);
        }
        if (!TextUtils.isEmpty(pNAdRequest.js)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_JS, pNAdRequest.js);
        }
        if (!TextUtils.isEmpty(pNAdRequest.soundSetting)) {
            builderBuildUpon.appendQueryParameter(AuthenticationTokenClaims.JSON_KEY_AUD, pNAdRequest.soundSetting);
        }
        if (!TextUtils.isEmpty(pNAdRequest.dnt)) {
            builderBuildUpon.appendQueryParameter("dnt", pNAdRequest.dnt);
        }
        if (!TextUtils.isEmpty(pNAdRequest.al)) {
            builderBuildUpon.appendQueryParameter(CampaignEx.JSON_KEY_AD_AL, pNAdRequest.al);
        }
        if (!TextUtils.isEmpty(pNAdRequest.width)) {
            builderBuildUpon.appendQueryParameter("w", pNAdRequest.width);
        }
        if (!TextUtils.isEmpty(pNAdRequest.height)) {
            builderBuildUpon.appendQueryParameter("h", pNAdRequest.height);
        }
        if (!TextUtils.isEmpty(pNAdRequest.mf)) {
            builderBuildUpon.appendQueryParameter("mf", pNAdRequest.mf);
        }
        if (!TextUtils.isEmpty(pNAdRequest.af)) {
            builderBuildUpon.appendQueryParameter(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, pNAdRequest.af);
        }
        if (!TextUtils.isEmpty(pNAdRequest.zoneId)) {
            builderBuildUpon.appendQueryParameter("zoneid", pNAdRequest.zoneId);
        }
        if (!TextUtils.isEmpty(pNAdRequest.testMode)) {
            builderBuildUpon.appendQueryParameter(POBConstants.TEST_MODE, pNAdRequest.testMode);
        }
        if (!TextUtils.isEmpty(pNAdRequest.locale)) {
            builderBuildUpon.appendQueryParameter(CommonUrlParts.LOCALE, pNAdRequest.locale);
        }
        if (!TextUtils.isEmpty(pNAdRequest.language)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_LANGUAGE, pNAdRequest.language);
        }
        if (!TextUtils.isEmpty(pNAdRequest.langb)) {
            builderBuildUpon.appendQueryParameter("langb", pNAdRequest.langb);
        }
        if (!TextUtils.isEmpty(pNAdRequest.latitude)) {
            builderBuildUpon.appendQueryParameter("lat", pNAdRequest.latitude);
        }
        if (!TextUtils.isEmpty(pNAdRequest.longitude)) {
            builderBuildUpon.appendQueryParameter(Constants.LONG, pNAdRequest.longitude);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gender)) {
            builderBuildUpon.appendQueryParameter("gender", pNAdRequest.gender);
        }
        if (!TextUtils.isEmpty(pNAdRequest.age)) {
            builderBuildUpon.appendQueryParameter("age", pNAdRequest.age);
        }
        if (!TextUtils.isEmpty(pNAdRequest.bundleid)) {
            builderBuildUpon.appendQueryParameter("bundleid", pNAdRequest.bundleid);
        }
        if (!TextUtils.isEmpty(pNAdRequest.keywords)) {
            builderBuildUpon.appendQueryParameter("keywords", pNAdRequest.keywords);
        }
        if (!TextUtils.isEmpty(pNAdRequest.coppa)) {
            builderBuildUpon.appendQueryParameter("coppa", pNAdRequest.coppa);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gid)) {
            builderBuildUpon.appendQueryParameter("gid", pNAdRequest.gid);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gidmd5)) {
            builderBuildUpon.appendQueryParameter("gidmd5", pNAdRequest.gidmd5);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gidsha1)) {
            builderBuildUpon.appendQueryParameter("gidsha1", pNAdRequest.gidsha1);
        }
        if (!TextUtils.isEmpty(pNAdRequest.displaymanager)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_DISPLAY_MANAGER, pNAdRequest.displaymanager);
        }
        if (!TextUtils.isEmpty(pNAdRequest.displaymanagerver)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_DISPLAY_MANAGER_VERSION, pNAdRequest.displaymanagerver);
        }
        if (!TextUtils.isEmpty(pNAdRequest.omidpn)) {
            builderBuildUpon.appendQueryParameter("omidpn", pNAdRequest.omidpn);
        }
        if (!TextUtils.isEmpty(pNAdRequest.omidpv)) {
            builderBuildUpon.appendQueryParameter("omidpv", pNAdRequest.omidpv);
        }
        if (!TextUtils.isEmpty(pNAdRequest.rv)) {
            builderBuildUpon.appendQueryParameter("rv", pNAdRequest.rv);
        }
        if (!TextUtils.isEmpty(pNAdRequest.usprivacy)) {
            builderBuildUpon.appendQueryParameter("usprivacy", pNAdRequest.usprivacy);
        }
        if (!TextUtils.isEmpty(pNAdRequest.userconsent)) {
            builderBuildUpon.appendQueryParameter("userconsent", pNAdRequest.userconsent);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gppstring)) {
            builderBuildUpon.appendQueryParameter("gpp", pNAdRequest.gppstring);
        }
        if (!TextUtils.isEmpty(pNAdRequest.gppsid)) {
            builderBuildUpon.appendQueryParameter("gppsid", pNAdRequest.gppsid);
        }
        if (!TextUtils.isEmpty(pNAdRequest.carrier)) {
            builderBuildUpon.appendQueryParameter("carrier", pNAdRequest.carrier);
        }
        if (!TextUtils.isEmpty(pNAdRequest.connectiontype)) {
            builderBuildUpon.appendQueryParameter("connectiontype", pNAdRequest.connectiontype);
        }
        if (!TextUtils.isEmpty(pNAdRequest.mccmnc)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_MCCMNC, pNAdRequest.mccmnc);
        }
        if (!TextUtils.isEmpty(pNAdRequest.mccmncsim)) {
            builderBuildUpon.appendQueryParameter("mccmncsim", pNAdRequest.mccmncsim);
        }
        if (!TextUtils.isEmpty(pNAdRequest.geofetch)) {
            builderBuildUpon.appendQueryParameter("geofetch", pNAdRequest.geofetch);
        }
        if (!TextUtils.isEmpty(pNAdRequest.sua)) {
            builderBuildUpon.appendQueryParameter("sua", pNAdRequest.sua);
        }
        if (!TextUtils.isEmpty(pNAdRequest.ae)) {
            builderBuildUpon.appendQueryParameter(ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT, pNAdRequest.ae);
        }
        if (!TextUtils.isEmpty(pNAdRequest.protocol)) {
            builderBuildUpon.appendQueryParameter("protocol", pNAdRequest.protocol);
        }
        if (!TextUtils.isEmpty(pNAdRequest.api)) {
            builderBuildUpon.appendQueryParameter("api", pNAdRequest.api);
        }
        if (!TextUtils.isEmpty(pNAdRequest.impdepth)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_IMP_DEPTH, pNAdRequest.impdepth);
        }
        if (!TextUtils.isEmpty(pNAdRequest.ageofapp)) {
            builderBuildUpon.appendQueryParameter("ageofapp", pNAdRequest.ageofapp);
        }
        if (!TextUtils.isEmpty(pNAdRequest.sessionduration)) {
            builderBuildUpon.appendQueryParameter(POBConstants.KEY_SESSION_DURATION, pNAdRequest.sessionduration);
        }
        String strConcat = "";
        if (!pNAdRequest.getSignals().isEmpty()) {
            for (Signal signal : pNAdRequest.getSignals()) {
                for (Field field : signal.getClass().getDeclaredFields()) {
                    BidParam bidParam = (BidParam) field.getAnnotation(BidParam.class);
                    if (bidParam != null) {
                        try {
                            if (Iterable.class.isAssignableFrom(field.getType())) {
                                String strValueOf2 = String.valueOf(field.get(signal));
                                strValueOf = strValueOf2.substring(1, strValueOf2.length() - 1).replaceAll("\\s+", "");
                            } else {
                                strValueOf = String.valueOf(field.get(signal));
                            }
                            if (!TextUtils.isEmpty(strValueOf) && !strValueOf.equals("null") && !TextUtils.isEmpty(bidParam.name())) {
                                builderBuildUpon.appendQueryParameter(bidParam.name(), strValueOf);
                            }
                        } catch (IllegalAccessException unused) {
                        }
                    }
                }
            }
        }
        if (pNAdRequest.topics != null && !pNAdRequest.topics.isEmpty()) {
            HashMap map = new HashMap();
            for (Topic topic : pNAdRequest.topics) {
                String strConcat2 = String.valueOf(topic.getTaxonomyVersion()).concat(StringUtils.COMMA).concat(topic.getTaxonomyVersionName().replaceAll("\\s", Marker.ANY_NON_NULL_MARKER));
                if (!map.containsKey(strConcat2)) {
                    map.put(strConcat2, new ArrayList());
                }
                ((ArrayList) Objects.requireNonNull((ArrayList) map.get(strConcat2))).add(String.valueOf(topic.getId()));
            }
            for (Map.Entry entry : map.entrySet()) {
                strConcat = strConcat.concat((String) entry.getKey()).concat(StringUtils.COMMA).concat(UByte$$ExternalSyntheticBackport0.m(StringUtils.COMMA, (ArrayList) entry.getValue())).concat("_");
            }
            builderBuildUpon.appendQueryParameter("psut", strConcat.substring(0, strConcat.length() - 1));
        }
        return builderBuildUpon.build();
    }
}
