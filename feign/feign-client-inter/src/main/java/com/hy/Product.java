package com.hy;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: $- Product -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/16 11:40
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/16 11:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
@Builder
public class Product {
    private Long productId;
    private String description;
    private Long stock;
}
