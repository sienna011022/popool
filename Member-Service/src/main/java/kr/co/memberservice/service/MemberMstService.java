package kr.co.memberservice.service;

import kr.co.memberservice.domain.dto.MemberMstDto;

public interface MemberMstService {

    //create service
    void signUp(MemberMstDto.CREATE create);

    //common service
    Boolean checkIdentity(String identity);
    Boolean checkPhone(String phone);

}
