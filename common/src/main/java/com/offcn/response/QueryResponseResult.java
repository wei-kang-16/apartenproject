package com.offcn.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    Object query;

    public QueryResponseResult(ResultCode resultCode, Object query){
        super(resultCode);
       this.query = query;
    }

}
