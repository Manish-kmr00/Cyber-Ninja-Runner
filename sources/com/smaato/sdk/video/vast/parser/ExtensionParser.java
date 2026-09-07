package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.Extension;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class ExtensionParser implements XmlClassParser<Extension> {
    private static final String[] VAST_EXTENSIONS_TAGS = {"AdVerifications"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Extension> parse(final RegistryXmlParser registryXmlParser) {
        final Extension.Builder builder = new Extension.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("type", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ExtensionParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setType((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseTags(VAST_EXTENSIONS_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ExtensionParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ExtensionParser.lambda$parse$1(registryXmlParser, builder, arrayList, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ExtensionParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Extension", new Exception("Unable to parse tags in Extension")));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$1(RegistryXmlParser registryXmlParser, final Extension.Builder builder, final List list, String str) {
        if ("AdVerifications".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("AdVerifications", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.ExtensionParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    ExtensionParser.lambda$parse$0(builder, list, (ParseResult) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$parse$0(Extension.Builder builder, List list, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            builder.setAdVerifications((List) result);
        }
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
