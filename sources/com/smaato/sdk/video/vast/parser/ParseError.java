package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ParseError {
    public final String enclosingName;
    public final Exception exception;
    public final List<ParseError> nestedErrors;

    public ParseError(String str, Exception exc, List<ParseError> list) {
        this.enclosingName = str;
        this.exception = exc;
        this.nestedErrors = list;
    }

    public static ParseError buildFrom(String str, Exception exc) {
        return new Builder().setEnclosingName(str).setException(exc).build();
    }

    public static class Builder {
        private String enclosingName;
        private Exception exception;
        private List nestedErrors;

        public Builder setEnclosingName(String str) {
            this.enclosingName = str;
            return this;
        }

        public Builder setException(Exception exc) {
            this.exception = exc;
            return this;
        }

        public Builder setNestedErrors(List<ParseError> list) {
            this.nestedErrors = list;
            return this;
        }

        public ParseError build() {
            Objects.requireNonNull(this.enclosingName);
            List list = this.nestedErrors;
            return new ParseError(this.enclosingName, this.exception, list == null ? null : Collections.unmodifiableList(list));
        }
    }
}
