package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.VastBeacon;
import com.smaato.sdk.video.vast.model.VideoClicks;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class VideoClicksParser implements XmlClassParser<VideoClicks> {
    private static final String[] VIDEO_CLICKS_PARSER = {"ClickThrough", "ClickTracking", "CustomClick"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<VideoClicks> parse(final RegistryXmlParser registryXmlParser) {
        final VideoClicks.Builder builder = new VideoClicks.Builder();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        builder.setClickTrackings(arrayList2);
        final ArrayList arrayList3 = new ArrayList();
        builder.setCustomClicks(arrayList3);
        registryXmlParser.parseTags(VIDEO_CLICKS_PARSER, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VideoClicksParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoClicksParser.lambda$parse$3(registryXmlParser, builder, arrayList, arrayList2, arrayList3, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VideoClicksParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("VideoClicks", new Exception("Unable to parse tags in CompanionAds", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$3(RegistryXmlParser registryXmlParser, final VideoClicks.Builder builder, final List list, final List list2, final List list3, String str) {
        if (str.equalsIgnoreCase("ClickThrough")) {
            registryXmlParser.parseClass("ClickThrough", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VideoClicksParser$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    VideoClicksParser.lambda$parse$0(builder, list, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("ClickTracking")) {
            registryXmlParser.parseClass("ClickTracking", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VideoClicksParser$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    VideoClicksParser.lambda$parse$1(list2, list, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("CustomClick")) {
            registryXmlParser.parseClass("CustomClick", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VideoClicksParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    VideoClicksParser.lambda$parse$2(list3, list, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$0(VideoClicks.Builder builder, List list, ParseResult parseResult) {
        builder.setClickThrough((VastBeacon) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$1(List list, List list2, ParseResult parseResult) {
        VastBeacon vastBeacon = (VastBeacon) parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(vastBeacon, new CompanionParser$$ExternalSyntheticLambda25(list));
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$2(List list, List list2, ParseResult parseResult) {
        VastBeacon vastBeacon = (VastBeacon) parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(vastBeacon, new CompanionParser$$ExternalSyntheticLambda25(list));
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }
}
