package meblo.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
