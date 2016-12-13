/*
  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
  the License. You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
  specific language governing permissions and limitations under the License.

  Copyright 2016 the original author or authors.
 */
package uk.co.lucasweb.aws.v4.signer;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author Richard Lucas
 */
public class HttpRequest {

    private final String method;
    private final URI uri;

    public HttpRequest(String method, URI uri) {
        this.method = method;
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        if ("".equals(uri.getPath())) {
            return "/";
        }else {
            String path = uri.getPath().substring(1, uri.getPath().length());
            try {
                return "/" +
                        URLEncoder.encode(path, "UTF-8")
                        .replaceAll("~", "%7E")
                        .replaceAll("'", "%27")
                        .replaceAll("\\(", "%28")
                        .replaceAll("\\)", "%29")
                        .replaceAll("\\*", "%2A");
            } catch (UnsupportedEncodingException e) {
                throw new SigningException("Failed to encode given path");
            }
        }
    }

    public String getQuery() {
        return Optional.ofNullable(uri.getQuery())
                .orElse("");
    }
}
