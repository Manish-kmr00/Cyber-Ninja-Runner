package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class UniversalAdIdParser implements XmlClassParser<UniversalAdId> {
    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<UniversalAdId> parse(RegistryXmlParser registryXmlParser) {
        final UniversalAdId.Builder builder = new UniversalAdId.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute(UniversalAdId.ID_REGISTRY, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.UniversalAdIdParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setIdRegistry((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute(UniversalAdId.ID_VALUE, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.UniversalAdIdParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setIdValue((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.UniversalAdIdParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setValue((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.UniversalAdIdParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("UniversalAdId", new Exception("Unable to parse UniversalAdId value", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }
}
