package com.playon.bridge;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Xml;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.XmlPullParserUtil;
import com.safedk.android.analytics.events.RedirectEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
class AdParser {
    private static final String TAG = Log.makeTag("AdParser");
    private Bundle mAd;

    AdParser() {
    }

    public Bundle parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            this.mAd = new Bundle();
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlPullParserNewPullParser.setInput(inputStream, null);
            xmlPullParserNewPullParser.nextTag();
            String name = xmlPullParserNewPullParser.getName();
            if (!TextUtils.isEmpty(name)) {
                this.mAd.putString("format", name);
            }
            readDaastOrVast(xmlPullParserNewPullParser);
            return this.mAd;
        } finally {
            inputStream.close();
        }
    }

    private void readDaastOrVast(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Ad")) {
                    readAd(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readAd(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Ad");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("InLine")) {
                    readInline(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readAdTitle(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "AdTitle");
        this.mAd.putString("title", XmlPullParserUtil.readText(xmlPullParser));
    }

    private void readImpression(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Impression");
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        String text = XmlPullParserUtil.readText(xmlPullParser);
        if (text == null) {
            return;
        }
        if (attributeValue != null && attributeValue.equals(RedirectEvent.i)) {
            ArrayList<String> stringArrayList = this.mAd.getStringArrayList(Ad.IMPRESSION_INTERNAL_TRACKING_URLS);
            if (stringArrayList == null) {
                stringArrayList = new ArrayList<>();
            }
            stringArrayList.add(text);
            this.mAd.putStringArrayList(Ad.IMPRESSION_INTERNAL_TRACKING_URLS, stringArrayList);
            return;
        }
        ArrayList<String> stringArrayList2 = this.mAd.getStringArrayList(Ad.IMPRESSION_TRACKING_URLS);
        if (stringArrayList2 == null) {
            stringArrayList2 = new ArrayList<>();
        }
        stringArrayList2.add(text);
        this.mAd.putStringArrayList(Ad.IMPRESSION_TRACKING_URLS, stringArrayList2);
    }

    private void readLinear(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Linear");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null) {
                    XmlPullParserUtil.skip(xmlPullParser);
                } else if (name.equals("Duration")) {
                    readDuration(xmlPullParser);
                } else if (name.equals("MediaFiles")) {
                    readMediaFiles(xmlPullParser);
                } else if (name.equals("TrackingEvents")) {
                    this.mAd.putBundle(Ad.MEDIA_TRACKING_EVENTS, readTrackingMediaEvents(xmlPullParser));
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readDuration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Duration");
        this.mAd.putString("duration", XmlPullParserUtil.readText(xmlPullParser));
    }

    private void readMediaFiles(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "MediaFiles");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("MediaFile") && this.mAd.getString("url") == null) {
                    readMediaFile(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readMediaFile(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "MediaFile");
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        if (!attributeValue.startsWith("audio")) {
            Log.w(TAG, "Unsupported MIME type: " + attributeValue);
            XmlPullParserUtil.skip(xmlPullParser);
        } else {
            String text = XmlPullParserUtil.readText(xmlPullParser);
            this.mAd.putString(Ad.MIME_TYPE, attributeValue);
            this.mAd.putString("url", text);
        }
    }

    private void readInline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "InLine");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null) {
                    XmlPullParserUtil.skip(xmlPullParser);
                } else if (name.equals("AdTitle")) {
                    readAdTitle(xmlPullParser);
                } else if (name.equals("Impression")) {
                    readImpression(xmlPullParser);
                } else if (name.equals("Creatives")) {
                    readCreatives(xmlPullParser);
                } else if (name.equals(k.l)) {
                    readPricing(xmlPullParser);
                } else if (name.equals("Extensions")) {
                    readExtensions(xmlPullParser);
                } else if (name.equals("AdVerifications")) {
                    readVerifications(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readExtensions(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Extensions");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("Extension")) {
                    readExtension(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readExtension(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Extension");
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (attributeValue.equals("TrackingEventPayload")) {
                    this.mAd.putString(Ad.TRACKINGEVENTPAYLOAD, readCDATAString(xmlPullParser));
                } else if (attributeValue.equals("TrackingEventAPI")) {
                    this.mAd.putString(Ad.TRACKINGEVENTURL, readCDATAString(xmlPullParser));
                } else if (attributeValue.equals("S2SRewardGrantedCallback")) {
                    this.mAd.putString(Ad.REWARD_GRANTED_CALLBACK_URL, readCDATAString(xmlPullParser));
                } else if (attributeValue.equals("S2SRewardRejectedCallback")) {
                    this.mAd.putString(Ad.REWARD_REJECTED_CALLBACK_URL, readCDATAString(xmlPullParser));
                }
            }
        }
    }

    private String readCDATAString(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "CDATAString");
        return XmlPullParserUtil.readText(xmlPullParser);
    }

    private void readPricing(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, k.l);
        String attributeValue = xmlPullParser.getAttributeValue(null, "model");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "currency");
        double d = XmlPullParserUtil.readDouble(xmlPullParser, 0.0d);
        Bundle bundle = new Bundle();
        bundle.putDouble(Ad.PRICINGVALUE, d);
        bundle.putString(Ad.PRICINGMODEL, attributeValue);
        bundle.putString(Ad.PRICINGCURRENCY, attributeValue2);
        this.mAd.putParcelable("price", bundle);
    }

    private void readCreatives(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Creatives");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Creative")) {
                    readCreative(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private void readVerifications(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "AdVerifications");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Verification")) {
                    arrayList.add(readVerification(xmlPullParser));
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        this.mAd.putParcelableArrayList(Ad.ADVERIFICATIONS, arrayList);
    }

    private Bundle readVerification(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Verification");
        String attributeValue = xmlPullParser.getAttributeValue(null, "vendor");
        String text = "";
        String text2 = "";
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null) {
                    XmlPullParserUtil.skip(xmlPullParser);
                } else if (name.equals("JavaScriptResource")) {
                    text = XmlPullParserUtil.readText(xmlPullParser);
                } else if (name.equals("VerificationParameters")) {
                    text2 = XmlPullParserUtil.readText(xmlPullParser);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("vendor", attributeValue);
        bundle.putString(Ad.VERIFICATIONRESOURCE, text);
        bundle.putString(Ad.VERIFICATIONPARAM, text2);
        return bundle;
    }

    private void readCreative(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Creative");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null) {
                    XmlPullParserUtil.skip(xmlPullParser);
                } else if (name.equals("Linear")) {
                    readLinear(xmlPullParser);
                } else if (name.equals("CompanionAds")) {
                    ArrayList<Bundle> companionAds = readCompanionAds(xmlPullParser);
                    if (companionAds != null) {
                        this.mAd.putParcelableArrayList(Ad.COMPANION, companionAds);
                    }
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
    }

    private ArrayList<Bundle> readCompanionAds(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList<Bundle> arrayList = null;
        xmlPullParser.require(2, null, "CompanionAds");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Companion")) {
                    Bundle companion = readCompanion(xmlPullParser);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(companion);
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private Bundle readCompanion(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Companion");
        Bundle bundle = new Bundle();
        int intAttribute = getIntAttribute(xmlPullParser, "width");
        int intAttribute2 = getIntAttribute(xmlPullParser, "height");
        boolean booleanAttribute = getBooleanAttribute(xmlPullParser, "isDefault");
        bundle.putInt("width", intAttribute);
        bundle.putInt("height", intAttribute2);
        bundle.putBoolean(Ad.SOUND_VISUALISER_ENABLED, booleanAttribute);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("IFrameResource")) {
                    String text = XmlPullParserUtil.readText(xmlPullParser);
                    if (text != null) {
                        bundle.putString("url", text.replace("fmt=iframe", "fmt=htmlpage"));
                    }
                } else if (name != null && name.equals("HTMLResource")) {
                    String text2 = XmlPullParserUtil.readText(xmlPullParser);
                    if (text2 != null) {
                        bundle.putString("html", text2);
                    }
                } else if (name != null && name.equals("StaticResource")) {
                    String text3 = XmlPullParserUtil.readText(xmlPullParser);
                    if (text3 != null) {
                        bundle.putString("url", text3);
                    }
                } else if (name != null && name.equals("CompanionClickThrough")) {
                    String text4 = XmlPullParserUtil.readText(xmlPullParser);
                    if (text4 != null) {
                        bundle.putString(Ad.COMPANION_CLICK_THROUGH_EVENT, text4);
                    }
                } else if (name != null && name.equals("CompanionClickTracking")) {
                    String text5 = XmlPullParserUtil.readText(xmlPullParser);
                    if (text5 != null) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList(Ad.COMPANION_CLICK_TRACKING_EVENT);
                        if (stringArrayList == null) {
                            stringArrayList = new ArrayList<>();
                        }
                        stringArrayList.add(text5);
                        bundle.putStringArrayList(Ad.COMPANION_CLICK_TRACKING_EVENT, stringArrayList);
                    }
                } else if (name != null && name.equals("TrackingEvents")) {
                    bundle.putStringArrayList(Ad.COMPANION_TRACKING_EVENTS, readTrackingCompanionEvents(xmlPullParser));
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        return bundle;
    }

    private ArrayList<String> readTrackingCompanionEvents(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "TrackingEvents");
        ArrayList<String> arrayList = new ArrayList<>();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Tracking")) {
                    String text = XmlPullParserUtil.readText(xmlPullParser);
                    if (text != null) {
                        arrayList.add(text);
                    }
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private Bundle readTrackingMediaEvents(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Log.d(TAG, "XML " + xmlPullParser.toString());
        xmlPullParser.require(2, null, "TrackingEvents");
        Bundle bundle = new Bundle();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals("Tracking")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "event");
                    String text = XmlPullParserUtil.readText(xmlPullParser);
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(attributeValue);
                    if (stringArrayList == null) {
                        stringArrayList = new ArrayList<>();
                    }
                    stringArrayList.add(text);
                    if (text != null) {
                        bundle.putStringArrayList(attributeValue, stringArrayList);
                    }
                } else {
                    XmlPullParserUtil.skip(xmlPullParser);
                }
            }
        }
        return bundle;
    }

    private static int getIntAttribute(XmlPullParser xmlPullParser, String str) {
        try {
            return Integer.parseInt(xmlPullParser.getAttributeValue(null, str));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str) {
        try {
            return Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
