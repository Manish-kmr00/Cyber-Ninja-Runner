package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.AdParameters;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class AdParametersParser implements XmlClassParser<AdParameters> {
    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<AdParameters> parse(RegistryXmlParser registryXmlParser) {
        AdParameters adParametersBuild;
        final AdParameters.Builder builder = new AdParameters.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseBooleanAttribute(AdParameters.XML_ENCODED, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParametersParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setXmlEncoded((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParametersParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setParameters((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdParametersParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("AdParameters", new Exception("Unable to parse AdParameters body", (Exception) obj)));
            }
        });
        try {
            adParametersBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("AdParameters", e));
            adParametersBuild = null;
        }
        return new ParseResult.Builder().setResult(adParametersBuild).setErrors(arrayList).build();
    }
}
