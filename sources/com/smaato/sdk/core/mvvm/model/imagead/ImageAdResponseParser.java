package com.smaato.sdk.core.mvvm.model.imagead;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.Jsons;
import com.smaato.sdk.core.util.Objects;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ImageAdResponseParser extends AdResponseParser {
    private final Logger logger;

    public ImageAdResponseParser(HeaderValueUtils headerValueUtils, Logger logger) {
        super(AdType.IMAGE, headerValueUtils);
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger cannot be null for ImageAdResponseParser::new");
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponseParser
    protected AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("image");
            builder.setImpressionTrackingUrls(Jsons.toStringList(jSONObject.getJSONArray("impressiontrackers")));
            builder.setClickTrackingUrls(Jsons.toStringList(jSONObject.getJSONArray(POBNativeConstants.NATIVE_CLICK_TRACKER)));
            if (!jSONObject.isNull("ext")) {
                builder.setExtensions(Extension.getExtensionList(jSONObject.getJSONObject("ext").getJSONArray("smaatoexts")));
            } else {
                this.logger.info(LogDomain.CORE, "Missing ext key in Json response", new Object[0]);
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("img");
            String string = jSONObject2.getString("url");
            String string2 = jSONObject2.getString("w");
            String string3 = jSONObject2.getString("h");
            builder.setImageUrl(string).setWidth(Integer.valueOf(Integer.parseInt(string2))).setHeight(Integer.valueOf(Integer.parseInt(string3))).setClickUrl(jSONObject2.getString("ctaurl"));
            return builder.build();
        } catch (NumberFormatException e) {
            e = e;
            String str2 = String.format("Invalid markup: %s", str);
            this.logger.error(LogDomain.AD, e, str2, new Object[0]);
            throw new AdResponseParser.ParsingException(str2, e);
        } catch (JSONException e2) {
            e = e2;
            String str3 = String.format("Invalid markup: %s", str);
            this.logger.error(LogDomain.AD, e, str3, new Object[0]);
            throw new AdResponseParser.ParsingException(str3, e);
        } catch (Exception e3) {
            this.logger.error(LogDomain.AD, e3, "Cannot build AdResponse due to validation error", new Object[0]);
            throw new AdResponseParser.ParsingException("Cannot build AdResponse due to validation error", e3);
        }
    }

    protected static class ResponseFields {
        static final String CLICK_TRACKERS_KEY = "clicktrackers";
        static final String EXT_KEY = "ext";
        static final String IMG_CALL_TO_ACTION_KEY = "ctaurl";
        static final String IMG_HEIGHT_KEY = "h";
        static final String IMG_KEY = "img";
        static final String IMG_URL_KEY = "url";
        static final String IMG_WIDTH_KEY = "w";
        static final String IMPRESSION_TRACKERS_KEY = "impressiontrackers";
        static final String ROOT_KEY = "image";
        static final String SMAATO_EXT_KEY = "smaatoexts";

        protected ResponseFields() {
        }
    }
}
