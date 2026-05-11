package com.study.app.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardDAO dao;

    public List<BoardDTO> getList() {
        return dao.getList();
    }

    public java.util.Map<String, Object> getBoardListWithPaging(int page, int size, String searchTerm) {
        int start = (page - 1) * size + 1;
        int end = page * size;

        java.util.Map<String, Object> params = new java.util.HashMap<>();
        params.put("start", start);
        params.put("end", end);
        params.put("searchTerm", searchTerm);

        java.util.List<BoardDTO> list = dao.getListPage(params);
        int totalCount = dao.countPosts(searchTerm);

        java.util.Map<String, Object> result = new java.util.HashMap<>();
        result.put("list", list);
        result.put("totalCount", totalCount);
        return result;
    }

    public BoardDTO getDetail(Long seq) {
        return dao.getDetail(seq);
    }

    public int postWrite(BoardDTO dto) {
        return dao.postWrite(dto);
    }

    public int detailUpdate(BoardDTO dto) {
        return dao.detailUpdate(dto);
    }

    public int deleteDetail(Long seq) {
        return dao.deleteDetail(seq);
    }
}
