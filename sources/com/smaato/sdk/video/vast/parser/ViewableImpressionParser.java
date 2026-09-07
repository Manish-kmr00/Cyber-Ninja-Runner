package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public class ViewableImpressionParser implements XmlClassParser<ViewableImpression> {
    private static final String[] VAST_VIEWABLE_IMPRESSION_TAGS = {ViewableImpression.VIEWABLE, ViewableImpression.NOT_VIEWABLE, ViewableImpression.VIEW_UNDETERMINED};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<ViewableImpression> parse(final RegistryXmlParser registryXmlParser) {
        final ViewableImpression.Builder builder = new ViewableImpression.Builder();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        builder.setViewable(arrayList);
        builder.setNotViewable(arrayList2);
        builder.setViewUndetermined(arrayList3);
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList4)).parseTags(VAST_VIEWABLE_IMPRESSION_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ViewableImpressionParser.lambda$parse$3(registryXmlParser, arrayList, arrayList4, arrayList2, arrayList3, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList4.add(ParseError.buildFrom("ViewableImpression", new Exception("Unable to parse tags in ViewableImpression")));
            }
        });
        return new ParseResult.Builder().setResult(builder.build()).setErrors(arrayList4).build();
    }

    static /* synthetic */ void lambda$parse$3(RegistryXmlParser registryXmlParser, List list, final List list2, List list3, List list4, String str) {
        if (ViewableImpression.VIEWABLE.equalsIgnoreCase(str)) {
            Objects.requireNonNull(list);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom(ViewableImpression.VIEWABLE, new Exception("Unable to parse ViewableImpression value", (Exception) obj)));
                }
            });
        } else if (ViewableImpression.NOT_VIEWABLE.equalsIgnoreCase(str)) {
            Objects.requireNonNull(list3);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list3), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom(ViewableImpression.NOT_VIEWABLE, new Exception("Unable to parse NotViewableImpression value", (Exception) obj)));
                }
            });
        } else if (ViewableImpression.VIEW_UNDETERMINED.equalsIgnoreCase(str)) {
            Objects.requireNonNull(list4);
            registryXmlParser.parseString(new CompanionParser$$ExternalSyntheticLambda0(list4), new Consumer() { // from class: com.smaato.sdk.video.vast.parser.ViewableImpressionParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom(ViewableImpression.VIEW_UNDETERMINED, new Exception("Unable to parse ViewUndetermined value", (Exception) obj)));
                }
            });
        }
    }
}
