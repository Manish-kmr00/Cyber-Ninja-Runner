package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.IconClicks;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.VastBeacon;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class IconClicksParser implements XmlClassParser<IconClicks> {
    private static final String[] ICON_CLICKS_TAGS = {"IconClickThrough", "IconClickTracking"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<IconClicks> parse(final RegistryXmlParser registryXmlParser) {
        final IconClicks.Builder builder = new IconClicks.Builder();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        builder.setIconClickTrackings(arrayList2);
        registryXmlParser.parseTags(ICON_CLICKS_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconClicksParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                IconClicksParser.lambda$parse$2(registryXmlParser, builder, arrayList, arrayList2, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconClicksParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("IconClicks", new Exception("Unable to parse IconClicks value", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$2(RegistryXmlParser registryXmlParser, final IconClicks.Builder builder, final List list, final List list2, String str) {
        if (str.equalsIgnoreCase("IconClickThrough")) {
            Objects.requireNonNull(builder);
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconClicksParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    builder.setIconClickThrough((String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconClicksParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list.add(ParseError.buildFrom("IconClickThrough", new Exception("Unable to parse IconClickThrough value", (Exception) obj)));
                }
            });
        } else if (str.equalsIgnoreCase("IconClickTracking")) {
            registryXmlParser.parseClass("IconClickTracking", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.IconClicksParser$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    IconClicksParser.lambda$parse$1(list2, list, (ParseResult) obj);
                }
            });
        }
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
}
