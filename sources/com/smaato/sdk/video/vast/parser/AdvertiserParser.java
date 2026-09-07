package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.Advertiser;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
class AdvertiserParser implements XmlClassParser<Advertiser> {
    public static final String ADVERTISER_NAME = "Advertiser";

    static /* synthetic */ void lambda$parse$0(ParseError parseError) {
    }

    AdvertiserParser() {
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Advertiser> parse(RegistryXmlParser registryXmlParser) {
        final Advertiser.Builder builder = new Advertiser.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdvertiserParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdvertiserParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                AdvertiserParser.lambda$parse$0((ParseError) obj);
            }
        }).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdvertiserParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setName((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.AdvertiserParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Advertiser", new Exception("Unable to parse Advertiser name value", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }
}
