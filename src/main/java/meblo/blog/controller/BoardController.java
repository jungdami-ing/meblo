package meblo.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
      ModelAndView mav = new ModelAndView("board");
      mav.addObject("boardList", boardList);
      return mav;
   }

   @PostMapping("/board")
   public ModelAndView writeBoard(Board board) {
      boardService.writeBoard(board);
      ModelAndView mav = new ModelAndView("board");
      List<Board> boardList = boardService.findAll();
      mav.addObject("boardList", boardList);
      return mav;
   }

   @GetMapping("/boardDetail{idx}")
   public ModelAndView boardDetail(@PathVariable int idx) {
	   Optional<Board> boardOne = boardService.findOne(idx);
	   ModelAndView mav = new ModelAndView("boardDetail");
	   mav.addObject("boardOne", boardOne.get());
	   return mav;
   }

   @GetMapping("/deleteBoard{idx}")
   public ModelAndView deleteBoard(@PathVariable int idx) {
	   boardService.deleteOne(idx);
	   List<Board> boardList = boardService.findAll();
	   ModelAndView mav = new ModelAndView("board");
	   mav.addObject("boardList", boardList);
	   return mav;
   }

}