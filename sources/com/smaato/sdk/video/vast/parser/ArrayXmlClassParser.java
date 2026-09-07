package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class ArrayXmlClassParser<Result> implements XmlClassParser<List<Result>> {
    private final String arrayName;
    private final String elementName;

    public ArrayXmlClassParser(String str, String str2) {
        this.arrayName = str;
        this.elementName = str2;
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<List<Result>> parse(final RegistryXmlParser registryXmlParser) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        registryXmlParser.parseTags(new String[]{this.elementName}, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ArrayXmlClassParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5716x19860dc(registryXmlParser, arrayList, arrayList2, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ArrayXmlClassParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5717x1bb3df7b(arrayList2, (Exception) obj);
            }
        });
        return new ParseResult.Builder().setResult(arrayList).setErrors(arrayList2).build();
    }

    /* JADX INFO: renamed from: lambda$parse$1$com-smaato-sdk-video-vast-parser-ArrayXmlClassParser, reason: not valid java name */
    /* synthetic */ void m5716x19860dc(RegistryXmlParser registryXmlParser, final List list, final List list2, String str) {
        registryXmlParser.parseClass(this.elementName, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.ArrayXmlClassParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                ArrayXmlClassParser.lambda$parse$0(list, list2, (ParseResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$parse$0(final List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(result, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ArrayXmlClassParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                list.add(obj);
            }
        });
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    /* JADX INFO: renamed from: lambda$parse$2$com-smaato-sdk-video-vast-parser-ArrayXmlClassParser, reason: not valid java name */
    /* synthetic */ void m5717x1bb3df7b(List list, Exception exc) {
        list.add(ParseError.buildFrom(this.arrayName, new Exception("Unable to parse " + this.elementName + " elements in " + this.arrayName, exc)));
    }
}
