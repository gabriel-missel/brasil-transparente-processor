package com.brasil.transparente.processor.util;

import com.brasil.transparente.processor.entity.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class OrdererService {

    public List<Poder> orderPoderListBySpending(List<Poder> poderList) {
        poderList.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return poderList;
    }

    public List<Ministerio> orderMinisterioListBySpending(List<Ministerio> ministerioList) {
        ministerioList.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return ministerioList;
    }

    public List<Orgao> orderOrgaoListBySpending(List<Orgao> orgaoList) {
        orgaoList.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return orgaoList;
    }

    public List<UnidadeGestora> orderUnidadeGestoraListBySpending(List<UnidadeGestora> unidadeGestoraList) {
        unidadeGestoraList.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return unidadeGestoraList;
    }

    public List<ElementoDespesa> orderElementoDespesaListBySpending(List<ElementoDespesa> elementoDespesaList) {
        elementoDespesaList.sort((i1, i2) -> Double.compare(i2.getTotalValueSpent(), i1.getTotalValueSpent()));
        return elementoDespesaList;
    }

}
