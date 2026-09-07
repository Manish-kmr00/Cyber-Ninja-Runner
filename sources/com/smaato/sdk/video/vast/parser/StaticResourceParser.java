package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.CheckedFunction;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.StaticResource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class StaticResourceParser implements XmlClassParser<StaticResource> {
    private static final CheckedFunction creativeTypeParsingFunction = new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.StaticResourceParser$$ExternalSyntheticLambda3
        @Override // com.smaato.sdk.video.fi.CheckedFunction
        public final Object apply(Object obj) {
            return StaticResourceParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ StaticResource.CreativeType lambda$static$0(String str) {
        return (StaticResource.CreativeType) Objects.requireNonNull(StaticResource.CreativeType.parse(str));
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<StaticResource> parse(RegistryXmlParser registryXmlParser) {
        StaticResource staticResourceBuild;
        final StaticResource.Builder builder = new StaticResource.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseTypedAttribute("creativeType", creativeTypeParsingFunction, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.StaticResourceParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setCreativeType((StaticResource.CreativeType) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.StaticResourceParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setUri((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.StaticResourceParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("StaticResource", new Exception("Unable to parse StaticResource uri", (Exception) obj)));
            }
        });
        try {
            staticResourceBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("StaticResource", e));
            staticResourceBuild = null;
        }
        return new ParseResult.Builder().setResult(staticResourceBuild).setErrors(arrayList).build();
    }
}
