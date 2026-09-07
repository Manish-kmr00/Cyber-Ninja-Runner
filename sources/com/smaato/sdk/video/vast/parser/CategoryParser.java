package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Category;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public class CategoryParser implements XmlClassParser<Category> {
    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Category> parse(RegistryXmlParser registryXmlParser) {
        Category categoryBuild;
        final Category.Builder builder = new Category.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute(Category.AUTHORITY, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CategoryParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setAuthority((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CategoryParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setCategoryCode((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.CategoryParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("Category", new Exception("Unable to parse Category code value", (Exception) obj)));
            }
        });
        try {
            categoryBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("Category", e));
            categoryBuild = null;
        }
        return new ParseResult.Builder().setResult(categoryBuild).setErrors(arrayList).build();
    }
}
