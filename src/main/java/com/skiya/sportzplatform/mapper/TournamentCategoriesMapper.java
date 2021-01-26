package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.TournamentCategories;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TournamentCategoriesMapper {
    int deleteByPrimaryKey(Integer tournamentCategoryId);

    int insert(TournamentCategories record);

    TournamentCategories selectByPrimaryKey(Integer tournamentCategoryId);

    List<TournamentCategories> selectAll();

    int updateByPrimaryKey(TournamentCategories record);
}