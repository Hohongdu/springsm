package edu.sm.app.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.dto.Search;
import edu.sm.app.frame.SMService;
import edu.sm.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements SMService<String, ItemDto> {

    final ItemRepository itemRepository;

    @Override
    public void add(ItemDto itemDto) throws Exception {
        itemRepository.insert(itemDto);
    }

    @Override
    public void modify(ItemDto itemDto) throws Exception {
        itemRepository.update(itemDto);
    }

    @Override
    public void del(String s) throws Exception {
        itemRepository.delete(s);
    }

    @Override
    public ItemDto get(String s) throws Exception {
        return itemRepository.selectOne(s);
    }

    @Override
    public List<ItemDto> get() throws Exception {
        return itemRepository.select();
    }

    public List<ItemDto> findByName(String name) throws Exception {
        return itemRepository.findByName(name);
    }
    public Page<ItemDto> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 5); // 3: 한화면에 출력되는 개수
        return itemRepository.getpage();
    }
    public Page<ItemDto> getFindPage(int pageNo, Search search) throws Exception {
        PageHelper.startPage(pageNo, 2); // 3: 한화면에 출력되는 개수
        return itemRepository.getfindpage(search);
    }
}