package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.CompanionAds;
import com.smaato.sdk.video.vast.model.Creative;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CreativeParser implements XmlClassParser<Creative> {
    private static final String[] CREATIVE_TAGS = {"UniversalAdId", "CompanionAds", "Linear"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Creative> parse(final RegistryXmlParser registryXmlParser) {
        final Creative.Builder builder = new Creative.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute("sequence", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setSequence((Integer) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("adId", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("apiFramework", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setApiFramework((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseTags(CREATIVE_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                CreativeParser.lambda$parse$3(registryXmlParser, builder, arrayList, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Creative", new Exception("Unable to parse tags in Creative", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$3(RegistryXmlParser registryXmlParser, final Creative.Builder builder, final List list, String str) {
        if (str.equalsIgnoreCase("UniversalAdId")) {
            registryXmlParser.parseClass("UniversalAdId", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    CreativeParser.lambda$parse$0(builder, list, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("CompanionAds")) {
            registryXmlParser.parseClass("CompanionAds", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda8
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    CreativeParser.lambda$parse$1(builder, list, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("Linear")) {
            registryXmlParser.parseClass("Linear", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CreativeParser$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    CreativeParser.lambda$parse$2(builder, list, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$0(Creative.Builder builder, List list, ParseResult parseResult) {
        builder.setUniversalAdId((UniversalAdId) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$1(Creative.Builder builder, List list, ParseResult parseResult) {
        builder.setCompanionAds((CompanionAds) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$2(Creative.Builder builder, List list, ParseResult parseResult) {
        builder.setLinear((Linear) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
