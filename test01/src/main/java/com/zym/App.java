package com.zym;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Core.Types.OperateResultExOne;
import HslCommunication.ModBus.ModbusTcpNet;

/**
 * Hello world!
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
            OperateResultExOne<byte[]> read = modbusClient.Read("400000", (short) 10);
            // 共计10个字节的结果内容
            int alarm = modbusClient.getByteTransform().TransInt16(read.Content, 4);


            System.out.println(alarm);
        }

    }
}

