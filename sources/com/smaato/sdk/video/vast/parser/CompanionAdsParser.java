package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.CheckedFunction;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.CompanionAds;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class CompanionAdsParser implements XmlClassParser<CompanionAds> {
    private static final CheckedFunction requiredParsingFunction = new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda5
        @Override // com.smaato.sdk.video.fi.CheckedFunction
        public final Object apply(Object obj) {
            return CompanionAdsParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ CompanionAds.Required lambda$static$0(String str) {
        return (CompanionAds.Required) Objects.requireNonNull(CompanionAds.Required.parse(str));
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<CompanionAds> parse(final RegistryXmlParser registryXmlParser) {
        CompanionAds companionAdsBuild;
        final CompanionAds.Builder builder = new CompanionAds.Builder();
        final ArrayList arrayList = new ArrayList();
        builder.setCompanions(arrayList);
        final ArrayList arrayList2 = new ArrayList();
        registryXmlParser.parseTypedAttribute("required", requiredParsingFunction, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setRequired((CompanionAds.Required) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList2)).parseTags(new String[]{"Companion"}, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                registryXmlParser.parseClass("Companion", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.video.fi.NonNullConsumer
                    public final void accept(Object obj2) {
                        CompanionAdsParser.lambda$parse$1(list, list, (ParseResult) obj2);
                    }
                });
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList2.add(ParseError.buildFrom("CompanionAds", new Exception("Unable to parse tags in CompanionAds", (Exception) obj)));
            }
        });
        try {
            companionAdsBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList2.add(ParseError.buildFrom("CompanionAds", e));
            companionAdsBuild = null;
        }
        return new ParseResult.Builder().setResult(companionAdsBuild).setErrors(arrayList2).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$1(final List list, List list2, ParseResult parseResult) {
        Companion companion = (Companion) parseResult.value;
        java.util.Objects.requireNonNull(list);
        Objects.onNotNull(companion, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CompanionAdsParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add((Companion) obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        java.util.Objects.requireNonNull(list2);
        Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }
}
