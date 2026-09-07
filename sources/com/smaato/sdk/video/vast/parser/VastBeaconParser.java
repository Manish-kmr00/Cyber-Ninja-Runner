package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.VastBeacon;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class VastBeaconParser implements XmlClassParser<VastBeacon> {
    private final String elementName;

    public VastBeaconParser(String str) {
        this.elementName = str;
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<VastBeacon> parse(RegistryXmlParser registryXmlParser) {
        VastBeacon vastBeaconBuild;
        final VastBeacon.Builder builder = new VastBeacon.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastBeaconParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastBeaconParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setUri((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VastBeaconParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5720lambda$parse$0$comsmaatosdkvideovastparserVastBeaconParser(arrayList, (Exception) obj);
            }
        });
        try {
            vastBeaconBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom(this.elementName, e));
            vastBeaconBuild = null;
        }
        return new ParseResult.Builder().setResult(vastBeaconBuild).setErrors(arrayList).build();
    }

    /* JADX INFO: renamed from: lambda$parse$0$com-smaato-sdk-video-vast-parser-VastBeaconParser, reason: not valid java name */
    /* synthetic */ void m5720lambda$parse$0$comsmaatosdkvideovastparserVastBeaconParser(List list, Exception exc) {
        list.add(ParseError.buildFrom(this.elementName, new Exception("Unable to parse UniversalAdId value", exc)));
    }
}
