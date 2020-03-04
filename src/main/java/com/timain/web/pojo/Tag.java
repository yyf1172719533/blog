package com.timain.web.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签实体类
 * @author yyf
 * @version 1.0
 * @date 2020/3/3 22:55
 */
@Data
@Entity
@Table(name = "t_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
