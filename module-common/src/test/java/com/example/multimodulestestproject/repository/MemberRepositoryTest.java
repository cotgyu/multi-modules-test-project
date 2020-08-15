package com.example.multimodulestestproject.repository;

import com.example.multimodulestestproject.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add () {
        memberRepository.save(new Member("v123v123s", "v123v123s@gmail.com"));
        Member saved = memberRepository.findById(1L).orElse(null);
        assertThat(saved.getName(), is("v123v123s"));
    }
}
