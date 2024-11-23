/*
 * Copyright ConsenSys Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package net.consensys.linea.zktracer.runtime.callstack;

import static com.google.common.base.Preconditions.checkArgument;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.consensys.linea.zktracer.types.MemorySpan;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.evm.frame.MessageFrame;

@Accessors(fluent = true)
@Getter
public class CallDataInfo {
  private static final CallDataInfo EMPTY = new CallDataInfo(Bytes.EMPTY, 0, 0, 0);

  public static CallDataInfo empty() {
    return EMPTY;
  }

  private final Bytes data;
  private final MemorySpan memorySpan;
  private final long callDataContextNumber;

  public CallDataInfo(
      final Bytes data,
      final long callDataOffset,
      final long callDataSize,
      final long callDataContextNumber) {

    checkArgument(data.size() == callDataSize);
    this.data = data;
    this.memorySpan = new MemorySpan(callDataOffset, callDataSize);
    this.callDataContextNumber = callDataContextNumber;
  }

  public CallDataInfo(
      final MessageFrame frame, final MemorySpan span, final int callDataContextNumber) {
    this.callDataContextNumber = callDataContextNumber;
    this.memorySpan = span;
    this.data =
        (span.isEmpty()) ? Bytes.EMPTY : frame.shadowReadMemory(span.offset(), span.length());
  }
}
