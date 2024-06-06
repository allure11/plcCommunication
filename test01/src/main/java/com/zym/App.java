package com.zym;

import HslCommunication.Core.Address.ModbusAddress;
import HslCommunication.Core.Types.OperateResult;
import HslCommunication.ModBus.ModbusTcpNet;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * Hello world!
 *
 */
public class App 
{
    // 创建Modbus TCP客户端对象
    private static ModbusTcpNet modbusClient;
    public static void main( String[] args )
    {
        modbusClient = new ModbusTcpNet();
        modbusClient.setIpAddress("192.168.0.1");
        modbusClient.setPort(502);
        OperateResult operateResult = modbusClient.ConnectServer();
//        modbusClient.Read()

        System.out.println(operateResult.Message);

    }
}

