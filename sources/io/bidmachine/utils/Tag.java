package io.bidmachine.utils;

/* JADX INFO: loaded from: classes7.dex */
public class Tag {
    private final String name;
    private String tag;

    public Tag(String str) {
        this.name = str;
    }

    public String toString() {
        if (this.tag == null) {
            this.tag = this.name + " @" + Integer.toHexString(hashCode());
        }
        return this.tag;
    }
}
