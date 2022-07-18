package com.spring.webmvc.springmvc.chap04.controller;

import com.spring.webmvc.springmvc.chap04.domain.Board;
import com.spring.webmvc.springmvc.chap04.repository.Boardrepository;
import com.spring.webmvc.springmvc.chap04.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final Boardrepository repository;
    private final BoardService boardService;

    /**
     * 게시물 목록요청: /board/list: GET
     * 게시물 상세조회요청: /board/content: GET
     * 게시글 쓰기 화면요청: /board/write: GET
     * 게시글 등록요청: /board/write: POST
     * 게시글 삭제요청: /board/delete: GET
     * 게시글 수정화면요청: /board/modify: GET
     * 게시글 수정요청: /board/modify: POST
     */

    // 전제조회
    @RequestMapping("/board/list")
//    @GetMapping("/board/list")
//    @ResponseBody -> 실행시 jsp 안돌아감
    public String boardList(Model model){
        log.info("board list--- ");
        List<Board> boardList = repository.findAll();
        model.addAttribute("board",boardList);
        return "chap04/board-list";
    }

    // 화면 보여주기
    @GetMapping("/board/write")
    public String write() {
        return "chap04/board-write";
    }

    // jsp에 post 넣어서 걸리게 해주기!
    @PostMapping("/board/write")
    public String write(Board board){
        log.info("board write GET 요청!! - param1 : {}", board);
        return  boardService.savewrite(board) ? "redirect:/board/list" : "redirect:/";

    }
    // 글 조회 -> 삭제/수정/목록
    @RequestMapping("/board/content")
    public ModelAndView showcontent(int boardNo){
        log.info("board content - param1: {}", boardService.findOne(boardNo));
        Board result = boardService.findOne(boardNo);

        ModelAndView mv = new ModelAndView("chap04/board-content");
        mv.addObject("no",result);

        return  mv;
    }

    // 삭제
    @GetMapping("/board/delete")
    public String delete(int boardNo){
        log.info("board delete - param1 : {}", boardService.delete(boardNo));
        return boardService.delete(boardNo) ? "redirect:/board/list" : "redirect:/";

    }
    
    // 수정
    @GetMapping("/board/modify")
    public String modify(int boardNo, Model model){
        Board b = boardService.findOne(boardNo);
        // db가서 잡아오기
        model.addAttribute("b", b);
        log.info("board modify GET 요청!! - param1 : {}", boardNo);
        return "chap04/board-modify";
    }

    @PostMapping("/board/modify")
    public String modifycontent(Board board){
        log.info("board modify POST 요청!! - param1 : {}", board);
        // 수정 보낼위치 다시 정하기
        boardService.modify(board);
//        return "redirect:/board/modify";
         return  boardService.modify(board) ? "redirect:/board/content?boardNo=" +  board.getBoardNo() : "redirect:/";
        // 추가할 기능 생각해보기
    }
}
