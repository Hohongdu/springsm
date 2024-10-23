package edu.sm.app.repository;

import com.github.pagehelper.Page;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.dto.Search;
import edu.sm.app.frame.SMRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemRepository extends SMRepository <String, ItemDto> {
    List<ItemDto> findByName(String name);
    Page<ItemDto> getpage() throws Exception;
    Page<ItemDto> getfindpage(Search search) throws Exception;
}