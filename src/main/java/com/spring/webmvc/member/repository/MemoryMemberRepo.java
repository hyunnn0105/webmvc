package com.spring.webmvc.member.repository;

import com.spring.webmvc.member.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepo implements MemberRepository{
    // 회원정보 저장소
    private Map<Integer, Member> memberMap = new HashMap<>();

    //싱글톤 패턴구현 - 외부소환 제한**
    private MemoryMemberRepo(){}
    // 2. 스스로의 객제를 단 하나 생성한다
    private static MemoryMemberRepo instance = new MemoryMemberRepo();
    // 3. 단 하나의 객체를 리턴하는 메서드를 만든다
    public static MemoryMemberRepo getInstance(){
        return instance;
    }
    
    
    @Override
    public void save(Member member) {
        memberMap.put(member.getUserNum(),member);
        System.out.println(memberMap);
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        for (Integer key : memberMap.keySet()) {
            memberList.add(memberMap.get(key));
        }
        return memberList;
    }
}
