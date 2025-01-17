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

package com.adobe.testing.s3mock.util;

import static com.adobe.testing.s3mock.util.EtagUtil.normalizeEtag;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class EtagUtilTest {

  @Test
  void testNormalize_null() {
    String etag = null;
    String normalizedEtag = normalizeEtag(etag);
    assertThat(normalizedEtag).isNull();
  }

  @Test
  void testNormalize_etagNoQuotes() {
    String etag = "some-etag";
    String normalizedEtag = normalizeEtag(etag);
    assertThat(normalizedEtag).isEqualTo("\"" + etag + "\"");
  }

  @Test
  void testNormalize_etagWithQuotes() {
    String etag = "\"some-etag\"";
    String normalizedEtag = normalizeEtag(etag);
    assertThat(normalizedEtag).isEqualTo(etag);
  }
}
