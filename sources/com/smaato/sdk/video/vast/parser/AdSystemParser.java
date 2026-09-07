package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.AdSystem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public class AdSystemParser implements XmlClassParser<AdSystem> {
    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<AdSystem> parse(RegistryXmlParser registryXmlParser) {
        final AdSystem.Builder builder = new AdSystem.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("version", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdSystemParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setVersion((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdSystemParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setServerName((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdSystemParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("AdSystem", new Exception("Unable to parse AdServer name value", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }
}
