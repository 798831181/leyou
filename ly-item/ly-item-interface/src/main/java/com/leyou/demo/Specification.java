package com.leyou.demo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_specifaction")
public class Specification {
    @Id
    private long categoryId;
    private String specifications;
}
