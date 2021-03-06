/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.extensions.sql.impl;

import org.apache.beam.sdk.extensions.sql.impl.rel.BeamRelNode;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.sql.SqlNode;

/**
 * An interface that planners should implement to convert sql statement to {@link BeamRelNode} or
 * {@link SqlNode}.
 */
public interface QueryPlanner {
  /** It parses and validate the input query, then convert into a {@link BeamRelNode} tree. */
  BeamRelNode convertToBeamRel(String sqlStatement) throws ParseException, SqlConversionException;

  /** Parse input SQL query, and return a {@link SqlNode} as grammar tree. */
  SqlNode parse(String sqlStatement) throws ParseException;
}
