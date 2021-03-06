/*
 * Copyright © 2019, 2020 Peter Doornbosch
 *
 * This file is part of Kwik, a QUIC client Java library
 *
 * Kwik is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * Kwik is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.luminis.quic;

import net.luminis.quic.packet.PacketInfo;
import net.luminis.quic.packet.QuicPacket;

import java.util.List;

public interface CongestionController {

    void registerInFlight(QuicPacket sentPacket);

    void registerAcked(List<? extends PacketInfo> acknowlegdedPackets);

    void registerLost(List<? extends PacketInfo> lostPackets);

    boolean canSend(int bytes);

    long getBytesInFlight();

    long getWindowSize();

    void reset();

    void waitForUpdate() throws InterruptedException;

    void discard(List<? extends PacketInfo> packetStatusStream);
}
