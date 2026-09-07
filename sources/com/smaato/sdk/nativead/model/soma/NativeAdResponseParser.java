package com.smaato.sdk.nativead.model.soma;

import android.net.Uri;
import android.util.JsonReader;
import android.util.JsonToken;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdLink;
import com.smaato.sdk.nativead.NativeAdTracker;
import com.smaato.sdk.nativead.model.NativeAdComponents;
import com.smaato.sdk.richmedia.util.HtmlPlayerUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class NativeAdResponseParser extends AdResponseParser {
    private final HtmlPlayerUtils htmlPlayerUtils;
    private String mRaidContent;
    private static final NativeAdTracker.Type[] E_TYPES = {null, NativeAdTracker.Type.IMPRESSION, NativeAdTracker.Type.VIEWABLE_MRC_50, NativeAdTracker.Type.VIEWABLE_MRC_100, NativeAdTracker.Type.VIEWABLE_VIDEO_50};
    private static final NativeAdLink EMPTY_LINK = NativeAdLink.create("", Collections.emptyList());

    public NativeAdResponseParser(HeaderValueUtils headerValueUtils, HtmlPlayerUtils htmlPlayerUtils) {
        super(AdType.NATIVE, headerValueUtils);
        this.mRaidContent = "";
        this.htmlPlayerUtils = htmlPlayerUtils;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponseParser
    protected AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException {
        NativeAdComponents nativeAdComponents = getNativeAdComponents(str);
        if (nativeAdComponents != null) {
            nativeAdComponents = wrapVastInMraid(nativeAdComponents);
        }
        return builder.setNativeObject(nativeAdComponents).setWidth(0).setHeight(0).setImpressionTrackingUrls(new ArrayList()).setClickTrackingUrls(new ArrayList()).build();
    }

    private NativeAdComponents getNativeAdComponents(String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("native".equals(jsonReader.nextName())) {
                NativeAdComponents.Builder builderLink = NativeAdComponents.builder().trackers(Collections.emptyList()).link(EMPTY_LINK);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.peek() == JsonToken.NAME) {
                        String strNextName = jsonReader.nextName();
                        strNextName.hashCode();
                        strNextName.hashCode();
                        switch (strNextName) {
                            case "assets":
                                builderLink.assets(readAssets(jsonReader));
                                break;
                            case "eventtrackers":
                                builderLink.trackers(readEventTrackers(jsonReader));
                                break;
                            case "privacy":
                                builderLink.privacyUrl(jsonReader.nextString());
                                break;
                            case "link":
                                builderLink.link(readLink(jsonReader));
                                break;
                            case "imptrackers":
                                builderLink.trackers(readImpTrackers(jsonReader));
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                return builderLink.build();
            }
            jsonReader.skipValue();
        }
        if (jsonReader.peek() != JsonToken.END_OBJECT) {
            return null;
        }
        jsonReader.endObject();
        return null;
    }

    private NativeAdLink readLink(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("url".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if (POBNativeConstants.NATIVE_CLICK_TRACKER.equals(strNextName)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(jsonReader.nextString());
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return NativeAdLink.create(strNextString, arrayList);
    }

    private NativeAdAssets readAssets(JsonReader jsonReader) throws IOException {
        NativeAdAssets.Builder builder = NativeAdAssets.builder();
        ArrayList arrayList = new ArrayList(3);
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.NAME) {
                    String strNextName = jsonReader.nextName();
                    strNextName.hashCode();
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "ext":
                            readMRAID(builder, jsonReader);
                            break;
                        case "img":
                            if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                                readImage(builder, jsonReader, arrayList);
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                            break;
                        case "data":
                            readData(builder, jsonReader);
                            break;
                        case "title":
                            readTitle(builder, jsonReader);
                            break;
                        case "video":
                            readVastTag(builder, jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        }
        builder.images(Collections.unmodifiableList(arrayList));
        if (jsonReader.peek() == JsonToken.END_OBJECT) {
            jsonReader.endObject();
        }
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        return builder.build();
    }

    private void readTitle(NativeAdAssets.Builder builder, JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("text".equals(jsonReader.nextName())) {
                builder.title(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private void readMRAID(NativeAdAssets.Builder builder, JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        if ("adm".equals(jsonReader.nextName())) {
            this.mRaidContent = jsonReader.nextString();
        }
        builder.mraidJs(this.mRaidContent);
    }

    private void readVastTag(NativeAdAssets.Builder builder, JsonReader jsonReader) throws IOException {
        String strNextString;
        jsonReader.beginObject();
        if (!"vasttag".equals(jsonReader.nextName())) {
            strNextString = "";
        } else {
            strNextString = jsonReader.nextString();
        }
        builder.vastTag(strNextString);
    }

    private List readImpTrackers(JsonReader jsonReader) throws IOException {
        String strNextString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            if (jsonReader.peek() != JsonToken.NULL) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
                strNextString = null;
            }
            NativeAdTracker.Type[] typeArr = E_TYPES;
            if (1 < typeArr.length) {
                arrayList.add(strNextString);
                arrayList2.add(NativeAdTracker.create(typeArr[1], strNextString));
            }
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList2);
    }

    private void readImage(NativeAdAssets.Builder builder, JsonReader jsonReader, List list) throws IOException {
        jsonReader.beginObject();
        Uri uri = null;
        int iNextInt = 0;
        int iNextInt2 = -1;
        int iNextInt3 = -1;
        while (true) {
            if (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                strNextName.hashCode();
                switch (strNextName) {
                    case "h":
                        iNextInt3 = jsonReader.nextInt();
                        break;
                    case "w":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "url":
                        uri = Uri.parse(jsonReader.nextString());
                        break;
                    case "type":
                        iNextInt = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (1 == iNextInt) {
                    builder.icon(NativeAdAssets.Image.create(uri, iNextInt2, iNextInt3));
                    return;
                } else {
                    if (3 == iNextInt) {
                        list.add(NativeAdAssets.Image.create(uri, iNextInt2, iNextInt3));
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void readData(NativeAdAssets.Builder builder, JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int iNextInt = 0;
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("type")) {
                iNextInt = jsonReader.nextInt();
            } else if (strNextName.equals("value")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (strNextString == null) {
            return;
        }
        if (iNextInt == 1) {
            builder.sponsored(strNextString);
            return;
        }
        if (iNextInt == 2) {
            builder.text(strNextString);
        } else if (iNextInt == 3) {
            builder.rating(Double.valueOf(Double.parseDouble(strNextString)));
        } else {
            if (iNextInt != 12) {
                return;
            }
            builder.cta(strNextString);
        }
    }

    private List readEventTrackers(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int iNextInt = 1;
            String strNextString = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("url")) {
                    strNextString = jsonReader.nextString();
                } else if (strNextName.equals("event")) {
                    iNextInt = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (iNextInt > 0) {
                NativeAdTracker.Type[] typeArr = E_TYPES;
                if (iNextInt < typeArr.length) {
                    arrayList.add(NativeAdTracker.create(typeArr[iNextInt], strNextString));
                }
            }
            if (iNextInt == 555) {
                arrayList.add(NativeAdTracker.create(NativeAdTracker.Type.OPEN_MEASUREMENT, strNextString));
            }
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    private NativeAdComponents wrapVastInMraid(NativeAdComponents nativeAdComponents) {
        String strVastTag = nativeAdComponents.assets().vastTag();
        if (nativeAdComponents.assets().vastTag() == null) {
            return nativeAdComponents;
        }
        return nativeAdComponents.buildUpon().mraidWrappedVast(this.htmlPlayerUtils.vastToRichMedia(strVastTag)).build();
    }
}
