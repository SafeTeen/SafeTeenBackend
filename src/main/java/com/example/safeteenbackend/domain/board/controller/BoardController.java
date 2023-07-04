package com.example.safeteenbackend.domain.board.controller;

import com.example.safeteenbackend.domain.board.controller.dto.request.BoardRequest;
import com.example.safeteenbackend.domain.board.controller.dto.response.BoardResponse;
import com.example.safeteenbackend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/QnA")
    public BoardResponse save(@RequestBody BoardRequest request) {
        return boardService.save(request);
    }

    @GetMapping("/QnA/{board_id}")
    public BoardResponse getBoard(@PathVariable int board_id) {
        return boardService.getBoard(board_id);
    }

    @GetMapping("/QnA/list")
    public List<BoardResponse> boardList(){
        return boardService.boardList();
    }

    @DeleteMapping("/QnA/{board_id}")
    public void delete(@PathVariable int board_id) {
        boardService.delete(board_id);
    }
}
