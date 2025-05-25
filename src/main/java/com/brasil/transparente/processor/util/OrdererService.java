package com.brasil.transparente.processor.util;

import com.brasil.transparente.processor.entity.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class OrdererService {

    public <T extends Gasto> List<T> orderBySpending(List<T> list) {
        list.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return list;
    }

}
