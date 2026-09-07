package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.AdParameters;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.VideoClicks;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public class LinearParser implements XmlClassParser<Linear> {
    private static final String[] VAST_LINEAR_TAGS = {"Duration", "AdParameters", "MediaFiles", "VideoClicks", "TrackingEvents", "Icons"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Linear> parse(final RegistryXmlParser registryXmlParser) {
        final Linear.Builder builder = new Linear.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("skipoffset", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setSkipOffset((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseTags(VAST_LINEAR_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                LinearParser.lambda$parse$6(registryXmlParser, builder, arrayList, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Linear", new Exception("Unable to parse tags in Linear")));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList).build();
    }

    static /* synthetic */ void lambda$parse$6(RegistryXmlParser registryXmlParser, final Linear.Builder builder, final List list, String str) {
        if ("Duration".equalsIgnoreCase(str)) {
            Objects.requireNonNull(builder);
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    builder.setDuration((String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list.add(ParseError.buildFrom("Duration", new Exception("Unable to parse Duration value", (Exception) obj)));
                }
            });
            return;
        }
        if ("AdParameters".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("AdParameters", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    LinearParser.lambda$parse$1(builder, list, (ParseResult) obj);
                }
            });
            return;
        }
        if ("MediaFiles".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("MediaFiles", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    LinearParser.lambda$parse$2(builder, list, (ParseResult) obj);
                }
            });
            return;
        }
        if ("VideoClicks".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("VideoClicks", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    LinearParser.lambda$parse$3(builder, list, (ParseResult) obj);
                }
            });
        } else if ("TrackingEvents".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("TrackingEvents", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda6
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    LinearParser.lambda$parse$4(builder, list, (ParseResult) obj);
                }
            });
        } else if ("Icons".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("Icons", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.LinearParser$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    LinearParser.lambda$parse$5(builder, list, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$1(Linear.Builder builder, List list, ParseResult parseResult) {
        builder.setAdParameters((AdParameters) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$parse$2(Linear.Builder builder, List list, ParseResult parseResult) {
        builder.setMediaFiles((List) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$3(Linear.Builder builder, List list, ParseResult parseResult) {
        builder.setVideoClicks((VideoClicks) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$parse$4(Linear.Builder builder, List list, ParseResult parseResult) {
        builder.setTrackingEvents((List) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$parse$5(Linear.Builder builder, List list, ParseResult parseResult) {
        builder.setIcons((List) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
