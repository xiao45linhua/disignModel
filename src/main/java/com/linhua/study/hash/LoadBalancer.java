package com.linhua.study.hash;

/**
 * @author linhua
 * @date 2021/2/2
 * @description 一致性hash算法实现负载均衡
 */
public interface LoadBalancer{

    /**
     * 添加服务节点
     * @param serverNodeName
     */
    void addServerNode(String serverNodeName);

    /**
     * 删除服务节点
     * @param serverNodeName
     */
    void delServerNode(String serverNodeName);

    /**
     * 选择服务节点
     * @param requestUrl
     * @return
     */
    String selectServerNode(String requestUrl);

}
