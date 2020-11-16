package com.hy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: $- GatewayController -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/16 11:37
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/16 11:37
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("gateway")
public class GatewayController {

    public static final Map<Long, Product> items = new ConcurrentHashMap<>();

    @GetMapping("details")
    public Product get(@RequestParam("pid") Long pid) {
        if (!items.containsKey(pid)) {
            Product prod = Product.builder()
                    .productId(pid)
                    .description("好吃不贵")
                    .stock(100L)
                    .build();
            items.putIfAbsent(pid, prod);
        }
        return items.get(pid);
    }

    @PostMapping("placeOrder")
    public String buy(@RequestParam("pid") Long pid) {
        Product prod = items.get(pid);

        if (prod == null) {
            return "Product not found";
        } else if (prod.getStock() <= 0L) {
            return "Sold out";
        }

        synchronized (prod) {
            if (prod.getStock() <= 0L) {
                return "Sold out";
            }
            prod.setStock(prod.getStock() - 1);
        }

        return "Order Placed";
    }
}
