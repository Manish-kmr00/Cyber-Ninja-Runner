package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.Ad;
import com.smaato.sdk.video.vast.model.InLine;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class AdParser implements XmlClassParser<Ad> {
    private static final String[] VAST_AD_TAGS = {"InLine", "Wrapper"};

    static /* synthetic */ void lambda$parse$0(ParseError parseError) {
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Ad> parse(final RegistryXmlParser registryXmlParser) {
        final Ad.Builder builder = new Ad.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute("sequence", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setSequence((Integer) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseBooleanAttribute(Ad.CONDITIONAL_AD, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setConditionalAd((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute(Ad.AD_TYPE, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAdType((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                AdParser.lambda$parse$0((ParseError) obj);
            }
        }).parseTags(VAST_AD_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                AdParser.lambda$parse$3(registryXmlParser, builder, arrayList, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Ad", new Exception("Unable to parse tags in Ad", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$3(RegistryXmlParser registryXmlParser, final Ad.Builder builder, final List list, String str) {
        if (str.equalsIgnoreCase("InLine")) {
            registryXmlParser.parseClass("InLine", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    AdParser.lambda$parse$1(builder, list, (ParseResult) obj);
                }
            });
        } else if (str.equalsIgnoreCase("Wrapper")) {
            registryXmlParser.parseClass("Wrapper", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.AdParser$$ExternalSyntheticLambda8
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    AdParser.lambda$parse$2(builder, list, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$1(Ad.Builder builder, List list, ParseResult parseResult) {
        builder.setInLine((InLine) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$2(Ad.Builder builder, List list, ParseResult parseResult) {
        builder.setWrapper((Wrapper) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
