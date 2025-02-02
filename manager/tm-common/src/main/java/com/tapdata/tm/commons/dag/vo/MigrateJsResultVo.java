package com.tapdata.tm.commons.dag.vo;

import io.tapdata.entity.schema.TapField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class MigrateJsResultVo {
    private String op;
    private String fieldName;
    private TapField tapField;
}
