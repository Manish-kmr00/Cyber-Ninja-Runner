package io.bidmachine;

import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.core.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Publisher {
    private final List<String> categories;
    private final String domain;
    private final String id;
    private final String name;

    private Publisher(String str, String str2, String str3, List<String> list) {
        this.id = str;
        this.name = str2;
        this.domain = str3;
        this.categories = list;
    }

    void build(Context.App.Builder builder) {
        Context.App.Publisher.Builder builderNewBuilder = Context.App.Publisher.newBuilder();
        String str = this.id;
        if (str != null) {
            builderNewBuilder.setId(str);
        }
        String str2 = this.name;
        if (str2 != null) {
            builderNewBuilder.setName(str2);
        }
        String str3 = this.domain;
        if (str3 != null) {
            builderNewBuilder.setDomain(str3);
        }
        List<String> list = this.categories;
        if (list != null) {
            builderNewBuilder.addAllCat(list);
        }
        builder.setPub(builderNewBuilder.build());
    }

    public static final class Builder {
        private List<String> categories;
        private String domain;
        private String id;
        private String name;

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setDomain(String str) {
            this.domain = str;
            return this;
        }

        public Builder addCategory(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (this.categories == null) {
                this.categories = new ArrayList();
            }
            this.categories.add(str);
            return this;
        }

        public Builder addCategories(List<String> list) {
            if (Utils.isEmpty(list)) {
                return this;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                addCategory(it.next());
            }
            return this;
        }

        public Publisher build() {
            return new Publisher(this.id, this.name, this.domain, this.categories);
        }
    }
}
