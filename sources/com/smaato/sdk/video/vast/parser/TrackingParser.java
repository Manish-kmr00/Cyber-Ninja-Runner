package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.CheckedFunction;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Tracking;
import com.smaato.sdk.video.vast.model.VastEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class TrackingParser implements XmlClassParser<Tracking> {
    private static final CheckedFunction eventParsingFunction = new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.TrackingParser$$ExternalSyntheticLambda4
        @Override // com.smaato.sdk.video.fi.CheckedFunction
        public final Object apply(Object obj) {
            return TrackingParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ VastEvent lambda$static$0(String str) {
        return (VastEvent) Objects.requireNonNull(VastEvent.parse(str));
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Tracking> parse(RegistryXmlParser registryXmlParser) {
        Tracking trackingBuild;
        final Tracking.Builder builder = new Tracking.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseTypedAttribute("event", eventParsingFunction, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.TrackingParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setVastEvent((VastEvent) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("offset", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.TrackingParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setOffset((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.TrackingParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setUrl((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.TrackingParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("url", new Exception("Unable to parse URL value", (Exception) obj)));
            }
        });
        try {
            trackingBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("Tracking", e));
            trackingBuild = null;
        }
        return new ParseResult.Builder().setResult(trackingBuild).setErrors(arrayList).build();
    }
}
