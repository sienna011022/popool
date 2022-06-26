package kr.co.memberservice.service;

import kr.co.memberservice.domain.dto.MemberMstDto;
import kr.co.memberservice.domain.entity.MemberMstEntity;
import kr.co.memberservice.domain.shared.Phone;
import kr.co.memberservice.domain.shared.enums.Gender;
import kr.co.memberservice.domain.shared.enums.MemberRank;
import kr.co.memberservice.domain.shared.enums.MemberRole;
import kr.co.memberservice.error.exception.BadRequestException;
import kr.co.memberservice.error.exception.DuplicatedException;
import kr.co.memberservice.error.model.ErrorCode;
import kr.co.memberservice.infra.security.jwt.JwtTokenProvider;
import kr.co.memberservice.repository.MemberMstRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMstServiceImpl implements MemberMstService{

    private final MemberMstRepository memberMstRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     * @param create 회원가입하기 위한 회원의 정보
     */
    @Override
    public void signUp(MemberMstDto.CREATE create) {

        if(checkIdentity(create.getIdentity())){
            throw new DuplicatedException(ErrorCode.DUPLICATED_ID);
        }
        if(!create.getPassword().equals(create.getCheckPassword())){
            throw new BadRequestException("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
        }

        //To do... 전화번호 중복 확인 ?

        MemberMstEntity memberMstEntity = MemberMstEntity.builder()
                .identity(create.getIdentity())
                .password(passwordEncoder.encode(create.getPassword()))
                .name(create.getName())
                .birth(create.getBirth())
                .phone(new Phone(create.getPhone()))
                .gender(Gender.of(create.getGender()))
                .memberRank(MemberRank.of(create.getMemberRank()))
                .memberRole(MemberRole.of(create.getMemberRole()))
                .build();

        memberMstRepository.save(memberMstEntity);
    }

    @Override
    public Boolean checkIdentity(String identity) {
        return memberMstRepository.existsByIdentity(identity);
    }

}
