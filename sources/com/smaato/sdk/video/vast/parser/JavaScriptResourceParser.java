package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.JavaScriptResource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class JavaScriptResourceParser implements XmlClassParser<JavaScriptResource> {
    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<JavaScriptResource> parse(RegistryXmlParser registryXmlParser) {
        JavaScriptResource javaScriptResourceBuild;
        final JavaScriptResource.Builder builder = new JavaScriptResource.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("apiFramework", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.JavaScriptResourceParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setApiFramework((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute(JavaScriptResource.BROWSER_OPTIONAL, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.JavaScriptResourceParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setBrowserOptional((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.JavaScriptResourceParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setUri((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.JavaScriptResourceParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("uri", new Exception("Unable to parse URI value", (Exception) obj)));
            }
        });
        try {
            javaScriptResourceBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("JavaScriptResource", e));
            javaScriptResourceBuild = null;
        }
        return new ParseResult.Builder().setResult(javaScriptResourceBuild).setErrors(arrayList).build();
    }
}
