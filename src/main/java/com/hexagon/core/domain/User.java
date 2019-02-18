package com.hexagon.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:06
 * @description 领域对象
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String age;
}
