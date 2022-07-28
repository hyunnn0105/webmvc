package com.spring.webmvc.springmvc.chap02.api;

import com.spring.webmvc.springmvc.chap02.mybatis.domain.Score;
import com.spring.webmvc.springmvc.chap02.mybatis.repository.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/sap/v1")
@CrossOrigin
public class ScoreApiController {

    private final ScoreMapper scoreMapper;

    // 전체조회
    @GetMapping("")
    public List<Score> findAll(String sort){
        log.info("scoreApiController GET - {}", sort);

        List<Score> scoreList = scoreMapper.findAll(sort);

        return scoreList;
    }
    
    // 상세조회 http://localhost:8186/sap/v1/12
    @PostMapping("/{scoreNo}")
    public Score findOne(@PathVariable int scoreNo){

        log.info("sac GET - {}", scoreNo);
        Score one = scoreMapper.findOne(scoreNo);
        return one;
    }


    //등록
    @PostMapping("") // http://localhost:8186/sap/v1  + 페이로드 데이터
    public String save(@RequestBody Score score){
        // 계산처리 해주기
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("sac save POST - {}", score);
        boolean save = scoreMapper.save(score);
        return save ? "save-succes" : "save-fail";
    }

    /*
         {
    "name": "name",
    "kor": 80,
    "eng": 50,
    "math": 90
  }
     */

    //수정 ??
    /*
    @PutMapping("/{scoreNo}")
    public String modify(@PathVariable int scoreNo, @RequestBody Score score){
        // 경로 넣어주기
        score.setStuNum(scoreNo);
        log.info("sac modify PUT scoreNo - {}, score - {}", scoreNo, score);
        scoreMapper.
        return "";
    }

     */
    // 삭제 url http://localhost:8186/sap/v1/10
    @DeleteMapping("/{scoreNo}")
    public String delete(@PathVariable int scoreNo){
        log.info("sac DELETE - {}", scoreNo);
        boolean remove = scoreMapper.remove(scoreNo);
        return remove ? "del-success" : "del-fail";
    }
}
