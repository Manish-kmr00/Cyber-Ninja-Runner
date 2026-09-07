package com.smaato.sdk.core.csm;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class CsmAdResponseParser {
    private final Logger logger;

    private static class ResponseFields {
        static final String AD_UNIT_ID = "adunitid";
        static final String CLASS_NAME = "classname";
        static final String CLICK_URL = "clickurl";
        static final String CUSTOM_DATA = "customdata";
        static final String HEIGHT = "height";
        static final String IMPRESSION = "impression";
        static final String NAME = "name";
        static final String NETWORKS = "networks";
        static final String PASSBACK = "passback";
        static final String PRIORITY = "priority";
        static final String SESSION_ID = "sessionid";
        static final String WIDTH = "width";
    }

    public CsmAdResponseParser(Logger logger) {
        this.logger = (Logger) Objects.requireNonNull(logger);
    }

    public CsmAdResponse parseResponse(String str) throws ParsingException {
        CsmAdResponse.Builder builder = CsmAdResponse.builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List<Network> networks = parseNetworks(jSONObject.getJSONArray("networks"));
            String string = jSONObject.getString("sessionid");
            builder.setNetworks(networks).setSessionId(string).setPassback(jSONObject.getString("passback"));
            return builder.build();
        } catch (NumberFormatException e) {
            e = e;
            String str2 = String.format("Invalid JSON content: %s", str);
            this.logger.error(LogDomain.AD, e, str2, new Object[0]);
            throw new ParsingException(str2, e);
        } catch (JSONException e2) {
            e = e2;
            String str3 = String.format("Invalid JSON content: %s", str);
            this.logger.error(LogDomain.AD, e, str3, new Object[0]);
            throw new ParsingException(str3, e);
        } catch (Exception e3) {
            this.logger.error(LogDomain.AD, e3, "Cannot build CsmAdResponse due to validation error", new Object[0]);
            throw new ParsingException("Cannot build CsmAdResponse due to validation error", e3);
        }
    }

    private List parseNetworks(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("name");
            int i2 = jSONObject.getInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            int i3 = jSONObject.getInt("width");
            int i4 = jSONObject.getInt("height");
            String string2 = jSONObject.getString("impression");
            String string3 = jSONObject.getString("clickurl");
            String strOptString = jSONObject.optString("adunitid");
            String strOptString2 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY);
            arrayList.add(Network.builder().setName(string).setPriority(i2).setWidth(i3).setHeight(i4).setImpression(string2).setClickUrl(string3).setAdUnitId(strOptString).setClassName(strOptString2).setCustomData(jSONObject.optString("customdata")).build());
        }
        return arrayList;
    }

    public static class ParsingException extends Exception {
        public ParsingException(String str, Throwable th) {
            super(str, th);
        }
    }
}
