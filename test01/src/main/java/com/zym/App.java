package com.zym;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author IronMan
 */
public class App {

    public static void main(String[] args) {
//        testModbusClient();
        testMqttClient();
    }

    public static void testMqttService() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setMqttVersion(3);
        mqttConnectOptions.setCleanSession(true);
        MqttClient mqttClient = new MqttClient(mqttConnectOptions);

        String a = "{emqx_plugin_kafka, [ \\\n" +
                "                   {kafka_address_list, [{\\\"$KAFKA_ADDRESS\\\", $KAFKA_PORT }]}, \\\n" +
                "                   {kafka_config, [ \\\n" +
                "                       {reconnect_cool_down_seconds, 10}, \\\n" +
                "                       {query_api_versions, true} \\\n" +
                "                   ]}, \\\n" +
                "                   {topic, <<\\\"$TOPIC_NAME\\\">>}, \\\n" +
                "                   {publish_base64, false} \\\n" +
                "               ]}. "

    }


    public static void testMqttClient() {
        try {
            MqttClient mqttClient = new MqttClient("tcp://192.168.21.128:1883", "102930", new MemoryPersistence());
            mqttClient.connect();
            MqttMessage message = new MqttMessage("hhhhhh".getBytes());
            mqttClient.publish("111", message);

            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("断开连接");
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println(new String(mqttMessage.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("任务完成");
                }
            });
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void testModbusClient() {
//        /**
//         * 创建Modbus TCP客户端对象
//         */
//        ModbusTcpNet modbusClient;
//        modbusClient = new ModbusTcpNet();
//        modbusClient.setIpAddress("192.168.21.128");
//        modbusClient.setPort(502);
//        OperateResult operateResult = modbusClient.ConnectServer();
//        if (operateResult.IsSuccess == true) {
////            short[] number = new short[189];
////            modbusClient.Write("400000", number);
//            OperateResultExOne<short[]> read = modbusClient.ReadInt16("0", (short) 10);
//            OperateResultExOne<short[]> read3 = modbusClient.ReadInt16("x=4;0", (short) 10);
//            OperateResultExOne<boolean[]> read2 = modbusClient.ReadBool("0", (short) 10);
//            OperateResultExOne<boolean[]> read4 = modbusClient.ReadBool("x=2;8", (short) 10);
//            // 共计10个字节的结果内容
//            for (short b : read.Content) {
//                System.out.println(b);
//            }
//            for (short b : read3.Content) {
//                System.out.println(b);
//            }
//            for (boolean b : read2.Content) {
//                System.out.println(b);
//            }
//            for (boolean b : read4.Content) {
//                System.out.println(b);
//            }
////            int alarm = modbusClient.getByteTransform().TransInt16(read.Content, 1);
////            int alarm2 = modbusClient.getByteTransform().TransInt16(read.Content, 1);
//        }
//
//    }
}

