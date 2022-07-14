package com.spring.webmvc.springmvc.chap02.controller;


import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
// model!!!! 위치 확인하기
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreRepository repository;
    // 점수등록및 조회화면 열기 요청

    @RequestMapping("/score/list")
    public String list(@RequestParam(defaultValue = "num") String sort, Model model){
        log.info("/score/list GET req");
        // jsp에게 정보 전달
        List<Score> scoreList = repository.findAll(sort);
//        System.out.println(scoreList.size());
        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            // 빌더로 더해주는게 좋다
            StringBuilder markname = new StringBuilder(String.valueOf(original.charAt(0)));
//            String markname = String.valueOf(original.charAt(0));
            for (int i = 0; i < original.length() - 1; i++) {
                markname.append("*");
            }
            s.setName(markname.toString());
        }
        model.addAttribute("scores", scoreList);
        return  "chap02/score-list";
    }

    @RequestMapping("/score/register")
    public String register(Score score){
        // spring이 기본생성자 사용함 -> setter가 끝난 이후 후작업으로 추가해주기
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! -" + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    /*
    1. 삭제 -> redirect로 돌아오기
    2. 상세정보
     */
    @RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn){
//        printf같은거??
        log.info("/score/delete POST - param1 : {}", sn);
        boolean remove = repository.remove(sn);

        if (remove){
            return "redirect:/score/list";
        } else {
            return "redirect:/";
        }
    }

    /*
    @RequestMapping("/score/detail")
    public String detail(int stuNum, Model model){
        log.info("/score/detail-- ");
        Score score = repository.findOne(stuNum);
        model.addAttribute("s", score);

        if (score.getStuNum() == stuNum){
            return "chap02/score-detail";
        } else {
            return "redirect:/";
        }
    }

     */


    // modelandview return
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum, Model model){
        log.info("/score/detail get -- param1: {}", stuNum);
        Score score = repository.findOne(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);

        return mv;
    }



}
