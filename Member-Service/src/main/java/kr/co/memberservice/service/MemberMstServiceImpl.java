package kr.co.memberservice.service;

import kr.co.memberservice.domain.dto.MemberMstDto;
import kr.co.memberservice.domain.entity.MemberMstEntity;
import kr.co.memberservice.domain.shared.Phone;
import kr.co.memberservice.domain.shared.enums.Gender;
import kr.co.memberservice.domain.shared.enums.MemberRank;
import kr.co.memberservice.domain.shared.enums.MemberRole;
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
     *
     * @param create
     */
    @Override
    public void signUp(MemberMstDto.CREATE create) {

        if(checkIdentity(create.getIdentity())){
            //To do... 예외 처리
        }
        if(!create.getPassword().equals(create.getCheckPassword())){
            //To do... 예외 처리
        }

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
        //To do...
        return null;
    }

    @Override
    public Boolean checkPhone(String phone) {
        //To do...
        return null;
    }

}
