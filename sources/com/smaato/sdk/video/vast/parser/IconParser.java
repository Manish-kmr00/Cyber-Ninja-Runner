package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.Icon;
import com.smaato.sdk.video.vast.model.IconClicks;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.StaticResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public class IconParser implements XmlClassParser<Icon> {
    private static final String[] ICON_TAGS = {"StaticResource", "IFrameResource", "HTMLResource", "IconClicks", "IconViewTracking"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Icon> parse(final RegistryXmlParser registryXmlParser) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final Icon.Builder builder = new Icon.Builder();
        builder.setIconViewTrackings(arrayList);
        builder.setStaticResources(arrayList2);
        builder.setIFrameResources(arrayList3);
        builder.setHtmlResources(arrayList4);
        final ArrayList arrayList5 = new ArrayList();
        parseAttributes(registryXmlParser, builder, arrayList5);
        registryXmlParser.parseTags(ICON_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                IconParser.lambda$parse$5(registryXmlParser, arrayList2, arrayList5, arrayList3, arrayList4, arrayList, builder, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList5.add(ParseError.buildFrom("Icon", new Exception("Unable to parse URL value", (Exception) obj)));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList5).build();
    }

    static /* synthetic */ void lambda$parse$5(RegistryXmlParser registryXmlParser, final List list, final List list2, List list3, List list4, List list5, final Icon.Builder builder, String str) {
        if (str.equalsIgnoreCase("StaticResource")) {
            registryXmlParser.parseClass("StaticResource", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda8
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    IconParser.lambda$parse$0(list, list2, (ParseResult) obj);
                }
            });
            return;
        }
        if (str.equalsIgnoreCase("IFrameResource")) {
            Objects.requireNonNull(list3);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list3), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda9
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("IFrameResource", new Exception("Unable to parse IFrameResource value", (Exception) obj)));
                }
            });
            return;
        }
        if (str.equalsIgnoreCase("HTMLResource")) {
            Objects.requireNonNull(list4);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list4), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda10
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("HTMLResource", new Exception("Unable to parse HTMLResource value", (Exception) obj)));
                }
            });
        } else if (str.equalsIgnoreCase("IconViewTracking")) {
            Objects.requireNonNull(list5);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list5), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda11
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("IconViewTracking", new Exception("Unable to parse IconViewTracking value", (Exception) obj)));
                }
            });
        } else if (str.equalsIgnoreCase("IconClicks")) {
            registryXmlParser.parseClass("IconClicks", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda12
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    IconParser.lambda$parse$4(builder, list2, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$0(List list, List list2, ParseResult parseResult) {
        Result result = parseResult.value;
        if (result != 0) {
            list.add((StaticResource) result);
        }
        List<ParseError> list3 = parseResult.errors;
        Objects.requireNonNull(list2);
        com.smaato.sdk.core.util.Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$4(Icon.Builder builder, List list, ParseResult parseResult) {
        builder.setIconClicks((IconClicks) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        Objects.requireNonNull(list);
        com.smaato.sdk.core.util.Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }

    private void parseAttributes(RegistryXmlParser registryXmlParser, final Icon.Builder builder, List list) {
        Objects.requireNonNull(builder);
        Consumer<String> consumer = new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setProgram((String) obj);
            }
        };
        Objects.requireNonNull(list);
        registryXmlParser.parseStringAttribute(Icon.PROGRAM, consumer, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("width", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setWidth((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("height", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setHeight((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute(Icon.X_POSITION, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setXPosition((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute(Icon.Y_POSITION, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setYPosition((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute("duration", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setDuration((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute("offset", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setOffset((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseStringAttribute("apiFramework", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setApiFramework((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list)).parseFloatAttribute("pxratio", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.IconParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setPxRatio((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(list));
    }
}
