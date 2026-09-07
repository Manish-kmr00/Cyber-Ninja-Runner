package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.AdSystem;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.VastBeacon;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import com.smaato.sdk.video.vast.model.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class WrapperParser implements XmlClassParser<Wrapper> {
    private static final String[] WRAPPER_TAGS = {"Impression", Wrapper.VAST_AD_TAG_URI, "AdSystem", "Error", "ViewableImpression", "AdVerifications", "Creatives", Wrapper.BLOCKED_AD_CATEGORIES};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Wrapper> parse(RegistryXmlParser registryXmlParser) {
        final Wrapper.Builder builder = new Wrapper.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseBooleanAttribute("followAdditionalWrappers", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setFollowAdditionalWrappers((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseBooleanAttribute("allowMultipleAds", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAllowMultipleAds((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseBooleanAttribute("fallbackOnNoAd", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setFallbackOnNoAd((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseTags(WRAPPER_TAGS, getParsingTagsConsumer(registryXmlParser, builder, arrayList), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Wrapper", new Exception("Unable to parse tags in Wrapper", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    private Consumer getParsingTagsConsumer(final RegistryXmlParser registryXmlParser, final Wrapper.Builder builder, final List list) {
        final ArrayList arrayList = new ArrayList();
        builder.setImpressions(arrayList);
        final ArrayList arrayList2 = new ArrayList();
        builder.setErrors(arrayList2);
        return new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                WrapperParser.lambda$getParsingTagsConsumer$9(registryXmlParser, arrayList, list, builder, arrayList2, (String) obj);
            }
        };
    }

    static /* synthetic */ void lambda$getParsingTagsConsumer$9(RegistryXmlParser registryXmlParser, final List list, final List list2, final Wrapper.Builder builder, List list3, String str) {
        if (str.equalsIgnoreCase("Impression")) {
            registryXmlParser.parseClass("Impression", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda10
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    WrapperParser.lambda$getParsingTagsConsumer$1(list, list2, (ParseResult) obj);
                }
            });
            return;
        }
        if (str.equalsIgnoreCase(Wrapper.VAST_AD_TAG_URI)) {
            Objects.requireNonNull(builder);
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda12
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    builder.setVastAdTagUri((String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda13
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom(Wrapper.VAST_AD_TAG_URI, new Exception("Unable to parse VastAdTagUri in Wrapper", (Exception) obj)));
                }
            });
            return;
        }
        if (str.equalsIgnoreCase(Wrapper.BLOCKED_AD_CATEGORIES)) {
            Objects.requireNonNull(builder);
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda14
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    builder.setBlockedAdCategories((String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda15
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom(Wrapper.BLOCKED_AD_CATEGORIES, new Exception("Unable to parse BlockedAdCategories in Wrapper", (Exception) obj)));
                }
            });
            return;
        }
        if (str.equalsIgnoreCase("AdSystem")) {
            registryXmlParser.parseClass("AdSystem", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda16
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    WrapperParser.lambda$getParsingTagsConsumer$4(builder, list2, (ParseResult) obj);
                }
            });
            return;
        }
        if (str.equalsIgnoreCase("Error")) {
            Objects.requireNonNull(list3);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list3), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("Error", new Exception("Unable to parse Error in Wrapper", (Exception) obj)));
                }
            });
        } else if (str.equalsIgnoreCase("ViewableImpression")) {
            registryXmlParser.parseClass("ViewableImpression", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    WrapperParser.lambda$getParsingTagsConsumer$6(builder, list2, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("AdVerifications")) {
            registryXmlParser.parseClass("AdVerifications", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    WrapperParser.lambda$getParsingTagsConsumer$7(builder, list2, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("Creatives")) {
            registryXmlParser.parseClass("Creatives", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda11
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    WrapperParser.lambda$getParsingTagsConsumer$8(builder, list2, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$getParsingTagsConsumer$1(List list, List list2, ParseResult parseResult) {
        VastBeacon vastBeacon = (VastBeacon) parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(vastBeacon, new CompanionParser$$ExternalSyntheticLambda25(list));
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$getParsingTagsConsumer$4(Wrapper.Builder builder, List list, ParseResult parseResult) {
        builder.setAdSystem((AdSystem) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$getParsingTagsConsumer$6(Wrapper.Builder builder, List list, ParseResult parseResult) {
        builder.setViewableImpression((ViewableImpression) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$getParsingTagsConsumer$7(final Wrapper.Builder builder, List list, ParseResult parseResult) {
        List list2 = (List) parseResult.value;
        Objects.requireNonNull(builder);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdVerifications((List) obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$getParsingTagsConsumer$8(final Wrapper.Builder builder, List list, ParseResult parseResult) {
        List list2 = (List) parseResult.value;
        Objects.requireNonNull(builder);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.WrapperParser$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setCreatives((List) obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
