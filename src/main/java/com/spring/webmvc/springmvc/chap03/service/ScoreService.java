package com.spring.webmvc.springmvc.chap03.service;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// 컨트롤러와 레파지토리 중간 로직 처리 컨르롤러->ㅅ비스-> 레파지토리
@Service //스프링 빈 등록
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository repository;

    // 점수 저장요청 중간처리
    public boolean saveService(Score score){
        score.calcTotalAndAvg();
        score.calcGrade();

        return repository.save(score);
    }


    // 점수 목록 요청 중간 처리 메서드
    public List<Score> listService(String sort){
        // jsp에게 정보 전달
        List<Score> scoreList = repository.findAll(sort);
//        System.out.println(scoreList.size());
        // 이름 마킹 처리
        processMarkName(scoreList);
        return scoreList;
    }

    // 점수 삭제 중간처리
    public boolean deleteService(int stuNum) {
        return repository.remove(stuNum);
    }
    // 점수 개별조회 중간처리
    public Score detailService(int stuNum) {
        return repository.findOne(stuNum);
    }

    private void processMarkName(List<Score> scoreList) {
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
    }
}

