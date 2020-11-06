package com.hy.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author 寒夜
 */
@NoArgsConstructor
public class MyRule extends AbstractLoadBalancerRule implements IRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        HttpServletRequest  request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String uri= request.getServletPath()+"?"+request.getQueryString();
        return route(uri.hashCode(),getLoadBalancer().getAllServers());
    }
    public Server route(int hashId, List<Server> addressList){
        if (addressList.isEmpty()) {
            return null;
        }
        TreeMap<Long,Server> address= new TreeMap<>();
        addressList.stream().forEach(e ->{
            //虚化若干个服务节点到环上
            for (int i = 0; i < 9; i++) {
                long hash=hash(e.getId()+i);
                address.put(hash,e);

            }
        });
        long hash= hash(String.valueOf(hashId));

        SortedMap<Long,Server> last= address.tailMap(hash);
        //当request URL 的 hash 值大于任意一个服务器的hashKey,取address中的第一个节点
        if(last.isEmpty()){
            return address.firstEntry().getValue();

        }

        return address.get(last.firstKey());
    }

    public long hash(String key){
        MessageDigest md5;
        try {
             md5= MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }
        byte[] keyByte;
        keyByte =key.getBytes(StandardCharsets.UTF_8);
        md5.update(keyByte);
        byte[] digest = md5.digest();
        long hashCode=((long)(digest[2] & 0xFF << 16)) | ((long)(digest[1] & 0xFF << 8)) | ((long)(digest[1] & 0xFF));
        return hashCode & 0xffffffffL;
    }
}
