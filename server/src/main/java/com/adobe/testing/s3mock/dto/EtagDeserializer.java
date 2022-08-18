/*
 *  Copyright 2017-2022 Adobe.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.adobe.testing.s3mock.dto;

import static org.apache.commons.lang3.StringUtils.endsWith;
import static org.apache.commons.lang3.StringUtils.startsWith;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 * ETag values are wrapped in quotation marks when serialized.
 * Example: {@code <ETag>"etag-value"</ETag>}
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ETag">API Reference</a>
 * When deserializing, quotation marks must be removed.
 * Also, if requester sends a weak ETag, we must strip
 */
public class EtagDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext) throws IOException {
    String deserialized = jsonParser.readValueAs(String.class);

    if (startsWith(deserialized, "\"") && endsWith(deserialized, "\"")) {
      //strip first and last character.
      deserialized = deserialized.substring(1);
      deserialized = deserialized.substring(0, deserialized.length() - 1);
    }
    return deserialized;
  }
}
