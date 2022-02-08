package com.evan.myshop.statics.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * bootstrap dataTable 领域模型
 */
@Data
public class DataTableDTO<T> implements Serializable {
    private int draw;
    private long recordsTotal;
    private long recordsFilter;
    private List<T> data;
    private String error;
}
