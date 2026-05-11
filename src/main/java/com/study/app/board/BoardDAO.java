package com.study.app.board;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

    @Autowired
    private SqlSession db;

    public List<BoardDTO> getList() {
        return db.selectList("Board.getList");
    }

    public BoardDTO getDetail(Long seq) {
        return db.selectOne("Board.getDetail", seq);
    }

    public int postWrite(BoardDTO dto) {
        return db.insert("Board.postWrite", dto);
    }

    public int detailUpdate(BoardDTO dto) {
        return db.update("Board.detailUpdate", dto);
    }

    public int deleteDetail(Long seq) {
        return db.delete("Board.deleteDetail", seq);
    }
}
