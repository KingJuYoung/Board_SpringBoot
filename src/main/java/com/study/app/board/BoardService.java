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
