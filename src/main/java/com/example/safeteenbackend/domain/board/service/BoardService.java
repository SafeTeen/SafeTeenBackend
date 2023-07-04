package com.example.safeteenbackend.domain.board.service;

import com.example.safeteenbackend.domain.board.controller.dto.request.BoardRequest;
import com.example.safeteenbackend.domain.board.controller.dto.response.BoardResponse;
import com.example.safeteenbackend.domain.board.entity.Board;
import com.example.safeteenbackend.domain.board.exception.BoardNotFound;
import com.example.safeteenbackend.domain.board.repository.BoardRepository;
import com.example.safeteenbackend.domain.user.entity.User;
import com.example.safeteenbackend.domain.user.exception.UserNotFoundException;
import com.example.safeteenbackend.domain.user.repository.UserRepository;
import com.example.safeteenbackend.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardResponse save(BoardRequest request) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Board board = Board.builder()
                .title(request.getTitle())
                .ask(request.getAsk())
                .user(user)
                .date(LocalDateTime.now())
                .build();
        boardRepository.save(board);

        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .ask(board.getAsk())
                .user(board.getUser())
                .dateTime(board.getDate())
                .build();
    }

    @Transactional
    public BoardResponse getBoard(int board_id) {
        Board board = boardRepository.findById(board_id).orElseThrow(BoardNotFound::new);
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .ask(board.getAsk())
                .user(board.getUser())
                .dateTime(board.getDate())
                .build();
    }

    @Transactional
    public void delete(int board_id) {
        boardRepository.deleteById(board_id);
    }

    @Transactional
    public List<BoardResponse> boardList() {
        List<Board> board = boardRepository.findAll();
        return board.stream().map(b -> new BoardResponse(
                b.getId(),
                b.getTitle(),
                b.getAsk(),
                b.getDate(),
                b.getUser()
        )).collect(Collectors.toList());
    }
}
