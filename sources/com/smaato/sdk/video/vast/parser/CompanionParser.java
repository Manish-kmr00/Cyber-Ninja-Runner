package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.AdParameters;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.StaticResource;
import com.smaato.sdk.video.vast.model.VastBeacon;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CompanionParser implements XmlClassParser<Companion> {
    private static final String[] COMPANION_TAGS = {"StaticResource", "IFrameResource", "HTMLResource", "AltText", "CompanionClickThrough", "CompanionClickTracking", "TrackingEvents", "AdParameters"};

    static /* synthetic */ void lambda$parseAttributes$10(ParseError parseError) {
    }

    private static Consumer getParsingTagsConsumer(final RegistryXmlParser registryXmlParser, final Companion.Builder builder, final List list) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        builder.setCompanionClickTrackings(arrayList);
        builder.setStaticResources(arrayList2);
        builder.setIFrameResources(arrayList3);
        builder.setHtmlResources(arrayList4);
        return new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                CompanionParser.lambda$getParsingTagsConsumer$0(registryXmlParser, arrayList2, list, arrayList3, arrayList4, builder, arrayList, (String) obj);
            }
        };
    }

    static /* synthetic */ void lambda$getParsingTagsConsumer$0(RegistryXmlParser registryXmlParser, List list, List list2, List list3, List list4, Companion.Builder builder, List list5, String str) {
        if ("StaticResource".equalsIgnoreCase(str)) {
            parseStaticResource(registryXmlParser, list, list2);
            return;
        }
        if ("IFrameResource".equalsIgnoreCase(str)) {
            parseIFrameResource(registryXmlParser, list3, list2);
            return;
        }
        if ("HTMLResource".equalsIgnoreCase(str)) {
            parseHtmlResource(registryXmlParser, list4, list2);
            return;
        }
        if ("AltText".equalsIgnoreCase(str)) {
            parseAltText(registryXmlParser, builder, list2);
            return;
        }
        if ("AdParameters".equalsIgnoreCase(str)) {
            parseAdParameters(registryXmlParser, builder, list2);
            return;
        }
        if ("CompanionClickThrough".equalsIgnoreCase(str)) {
            parseCompanionClickThrough(registryXmlParser, builder, list2);
        } else if ("CompanionClickTracking".equalsIgnoreCase(str)) {
            parseCompanionClickTracking(registryXmlParser, list5, list2);
        } else if ("TrackingEvents".equalsIgnoreCase(str)) {
            parseTrackingEvents(registryXmlParser, builder, list2);
        }
    }

    private static void parseStaticResource(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("StaticResource", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                CompanionParser.lambda$parseStaticResource$1(list, list2, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseStaticResource$1(final List list, List list2, ParseResult parseResult) {
        StaticResource staticResource = (StaticResource) parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(staticResource, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add((StaticResource) obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private static void parseTrackingEvents(RegistryXmlParser registryXmlParser, final Companion.Builder builder, final List list) {
        registryXmlParser.parseClass("TrackingEvents", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                CompanionParser.lambda$parseTrackingEvents$2(builder, list, (ParseResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$parseTrackingEvents$2(final Companion.Builder builder, List list, ParseResult parseResult) {
        List list2 = (List) parseResult.value;
        Objects.requireNonNull(builder);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda22
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setTrackingEvents((List) obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private static void parseCompanionClickTracking(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("CompanionClickTracking", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                CompanionParser.lambda$parseCompanionClickTracking$3(list, list2, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseCompanionClickTracking$3(List list, List list2, ParseResult parseResult) {
        VastBeacon vastBeacon = (VastBeacon) parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(vastBeacon, new CompanionParser$$ExternalSyntheticLambda25(list));
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private static void parseCompanionClickThrough(RegistryXmlParser registryXmlParser, final Companion.Builder builder, final List list) {
        Objects.requireNonNull(builder);
        registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setCompanionClickThrough((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(ParseError.buildFrom("CompanionClickThrough", new Exception("Unable to parse CompanionClickThrough", (Exception) obj)));
            }
        });
    }

    private static void parseAdParameters(RegistryXmlParser registryXmlParser, final Companion.Builder builder, final List list) {
        registryXmlParser.parseClass("AdParameters", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda24
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                CompanionParser.lambda$parseAdParameters$5(builder, list, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseAdParameters$5(Companion.Builder builder, List list, ParseResult parseResult) {
        builder.setAdParameters((AdParameters) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private static void parseAltText(RegistryXmlParser registryXmlParser, final Companion.Builder builder, final List list) {
        Objects.requireNonNull(builder);
        registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAltText((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(ParseError.buildFrom("AltText", new Exception("Unable to parse AltText", (Exception) obj)));
            }
        });
    }

    private static void parseHtmlResource(RegistryXmlParser registryXmlParser, List list, final List list2) {
        Objects.requireNonNull(list);
        registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list2.add(ParseError.buildFrom("HTMLResource", new Exception("Unable to parse HtmlResource", (Exception) obj)));
            }
        });
    }

    private static void parseIFrameResource(RegistryXmlParser registryXmlParser, List list, final List list2) {
        Objects.requireNonNull(list);
        registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list2.add(ParseError.buildFrom("IFrameResource", new Exception("Unable to parse IFrameResource", (Exception) obj)));
            }
        });
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Companion> parse(RegistryXmlParser registryXmlParser) {
        Companion.Builder builder = new Companion.Builder();
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        builder.setTrackingEvents(arrayList2);
        builder.setCompanionClickTrackings(arrayList3);
        parseAttributes(registryXmlParser, builder, arrayList);
        registryXmlParser.parseTags(COMPANION_TAGS, getParsingTagsConsumer(registryXmlParser, builder, arrayList), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Companion", new Exception("Unable to parse tags in Companion", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    private void parseAttributes(RegistryXmlParser registryXmlParser, final Companion.Builder builder, List list) {
        Objects.requireNonNull(builder);
        Consumer<String> consumer = new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        };
        Objects.requireNonNull(list);
        registryXmlParser.parseStringAttribute("id", consumer, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("assetWidth", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAssetWidth((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("assetHeight", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAssetHeight((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("expandedWidth", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setExpandedWidth((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("expandedHeight", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setExpandedHeight((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute("apiFramework", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setApiFramework((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute("adSlotID", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdSlotID((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("pxratio", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setPxRatio((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute(Companion.RENDERING_MODE, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setRenderingMode((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionParser$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                CompanionParser.lambda$parseAttributes$10((ParseError) obj);
            }
        });
    }
}
