package com.linhua.study.hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author linhua
 * @date 2021/2/2
 * @description
 */
public class SortedMapWithoutVirtualNodeTest {

    private static Logger logger = LoggerFactory.getLogger(SortedMapWithoutVirtualNodeTest.class);

    private static SortedMapWithoutVirtualNode sortedMapWithoutVirtualNode = new SortedMapWithoutVirtualNode();

    // Hash 环
    private static SortedMap<Integer, String> treeMapHash;
    // 服务器总数
    private static final int SERVERS_NUM = 100;

    // 待加入 Hash 环的服务器列表
    private static ArrayList<String> servers = new ArrayList<>();

    private static void init() {
        // 构造服务器数据
        for (int i = 0; i < SERVERS_NUM; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            servers.add(stringBuilder.append("192.168.0.").append(String.valueOf(i)).toString());
        }
        // 构建 Hash 环
        treeMapHash = sortedMapWithoutVirtualNode.buildHash(new TreeMap<Integer, String>());
        // 将服务器添加到 Hash 环中
        for (int i = 0; i < SERVERS_NUM; i++) {
            sortedMapWithoutVirtualNode.addServerNode(servers.get(i));
        }
    }

    public static void main(String[] args) {

        init();

        // 请求节点
        String[] nodes = new IpAddressGenerate().getIpAddress(10000);
        // <节点，服务器>
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            // 选择服务器
            String serverIp = sortedMapWithoutVirtualNode.selectServerNode(nodes[i]);
            // 记录服务器信息
            map.put(nodes[i], serverIp);
        }

        logger.info("初始方差: " + new Analysis().analysis(map));
    }
}
