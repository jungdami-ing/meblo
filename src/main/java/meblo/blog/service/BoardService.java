package meblo.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import meblo.blog.model.Board;
import meblo.blog.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

   @Autowired
   private final BoardRepository boardRepository;

   public List<Board> findAll(){
      List<Board> boardList = boardRepository.findAll();
      return boardList;
   }

   public void writeBoard(Board board) {
      boardRepository.save(board);
   }

   public Optional<Board> findOne(int idx) {
	   Optional<Board> boardOne = boardRepository.findById(idx);
	   return boardOne;
   }



}