package com.spring.webmvc.springmvc.chap02.controller;


import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
// model!!!! 위치 확인하기
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreRepository repository;
    // 점수등록및 조회화면 열기 요청

    @RequestMapping("/score/list")
    public String list(Model model){
        log.info("/score/list GET req");
        // jsp에게 정보 전달
        List<Score> scoreList = repository.findAll();
//        System.out.println(scoreList.size());
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
    public String delete(int stuNum){
        boolean remove = repository.remove(stuNum);
        log.info("/score/delete POST");

        if (remove){
            return "redirect:/score/list";
        } else {
            return "redirect:/";
        }
    }

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


}
