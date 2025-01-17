/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebootNet.Packets.Client;

import FacebootNet.Engine.AbstractPacket;
import FacebootNet.Engine.Opcodes;
import FacebootNet.Engine.PacketBuffer;

/**
 * This packet is created from client to server for handshaking purposes.
 * @author Ivy
 */
public class CHelloPacket extends AbstractPacket {
    
    public int ApplicationVersion;
    
    public CHelloPacket(int requestIdx){
        super(Opcodes.Hello, requestIdx);
    }
    
    public static CHelloPacket Deserialize(byte[] data) throws Exception{
        CHelloPacket p = new CHelloPacket(0);
        PacketBuffer b = PacketBuffer.From(data);
        p.ApplicationVersion = b.ReadInt();
        return p;
    }
    
    @Override
    public byte[] Serialize() throws Exception{
        return CraftPacket()
                .WriteInt(ApplicationVersion)
                .Serialize();
    }
    
}
