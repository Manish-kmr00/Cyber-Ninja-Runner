package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.CheckedFunction;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Delivery;
import com.smaato.sdk.video.vast.model.MediaFile;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
public class MediaFileParser implements XmlClassParser<MediaFile> {
    private static final CheckedFunction deliveryParsingFunction = new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda0
        @Override // com.smaato.sdk.video.fi.CheckedFunction
        public final Object apply(Object obj) {
            return MediaFileParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ void lambda$parse$1(ParseError parseError) {
    }

    static /* synthetic */ void lambda$parse$2(ParseError parseError) {
    }

    static /* synthetic */ void lambda$parse$3(ParseError parseError) {
    }

    static /* synthetic */ Delivery lambda$static$0(String str) {
        return (Delivery) Objects.requireNonNull(Delivery.parse(str));
    }

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<MediaFile> parse(RegistryXmlParser registryXmlParser) {
        MediaFile mediaFileBuild;
        final MediaFile.Builder builder = new MediaFile.Builder();
        final ArrayList arrayList = new ArrayList();
        registryXmlParser.parseStringAttribute("id", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setId((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("type", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setType((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseFloatAttribute("width", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setWidth((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseFloatAttribute("height", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setHeight((Float) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("codec", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setCodec((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute("bitrate", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setBitrate((Integer) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute("minBitrate", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setMinBitrate((Integer) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute("maxBitrate", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setMaxBitrate((Integer) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseBooleanAttribute("scalable", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setScalable((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseBooleanAttribute("maintainAspectRatio", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setMaintainAspectRatio((Boolean) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseStringAttribute("apiFramework", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setApiFramework((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList)).parseIntegerAttribute(MediaFile.FILE_SIZE, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setFileSize((Integer) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                MediaFileParser.lambda$parse$1((ParseError) obj);
            }
        }).parseStringAttribute(MediaFile.MEDIA_TYPE, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setMediaType((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                MediaFileParser.lambda$parse$2((ParseError) obj);
            }
        }).parseTypedAttribute("delivery", deliveryParsingFunction, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setDelivery((Delivery) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                MediaFileParser.lambda$parse$3((ParseError) obj);
            }
        }).parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setUrl((String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.MediaFileParser$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList.add(ParseError.buildFrom("url", new Exception("Unable to parse URL value", (Exception) obj)));
            }
        });
        try {
            mediaFileBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList.add(ParseError.buildFrom("MediaFile", e));
            mediaFileBuild = null;
        }
        return new ParseResult.Builder().setResult(mediaFileBuild).setErrors(arrayList).build();
    }
}
