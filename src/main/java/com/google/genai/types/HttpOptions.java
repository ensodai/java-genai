/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.genai.JsonSerializable;
import java.util.Map;
import java.util.Optional;

/** HTTP options to be used in each of the requests. */
@AutoValue
@JsonDeserialize(builder = HttpOptions.Builder.class)
public abstract class HttpOptions extends JsonSerializable {
  /** The base URL for the AI platform service endpoint. */
  @JsonProperty("baseUrl")
  public abstract Optional<String> baseUrl();

  /** Specifies the version of the API to use. */
  @JsonProperty("apiVersion")
  public abstract Optional<String> apiVersion();

  /** Additional HTTP headers to be sent with the request. */
  @JsonProperty("headers")
  public abstract Optional<Map<String, String>> headers();

  /** Timeout for the request in milliseconds. */
  @JsonProperty("timeout")
  public abstract Optional<Integer> timeout();

  public abstract Optional<String> proxyHost();
  public abstract Optional<Integer> proxyPort();
  public abstract Optional<String> proxyUser();
  public abstract Optional<String> proxyPassword();

  public static Builder builder() {
    return new AutoValue_HttpOptions.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `HttpOptions.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_HttpOptions.Builder();
    }

    @JsonProperty("baseUrl")
    public abstract Builder baseUrl(String baseUrl);
    public abstract Builder baseUrl(Optional<String> baseUrl);

    @JsonProperty("apiVersion")
    public abstract Builder apiVersion(String apiVersion);
    public abstract Builder apiVersion(Optional<String> apiVersion);

    @JsonProperty("headers")
    public abstract Builder headers(Map<String, String> headers);
    public abstract Builder headers(Optional<Map<String,String>> headers);

    @JsonProperty("timeout")
    public abstract Builder timeout(Integer timeout);
    public abstract Builder timeout(Optional<Integer> timeout);

    public abstract Builder proxyHost(String proxyHost);
    public abstract Builder proxyHost(Optional<String> proxyHost);

    public abstract Builder proxyUser(String proxyUser);
    public abstract Builder proxyUser(Optional<String> proxyUser);

    public abstract Builder proxyPassword(String proxyPassword);
    public abstract Builder proxyPassword(Optional<String> proxyPassword);

    public abstract Builder proxyPort(Integer proxyPort);
    public abstract Builder proxyPort(Optional<Integer> proxyPort);

    abstract Optional<String> proxyHost();
    abstract Optional<Integer> proxyPort();

    abstract HttpOptions autoBuild();

    public HttpOptions build() {
      Optional<String> currentProxyHost = proxyHost();
      Optional<Integer> currentProxyPort = proxyPort();

      if (currentProxyHost.isPresent() && !currentProxyPort.isPresent()) {
        throw new IllegalStateException("proxyPort must be set if proxyHost is set.");
      }
      if (!currentProxyHost.isPresent() && currentProxyPort.isPresent()) {
        throw new IllegalStateException("proxyHost must be set if proxyPort is set.");
      }
      if (currentProxyPort.isPresent()) {
        int port = currentProxyPort.get();
        if (port <= 0 || port > 65535) {
          throw new IllegalArgumentException("proxyPort must be between 1 and 65535 if set.");
        }
      }
      return autoBuild();
    }
  }

  /** Deserializes a JSON string to a HttpOptions object. */
  public static HttpOptions fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, HttpOptions.class);
  }
}
