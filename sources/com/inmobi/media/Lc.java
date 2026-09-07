package com.inmobi.media;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.inmobi.commons.core.configs.AdConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class Lc {
    public static final HashMap f = MapsKt.hashMapOf(TuplesKt.to("Error", "error"), TuplesKt.to("Impression", "Impression"), TuplesKt.to("ClickTracking", "click"), TuplesKt.to(EventConstants.CREATIVE_VIEW, EventConstants.CREATIVE_VIEW), TuplesKt.to("start", "start"), TuplesKt.to(EventConstants.FIRST_QUARTILE, EventConstants.FIRST_QUARTILE), TuplesKt.to("midpoint", "midpoint"), TuplesKt.to(EventConstants.THIRD_QUARTILE, EventConstants.THIRD_QUARTILE), TuplesKt.to("complete", "complete"), TuplesKt.to("mute", "mute"), TuplesKt.to("unmute", "unmute"), TuplesKt.to("pause", "pause"), TuplesKt.to("resume", "resume"), TuplesKt.to("fullscreen", "fullscreen"), TuplesKt.to("exitFullscreen", "exitFullscreen"), TuplesKt.to("closeEndCard", "closeEndCard"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdConfig.VastVideoConfig f3129a;
    public final L4 b;
    public final Qc c;
    public boolean d;
    public int e;

    public Lc(AdConfig.VastVideoConfig mVastVideoConfig, L4 l4) {
        Intrinsics.checkNotNullParameter(mVastVideoConfig, "mVastVideoConfig");
        this.f3129a = mVastVideoConfig;
        this.b = l4;
        this.c = new Qc(CollectionsKt.emptyList(), mVastVideoConfig);
    }

    public static boolean b(int i) {
        return i == 3;
    }

    public final Qc a(String str) {
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).c("Lc", P5.a("Lc", "TAG", "vastXML = ", str));
        }
        try {
            if (TextUtils.isEmpty(str)) {
                c(303);
                return this.c;
            }
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            String[] strArr = {"Wrapper", "InLine"};
            Intrinsics.checkNotNull(xmlPullParserNewPullParser);
            a(xmlPullParserNewPullParser, "VAST");
            if (Intrinsics.areEqual("VAST", xmlPullParserNewPullParser.getName())) {
                a(xmlPullParserNewPullParser, "Ad");
                if (Intrinsics.areEqual("Ad", xmlPullParserNewPullParser.getName())) {
                    a(xmlPullParserNewPullParser, strArr);
                    if (Intrinsics.areEqual("InLine", xmlPullParserNewPullParser.getName())) {
                        c(xmlPullParserNewPullParser);
                    } else if (Intrinsics.areEqual("Wrapper", xmlPullParserNewPullParser.getName())) {
                        f(xmlPullParserNewPullParser);
                    } else {
                        L4 l5 = this.b;
                        if (l5 != null) {
                            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                            ((M4) l5).b("Lc", "VAST Schema validation error: InLine node or Wrapper node at appropriate hierarchy not found");
                        }
                        c(101);
                    }
                } else {
                    L4 l6 = this.b;
                    if (l6 != null) {
                        Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                        ((M4) l6).b("Lc", "VAST Schema validation error: Ad node at appropriate hierarchy not found");
                    }
                    c(303);
                }
            } else {
                L4 l7 = this.b;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                    ((M4) l7).b("Lc", "VAST Schema validation error: VAST node at appropriate hierarchy not found");
                }
                c(101);
            }
            return this.c;
        } catch (XmlPullParserException e) {
            c(100);
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        } catch (Exception e2) {
            c(900);
            C3339d5 c3339d6 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e2, "event"));
        }
    }

    public final void b(XmlPullParser xmlPullParser) {
        int iD = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "Extensions") && b(iD)) {
                return;
            }
            if (xmlPullParser.getName() != null && !b(iD)) {
                String name = xmlPullParser.getName();
                if (Intrinsics.areEqual(name, "CompanionAdTracking")) {
                    int iD2 = d(xmlPullParser);
                    while (true) {
                        if (xmlPullParser.getName() == null || !Intrinsics.areEqual(xmlPullParser.getName(), "CompanionAdTracking") || !b(iD2)) {
                            if (xmlPullParser.getName() != null && !b(iD2) && Intrinsics.areEqual("TrackingEvents", xmlPullParser.getName())) {
                                e(xmlPullParser);
                            }
                            iD2 = d(xmlPullParser);
                        }
                    }
                } else if (Intrinsics.areEqual(name, "Extension") && Intrinsics.areEqual(xmlPullParser.getAttributeValue(null, "type"), "AdVerifications")) {
                    a(xmlPullParser);
                }
            }
            iD = d(xmlPullParser);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:243:0x040a  */
    /* JADX WARN: Code duplicated, block: B:245:0x0413  */
    /* JADX WARN: Code duplicated, block: B:248:0x0430 A[LOOP:7: B:244:0x0411->B:248:0x0430, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:509:0x087d  */
    /* JADX WARN: Code duplicated, block: B:511:0x0885  */
    /* JADX WARN: Code duplicated, block: B:513:0x088c  */
    /* JADX WARN: Code duplicated, block: B:515:0x0898  */
    /* JADX WARN: Code duplicated, block: B:554:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:619:0x0433 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0422 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x08b0 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(XmlPullParser xmlPullParser) {
        XmlPullParser xmlPullParser2;
        String str;
        boolean z;
        String name;
        String str2;
        boolean z2;
        boolean z3;
        String str3;
        char c;
        boolean z4;
        int i;
        int i2;
        String name2;
        String str4;
        boolean z5;
        String name3;
        String str5;
        boolean z6;
        String strA;
        boolean z7;
        List<String> allowedContentType;
        int size;
        int i3;
        boolean z8;
        int i4;
        String str6;
        boolean z9;
        boolean z10;
        String str7;
        int i5;
        int i6;
        int i7;
        String str8;
        String str9;
        String name4;
        String strA2;
        String strA3;
        int i8;
        String strA4;
        int size2;
        int i9;
        String strA5;
        xmlPullParser = xmlPullParser;
        String str10 = "getAttributeValue(...)";
        int iD = d(xmlPullParser);
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            int i10 = 101;
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "InLine") && b(iD)) {
                if (z11 && z12) {
                    return;
                }
                L4 l4 = this.b;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                    ((M4) l4).b("Lc", "VAST Schema validation error: Creatives at appropriate hierarchy  not found");
                }
                c(101);
                return;
            }
            if (xmlPullParser.getName() != null && !b(iD) && (name = xmlPullParser.getName()) != null) {
                char c2 = 4;
                switch (name.hashCode()) {
                    case -2077435339:
                        xmlPullParser2 = xmlPullParser;
                        str = str10;
                        z = z12;
                        if (name.equals("AdVerifications")) {
                            a(xmlPullParser);
                        }
                        z12 = z;
                        break;
                    case -1692490108:
                        String str11 = "Creatives";
                        if (!name.equals("Creatives")) {
                            xmlPullParser2 = xmlPullParser;
                            str = str10;
                            z = z12;
                            z12 = z;
                            break;
                        } else {
                            int iD2 = d(xmlPullParser);
                            boolean z13 = false;
                            boolean z14 = false;
                            int i11 = 0;
                            while (true) {
                                if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str11) && b(iD2)) {
                                    if (!z13) {
                                        L4 l5 = this.b;
                                        if (l5 != null) {
                                            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                            ((M4) l5).b("Lc", "VAST Schema validation error: Creative at appropriate hierarchy not found");
                                        }
                                        c(i10);
                                    }
                                    if (!z14) {
                                        L4 l6 = this.b;
                                        if (l6 != null) {
                                            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                            ((M4) l6).b("Lc", "VAST Schema validation error: Linear Node at appropriate hierarchy not found");
                                        }
                                        c(201);
                                    }
                                    if (z13 && z14 && i11 != 0) {
                                        xmlPullParser2 = xmlPullParser;
                                        str = str10;
                                        z11 = true;
                                        break;
                                    }
                                } else {
                                    if (xmlPullParser.getName() == null || b(iD2) || (name2 = xmlPullParser.getName()) == null) {
                                        str2 = str10;
                                        z2 = z13;
                                        z3 = z12;
                                        str3 = str11;
                                        c = c2;
                                        z4 = z14;
                                        i = i11;
                                        xmlPullParser = xmlPullParser;
                                        i2 = i10;
                                    } else {
                                        int iHashCode = name2.hashCode();
                                        if (iHashCode != -2018804923) {
                                            if (iHashCode == 1150879268) {
                                                String str12 = "CompanionAds";
                                                if (name2.equals("CompanionAds")) {
                                                    int iD3 = d(xmlPullParser);
                                                    int i12 = 0;
                                                    while (true) {
                                                        if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str12) && b(iD3)) {
                                                            int size3 = this.c.i.size();
                                                            if (size3 == 0 && this.d) {
                                                                a(604);
                                                            } else if (i12 > 0 && size3 == 0) {
                                                                a(600);
                                                            }
                                                        } else {
                                                            if (xmlPullParser.getName() != null) {
                                                                str6 = str12;
                                                                String str13 = "Companion";
                                                                if (Intrinsics.areEqual("Companion", xmlPullParser.getName()) && !b(iD3)) {
                                                                    int i13 = i12 + 1;
                                                                    int i14 = iD3;
                                                                    try {
                                                                        String attributeValue = xmlPullParser.getAttributeValue(null, "width");
                                                                        Intrinsics.checkNotNullExpressionValue(attributeValue, str10);
                                                                        i6 = Integer.parseInt(attributeValue);
                                                                        z9 = z13;
                                                                        try {
                                                                            String attributeValue2 = xmlPullParser.getAttributeValue(null, "height");
                                                                            Intrinsics.checkNotNullExpressionValue(attributeValue2, str10);
                                                                            i7 = Integer.parseInt(attributeValue2);
                                                                        } catch (Exception unused) {
                                                                            L4 l7 = this.b;
                                                                            if (l7 != null) {
                                                                                Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                                ((M4) l7).b("Lc", "Invalid width or height encountered for a companion and ignoring that.");
                                                                            }
                                                                            i7 = 0;
                                                                        }
                                                                    } catch (Exception unused2) {
                                                                        z9 = z13;
                                                                        i6 = 0;
                                                                    }
                                                                    if (i6 <= 0 || i7 <= 0) {
                                                                        z14 = z14;
                                                                        i5 = i11;
                                                                        iD3 = d(xmlPullParser);
                                                                        str12 = str6;
                                                                        z13 = z9;
                                                                        str10 = str10;
                                                                        z12 = z12;
                                                                        str11 = str11;
                                                                        i12 = i13;
                                                                        z14 = z14;
                                                                        i11 = i5;
                                                                    } else {
                                                                        str10 = str10;
                                                                        Hc companion = new Hc(i6, i7, xmlPullParser.getAttributeValue(null, "ID"));
                                                                        int iD4 = d(xmlPullParser);
                                                                        String str14 = null;
                                                                        while (true) {
                                                                            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str13) && b(iD4)) {
                                                                                z10 = z12;
                                                                                str7 = str11;
                                                                                i13 = i13;
                                                                                z14 = z14;
                                                                            } else {
                                                                                if (xmlPullParser.getName() != null && !b(iD4) && (name4 = xmlPullParser.getName()) != null) {
                                                                                    str8 = str13;
                                                                                    str9 = str14;
                                                                                    z10 = z12;
                                                                                    str7 = str11;
                                                                                    switch (name4.hashCode()) {
                                                                                        case -375340334:
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            i11 = i11;
                                                                                            if (name4.equals("IFrameResource") && d(xmlPullParser) == 4) {
                                                                                                String text = xmlPullParser.getText();
                                                                                                if (!TextUtils.isEmpty(text)) {
                                                                                                    Gc resource = new Gc((byte) 3, text);
                                                                                                    Intrinsics.checkNotNullParameter(resource, "resource");
                                                                                                    companion.e.add(resource);
                                                                                                }
                                                                                            }
                                                                                            str14 = str9;
                                                                                            iD4 = d(xmlPullParser);
                                                                                            xmlPullParser = xmlPullParser;
                                                                                            str13 = str8;
                                                                                            z12 = z10;
                                                                                            str11 = str7;
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            i11 = i11;
                                                                                            break;
                                                                                        case -348198615:
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            i11 = i11;
                                                                                            if (name4.equals("CompanionClickThrough") && d(xmlPullParser) == 4) {
                                                                                                String text2 = xmlPullParser.getText();
                                                                                                if (text2 == null || text2.length() == 0) {
                                                                                                    strA2 = null;
                                                                                                } else {
                                                                                                    int length = text2.length() - 1;
                                                                                                    boolean z15 = false;
                                                                                                    int i15 = 0;
                                                                                                    while (i15 <= length) {
                                                                                                        boolean z16 = Intrinsics.compare((int) text2.charAt(!z15 ? i15 : length), 32) <= 0;
                                                                                                        if (z15) {
                                                                                                            if (z16) {
                                                                                                                length--;
                                                                                                            } else {
                                                                                                                strA2 = Q6.a(length, 1, text2, i15);
                                                                                                            }
                                                                                                        } else if (z16) {
                                                                                                            i15++;
                                                                                                        } else {
                                                                                                            z15 = true;
                                                                                                        }
                                                                                                    }
                                                                                                    strA2 = Q6.a(length, 1, text2, i15);
                                                                                                }
                                                                                                if (URLUtil.isValidUrl(strA2)) {
                                                                                                    companion.c = strA2;
                                                                                                }
                                                                                            }
                                                                                            str14 = str9;
                                                                                            iD4 = d(xmlPullParser);
                                                                                            xmlPullParser = xmlPullParser;
                                                                                            str13 = str8;
                                                                                            z12 = z10;
                                                                                            str11 = str7;
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            i11 = i11;
                                                                                            break;
                                                                                        case 611554000:
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            if (name4.equals("TrackingEvents")) {
                                                                                                int iD5 = d(xmlPullParser);
                                                                                                while (true) {
                                                                                                    if (xmlPullParser.getName() == null || !Intrinsics.areEqual(xmlPullParser.getName(), "TrackingEvents") || !b(iD5)) {
                                                                                                        if (!Intrinsics.areEqual("Tracking", xmlPullParser.getName()) || b(iD5)) {
                                                                                                            i11 = i11;
                                                                                                        } else {
                                                                                                            int attributeCount = xmlPullParser.getAttributeCount();
                                                                                                            int i16 = 0;
                                                                                                            while (true) {
                                                                                                                if (i16 < attributeCount) {
                                                                                                                    if (Intrinsics.areEqual(xmlPullParser.getAttributeName(i16), "event")) {
                                                                                                                        String attributeValue3 = xmlPullParser.getAttributeValue(i16);
                                                                                                                        if (d(xmlPullParser) == 4) {
                                                                                                                            String text3 = xmlPullParser.getText();
                                                                                                                            if (text3 != null) {
                                                                                                                                int length2 = text3.length() - 1;
                                                                                                                                int i17 = 0;
                                                                                                                                boolean z17 = false;
                                                                                                                                while (true) {
                                                                                                                                    i11 = i11;
                                                                                                                                    if (i17 <= length2) {
                                                                                                                                        boolean z18 = Intrinsics.compare((int) text3.charAt(!z17 ? i17 : length2), 32) <= 0;
                                                                                                                                        if (z17) {
                                                                                                                                            if (z18) {
                                                                                                                                                length2--;
                                                                                                                                            }
                                                                                                                                        } else if (z18) {
                                                                                                                                            i17++;
                                                                                                                                        } else {
                                                                                                                                            z17 = true;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                strA3 = Q6.a(length2, 1, text3, i17);
                                                                                                                            } else {
                                                                                                                                i11 = i11;
                                                                                                                                strA3 = null;
                                                                                                                            }
                                                                                                                            if (URLUtil.isValidUrl(strA3)) {
                                                                                                                                String str15 = (String) f.get(attributeValue3);
                                                                                                                                if (str15 == null) {
                                                                                                                                    str15 = "unknown";
                                                                                                                                }
                                                                                                                                String text4 = xmlPullParser.getText();
                                                                                                                                Intrinsics.checkNotNullExpressionValue(text4, "getText(...)");
                                                                                                                                C3328c8 tracker = new C3328c8(text4, 0, str15, null);
                                                                                                                                Intrinsics.checkNotNullParameter(tracker, "tracker");
                                                                                                                                companion.f.add(tracker);
                                                                                                                            } else {
                                                                                                                                L4 l8 = this.b;
                                                                                                                                if (l8 != null) {
                                                                                                                                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                                                                                    ((M4) l8).b("Lc", "Malformed URL: " + text3 + "; Discarding this tracker");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i16++;
                                                                                                                        xmlPullParser = xmlPullParser;
                                                                                                                    }
                                                                                                                }
                                                                                                                i11 = i11;
                                                                                                            }
                                                                                                        }
                                                                                                        iD5 = d(xmlPullParser);
                                                                                                        xmlPullParser = xmlPullParser;
                                                                                                        i11 = i11;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            i11 = i11;
                                                                                            str14 = str9;
                                                                                            iD4 = d(xmlPullParser);
                                                                                            xmlPullParser = xmlPullParser;
                                                                                            str13 = str8;
                                                                                            z12 = z10;
                                                                                            str11 = str7;
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            i11 = i11;
                                                                                            break;
                                                                                        case 676623548:
                                                                                            i13 = i13;
                                                                                            z14 = z14;
                                                                                            if (!name4.equals("StaticResource")) {
                                                                                                i11 = i11;
                                                                                                str14 = str9;
                                                                                                iD4 = d(xmlPullParser);
                                                                                                xmlPullParser = xmlPullParser;
                                                                                                str13 = str8;
                                                                                                z12 = z10;
                                                                                                str11 = str7;
                                                                                                i13 = i13;
                                                                                                z14 = z14;
                                                                                                i11 = i11;
                                                                                            } else {
                                                                                                String attributeValue4 = xmlPullParser.getAttributeValue(null, "creativeType");
                                                                                                if (d(xmlPullParser) == 4) {
                                                                                                    String text5 = xmlPullParser.getText();
                                                                                                    if (text5 == null || text5.length() == 0) {
                                                                                                        i8 = 1;
                                                                                                        strA4 = null;
                                                                                                    } else {
                                                                                                        int length3 = text5.length() - 1;
                                                                                                        int i18 = 0;
                                                                                                        boolean z19 = false;
                                                                                                        while (i18 <= length3) {
                                                                                                            boolean z20 = Intrinsics.compare((int) text5.charAt(!z19 ? i18 : length3), 32) <= 0;
                                                                                                            if (z19) {
                                                                                                                if (z20) {
                                                                                                                    length3--;
                                                                                                                } else {
                                                                                                                    i8 = 1;
                                                                                                                    strA4 = Q6.a(length3, 1, text5, i18);
                                                                                                                }
                                                                                                            } else if (z20) {
                                                                                                                i18++;
                                                                                                            } else {
                                                                                                                z19 = true;
                                                                                                            }
                                                                                                        }
                                                                                                        i8 = 1;
                                                                                                        strA4 = Q6.a(length3, 1, text5, i18);
                                                                                                    }
                                                                                                } else {
                                                                                                    i8 = 1;
                                                                                                    strA4 = str9;
                                                                                                }
                                                                                                if (attributeValue4 != null) {
                                                                                                    int length4 = attributeValue4.length() - i8;
                                                                                                    int i19 = 0;
                                                                                                    boolean z21 = false;
                                                                                                    while (i19 <= length4) {
                                                                                                        boolean z22 = Intrinsics.compare((int) attributeValue4.charAt(!z21 ? i19 : length4), 32) <= 0;
                                                                                                        if (z21) {
                                                                                                            if (z22) {
                                                                                                                length4--;
                                                                                                            } else if (attributeValue4.subSequence(i19, length4 + 1).toString().length() > 0) {
                                                                                                                size2 = Hc.h.size();
                                                                                                                i9 = 0;
                                                                                                                while (true) {
                                                                                                                    if (i9 < size2) {
                                                                                                                        this.d = true;
                                                                                                                    } else if (StringsKt.equals(attributeValue4, (String) Hc.h.get(i9), true)) {
                                                                                                                        Gc resource2 = new Gc((byte) 1, strA4);
                                                                                                                        Intrinsics.checkNotNullParameter(resource2, "resource");
                                                                                                                        companion.e.add(resource2);
                                                                                                                    } else {
                                                                                                                        i9++;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (z22) {
                                                                                                            i19++;
                                                                                                        } else {
                                                                                                            z21 = true;
                                                                                                        }
                                                                                                    }
                                                                                                    if (attributeValue4.subSequence(i19, length4 + 1).toString().length() > 0) {
                                                                                                        size2 = Hc.h.size();
                                                                                                        i9 = 0;
                                                                                                        while (true) {
                                                                                                            if (i9 < size2) {
                                                                                                                this.d = true;
                                                                                                            } else if (StringsKt.equals(attributeValue4, (String) Hc.h.get(i9), true)) {
                                                                                                                Gc resource3 = new Gc((byte) 1, strA4);
                                                                                                                Intrinsics.checkNotNullParameter(resource3, "resource");
                                                                                                                companion.e.add(resource3);
                                                                                                            } else {
                                                                                                                i9++;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                str14 = strA4;
                                                                                                iD4 = d(xmlPullParser);
                                                                                                xmlPullParser = xmlPullParser;
                                                                                                str13 = str8;
                                                                                                z12 = z10;
                                                                                                str11 = str7;
                                                                                                i13 = i13;
                                                                                                z14 = z14;
                                                                                                i11 = i11;
                                                                                            }
                                                                                            break;
                                                                                        case 1877773523:
                                                                                            if (name4.equals("CompanionClickTracking") && d(xmlPullParser) == 4) {
                                                                                                String text6 = xmlPullParser.getText();
                                                                                                if (text6 == null || text6.length() == 0) {
                                                                                                    i13 = i13;
                                                                                                    z14 = z14;
                                                                                                    strA5 = null;
                                                                                                } else {
                                                                                                    int length5 = text6.length() - 1;
                                                                                                    int i20 = 0;
                                                                                                    boolean z23 = false;
                                                                                                    while (true) {
                                                                                                        i13 = i13;
                                                                                                        if (i20 <= length5) {
                                                                                                            z14 = z14;
                                                                                                            boolean z24 = Intrinsics.compare((int) text6.charAt(!z23 ? i20 : length5), 32) <= 0;
                                                                                                            if (z23) {
                                                                                                                if (z24) {
                                                                                                                    length5--;
                                                                                                                }
                                                                                                            } else if (z24) {
                                                                                                                i20++;
                                                                                                            } else {
                                                                                                                z23 = true;
                                                                                                            }
                                                                                                        } else {
                                                                                                            z14 = z14;
                                                                                                        }
                                                                                                    }
                                                                                                    strA5 = Q6.a(length5, 1, text6, i20);
                                                                                                }
                                                                                                if (!URLUtil.isValidUrl(strA5)) {
                                                                                                    L4 l9 = this.b;
                                                                                                    if (l9 != null) {
                                                                                                        Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                                                        ((M4) l9).b("Lc", "Malformed URL: " + strA5 + "; Discarding this tracker");
                                                                                                    }
                                                                                                } else {
                                                                                                    Intrinsics.checkNotNull(strA5);
                                                                                                    C3328c8 tracker2 = new C3328c8(strA5, 0, "click", null);
                                                                                                    Intrinsics.checkNotNullParameter(tracker2, "tracker");
                                                                                                    companion.f.add(tracker2);
                                                                                                    str14 = strA5;
                                                                                                    iD4 = d(xmlPullParser);
                                                                                                    xmlPullParser = xmlPullParser;
                                                                                                    str13 = str8;
                                                                                                    z12 = z10;
                                                                                                    str11 = str7;
                                                                                                    i13 = i13;
                                                                                                    z14 = z14;
                                                                                                    i11 = i11;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 1928285401:
                                                                                            if (name4.equals("HTMLResource") && d(xmlPullParser) == 4) {
                                                                                                String text7 = xmlPullParser.getText();
                                                                                                if (!TextUtils.isEmpty(text7)) {
                                                                                                    Gc resource4 = new Gc((byte) 2, text7);
                                                                                                    Intrinsics.checkNotNullParameter(resource4, "resource");
                                                                                                    companion.e.add(resource4);
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    str8 = str13;
                                                                                    str9 = str14;
                                                                                    z10 = z12;
                                                                                    str7 = str11;
                                                                                }
                                                                                i13 = i13;
                                                                                z14 = z14;
                                                                                i11 = i11;
                                                                                str14 = str9;
                                                                                iD4 = d(xmlPullParser);
                                                                                xmlPullParser = xmlPullParser;
                                                                                str13 = str8;
                                                                                z12 = z10;
                                                                                str11 = str7;
                                                                                i13 = i13;
                                                                                z14 = z14;
                                                                                i11 = i11;
                                                                            }
                                                                        }
                                                                        if (companion.e.isEmpty()) {
                                                                            str12 = str6;
                                                                            iD3 = i14;
                                                                            z13 = z9;
                                                                            str10 = str10;
                                                                            z12 = z10;
                                                                            str11 = str7;
                                                                            i12 = i13;
                                                                            z14 = z14;
                                                                        } else {
                                                                            Qc qc = this.c;
                                                                            qc.getClass();
                                                                            Intrinsics.checkNotNullParameter(companion, "companion");
                                                                            qc.i.add(companion);
                                                                            i5 = i11;
                                                                            i12 = i13;
                                                                            iD3 = d(xmlPullParser);
                                                                            str12 = str6;
                                                                            z13 = z9;
                                                                            str10 = str10;
                                                                            z12 = z10;
                                                                            str11 = str7;
                                                                            z14 = z14;
                                                                            i11 = i5;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            } else {
                                                                str6 = str12;
                                                            }
                                                            z9 = z13;
                                                            z10 = z12;
                                                            str7 = str11;
                                                            z14 = z14;
                                                            i5 = i11;
                                                            iD3 = d(xmlPullParser);
                                                            str12 = str6;
                                                            z13 = z9;
                                                            str10 = str10;
                                                            z12 = z10;
                                                            str11 = str7;
                                                            z14 = z14;
                                                            i11 = i5;
                                                        }
                                                    }
                                                }
                                            } else if (iHashCode == 1885066191 && name2.equals("Creative")) {
                                                xmlPullParser = xmlPullParser;
                                                str2 = str10;
                                                z3 = z12;
                                                str3 = str11;
                                                i2 = 101;
                                                z13 = true;
                                                c = 4;
                                            }
                                            xmlPullParser = xmlPullParser;
                                            str2 = str10;
                                            z2 = z13;
                                            z3 = z12;
                                            str3 = str11;
                                            z4 = z14;
                                            i = i11;
                                            i2 = 101;
                                            c = 4;
                                        } else {
                                            str2 = str10;
                                            z2 = z13;
                                            z3 = z12;
                                            str3 = str11;
                                            z4 = z14;
                                            i = i11;
                                            String str16 = null;
                                            int i21 = 0;
                                            String str17 = "Linear";
                                            if (name2.equals("Linear")) {
                                                int iD6 = d(xmlPullParser);
                                                boolean z25 = false;
                                                boolean z26 = false;
                                                int i22 = 0;
                                                while (true) {
                                                    if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str17) && b(iD6)) {
                                                        if (!z25 || !z26) {
                                                            L4 l10 = this.b;
                                                            if (l10 != null) {
                                                                Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                ((M4) l10).b("Lc", "VAST Schema Validation Error.Duration tag not found");
                                                            }
                                                            c(101);
                                                        }
                                                        if (z25 && z26 && i22 != 0) {
                                                            i2 = 101;
                                                            c = 4;
                                                            i11 = 1;
                                                        } else {
                                                            i11 = i21;
                                                            i2 = 101;
                                                            c = 4;
                                                        }
                                                    } else {
                                                        if (xmlPullParser.getName() == null || b(iD6) || (name3 = xmlPullParser.getName()) == null) {
                                                            str4 = str17;
                                                            z5 = z25;
                                                            z25 = z5;
                                                        } else {
                                                            int iHashCode2 = name3.hashCode();
                                                            if (iHashCode2 == -2049897434) {
                                                                str4 = str17;
                                                                z5 = z25;
                                                                if (name3.equals("VideoClicks")) {
                                                                    a(xmlPullParser, true);
                                                                }
                                                                z25 = z5;
                                                            } else if (iHashCode2 != -1927368268) {
                                                                if (iHashCode2 == -385055469) {
                                                                    String str18 = "MediaFiles";
                                                                    if (name3.equals("MediaFiles")) {
                                                                        int iD7 = d(xmlPullParser);
                                                                        int i23 = i21;
                                                                        while (true) {
                                                                            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str18) && b(iD7)) {
                                                                                if (i23 == 0) {
                                                                                    c(401);
                                                                                } else {
                                                                                    if (this.c.e.isEmpty()) {
                                                                                        c(403);
                                                                                    } else {
                                                                                        i4 = 1;
                                                                                    }
                                                                                    str4 = str17;
                                                                                    i22 = i4;
                                                                                    z26 = true;
                                                                                }
                                                                                i4 = i21;
                                                                                str4 = str17;
                                                                                i22 = i4;
                                                                                z26 = true;
                                                                            } else {
                                                                                if (xmlPullParser.getName() == null || !Intrinsics.areEqual("MediaFile", xmlPullParser.getName()) || b(iD7)) {
                                                                                    str5 = str17;
                                                                                    z6 = z25;
                                                                                    str18 = str18;
                                                                                } else {
                                                                                    AdConfig.BitRateConfig bitRate = this.f3129a.getBitRate();
                                                                                    int attributeCount2 = xmlPullParser.getAttributeCount();
                                                                                    String attributeValue5 = str16;
                                                                                    String attributeValue6 = attributeValue5;
                                                                                    int i24 = i21;
                                                                                    int iIntValue = i24;
                                                                                    while (i24 < attributeCount2) {
                                                                                        String attributeName = xmlPullParser.getAttributeName(i24);
                                                                                        String str19 = str17;
                                                                                        if (attributeName != null) {
                                                                                            int iHashCode3 = attributeName.hashCode();
                                                                                            z8 = z25;
                                                                                            if (iHashCode3 != -102270099) {
                                                                                                if (iHashCode3 != 3575610) {
                                                                                                    if (iHashCode3 == 823466996 && attributeName.equals("delivery")) {
                                                                                                        attributeValue5 = xmlPullParser.getAttributeValue(i24);
                                                                                                    }
                                                                                                } else if (attributeName.equals("type")) {
                                                                                                    attributeValue6 = xmlPullParser.getAttributeValue(i24);
                                                                                                }
                                                                                            } else if (attributeName.equals("bitrate")) {
                                                                                                try {
                                                                                                    Integer numValueOf = Integer.valueOf(xmlPullParser.getAttributeValue(i24));
                                                                                                    Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(...)");
                                                                                                    iIntValue = numValueOf.intValue();
                                                                                                } catch (Exception unused3) {
                                                                                                    L4 l11 = this.b;
                                                                                                    if (l11 != null) {
                                                                                                        Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                                                        ((M4) l11).b("Lc", "Invalid value found for BitRate.");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            z8 = z25;
                                                                                        }
                                                                                        i24++;
                                                                                        str17 = str19;
                                                                                        z25 = z8;
                                                                                    }
                                                                                    str5 = str17;
                                                                                    z6 = z25;
                                                                                    int iD8 = d(xmlPullParser);
                                                                                    if (iD8 == 4) {
                                                                                        String text8 = xmlPullParser.getText();
                                                                                        if (text8 == null || text8.length() == 0) {
                                                                                            iD8 = iD8;
                                                                                            str18 = str18;
                                                                                            strA = null;
                                                                                        } else {
                                                                                            int length6 = text8.length() - 1;
                                                                                            int i25 = 0;
                                                                                            boolean z27 = false;
                                                                                            while (true) {
                                                                                                iD8 = iD8;
                                                                                                if (i25 <= length6) {
                                                                                                    str18 = str18;
                                                                                                    boolean z28 = Intrinsics.compare((int) text8.charAt(!z27 ? i25 : length6), 32) <= 0;
                                                                                                    if (z27) {
                                                                                                        if (z28) {
                                                                                                            length6--;
                                                                                                        }
                                                                                                    } else if (z28) {
                                                                                                        i25++;
                                                                                                    } else {
                                                                                                        z27 = true;
                                                                                                    }
                                                                                                } else {
                                                                                                    str18 = str18;
                                                                                                }
                                                                                            }
                                                                                            strA = Q6.a(length6, 1, text8, i25);
                                                                                        }
                                                                                        if (URLUtil.isValidUrl(strA) && ((!bitRate.getBitrate_mandatory() || iIntValue > 0) && attributeValue5 != null)) {
                                                                                            int length7 = attributeValue5.length() - 1;
                                                                                            int i26 = 0;
                                                                                            boolean z29 = false;
                                                                                            while (i26 <= length7) {
                                                                                                boolean z30 = Intrinsics.compare((int) attributeValue5.charAt(!z29 ? i26 : length7), 32) <= 0;
                                                                                                if (z29) {
                                                                                                    if (z30) {
                                                                                                        length7--;
                                                                                                    } else {
                                                                                                        z7 = true;
                                                                                                        if (!StringsKt.equals(Q6.a(length7, 1, attributeValue5, i26), "Progressive", true)) {
                                                                                                            allowedContentType = this.f3129a.getAllowedContentType();
                                                                                                            if (attributeValue6 != null) {
                                                                                                                size = allowedContentType.size();
                                                                                                                i3 = 0;
                                                                                                                while (i3 < size) {
                                                                                                                    if (StringsKt.equals(attributeValue6, allowedContentType.get(i3), z7)) {
                                                                                                                        Qc qc2 = this.c;
                                                                                                                        Intrinsics.checkNotNull(strA);
                                                                                                                        Ic vastMediaFile = new Ic(strA, iIntValue);
                                                                                                                        qc2.getClass();
                                                                                                                        Intrinsics.checkNotNullParameter(vastMediaFile, "vastMediaFile");
                                                                                                                        qc2.e.add(vastMediaFile);
                                                                                                                    }
                                                                                                                    i3++;
                                                                                                                    z7 = true;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        str16 = null;
                                                                                                        i21 = 0;
                                                                                                    }
                                                                                                } else if (z30) {
                                                                                                    i26++;
                                                                                                } else {
                                                                                                    z29 = true;
                                                                                                }
                                                                                            }
                                                                                            z7 = true;
                                                                                            if (!StringsKt.equals(Q6.a(length7, 1, attributeValue5, i26), "Progressive", true)) {
                                                                                                allowedContentType = this.f3129a.getAllowedContentType();
                                                                                                if (attributeValue6 != null) {
                                                                                                    size = allowedContentType.size();
                                                                                                    i3 = 0;
                                                                                                    while (i3 < size) {
                                                                                                        if (StringsKt.equals(attributeValue6, allowedContentType.get(i3), z7)) {
                                                                                                            Qc qc3 = this.c;
                                                                                                            Intrinsics.checkNotNull(strA);
                                                                                                            Ic vastMediaFile2 = new Ic(strA, iIntValue);
                                                                                                            qc3.getClass();
                                                                                                            Intrinsics.checkNotNullParameter(vastMediaFile2, "vastMediaFile");
                                                                                                            qc3.e.add(vastMediaFile2);
                                                                                                        }
                                                                                                        i3++;
                                                                                                        z7 = true;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            str16 = null;
                                                                                            i21 = 0;
                                                                                        }
                                                                                        str17 = str5;
                                                                                        z25 = z6;
                                                                                        iD7 = iD8;
                                                                                        str18 = str18;
                                                                                        i23 = 1;
                                                                                        str16 = null;
                                                                                        i21 = 0;
                                                                                    } else {
                                                                                        str18 = str18;
                                                                                    }
                                                                                    i23 = 1;
                                                                                }
                                                                                iD7 = d(xmlPullParser);
                                                                                str17 = str5;
                                                                                z25 = z6;
                                                                                str18 = str18;
                                                                                str16 = null;
                                                                                i21 = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (iHashCode2 == 611554000 && name3.equals("TrackingEvents")) {
                                                                    e(xmlPullParser);
                                                                }
                                                                str4 = str17;
                                                                z5 = z25;
                                                                z25 = z5;
                                                            } else {
                                                                str4 = str17;
                                                                z5 = z25;
                                                                if (name3.equals("Duration")) {
                                                                    c = 4;
                                                                    if (d(xmlPullParser) == 4) {
                                                                        String text9 = xmlPullParser.getText();
                                                                        if (!TextUtils.isEmpty(text9)) {
                                                                            Intrinsics.checkNotNull(text9);
                                                                            if (new Regex("^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:\\.\\d{1,3})?$").matches(text9)) {
                                                                                this.c.g = text9;
                                                                                z25 = true;
                                                                            }
                                                                        }
                                                                        L4 l12 = this.b;
                                                                        if (l12 != null) {
                                                                            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                                                            ((M4) l12).b("Lc", "VAST Schema Validation Error. " + text9 + " Media Duration invalid.");
                                                                        }
                                                                        i2 = 101;
                                                                        c(101);
                                                                        i11 = 0;
                                                                    } else {
                                                                        z25 = z5;
                                                                    }
                                                                } else {
                                                                    z25 = z5;
                                                                }
                                                            }
                                                        }
                                                        iD6 = d(xmlPullParser);
                                                        str17 = str4;
                                                        str16 = null;
                                                        i21 = 0;
                                                    }
                                                    z13 = z2;
                                                    z14 = true;
                                                }
                                            } else {
                                                xmlPullParser = xmlPullParser;
                                                i2 = 101;
                                                c = 4;
                                            }
                                        }
                                        iD2 = d(xmlPullParser);
                                        i10 = i2;
                                        xmlPullParser = xmlPullParser;
                                        str10 = str2;
                                        str11 = str3;
                                        c2 = c;
                                        z12 = z3;
                                    }
                                    z13 = z2;
                                    z14 = z4;
                                    i11 = i;
                                    iD2 = d(xmlPullParser);
                                    i10 = i2;
                                    xmlPullParser = xmlPullParser;
                                    str10 = str2;
                                    str11 = str3;
                                    c2 = c;
                                    z12 = z3;
                                }
                            }
                        }
                        break;
                    case 67232232:
                        if (name.equals("Error")) {
                            d(xmlPullParser);
                            String text10 = xmlPullParser.getText();
                            Intrinsics.checkNotNullExpressionValue(text10, "getText(...)");
                            a("error", text10);
                        }
                        xmlPullParser2 = xmlPullParser;
                        str = str10;
                        z = z12;
                        z12 = z;
                        break;
                    case 184043572:
                        if (name.equals("Extensions")) {
                            b(xmlPullParser);
                        }
                        xmlPullParser2 = xmlPullParser;
                        str = str10;
                        z = z12;
                        z12 = z;
                        break;
                    case 2114088489:
                        if (name.equals("Impression")) {
                            int iD9 = d(xmlPullParser);
                            if (iD9 == 4) {
                                String text11 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text11, "getText(...)");
                                a("Impression", text11);
                                xmlPullParser2 = xmlPullParser;
                                str = str10;
                                z12 = true;
                            } else {
                                L4 l13 = this.b;
                                if (l13 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                    ((M4) l13).b("Lc", "VAST Schema Error: VastAdTagUri at appropriate hierarchy not found or invalid - " + iD9);
                                }
                            }
                        }
                        xmlPullParser2 = xmlPullParser;
                        str = str10;
                        z = z12;
                        z12 = z;
                        break;
                    default:
                        xmlPullParser2 = xmlPullParser;
                        str = str10;
                        z = z12;
                        z12 = z;
                        break;
                }
                return;
            }
            xmlPullParser2 = xmlPullParser;
            str = str10;
            z = z12;
            z12 = z;
            iD = d(xmlPullParser);
            xmlPullParser = xmlPullParser2;
            str10 = str;
        }
    }

    public final int d(XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.next();
        } catch (IOException unused) {
            L4 l4 = this.b;
            if (l4 == null) {
                return -1;
            }
            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
            ((M4) l4).b("Lc", "Parsing failed.");
            return -1;
        } catch (XmlPullParserException unused2) {
            L4 l5 = this.b;
            if (l5 == null) {
                return -1;
            }
            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
            ((M4) l5).b("Lc", "VAST Schema validation error: VAST node at appropriate hierarchy not found.");
            return -1;
        }
    }

    public final void e(XmlPullParser xmlPullParser) {
        int iD = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "TrackingEvents") && b(iD)) {
                return;
            }
            if (xmlPullParser.getName() != null && Intrinsics.areEqual("Tracking", xmlPullParser.getName()) && !b(iD)) {
                int attributeCount = xmlPullParser.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (Intrinsics.areEqual(xmlPullParser.getAttributeName(i), "event")) {
                        String attributeValue = xmlPullParser.getAttributeValue(i);
                        if (d(xmlPullParser) != 4) {
                            break;
                        }
                        HashMap map = f;
                        if (!map.containsKey(attributeValue)) {
                            break;
                        }
                        Object obj = map.get(attributeValue);
                        Intrinsics.checkNotNull(obj);
                        String text = xmlPullParser.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                        a((String) obj, text);
                        break;
                    }
                }
            }
            iD = d(xmlPullParser);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void f(XmlPullParser xmlPullParser) {
        String name;
        String strA;
        int i = this.e + 1;
        this.e = i;
        if (i > this.f3129a.getMaxWrapperLimit()) {
            L4 l4 = this.b;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                ((M4) l4).b("Lc", "Schema Validation Error:Max VAST wrapper limit exceeded");
            }
            c(302);
            return;
        }
        int iD = d(xmlPullParser);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "Wrapper") && b(iD)) {
                if (z && z2) {
                    return;
                }
                L4 l5 = this.b;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                    ((M4) l5).b("Lc", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                }
                c(101);
                return;
            }
            if (xmlPullParser.getName() != null && !b(iD) && (name = xmlPullParser.getName()) != null) {
                switch (name.hashCode()) {
                    case -2077435339:
                        if (name.equals("AdVerifications")) {
                            a(xmlPullParser);
                        }
                        break;
                    case -2049897434:
                        if (name.equals("VideoClicks")) {
                            a(xmlPullParser, false);
                        }
                        break;
                    case -587420703:
                        if (!name.equals("VASTAdTagURI")) {
                            continue;
                        } else {
                            if (d(xmlPullParser) != 4) {
                                L4 l6 = this.b;
                                if (l6 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                    ((M4) l6).b("Lc", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                                }
                                c(101);
                                return;
                            }
                            String text = xmlPullParser.getText();
                            if (text == null || text.length() == 0) {
                                strA = null;
                            } else {
                                Intrinsics.checkNotNull(text);
                                int length = text.length() - 1;
                                int i2 = 0;
                                boolean z3 = false;
                                while (i2 <= length) {
                                    boolean z4 = Intrinsics.compare((int) text.charAt(!z3 ? i2 : length), 32) <= 0;
                                    if (z3) {
                                        if (z4) {
                                            length--;
                                        } else {
                                            strA = Q6.a(length, 1, text, i2);
                                        }
                                    } else if (z4) {
                                        i2++;
                                    } else {
                                        z3 = true;
                                    }
                                }
                                strA = Q6.a(length, 1, text, i2);
                            }
                            if (strA == null) {
                                L4 l7 = this.b;
                                if (l7 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                    ((M4) l7).b("Lc", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                                }
                                c(300);
                                return;
                            }
                            if (URLUtil.isValidUrl(strA)) {
                                S8 mRequest = new S8(strA, this.b);
                                mRequest.t = false;
                                mRequest.u = false;
                                mRequest.x = false;
                                mRequest.r = true;
                                Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                                T8 t8B = mRequest.b();
                                if (t8B.b()) {
                                    c(301);
                                } else {
                                    a(t8B.a());
                                }
                            } else {
                                c(300);
                            }
                            if (this.c.l != 0) {
                                return;
                            } else {
                                z = true;
                            }
                        }
                        break;
                    case 67232232:
                        if (name.equals("Error") && d(xmlPullParser) == 4) {
                            String text2 = xmlPullParser.getText();
                            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                            a("error", text2);
                        }
                        break;
                    case 184043572:
                        if (name.equals("Extensions")) {
                            b(xmlPullParser);
                        }
                        break;
                    case 611554000:
                        if (name.equals("TrackingEvents")) {
                            e(xmlPullParser);
                        }
                        break;
                    case 2114088489:
                        if (name.equals("Impression")) {
                            int iD2 = d(xmlPullParser);
                            if (iD2 != 4) {
                                L4 l8 = this.b;
                                if (l8 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                                    ((M4) l8).b("Lc", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid - " + iD2);
                                }
                            } else {
                                String text3 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                                a("Impression", text3);
                                z2 = true;
                            }
                        }
                        break;
                }
            }
            iD = d(xmlPullParser);
        }
    }

    public final void a(XmlPullParser xmlPullParser, String str) {
        L4 l4 = this.b;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
            ((M4) l4).c("Lc", "name=".concat(str));
        }
        int next = 0;
        while (true) {
            try {
                next = xmlPullParser.next();
            } catch (IOException e) {
                L4 l5 = this.b;
                if (l5 != null) {
                    ((M4) l5).b("Lc", O5.a("Lc", "TAG", "Parsing failed. ").append(Arrays.toString(e.getStackTrace())).toString());
                }
            } catch (XmlPullParserException e2) {
                L4 l6 = this.b;
                if (l6 != null) {
                    ((M4) l6).b("Lc", O5.a("Lc", "TAG", "VAST Schema validation error: VAST node at appropriate hierarchy not found. ").append(Arrays.toString(e2.getStackTrace())).toString());
                }
            }
            if (next == 1) {
                return;
            }
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str)) {
                return;
            }
        }
    }

    public final void a(XmlPullParser xmlPullParser, String[] strArr) {
        int next = 0;
        boolean z = false;
        do {
            try {
                next = xmlPullParser.next();
            } catch (IOException unused) {
                L4 l4 = this.b;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                    ((M4) l4).b("Lc", "Parsing failed.");
                }
            } catch (XmlPullParserException unused2) {
                L4 l5 = this.b;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                    ((M4) l5).b("Lc", "VAST Schema validation error: VAST node at appropriate hierarchy not found.");
                }
            }
            if (next == 1) {
                return;
            }
            if (xmlPullParser.getName() != null) {
                for (String str : strArr) {
                    if (Intrinsics.areEqual(xmlPullParser.getName(), str)) {
                        z = true;
                        break;
                    }
                }
            }
        } while (!z);
    }

    public final void a(XmlPullParser xmlPullParser, boolean z) {
        String strA;
        int iD = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "VideoClicks") && b(iD)) {
                return;
            }
            if (xmlPullParser.getName() != null && !b(iD)) {
                String name = xmlPullParser.getName();
                if (Intrinsics.areEqual(name, "ClickThrough")) {
                    if (!z) {
                        return;
                    }
                    if (d(xmlPullParser) == 4) {
                        String text = xmlPullParser.getText();
                        if (text == null || text.length() == 0) {
                            strA = null;
                        } else {
                            Intrinsics.checkNotNull(text);
                            int length = text.length() - 1;
                            int i = 0;
                            boolean z2 = false;
                            while (i <= length) {
                                boolean z3 = Intrinsics.compare((int) text.charAt(!z2 ? i : length), 32) <= 0;
                                if (z2) {
                                    if (!z3) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z3) {
                                    i++;
                                } else {
                                    z2 = true;
                                }
                            }
                            strA = Q6.a(length, 1, text, i);
                        }
                        this.c.k = strA;
                    }
                } else if (Intrinsics.areEqual(name, "ClickTracking") && d(xmlPullParser) == 4) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    a("click", text2);
                }
            }
            iD = d(xmlPullParser);
        }
    }

    public final void a(XmlPullParser vastParser) {
        String vendor;
        int iD;
        int iD2 = d(vastParser);
        while (true) {
            if (vastParser.getName() != null && Intrinsics.areEqual(vastParser.getName(), "AdVerifications") && b(iD2)) {
                return;
            }
            if (vastParser.getName() != null && !b(iD2) && Intrinsics.areEqual(vastParser.getName(), "Verification") && (vendor = vastParser.getAttributeValue(null, "vendor")) != null) {
                Intrinsics.checkNotNullParameter(vastParser, "vastParser");
                Intrinsics.checkNotNullParameter(vendor, "vendor");
                int iD3 = d(vastParser);
                String strA = null;
                String string = null;
                while (true) {
                    if (vastParser.getName() != null && Intrinsics.areEqual(vastParser.getName(), "Verification") && b(iD3)) {
                        break;
                    }
                    if (vastParser.getName() != null && !b(iD3)) {
                        String name = vastParser.getName();
                        if (Intrinsics.areEqual(name, "JavaScriptResource")) {
                            String attributeValue = vastParser.getAttributeValue(null, "apiFramework");
                            if (attributeValue != null && StringsKt.startsWith$default(attributeValue, CampaignEx.KEY_OMID, false, 2, (Object) null) && d(vastParser) == 4) {
                                String text = vastParser.getText();
                                if (text == null || text.length() == 0) {
                                    strA = null;
                                } else {
                                    int length = text.length() - 1;
                                    int i = 0;
                                    boolean z = false;
                                    while (i <= length) {
                                        boolean z2 = Intrinsics.compare((int) text.charAt(!z ? i : length), 32) <= 0;
                                        if (z) {
                                            if (!z2) {
                                                break;
                                            } else {
                                                length--;
                                            }
                                        } else if (z2) {
                                            i++;
                                        } else {
                                            z = true;
                                        }
                                    }
                                    strA = Q6.a(length, 1, text, i);
                                }
                            }
                        } else if (Intrinsics.areEqual(name, "VerificationParameters") && ((iD = d(vastParser)) == 4 || iD == 5)) {
                            String text2 = vastParser.getText();
                            if (text2 == null || text2.length() == 0) {
                                string = null;
                            } else {
                                String text3 = vastParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                                string = StringsKt.trim((CharSequence) text3).toString();
                            }
                        }
                    }
                    iD3 = d(vastParser);
                }
                if (URLUtil.isValidUrl(strA)) {
                    Intrinsics.checkNotNull(strA);
                    C3385g9 tracker = new C3385g9(vendor, string, strA, null);
                    Qc qc = this.c;
                    qc.getClass();
                    Intrinsics.checkNotNullParameter(tracker, "tracker");
                    qc.h.add(tracker);
                    L4 l4 = this.b;
                    if (l4 != null) {
                        Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                        ((M4) l4).b("Lc", "Omid JavaScript URL found inside VAST : ".concat(strA));
                    }
                }
            }
            iD2 = d(vastParser);
        }
    }

    public final void a(int i) {
        HashMap map = new HashMap();
        map.put("[ERRORCODE]", String.valueOf(i));
        for (C3328c8 c3328c8 : this.c.h) {
            if (Intrinsics.areEqual("error", c3328c8.b)) {
                String str = c3328c8.d;
                boolean z = W8.f3228a;
                C3364f2.f3308a.a(W8.a(str, map), c3328c8.c, true, null, B9.c, this.b);
            }
        }
    }

    public final void a(String str, String str2) {
        String strA;
        if (str2.length() == 0) {
            strA = null;
        } else {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            strA = Q6.a(length, 1, str2, i);
        }
        if (!URLUtil.isValidUrl(strA)) {
            L4 l4 = this.b;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("Lc", "TAG");
                ((M4) l4).b("Lc", "Malformed URL " + strA + " Discarding this tracker");
            }
            Intrinsics.areEqual(str, "Impression");
            return;
        }
        Intrinsics.checkNotNull(strA);
        C3328c8 tracker = new C3328c8(strA, 0, str, null);
        Qc qc = this.c;
        qc.getClass();
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        qc.h.add(tracker);
    }

    public final void c(int i) {
        this.c.l = i;
        a(i);
    }
}
