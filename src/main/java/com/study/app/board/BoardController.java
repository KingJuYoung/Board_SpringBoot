package com.study.app.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getBoards() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/paged")
    public ResponseEntity<java.util.Map<String, Object>> getBoardsPaged(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "searchTerm", required = false) String searchTerm) {
        return ResponseEntity.ok(service.getBoardListWithPaging(page, size, searchTerm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable("id") Long id) {
        BoardDTO board = service.getDetail(id);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO data) {
        System.out.println(data.getContents()+"dfsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        data.setWriter("임시");
    	int result = service.postWrite(data);
        
        if (result > 0) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.badRequest().body("Failure");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDTO data) {
        data.setSeq(id);
        int result = service.detailUpdate(data);
        if (result > 0) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.badRequest().body("Failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Long id) {
        int result = service.deleteDetail(id);
        if (result > 0) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.badRequest().body("Failure");
        }
    }
}
