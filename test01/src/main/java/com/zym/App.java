package com.zym;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Core.Types.OperateResultExOne;
import HslCommunication.ModBus.ModbusTcpNet;

/**
 * @author IronMan
 */
public class App {
    /**
     * 创建Modbus TCP客户端对象
     */
    private static ModbusTcpNet modbusClient;

    public static void main(String[] args) {
        modbusClient = new ModbusTcpNet();
        modbusClient.setIpAddress("192.168.21.128");
        modbusClient.setPort(502);
        OperateResult operateResult = modbusClient.ConnectServer();
        if (operateResult.IsSuccess == true) {
//            short[] number = new short[189];
//            modbusClient.Write("400000", number);
            OperateResultExOne<short[]> read = modbusClient.ReadInt16("0", (short) 10);
            OperateResultExOne<short[]> read3 = modbusClient.ReadInt16("x=4;0", (short) 10);
            OperateResultExOne<boolean[]> read2 = modbusClient.ReadBool("0", (short) 10);
            OperateResultExOne<boolean[]> read4 = modbusClient.ReadBool("x=2;8", (short) 10);
            // 共计10个字节的结果内容
            for (short b : read.Content) {
                System.out.println(b);
            }
            for (short b : read3.Content) {
                System.out.println(b);
            }
            for (boolean b : read2.Content) {
                System.out.println(b);
            }
            for (boolean b : read4.Content) {
                System.out.println(b);
            }
//            int alarm = modbusClient.getByteTransform().TransInt16(read.Content, 1);
//            int alarm2 = modbusClient.getByteTransform().TransInt16(read.Content, 1);

        }

    }
}

