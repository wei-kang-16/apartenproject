package com.offcn.consume.service;

import com.offcn.consume.client.ProducerClient;
import com.offcn.response.CommonCode;
import com.offcn.response.QueryResponseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumeService {

    @Autowired
    private ProducerClient producerClient;

    public QueryResponseResult getPro(String id){
        String byId = producerClient.findById(id);
        return new QueryResponseResult(CommonCode.SUCCESS,byId);
    }

}
