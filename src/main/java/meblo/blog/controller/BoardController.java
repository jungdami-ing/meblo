package meblo.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import meblo.blog.model.Board;
import meblo.blog.service.BoardService;

@Controller
public class BoardController {

   @Autowired
   private BoardService boardService;

   @GetMapping({"", "/", "/index"})
   public String index() {
      return "index";
   }

   @GetMapping("/board")
   public ModelAndView boardList() {
      List<Board> boardList = boardService.findAll();
      ModelAndView nextView = new ModelAndView("board");
      nextView.addObject("boardList", boardList);
      return nextView;
   }

   @PostMapping("/board")
   public ModelAndView writeBoard(Board board) {
      boardService.writeBoard(board);
      ModelAndView mav = new ModelAndView("board");
      List<Board> boardList = boardService.findAll();
      mav.addObject("boardList", boardList);
      return mav;
   }

}