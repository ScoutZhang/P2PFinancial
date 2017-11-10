package cn.edu.zju.cst.util;

import cn.edu.zju.cst.dto.RegularResultDTO;
import cn.edu.zju.cst.dto.RegularResultDTO2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEAN on 2017/11/10.
 * 处理regularResultDTO为特定的样式
 */
public class RegularResultDTOUtil {
    public static List<RegularResultDTO2> convertToSecondModel(RegularResultDTO regularResultDTO){
        List<RegularResultDTO2> regularResultDTO2List = new ArrayList<>();
        if(regularResultDTO!=null){
            for(int i=0;i<regularResultDTO.getReturnMoneyTime().size();++i){
                RegularResultDTO2 regularResultDTO2 = new RegularResultDTO2();
                regularResultDTO2.setReturnMoneyTime(regularResultDTO.getReturnMoneyTime().get(i));
                regularResultDTO2.setReturnPrincipal(regularResultDTO.getReturnPrincipal().get(i));
                regularResultDTO2.setReturnInterest(regularResultDTO.getReturnInterest().get(i));
                regularResultDTO2.setReturnMoney(regularResultDTO.getReturnMoney().get(i));
                regularResultDTO2List.add(regularResultDTO2);
            }
        }
        return regularResultDTO2List;
    }
}
