package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.Ad;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.VastTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class VastTreeParser implements XmlClassParser<VastTree> {
    private static final String[] VAST_TREE_TAGS = {"Ad", "Error"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<VastTree> parse(final RegistryXmlParser registryXmlParser) {
        final VastTree.Builder builder = new VastTree.Builder();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        builder.setAds(arrayList2);
        final ArrayList arrayList3 = new ArrayList();
        builder.setErrors(arrayList3);
        registryXmlParser.parseStringAttribute("version", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setVersion((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseTags(VAST_TREE_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VastTreeParser.lambda$parse$3(registryXmlParser, arrayList3, arrayList, arrayList2, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("VAST", new Exception("Unable to parse tags in Vast", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$3(RegistryXmlParser registryXmlParser, final List list, final List list2, final List list3, String str) {
        if (str.equalsIgnoreCase("Error")) {
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    VastTreeParser.lambda$parse$0(list, (String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("Error", new Exception("Unable to parse Error in Vast", (Exception) obj)));
                }
            });
        } else if (str.equalsIgnoreCase("Ad")) {
            registryXmlParser.parseClass("Ad", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VastTreeParser$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    VastTreeParser.lambda$parse$2(list3, list2, (ParseResult) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$parse$0(List list, String str) {
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(str, new CompanionParser$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$2(List list, List list2, ParseResult parseResult) {
        list.add((Ad) parseResult.value);
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }
}
