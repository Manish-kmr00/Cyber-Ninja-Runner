package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.AdSystem;
import com.smaato.sdk.video.vast.model.Advertiser;
import com.smaato.sdk.video.vast.model.Category;
import com.smaato.sdk.video.vast.model.InLine;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.VastBeacon;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class InLineParser implements XmlClassParser<InLine> {
    private static final String[] VAST_INLINE_TAGS = {"AdSystem", "AdTitle", InLine.AD_SERVING_ID, "Impression", "Category", "Description", "Advertiser", "Error", "ViewableImpression", "AdVerifications", "Creatives", "Extensions"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<InLine> parse(RegistryXmlParser registryXmlParser) {
        InLine.Builder builder = new InLine.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseTags(VAST_INLINE_TAGS, getParsingTagsConsumer(registryXmlParser, builder, arrayList), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("InLine", new Exception("Unable to parse tags in InLine")));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    private Consumer getParsingTagsConsumer(final RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        builder.setImpressions(arrayList);
        builder.setCategories(arrayList2);
        builder.setAdVerifications(arrayList4);
        builder.setExtensions(arrayList5);
        builder.setErrors(arrayList3);
        return new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5718x44dfff45(registryXmlParser, builder, list, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, (String) obj);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$getParsingTagsConsumer$1$com-smaato-sdk-video-vast-parser-InLineParser, reason: not valid java name */
    /* synthetic */ void m5718x44dfff45(RegistryXmlParser registryXmlParser, InLine.Builder builder, List list, List list2, List list3, List list4, List list5, List list6, String str) {
        if ("AdSystem".equalsIgnoreCase(str)) {
            parseAdSystem(registryXmlParser, builder, list);
            return;
        }
        if ("AdTitle".equalsIgnoreCase(str)) {
            parseAdTitle(registryXmlParser, builder, list);
            return;
        }
        if (InLine.AD_SERVING_ID.equalsIgnoreCase(str)) {
            parseAdServingId(registryXmlParser, builder, list);
            return;
        }
        if ("Impression".equalsIgnoreCase(str)) {
            parseImpression(registryXmlParser, list2, list);
            return;
        }
        if ("Category".equalsIgnoreCase(str)) {
            parseCategory(registryXmlParser, list3, list);
            return;
        }
        if ("Description".equalsIgnoreCase(str)) {
            parseDescription(registryXmlParser, builder, list);
            return;
        }
        if ("Advertiser".equalsIgnoreCase(str)) {
            parseAdvertiser(registryXmlParser, builder, list);
            return;
        }
        if ("Error".equalsIgnoreCase(str)) {
            parseError(registryXmlParser, list4, list);
            return;
        }
        if ("ViewableImpression".equalsIgnoreCase(str)) {
            parseViewableImpression(registryXmlParser, builder, list);
            return;
        }
        if ("Creatives".equalsIgnoreCase(str)) {
            parseCreatives(registryXmlParser, builder, list);
        } else if ("AdVerifications".equalsIgnoreCase(str)) {
            parseAdVerification(registryXmlParser, list5, list);
        } else if ("Extensions".equalsIgnoreCase(str)) {
            parseExtention(registryXmlParser, list6, list);
        }
    }

    private void parseExtention(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("Extensions", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseExtention$2(list, list2, (ParseResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$parseExtention$2(List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            list.addAll((Collection) result);
        }
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private void parseAdVerification(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("AdVerifications", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseAdVerification$3(list, list2, (ParseResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$parseAdVerification$3(List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            list.addAll((Collection) result);
        }
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private void parseCreatives(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        registryXmlParser.parseClass("Creatives", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseCreatives$4(builder, list, (ParseResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$parseCreatives$4(InLine.Builder builder, List list, ParseResult parseResult) {
        builder.setCreatives((List) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private void parseViewableImpression(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        registryXmlParser.parseClass("ViewableImpression", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseViewableImpression$5(builder, list, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseViewableImpression$5(InLine.Builder builder, List list, ParseResult parseResult) {
        builder.setViewableImpression((ViewableImpression) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private void parseError(RegistryXmlParser registryXmlParser, List list, final List list2) {
        Objects.requireNonNull(list);
        registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list2.add(ParseError.buildFrom("Error", new Exception("Unable to parse Error value", (Exception) obj)));
            }
        });
    }

    private void parseAdvertiser(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        registryXmlParser.parseClass("Advertiser", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseAdvertiser$7(builder, list, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseAdvertiser$7(InLine.Builder builder, List list, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            builder.setAdvertiser((Advertiser) result);
        }
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private void parseDescription(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        Objects.requireNonNull(builder);
        registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setDescription((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(ParseError.buildFrom("Description", new Exception("Unable to parse Description value", (Exception) obj)));
            }
        });
    }

    private void parseCategory(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("Category", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseCategory$9(list, list2, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseCategory$9(List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            list.add((Category) result);
        }
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private void parseImpression(RegistryXmlParser registryXmlParser, final List list, final List list2) {
        registryXmlParser.parseClass("Impression", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseImpression$10(list, list2, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseImpression$10(List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            list.add((VastBeacon) result);
        }
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    private void parseAdServingId(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        Objects.requireNonNull(builder);
        registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdServingId((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(ParseError.buildFrom(InLine.AD_SERVING_ID, new Exception("Unable to parse AdServingId value", (Exception) obj)));
            }
        });
    }

    private void parseAdTitle(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        Objects.requireNonNull(builder);
        registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdTitle((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(ParseError.buildFrom("AdTitle", new Exception("Unable to parse AdTitle value", (Exception) obj)));
            }
        });
    }

    private void parseAdSystem(RegistryXmlParser registryXmlParser, final InLine.Builder builder, final List list) {
        registryXmlParser.parseClass("AdSystem", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.InLineParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                InLineParser.lambda$parseAdSystem$13(builder, list, (ParseResult) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parseAdSystem$13(InLine.Builder builder, List list, ParseResult parseResult) {
        builder.setAdSystem((AdSystem) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
