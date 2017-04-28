/**
 * Copyright (C) 2017 John McGonegal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.readytalk.metrics;

import javax.annotation.concurrent.NotThreadSafe;
import java.net.InetSocketAddress;

/**
 * A client to a StatsD Statsite server.
 * http://statsite.github.io/statsite/
 */
@NotThreadSafe
public class StatsiteStatsD extends StatsD {

  /**
   * Creates a new client which connects to the given address and socket factory.
   *
   * @param address       the address of the Carbon server
   * @param socketFactory the socket factory
   */
  public StatsiteStatsD(final InetSocketAddress address, final DatagramSocketFactory socketFactory) {
    super(address, socketFactory);
  }

  /**
   *
   * @param  name  the name of the metric
   * @param  value the value of the metric
   * @return formatted data packet content
   */
  @Override
  public String formatPacketContent(String name, String value) {
    // messages must be terminated by newlines in Statsite
    return String.format("%s:%s|g\n", name, value);
  }

}
