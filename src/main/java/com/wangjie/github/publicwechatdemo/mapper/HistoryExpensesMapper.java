package com.wangjie.github.publicwechatdemo.mapper;

import com.wangjie.github.publicwechatdemo.domain.HistoryExpenses;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName HistoryExpensesMapper
 * @Description
 * @Author 25127
 * @Date 2019/12/1 21:26
 * @Email jie.wang13@hand-china.com
 **/
@Repository
@Mapper
public interface HistoryExpensesMapper {


    @Insert({
            "<script>",
            "insert into history_expenses(type, content, use_day) values ",
            "<foreach collection='historyExpensesList' item='item' index='index' separator=','>",
            "(#{item.type}, #{item.content}, #{item.useDay})",
            "</foreach>",
            "</script>"
    })
    void insertList(@Param("historyExpensesList") List<HistoryExpenses> historyExpensesList);
}
