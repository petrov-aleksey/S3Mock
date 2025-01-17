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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;

/**
 * Represents a result of listing all Buckets.
 * <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_ListBuckets.html">API Reference</a>
 */
@JsonRootName("ListAllMyBucketsResult")
public class ListAllMyBucketsResult {

  @JsonProperty("Owner")
  private Owner owner;

  @JsonProperty("Buckets")
  private Buckets buckets;

  public ListAllMyBucketsResult(final Owner owner, final List<Bucket> buckets) {
    this.owner = owner;
    this.buckets = new Buckets();
    this.buckets.setBuckets(buckets);
  }

  public Buckets getBuckets() {
    return buckets;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setBuckets(final Buckets buckets) {
    this.buckets = buckets;
  }

  public void setOwner(final Owner owner) {
    this.owner = owner;
  }
}
