package net.pubnative.lite.sdk.models;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ContentInfo {
    private final List<String> clickTrackers;
    private final int height;
    private final String iconUrl;
    private final String linkUrl;
    private final PositionX positionX;
    private final PositionY positionY;
    private final String text;
    private final List<String> viewTrackers;
    private final int width;

    public ContentInfo(String str, String str2, String str3, List<String> list) {
        this(str, str2, str3, -1, -1, PositionX.LEFT, PositionY.TOP, list, null);
    }

    public ContentInfo(String str, String str2, String str3, PositionX positionX, PositionY positionY, List<String> list) {
        this(str, str2, str3, -1, -1, positionX, positionY, list, null);
    }

    public ContentInfo(String str, String str2, String str3, int i, int i2, List<String> list) {
        this(str, str2, str3, i, i2, PositionX.LEFT, PositionY.TOP, list, null);
    }

    public ContentInfo(String str, String str2, String str3, int i, int i2, PositionX positionX, PositionY positionY, List<String> list, List<String> list2) {
        this.iconUrl = str;
        this.linkUrl = str2;
        this.text = str3;
        this.width = i;
        this.height = i2;
        this.positionX = positionX;
        this.positionY = positionY;
        this.viewTrackers = list;
        this.clickTrackers = list2;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getText() {
        return this.text;
    }

    public List<String> getViewTrackers() {
        return this.viewTrackers;
    }

    public List<String> getClickTrackers() {
        return this.clickTrackers;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public PositionX getPositionX() {
        return this.positionX;
    }

    public PositionY getPositionY() {
        return this.positionY;
    }
}
